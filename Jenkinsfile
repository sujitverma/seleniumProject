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
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                git url: 'https://github.com/sujitverma/seleniumProject'
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
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
