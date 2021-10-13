pipeline{
    agent any
    stages{

        stage('one'){
            steps{
                sh 'echo Hello World'
                slackSend channel: '#nothing', message: 'Hello'
            }
        }
    }
}