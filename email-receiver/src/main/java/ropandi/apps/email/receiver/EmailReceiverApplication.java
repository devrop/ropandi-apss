package ropandi.apps.email.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ropandi.apps")
public class EmailReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailReceiverApplication.class, args);
    }
}
