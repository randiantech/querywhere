package com.randiantech;

import com.randiantech.utils.HttpServerConfiguration;
import com.randiantech.value.ErrorMessageBuilder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Juan Carlos Cancela <juan.cancela@randiantech.com>
 */
public class Application
{

    /* Error Message Builder */
    private static ErrorMessageBuilder errorMessageBuilder = new ErrorMessageBuilder();
    
    /* Connections Map */
    private static Map<String, Connection> connections = new HashMap<String, Connection>();


    private void startHttpServer(String providedPort) throws Exception
    {
        Integer applicationPort = HttpServerConfiguration.getApplicationPort(providedPort);
        Server server = new Server(applicationPort);
        WebAppContext root = new WebAppContext();
        root.setContextPath(HttpServerConfiguration.getContextPath());
        root.setDescriptor(HttpServerConfiguration.getApplicationDescriptorPath());
        root.setResourceBase(HttpServerConfiguration.getWebApplicationDirectory());
        root.setParentLoaderPriority(true);
        server.setHandler(root);
        server.start();
        server.join();
    }

    private void registerDatabaseConnections(String databaseType){
            //connections.put(DatabaseType.valueOf(databaseType), DatabaseType.valueOf(databaseType).getConnection(null));
    }

    public void start(String providedPort) throws Exception{
        //registerDatabaseConnections(databaseType);
        startHttpServer(providedPort);
    }

    public static ErrorMessageBuilder getErrorMessageBuilder()
    {
        return errorMessageBuilder;
    }

    public static void setErrorMessageBuilder(ErrorMessageBuilder errorMessageBuilder)
    {
        Application.errorMessageBuilder = errorMessageBuilder;
    }

    public static Map<String, Connection> getConnections()
    {
        return connections;
    }
}
