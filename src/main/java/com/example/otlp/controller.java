package com.example.otlp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerProvider;

@RestController
public class controller {
    @Autowired
    private final OpenTelemetry openTelemetry;

    public controller(OpenTelemetry openTelemetry) {
        this.openTelemetry = openTelemetry;
    }

    @GetMapping("/trace")
    public String trace() {
        // Create a new trace
        TracerProvider tracerProvider = openTelemetry.getTracerProvider();
        Tracer tracer = tracerProvider.get("my-tracer");

        // Start the root span (the first span in the trace)
        Span rootSpan = tracer.spanBuilder("root-span").startSpan();

        // Add attributes to the root span
        rootSpan.setAttribute("root-attribute", "root-value");

        // Start a child span
        Span childSpan = tracer.spanBuilder("child-span").startSpan();

        try {
            // Add attributes to the child span
            childSpan.setAttribute("child-attribute", "child-value");

            // Simulate some work within the child span
            doSomeWorkInChildSpan();

        } finally {
            // End the child span
            childSpan.end();
        }

        // Simulate some work in the root span
        doSomeWorkInRootSpan();

        // End the root span before returning
        rootSpan.end();

        return "Trace created!";
    }

    private void doSomeWorkInChildSpan() {
        // Simulate some work within the child span
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doSomeWorkInRootSpan() {
        // Simulate some work within the root span
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
