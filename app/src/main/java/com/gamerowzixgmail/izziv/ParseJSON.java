package com.gamerowzixgmail.izziv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rowzica on 23.1.2016.
 */
public class ParseJSON {



    public static String overview;
    public static String runtime;
    public static String revenue;
    public static String vote_average;
    public static String vote_count;
    public static String original_title;
    public static String release_date;

    public static final String JSON_RUNTIME = "runtime";
    public static final String JSON_VOTE_COUNT = "vote_count";
    public static final String JSON_VOTE_AVERAGE = "vote_average";
    public static final String JSON_ORIGINAL_TITLE = "original_title";
    public static final String JSON_OVERVIEW = "overview";
    public static final String JSON_RELEASE_DATE = "release_date";
    public static final String JSON_REVENUE = "revenue";

    public static final String JSON_ARRAY = "production_companies";

    String tmp1,tmp2,tmp3,tmp4,tmp5,tmp6,tmp7;


    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            JSONObject object = new JSONObject(json);
            tmp1 = object.getString(JSON_ORIGINAL_TITLE);
            JSONObject object2 = new JSONObject(json);
            tmp2 = object2.getString(JSON_RUNTIME);
            tmp3 = jsonObject.getString(JSON_OVERVIEW);
            tmp4 = jsonObject.getString(JSON_RELEASE_DATE);
            tmp5 = jsonObject.getString(JSON_REVENUE);
            tmp6 = jsonObject.getString(JSON_VOTE_COUNT);
            tmp7 = jsonObject.getString(JSON_VOTE_AVERAGE);


            original_title=tmp1;
            runtime=tmp2;
            overview=tmp3;
            release_date=tmp4;
            revenue=tmp5;
            vote_count=tmp6;
            vote_average=tmp7;
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
