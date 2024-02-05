# Use the official Tomcat image as the base image
FROM tomcat:latest

# Copy the .war file from the Jenkins workspace to the Tomcat webapps directory
COPY /var/lib/jenkins/workspace/java-docker-pipeline/target/*.war /usr/local/tomcat/webapps/
