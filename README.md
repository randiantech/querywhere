## Application Prerequisites

In order to get application up and running, it is required:

* OpenJDK 1.8

* Apache Maven 3.0.5 (http://maven.apache.org/)
** How to install: Execute `apt-get install maven` (Debian|Ubuntu)
                   Execute `yum install maven` (Fedora|Centos|RedHat)


## Application installation

To run application, execute:

* `mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.3.0 -Dpackaging=jar -Dfile=driver/oracle/ojdbc14.jar -DgeneratePom=true` on application root path
* `mvn clean install` on application root path
* `mvn compile exec:java` on application root path, where
** APP_PORT : The port where application will be executed. By default, 8080
** DB_CONNECTIONS : JSON object containing as key value of DatabaseType (in example, ORACLE_10), and connection properties (required properties are defined in DatabaseType).

Example:

Suppose I want to connect to an Oracle 10 instance, i would execute:


curl -X POST -d @./test/integration/oracle_test_connection.json -H "Accept: application/json" -H "Content-Type: application/json" http://localhost:8080/api/connect/ORACLE_10

curl "http://localhost:8080/api/query?query=lala&db=ORACLE_10&table=AAA"

