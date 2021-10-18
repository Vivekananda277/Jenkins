def call(String COMPONENT){
  pipeline{
    agent {
      node {
        label "NODEJS"
      }
    }
    environment{
      SONAR_TOKEN = credentials('SONAR_TOKEN')
    }
    stages{

      stage('Submit Code'){
        steps {
          sh """
             # sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.31.141:9000 -Dsonar.login=${SONAR_TOKEN}
             echo Submit
         """
        }
      }
      stage('Check Code Quality'){
        steps {
          echo 'Code Quality'
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