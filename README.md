# Jenkins Pipeline Project

## Overview

This project contains a Jenkins declarative pipeline script that automates the process of cloning a Git repository, running a Python script, and logging the output of the `git log` command. The pipeline is designed to run on any available Jenkins agent.

## Description

The pipeline script `pipeline.groovy` performs the following tasks:
1. Checks if the repository directory exists and removes it if it does.
2. Clones the specified Git repository and logs the commit history.
3. Runs a Python script (`run_suite.py`) located in the cloned repository.

## Pipeline Stages

### 1. Check If Repo Exists

This stage checks if the repository directory exists and removes it if it does.

```groovy
stage('Check If Repo Exists'){
    steps{
        sh """
            if [ -d ${REPO_NAME} ]; then
                rm -fr ${REPO_NAME}
            fi
        """
    }
}