package pl.tanielazienki.tanielazienki.cron;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.tanielazienki.tanielazienki.service.EmailService;

import java.io.IOException;

@Component
public class CheckingComplaintExpiration {
    @Autowired
    private EmailService emailService;
    @Scheduled(cron = "0 0 10 * * ?")
    public void sendEmailForExpiringComplaints() throws IOException {
        emailService.sendSimpleEmail();
    }
}
