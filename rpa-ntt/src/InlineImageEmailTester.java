
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.mail.internet.InternetAddress;



/**
 * This program tests out the EmbeddedImageEmailUtil utility class.
 * @author www.codejava.net
 *
 */
public class InlineImageEmailTester {

	/**
	 * main entry of the program
	 */
	
	public static String gDBName="capitaland";
	
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
	
	private static String readLineByLineJava8(String filePath) 
    {
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
    }
	
	
	public static String getDate(int iDays) {
		  
		  return getDate( iDays, "eeee, dd MMMM yyyy");
		  
		  
	  }
	  public static String getDate(int iDays, String sPattern) {
		  ZonedDateTime yesterday = null;
		 
		  
		  yesterday = ZonedDateTime.now().with(ChronoField.NANO_OF_DAY, 0).plusDays(iDays);
			
			   //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
			 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(sPattern);
			  String dateEndStr = dateTimeFormatter.format(yesterday);
			  return dateEndStr;
		}
		
	  
		  
	public static void capitalandDailyEmail() {
		
		
		String port = "25";		
		 String host = "dutabot.com";
		    String mailFrom = "purnama@dutabot.com";
		    String password = "!12qwasZX";

		    //String provider  = "pop3";
		    
		//Email Template
		    String sEmailTemplateFile="C:\\ppms\\email\\capitaland.htm";

		// message info
		String mailTo = "purnama@nttapps.com";
		String subject = "CapitaLand - Daily Report";
		StringBuffer body
			= new StringBuffer(readLineByLineJava8(sEmailTemplateFile));
		
		// inline LOGO
				Map<String, String> inlineImages = new HashMap<String, String>();
				String sFolderPath="C:\\ppms\\email\\logo\\";
				File dir = new File(sFolderPath);
			      FilenameFilter filter = new FilenameFilter() {
			         public boolean accept (File dir, String name) { 
			            return name.endsWith("png");
			         } 
			      }; 
			      String[] children = dir.list(filter);
			      if (children == null) {
			         System.out.println("Either dir does not exist or is not a directory"); 
			      } else { 
			         for (int i = 0; i< children.length; i++) {
			            String filename = children[i];
			            System.out.println(filename);
			            String sFileID="";
			            if (filename!=null) {
			            	if (filename.toLowerCase().contains("logo")) {
			            		sFileID="LOGO";
			            	} else if (filename.toLowerCase().contains("header")) {
			            		sFileID="HEADER";
			            	
			            	}
			            }
			            inlineImages.put(sFileID, sFolderPath+"\\"+filename);
			         } 
			      } 
			      

		// inline images
	
		 sFolderPath="C:\\ppms\\email\\"+getCurrentDate();
		 dir = new File(sFolderPath);
	       filter = new FilenameFilter() {
	         public boolean accept (File dir, String name) { 
	            return name.endsWith("png");
	         } 
	      }; 
	      children = dir.list(filter);
	      if (children == null) {
	         System.out.println("Either dir does not exist or is not a directory"); 
	      } else { 
	         for (int i = 0; i< children.length; i++) {
	            String filename = children[i];
	            System.out.println(filename);
	            String sFileID="";
	            if (filename!=null) {
	            	if (filename.toLowerCase().contains("dashboard")) {
	            		sFileID="DASHBOARD";
	            	} else if (filename.toLowerCase().contains("hold")) {
	            		sFileID="HOLD";
	            	} else if (filename.toLowerCase().contains("close")) {
	            		sFileID="CLOSE";
	            	} else if (filename.toLowerCase().contains("progress")) {
	            		sFileID="PROGRESS";
	            	} 
//	            	if (filename.toLowerCase().contains("dashboard")) {
//	            		sFileID="DASHBOARD";
//	            	} else if (filename.toLowerCase().contains("open")) {
//	            		sFileID="OPEN";
//	            	} else if (filename.toLowerCase().contains("close")) {
//	            		sFileID="CLOSE";
//	            	} else if (filename.toLowerCase().contains("velocity")) {
//	            		sFileID="VELOCITY";
//	            	}
	            }
	            inlineImages.put(sFileID, sFolderPath+"\\"+filename);
	         } 
	      } 
	      
		//Replace Template
	      String sBody=body.toString();
	      sBody=sBody.replaceAll("\\[HEADER\\]", "HEADER");
	      sBody=sBody.replaceAll("\\[LOGO\\]", "LOGO");
	      sBody=sBody.replaceAll("\\[DASHBOARD\\]", "DASHBOARD");
	      sBody=sBody.replaceAll("\\[HOLD\\]", "HOLD");
	      sBody=sBody.replaceAll("\\[PROGRESS\\]", "PROGRESS");
	      sBody=sBody.replaceAll("\\[CLOSE\\]", "CLOSE");
//	      sBody=sBody.replaceAll("\\[VELOCITY\\]", "VELOCITY");
	      
		
	      //replace content
	   	  String sDate=getDate(-1, "yyyy-MM-dd");
//	      clAnalysis clAna = new clAnalysis();
	      	     
//	      sBody=sBody.replaceAll("\\[DASHBOARDTEXT\\]",  clAna.getText(sDate,"dashboard"));
//	      sBody=sBody.replaceAll("\\[OPENTEXT\\]",  clAna.getText(sDate,"open"));
//	      sBody=sBody.replaceAll("\\[CLOSETEXT\\]",  clAna.getText(sDate,"close"));
//	      sBody=sBody.replaceAll("\\[VELOCITYTEXT\\]",  clAna.getText(sDate,"velocity"));

		try {
			
			//Get List of User
			clTicket cl = new clTicket(gDBName);		
			//msg.setFrom(new InternetAddress("interactionhub@nttapps.com","NTT Interaction HUB"));
			EmbeddedImageEmailUtil.send(host, port, mailFrom, password, cl.getEmailAddress(),
				subject, sBody, inlineImages,"interactionhub@capitaland.com","NTT Interaction HUB");
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}
	
	
public static void capitalandReminder(String sType) {
		
	
		String sFileName="";
		String sTitle="";
		if (sType.equals("capitaland-ca")) {
			sFileName="capitaland-ca.htm";
			sTitle=" Client Action";
		} else if (sType.equals("capitaland-epa")) {
			sFileName="capitaland-epa.htm";
			sTitle=" External Provider Action";
		} else if (sType.equals("capitaland-wip")) {
			sFileName="capitaland-wip.htm";
			sTitle=" Work in Progress";
		} 
		
		String port = "25";		
		 String host = "dutabot.com";
		    String mailFrom = "purnama@dutabot.com";
		    String password = "!12qwasZX";
		    //String provider  = "pop3";
		    
		//Email Template
		    String sEmailTemplateFile="C:\\ppms\\email\\"+sFileName;

		// message info
		String mailTo = "purnama@nttapps.com";
		String subject = "Ticket Progress Updates -"+sTitle;
		StringBuffer body
			= new StringBuffer(readLineByLineJava8(sEmailTemplateFile));
		
		
		Map<String, String> inlineImages = new HashMap<String, String>();
		String sFolderPath="C:\\ppms\\email\\logo2\\";
		// inline LOGO

/*
				
				File dir = new File(sFolderPath);
			      FilenameFilter filter = new FilenameFilter() {
			         public boolean accept (File dir, String name) { 
			            return name.endsWith("cl-logo.png");
			         } 
			      }; 
			      String[] children = dir.list(filter);
			      if (children == null) {
			         System.out.println("Either dir does not exist or is not a directory"); 
			      } else { 
			         for (int i = 0; i< children.length; i++) {
			            String filename = children[i];
			            System.out.println(filename);
			            String sFileID="";
			            if (filename!=null) {
			            	if (filename.toLowerCase().contains("logo")) {
			            		sFileID="LOGO";
			            	} else if (filename.toLowerCase().contains("header")) {
			            		sFileID="HEADER";
			            	
			            	}
			            }
			            inlineImages.put(sFileID, sFolderPath+"\\"+filename);
			         } 
			      } 
			      */
		  inlineImages.put("LOGO", sFolderPath+"\\"+"cl-logo.png");
		  if (sType.equals("capitaland-ca")) {
			  inlineImages.put("GUIDE", sFolderPath+"\\"+"cl-ca-guide.png");
		  } else if (sType.equals("capitaland-epa")) {
			  inlineImages.put("GUIDE", sFolderPath+"\\"+"cl-epa-guide.png");
		  } 
	      
		//Replace Template
	      String sBody=body.toString();
	      sBody=sBody.replaceAll("\\[HEADER\\]", "HEADER");
	      sBody=sBody.replaceAll("\\[LOGO\\]", "LOGO");
	      if (sType.equals("capitaland-ca") || sType.equals("capitaland-epa")) {
	    	  sBody=sBody.replaceAll("\\[GUIDE\\]", "GUIDE");
	      }
	      
	      
		
	   

		try {
			clTicket cl = new clTicket(gDBName);	
			List<String> sToEach= new LinkedList<>();
			List<String> sTo= new LinkedList<>();
//			sTo.add("purnama@nttapps.com");
			sTo.add("weimingjeremy.tan@global.ntt");
			//sTo.add("purnama.sidhi@global.ntt");
			
//			List<String> sTo1= new LinkedList<>(); //testing purposes
//			sTo1.add("vr_jeremy.tan@capitaland.com");
			
			if (sType.equals("capitaland-ca")) {
				cl.initReminderObjectCA();				
				sTo.add("alvin.ng@capitaland.com");
				sTo.add("alex.khoo@global.ntt");
//				sTo.add("saurabh.shukla@global.ntt");
				sTo.add("kayden.tan@capitaland.com");
			} else if (sType.equals("capitaland-epa")) {
				cl.initReminderObjectEPA();
				sTo.add("alvin.ng@capitaland.com");
				sTo.add("alex.khoo@global.ntt");
//				sTo.add("saurabh.shukla@global.ntt");
				sTo.add("kayden.tan@capitaland.com");

			} else if (sType.equals("capitaland-wip")) {
				cl.initReminderObjectWIP();				
				//sTo.add("mark.tan@global.ntt");
				sTo.add("alex.khoo@global.ntt");
				sTo.add("kayden.tan@capitaland.com");
//				sTo.add("saurabh.shukla@global.ntt");
				sTo.add("alvin.ng@capitaland.com");
				sTo.add("Sivakumar11.Jeevarathinam@nttdata.com");
				sTo.add("siddaraju.ramaiah@global.ntt");
				sTo.add("lock-lee.mok@global.ntt");
				sTo.add("mark.duran@global.ntt");
				sTo.add("chintiong.goh@global.ntt");
//				sTo.add("corrine.lim@global.ntt");
				sTo.add("Vagish.Patil@nttdata.com");
				sTo.add("roy.dodda@global.ntt");
				sTo.add("atul-vichare@global.ntt");
				sTo.add("eric.chow@global.ntt");
				sTo.add("renjith.george@global.ntt");
				sTo.add("shanawaz.sheik@global.ntt");
				sTo.add("abhishek.oommen@global.ntt");
				sTo.add("pavankumar.totad@global.ntt");
				//sTo.add("peter.simpson@global.ntt");
				sTo.add("lokesha.rao@global.ntt");
				sTo.add("bhaskar.pal@global.ntt");
				
			} 
			
			
			int iTotal=0;
			
			if (cl.ArrReminderObject.size()>0) {
				for (int i=0;i<cl.ArrReminderObject.size();i++) {
					String tmpBody=sBody;
					clTicket.ReminderObject tmpObj= cl.ArrReminderObject.get(i);
					tmpBody=tmpBody.replaceAll("\\[TICKETS\\]", tmpObj.content);
					tmpBody=tmpBody.replaceAll("\\[USER\\]", tmpObj.requestor);
					tmpBody=tmpBody.replaceAll("\\[FINALNOTES\\]", tmpObj.finalnotes);
					//String[] sTo = {"purnama@nttapps.com","purnama.sidhi@global.ntt","alvin.ng@capitaland.com"};
					if (sType.equals("capitaland-wip") || sType.equals("capitaland-ca")) {
						if (tmpObj.email!=null) {
							if (!tmpObj.email.equals("")) {
								sTo.add(tmpObj.email);
							}
						}
					}
					
					else if (sType.equals("capitaland-epa")) {
						if (tmpObj.email!=null) {
							if (!tmpObj.email.equals("")) {
								String[] emaiList = tmpObj.email.split(",");
								for (String s: emaiList) {	
									sTo.add(s);
								}
								
							}
						}
						
					}
				
					EmbeddedImageEmailUtil.send(host, port, mailFrom, password,sTo.toArray(new String[0]),
							subject, tmpBody, inlineImages,"donotreply@capitaland.com","IT Helpdesk Notification");
						System.out.println("Reminder Email sent to "+tmpObj.email);
//						
					//Testing purpose
//						EmbeddedImageEmailUtil.send(host, port, mailFrom, password,sTo1.toArray(new String[0]),
//								subject, tmpBody, inlineImages,"donotreply@capitaland.com","IT Helpdesk Notification");
//							System.out.println("Reminder Email sent to "+sTo1); 
							
						
						if (sType.equals("capitaland-epa")) {
							if (tmpObj.email!=null) {
								if (!tmpObj.email.equals("")) {
									String[] emaiList = tmpObj.email.split(",");
									for (String s: emaiList) {	
										sTo.remove(s);
									}
									
								}
							}
							
						} else {
							sTo.remove(tmpObj.email);
						}
						
					iTotal++;
				}
				System.out.println("Sent Emails: "+iTotal);
			}
			
			
			
			
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// SMTP info
		
		String report = "DailyReport";
//		String report = "EPA";//Testing
		if (args!=null) {
    		if (args.length>0) {
    			report=args[0]; 
    			}
		}
		
		if(report.equals("DailyReport")) {
			capitalandDailyEmail();
		}
		
		if(report.equals("CA")) {
			capitalandReminder("capitaland-ca");
		}
		
		if(report.equals("EPA")) {
			capitalandReminder("capitaland-epa");
		}
		
		if(report.equals("WIP")) {
			capitalandReminder("capitaland-wip");
		}
		
				
//		capitalandDailyEmail();
//		capitalandReminder("capitaland-ca");
//		capitalandReminder("capitaland-epa");
//		capitalandReminder("capitaland-wip");
	}
}