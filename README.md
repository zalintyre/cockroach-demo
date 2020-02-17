# cockroach-demo

This is the 'cockroach-demo' micro service.

## Building

Run `./gradlew build`

### Kubernetes Deployment

A docker image can be built with `docker build -t cockroachdb src/main/docker`. Push the image to your favorite kubernetes cluster.

## Testing

### Running with Docker Compose
Run: ` docker-compose up --build cockroach-demo`

UI is available at: http://localhost:8080/cockroach-demo/ui

## Health Check

Access the health check endpoint at `http://localhost:8080/health`

## OpenAPI

Access the OpenAPI description at `http://localhost:8080/openapi`
