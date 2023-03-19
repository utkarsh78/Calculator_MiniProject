pipeline {
    environment{
        dockerimg = ""
    }
    agent any

    stages {
        stage('Clone Git') {
            steps {
                git 'https://github.com/utkarsh78/Calculator_MiniProject.git'
            }
        }
        
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Docker') {
            steps {
                script {
                    dockerimg = docker.build "utkarsh67/dockerimage_calminipro:latest"
                }
            }
        }
        
        stage('Push Docker Image'){
            steps {
                script {
                    docker.withRegistry('','DockerID'){
                        dockerimg.push()
                    }
                }
            }
        }
        
        stage('Delete Docker Image'){
            steps {
                script {
                    sh 'docker image rm -f utkarsh67/dockerimage_calminipro'
                }
            }
        }
        
        stage('Pull Docker Image to Ansible User'){
            steps {
                //ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, inventory: 'inventory', playbook: 'calminipro.yml'
                ansiblePlaybook credentialsId: 'InventoryID', inventory: 'inventory', playbook: 'calminipro.yml'
                
            }
        }
    }
}
