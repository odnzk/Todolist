pipeline {
    agent any 

    stages {
        stage("Checkout") {
            steps {
                git branch: 'master', 
                url: 'https://github.com/ash2code/Todolist.git'
            }

        }
        stage("Build") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Test") {
            steps {
                sh "mvn test"
            }
        }
        stage("Package") {
            steps {
                sh "mvn package"
            }
        }
       stage("Deploy") {
            steps {
                sshagent(['deploy_user']) {
                    sh "scp -o StrictHostKeyChecking=no java-mvn-tomcat9-job/target/SemesterProject.war ubuntu@172.31.34.101:/opt/apache-tomcat-9.0.65/webapps"
                }
            }
        }
    }
}
