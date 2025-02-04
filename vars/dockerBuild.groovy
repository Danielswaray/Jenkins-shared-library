def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh """
        docker build \
        --build-arg REACT_APP_RAPID_API_KEY=77c79b7207msh3fcea28d5e8f0dfp1974fbjsn395660057497 \
        -t ${imageName} .
    """
    
    // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    
    // Push the Docker image
    withDockerRegistry ([url: 'https://index.docker.io/v1/', credentialsId: 'Danielswaray']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
