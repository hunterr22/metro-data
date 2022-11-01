node {
    stage('Checkout DataService') {
        git branch: 'main', url: 'https://github.com/hunterr22/metro-data.git'
    }


    stage('Gradle Build - DataService') {
        sh './gradlew clean build -Dorg.gradle.java.home=//usr/lib/jvm/java-11-openjdk-amd64'
    }

    stage('Gradle Bootjar-Package - DataService') {
        sh './gradlew bootjar -Dorg.gradle.java.home=//usr/lib/jvm/java-11-openjdk-amd64'
    }

    stage('Containerize the app-docker build - DataService') {
        sh 'docker build --rm -t event-data:v1.0 .'
    }

    stage('Inspect the docker image - DataService') {
        sh 'docker images event-data:v1.0'
        sh 'docker inspect event-data:v1.0'
    }

    stage('Run Docker container instance - DataService') {
        sh 'docker run -d --rm --name event-data -p 8080:8080 event-data:v1.0'
    }

    stage('User Acceptance Test - DataService') {
    
        def response= input message: 'Is this build good to go?',
            parameters: [choice(choices: 'Yes\nNo',
            description: '', name: 'Pass')]
        
        if(response=="Yes") {
            stage('Deploy to Kuberenetes cluster - DataService') {
                sh 'kubectl create deployment event-data --image=event-data:v1.0'
                sh 'kubectl expose deployment event-data --type=LoadBalancer --port=8080'
            }
        }
    }

    stage('Production Deployment View') {
        sh 'kubectl get deployments'
        sh 'kubectl get pods'
        sh 'kubectl get services'
    }
}