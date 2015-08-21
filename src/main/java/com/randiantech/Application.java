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
public class Application {

    /* Error Message Builder */
    private static ErrorMessageBuilder errorMessageBuilder = new ErrorMessageBuilder();
    
    /* Connections Map */
    private static Map<DatabaseType, Connection> connections = new HashMap<DatabaseType, Connection>();


    /**
     * Starts HTTP Server
     * @throws Exception
     */
    private void startHttpServer() throws Exception {
        Integer applicationPort = HttpServerConfiguration.getApplicationPort(null);
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

    private void registerDatabaseConnections(DatabaseType databaseType) throws Exception {
        connections.put(databaseType, databaseType.getConnection(null));
    }

    public void start() throws Exception {
        startHttpServer();
    }

    public static ErrorMessageBuilder getErrorMessageBuilder() {
        return errorMessageBuilder;
    }

    public static void setErrorMessageBuilder(ErrorMessageBuilder errorMessageBuilder) {
        Application.errorMessageBuilder = errorMessageBuilder;
    }

    public static Map<DatabaseType, Connection> getConnections() {
        return connections;
    }
}
