package com.prasidyo;

import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailService {
    private final Session session;

    public EmailService(Session session) {
        super();
        this.session = session;
    }

    public void sendMail() throws Exception {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
        message.setSubject("Mail Subject");
        String msg = "This is my first email using JavaMailer";
        
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
    
   
    // private Session getSession() {
    //     Session session = Session.getInstance(prop, new Authenticator() {
    //         @Override
    //         protected PasswordAuthentication getPasswordAuthentication() {
    //             return new PasswordAuthentication(username, password);
    //         }
    //     });
    //     return session;
    // }

}
