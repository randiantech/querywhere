package com.randiantech.value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleList{
    private List<Tuple> properties = new ArrayList<Tuple>();

    public Map<String, String> toMap(){
        Map<String, String> map = new HashMap<String, String>();

        for(Tuple property : properties){
            map.put(property.getKey(), property.getValue());
        }

        return map;
    }

    public List<Tuple> getProperties()
    {
        return properties;
    }

    public void setProperties(List<Tuple> properties)
    {
        this.properties = properties;
    }
}


/**
 * Created by juan on 02/06/15.
 */
class Tuple
{
    private String key;

    private String value;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
