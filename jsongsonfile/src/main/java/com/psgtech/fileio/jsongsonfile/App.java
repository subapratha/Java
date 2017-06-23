package com.psgtech.fileio.jsongsonfile;

/**
 * Hello world!
 *
 */
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String,List<Map<String, String>>>>() {}.getType();
        Map<String,List<Map<String, String>> >map = gson.fromJson("f://21.json", mapType);
        System.out.println(map);

        Customers c = new Customers();

        c.setCustomers(map.get("Customers"));

        System.out.println(c.getCustomers());
    }
}
