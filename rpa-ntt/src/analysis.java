import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.opencsv.CSVReader;

//import javafx.concurrent.Task;


import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONObject;

public class analysis {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String grid = "";
  
  public static String gsno = "";
  
  public static RemoteWebDriver gdriver = null;
  
  public static File gFDownloaded = null;
  public static String gDBName = "capitaland";
  
  
  
  public static boolean isBrowserClosed(WebDriver driver) {
    boolean isClosed = false;
    try {
      driver.getTitle();
    } catch (UnreachableBrowserException ubex) {
      isClosed = true;
    } catch (Exception e) {
      isClosed = true;
    } 
    return isClosed;
  }
  
  public static String TableToJson(String source) {
    Document doc = Jsoup.parse(source);
    JSONObject jsonParentObject = new JSONObject();
    for (Element table : doc.select("table")) {
      for (Element row : table.select("tr")) {
        JSONObject jsonObject = new JSONObject();
        Elements tds = row.select("td");
        String Name = ((Element)tds.get(0)).text();
        String Group = ((Element)tds.get(1)).text();
        String Code = ((Element)tds.get(2)).text();
        String Lesson = ((Element)tds.get(3)).text();
        String Day1 = ((Element)tds.get(4)).text();
        String Day2 = ((Element)tds.get(5)).text();
        String Day3 = ((Element)tds.get(6)).text();
        jsonObject.put("Group", Group);
        jsonObject.put("Code", Code);
        jsonObject.put("Lesson", Lesson);
        jsonObject.put("Day1", Day1);
        jsonObject.put("Day2", Day2);
        jsonObject.put("Day3", Day3);
        jsonParentObject.put(Name, jsonObject);
      } 
    } 
    return jsonParentObject.toString();
  }
  
  
  public static String getData(String sContent, String startKeyword, String endKeyword) {
    int locStart = sContent.indexOf(startKeyword);
    int locEnd = sContent.indexOf(endKeyword, locStart);
    String temp = sContent.substring(locStart + startKeyword.length(), locEnd);
    System.out.println(temp);
    return temp;
  }
  
  public static String getURLValue(String ahref, String sKeyword, int iValueLength) {
    String rslt = "";
    try {
      int sloc = ahref.indexOf(sKeyword) + sKeyword.length();
      rslt = ahref.substring(sloc, sloc + iValueLength).toUpperCase();
    } catch (Exception e) {
      System.out.println("Error: getURLValue for " + ahref + " : " + sKeyword + " : " + iValueLength);
    } 
    return rslt;
  }
  





 
  
  public static String normalize(String sText) {
    String sRslt = sText;
    if (sRslt != null)
      sRslt.replaceAll("-", ""); 
    return sRslt;
  }
  
  public static String getCurrency(String sText) {
    String sRslt = sText;
    if (sRslt != null)
      if (sRslt.length() > 3) {
        sRslt = sRslt.substring(0, 2);
      } else {
        sRslt = "";
      }  
    return sRslt;
  }
  
  
  public static void moveFile(String fromFile, String toFile) {
	

      Path source = Paths.get(fromFile);
      Path target = Paths.get(toFile);

      try {

          
          Files.move(source, target);

     

      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
  
  public static String generateRandomStringByUUID() {
      return UUID.randomUUID().toString();
  }

  public static String generateRandomStringByUUIDNoDash() {
      return UUID.randomUUID().toString().replace("-", "");
  }
  
  
  
  public static String escapeString(String x, boolean escapeDoubleQuotes) {
      StringBuilder sBuilder = new StringBuilder(x.length() * 11/10);

      int stringLength = x.length();

      for (int i = 0; i < stringLength; ++i) {
          char c = x.charAt(i);

          switch (c) {
          case 0: /* Must be escaped for 'mysql' */
              sBuilder.append('\\');
              sBuilder.append('0');

              break;

          case '\n': /* Must be escaped for logs */
              sBuilder.append('\\');
              sBuilder.append('n');

              break;

          case '\r':
              sBuilder.append('\\');
              sBuilder.append('r');

              break;

          case '\\':
              sBuilder.append('\\');
              sBuilder.append('\\');

              break;

          case '\'':
              sBuilder.append('\\');
              sBuilder.append('\'');

              break;

          case '"': /* Better safe than sorry */
              if (escapeDoubleQuotes) {
                  sBuilder.append('\\');
              }

              sBuilder.append('"');

              break;

          case '\032': /* This gives problems on Win32 */
              sBuilder.append('\\');
              sBuilder.append('Z');

              break;

          case '\u00a5':
          case '\u20a9':
              // escape characters interpreted as backslash by mysql
              // fall through

          default:
              sBuilder.append(c);
          }
      }

      return sBuilder.toString();
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
	
	public static String convertDate(String sDate, String sFormat) {
		String rslt="";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterDest = new SimpleDateFormat(sFormat);
        

        try {

            Date date = formatter.parse(sDate);
            System.out.println(date);
            System.out.println(formatterDest.format(date));
            rslt=formatterDest.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rslt;
	}
	
	 
	 
	public static LocalDateTime convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	
	public static int getInt(String sInt) {
		int rslt=0;
		try {
			rslt=Integer.parseInt(sInt);
		} catch (Exception e) {
			rslt=0;
		}
		return rslt;
	}
	
	public static void setTemplate(String sCategory) {
		
		
		clTemplate cltemplate = new clTemplate();
    
    	
    	
    	String sTemplate=cltemplate.getTemplate(sCategory);
    	
    	if (sTemplate!=null) {
    		if (sTemplate.length()>0) {
    	
		    	clpbiTicketAnalysis clpbi= new clpbiTicketAnalysis();
		    	
		    	String sDate=getDate(-1, "yyyy-MM-dd");
		    	clTicket cl = new clTicket(gDBName);
		    	
		    	if (sCategory=="dashboard") {
		    			
			    	clpbi.getData(sDate);    	
			    	
			    	
			    	
			    	//Replace Yesterday Date
			    	sTemplate=sTemplate.replaceAll("\\[yesterdaydate\\]", getDate(-1));
			    	sTemplate=sTemplate.replaceAll("\\[numberofticketcreated\\]", clpbi.getTicketcreatednonalert());
			    	sTemplate=sTemplate.replaceAll("\\[wipticket\\]", clpbi.getTicketwipnonalert());
			    	sTemplate=sTemplate.replaceAll("\\[closedticket\\]", clpbi.getTicketclosednonalert());
			    	
			    	sTemplate=sTemplate.replaceAll("\\[cancelticket\\]", clpbi.getTicketcancellednonalert());
			    	
			    	//FCR-PW
			    	float pFCRPWD=0;
			    	String sFCRPWPct="100%";
			    	if (clpbi.getFCRPWBase().equals("0")) {
			    		sFCRPWPct="100%";
			    	} else {
			    		pFCRPWD= (float)getInt(clpbi.getFCRPW())/ (float)getInt(clpbi.getFCRPWBase());
			    		sFCRPWPct= Math.round(pFCRPWD*100)+"%";
			    	}
			    	
			    	//FCR
			    	float pFCROthers=0;
			    	String sFCROtherPct="100%";
			    	if (clpbi.getFCROthersBase().equals("0")) {
			    		sFCROtherPct="100%";
			    	} else {
			    		pFCROthers= (float)getInt(clpbi.getFCROthers())/ (float)getInt(clpbi.getFCROthersBase());
			    		sFCROtherPct= Math.round(pFCROthers*100)+"%";
			    	}
			    	sTemplate=sTemplate.replaceAll("\\[FRC-PWD\\%\\]", sFCRPWPct);
			    	sTemplate=sTemplate.replaceAll("\\[metFRC-PWD\\]", clpbi.getFCRPW());
			    	sTemplate=sTemplate.replaceAll("\\[FRC-PWD\\]", clpbi.getFCRPWBase());
			    	sTemplate=sTemplate.replaceAll("\\[FRC-Others\\%\\]", sFCROtherPct);
			    	sTemplate=sTemplate.replaceAll("\\[metFRC-Others\\]", clpbi.getFCROthers());
			    	sTemplate=sTemplate.replaceAll("\\[FRC-Others\\]", clpbi.getFCROthersBase());
			    	
			    	//Priority
			    	String sPriority="<br /><br /><b>Priority</b>: ";
			    	int iP1=getInt(clpbi.getTicketp1nonalert());
			    	int iP2=getInt(clpbi.getTicketp2nonalert());
			    	int iP3=getInt(clpbi.getTicketp3nonalert());
			    	
			    	if ((iP1==0)&& (iP2==0)&&(iP3==0)) {
			    		sPriority=sPriority+" There is no P1,P2, and P3 ticket raised.";
			    	} else if ((iP1==0)&& (iP2==0)) {
			    		sPriority=sPriority+" There is no P1,and P2 ticket raised.";
			    	} else if ((iP1==0)&& (iP3==0)) {
			    		sPriority=sPriority+" There is no P1,and P3 ticket raised.";
			    	} else if ((iP2==0)&& (iP3==0)) {
			    		sPriority=sPriority+" There is no P2 and P3 ticket raised.";
			    	}
			    	
			    	
			    	
			    		sPriority+=cl.getTemplatePriority(sDate, "1 - Ciritical");
			    		sPriority+=cl.getTemplatePriority(sDate, "2 - High");
			    		sPriority+=cl.getTemplatePriority(sDate, "3 - Moderate");
			    		sPriority+=cl.getTemplatePriority(sDate, "4 - Low");
			    	
			    	/*
			    	-Priority-
			    	[P1]=0 = There is no P1,P2 ticket raised. 
			    	[P1}>0. There is [P1] ticket(s) raised for [AssignmentGroup] on [BusinessService]. Current ticket status: [numberofP1ticket] is [status], �.
	
			    	*/
			    	
			    	
			    	sTemplate=sTemplate+sPriority;
			    	
			    	
			    	//Business Service
			    	sTemplate=sTemplate+"<br /><br /><b>Business Service</b> - Top 10: "+cl.getTemplateBusinessService(sDate);
			    	
			    	
			    	
		    	}
		    	
		    	
		    	//OPEN
		    	if (sCategory=="open") {
		    		sTemplate=cl.getTemplateOpen(sDate, sTemplate);
		    		
		    	}
		    	
		    	//CLOSE
		    	if (sCategory=="close") {
		    		sTemplate=cl.getTemplateClose(sDate, sTemplate);
		    		
		    	}
		    	
		    	
		    	if (sTemplate!=null) {
		    		if (sTemplate.length()>0) {
		    			System.out.println(sTemplate);
		    		}
		    		
		    	}
		    	
		    	
		    	
		    	sTemplate=sTemplate.replaceAll("  ", " ");
		    	sTemplate=sTemplate.replaceAll("\\.\\.", "\\.");
		    	clAnalysis clAna = new clAnalysis();
		    	clAna.setDate(sDate);
		    	clAna.setCategory(sCategory);
		    	clAna.setText(sTemplate);    	
		    	clAna.dbLoadData();
    		}
    	}
	}
  public static void main(String[] args) {
    try {
    	
    	
    	setTemplate("dashboard");
    	setTemplate("open");
    	setTemplate("close");
    	
    	
    } catch (Exception e) {
    	System.out.println("Error: "+e.getMessage());
    } finally {
   
      System.exit(0);
    } 
  }
}
