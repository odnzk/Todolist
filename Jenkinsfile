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
    }
}
