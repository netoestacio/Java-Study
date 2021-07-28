package br.com.msemail.services;

import br.com.msemail.enums.StatusEmail;
import br.com.msemail.models.EmailModel;
import br.com.msemail.repositories.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private EmailRepository repository;
    @Autowired
    private JavaMailSender emailSender;


    public EmailModel sendEmail(EmailModel email){
        email.setSenDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
            log.info("Email enviado");

        }catch (Exception e){
            email.setStatusEmail(StatusEmail.ERROR);
            log.error(e.getMessage());
        }finally {
            return repository.save(email);
        }

    }
}
