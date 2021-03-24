FROM tomcat:9.0.24

COPY /rest/target/auth.war /usr/local/tomcat/webapps/auth.war