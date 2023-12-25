package ropandi.apps.email.receiver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ropandi.apps.email.receiver.entity.EmailSendLog;
import ropandi.apps.email.receiver.repository.EmailSendLogRepository;
import ropandi.apps.model.test.dto.TestDto;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailSendLogService {

    private final EmailSendLogRepository emailSendLogRepository;

    public void saveTest(TestDto testDto){
        EmailSendLog emailSendLog = new EmailSendLog();
        emailSendLog.setContent(testDto.getCc());
        emailSendLog.setReceiver(UUID.randomUUID().toString());
        emailSendLog.setSender("kafka");
        emailSendLog.setSubject("subject");
        emailSendLog.setSendAt(new Date());
        emailSendLogRepository.save(emailSendLog);
        log.info("success test name : {}", testDto.getCc());
    }

}
