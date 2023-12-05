

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * This utility class provides a functionality to send an HTML e-mail message
 * with embedded images.
 * @author www.codejava.net
 *
 */
public class EmbeddedImageEmailUtil {

	/**
	 * Sends an HTML e-mail with inline images.
	 * @param host SMTP host
	 * @param port SMTP port
	 * @param userName e-mail address of the sender's account 
	 * @param password password of the sender's account
	 * @param toAddress e-mail address of the recipient
	 * @param subject e-mail subject
	 * @param htmlBody e-mail content with HTML tags
	 * @param mapInlineImages 
	 * 			key: Content-ID
	 * 			value: path of the image file
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void send(String host, String port,
			final String userName, final String password, String[] toAddress,
			String subject, String htmlBody, 
			Map<String, String> mapInlineImages, String sSenderEmail, String sSenderLabel)
				throws AddressException, MessagingException {
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);
		

		// creates a new session with an authenticator
		/*
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);
		
		*/
	      //Connect to the server
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.user", userName);
		props.put("mail.password", password);
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.socketFactory.port", port); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		String provider  = "imap";
		
//		 Properties props = new Properties();
//		 props.put("mail.smtp.host", "smtp.gmail.com");
//		 props.put("mail.smtp.port", "25");
//		 props.put("mail.smtp.ssl.enable", "true");
//		 props.put("mail.smtp.auth", "true");
//		 
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		session.setDebug(false);
	      Store store     = session.getStore(provider);
	      store.connect(host, userName, password);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		try {
			
			msg.setFrom(new InternetAddress(sSenderEmail,sSenderLabel));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		javax.mail.internet.InternetAddress[] addressTo = new javax.mail.internet.InternetAddress[toAddress.length];

		for (int i = 0; i < toAddress.length; i++)
		{
		    addressTo[i] = new javax.mail.internet.InternetAddress(toAddress[i]);
		}

		msg.setRecipients(javax.mail.Message.RecipientType.BCC, addressTo); 
		
		
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(htmlBody, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds inline image attachments
		if (mapInlineImages != null && mapInlineImages.size() > 0) {
			Set<String> setImageID = mapInlineImages.keySet();
			
			for (String contentId : setImageID) {
				MimeBodyPart imagePart = new MimeBodyPart();
				imagePart.setHeader("Content-ID", "<" + contentId + ">");
				imagePart.setDisposition(MimeBodyPart.INLINE);
				
				String imageFilePath = mapInlineImages.get(contentId);
				try {
					imagePart.attachFile(imageFilePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(imagePart);
			}
		}

		msg.setContent(multipart);
				try {
						Transport.send(msg);
						
						
				} catch (MessagingException  mex) {
					mex.printStackTrace();
				}
				
		
		//close connection
		try {
			if (store != null && store.isConnected()) {
               
                store.close();
            }
			
		} catch (Exception e) {
			
		}
	}
}