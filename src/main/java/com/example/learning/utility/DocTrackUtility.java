package com.example.learning.utility;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class DocTrackUtility {

    public static <T> void setFields(T fromObject, T toObject) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] fields = fromObject.getClass().getDeclaredFields();
        for(Field f : fields){
            if(Objects.nonNull(callGetter(f.getName(), fromObject))) {
                callSetter(toObject, f.getName(), callGetter(f.getName(), fromObject));
            }
        }
    }

    public static Object callGetter(String fieldName, Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd = new PropertyDescriptor(fieldName, obj.getClass());
        return pd.getReadMethod().invoke(obj);
    }

    public static void callSetter(Object obj, String fieldName, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd = new PropertyDescriptor(fieldName, obj.getClass());
        pd.getWriteMethod().invoke(obj, value);
    }
}
