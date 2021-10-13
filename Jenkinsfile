pipeline {
    agent any

    environment {
//        SAMPLE_URL="www.google.com"
//        SLACK_TOKEN=credentials('slack')
        //   }
        stages {
            stage('one') {
                steps {
                    sh 'echo Hello World'
                    sh 'echo ${SAMPLE_URL}'
                    sh 'echo ${SLACK_TOKEN}'
                }
            }
            stage('two') {
                steps {
                    //    slackSend channel: '#nothing', message: 'Hello'
                    //    slackSend channel: '#nothing', message: 'Nothing'
                }
            }
        }
    }
}