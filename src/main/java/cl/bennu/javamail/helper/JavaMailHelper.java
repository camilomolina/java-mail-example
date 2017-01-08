package cl.bennu.javamail.helper;

import org.apache.commons.mail.DefaultAuthenticator;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class JavaMailHelper {

    public static void sendMail(String host, int port, boolean ssl, String from, String to, String subject, String body, String user, String pass) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.user", user);
            props.put("mail.smtp.starttls.enable", ssl);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", port);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getDefaultInstance(props, new DefaultAuthenticator(user, pass));
            session.setPasswordAuthentication(new URLName(host), new PasswordAuthentication(user, pass));

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(body);

            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);

            Transport.send(message);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
