/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.depreciated.jvm.bytecode;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.sun.org.apache.bcel.internal.*;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;
import com.sun.org.apache.bcel.internal.classfile.Constant;
import com.sun.org.apache.bcel.internal.classfile.ConstantClass;
import com.sun.org.apache.bcel.internal.classfile.ConstantDouble;
import com.sun.org.apache.bcel.internal.classfile.ConstantFieldref;
import com.sun.org.apache.bcel.internal.classfile.ConstantFloat;
import com.sun.org.apache.bcel.internal.classfile.ConstantInteger;
import com.sun.org.apache.bcel.internal.classfile.ConstantInterfaceMethodref;
import com.sun.org.apache.bcel.internal.classfile.ConstantLong;
import com.sun.org.apache.bcel.internal.classfile.ConstantMethodref;
import com.sun.org.apache.bcel.internal.classfile.ConstantNameAndType;
import com.sun.org.apache.bcel.internal.classfile.ConstantPool;
import com.sun.org.apache.bcel.internal.classfile.ConstantString;
import com.sun.org.apache.bcel.internal.classfile.ConstantUtf8;
import com.sun.org.apache.bcel.internal.classfile.Field;
import com.sun.org.apache.bcel.internal.classfile.Method;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;

/**
 *
 * @author vpc
 */
public class KClassParser {
    private static final Attribute[] EMPTY_ARRAY_ATTRIBUTE = new Attribute[0];

    private DataInputStream file;
    private String file_name;
    private String zip_file;
    private int class_name_index, superclass_name_index;
    private int major, minor; // Compiler version
    private int access_flags; // Access rights of parsed class
    private int[] interfaces; // Names of implemented interfaces
    private ConstantPool constant_pool; // collection of constants
    private Field[] fields; // class fields, i.e., its variables
    private Method[] methods; // methods defined in the class
    private Attribute[] attributes; // attributes defined in the class
    private static final int BUFSIZE = 8192;
    private KClassDef def = new KClassDef();

    /**
     * Parse class from the given stream.
     *
     * @param file Input stream
     * @param file_name File name
     */
    public KClassParser(InputStream file, String file_name) {
        this.file_name = file_name;
        if (file instanceof DataInputStream) {
            this.file = (DataInputStream) file;
        } else {
            this.file = new DataInputStream(new BufferedInputStream(file, BUFSIZE));
        }
    }

    /**
     * Parse the given Java class file and return an object that represents
     * the contained data, i.e., constants, methods, fields and commands.
     * A <em>ClassFormatException</em> is raised, if the file is not a valid
     * .class file. (This does not include verification of the byte code as it
     * is performed by the java interpreter).
     *
     * @return Class object representing the parsed class file
     * @throws  IOException
     * @throws  ClassFormatException
     */
    public KClassDef parse() throws IOException, ClassFormatException {
        try {
            /****************** Read headers ********************************/
            // Check magic tag of class file
            readID();
            // Get compiler version
            readVersion();
            /****************** Read constant pool and related **************/
            // Read constant pool entries
            readConstantPool();
            // Get class information
            readClassInfo();
            // Get interface information, i.e., implemented interfaces
            readInterfaces();
            /****************** Read class fields and methods ***************/
            // Read class fields, i.e., the variables of the class
            readFields();
            // Read class methods, i.e., the functions in the class
            readMethods();
            // Read class attributes
            readAttributes();
            // Check for unknown variables
            //Unknown[] u = Unknown.getUnknownAttributes();
            //for(int i=0; i < u.length; i++)
            //  System.err.println("WARNING: " + u[i]);
            // Everything should have been read now
            //      if(file.available() > 0) {
            //        int bytes = file.available();
            //        byte[] buf = new byte[bytes];
            //        file.read(buf);
            //        if(!(is_zip && (buf.length == 1))) {
            //  	System.err.println("WARNING: Trailing garbage at end of " + file_name);
            //  	System.err.println(bytes + " extra bytes: " + Utility.toHexString(buf));
            //        }
            //      }
        } finally {
            // Read everything of interest, so close the file
        }
        return def;
    }

    /**
     * Read information about the attributes of the class.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readAttributes() throws IOException, ClassFormatException {
        int attributes_count;
        attributes_count = file.readUnsignedShort();
        attributes = EMPTY_ARRAY_ATTRIBUTE;
        //attributes = new Attribute[attributes_count];
        //for (int i = 0; i < attributes_count; i++) {
        //    attributes[i] = Attribute.readAttribute(file, constant_pool);
        //}
    }

    /**
     * Read information about the class and its super class.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readClassInfo() throws IOException, ClassFormatException {
        access_flags = file.readUnsignedShort();
        /* Interfaces are implicitely abstract, the flag should be set
         * according to the JVM specification.
         */
        if ((access_flags & Constants.ACC_INTERFACE) != 0) {
            access_flags |= Constants.ACC_ABSTRACT;
        }
        if (((access_flags & Constants.ACC_ABSTRACT) != 0)
                && ((access_flags & Constants.ACC_FINAL) != 0)) {
            throw new ClassFormatException("Class can't be both final and abstract");
        }
        class_name_index = file.readUnsignedShort();
        superclass_name_index = file.readUnsignedShort();
        def.setModifiers(access_flags);
        def.setName(constant_pool.getConstant(class_name_index).toString());
        def.setSuperClassName(constant_pool.getConstant(superclass_name_index).toString());
    }

    /**
     * Read constant pool entries.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readConstantPool() throws IOException, ClassFormatException {
        int constant_pool_count = file.readUnsignedShort();
        Constant[] cts = new Constant[constant_pool_count];

        /* constant_pool[0] is unused by the compiler and may be used freely
         * by the implementation.
         */
        for (int i = 1; i < constant_pool_count; i++) {
            cts[i] = readConstant(file);

            /* Quote from the JVM specification:
             * "All eight byte constants take up two spots in the constant pool.
             * If this is the n'th byte in the constant pool, then the next item
             * will be numbered n+2"
             *
             * Thus we have to increment the index counter.
             */
            int tag = cts[i].getTag();
            if ((tag == Constants.CONSTANT_Double) || (tag == Constants.CONSTANT_Long)) {
                i++;
            }
        }


        this.constant_pool = new ConstantPool(cts);
    }

    /**
     * Read information about the fields of the class, i.e., its variables.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readFields() throws IOException, ClassFormatException {
        int fields_count;
        fields_count = file.readUnsignedShort();
        fields = new Field[fields_count];
        KFieldDef[] kfields = new KFieldDef[fields_count];
        for (int i = 0; i < fields_count; i++) {
            Field f = new Field(
                    file.readUnsignedShort(), file.readUnsignedShort(),
                    file.readUnsignedShort(), null, constant_pool);
            fields[i] = f;
            kfields[i] = new KFieldDef(def.getName(), f.getModifiers(), f.getSignature(), f.getName());
        }
        def.setFields(kfields);
    }

    /******************** Private utility methods **********************/
    /**
     * Check whether the header of the file is ok.
     * Of course, this has to be the first action on successive file reads.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readID() throws IOException, ClassFormatException {
        int magic = 0xCAFEBABE;
        if (file.readInt() != magic) {
            throw new ClassFormatException(file_name + " is not a Java .class file");
        }
    }

    /**
     * Read information about the interfaces implemented by this class.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readInterfaces() throws IOException, ClassFormatException {
        int interfaces_count;
        interfaces_count = file.readUnsignedShort();
        interfaces = new int[interfaces_count];
        String[] interfacesNames = new String[interfaces_count];
        for (int i = 0; i < interfaces_count; i++) {
            interfaces[i] = file.readUnsignedShort();
            interfacesNames[i] = ((ConstantUtf8) constant_pool.getConstant(file.readUnsignedShort())).getBytes();
        }
        def.setSuperInterfaceNames(interfacesNames);
    }

    /**
     * Read information about the methods of the class.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readMethods() throws IOException, ClassFormatException {
        int methods_count;
        methods_count = file.readUnsignedShort();
        methods = new Method[methods_count];
        KMethodDef[] kmethods = new KMethodDef[methods_count];
        for (int i = 0; i < methods_count; i++) {
            methods[i] = new Method(
                    file.readUnsignedShort(), file.readUnsignedShort(),
                    file.readUnsignedShort(), null, constant_pool);
        }
    }

    /**
     * Read major and minor version of compiler which created the file.
     * @throws  IOException
     * @throws  ClassFormatException
     */
    private final void readVersion() throws IOException, ClassFormatException {
        minor = file.readUnsignedShort();
        major = file.readUnsignedShort();
    }

    static final Constant readConstant(DataInputStream file)
            throws IOException, ClassFormatException {
        byte b = file.readByte(); // Read tag byte

        switch (b) {
            case Constants.CONSTANT_Class:
                return new ConstantClass(file.readUnsignedShort());
            case Constants.CONSTANT_Fieldref:
                return new ConstantFieldref(file.readUnsignedShort(), file.readUnsignedShort());
            case Constants.CONSTANT_Methodref:
                return new ConstantMethodref(file.readUnsignedShort(), file.readUnsignedShort());
            case Constants.CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodref(file.readUnsignedShort(), file.readUnsignedShort());
            case Constants.CONSTANT_String:
                return new ConstantString((int) file.readUnsignedShort());
            case Constants.CONSTANT_Integer:
                return new ConstantInteger(file.readInt());
            case Constants.CONSTANT_Float:
                return new ConstantFloat(file.readFloat());
            case Constants.CONSTANT_Long:
                return new ConstantLong(file.readLong());
            case Constants.CONSTANT_Double:
                return new ConstantDouble(file.readDouble());
            case Constants.CONSTANT_NameAndType:
                return new ConstantNameAndType((int) file.readUnsignedShort(), (int) file.readUnsignedShort());
            case Constants.CONSTANT_Utf8:
                return new ConstantUtf8(file.readUTF());
            default:
                throw new ClassFormatException("Invalid byte tag in constant pool: " + b);
        }
    }
}
