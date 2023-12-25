package ropandi.apps.email.sender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropandi.apps.email.sender.publisher.TestPublisher;
import ropandi.apps.email.sender.request.TestRequest;
import ropandi.apps.email.sender.transformer.TestRequestMapper;
import ropandi.apps.kafka.core.configdata.KafkaConfigData;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestPublisher testPublisher;
    private final KafkaConfigData kafkaConfigData;

    public String sendTest(TestRequest request){
        testPublisher.send(kafkaConfigData.getTopicName(),request.getId(), TestRequestMapper.convertToAvro(request));
        return "OK";
    }
}
