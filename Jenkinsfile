pipeline {
  
  agent any
  
  stages {
    
    stage("build") {
      
      steps {
        echo 'building the application...'
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
      }
    }
  }
}
