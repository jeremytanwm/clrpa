import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;

public class CheckingMails {

  public static void main(String args[]) throws Exception {

    // mail server connection parameters
    String host = "mail.dutabot.com";
    String user = "purnama@dutabot.com";
    String password = "!12qwasZX";

    // connect to my pop3 inbox
    Properties properties = System.getProperties();
    Session session = Session.getDefaultInstance(properties);
    Store store = session.getStore("pop3");
    store.connect(host, user, password);
    Folder inbox = store.getFolder("CAPITALAND");
    inbox.open(Folder.READ_ONLY);
    int timeOutInSeconds=6000;
 // Only pull unread
    FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
    Message messages[]; // = folder.search(ft);
    
   // for(int x = 0; x < timeOutInSeconds; x++) {
        
        try {
        	inbox.getMessages();
            messages = inbox.search(ft);

            if (messages.length > 0) {
                for (Message message : messages) {
                    //log.reportMessage("found message: should not see again, marking read");
                    // want to mark as rea
                	 message.setFlag(Flags.Flag.SEEN,true);
                	System.out.println(message.getSubject());

                }
            }
            Thread.sleep(1000);
        }
        catch(Exception ex) {

        }
    //}

  
    
    
    System.out.println("Unread emaul:"+inbox.getUnreadMessageCount());
    inbox.close(true);
    store.close();
  }
}