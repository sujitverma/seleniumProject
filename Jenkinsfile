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
                    stash includes: 'target/*.jar', name: 'test-automation-framework'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                unstash 'test-automation-framework'
                git credentialsId: '483c8655-bd6b-423f-903a-a4063a71124e', url: 'https://github.com/sujitverma/seleniumProject'
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
