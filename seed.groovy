folder('CI-Pipelines') {
  displayName('CI-Pipelines')
  description('CI-Pipelines')
}

def component= ["cart", "catalogue", "user", "shipping", "frontend", "payment"]

def count = (component.size() -1 )

 for(int i in 0..count) {
   def j = component[i]
   pipelineJob("CI-Pipelines/${j}") {
     configure { flowdefinition ->
       flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
         'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
           'userRemoteConfigs' {
             'hudson.plugins.git.UserRemoteConfig' {
               'url'("https://vivekanandareddy544@dev.azure.com/vivekanandareddy544/Roboshop/_git/${j}")
               'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
             }
           }
           'branches' {
             'hudson.plugins.git.BranchSpec' {
               'name'('*/tags/*')
             }
             'hudson.plugins.git.BranchSpec' {
               'name'('*/main')
             }
           }
         }
         'scriptPath'('Jenkinsfile')
         'lightweight'(true)
       }
     }
   }
 }

folder('Mutable') {
  displayName('Mutable')
  description('Mutable')
}

pipelineJob('Mutable/vpc') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://vivekanandareddy544@dev.azure.com/vivekanandareddy544/Roboshop/_git/terraform-mutable')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/main')
          }
        }
      }
      'scriptPath'('vpc/Jenkinsfile')
      'lightweight'(true)
    }
  }
}

pipelineJob('Mutable/DB') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://vivekanandareddy544@dev.azure.com/vivekanandareddy544/Roboshop/_git/terraform-mutable')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/main')
          }
        }
      }
      'scriptPath'('databases/Jenkinsfile')
      'lightweight'(true)
    }
  }
}

for(int i in 0..count) {
  def j = component[i]
  pipelineJob("Mutable/${j}") {
    configure { flowdefinition ->
      flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
        'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'("https://vivekanandareddy544@dev.azure.com/vivekanandareddy544/Roboshop/_git/${j}")
              'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
            }
          }
          'branches' {
            'hudson.plugins.git.BranchSpec' {
              'name'('*/tags/*')
            }
            'hudson.plugins.git.BranchSpec' {
              'name'('*/main')
            }
          }
        }
        'scriptPath'('Jenkinsfile-infra')
        'lightweight'(true)
      }
    }
  }
}