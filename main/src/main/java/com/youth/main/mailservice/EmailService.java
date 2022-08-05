package com.youth.main.mailservice;

public interface EmailService {

 // Method
 // To send a simple email
 String sendSimpleMail(EmailDetails details);

 // To send an email with attachment
 String sendMailWithAttachment(EmailDetails details);
 
// Sending mail without attachment only html
 String sendMailWithHTMLOnly(EmailDetails details);
}