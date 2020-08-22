///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.depreciated;
//
//import org.doovos.kernel.api.jvm.bytecode.*;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.filesystem.KFile;
//import org.doovos.kernel.api.memory.KMemorySegment;
//import org.doovos.kernel.api.io.stream.KInputStream;
//import org.doovos.kernel.api.io.stream.KOutputStream;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.KSysCallOperator;
//
//import java.io.*;
//import java.lang.reflect.Modifier;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Hashtable;
//import java.util.NoSuchElementException;
//import java.util.Set;
//
//public class KASMUtils {
//    public static KClassDef loadClass(KFile file) throws IOException, KInvalidByteCodeImageException {
//        try {
//            KInputStream stream = null;
//            ObjectInputStream ois = null;
//            try {
//                stream = file.openInputStream();
//                ois = new ObjectInputStream(stream.getInputStream());
//                return (KClassDef) ois.readObject();
//            } finally {
//                if (ois != null) {
//                    ois.close();
//                }
//                if (stream != null) {
//                    stream.free();
//                }
//            }
//        } catch (IOException e) {
//            throw e;
//        } catch (Exception e) {
//            throw new KInvalidByteCodeImageException(e);
//        }
//    }
//
//    public static void storeClass(KClassDef code, KFile file) throws IOException, KDefinitionParseException, KInvalidByteCodeImageException {
//        try {
//            KOutputStream stream = null;
//            ObjectOutputStream ois = null;
//            try {
//                stream = file.openOutputStream(new KFile.OutFlags().setAppend(false).setCreate(true));
//                ois = new ObjectOutputStream(stream.getOutputStream());
//                ois.writeObject(code);
//            } finally {
//                if (ois != null) {
//                    ois.close();
//                }
//                if (stream != null) {
//                    stream.free();
//                }
//            }
//        } catch (IOException e) {
//            throw e;
//        } catch (Exception e) {
//            throw new KInvalidByteCodeImageException(e);
//        }
//    }
//
//    public static KClassDef compileAssemblerClass(KFile is) throws IOException, KDefinitionParseException {
//        KInputStream inputStream = null;
//        try {
//            inputStream = is.openInputStream();
//            return compileAssemblerClass(new InputStreamReader(inputStream.getInputStream()));
//        } finally {
//            if (inputStream != null) {
//                inputStream.free();
//            }
//        }
//    }
//
////    private static DByteCodeImage compile1(Reader is) throws IOException, DByteCodeParseException {
////        BufferedReader r = (is instanceof BufferedReader) ? (BufferedReader) is : new BufferedReader(is);
////        String line;
////        final int HEADER_CODE = 2;
////        final int HEADER_SEGMENT = 8;
////        final int SEGMENT_LINE = 3;
////        final int HEADER_METADATA = 5;
////        final int METADATA_LINE = 6;
////        final int CODE_LINE = 7;
////        final int END = 9;
////        int status = HEADER_METADATA;
////        int lineCounter = 0;
////        int opcodeIndex = 0;
////        ArrayList<DSegmentInfo> segments = new ArrayList<DSegmentInfo>();
////        ArrayList<Object> consts = new ArrayList<Object>();
////        ArrayList<DMetaDataInfo> metadata = new ArrayList<DMetaDataInfo>();
////        ArrayList<DInstruction> code = new ArrayList<DInstruction>();
////        Hashtable<String, int[]> aliases = new Hashtable<String, int[]>();
////        Token[] tokens = null;
////        TreeSet<String> keywords = new TreeSet<String>();
////        keywords.add(".segment");
////        keywords.add(".code");
////        keywords.add(".end");
////        keywords.add(".doovosasm");
////        keywords.add(".method");
////        keywords.add(".attribute");
////        boolean skipReadLine = false;
////        int segmentId=0;
////        int segmentIndex=0;
////        Hashtable<String,Integer> labels=new Hashtable<String, Integer>();
////        class OnHoldLabel{
////            int instIndex;
////            int paramIndex;
////            String label;
////
////            OnHoldLabel(String label, int instIndex, int paramIndex) {
////                this.label = label;
////                this.instIndex = instIndex;
////                this.paramIndex = paramIndex;
////            }
////        }
////        ArrayList<OnHoldLabel> onHoldLabels=new ArrayList<OnHoldLabel>();
////        while (true) {
////            if (skipReadLine) {
////                skipReadLine = false;
////            } else {
////                line = r.readLine();
////                if (line == null) {
////                    break;
////                }
////                lineCounter++;
////                tokens = split(line,lineCounter);
////                if (tokens.length == 0) {
////                    continue;
////                }
////                skipReadLine = false;
////            }
////            switch (status) {
////                case HEADER_CODE: {
////                    String section = tokens[0].value;
////                    if (tokens.length == 1 && section.equals(".code")) {
////                        status = CODE_LINE;
////                    } else {
////                        throw new DByteCodeParseException("Expected .code", lineCounter,0);
////                    }
////                    break;
////                }
////                case HEADER_METADATA: {
////                    if (tokens.length == 1 && ".doovosasm".equals(tokens[0].value)) {
////                        status = METADATA_LINE;
////                    } else {
////                        throw new DByteCodeParseException("Expected .doovosasm", lineCounter,0);
////                    }
////                    break;
////                }
////                case HEADER_SEGMENT: {
////                    if (tokens.length < 2 || tokens.length > 3) {
////                        throw new DByteCodeParseException("Wrong arguments count", lineCounter,0);
////                    }
////                    long size=-1;
////                    if(tokens.length == 3){
////                        if(tokens[2].value.toLowerCase().endsWith("m")){
////                            size=Long.parseLong(tokens[2].value.substring(0,tokens[2].value.length()-1))*1024*1024;
////                        }else if(tokens[2].value.toLowerCase().endsWith("mo")){
////                            size=Long.parseLong(tokens[2].value.substring(0,tokens[2].value.length()-2))*1024*1024;
////                        }else if(tokens[2].value.toLowerCase().endsWith("k")){
////                            size=Long.parseLong(tokens[2].value.substring(0,tokens[2].value.length()-1))*1024;
////                        }else if(tokens[2].value.toLowerCase().endsWith("ko")){
////                            size=Long.parseLong(tokens[2].value.substring(0,tokens[2].value.length()-2))*1024;
////                        }else if(tokens[2].value.toLowerCase().endsWith("o")){
////                            size=Long.parseLong(tokens[2].value.substring(0,tokens[2].value.length()-1));
////                        }else{
////                            size=Long.parseLong(tokens[2].value);
////                        }
////                    }
////                    DSegmentInfo segmentInfo = new DSegmentInfo(
////                            tokens[1].value,
////                            size,
////                            DMemorySegment.Options.DEFAULT,
////                            null
////                    );
////                    segments.add(segmentInfo);
////                    status = SEGMENT_LINE;
////                    segmentId++;
////                    segmentIndex=0;
////                    break;
////                }
////                case SEGMENT_LINE: {
////                    if (".segment".equals(tokens[0].value)) {
////                        segments.get(segments.size() - 1).constants = new DConstantsInfo(consts.toArray(new Object[consts.size()]));
////                        consts.clear();
////                        status = HEADER_SEGMENT;
////                        skipReadLine = true;
////                    } else if (".code".equals(tokens[0].value)) {
////                        segments.get(segments.size() - 1).constants = new DConstantsInfo(consts.toArray(new Object[consts.size()]));
////                        consts.clear();
////                        status = HEADER_CODE;
////                        skipReadLine = true;
////                    } else if (keywords.contains(tokens[0].value)) {
////                        throw new DByteCodeParseException("Expected .code", lineCounter,0);
////                    } else {
////                        String type = tokens[0].value;
////                        if ("options".equals(tokens[0].value)) {
////                            int options = DMemorySegment.Options.DEFAULT;
////                            for (int i = 1; i < tokens.length; i++) {
////                                String item = tokens[i].value;
////                                if ("grow".equalsIgnoreCase(item) || "growable".equalsIgnoreCase(item)) {
////                                    options |= DMemorySegment.Options.GROWABLE;
////                                } else if ("shrink".equalsIgnoreCase(item) || "shrinkable".equalsIgnoreCase(item)) {
////                                    options |= DMemorySegment.Options.SHRINLABLE;
////                                } else if ("ro".equalsIgnoreCase(item) || "readonly".equalsIgnoreCase(item)) {
////                                    options |= DMemorySegment.Options.READ_ONLY;
////                                } else {
////                                    options |= parseInt(item);
////                                }
////                            }
////                            segments.get(segments.size() - 1).options = options;
////                        } else {
////                            if(tokens.length>1 && tokens[0].value.startsWith("&")){
////                                aliases.put(tokens[0].value,new int[]{segmentId,segmentIndex});
////                                Token[] a=new Token[tokens.length-1];
////                                System.arraycopy(tokens,1,a,0,a.length);
////                                tokens=a;
////                                type=tokens[0].value;
////                            }
////                            segmentIndex++;
////                            if ("int".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                consts.add(parseInt(tokens[1].value));
////                            } else if ("int[]".equals(type)) {
////                                if (tokens.length == 1) {
////                                    consts.add(new float[0]);
////                                } else {
////                                    int[] values = new int[tokens.length - 1];
////                                    for (int i = 0; i < values.length; i++) {
////                                        consts.add(parseInt(tokens[i + 1].value));
////                                    }
////                                    consts.add(values);
////                                }
////                            } else if ("long".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                consts.add(parseLong(tokens[1].value));
////                            } else if ("long[]".equals(type)) {
////                                if (tokens.length == 1) {
////                                    consts.add(new long[0]);
////                                } else {
////                                    long[] values = new long[tokens.length - 1];
////                                    for (int i = 0; i < values.length; i++) {
////                                        consts.add(parseLong(tokens[i + 1].value));
////                                    }
////                                    consts.add(values);
////                                }
////                            } else if ("double".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                consts.add(Double.parseDouble(tokens[1].value));
////                            } else if ("double[]".equals(type)) {
////                                if (tokens.length == 1) {
////                                    consts.add(new double[0]);
////                                } else {
////                                    double[] values = new double[tokens.length - 1];
////                                    for (int i = 0; i < values.length; i++) {
////                                        values[i] = (Double.parseDouble(tokens[i + 1].value));
////                                    }
////                                    consts.add(values);
////                                }
////                            } else if ("float".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                consts.add(Float.parseFloat(tokens[1].value));
////                            } else if ("float[]".equals(type)) {
////                                if (tokens.length == 1) {
////                                    consts.add(new float[0]);
////                                } else {
////                                    float[] values = new float[tokens.length - 1];
////                                    for (int i = 0; i < values.length; i++) {
////                                        values[i] = (Float.parseFloat(tokens[i + 1].value));
////                                    }
////                                    consts.add(values);
////                                }
////                            } else if ("byte".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                consts.add(parseByte(tokens[1].value));
////                            } else if ("byte[]".equals(type)) {
////                                if (tokens.length == 1) {
////                                    consts.add(new byte[0]);
////                                } else {
////                                    byte[] values = new byte[tokens.length - 1];
////                                    for (int i = 0; i < values.length; i++) {
////                                        values[i] = parseByte(tokens[i + 1].value);
////                                    }
////                                    consts.add(values);
////                                }
////                            } else if ("boolean".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                consts.add(Boolean.parseBoolean(tokens[1].value));
////                            } else if ("boolean[]".equals(type)) {
////                                if (tokens.length == 1) {
////                                    consts.add(new boolean[0]);
////                                } else {
////                                    boolean[] values = new boolean[tokens.length - 1];
////                                    for (int i = 0; i < values.length; i++) {
////                                        values[i] = Boolean.parseBoolean(tokens[i + 1].value);
////                                    }
////                                    consts.add(values);
////                                }
////                            } else if ("char".equals(type)) {
////                                if (tokens.length != 2) {
////                                    throw new DByteCodeParseException("Expected <type> <literal value>", lineCounter,0);
////                                }
////                                if (tokens[1].value.length() != 1) {
////                                    throw new DByteCodeParseException("Expected a char", lineCounter,0);
////                                }
////                                consts.add(tokens[1].value.charAt(0));
////                            } else if ("char[]".equals(type)) {
////                                consts.add(tokens[1].value.toCharArray());
////                            } else {
////                                throw new DByteCodeParseException("Unknown type " + type, lineCounter,0);
////                            }
////                        }
////                    }
////                    break;
////                }
////                case METADATA_LINE: {
////                    if (".segment".equals(tokens[0].value)) {
////                        status = HEADER_SEGMENT;
////                        skipReadLine = true;
////                    } else if (keywords.contains(tokens[0].value)) {
////                        throw new DByteCodeParseException("Expected .segment", lineCounter,0);
////                    } else {
////                        if (tokens.length != 2) {
////                            throw new DByteCodeParseException("Expected KEY VALUE", lineCounter,0);
////                        }
////                        DMetaDataInfo v = new DMetaDataInfo();
////                        v.key = tokens[0].value;
////                        v.value = tokens[1].value;
////                        metadata.add(v);
////                    }
////                    break;
////                }
////                case CODE_LINE: {
////                    if (".end".equals(tokens[0].value)) {
////                        status = END;
////                    } else if (keywords.contains(tokens[0].value)) {
////                        throw new DByteCodeParseException("Expected End", lineCounter,0);
////                    } else if("label".equals(tokens[0].value)){
////                        if(tokens.length!=2){
////                            throw new DByteCodeParseException("Expected Label value", lineCounter,0);
////                        }
////                        if(labels.containsKey("@"+tokens[1])){
////                            throw new DByteCodeParseException("Label already defined "+tokens[1], lineCounter,0);
////                        }else{
////                            labels.put("@"+tokens[1],opcodeIndex);
////                        }
////                    } else {
////                        DInstruction ins = new DInstruction();
////                        try {
////                            ins.operator = DByteCodeOperator.valueOf(tokens[0].value.toUpperCase());
////                        } catch (Exception e) {
////                            throw new DByteCodeParseException("Unknown opcode "+tokens[0].value+" : "+e,lineCounter,0);
////                        }
////                        ArrayList<Long> operandList=new ArrayList<Long>();
////                        for (int i = 1; i < tokens.length; i++) {
////                            String o = tokens[i].value;
////                            if (Character.isLetter(o.charAt(0))) {
////                                boolean ok = false;
////                                //assume it is a segment id
////                                for (int j = 0; j < segments.size(); j++) {
////                                    if (segments.get(j).id.equals(o)) {
////                                        operandList.add(new Long(j+1));
////                                        ok = true;
////                                    }
////                                }
////                                if (!ok) {
////                                    throw new DByteCodeParseException("Unresolved segment " + o, lineCounter,0);
////                                }
////                            } else if(o.length()>1 && o.startsWith("&")){
////                                int[] ints = aliases.get(o);
////                                if(ints==null){
////                                    throw new DByteCodeParseException("Unknown alias "+o,lineCounter,0);
////                                }
////                                operandList.add(new Long(ints[0]));
////                                operandList.add(new Long(ints[1]));
////                            } else if(o.length()>1 && o.startsWith("@")){
////                                Integer labelIndex = labels.get(o);
////                                if(labelIndex==null){
////                                    onHoldLabels.add(new OnHoldLabel(o,opcodeIndex,onHoldLabels.size()));
////                                    operandList.add(new Long(0));
////                                }else{
////                                    operandList.add(new Long(labelIndex));
////                                }
////                            }else{
////                                operandList.add(parseLong(o));
////                            }
////                        }
////
////                        ins.operands = new long[operandList.size()];
////                        for (int i = 0; i < operandList.size(); i++) {
////                            ins.operands[i]=operandList.get(i);
////                        }
////                        if(ins.operands.length!=ins.operator.getOperandsCount()){
////                            throw new DByteCodeParseException("Op "+ins.operator+" expected "+ins.operator.getOperandsCount()+" operands but found "+ins.operands.length,lineCounter,0);
////                        }
////                        code.add(ins);
////                        opcodeIndex++;
////                    }
////                    break;
////                }
////                case END: {
////                    throw new DByteCodeParseException("Expected end of file", lineCounter,0);
////                }
////                default: {
////                    throw new DByteCodeParseException("??????", lineCounter,0);
////                }
////            }
////        }
////        if (status != END) {
////            throw new DByteCodeParseException("unexpected end of file", lineCounter,0);
////        }
////        DByteCodeImage image = new DByteCodeImage();
////        image.code = code.toArray(new DInstruction[code.size()]);
////        image.metadata = metadata.toArray(new DMetaDataInfo[metadata.size()]);
////        image.segments = segments.toArray(new DSegmentInfo[segments.size()]);
////        for (OnHoldLabel onHoldLabel : onHoldLabels) {
////            Integer labelIndex = labels.get(onHoldLabel.label);
////            if(labelIndex==null){
////                throw new DByteCodeParseException("Label not found "+onHoldLabel.label, lineCounter,0);
////            }
////            image.code[onHoldLabel.instIndex].operands[onHoldLabel.paramIndex]=labelIndex.longValue();
////        }
////        return image;
////    }
//
//    public static KClassDef compileAssemblerClass(Reader is) throws IOException, KDefinitionParseException {
//        BufferedReader r = (is instanceof BufferedReader) ? (BufferedReader) is : new BufferedReader(is);
//        String line;
//        final int HEADER_CODE = 2;
//        final int HEADER_SEGMENT = 8;
//        final int SEGMENT_LINE = 3;
//        final int HEADER_METADATA = 5;
//        final int METADATA_LINE = 6;
//        final int CODE_LINE = 7;
//        final int HEADER_ATTRIBUTE = 10;
//        final int HEADER_CLASS = 14;
//        final int HEADER_METHOD = 11;
//        final int METHOD_PARAM = 12;
//        final int METHOD_VAR = 13;
//        int status = HEADER_METADATA;
//        int maxLocals = -1;
//        int maxStack = -1;
//        int lineCounter = 0;
//        int opcodeIndex = 0;
//        ArrayList<KSegmentDef> segments = new ArrayList<KSegmentDef>();
//        ArrayList<Object> consts = new ArrayList<Object>();
//        ArrayList<KMetaDataDef> metadata = new ArrayList<KMetaDataDef>();
//        ArrayList<KInstruction> code = new ArrayList<KInstruction>();
//        Hashtable<String, int[]> aliases = new Hashtable<String, int[]>();
//        Token[] tokens = null;
//        Set<String> keywords = new HashSet<String>();
//        keywords.add(".segment");
//        keywords.add(".code");
//        keywords.add(".end");
//        keywords.add(".doovosasm");
//        keywords.add(".method");
//        keywords.add(".field");
//        keywords.add(".class");
//        boolean skipReadLine = false;
//        int segmentId = 0;
//        int segmentIndex = 0;
//        int classModifiers = 0;
//        int methodModifiers = 0;
//        int parameterModifiers = 0;
//        String className = "NONAME";
//        String extendsClassName = null;
//        long classVersion = 0;
//        String methodName = null;
//        String methodType = null;
//        ArrayList<KParameterDef> params = new ArrayList<KParameterDef>();
//        ArrayList<KVariableDef> vars = new ArrayList<KVariableDef>();
//        ArrayList<String> implementsClassNames = new ArrayList<String>();
//        Hashtable<String, Integer> labels = new Hashtable<String, Integer>();
//        class OnHoldLabel {
//            int instIndex;
//            int paramIndex;
//            String label;
//
//            OnHoldLabel(String label, int instIndex, int paramIndex) {
//                this.label = label;
//                this.instIndex = instIndex;
//                this.paramIndex = paramIndex;
//            }
//        }
//        ArrayList<OnHoldLabel> onHoldLabels = new ArrayList<OnHoldLabel>();
//        ArrayList<KFieldDef> attributes = new ArrayList<KFieldDef>();
//        ArrayList<KMethodDef> methods = new ArrayList<KMethodDef>();
//        while (true) {
//            if (skipReadLine) {
//                skipReadLine = false;
//            } else {
//                line = r.readLine();
//                if (line == null) {
//                    break;
//                }
//                lineCounter++;
//                tokens = split(line, lineCounter);
//                if (tokens.length == 0) {
//                    continue;
//                }
//                skipReadLine = false;
//            }
//            switch (status) {
//                case HEADER_METADATA: {
//                    if (tokens.length == 1 && ".doovosasm".equals(tokens[0].value)) {
//                        status = METADATA_LINE;
//                    } else {
//                        throw new KDefinitionParseException("Expected .doovosasm", lineCounter, 0);
//                    }
//                    break;
//                }
//                case METADATA_LINE: {
//                    if (".segment".equals(tokens[0].value)) {
//                        status = HEADER_SEGMENT;
//                        skipReadLine = true;
//                    } else if (".class".equals(tokens[0].value)) {
//                        status = HEADER_CLASS;
//                        skipReadLine = true;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .segment", lineCounter, 0);
//                    } else {
//                        if (tokens.length != 2) {
//                            throw new KDefinitionParseException("Expected KEY VALUE", lineCounter, 0);
//                        }
//                        KMetaDataDef v = new KMetaDataDef();
//                        v.key = tokens[0].value;
//                        v.value = tokens[1].value;
//                        metadata.add(v);
//                    }
//                    break;
//                }
//                case HEADER_CLASS: {
//                    if (".class".equals(tokens[0].value)) {
//                        if (tokens.length < 3) {
//                            throw new KDefinitionParseException("Expected .field modifiers type  name", lineCounter, 0);
//                        }
//                        classModifiers = 0;
//                        for (int i = 1; i < tokens.length - 2; i++) {
//                            classModifiers |= getModifier(tokens[i].value);
//                        }
//                        className = tokens[tokens.length - 2].value;
//                        classVersion = Long.parseLong(tokens[tokens.length - 1].value);
//                        status = HEADER_ATTRIBUTE;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .class", lineCounter, 0);
//                    }
//                    break;
//                }
//                case HEADER_ATTRIBUTE: {
//                    if (".field".equals(tokens[0].value)) {
//                        if (tokens.length < 3) {
//                            throw new KDefinitionParseException("Expected .field modifiers type  name", lineCounter, 0);
//                        }
//                        parameterModifiers = 0;
//                        for (int i = 1; i < tokens.length - 2; i++) {
//                            parameterModifiers |= getModifier(tokens[i].value);
//                        }
//                        String type = tokens[tokens.length - 2].value;
//                        String name = tokens[tokens.length - 1].value;
//                        attributes.add(new KFieldDef(className, parameterModifiers, KClass.userClassFormatToJavaClassFormat(type), name));
//                    } else if (".method".equals(tokens[0].value)) {
//                        status = HEADER_METHOD;
//                        skipReadLine = true;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .field or .method", lineCounter, 0);
//                    } else {
//                        throw new KDefinitionParseException("Expected .field or .method", lineCounter, 0);
//                    }
//                    break;
//                }
//                case HEADER_METHOD: {
//                    if (".method".equals(tokens[0].value)) {
//                        onHoldLabels.clear();
//                        params.clear();
//                        vars.clear();
//                        code.clear();
//                        labels.clear();
//                        maxLocals = -1;
//                        maxStack = -1;
//                        if (tokens.length < 3) {
//                            throw new KDefinitionParseException("Expected .field modifiers type  name", lineCounter, 0);
//                        }
//                        methodModifiers = 0;
//                        for (int i = 1; i < tokens.length - 2; i++) {
//                            methodModifiers |= getModifier(tokens[i].value);
//                        }
//                        methodType = tokens[tokens.length - 2].value;
//                        methodName = tokens[tokens.length - 1].value;
//                        status = METHOD_PARAM;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .method", lineCounter, 0);
//                    } else {
//                        throw new KDefinitionParseException("Expected .method", lineCounter, 0);
//                    }
//                    break;
//                }
//                case METHOD_PARAM: {
//                    if (".param".equals(tokens[0].value)) {
//                        if (tokens.length < 3) {
//                            throw new KDefinitionParseException("Expected .field modifiers type  name", lineCounter, 0);
//                        }
//                        String type = tokens[tokens.length - 2].value;
//                        String name = tokens[tokens.length - 1].value;
//                        parameterModifiers = 0;
//                        for (int i = 1; i < tokens.length - 2; i++) {
//                            parameterModifiers |= getModifier(tokens[i].value);
//                        }
//                        params.add(new KParameterDef(name, KClass.userClassFormatToJavaClassFormat(type), parameterModifiers, params.size()));
//                    } else if (".var".equals(tokens[0].value)) {
//                        status = METHOD_VAR;
//                        skipReadLine = true;
//                    } else if (".code".equals(tokens[0].value)) {
//                        status = HEADER_CODE;
//                        skipReadLine = true;
//                    } else if (".maxLocals".equals(tokens[0].value)) {
//                        maxLocals = parseInt(tokens[1].value);
//                    } else if (".maxLocals".equals(tokens[0].value)) {
//                        maxStack = parseInt(tokens[1].value);
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .param, .var or.code", lineCounter, 0);
//                    } else {
//                        throw new KDefinitionParseException("Expected .param, .var or.code", lineCounter, 0);
//                    }
//                    break;
//                }
//                case METHOD_VAR: {
//                    if (".var".equals(tokens[0].value)) {
//                        if (tokens.length < 3) {
//                            throw new KDefinitionParseException("Expected .field modifiers type  name", lineCounter, 0);
//                        }
//                        String type = tokens[tokens.length - 2].value;
//                        String name = tokens[tokens.length - 1].value;
//                        parameterModifiers = 0;
//                        for (int i = 1; i < tokens.length - 2; i++) {
//                            parameterModifiers |= getModifier(tokens[i].value);
//                        }
//                        vars.add(new KVariableDef(name, KClass.userClassFormatToJavaClassFormat(type), parameterModifiers, vars.size()));
//                    } else if (".code".equals(tokens[0].value)) {
//                        status = HEADER_CODE;
//                        skipReadLine = true;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .var or .code", lineCounter, 0);
//                    } else {
//                        throw new KDefinitionParseException("Expected .var or .code", lineCounter, 0);
//                    }
//                    break;
//                }
//                case HEADER_CODE: {
//                    String section = tokens[0].value;
//                    if (tokens.length == 1 && section.equals(".code")) {
//                        status = CODE_LINE;
//                    } else {
//                        throw new KDefinitionParseException("Expected .code", lineCounter, 0);
//                    }
//                    break;
//                }
//                case HEADER_SEGMENT: {
//                    if (tokens.length < 2 || tokens.length > 3) {
//                        throw new KDefinitionParseException("Wrong arguments count", lineCounter, 0);
//                    }
//                    long size = -1;
//                    if (tokens.length == 3) {
//                        if (tokens[2].value.toLowerCase().endsWith("m")) {
//                            size = Long.parseLong(tokens[2].value.substring(0, tokens[2].value.length() - 1)) * 1024 * 1024;
//                        } else if (tokens[2].value.toLowerCase().endsWith("mo")) {
//                            size = Long.parseLong(tokens[2].value.substring(0, tokens[2].value.length() - 2)) * 1024 * 1024;
//                        } else if (tokens[2].value.toLowerCase().endsWith("k")) {
//                            size = Long.parseLong(tokens[2].value.substring(0, tokens[2].value.length() - 1)) * 1024;
//                        } else if (tokens[2].value.toLowerCase().endsWith("ko")) {
//                            size = Long.parseLong(tokens[2].value.substring(0, tokens[2].value.length() - 2)) * 1024;
//                        } else if (tokens[2].value.toLowerCase().endsWith("o")) {
//                            size = Long.parseLong(tokens[2].value.substring(0, tokens[2].value.length() - 1));
//                        } else {
//                            size = Long.parseLong(tokens[2].value);
//                        }
//                    }
//                    KSegmentDef segmentInfo = new KSegmentDef(
//                            tokens[1].value,
//                            size,
//                            KMemorySegment.Options.DEFAULT,
//                            null
//                    );
//                    segments.add(segmentInfo);
//                    status = SEGMENT_LINE;
//                    segmentId++;
//                    segmentIndex = 0;
//                    break;
//                }
//                case SEGMENT_LINE: {
//                    if (".segment".equals(tokens[0].value)) {
//                        segments.get(segments.size() - 1).constants = new KConstantDef(consts.toArray(new Object[consts.size()]));
//                        consts.clear();
//                        status = HEADER_SEGMENT;
//                        skipReadLine = true;
//                    } else if (".code".equals(tokens[0].value)) {
//                        segments.get(segments.size() - 1).constants = new KConstantDef(consts.toArray(new Object[consts.size()]));
//                        consts.clear();
//                        status = HEADER_CODE;
//                        skipReadLine = true;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected .code", lineCounter, 0);
//                    } else {
//                        String type = tokens[0].value;
//                        if ("options".equals(tokens[0].value)) {
//                            int options = KMemorySegment.Options.DEFAULT;
//                            for (int i = 1; i < tokens.length; i++) {
//                                String item = tokens[i].value;
//                                if ("grow".equalsIgnoreCase(item) || "growable".equalsIgnoreCase(item)) {
//                                    options |= KMemorySegment.Options.GROWABLE;
//                                } else if ("shrink".equalsIgnoreCase(item) || "shrinkable".equalsIgnoreCase(item)) {
//                                    options |= KMemorySegment.Options.SHRINLABLE;
//                                } else if ("ro".equalsIgnoreCase(item) || "readonly".equalsIgnoreCase(item)) {
//                                    options |= KMemorySegment.Options.READ_ONLY;
//                                } else {
//                                    options |= parseInt(item);
//                                }
//                            }
//                            segments.get(segments.size() - 1).KSegmentDef.this.options = options;
//                        } else {
//                            if (tokens.length > 1 && tokens[0].value.startsWith("&")) {
//                                aliases.put(tokens[0].value, new int[]{segmentId, segmentIndex});
//                                Token[] a = new Token[tokens.length - 1];
//                                System.arraycopy(tokens, 1, a, 0, a.length);
//                                tokens = a;
//                                type = tokens[0].value;
//                            }
//                            segmentIndex++;
//                            if ("int".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                consts.add(parseInt(tokens[1].value));
//                            } else if ("int[]".equals(type)) {
//                                if (tokens.length == 1) {
//                                    consts.add(new float[0]);
//                                } else {
//                                    int[] values = new int[tokens.length - 1];
//                                    for (int i = 0; i < values.length; i++) {
//                                        consts.add(parseInt(tokens[i + 1].value));
//                                    }
//                                    consts.add(values);
//                                }
//                            } else if ("long".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                consts.add(parseLong(tokens[1].value));
//                            } else if ("long[]".equals(type)) {
//                                if (tokens.length == 1) {
//                                    consts.add(new long[0]);
//                                } else {
//                                    long[] values = new long[tokens.length - 1];
//                                    for (int i = 0; i < values.length; i++) {
//                                        consts.add(parseLong(tokens[i + 1].value));
//                                    }
//                                    consts.add(values);
//                                }
//                            } else if ("double".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                consts.add(Double.parseDouble(tokens[1].value));
//                            } else if ("double[]".equals(type)) {
//                                if (tokens.length == 1) {
//                                    consts.add(new double[0]);
//                                } else {
//                                    double[] values = new double[tokens.length - 1];
//                                    for (int i = 0; i < values.length; i++) {
//                                        values[i] = (Double.parseDouble(tokens[i + 1].value));
//                                    }
//                                    consts.add(values);
//                                }
//                            } else if ("float".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                consts.add(Float.parseFloat(tokens[1].value));
//                            } else if ("float[]".equals(type)) {
//                                if (tokens.length == 1) {
//                                    consts.add(new float[0]);
//                                } else {
//                                    float[] values = new float[tokens.length - 1];
//                                    for (int i = 0; i < values.length; i++) {
//                                        values[i] = (Float.parseFloat(tokens[i + 1].value));
//                                    }
//                                    consts.add(values);
//                                }
//                            } else if ("byte".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                consts.add(parseByte(tokens[1].value));
//                            } else if ("byte[]".equals(type)) {
//                                if (tokens.length == 1) {
//                                    consts.add(new byte[0]);
//                                } else {
//                                    byte[] values = new byte[tokens.length - 1];
//                                    for (int i = 0; i < values.length; i++) {
//                                        values[i] = parseByte(tokens[i + 1].value);
//                                    }
//                                    consts.add(values);
//                                }
//                            } else if ("boolean".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                consts.add(Boolean.parseBoolean(tokens[1].value));
//                            } else if ("boolean[]".equals(type)) {
//                                if (tokens.length == 1) {
//                                    consts.add(new boolean[0]);
//                                } else {
//                                    boolean[] values = new boolean[tokens.length - 1];
//                                    for (int i = 0; i < values.length; i++) {
//                                        values[i] = Boolean.parseBoolean(tokens[i + 1].value);
//                                    }
//                                    consts.add(values);
//                                }
//                            } else if ("char".equals(type)) {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected <type> <literal value>", lineCounter, 0);
//                                }
//                                if (tokens[1].value.length() != 1) {
//                                    throw new KDefinitionParseException("Expected a char", lineCounter, 0);
//                                }
//                                consts.add(tokens[1].value.charAt(0));
//                            } else if ("char[]".equals(type)) {
//                                consts.add(tokens[1].value.toCharArray());
//                            } else {
//                                throw new KDefinitionParseException("Unknown type " + type, lineCounter, 0);
//                            }
//                        }
//                    }
//                    break;
//                }
//                case CODE_LINE: {
//                    if (".end".equals(tokens[0].value)) {
//                        for (OnHoldLabel onHoldLabel : onHoldLabels) {
//                            Integer labelIndex = labels.get(onHoldLabel.label);
//                            if (labelIndex == null) {
//                                throw new KDefinitionParseException("Label not found " + onHoldLabel.label, lineCounter, 0);
//                            }
//                            code.get(onHoldLabel.instIndex).getOperands()[onHoldLabel.paramIndex] = labelIndex.longValue();
//                        }
//                        methods.add(new KMethodDef(
//                                methodName,
//                                className,
//                                KClass.userClassFormatToJavaClassFormat(methodType),
//                                methodModifiers,
//                                params.toArray(new KParameterDef[params.size()]),
//                                vars.toArray(new KVariableDef[vars.size()]),
//                                code.toArray(new KInstruction[code.size()]),
//                                new KTryCatchDef[0],
//                                maxLocals == -1 ? vars.size() : maxLocals,
//                                maxStack == -1 ? 10 : maxStack
//
//                        ));
//                        methodName = null;
//                        status = HEADER_METHOD;
//                    } else if (keywords.contains(tokens[0].value)) {
//                        throw new KDefinitionParseException("Expected End", lineCounter, 0);
//                    } else if (tokens[0].value.equals("label")) {
//                        if (tokens.length != 2) {
//                            throw new KDefinitionParseException("Expected Label value", lineCounter, 0);
//                        }
//                        if (labels.containsKey(tokens[1].value)) {
//                            throw new KDefinitionParseException("Label already defined " + tokens[1].value, lineCounter, 0);
//                        } else {
//                            labels.put(tokens[1].value, opcodeIndex);
//                        }
//                    } else {
//                        KOperator operator;
//                        long[] operands;
//                        try {
//                            operator = KOperator.valueOf(tokens[0].value.toUpperCase());
//                        } catch (Exception e) {
//                            throw new KDefinitionParseException("Unknown opcode " + tokens[0].value + " : " + e, lineCounter, 0);
//                        }
//                        switch (operator) {
//                            case IF_ICMPEQ:
//                            case IF_ICMPGE:
//                            case IF_ICMPGT:
//                            case IF_ICMPLE:
//                            case IF_ICMPLT:
//                            case IF_ICMPNE:
//                            case IFEQ:
//                            case IFGE:
//                            case IFGT:
//                            case IFLE:
//                            case IFLT:
//                            case IFNE:
//                            case IFNONNULL:
//                            case IFNULL:
//                            case GOTO:
//                            case GOTO_W: {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected " + operator + " label", lineCounter, 0);
//                                }
//                                if (!labels.containsKey(tokens[1].value)) {
//                                    operands = new long[]{0};
//                                    onHoldLabels.add(new OnHoldLabel(tokens[1].value, opcodeIndex, onHoldLabels.size()));
//                                } else {
//                                    operands = new long[]{labels.get(tokens[1].value)};
//                                }
//                                break;
//                            }
//                            case SYSCALL: {
//                                if (tokens.length != 2) {
//                                    throw new KDefinitionParseException("Expected " + operator + " callType", lineCounter, 0);
//                                }
//                                operands = new long[]{KSysCallOperator.valueOf(tokens[1].value.toUpperCase()).ordinal()};
//                                break;
//                            }
//                            default: {
//                                ArrayList<Long> operandList = new ArrayList<Long>();
//                                for (int i = 1; i < tokens.length; i++) {
//                                    switch (tokens[i].type) {
//                                        case WORD: {
//                                            operandList.add(parseLong(tokens[i].value));
//                                            break;
//                                        }
//                                        case CHAR_LITTERAL: {
//                                            operandList.add((long) (tokens[i].value).charAt(0));
//                                            break;
//                                        }
//                                        case STRING_LITTERAL: {
//                                            operandList.add((long) consts.size());
//                                            consts.add(tokens[i].value);
//                                            break;
//                                        }
//                                    }
//                                }
//
//                                operands = new long[operandList.size()];
//                                for (int i = 0; i < operandList.size(); i++) {
//                                    operands[i] = operandList.get(i);
//                                }
//                                break;
//                            }
//                        }
//                        if (operands.length != operator.getOperandsCount()) {
//                            throw new KDefinitionParseException("Op " + operator + " expected " + operator.getOperandsCount() + " operands but found " + operands.length, lineCounter, 0);
//                        }
//                        code.add(KJVMInstructions.createInstruction(operator, operands));
//                        opcodeIndex++;
//                    }
//                    break;
//                }
//                default: {
//                    throw new KDefinitionParseException("??????", lineCounter, 0);
//                }
//            }
//        }
//        if (status != HEADER_METHOD) {
//            throw new KDefinitionParseException("unexpected end of file", lineCounter, 0);
//        }
//        return new KClassDef(
//                className,
//                classVersion,
//                classModifiers,
//                extendsClassName,
//                implementsClassNames.toArray(new String[implementsClassNames.size()]),
//                metadata.toArray(new KMetaDataDef[metadata.size()]),
//                attributes.toArray(new KFieldDef[attributes.size()]),
//                methods.toArray(new KMethodDef[methods.size()]),
//                consts.toArray(new Object[consts.size()])
//        );
//    }
//
//    public static int getModifier(String name) {
//        if ("public".equals(name)) {
//            return Modifier.PUBLIC;
//        } else if ("private".equals(name)) {
//            return Modifier.PRIVATE;
//        } else if ("protected".equals(name)) {
//            return Modifier.PROTECTED;
//        } else if ("final".equals(name)) {
//            return Modifier.FINAL;
//        } else if ("static".equals(name)) {
//            return Modifier.STATIC;
//        }
//        throw new NoSuchElementException(name);
//    }
//
//    private static String toClassRefString(Object value) {
//        if (value instanceof String) {
//            String s = value.toString();
//            int arr = 0;
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                switch (c) {
//                    case 'V': {
//                        sb.append("void");
//                        break;
//                    }
//                    case 'I': {
//                        sb.append("int");
//                        break;
//                    }
//                    case 'J': {
//                        sb.append("long");
//                        break;
//                    }
//                    case 'S': {
//                        sb.append("short");
//                        break;
//                    }
//                    case 'D': {
//                        sb.append("double");
//                        break;
//                    }
//                    case 'Z': {
//                        sb.append("boolean");
//                        break;
//                    }
//                    case 'B': {
//                        sb.append("byte");
//                        break;
//                    }
//                    case 'G': {
//                        sb.append("string");
//                        break;
//                    }
//                    case 'O': {
//                        sb.append("object");
//                        break;
//                    }
//                    case 'F': {
//                        sb.append("float");
//                        break;
//                    }
//                    case 'C': {
//                        sb.append("char");
//                        break;
//                    }
//                    case 'L': {
//                        i++;
//                        while (i < s.length()) {
//                            c = s.charAt(i);
//                            if (c == ';') {
//                                break;
//                            }
//                            sb.append(c);
//                            i++;
//                        }
//                        break;
//                    }
//                    case '[': {
//                        arr++;
//                        break;
//                    }
//                    default: {
//                        sb.append("?").append(c);
//                    }
//                }
//            }
//            while (arr > 0) {
//                sb.append("[]");
//                arr--;
//            }
//            return sb.toString();
//        }
//        throw new IllegalArgumentException("Not yet supported");
//    }
//
//    private static String toLitteral(Object value) {
//        if (value == null) {
//            return "null";
//        } else if (value instanceof String) {
//            return toLitteralString((String) value);
//        } else if (value instanceof Long) {
//            return String.valueOf(value) + "L";
//        } else if (value instanceof Double) {
//            return String.valueOf(value);
//        }
//        throw new IllegalArgumentException("Not yet supported : " + value);
//    }
//
//    public static void writeClassCode(KClassDef code, PrintStream out) {
//        out.println(".doovosasm");
//        int max;
//        max = code.getMetadataSize();
//
//        for (int i = 0; i < max; i++) {
//            out.print(" ");
//            KMetaDataDef v = code.getMetadata(i);
//            out.print(v.key);
//            out.print(" ");
//            out.print(toLitteralString(v.value));
//            out.println();
//        }
//        out.print(".class ");
//        out.print(Modifier.toString(code.getModifiers()));
//        out.print(" ");
//        out.print(code.getName());
//        out.print(" ");
//        out.print(code.getVersion());
//        out.println();
//
//        max = code.getFieldsCount();
//        for (int i = 0; i < max; i++) {
//            out.print(".field ");
//            KFieldDef v = code.getField(i);
//            out.print(Modifier.toString(v.getModifiers()));
//            out.print(" ");
//            out.print(v.getTypeName());
//            out.print(" ");
//            out.print(v.getName());
//            out.println();
//        }
//
//        max = code.getMethodsCount();
//        for (int i = 0; i < max; i++) {
//            out.print(".method ");
//            KMethodDef methodByteCode = code.getMethod(i);
//            out.print(Modifier.toString(methodByteCode.getModifiers()));
//            out.print(" ");
//            out.print(toClassRefString(methodByteCode.getReturnType()));
//            out.print(" ");
//            out.print(methodByteCode.getName());
//            out.println();
//            int max2 = methodByteCode.getParametersCount();
//            for (int j = 0; j < max2; j++) {
//                out.print(" .parameter ");
//                KParameterDef p = methodByteCode.getParameter(j);
//                out.print(Modifier.toString(p.getModifiers()));
//                out.print(" ");
//                out.print(toClassRefString(p.getType()));
//                out.print(" ");
//                out.print(p.getName());
//                out.println();
//            }
//            max2 = methodByteCode.getVariableCount();
//            for (int j = 0; j < max2; j++) {
//                out.print(" .var ");
//                KVariableDef p = methodByteCode.getVariable(j);
//                out.print(Modifier.toString(p.getModifiers()));
//                out.print(" ");
//                out.print(toClassRefString(p.getType()));
//                out.print(" ");
//                out.print(p.getName());
//                out.println();
//            }
//            out.println(" .code");
//            DecimalFormat df = new DecimalFormat();
//            df.setMaximumFractionDigits(0);
//            df.setMinimumIntegerDigits((int) (Math.log10(methodByteCode.getCode().length) + 1));
//            KInstruction[] codeArray = methodByteCode.getCode();
//            int codeArrayLen = codeArray.length;
//            for (int i1 = 0; i1 < codeArrayLen; i1++) {
//                KInstruction inst = codeArray[i1];
//                out.print("  /*");
//                out.print(df.format(i1));
//                out.print("*/ ");
//                switch (inst.getOperator()) {
//                    case NEW:
//                    case LDC:
//                    case ANEWARRAY:
//                    case INVOKESTATIC:
//                    case GETSTATIC:
//                    case PUTSTATIC:
//                    case PUTFIELD:
//                    case GETFIELD:
//                    case INVOKEVIRTUAL:
//                    case INVOKESPECIAL: {
//                        out.print(inst.getOperator().toString().toLowerCase());
//                        for (long operand : inst.getOperands()) {
//                            out.print(" ");
//                            out.print(toLitteral(code.getConstant((int) operand)));
//                        }
//                        out.println();
//                        break;
//                    }
//                    case MULTIANEWARRAY: {
//                        out.print(inst.getOperator().toString().toLowerCase());
//                        long[] longs = inst.getOperands();
//                        out.print(" ");
//                        out.print(toLitteral(code.getConstant((int) longs[0])));
//                        out.print(" ");
//                        out.print(longs[1]);
//                        out.println();
//                        break;
//                    }
//                    default: {
//                        out.print(inst.getOperator().toString().toLowerCase());
//                        for (long operand : inst.getOperands()) {
//                            out.print(" ");
//                            out.print(operand);
//                        }
//                        out.println();
//                    }
//                }
//            }
//            out.println(" .end");
//        }
//    }
//
//    private static String toLitteralString(String value) {
//        StringBuilder sb = new StringBuilder("\"");
//        int max = value.length();
//        char c;
//        for (int i = 0; i < max; i++) {
//            c = value.charAt(i);
//            switch (c) {
//                case '\"': {
//                    sb.append("\\\"");
//                    break;
//                }
//                case '\\': {
//                    sb.append("\\\\");
//                    break;
//                }
//                case '\n': {
//                    sb.append("\\n");
//                    break;
//                }
//                case '\f': {
//                    sb.append("\\f");
//                    break;
//                }
//                case '\t': {
//                    sb.append("\\t");
//                    break;
//                }
//                case '\r': {
//                    sb.append("\\r");
//                    break;
//                }
//                default: {
//                    sb.append(c);
//                }
//            }
//        }
//        sb.append("\"");
//        return sb.toString();
//    }
//
//    //traiter les \\
//    private static long parseLong(String value) {
//        if (value.startsWith("0x")) {
//            return (Long.parseLong(value.substring(2), 16));
//        } else {
//            return (Long.parseLong(value, 10));
//        }
//    }
//
//    private static int parseInt(String value) {
//        if (value.startsWith("0x")) {
//            return (Integer.parseInt(value.substring(2), 16));
//        } else {
//            return (Integer.parseInt(value, 10));
//        }
//    }
//
//    private static byte parseByte(String value) {
//        if (value.startsWith("0x")) {
//            return (Byte.parseByte(value.substring(2), 16));
//        } else {
//            return (Byte.parseByte(value, 10));
//        }
//    }
//
//    private static enum TokenType {
//        WORD,
//        STRING_LITTERAL,
//        CHAR_LITTERAL,
//    }
//
//    private static class Token {
//        String value;
//        TokenType type;
//
//        private Token(String value, TokenType type) {
//            this.value = value;
//            this.type = type;
//        }
//    }
//
//    private static Token[] split(String value, int lineCount) throws KDefinitionParseException {
//        ArrayList<Token> all = new ArrayList<Token>();
//        StringBuilder sb = new StringBuilder();
//        int max = value.length();
//        int i = 0;
//        while (i < max) {
//            char c = value.charAt(i);
//            switch (c) {
//                case '\"': {
//                    i++;
//                    if (i >= max) {
//                        throw new KDefinitionParseException("expected a character", lineCount, i);
//                    }
//                    loopChars:
//                    while (i < max) {
//                        c = value.charAt(i);
//                        if (c == '\\') {
//                            i++;
//                            if (i >= max) {
//                                throw new KDefinitionParseException("expected a character", lineCount, i);
//                            }
//                            c = value.charAt(i);
//                            switch (c) {
//                                case 't': {
//                                    sb.append("\t");
//                                    break;
//                                }
//                                case 'n': {
//                                    sb.append("\n");
//                                    break;
//                                }
//                                case 'f': {
//                                    sb.append("\f");
//                                    break;
//                                }
//                                case 'b': {
//                                    sb.append("\b");
//                                    break;
//                                }
//                                case 'r': {
//                                    sb.append("\r");
//                                    break;
//                                }
//                                default: {
//                                    if (c >= '\60' && c <= '\67') {
//                                        int escape = c - '0';
//                                        i++;
//                                        if (i >= max) {
//                                            sb.append((char) escape);
//                                            break;
//                                        }
//                                        c = value.charAt(i);
//                                        if (c >= '\60' && c <= '\67') {
//                                            escape = escape << 3;
//                                            escape = escape | (c - '0');
//
//                                            i++;
//                                            if (i >= max) {
//                                                sb.append((char) escape);
//                                                break;
//                                            }
//                                            c = value.charAt(i);
//                                            if (c >= '\60' && c <= '\67') {
//                                                escape = escape << 3;
//                                                escape = escape | (c - '0');
//                                            } else {
//                                                i--;
//                                            }
//                                        } else {
//                                            i--;
//                                        }
//                                        sb.append((char) escape);
//                                    } else {
//                                        sb.append(c);
//                                    }
//                                }
//                            }
//                        } else if (c == '\"') {
//                            String s = sb.toString();
//                            all.add(new Token(s, TokenType.STRING_LITTERAL));
//                            sb.delete(0, sb.length());
//                            break loopChars;
//                        } else {
//                            sb.append(c);
//                        }
//                        i++;
//                    }
//                    if (sb.length() != 0) {
//                        throw new KDefinitionParseException("String not closed", lineCount, i);
//                    }
//                    break;
//                }
//                case '\'': {
//                    i++;
//                    if (i >= max) {
//                        throw new KDefinitionParseException("expected a character", lineCount, i);
//                    }
//                    loopChars:
//                    while (i < max) {
//                        c = value.charAt(i);
//                        if (c == '\\') {
//                            i++;
//                            if (i >= max) {
//                                throw new KDefinitionParseException("expected a character", lineCount, i);
//                            }
//                            c = value.charAt(i);
//                            switch (c) {
//                                case 't': {
//                                    sb.append("\t");
//                                    break;
//                                }
//                                case 'n': {
//                                    sb.append("\n");
//                                    break;
//                                }
//                                case 'f': {
//                                    sb.append("\f");
//                                    break;
//                                }
//                                case 'b': {
//                                    sb.append("\b");
//                                    break;
//                                }
//                                case 'r': {
//                                    sb.append("\r");
//                                    break;
//                                }
//                                default: {
//                                    if (c >= '\60' && c <= '\67') {
//                                        int escape = c - '0';
//                                        i++;
//                                        if (i >= max) {
//                                            sb.append((char) escape);
//                                            break;
//                                        }
//                                        c = value.charAt(i);
//                                        if (c >= '\60' && c <= '\67') {
//                                            escape = escape << 3;
//                                            escape = escape | (c - '0');
//
//                                            i++;
//                                            if (i >= max) {
//                                                sb.append((char) escape);
//                                                break;
//                                            }
//                                            c = value.charAt(i);
//                                            if (c >= '\60' && c <= '\67') {
//                                                escape = escape << 3;
//                                                escape = escape | (c - '0');
//                                            } else {
//                                                i--;
//                                            }
//                                        } else {
//                                            i--;
//                                        }
//                                        sb.append((char) escape);
//                                    } else {
//                                        sb.append(c);
//                                    }
//                                }
//                            }
//                        } else if (c == '\'') {
//                            String s = sb.toString();
//                            if (s.length() != 1) {
//                                throw new KDefinitionParseException("Expected a character", lineCount, i);
//                            }
//                            all.add(new Token(s, TokenType.CHAR_LITTERAL));
//                            sb.delete(0, sb.length());
//                            break loopChars;
//                        } else {
//                            sb.append(c);
//                        }
//                        i++;
//                    }
//                    if (sb.length() != 0) {
//                        throw new KDefinitionParseException("String not closed", lineCount, i);
//                    }
//                    break;
//                }
//                case '/': {
//                    if (i < (max - 1)) {
//                        if (value.charAt(i + 1) == '/') {
//                            //ignore all remaining
//                            i = max + 1;
//                        } else if (value.charAt(i + 1) == '*') {
//                            i++;
//                            i++;
//                            while (i < max) {
//                                c = value.charAt(i);
//                                if (c == '*' && i < (max - 1) && value.charAt(i + 1) == '/') {
//                                    i++;
//                                    break;
//                                }
//                                i++;
//                            }
//                        } else {
//                            sb.append(c);
//                        }
//                    } else {
//                        sb.append(c);
//                    }
//                    break;
//                }
//                case '#': {
//                    //ignore all remaining
//                    i = max + 1;
//                    break;
//                }
//                default: {
//                    if (Character.isWhitespace(c)) {
//                        if (sb.length() > 0) {
//                            all.add(new Token(sb.toString(), TokenType.WORD));
//                            sb.delete(0, sb.length());
//                        }
//                        //ignore
//                    } else {
//                        sb.append(c);
//                    }
//                    break;
//                }
//            }
//            i++;
//        }
//        if (sb.length() > 0) {
//            all.add(new Token(sb.toString(), TokenType.WORD));
//        }
//        return all.toArray(new Token[all.size()]);
//    }
//
//}