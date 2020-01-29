# cockroach-demo

This is the 'cockroach-demo' micro service.

## Building

Run `./gradlew build`

## Testing

### Running with Docker Compose
Run: ` docker-compose up --build cockroach-demo`

UI is available at: http://localhost:8080/cockroach-demo/ui

### Serving UI separately

The UI can be served with `./gradlew npm_start` (depending on which build tool is used)

It will be available at: Open UI: http://localhost:4200/cockroach-demo/ui

Note: Ideally, you should use the same Node version that is used by Gradle. So, if you prefer
to run `npm`, `node` or `ng` directly, set up your `PATH` like this:

`export PATH=node_modules/.bin:.gradle/nodejs/node-v10.16.2-linux-x64/bin`

Adapt the path according to what's in your `.gradle` folder.

## Health Check

Access the health check endpoint at `http://localhost:8080/health`

## OpenAPI

Access the OpenAPI description at `http://localhost:8080/openapi`
