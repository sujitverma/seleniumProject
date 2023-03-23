pipeline {
    agent any

    tools {
        maven 'maven'
    }
    
    stages {
        stage('Build Core Framework') {
            steps {
                build 'Core-Framework'
            }
        }
        stage('docker-compose') {
           steps {
              sh "docker-compose build"
              sh "docker-compose -f docker-compose-v3.yml up"
           }
       }
        stage('Test') {
            steps {
                git url: 'https://github.com/sujitverma/seleniumProject'
                sh "mvn -Dmaven.test.failure.ignore=false clean test"
            }
            post {
                always {
                    archiveArtifacts 'target/*.jar'
                }
                success{
                    junit '**/target/*.xml'
                }
            }
        }
    }
}
