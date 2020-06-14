/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;

import com.esprit.Entite.Inscription_evenement;
import com.esprit.Service.ServiceEvenement;
import com.esprit.Service.ServiceInscription_evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Dimassi Abdelhak
 */
public class JavamailUtil_1 {
  
 
    
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send:");
        Properties properties = new Properties();       
        
        String myAccountEmail ="bestgoldennumber1@gmail.com";
        String password ="freebestboy";
        
        properties.put("com.hof.email.starttime","20170519094544");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.connectiontimeout","60000");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.timeout","60000");
        properties.put("mail.transport.protocol","smtp");
        
        
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session,myAccountEmail,recepient);
        
        Transport.send(message);
        System.out.println("message send successfully");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail,String recepient){
        try {
            ServiceEvenement Act = new ServiceEvenement();
           ServiceInscription_evenement Act2 = new ServiceInscription_evenement();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("La listes des événements");
            message.setText(Act.listEvenement());
           
           

      
          
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(JavamailUtil_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
