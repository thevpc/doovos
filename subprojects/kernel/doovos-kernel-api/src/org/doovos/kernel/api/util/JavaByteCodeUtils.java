/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.api.util;

import org.doovos.kernel.api.memory.KObjectType;

import java.util.ArrayList;
import org.doovos.kernel.api.memory.KRegisterType;

/**
 *
 * @author vpc
 */
public class JavaByteCodeUtils {

//    private static final String STRING_JAVA_CLASS_NAME = "java*lang*String";
//    private static final String OBJECT_JAVA_CLASS_NAME = "java*lang*Object";
//    private static final String STRING_JAVA_CLASS_NAME_ENCODED = "L" + STRING_JAVA_CLASS_NAME + ";";
//    private static final String OBJECT_JAVA_CLASS_NAME_ENCODED = "L" + OBJECT_JAVA_CLASS_NAME + ";";

    static String mapType0(String type) {
            return type;
//        if (OBJECT_JAVA_CLASS_NAME.equals(type)) {
//            return "O";
//        } else if (STRING_JAVA_CLASS_NAME.equals(type)) {
//            return "G";
//        } else {
//            return type;
//        }
    }

    public static String mapType(String type) {
        if(type.startsWith("[")){
            return type;
        }else if(!type.endsWith(";")) {
            return type.replace('/','.');
        }else{
            return type.substring(1,type.length()-1);
        }
    }

    public static String mapType2(String type) {
        char[] all = type.toCharArray();
        int length = all.length;
        int array = 0;
        while (all[array] == '[') {
            array++;
        }
        if (array > 0) {
            return type;
//            if (all[length - 1] == ';') {
//                int count = length - 1;
//                for (int i = array + 1; i < count; i++) {
//                    if (all[i] == '/') {
//                        all[i] = '.';
//                    }
//                }
//                return new String(all, array + 1, count - array - 1);
//            } else {
//                //int typeLength = length - array;
//                //String name2 = new String(all, array, typeLength);
//                //return KObjectType.resolveByCode(name2).getName();
//                return type;
//            }
        } else if(all[length - 1] == ';'){
            int count =  length- 1;
            for (int i = 1; i < count; i++) {
                if (all[i] == '/') {
                    all[i] = '.';
                }
            }
            return new String(all, 1, count - 1);
        }else{
            return KObjectType.resolveByCode(type).getName();
        }
    }

//    static String mapSignature(String name, String desc) {
//        StringBuilder sb = new StringBuilder(name);
//        if (desc.equals("()")) {
//            sb.append(desc);
//        } else {
//            int i = 0;
//            StringBuilder sb2 = new StringBuilder();
//            int desc_length = desc.length();
//            while (i < desc_length) {
//                switch (desc.charAt(i)) {
//                    case 'L': {
//                        WHILE2:
//                        while (i < desc_length) {
//                            switch (desc.charAt(i)) {
//                                case ';': {
//                                    sb2.append(";");
//                                    String x = sb2.toString();
////                                    x = x.replace(STRING_JAVA_CLASS_NAME_ENCODED, "G");
////                                    x = x.replace(OBJECT_JAVA_CLASS_NAME_ENCODED, "O");
//                                    sb.append(x);
//                                    sb2.delete(0, sb2.length());
//                                    break WHILE2;
//                                }
//                                default: {
//                                    sb2.append(desc.charAt(i));
//                                    break;
//                                }
//                            }
//                            i++;
//                        }
//                        break;
//                    }
//                    default: {
//                        sb.append(desc.charAt(i));
//                    }
//                }
//                i++;
//            }
//        }
//        return sb.toString();
//    }

    public static String getReturnType(String desc) {
        return desc.substring(desc.indexOf(')')+1);
    }
    
    public static int getParametersCount(String desc) {
        int all = 0;
        int i = desc.indexOf('(')+1;
        char[] chars = desc.toCharArray();
        int desc_length = desc.indexOf(')',i+1);
        while (i < desc_length) {
            switch (chars[i]) {
                case 'L': {
                    WHILE2:
                    while (i < desc_length) {
                        switch (chars[i]) {
                            case ';': {
                                all++;
                                break WHILE2;
                            }
                            default: {
                                break;
                            }
                        }
                        i++;
                    }
                    break;
                }
                case '[': {
                    break;
                }
                default: {
                    all++;
                }
            }
            i++;
        }
        return all;
    }

    public static String[] getMethodTypeCodes(String desc) {
        return getMethodTypeCodes0(desc.substring(desc.indexOf('(')+1, desc.indexOf(')')));
    }
    
    public static String[] getMethodTypeCodes0(String typesListString) {
        ArrayList<String> all = new ArrayList<String>();
        int i = 0;
        StringBuilder sb2 = new StringBuilder();
        char[] chars = typesListString.toCharArray();
        int desc_length = chars.length;
        while (i < desc_length) {
            switch (chars[i]) {
                case 'L': {
                    WHILE2:
                    while (i < desc_length) {
                        switch (chars[i]) {
                            case ';': {
                                sb2.append(";");
                                String x = sb2.toString();
//                                x = x.replace(STRING_JAVA_CLASS_NAME_ENCODED, "G");
//                                x = x.replace(OBJECT_JAVA_CLASS_NAME_ENCODED, "O");
                                all.add(x);
                                sb2.delete(0, sb2.length());
                                break WHILE2;
                            }
                            default: {
                                sb2.append(chars[i]);
                                break;
                            }
                        }
                        i++;
                    }
                    break;
                }
                case '[': {
                    sb2.append('[');
                    break;
                }
                default: {
                    sb2.append(chars[i]);
                    all.add(sb2.toString());
                    sb2.delete(0, sb2.length());
                }
            }
            i++;
        }
        return all.toArray(new String[all.size()]);
    }

    public static String[] getMethodTypes(String desc) {
        return mapMethodTypes(desc.substring(desc.indexOf('(')+1, desc.indexOf(')')));
    }
    
    public static String[] mapMethodTypes(String desc) {
        ArrayList<String> all = new ArrayList<String>();
        int i = 0;
        StringBuilder sb2 = new StringBuilder();
        char[] chars = desc.toCharArray();
        int desc_length = chars.length;
        while (i < desc_length) {
            switch (chars[i]) {
                case 'L': {
                    WHILE2:
                    while (i < desc_length) {
                        switch (chars[i]) {
                            case ';': {
                                sb2.append(";");
                                String x = sb2.toString();
//                                x = x.replace(STRING_JAVA_CLASS_NAME_ENCODED, "G");
//                                x = x.replace(OBJECT_JAVA_CLASS_NAME_ENCODED, "O");
                                all.add(mapType2(x));
                                sb2.delete(0, sb2.length());
                                break WHILE2;
                            }
                            default: {
                                sb2.append(chars[i]);
                                break;
                            }
                        }
                        i++;
                    }
                    break;
                }
                case '[': {
                    sb2.append('[');
                    break;
                }
                default: {
                    sb2.append(chars[i]);
                    all.add(mapType2(sb2.toString()));
                    sb2.delete(0, sb2.length());
                }
            }
            i++;
        }
        return all.toArray(new String[all.size()]);
    }

    public static KRegisterType getRegisterTypeByClassCode(String s){
        if(s.equals("V")){
            return null;
        }
        if(s.equals("J")){
            return KRegisterType.LONG;
        }
        if(s.equals("D")){
            return KRegisterType.DOUBLE;
        }
        if(s.equals("F")){
            return KRegisterType.FLOAT;
        }
        if(s.equals("I")){
            return KRegisterType.INTEGER;
        }
        if(s.equals("S")){
            return KRegisterType.INTEGER;
        }
        if(s.equals("B")){
            return KRegisterType.INTEGER;
        }
        if(s.equals("C")){
            return KRegisterType.INTEGER;
        }
        if(s.equals("Z")){
            return KRegisterType.INTEGER;
        }
        if(s.startsWith("[")){
            return KRegisterType.REF;
        }
        if(s.endsWith(";")){
            return KRegisterType.REF;
        }
        throw new IllegalArgumentException("Unsupported type "+s);
    }

//    private static String opcodeName(int opcode) {
//        for (Field field : JavaOpCodes.class.getFields()) {
//            try {
//                if (field.getInt(null) == opcode) {
//                    return opcode + "_" + field.getName();
//                }
//            } catch (Throwable e) {
//                e.printStackTrace();
//            }
//        }
//        return (String.valueOf(opcode));
//    }
}
