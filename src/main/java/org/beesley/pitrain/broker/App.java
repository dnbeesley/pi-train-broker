package org.beesley.pitrain.broker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.beesley.pitrain")
@EntityScan("org.beesley.pitrain")
@SpringBootApplication
public class App extends SpringBootServletInitializer {
}
