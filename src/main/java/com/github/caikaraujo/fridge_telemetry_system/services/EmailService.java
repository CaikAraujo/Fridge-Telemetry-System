package com.github.caikaraujo.fridge_telemetry_system.services;


import com.github.caikaraujo.fridge_telemetry_system.enums.TmErrorCode;
import com.github.caikaraujo.fridge_telemetry_system.exceptions.TelemetryException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body, byte[] attachmentContent){

        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            helper.addAttachment("Daily_Report.PDF", new ByteArrayResource(attachmentContent));

            mailSender.send(message);
        } catch (MessagingException ex){
            throw new TelemetryException(TmErrorCode.NOTIFICATION_SERVICE_ERROR);
        }


    }
}
