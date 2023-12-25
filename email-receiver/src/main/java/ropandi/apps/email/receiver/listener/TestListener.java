package ropandi.apps.email.receiver.listener;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ropandi.apps.email.receiver.service.EmailSendLogService;
import ropandi.apps.email.receiver.transformer.TestDtoMapper;
import ropandi.apps.kafka.consumer.service.KafkaConsumer;
import ropandi.apps.model.test.avro.TestAvroModel;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestListener implements KafkaConsumer<TestAvroModel> {

    private final EmailSendLogService emailSendLogService;

    private static final Logger log = LoggerFactory.getLogger(TestListener .class);
    @Override
    @KafkaListener(id = "${kafka-consumer-config.consumer-group-id}",
            topics = "${kafka-consumer-config.topic-name}")
    public void receive(@Payload List<TestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of orders approval requests received with keys {}, partitions {} and offsets {}" +
                        ", sending for restaurant approval",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(testAvroModel -> {
            try {
                log.info("Processing email for order id: {}", testAvroModel .getId());
                emailSendLogService.saveTest(TestDtoMapper.getDto(testAvroModel));
            } catch (DataAccessException e) {

            }
        });
    }
}
