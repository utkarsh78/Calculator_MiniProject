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
//                     sh 'docker image rm -f utkarsh67/dockerimage_calminipro'
                    sh '''
                    # Get the IDs of all images with the tag <none>
                    NONE_IMAGES=$(docker images | grep "<none>" | awk '{print $3}')
                    # Delete all of the <none> images
                    
                    # Delete all of the containers associated with the <none> images
                    for IMAGE in $NONE_IMAGES
                    do
                      # Get the container IDs for the image
                      CONTAINER_IDS=$(docker ps -a | grep $IMAGE | awk '{print $1}')
                    # Remove the containers
                    for CONTAINER_ID in $CONTAINER_IDS
                    do
                        docker rm --force $CONTAINER_ID
                    done
                    
                    for IMAGE in $NONE_IMAGES
                    do
                      docker rmi --force $IMAGE
                    done
                   done
                '''
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
