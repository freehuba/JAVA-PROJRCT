package com.jsp.gmail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App {
	static Random random = new Random();

	public static void main(String[] args) throws Exception {
		int otp = random.nextInt(1001, 99999);
		String from = "hemanthhemanthjm21797@gmail.com";
		String to = "softwaredibya@gmail.com";
		String subject = "CodersArea : Confirmation";
		String message = "One Time Password Is sent by hemanth: " + otp;

		sendGmail(from, to, subject, message);
		// sendGmailAttacFile(from, to, subject, message);
	}

	public static void sendGmail(String form, String to, String subject, String message) {
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println(properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("hemanthjmhemanth@gmail.com", "tddf pfcx qdzd owix");
			}

		});

		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(form);
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			m.saveChanges();
			Transport.send(m);
			System.out.println("Send succes..............................");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void sendGmailAttacFile(String form, String to, String subject, String message) throws IOException {
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println(properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("hemanthjmhemanth@gmail.com", "tddf pfcx qdzd owix");
			}

		});

		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(form);
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);

			File f = new File("C:\\Users\\WIN 10\\Pictures\\Screenshots\\abc.png");

			MimeMultipart mimeMultipart = new MimeMultipart();
			MimeBodyPart text = new MimeBodyPart();
			MimeBodyPart file = new MimeBodyPart();

			text.setText(message);
			file.attachFile(f);

			mimeMultipart.addBodyPart(text);
			mimeMultipart.addBodyPart(file);

			m.setContent(mimeMultipart);
			m.saveChanges();
			Transport.send(m);
			System.out.println("Send succes..............................");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}