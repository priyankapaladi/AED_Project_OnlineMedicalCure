package EmailValidation;


import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMail {
   
    public void sendMailTo( String to, String location) {

       
        final String username = "kaisertest01@yahoo.com";
        final String password = "ktpassword";
        String toAddress =to;
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(toAddress));
            message.setSubject("Treatment and Prescription");
          //  message.setText(body);
            
            
            // attach file 
            
               
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("Here is your Prescription! The PDF of your prescription has been attached "
                 + "and RequestID is your password!");
         Multipart multipart = new MimeMultipart();
         // Set text message part
         multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();

       //  messageBodyPart = new MimeBodyPart();
         String filename = location;
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);
        
            
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
           // throw new RuntimeException(e);
            System.out.println("The email address was not authentic");
        }
    }
    
    
    public void notifyUserForLogin(String to, String newPassword){
        final String username = "kaisertest01@yahoo.com";
        final String password = "ktpassword";
        String toAddress =to;
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("kaisertest01@yahoo.com"));
            message.setSubject("Treatment and Prescription");
            message.setText("The user registered with this emailId tried logging in thrice with wrong password!"+
                    "\n"+"The password has been reset and the new password to your account is "+ newPassword);
              Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
            
        
    }
    
    
    
    public void sendAlertMail (String data, String location){
       final String username = "kaisertest01@yahoo.com";
        final String password = "ktpassword";
        
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("prynk.paladi@gmail.com"));
                        message.setSubject("Alert!!");

            // attach file 
            
               
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText(data);
         Multipart multipart = new MimeMultipart();
         // Set text message part
         multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();

       //  messageBodyPart = new MimeBodyPart();
         String filename = location;
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);
        
            
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }  
    }
}
