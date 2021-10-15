def call(){
  pipeline{
    agent {
      node {
        label 'NODEJS'
      }
    }

  stages{
    stage('Compile'){
      steps {
        echo 'Nothing to do for compilation'
      }
    }
    stage('Check Code Quality'){
      steps {
        echo 'Code quality'
      }
    }
    stage('Lint checks'){
      steps {
        echo 'Lint checks'
      }
    }
    stage('Unit Tests'){
      steps {
        echo 'Unit tests'
      }
    }
    stage('Prepare Artifacts'){
      steps {
        sh '''
        cd static
        zip -r frontend.zip
        '''
      }
    }
    stage('Publish Artifacts'){
      steps {
        echo 'Publish Artifacts'
      }
    }
  }
  }
}
