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

    stage('User Acceptance Test - DataService') {
    
        def response= input message: 'Is this build good to go?',
            parameters: [choice(choices: 'Yes\nNo',
            description: '', name: 'Pass')]
        
        if(response=="Yes") {
            stage('Release - DataService') {
            sh './gradlew build -x test -Dorg.gradle.java.home=//usr/lib/jvm/java-11-openjdk-amd64'
            sh 'echo DataService is ready to release'
            }
        }
    }
}