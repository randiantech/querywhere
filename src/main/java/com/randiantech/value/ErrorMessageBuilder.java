package com.randiantech.value;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by juan on 26/05/15.
 */
public class ErrorMessageBuilder
{
    private static String ERROR_KEY = "error";
    private Gson gson = new Gson();

    public String build(String errorMessage)
    {
        Map<String, String> errorTuple = new HashMap<String, String>();
        errorTuple.put(ERROR_KEY, errorMessage);
        return gson.toJson(errorTuple);
    }
}
