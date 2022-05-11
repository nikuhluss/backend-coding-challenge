package com.heb.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "H-E-B backend",
                version = "1.0.0",
                description = "Backend assessment to interact with customer data",
                contact = @Contact(
                        url = "https://www.linkedin.com/in/nicholas-j-scott/",
                        name = "Nicholas Scott",
                        email = "nikuhluss@gmail.com"
                )
        )
)
public class OpenApiDefinition {
}
