package com.example.otlp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
@Configuration
public class beans {
	
	
	
	

	  @Bean
	  public OpenTelemetry openTelemetry() {
	    return OpenTelemetrySdk.builder().build();
	  }
	}

