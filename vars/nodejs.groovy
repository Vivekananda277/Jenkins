def call(String COMPONENT){
  pipeline{
    agent {
      node {
        label "NODEJS"
      }
    }
    stages{

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
      stage('Prepare Artifacts'){
        steps {
          sh '''
        cd static
        zip -r ${COMPONENT}.zip *
        '''
        }
      }
      stage('Publish Artifacts'){
        steps {
          echo 'Publish Artifacts'
        }
      }
    }

    post {
      always {
        cleanWs()
      }
    }
  }


}