FROM tomcat:8.0.20-jre8
COPY target/Todolist.war /usr/local/tomcat/webapps/Todolist.war
