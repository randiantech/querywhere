package com.randiantech.services;

import com.randiantech.Application;
import com.randiantech.DatabaseType;
import com.randiantech.value.TupleList;
import org.codehaus.jackson.map.ObjectMapper;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

/**
 * @author Juan Carlos Cancela <juan.cancela@randiantech.com>
 */
@Path("/connect")
public class JdbcConnectionService
{
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{databaseName}")
    public Response getMsg(String connectionObject, @PathParam("databaseName") String databaseName)
    {
        try
        {
            TupleList propertyList = new ObjectMapper().readValue(connectionObject, TupleList.class);
            Connection connection = DatabaseType.valueOf(databaseName).getConnection(propertyList.toMap());
            Application.getConnections().put(databaseName, connection);
        }
        catch (Exception e)
        {
            return Response.status(500).entity(e).build();
        }
        return Response.status(201).build();
    }
}
