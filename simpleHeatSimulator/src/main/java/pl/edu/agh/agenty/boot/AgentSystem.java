package pl.edu.agh.agenty.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Janusz on 12.06.2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"pl.edu.agh.agenty"})
public class AgentSystem {
    public static void main(String[] args) {
        SpringApplication.run(AgentSystem.class, args);
    }
}
