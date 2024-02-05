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
        stage ("Docker-Build") {
            steps {
                sh "Docker build -t ash2code/todo-list ."
            }
        } 
        stage ("Docker-Run") {
            steps {
                sh "Docker container run -dt -p 8085:8080 --name todo ash2code/todo-list"
            }
        }
    }
}
