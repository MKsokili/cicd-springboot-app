// pipeline {
//     agent any
//     tools{
//         maven 'maven_4_0_0'
//     }
//     stages{
//         stage('Build Maven'){
//             steps{
//                 checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MKsokili/cicd-springboot-app']]])
//                 sh 'mvn clean install'
//             }
//         }
//         stage('Build docker image'){
//             steps{
//                 script{
//                     sh 'docker build -t Jenkins-test-pipeline .'
//                 }
//             }
//         }
//         stage('Push image to Hub'){
//             steps{
//                 script{
//                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
//                    sh 'docker login -u javatechie -p ${dockerhubpwd}'

// }
//                    sh 'docker push javatechie/devops-integration'
//                 }
//             }
//         }
//         stage('Deploy to k8s'){
//             steps{
//                 script{
//                     kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
//                 }
//             }
//         }
//     }
// }

pipeline {
    agent any

    tools {
        maven 'maven3.9' 
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/MKsokili/cicd-springboot-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("cicd-pipeline-testimage:1.0")
                }
            }
        }
    }
    post {
    always {
        archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        cleanWs()
    }
}

}
