package com.randiantech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Enums the different types of supported databases
 *
 * @author Juan Carlos Cancela <juan.cancela@randiantech.com>
 */
public enum DatabaseType
{

    /**
     * ORACLE_10
     */
    ORACLE_10(1)
            {
                List<String> oracleProperties = Arrays.asList("USERNAME", "PASSWORD", "HOST", "PORT", "SERVICENAME");
                public Connection getConnection(Map<String, String> properties) throws Exception
                {
                    validateAllRequiredPropertiesAreProvided(oracleProperties, properties);
                    String oracleConnectionString = "jdbc:oracle:thin:" + properties.get("USERNAME") + "/" + properties.get("PASSWORD") + "@//" + properties.get("HOST") + ":" + properties.get("PORT") + "/" + properties.get("SERVICENAME");
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    return DriverManager.getConnection(oracleConnectionString);
                }
            };

    /**
     * The file type value
     */
    @SuppressWarnings("unused")
    private int value;

    /**
     * Validates that all the required properties to establish the database services are provided
     */
    public void validateAllRequiredPropertiesAreProvided(List<String> requiredProperties, Map<String, String> providedProperties) throws Exception
    {
        for (String requiredProperty : requiredProperties)
        {
            if (providedProperties.get(requiredProperty) == null)
            {
                throw new Error("Missed Property: " + requiredProperty);
            }
        }
    }

    public abstract Connection getConnection(Map<String, String> properties) throws Exception;

    /**
     * The database type
     *
     * @param value the value
     */
    private DatabaseType(int value)
    {
        this.value = value;
    }

}
