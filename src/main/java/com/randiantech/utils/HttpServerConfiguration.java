package com.randiantech.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Provides configuration methods required to configure HTTP server
 * @author Juan Carlos Cancela <juan.cancela@randiantech.com>
 */
public class HttpServerConfiguration
{

    /**
     * Default port where application will be running
     */
    public static Integer DEFAULT_APPLICATION_PORT = 8080;

    /**
     * Default directory where web application files will be placed
     */
    public static String DEFAULT_WEB_APPLICATION_DIRECTORY = "src/main/webapp/";

    /**
     * Default path where web.xml file will be placed
     */
    public static String DEFAULT_WEB_XML_PATH = "/WEB-INF/web.xml";

    /**
     * Default path used as prefix to create application's path
     */
    public static String DEFAULT_CONTEXT_PATH = "/";

    /**
     * @param providedPort user provided port through command line execution
     * @return provided user port, of default one
     */
    public static Integer getApplicationPort(String providedPort)
    {
        if (StringUtils.isEmpty(providedPort))
        {
            return DEFAULT_APPLICATION_PORT;
        }
        else
        {
            return Integer.valueOf(providedPort);
        }
    }

    /**
     * @return directory where web application will be placed
     */
    public static String getWebApplicationDirectory()
    {
        return DEFAULT_WEB_APPLICATION_DIRECTORY;
    }

    /**
     * @return path where web.xml file is placed
     */
    public static String getApplicationDescriptorPath()
    {
        return getWebApplicationDirectory() + DEFAULT_WEB_XML_PATH;
    }

    /**
     * @return application context path (in example, if context path is "/something", then endpoints will be "/something/..."
     */
    public static String getContextPath()
    {
        return DEFAULT_CONTEXT_PATH;
    }
}
