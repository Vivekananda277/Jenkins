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
          sh """
             sonar-scanner -Dsonar.projectKey=sample -Dsonar.sources=. -Dsonar.host.url=http://172.31.31.141:9000                -Dsonar.login=17cd0356e039ed0f6fc3eeb48f1413b22461aba5
         """
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