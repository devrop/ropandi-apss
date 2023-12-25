package ropandi.apps.email.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ropandi.apps.email.receiver.entity.EmailSendLog;
@Repository
public interface EmailSendLogRepository extends JpaRepository<EmailSendLog,Long> {
}
