/** 
    *Author: Juan José Solorzano Carrillo
    *Date: 2024-09-30
    *Description: This is a declarative pipeline script that will clone a repository, run a python script and log
                  the output of the git log command.
    *The script will run on any available agent.
*/

pipeline{
    agent any
    environment{
        GIT_REPO = 'git@github.com:JuanJoseSoloraznoCarrillo/JenkinsRepository.git'
        GIT_BRANCH = 'master'
        GIT_USER = 'Jenkins CT'
        GIT_MAIL = 'Jenkins@example.com'
        REPO_NAME = 'Jenkins'
    }
    stages{
        stage('Check If Repo Exists'){
            steps{
                sh """
                    if [ -d ${REPO_NAME} ]; then
                        rm -fr ${REPO_NAME}
                    fi
                """
            }
        }
        stage('Clone Repository'){
            steps{
                sh """
                    git clone -b ${GIT_BRANCH} ${GIT_REPO}
                    cd ${REPO_NAME}
                    git log --oneline
                """
            }
        }
        stage('Run Python Script'){
            steps{
                sh """
                    cd ${REPO_NAME} 
                    python3 run_suite.py
                """
            }
        }
    }
}