/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs;

import java.util.Arrays;

/**
 *
 * @author vpc
 */
public class FieldStruct {

    private String className;
    private String fieldName;
    private TypeStruct type;

    public FieldStruct(Class className, String fieldName, TypeStruct type) {
        this.className = className.getName();
        this.fieldName = fieldName;
        this.type = type;
    }

    public String getClassName() {
        return className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public TypeStruct getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldStruct that = (FieldStruct) o;

        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = className != null ? className.hashCode() : 0;
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
