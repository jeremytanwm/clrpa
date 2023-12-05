import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * My JavaMail email address extractor.
 * A JavaMail API example.
 * @author alvin alexander, alvinalexander.com.
 */
public class EmailIMAP
{

	
	public static String getCurrentDate() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);  
	}
	
	public static String convertDate(Date dDate) {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = convertToLocalDateViaInstant(dDate);  
		   return dtf.format(now);  
	}
	
	public static boolean createFolder(String sFullPath){
		File file = new File(sFullPath);
		boolean rslt=false;
        // true if the directory was created, false otherwise
		if (file.exists()) {
			rslt=true;
		} else {
	        if (file.mkdirs()) {
	            System.out.println("Directory is created! "+sFullPath);
	            rslt=true;
	        } else {
	            System.out.println("Failed to create directory! " +sFullPath);
	            rslt=false;
	        }
		}
        return rslt;
	}
	
	
	public static LocalDateTime convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
  public static void main(String[] args)
  {
    Properties props = new Properties();

    String host = "mail.dutabot.com";
    String username = "purnama@dutabot.com";
    String password = "!12qwasZX";
    //String provider  = "pop3";
    String provider  = "imap";
    

    try
    {
      //Connect to the server
      Session session = Session.getDefaultInstance(props, null);
      Store store     = session.getStore(provider);
      store.connect(host, username, password);

      //open the inbox folder
      Folder inbox = store.getFolder("capitaland");
      inbox.open(Folder.READ_WRITE);

   
      
     
      
      // get a list of javamail messages as an array of messages
      Message[] messages = inbox.search(
    	        new FlagTerm(new Flags(Flags.Flag.SEEN), false));

      for (int i = 0; i < messages.length; i++) {
          Message message = messages[i];
          Address[] fromAddress = message.getFrom();
          String from = fromAddress[0].toString();
          String subject = message.getSubject();
          String sentDate = message.getSentDate().toString();

          String contentType = message.getContentType();
          String messageContent = "";
          
          
          //CreateFolder

          String sFullFolder="c:\\ppms\\email\\"+convertDate(message.getSentDate());          
          createFolder(sFullFolder);

          // store attachment file name, separated by comma
          String attachFiles = "";
      	try {
          if (contentType.contains("multipart")) {
              // content may contain attachments
              Multipart multiPart;
		
				multiPart = (Multipart) message.getContent();
			
              int numberOfParts = multiPart.getCount();
              for (int partCount = 0; partCount < numberOfParts; partCount++) {
                  MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                  if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                      // this part is attachment
                      String fileName = part.getFileName();
                      attachFiles += fileName + ", ";
                    part.saveFile(sFullFolder + File.separator + fileName);
                    
                  } else {
                      // this part may be the message content
                     messageContent = part.getContent().toString();
                  }
              }
              

              if (attachFiles.length() > 1) {
                  attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
              }
          } else if (contentType.contains("text/plain")
                  || contentType.contains("text/html")) {
              Object content = message.getContent();
              if (content != null) {
                  messageContent = content.toString();
              }
          }
          } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

          // print out details of each message
          System.out.println("Message #" + (i + 1) + ":");
          System.out.println("\t From: " + from);
          System.out.println("\t Subject: " + subject);
          System.out.println("\t Sent Date: " + sentDate);
          System.out.println("\t Message: " + messageContent);
          System.out.println("\t Attachments: " + attachFiles);
          
          message.setFlag(Flags.Flag.SEEN, true);//update message as READ
      }


      //close the inbox folder but do not
      //remove the messages from the server
      inbox.close(false);
      store.close();
      
      System.out.println("Completed");
      
    }
    catch (NoSuchProviderException nspe)
    {
      System.err.println("invalid provider name");
    }
    catch (MessagingException me)
    {
      System.err.println("messaging exception");
      me.printStackTrace();
    }
  }

  private static String getFrom(Message javaMailMessage) 
  throws MessagingException
  {
    String from = "";
    Address a[] = javaMailMessage.getFrom();
    if ( a==null ) return null;
    for ( int i=0; i<a.length; i++ )
    {
      Address address = a[i];
      from = from + address.toString();
    }

    return from;
  }
  
  

  private static String removeQuotes(String stringToModify)
  {
    int indexOfFind = stringToModify.indexOf(stringToModify);
    if ( indexOfFind < 0 ) return stringToModify;

    StringBuffer oldStringBuffer = new StringBuffer(stringToModify);
    StringBuffer newStringBuffer = new StringBuffer();
    for ( int i=0, length=oldStringBuffer.length(); i<length; i++ )
    {
      char c = oldStringBuffer.charAt(i);
      if ( c == '"' || c == '\'' )
      {
        // do nothing
      }
      else
      {
        newStringBuffer.append(c);
      }

    }
    return new String(newStringBuffer);
  }

}