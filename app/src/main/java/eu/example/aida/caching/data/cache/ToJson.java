package eu.example.aida.caching.data.cache;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Aida on 1/21/2019.
 */

public class ToJson
{
    private Gson gson;

    public ToJson()
    {
        this.gson=new Gson();
    }

    public String serialzation(Object o,Class aClass)
    {
        return gson.toJson(o,aClass);
    }

    public <T> T deSerialzation(String s,Class<T> aClass)
    {
        return gson.fromJson(s,aClass);
    }

    public <T> T deSerial_Type(String s,Class<T> aClass)
    {
        Type type=new TypeToken<T>(){}.getType();
        return gson.fromJson(s,type);
    }
}
