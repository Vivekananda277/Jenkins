def call(String AGENT){
  pipeline{
    agent {
      node {
        label "${AGENT}"
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
          echo 'Unit Tests'
        }
      }
      stage('Prepare Artifaacts'){
        steps {
          sh '''
        cd static
        zip -r frontend.zip *
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