pipeline {
  
  agent any
  
  environment {
    TEST_CREDENTIALS = credentials('pipeline-id')
  }
  
  stages {
    
    stage("build") {
      
      steps {
        echo 'building the application...'
        echo "credentials ${TEST_CREDENTIALS}"
      }
    }
    
    stage("test") {
      when {
        expression {
          env.BRANCH_NAME == 'main'
        }
      }
      steps {
        echo 'testing the application..'
      }
    }
    
    stage("deploy") {
      
      steps {
        echo 'deploying the applications'
        withCredentials([
          usernamePassword(credentials: 'pipeline-id', usernameVariable: USER, passwordVariable: PWD)
        ]) {
          sh "some script ${USER} ${PWD}"
        }
      }
    }
  }
}
