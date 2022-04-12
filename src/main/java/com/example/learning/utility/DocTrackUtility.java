package com.example.learning.utility;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class DocTrackUtility {

    public static <T> void setFieldsFromRequest(T request, T availableInDB) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] fields = request.getClass().getDeclaredFields();
        for(Field f : fields){
            if(Objects.nonNull(callGetter(f.getName(), request))) {
                callSetter(availableInDB, f.getName(), callGetter(f.getName(), request));
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
