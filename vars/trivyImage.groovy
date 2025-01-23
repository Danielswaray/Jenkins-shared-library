def call() {
    sh 'trivy image Danielswaray/youtube:latest > trivyimage.txt'
}