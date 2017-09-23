## Steps to Run the App

## Tools used
Oracle 11g, Eclipse JEE, Wildfly Server.

# How To deploy

## Prerequisites
1. This is Java web application and Java Web application project is to be deployed on web server.
2. Install latest Eclipse JEE, Java, Oracle 11g and Wildfly Server in the operating system.


## To install, build and run, import the project
1. Install latest Eclipse JEE version, Java version, Oracle 11g version, Wildfly Server version.
2. Download the source code,unzip it and import the project.
3. Run the SQL statements given by database file.txt on your Oracle 11g.
4. After Importing the project in eclipse and add jar file in lib folder (which is in webinf folder).
5. Find the dbutil.java located at Java Resources/src/com.nineleaps.dbutil/dbUtil.java.
6. Change the properties according to Oracle 11g database server connectivity. 
7. Save the changes. 
8. Then deploy project in Wildfly Server by running it from index.jsp located in WebContent folder. 
9. Access the EmployeeDetails from http://localhost:8082/EmployeeDetails/index.jsp

For Oracle JDBC Connection, Please override properties entries in dbUtil.java as with your Oracle database connection as follows.

`driver=oracle.jdbc.driver.OracleDriverconnection.url=jdbc:oracle:thin:@DESKTOP-BM1A64V:1521:XE`
(NOTE : @DESKTOP-BM1A64V in my hostname and XE is my database name. Change it to your Oracle database name )

`username=system`
( NOTE : system is my Oracle user name. Change it to your oracle user name )

`password=system`
( NOTE : system is my Oracle password. Change it to your oracle password )


