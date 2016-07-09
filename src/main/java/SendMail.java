import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.TimerTask;

/**
 * Created by EvanKing on 7/8/16.
 */
public class SendMail extends TimerTask {

    private Config config = new Config();

    final String body = config.getValues().get("body");

    final String subject = config.getValues().get("subject");

    final String from = config.getValues().get("from");

    final String to = config.getValues().get("to");

    final String password = config.getValues().get("password");

    public void run() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(from));

            InternetAddress[] iAdressArray = InternetAddress.parse(to);
            message.setRecipients(Message.RecipientType.TO, iAdressArray);

            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}