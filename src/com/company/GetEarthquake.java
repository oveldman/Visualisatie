package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import sun.invoke.empty.Empty;
import sun.misc.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Oscar on 5/9/2016.
 */
public class GetEarthquake {
    @SuppressWarnings("unchecked")
    public static ArrayList<Earthquake> main() {
        JSONParser parser = new JSONParser();
        ArrayList<Earthquake> earthquakeArrayList = new ArrayList<Earthquake>();
        try {

            Object obj = parser.parse(new FileReader(
                    "is.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String size = (String) jsonObject.get("size");
            //String author = (String) jsonObject.get("Author");
            JSONArray arr = (JSONArray) jsonObject.get("results");



            for(int i = 0; i < arr.size(); i++){
                JSONObject result = (JSONObject) arr.get(i);
                Earthquake thisEarthquake = (Earthquake) new Earthquake(Float.parseFloat(result.get("size").toString()), Float.parseFloat(result.get("depth").toString()), Float.parseFloat(result.get("quality").toString()),Float.parseFloat(result.get("latitude").toString()),Float.parseFloat(result.get("longitude").toString()), result.get("timestamp").toString(),result.get("humanReadableLocation").toString());
                earthquakeArrayList.add(thisEarthquake);
            }
            return earthquakeArrayList;
            //System.out.println("Author: " + author);
            //System.out.println("\nresults:");
//            Iterator<String> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (Exception e) {
            e.printStackTrace();
            return earthquakeArrayList;
        }
    }
}






