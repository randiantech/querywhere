package com.randiantech;

/**
 * Main entry class used to fire up embedded Jetty server that contains the served application
 * @author Juan Carlos Cancela <juan.cancela@randiantech.com>
 */
public class Start
{
    /**
     * Starts Jetty server
     * @param args command line arguments (check README.md for configuration details)
     * @throws Exception if Jetty server bootstrap fails
     */
    public static void main(String[] args) throws Exception
    {
        Application app = new Application();
        app.start();
    }
}
