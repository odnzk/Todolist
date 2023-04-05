FROM tomcat:8.0.20-jre8
COPY target/SemesterProject.war /usr/local/tomcat/webapps/SemesterProject.war
