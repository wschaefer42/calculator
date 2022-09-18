pipeline {
     agent any
     triggers {     
          pollSCM('1 * * * *')
     }
     post {
          always {
               mail to: 'laron.dooley@ethereal.email',
               subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
               body: "Your build completed, please check: ${env.BUILD_URL}"
          }
     }
     stages {
          stage("Compile") {
               steps {
                    sh "./gradlew compileJava"
               }
          }

          stage("Unit test") {
               steps {
                    sh "./gradlew test"
               }
          }
          stage("Code coverage") {
                steps {
                    sh "./gradlew jacocoTestReport"
                       publishHTML (target: [
                                   reportDir: 'build/reports/jacoco/test/html',
                                   reportFiles: 'index.html',
                                   reportName: "JaCoCo Report"                  
                              ])
                    sh "./gradlew jacocoTestCoverageVerification"
                }
          }
          stage("Static code analysis") {
                steps {
                    sh "./gradlew checkstyleMain"
                        publishHTML (target: [
                             reportDir: 'build/reports/checkstyle/',
                             reportFiles: 'main.html',
                             reportName: "Checkstyle Report"
                        ])
                }
          }
        /*           
        stage('SonarQube Analysis') {
                steps {
                    withSonarQubeEnv("SonarQube") {
                        sh "./gradlew sonarqube"
                    }
                }
          } 
          */
          stage('SonarQube Analysis') {
                steps {
                    withSonarQubeEnv("SonarQube") {
                        sh "./gradlew sonarqube \
                          -Dsonar.projectKey=calculator \
                          -Dsonar.host.url=http://localhost:9000 \
                          -Dsonar.login=sqa_33888846615f1d09342ccfde6ea499c3900c3ea3"
                    }
                }
          }

     }
}