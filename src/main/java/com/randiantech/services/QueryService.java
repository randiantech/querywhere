package com.randiantech.services;

import com.randiantech.Application;
import com.randiantech.DatabaseType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Juan Carlos Cancela <juan.cancela@randiantech.com>
 */
@Path("/query")
public class QueryService
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getMsg(@QueryParam("query") String query, @QueryParam("db") String db, @QueryParam("table") String table)
    {
        try
        {
            JSONObject response = new JSONObject();
            JSONArray resultList = new JSONArray();
            Connection connection = Application.getConnections().get(DatabaseType.valueOf(db));
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery(query);
            response.put("query", query);
            while( resultSet.next() ){
                String result = "";
                int columnPosition = 1;
                String row = "";
                while(columnPosition != 15){
                    result = resultSet.getString(columnPosition);
                    if(result != null){
                        row += result + "|";
                    } else {
                        resultList.add(row);
                    }
                    columnPosition++;
                }
            }
            response.put("result", resultList);

            resultSet.close() ;
            statement.close() ;

            return Response.status(200).entity(response.toJSONString()).build();
        }
        catch (Exception e)
        {
            return Response.status(500).entity(e).build();
        }
    }
}
