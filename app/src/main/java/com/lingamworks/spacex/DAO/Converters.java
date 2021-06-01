package com.lingamworks.spacex.DAO;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converters {

    @TypeConverter
    public  String fromlauncheslist(List<String> value){
        if(value==null){
            return (null);
        }
        Gson gson=new Gson();
        String json=gson.toJson(value);
        return json;
    }
    @TypeConverter
    public static List<String> stringtolist(String data){
        if(data==null){
            return null;
        }
        Gson gson=new Gson();
        Type listType=new TypeToken<List<String>>(){}.getType();
        return gson.fromJson(data,listType);
    }


}
