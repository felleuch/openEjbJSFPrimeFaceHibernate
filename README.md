openEjbJSFPrimeFaceHibernate
============================

openEjb 4.6  &amp;&amp; primefaces 3.5 &amp;&amp; JSF 2.2  &amp;&amp; Hibernate 4 Tomee1.6


TO use this sample with wildfly-8

add mysql driver to server :

wildfly-8.0.0.Final\modules\system\layers\base\com\mysql\main


mysql-connector-java-5.1.17.jar
module.xml 


```xml

<?xml version="1.0" encoding="UTF-8"?>
 
<module xmlns="urn:jboss:module:1.0" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.1.17.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
  </dependencies>
</module>

```


modify this line on : persistance.xml

```xml
 <jta-data-source>java:jboss/datasources/myJtaDatabase</jta-data-source>
```

and add data source to configuration file :
wildfly-8.0.0.Final\standalone\configuration\standalone.xml

=============================================
```xml

<subsystem xmlns="urn:jboss:domain:datasources:2.0">
            <datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
                <datasource jta="true" jndi-name="java:jboss/datasources/myJtaDatabase" pool-name="myJtaDatabase_pool" enabled="true" use-java-context="true" use-ccm="true">
                    <connection-url>jdbc:mysql://localhost:3306/weatherinfo?autoReconnect=true</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                        <password>###</password>
                    </security>
                    <statement>
                        <prepared-statement-cache-size>100</prepared-statement-cache-size>
                        <share-prepared-statements>true</share-prepared-statements>
                    </statement>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="mysql" module="com.mysql"/>
                </drivers>
            </datasources>
        </subsystem>
        
```

