## README for OpenTelemetry trace example controller

This repository contains a simple Spring Boot application demonstrating the use of OpenTelemetry for distributed tracing.

### Functionality

The `controller` class exposes a `/trace` endpoint that creates a new OpenTelemetry trace with two spans:

- **Root span:** Named "root-span" with an attribute "root-attribute".
- **Child span:** Named "child-span" with an attribute "child-attribute" and simulated work with a 500ms sleep.

The root span also performs simulated work with a 1000ms sleep before ending both spans.

### Prerequisites

* Java 11+
* Maven
* OpenTelemetry SDK

### Running the application

1. Clone the repository and build the application using `mvn clean package`.
2. Run the application using `java -jar target/otlp-example-0.1.0.jar`.
3. Open http://localhost:8080/trace in your browser to create a trace.

### OpenTelemetry configuration

This application uses dependency injection to obtain the `OpenTelemetry` instance injected by Spring Boot. No additional configuration is necessary.

### Viewing traces

The generated traces can be viewed in any OpenTelemetry backend compatible with the collector used (e.g., Zipkin, Jaeger). 

### Notes

* This is a simple example and only demonstrates basic OpenTelemetry usage.
* Further configuration and instrumentation can be implemented for real-world scenarios.

### Contributing

Pull requests and suggestions are welcome. Please follow standard Git conventions and contribute tests for any changes made.


I hope this provides a concise and informative readme for your code. Feel free to adjust it further to match your specific project needs.
