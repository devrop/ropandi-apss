package ropandi.apps.kafka.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ropandi.apps.kafka.admin.init.StreamInitializer;

@SpringBootApplication
@ComponentScan(basePackages = "ropandi.apps")
public class KafkaAdminApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminApplication.class);


    private final StreamInitializer streamInitializer;


    public KafkaAdminApplication(StreamInitializer initializer) {
        this.streamInitializer = initializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaAdminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("App starts...");
        streamInitializer.init();
    }

}