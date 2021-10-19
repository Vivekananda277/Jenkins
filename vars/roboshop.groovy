def call(String AGENT,String COMPONENT){
  pipeline{
    agent {
      node {
        label "${AGENT}"
      }
    }

    stages{
      stage('Compile'){
        when{
          anyOf{
            expression{ COMPONENT == 'JAVA'}
          }
        }
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