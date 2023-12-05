import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeDriverService;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

//import javafx.concurrent.Task;


import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONObject;

public class servicenow {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String grid = "";
  
  public static String gsno = "";
  
  public static String gSession = "";
  
  public static RemoteWebDriver gdriver = null;
  public static RemoteWebDriver gdriverPBI = null;
  
  public static File gFDownloaded = null;
  
  public static String gDBName = "capitaland";
  
  
  public static String convertDateTime(String sOriginalDate, String sSourceDateFormat) {
	  
	  return convertDateTime(sOriginalDate, sSourceDateFormat, "yyyy-MM-dd HH:mm:ss");
  }
  
  public static String convertDateTime(String sOriginalDate, String sSourceDateFormat, String sToDateFormat) {
	  /*
	   * 
	   * 
Letter	Date or Time Component	Presentation	Examples
G	Era designator	Text	AD
y	Year	Year	1996; 96
Y	Week year	Year	2009; 09
M	Month in year	Month	July; Jul; 07
w	Week in year	Number	27
W	Week in month	Number	2
D	Day in year	Number	189
d	Day in month	Number	10
F	Day of week in month	Number	2
E	Day name in week	Text	Tuesday; Tue
u	Day number of week (1 = Monday, ..., 7 = Sunday)	Number	1
a	Am/pm marker	Text	PM
H	Hour in day (0-23)	Number	0
k	Hour in day (1-24)	Number	24
K	Hour in am/pm (0-11)	Number	0
h	Hour in am/pm (1-12)	Number	12
m	Minute in hour	Number	30
s	Second in minute	Number	55
S	Millisecond	Number	978
z	Time zone	General time zone	Pacific Standard Time; PST; GMT-08:00
Z	Time zone	RFC 822 time zone	-0800
X	Time zone	ISO 8601 time zone	-08; -0800; -08:00

Examples:
Date and Time Pattern	Result
"yyyy.MM.dd G 'at' HH:mm:ss z"	2001.07.04 AD at 12:08:56 PDT
"EEE, MMM d, ''yy"	Wed, Jul 4, '01
"h:mm a"	12:08 PM
"hh 'o''clock' a, zzzz"	12 o'clock PM, Pacific Daylight Time
"K:mm a, z"	0:08 PM, PDT
"yyyyy.MMMMM.dd GGG hh:mm aaa"	02001.July.04 AD 12:08 PM
"EEE, d MMM yyyy HH:mm:ss Z"	Wed, 4 Jul 2001 12:08:56 -0700
"yyMMddHHmmssZ"	010704120856-0700
"yyyy-MM-dd'T'HH:mm:ss.SSSZ"	2001-07-04T12:08:56.235-0700
"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"	2001-07-04T12:08:56.235-07:00
"YYYY-'W'ww-u"	2001-W27-3
	   * 
	   * 
	   */
	  
	  String sRslt="";
	  
	  try
	    {
	      //create SimpleDateFormat object with source string date format
	      SimpleDateFormat sdfSource = new SimpleDateFormat(sSourceDateFormat);
	      
	      //parse the string into Date object
	      Date date = sdfSource.parse(sOriginalDate);
	      
	      //create SimpleDateFormat object with desired date format
	      SimpleDateFormat sdfDestination = new SimpleDateFormat(sToDateFormat);
	      
	      //parse the date into another format
	      sRslt = sdfDestination.format(date);
	      
	      //System.out.println("Date is converted from "+sSourceDateFormat+" format to "+sToDateFormat);
	      //System.out.println("Converted date is : " + sRslt);
	      
	    }
	    catch(ParseException pe)
	    { 
	      System.out.println("Parse Exception : " + pe);
	    }
	  
	  return sRslt;
	  
  }
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
  




  public static void pause(int iSeconds) {
	  try {
	        Thread.sleep(iSeconds * 1000);
	    
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      } 
  }
  
  public static void initDriverServiceNowCL() {
	    gdriver = getDriverServiceNowCL();
	    if (gdriver!=null) {
	    	System.out.println("Connected");   	
	    
	    }
  }
  
  public static void initDriverServiceNow() {
    //gdriver = getDriverServiceNow();
	  gdriver = getDriverServiceNowEdge();
    if (gdriver!=null) {
    	System.out.println("Connected");   	
    
    }
    FluentWait<WebDriver> wait = (new FluentWait(gdriver))
    	      .withTimeout(5L, TimeUnit.SECONDS)
    	      .pollingEvery(1L, TimeUnit.SECONDS)
    	      .ignoring(NoSuchElementException.class);
    /*
    	    By cssBtn = By.cssSelector("button[class=\"button mb24 secondary wide\"]");
    	    WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssBtn));
    	    btnLogin.click();
    	    wait = (new FluentWait(gdriver))
    	      .withTimeout(5L, TimeUnit.MINUTES)
    	      .pollingEvery(1L, TimeUnit.SECONDS)
    	      .ignoring(NoSuchElementException.class);
    	      */
    
    /* FOR CHROME ONLY===================
    	    By cssUserName = By.cssSelector("input[name=\"loginfmt\"]");
    	    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
    	    usernameTxt.sendKeys(new CharSequence[] { "purnama.sidhi@global.ntt" });
    	    By cssNextBtn = By.cssSelector("input[id=\"idSIButton9\"]");
    	    WebElement nextBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextBtn));
    	    nextBtn.click();
    	    wait = (new FluentWait(gdriver))
    	      .withTimeout(5L, TimeUnit.MINUTES)
    	      .pollingEvery(1L, TimeUnit.SECONDS)
    	      .ignoring(NoSuchElementException.class);
    	    By cssPassword = By.cssSelector("input[name=\"passwd\"]");
    	    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
    	    password.sendKeys(new CharSequence[] { "P@ssw0rd" });
    	    By cssNextPwdBtn = By.cssSelector("input[id=\"idSIButton9\"]");
    	    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
    	    nextPwdBtn.click();
    	    
    	    //OTP
    	    System.out.println("Checking OTP :");
    	    boolean isWaiting=true;
    	    while (isWaiting) {
    	    	try {
    	    		pause(5);
    	    		wait = (new FluentWait(gdriver))
    	    	    	      .withTimeout(5L, TimeUnit.SECONDS)
    	    	    	      .pollingEvery(1L, TimeUnit.SECONDS)
    	    	    	      .ignoring(NoSuchElementException.class);
	    	    	By cssWait = By.cssSelector("div[id=\"idDiv_SAOTCAS_Title\"]");
	    	    	WebElement spanWait = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssWait));
	    	    	System.out.print(".");
	    	    	
    	    	} catch (Exception e) {
    	    		System.out.println("NO 2FA/ 2FA Completed");
    	    		isWaiting=false;
    	    	}
    	    } 
    	    System.out.println("initDriverServiceNow - Completed");
    	    
    	    */
  }
  
  public static void initDriverPowerBI() {
	    gdriverPBI = getDriverPowerBI();
	    if (gdriverPBI!=null) {
	    	System.out.println("Connected");   	
	    
	    }
		
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
  
  public static void downloadReport(String sReportID) {	  
	  downloadReport(sReportID, null);
	  System.gc();  
  }
  
  public static void updateVelocity(String sStartDate) {	
	  LocalDate sNow = LocalDate.now();
	  updateVelocity(sStartDate, sNow.toString());
	  System.gc();  
  }
  

  public static void updateVelocity() {	
	  LocalDate sNow = LocalDate.now();	  
	  clTicket clTix = new clTicket(gDBName);

		 
		 updateVelocity(sNow.minusWeeks(2).toString(), sNow.toString());		 
		 
		 
	
	  System.gc();  
  }
  
 
  
  public static void updateVelocity(String sStartDate, String sEndDate) {
	  //sys_date, sys_day, created, closed, burn_rate, backlog
	  
	 //get Date Different
	  long iDays = getDays (sStartDate, sEndDate);
	  String sRunningDate=sStartDate;
	  LocalDate runningDate = LocalDate.parse(sRunningDate);
	  System.out.println("START Update Velocity");
	  clVelocity clVel= new clVelocity(gDBName);
	  for (int i=0; i< iDays+1; i++) {
		  
		  
		  String sDate=runningDate.toString();
		  String sCreated="0";
		  String sClosed="0";
		  String sBurnRate="0";
		  String sBackLog="0";
		  
		  //Get Created
		  sCreated=clVel.getData("created", sDate)+"";
		  sClosed=clVel.getData("closed", sDate)+"";
		  sBackLog=clVel.getData("backlog", sDate)+"";
		  try {
			  if (  Integer.parseInt(sCreated)>0) {
				  sBurnRate = Float.toString(Float.parseFloat(sClosed) /  Float.parseFloat(sCreated));
			  }
		  } catch (Exception e) {
			  sBurnRate="0";
		  }
		  System.out.println(runningDate.toString()+"-"+sCreated+"-"+sClosed+"-"+sBurnRate+"-"+sBackLog);
		  //Insert to DB
		  clVel.Load(sDate, sCreated, sClosed, sBurnRate, sBackLog);
		  runningDate=runningDate.plusDays(1);
	  }
	  
	  clVel.close();
	  
	  System.out.println("END Update Velocity");
  }
  
  
  public static void updateVelocityByAssigneeGroup() {	
	  LocalDate sNow = LocalDate.now();	  
	  clTicket clTix = new clTicket(gDBName);
	  String[] sResult=clTix.getPBITicketAssignmentGroup();
	 for (int i=0;i<sResult.length;i++) {
		 System.out.println("=== START ["+i+"/"+sResult.length+"] :"+sResult[i]+" ===");
		 //updateVelocityByAssigneeGroup(sNow.minusWeeks(2).toString(), sNow.toString(),sResult[i]);		 
		 
		 updateVelocityByAssigneeGroup(sNow.minusYears(1).toString(), sNow.toString(),sResult[i]);
		 
		 
		 System.out.println("=== END ["+i+"/"+sResult.length+"] :"+sResult[i]+" ===");
		 System.gc();  
	 }
	  System.gc();  
  }
  
  public static void updateVelocityByAssigneeGroup(String sStartDate, String sEndDate, String sAssignmentGroup) {
	  //sys_date, sys_day, created, closed, burn_rate, backlog
	  
	 //get Date Different
	  long iDays = getDays (sStartDate, sEndDate);
	  String sRunningDate=sStartDate;
	  LocalDate runningDate = LocalDate.parse(sRunningDate);
	  System.out.println("START Update Velocity for "+sAssignmentGroup);
	  clVelocity clVel= new clVelocity(gDBName);
	  for (int i=0; i< iDays+1; i++) {
		  
		  
		  String sDate=runningDate.toString();
		  String sCreated="0";
		  String sClosed="0";
		  String sBurnRate="0";
		  String sBackLog="0";
		  
		  //Get Created
		  sCreated=clVel.getData("created", sDate, sAssignmentGroup)+"";
		  sClosed=clVel.getData("closed", sDate, sAssignmentGroup)+"";
		  sBackLog=clVel.getData("backlog", sDate, sAssignmentGroup)+"";
		  try {
			  if (  Integer.parseInt(sCreated)>0) {
				  sBurnRate = Float.toString(Float.parseFloat(sClosed) /  Float.parseFloat(sCreated));
			  }
		  } catch (Exception e) {
			  sBurnRate="0";
		  }
		  System.out.println(sAssignmentGroup+"-"+runningDate.toString()+"-"+sCreated+"-"+sClosed+"-"+sBurnRate+"-"+sBackLog);
		  //Insert to DB
		  clVel.Load(sDate, sCreated, sClosed, sBurnRate, sBackLog, sAssignmentGroup);
		  runningDate=runningDate.plusDays(1);
	  }
	  System.out.println("END Update Velocity for "+sAssignmentGroup);
  }
  
  public static long getDays (String sStartDate, String sEndDate) {
	  
	//Parsing the date
		LocalDate dateBefore = LocalDate.parse(sStartDate);
		LocalDate dateAfter = LocalDate.parse(sEndDate);
			
		//calculating number of days in between
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			
		//displaying the number of days
		return noOfDaysBetween;
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
  
  public static void initCapitaLand(String sReportID) {
	    String sContent = "";
	    String sURL = "";
	    try {
	    	
	    	
	      sURL = "https://apps_servicegrid_svcp:HoPx6Rst041@capitaland.service-now.com/sys_report_template.do?XML&jvar_report_id=" + sReportID;
	      //driver.get("https://purnama.sidhi%40global.ntt:P@ssw0rd@dimensiondataservices.service-now.com/sys_report_template.do?CSV&jvar_report_id=b32219791bf224d822e92f072d4bcbb7");
	      gdriver.get(sURL);
	      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
	    	        .withTimeout(5L, TimeUnit.MINUTES)
	    	        .pollingEvery(1L, TimeUnit.SECONDS)
	    	        .ignoring(NoSuchElementException.class);
	      
	    } catch (Exception e) {
	      System.out.println("ERROR: initCapitaLand: " + sURL);
	      System.out.println(e.getMessage());
	    } 
	  }
  
  public static void downloadReportCapitaLand(String sReportID, String sReportType) {
	    String sContent = "";
	    String sURL = "";
	    try {
	    	
	    	
	      sURL = "https://capitaland.service-now.com/sys_report_template.do?CSV&jvar_report_id=" + sReportID;
	      //driver.get("https://purnama.sidhi%40global.ntt:P@ssw0rd@dimensiondataservices.service-now.com/sys_report_template.do?CSV&jvar_report_id=b32219791bf224d822e92f072d4bcbb7");
	      gdriver.get(sURL);
	      System.out.print("Capitaland - Downloading report file : " + sReportID);	      
	      File dir = new File("C:\\ppms\\download\\"+gDBName);
	      
	     
	      FluentWait<WebDriver> wait = new FluentWait<WebDriver>(gdriver);
	    	        wait.pollingEvery(5, TimeUnit.SECONDS);
	    	        wait.withTimeout(15, TimeUnit.MINUTES);
	    	        wait.until(x -> {
	    	            File[] filesInDir = dir.listFiles();
	    	            for (File fileInDir : filesInDir) {
	    	                if (fileInDir.getName().endsWith("csv")) {
	    	                	System.out.println("found");	
	    	                	gFDownloaded=fileInDir;
	    	                    return true;
	    	                } else {
	    	                	System.out.print(".");
	    	                }
	    	            }
	    	            return false;
	    	        });   
	    	 
	    	//gFDownloaded = new File("C:\\ppms\\download\\incident-80e34b61f3d5449b9ce63ac4c670b14c.csv");
	    	if (gFDownloaded!=null) {
	    	        	System.out.println(gFDownloaded.getPath());
	    	        	
	    	        	//process file
	    	            File file = gFDownloaded;


	    	    	    try { 
	    	    	  
	    	    	        // Create an object of filereader 
	    	    	        // class with CSV file as a parameter. 
	    	    	        //FileReader filereader = new FileReader(gFDownloaded.getPath());     	    	  
	    	    	      

	    	    	        Csvparser obj = new Csvparser();
	    	    	        List<String[]> result = obj.readFile(file, 1);

	    	    	        int listIndex = 0;
	    	    	        
	    	    	        
	    	    	        if (sReportType==null) {
	    	    	        	
	    	    	        	
	    	    	        } else if (sReportType.equals("INCTASK")) {
	    	    	        	
	    	    	        	
	    	    	        	clIncTask clinctask = new clIncTask();
	    	    	        	//Incident Report
	    	    	        	for (String[] arrays : result) {
		    	    	        	int curlistIndex=listIndex;
		    	    	        	if (listIndex %100 ==0 )System.gc();
		    	    	        	listIndex++;
		    	    	            //System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));

		    	    	            int index = 1;
		    	    	            
		    	    	            for (String array : arrays) {
		    	    	                //System.out.println(index++ + " : " + array);
		    	    	            
			    	    	            switch (index++) {
			    	    	            
			    	    	            	default:  clinctask.list.add(array);break;
			 	    	                    
										 
			 	    	                }
		 	    	                 
		 	    	                    
		    	    	               
		    	    	            } 
		    	    	            int tries=0;
		    	    	            while (tries<2) {
			    	    	            boolean rslt=clinctask.Load();
				    	    	            if (rslt) {
				    	    	            	break;
				    	    	            } else {
				    	    	            	 System.out.println("line["+curlistIndex+"]: Retry to update db ... "+tries); 
				    	    	            	 tries++;
				    	    	            	 System.gc();
				    	    	            }
		    	    	            	}
		    	    	            	//System.out.println("line["+curlistIndex+"]: completed"); 
		    	    	            
		    	    	            	clinctask.list.clear();
	    	    	        	}
	    	    	        	
	    	    	        	
	    	    	        	//END Incident Task Report
	    	    	        	clinctask.close();
	    	    	        
	    	    	         	
	    	    	       
	    	    	        
	    	    	        } else if (sReportType.equals("INCIDENT")) {
	    	    	        	
	    	    	        	
	    	    	        	clIncident clincident = new clIncident();
	    	    	        	//Incident Report
	    	    	        	for (String[] arrays : result) {
		    	    	        	int curlistIndex=listIndex;
		    	    	        	if (listIndex %100 ==0 )System.gc();
		    	    	        	listIndex++;
		    	    	           // System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));

		    	    	            int index = 1;
		    	    	            
		    	    	            for (String array : arrays) {
		    	    	                //System.out.println(index++ + " : " + array);
		    	    	            
			    	    	            switch (index++) {
			    	    	            
			    	    	            	default:  clincident.list.add(array);break;
			 	    	                    
										 
			 	    	                }
		 	    	                 
		 	    	                    
		    	    	               
		    	    	            } 
		    	    	            int tries=0;
		    	    	            while (tries<2) {
			    	    	            boolean rslt=clincident.Load();
				    	    	            if (rslt) {
				    	    	            	break;
				    	    	            } else {
				    	    	            	 System.out.println("line["+curlistIndex+"]: Retry to update db ... "+tries); 
				    	    	            	 tries++;
				    	    	            	 System.gc();
				    	    	            }
		    	    	            	}
		    	    	            	//System.out.println("line["+curlistIndex+"]: completed"); 
		    	    	            
		    	    	            clincident.list.clear();
	    	    	        	}
	    	    	        	
	    	    	        	
	    	    	        	//END Incident Report
	    	    	        	clincident.close();
	    	    	        
	    	    	        
	    	    	        } else if (sReportType.equals("SCTASK")) {
	    	    	        	
	    	    	        	
	    	    	        	
	    	    	        	//SLA REport
	    	    	        	for (String[] arrays : result) {
		    	    	        	int curlistIndex=listIndex;
		    	    	        	if (listIndex %100 ==0 )System.gc();
		    	    	        	listIndex++;
		    	    	            //System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));

		    	    	            int index = 1;
		    	    	            clScTask clSCTask = new clScTask(gDBName);
		    	    	            for (String array : arrays) {
		    	    	                //System.out.println(index++ + " : " + array);
		    	    	            
			    	    	            switch (index++) {
			    	    	            case 1:clSCTask.setNumber(array);break;
			    	    	            case 2:clSCTask.setCorrelation_id(array);break;
			    	    	            case 3:clSCTask.setPriority(array);break;
			    	    	            case 4:clSCTask.setState(array);break;
			    	    	            case 5:clSCTask.setSys_created_on(array);break;
			    	    	            case 6:clSCTask.setClosed_at(array);break;
			    	    	            case 7:clSCTask.setSys_updated_on(array);break;
			    	    	            case 8:clSCTask.setDue_date(array);break;
			    	    	            case 9:clSCTask.setWork_start(array);break;
			    	    	            case 10:clSCTask.setWork_end(array);break;
			    	    	            case 11:clSCTask.setCalendar_duration(array);break;
			    	    	            case 12:clSCTask.setRequest_number(array);break;
			    	    	            case 13:clSCTask.setRequest_opened_by(array);break;
			    	    	            case 14:clSCTask.setAssignment_group(array);break;
			    	    	            case 15:clSCTask.setAssigned_to(array);break;
			    	    	            case 16:clSCTask.setRequest_item_sla_due(array);break;
			    	    	            case 17:clSCTask.setSys_class_name(array);break;
			    	    	            case 18:clSCTask.setSys_created_by(array);break;
			    	    	            case 19:clSCTask.setSys_updated_by(array);break;
			    	    	            case 20:clSCTask.setClosed_by(array);break;
			    	    	            case 21:clSCTask.setShort_description(array);break;
			    	    	            case 22:clSCTask.setDescription(array);break;
			    	    	            default: clSCTask.setDescription(clSCTask.getDescription()+array);break;
			 	    	                    
										 
			 	    	                   }
		 	    	                 
		 	    	                    
		    	    	               
		    	    	            	} 
		    	    	            int tries=0;
		    	    	            while (tries<2) {
			    	    	            boolean rslt=clSCTask.dbLoadData();
				    	    	            if (rslt) {
				    	    	            	break;
				    	    	            } else {
				    	    	            	 System.out.println("line["+curlistIndex+"]: Retry to update db ... "+tries); 
				    	    	            	 tries++;
				    	    	            	 System.gc();
				    	    	            }
		    	    	            	}
		    	    	            	//System.out.println("line["+curlistIndex+"]: completed"); 
		    	    	            
		    	    	            
	    	    	        		}
	    	    	        		//END SLA Report
	    	    	        	
	    	    	        	}
	    	    	        else if (sReportType.equals("CHANGE")) {
	    	    	        	//SLA REport
	    	    	        	for (String[] arrays : result) {
		    	    	        	int curlistIndex=listIndex;
		    	    	        	if (listIndex %100 ==0 )System.gc();
		    	    	        	listIndex++;
		    	    	            //System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));

		    	    	            int index = 1;
		    	    	            clChangeTask clChgTask = new clChangeTask();
		    	    	            for (String array : arrays) {
		    	    	                //System.out.println(index++ + " : " + array);
		    	    	            
			    	    	            switch (index++) {
			    	    	            case 1:clChgTask.setNumber(array);break;
			    	    	            case 2:clChgTask.setChange_request(array);break;
			    	    	            case 3:clChgTask.setCorrelation_id(array);break;
			    	    	            case 4:clChgTask.setActive(array);break;
			    	    	            case 5:clChgTask.setActivity_due(array);break;
			    	    	            case 6:clChgTask.setAdditional_assignee_list(array);break;
			    	    	            case 7:clChgTask.setApproval(array);break;
			    	    	            case 8:clChgTask.setApproval_history(array);break;
			    	    	            case 9:clChgTask.setApproval_set(array);break;
			    	    	            case 10:clChgTask.setAssigned_to(array);break;
			    	    	            case 11:clChgTask.setAssignment_group(array);break;
			    	    	            case 12:clChgTask.setBusiness_duration(array);break;
			    	    	            case 13:clChgTask.setWork_start(array);break;
			    	    	            case 14:clChgTask.setWork_end(array);break;
			    	    	            case 15:clChgTask.setSys_created_on(array);break;
			    	    	            case 16:clChgTask.setClosed_at(array);break;
			    	    	            case 17:clChgTask.setSys_updated_on(array);break;
			    	    	            case 18:clChgTask.setSys_created_by(array);break;
			    	    	            case 19:clChgTask.setPriority(array);break;
			    	    	            case 20:clChgTask.setChange_request_start_date(array);break;
			    	    	            case 21:clChgTask.setChange_request_end_date(array);break;
			    	    	            case 22:clChgTask.setChange_request_priority(array);break;
			    	    	            case 23:clChgTask.setChange_request_requested_by_date(array);break;
			    	    	            case 24:clChgTask.setChange_request_u_request_by_end_date(array);break;
			    	    	            case 25:clChgTask.setChange_request_risk(array);break;
			    	    	            case 26:clChgTask.setChange_request_state(array);break;
			    	    	            case 27:clChgTask.setDbCreatedOn(array);break;
			    	    	            case 28:clChgTask.setDbUpdatedOn(array);break;

			    	    	            default: break;
			 	    	                    
										 
			 	    	                   }
		 	    	                 
		 	    	                    
		    	    	               
		    	    	            	} 
		    	    	            int tries=0;
		    	    	            while (tries<2) {
			    	    	            boolean rslt=clChgTask.dbLoadData();
				    	    	            if (rslt) {
				    	    	            	//update change ticket
				    	    	            	clTicket cltix= new clTicket(gDBName);
				    	    	            	cltix.updateParentTicket(clChgTask.getNumber(), clChgTask.getChange_request());
				    	    	            	break;
				    	    	            } else {
				    	    	            	 System.out.println("line["+curlistIndex+"]: Retry to update db ... "+tries); 
				    	    	            	 tries++;
				    	    	            	 System.gc();
				    	    	            }
		    	    	            	}
		    	    	            	//System.out.println("line["+curlistIndex+"]: completed"); 
		    	    	            
		    	    	            
	    	    	        		}
	    	    	        		//END SLA Report
	    	    	        
	    	    	        }
	    	    	        
	    	    	    } 
	    	    	    catch (Exception e) { 
	    	    	        e.printStackTrace(); 
	    	    	    } 

	    	        	
	    	        	//remove the file after processed
	    	    	    try {
	    	        	String sNewFile ="c:\\ppms\\archive\\"+gDBName+"\\"+gFDownloaded.getName().replace(".csv", "-"+generateRandomStringByUUIDNoDash()+".csv");
	    	        	moveFile(gFDownloaded.getPath(), sNewFile);
	    	    	    } catch (Exception e) {
	    	    	    	System.out.println("ERROR: downloadReport: " + sURL);
	    	    		      System.out.println(e.getMessage());
	    	    	    }
	    	        	
	    	}
	      
	    } catch (Exception e) {
	      System.out.println("ERROR: downloadReportCapitaLand: " + sURL);
	      System.out.println(e.getMessage());
	    } 
	  }
	  
  
  public static void downloadReport(String sReportID, String sReportType) {
	    String sContent = "";
	    String sURL = "";
	    try {
	    	
	    	
	      sURL = "https://dimensiondataservices.service-now.com/sys_report_template.do?CSV&jvar_report_id=" + sReportID;
	      //driver.get("https://purnama.sidhi%40global.ntt:P@ssw0rd@dimensiondataservices.service-now.com/sys_report_template.do?CSV&jvar_report_id=b32219791bf224d822e92f072d4bcbb7");
	      
	      gdriver.get(sURL);
	      System.out.print("Downloading report file : " + sReportID);	      
	      File dir = new File("C:\\ppms\\download\\"+gDBName);
	      
	     
	      FluentWait<WebDriver> wait = new FluentWait<WebDriver>(gdriver);
	    	        wait.pollingEvery(5, TimeUnit.SECONDS);
	    	        wait.withTimeout(120, TimeUnit.MINUTES);
	    	        wait.until(x -> {
	    	            File[] filesInDir = dir.listFiles();
	    	            for (File fileInDir : filesInDir) {
	    	                if (fileInDir.getName().endsWith("csv")) {
	    	                	System.out.println("found");	
	    	                	gFDownloaded=fileInDir;
	    	                    return true;
	    	                } else {
	    	                	System.out.print(".");
	    	                }
	    	            }
	    	            return false;
	    	        });   
	    	 
	    	//gFDownloaded = new File("C:\\ppms\\download\\incident-80e34b61f3d5449b9ce63ac4c670b14c.csv");
	    	if (gFDownloaded!=null) {
	    	        	System.out.println(gFDownloaded.getPath());
	    	        	
	    	        	//process file
	    	            File file = gFDownloaded;
//	    	            FileReader filereader = new FileReader(file);


	    	    	    try { 
	    	    	  
	    	    	        // Create an object of filereader 
	    	    	        // class with CSV file as a parameter. 
//	    	    	        FileReader filereader = new FileReader(gFDownloaded.getPath());  
	    	    	      

	    	    	        Csvparser obj = new Csvparser();
	    	    	        List<String[]> result = obj.readFile(file, 1);
	    	    	        
//	    	    			
//	    	    			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
//	    	    			List<String[]> result = csvReader.readAll();

	    	    	        int listIndex = 0;
	    	    	        
	    	    	        
	    	    	        if (sReportType==null) {
	    	    	        for (String[] arrays : result) {
	    	    	        	int curlistIndex=listIndex;
	    	    	        	listIndex++;
	    	    	            //System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));
	    	    	        	if (listIndex %100 ==0 )System.gc();
	    	    	            int index = 1;
	    	    	            clTicket cltix = new clTicket(gDBName);
	    	    	            for (String array : arrays) {
	    	    	                //System.out.println(index++ + " : " + array);
	    	    	            
	    	    	            switch (index++) {
	 	    	                    case 1:cltix.setNumber(array);break;
	 	    	                    case 2:cltix.setU_major_task(array);break;
	 	    	                    case 3:cltix.setContact_type(array);break;
	 	    	                    case 4:cltix.setU_ext_ref_no_calc(array);break;
	 	    	                    case 5:cltix.setSys_created_on(array);break;
	 	    	                    case 6:cltix.setClosed_at(array);break;
	 	    	                    case 7:cltix.setU_contract(array);break;
	 	    	                    case 8:cltix.setU_vip(array);break;
	 	    	                    case 9:cltix.setU_caller(array);break;
	 	    	                    case 10:cltix.setU_caller_email(array);break;
	 	    	                    case 11:cltix.setU_requested_for(array);break;
	 	    	                    case 12:cltix.setU_requested_for_email(array);break;
	 	    	                    case 13:cltix.setCompany(array);break;
	 	    	                    case 14:cltix.setU_product(array);break;
	 	    	                    case 15:cltix.setU_product_cmdb_ci_class(array);break;
	 	    	                    case 16:cltix.setU_product_u_erp_reference(array);break;
	 	    	                    case 17:cltix.setU_product_u_part_number(array);break;
	 	    	                    case 18:cltix.setU_product_name(array);break;
	 	    	                    case 19:cltix.setU_classification(array);break;
	 	    	                    case 20:cltix.setU_classification_u_classification_0(array);break;
	 	    	                    case 21:cltix.setU_classification_u_classification_1(array);break;
	 	    	                    case 22:cltix.setU_classification_u_classification_2(array);break;
	 	    	                    case 23:cltix.setU_classification_u_classification_path(array);break;
	 	    	                    case 24:cltix.setPriority(array);break;
	 	    	                    case 25:cltix.setU_next_step(array);break;
	 	    	                    case 26:cltix.setU_next_step_displayed(array);break;
	 	    	                    case 27:cltix.setState(array);break;
	 	    	                    case 28:cltix.setIncident_state(array);break;
	 	    	                    //case 29:break;
	 	    	                    case 29:cltix.setShort_description(array);break;
	 	    	                    case 30:cltix.setU_owner_group(array);break;
	 	    	                    case 31:cltix.setU_owner(array);break;
	 	    	                    case 32:cltix.setU_responsible_owner_group(array);break;
	 	    	                    case 33:cltix.setU_responsible_owner(array);break;
	 	    	                    case 34:cltix.setAssignment_group(array);break;
	 	    	                    case 35:cltix.setAssigned_to(array);break;
	 	    	                    case 36:cltix.setU_accepted(array);break;
	 	    	                    case 37:cltix.setU_effort(array);break;
	 	    	                    case 38:cltix.setCalendar_stc(array);break;
	 	    	                    case 39:cltix.setSys_updated_on(array);break;
	 	    	                    case 40:cltix.setSys_updated_by(array);break;
	 	    	                    case 41:cltix.setSys_created_by(array);break;
	 	    	                    case 42:cltix.setOpened_by(array);break;
	 	    	                    case 43:cltix.setU_breach_code(array);break;
	 	    	                    case 44:cltix.setU_breached(array);break;
	 	    	                    case 45:cltix.setSys_class_name(array);break;
	 	    	                    case 46:cltix.setComments(array);break;
	 	    	                    case 47:cltix.setU_breach_caused_by(array);break;
	 	    	                    case 48:cltix.setU_breach_comments(array);break;
	 	    	                    case 49:cltix.setBusiness_duration(array);break;
	 	    	                    case 50:cltix.setSla_due(array);break;
	 	    	                    case 51:cltix.setU_task_delay_comments(array);break;
	 	    	                    case 52:cltix.setCalendar_duration(array);break;
	 	    	                    case 53:cltix.setU_estimated_duration(array);break;
	 	    	                    case 54:cltix.setU_resolved_by(array);break;
	 	    	                    case 55:cltix.setU_group_reassign_count(array);break;
	 	    	                    case 56:cltix.setU_assignee_reassign_count(array);break;
	 	    	                    case 57:cltix.setU_technology_u_name(array);break;
	 	    	                    case 58:cltix.setU_auto_close_milestone(array);break;
	 	    	                    case 59:cltix.setSys_mod_count(array);break;
	 	    	                    case 60:cltix.setU_resolution_code(array);break;
	 	    	                    case 61:cltix.setU_task_resolution_code(array);break;
	 	    	                    case 62:cltix.setU_task_rootcause(array);break;
	 	    	                    case 63:cltix.setU_task_rootcause_u_classification_0(array);break;
	 	    	                    case 64:cltix.setU_task_rootcause_u_classification_1(array);break;
	 	    	                    case 65:cltix.setU_task_rootcause_u_classification_2(array);break;
	 	    	                    case 66:cltix.setU_task_rootcause_u_classification_path(array);break;
	 	    	                    
	 	    	                    //Email
	 	    	                    case 67:cltix.setU_owner_group_email(array);break;
	 	    	                    case 68:cltix.setU_owner_email(array);break;
	 	    	                    case 69:cltix.setU_responsible_owner_group_email(array);break;
	 	    	                    case 70:cltix.setU_responsible_owner_email(array);break;
	 	    	                    case 71:cltix.setAssignment_group_email(array);break;
	 	    	                    case 72:cltix.setAssigned_to_email(array);break;
	 	    	                    
	 	    	                    
	 	    	                    case 73:cltix.setU_root_cause_comments(array);break;
	 	    	                    case 74:cltix.setU_sip_information(array);break;
	 	    	                    case 75:cltix.setU_auto_close_acceptance(array);break;
	 	    	                    case 76:cltix.setClose_notes(array);break;
	 	    	                    default: cltix.setClose_notes(cltix.getClose_notes()+array);break;
	 	    	                    
									/*
									 * case 71:cltix.setU_client_closure_comment(array);break; case
									 * 72:cltix.setWork_notes(array);break; case 73:cltix.setIdMHIS(array);break;
									 * case 74:cltix.setIdCapitaLand(array);break; case
									 * 75:cltix.setP1A(array);break; case 76:cltix.setP1R(array);break; case
									 * 77:cltix.setP2A(array);break; case 78:cltix.setP2R(array);break; case
									 * 79:cltix.setP3A(array);break; case 80:cltix.setP3R(array);break; case
									 * 81:cltix.setP4A(array);break; case 82:cltix.setP4R(array);break; case
									 * 83:cltix.setDbCreatedOn(array);break; case
									 * 84:cltix.setDbUpdatedOn(array);break;
									 */                    
	 	    	                    }
	 	    	                 
	 	    	                    
	    	    	               
	    	    	            } 
	    	    	            int tries=0;
	    	    	            while (tries<4) {
		    	    	            boolean rslt=cltix.dbLoadTicket();
		    	    	            if (rslt) {
		    	    	            	break;
		    	    	            } else {
		    	    	            	 System.out.println("line["+curlistIndex+"]: Retry to update db ... "+tries); 
		    	    	            	 tries++;
		    	    	            }
	    	    	            }
	    	    	            //System.out.println("line["+curlistIndex+"]: completed"); 
	    	    	        } 
	    	    	        
	    	    	        
	    	    	        
	    	    	        } else if (sReportType.equals("SLA")) {
	    	    	        	
	    	    	        	
	    	    	        	
	    	    	        	//SLA REport
	    	    	        	for (String[] arrays : result) {
		    	    	        	int curlistIndex=listIndex;
		    	    	        	if (listIndex %100 ==0 )System.gc();
		    	    	        	listIndex++;
		    	    	            //System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));

		    	    	            int index = 1;
		    	    	            clSLA clSLA = new clSLA(gDBName);
		    	    	            for (String array : arrays) {
//		    	    	                System.out.println(index + " : " + array);
		    	    	            
			    	    	            switch (index++) {
				    	    	            case 1: clSLA.setU_contract(array);break;
				    	    	            case 2: clSLA.setSla_name(array);break;
				    	    	            case 3: clSLA.setTask(array);break;
				    	    	            case 4: clSLA.setTask_sys_class_name(array);break;
				    	    	            case 5: clSLA.setTask_u_contract(array);break;
				    	    	            case 6: clSLA.setTask_state(array);break;
				    	    	            case 7: clSLA.setTask_company(array);break;
				    	    	            case 8: clSLA.setSla_type(array);break;
				    	    	            case 9: clSLA.setU_current_stage(array);break;
				    	    	            case 10: clSLA.setU_escalation(array);break;
				    	    	            case 11: clSLA.setTask_priority(array);break;
				    	    	            case 12: clSLA.setTask_sys_updated_on(array);break;
				    	    	            case 13: clSLA.setTask_sys_created_on(array);break;
				    	    	            case 14: clSLA.setHas_breached(array);break;
				    	    	            case 15: clSLA.setPercentage(array);break;
				    	    	            case 16: clSLA.setStart_time(array);break;
				    	    	            case 17: clSLA.setEnd_time(array);break;
				    	    	            case 18: clSLA.setTime_left(array);break;
				    	    	            case 19: clSLA.setPause_duration(array);break;
				    	    	            case 20: clSLA.setPlanned_end_time(array);break;
				    	    	            case 21: clSLA.setDuration(array);break;
				    	    	            case 22: clSLA.setPause_time(array);break;
				    	    	            case 23: clSLA.setOriginal_breach_time(array);break;
				    	    	            case 24: clSLA.setBusiness_percentage(array);break;
				    	    	            case 25: clSLA.setBusiness_time_left(array);break;
				    	    	            case 26: clSLA.setBusiness_duration(array);break;
				    	    	            case 27: clSLA.setBusiness_pause_duration(array);break;
				    	    	            case 28: clSLA.setU_breach_reason_code(array);break;
				    	    	            case 29: clSLA.setU_breach_comments(array);break;
				    	    	            case 30: clSLA.setActive(array);break;
				    	    	            case 31: clSLA.setU_name(clSLA.getStart_time().subSequence(clSLA.getStart_time().length()-8, clSLA.getStart_time().length())+array);break;
				    	    	            case 32: clSLA.setSys_updated_on(array);break;
				    	    	            case 33: clSLA.setSys_updated_by(array);break;
			 	    	                    
										 
			 	    	                   }
		 	    	                 
		 	    	                    
		    	    	               
		    	    	            	} 
		    	    	            int tries=0;
		    	    	            while (tries<2) {
			    	    	            boolean rslt=clSLA.dbLoadSLA();
			    	    	            if (rslt) {
			    	    	            	break;
			    	    	            } else {
			    	    	            	 System.out.println("line["+curlistIndex+"]: Retry to update db ... "+tries); 
			    	    	            	 tries++;
			    	    	            	 System.gc();
			    	    	            }
		    	    	            }
		    	    	            //System.out.println("line["+curlistIndex+"]: completed"); 
	    	    	        	}
	    	    	        	
	    	    	        	
	    	    	        	
		    	    	    } else if (sReportType.equals("Reassign")) {
		    	    	    	System.out.println(sReportType+" : Started");
		    	    	    	for (String[] arrays : result) {
		    	    	        	int curlistIndex=listIndex;
		    	    	        	listIndex++;
		    	    	            //System.out.println("\nString[" + curlistIndex + "] : " + Arrays.toString(arrays));
		    	    	        	if (listIndex %100 ==0 )System.gc();
		    	    	            int index = 1;
		    	    	            String sTicketNo="";
		    	    	            for (String array : arrays) {
		    	    	                //System.out.println(index++ + " : " + array);
		    	    	            
		    	    	            switch (index++) {
		 	    	                    case 1:sTicketNo=array;break;
		 	    	                    
		 	    	                    default:break;
		 	    	                    
										/*
										 * case 71:cltix.setU_client_closure_comment(array);break; case
										 * 72:cltix.setWork_notes(array);break; case 73:cltix.setIdMHIS(array);break;
										 * case 74:cltix.setIdCapitaLand(array);break; case
										 * 75:cltix.setP1A(array);break; case 76:cltix.setP1R(array);break; case
										 * 77:cltix.setP2A(array);break; case 78:cltix.setP2R(array);break; case
										 * 79:cltix.setP3A(array);break; case 80:cltix.setP3R(array);break; case
										 * 81:cltix.setP4A(array);break; case 82:cltix.setP4R(array);break; case
										 * 83:cltix.setDbCreatedOn(array);break; case
										 * 84:cltix.setDbUpdatedOn(array);break;
										 */                    
		 	    	                    }
		 	    	                 
		 	    	                    
		    	    	               
		    	    	            } 
		    	    	            
		    	    	          
			    	    	            if (sTicketNo!=null) {
			    	    	            	if (sTicketNo.contains("ICM")) {
			    	    	            		snowReassign("incident",sTicketNo, "Group.CL.SD", null);
			    	    	            	} else if (sTicketNo.contains("SVR")) {
			    	    	            		snowReassign("u_request",sTicketNo, "Group.CL.SD", null);
			    	    	            	}
			    	    	            }
			    	    	      
		    	    	            //System.out.println("line["+curlistIndex+"]: completed"); 
		    	    	        } 
		    	    	        
		    	    	    	 
		    	    	        
		    	    	    } 
	    	    	        
	    	    	        System.out.println(sReportType+" : Completed");
	    	    	        
	    	    	        
	    	    	    }
	    	    	    catch (Exception e) { 
	    	    	        e.printStackTrace(); 
	    	    	    }
//	    	    	    finally {
//	    	    	    	filereader.close();
//	    	    	    	}

	    	        	
	    	        	//remove the file after processed
	    	    	    try {
	    	        	String sNewFile ="c:\\ppms\\archive\\"+gDBName+"\\"+gFDownloaded.getName().replace(".csv", "-"+generateRandomStringByUUIDNoDash()+".csv");
	    	        	moveFile(gFDownloaded.getPath(), sNewFile);
	    	        	 System.out.println(sReportType+" : File moved "+sNewFile);
	    	    	    } catch (Exception e) {
	    	    	    	System.out.println("ERROR: downloadReport: " + sURL);
	    	    		      System.out.println(e.getMessage());
	    	    	    }
	    	    	    
	    	        	
	    	}
	      
	    } catch (Exception e) {
	      System.out.println("ERROR: downloadReport: " + sURL);
	      System.out.println(e.getMessage());
	    } 
	  }
	  
  
  public static void sfdcReportCase(String sReportID) {
	    String sContent = "";
	    String sURL = "";
	    try {
	      sURL = "https://nttlimited-global.my.salesforce.com/" + sReportID;
	      gdriver.get(sURL);
	      sContent = gdriver.getPageSource();
	      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
	        .withTimeout(5L, TimeUnit.MINUTES)
	        .pollingEvery(1L, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class);
	      By css = By.cssSelector("tr[class=\"grandTotal grandTotalTop\"]");
	      WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
	      sContent = gdriver.getPageSource();
	      Document doc = null;
	      doc = Jsoup.parse(sContent);
	      Elements rows = doc.select("tr");
	      int i = 0;
	      for (Element tr : rows) {
	        String sClass = tr.attr("class");
	        if (sClass.equalsIgnoreCase("odd") || sClass.equalsIgnoreCase("even")) {
	          Elements tds = tr.select("td");
	          int index = 0;
	          opportunityCase oppCase = new opportunityCase();
	          String s="";
	          for (Element td : tds) {
	            String sValue = normalize(td.text().trim());
	            switch (index) {
	              case 0: //opportunity
	            	 
	            		  s=td.select("a").attr("href");
	            		  if (s.length()>0) {
	            			  oppCase.setIdopportunity(getURLValue(td.select("a").attr("href"), "/", 15));
	            		  } else 	            	 
	            		  oppCase.setIdopportunity("");
	            	  
	                break;
	              case 1:
	                oppCase.setOpportunityowner(sValue);
	                break;
	              case 2: //Parent Case ID
	            	  oppCase.setParentidcase(sValue);
	                break;
	              case 3: //Parent Case Number
	            	  oppCase.setParentcase(sValue);
	                break;
	              case 4:// Case ID
	            	  oppCase.setIdcase(sValue);
	                break;
	              case 5: //Case Number
	                oppCase.setCasenumber(sValue);
	                break;
	              case 6: //Case Owner
	            	  s=td.select("a").attr("href");
            		  if (s.length()>0) {
            			  oppCase.setCaseidowner(getURLValue(td.select("a").attr("href"), "/", 15));
            		  } else 	            	 
            		  oppCase.setCaseidowner("");
	            	oppCase.setCaseowner(sValue);
	                break;
	              case 7: //Subject
	            	  oppCase.setSubject(sValue);
	                break;
	              case 8: //Description
	            	  oppCase.setDescription(sValue);
	                break;
	              case 9: //Close remark
	            	  oppCase.setCloseremark(sValue);
	                break;
	              case 10: //Status
	            	  oppCase.setStatus(sValue);
	                break;
	              case 11: //Priority
	            	  oppCase.setPriority(sValue);
	                break;
	              case 12: //Due Date
	            	  oppCase.setDuedate(sValue);
	                break;
	              case 13: //Age(minutes)
	            	  oppCase.setAge(sValue);
	                break;
	              case 14: //Contact Name
	            	  oppCase.setContactname(sValue);
	                break;
	              case 15: //Contact Email
	            	  oppCase.setContactemail(sValue);
	                break;
	              case 16: //Date/time Opened
	            	  oppCase.setCreatedon(sValue);
	                break;
	              case 17: //CreatedBy
	            	  s=td.select("a").attr("href");
            		  if (s.length()>0) {
            			  oppCase.setCreatedid(getURLValue(td.select("a").attr("href"), "/", 15));
            		  } else 	            	 
            		  oppCase.setCreatedid("");
	            	  oppCase.setCreatedby(sValue);
	                break;
	              case 18: //DateTime Last Modified
	            	  oppCase.setUpdatedon(sValue);
	                break;
	              case 19: //last modified by
	            	  s=td.select("a").attr("href");
            		  if (s.length()>0) {
            			  oppCase.setUpdatedid(getURLValue(td.select("a").attr("href"), "/", 15));
            		  } else 	            	 
            		  oppCase.setUpdatedid("");
	            	  oppCase.setUpdatedby(sValue);
	                break;
	              case 20: //Datetime Closed
	            	  oppCase.setClosedon(sValue);
	                break;
	             
	            } 
	            index++;
	          } 
	          oppCase.dbUpdateOpportunityCase();
	        } 
	      } 
	    } catch (Exception e) {
	      System.out.println("ERROR: Timesheet: " + sURL);
	      System.out.println(e.getMessage());
	    } 
	  }
	  
  
  public static void sfdcReportOpportunity(String sReportID) {
    String sContent = "";
    String sURL = "";
    try {
      sURL = "https://nttlimited-global.my.salesforce.com/" + sReportID;
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(5L, TimeUnit.MINUTES)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By css = By.cssSelector("tr[class=\"grandTotal grandTotalTop\"]");
      WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
      sContent = gdriver.getPageSource();
      Document doc = null;
      doc = Jsoup.parse(sContent);
      Elements rows = doc.select("tr");
      int i = 0;
      for (Element tr : rows) {
        String sClass = tr.attr("class");
        if (sClass.equalsIgnoreCase("odd") || sClass.equalsIgnoreCase("even")) {
          Elements tds = tr.select("td");
          int index = 0;
          opportunity opp = new opportunity();
          for (Element td : tds) {
            String sValue = normalize(td.text().trim());
            switch (index) {
              case 0:
                opp.setIdrecord(sValue);
                break;
              case 1:
                opp.setIdopportunity(sValue);
                break;
              case 2:
                opp.setName(sValue);
                break;
              case 3:
                opp.setDescription(sValue);
                break;
              case 4:
                opp.setNextstep(sValue);
                break;
              case 5:
                opp.setType(sValue);
                break;
              case 6:
                opp.setRecordtype(sValue);
                break;
              case 7:
                opp.setSource(sValue);
                break;
              case 8:
                opp.setPartner(sValue);
                break;
              case 9:
                opp.setCurrency(sValue);
                break;
              case 10:
                opp.setScore(sValue);
                break;
              case 11:
                opp.setProbability(sValue);
                break;
              case 12:
                opp.setAmount(sValue);
                break;
              case 13:
                opp.setAmountusd(sValue);
                break;
              case 14:
                opp.setForecast(sValue);
                break;
              case 15:
                opp.setStage(sValue);
                break;
              case 16:
                opp.setLaststagechange(sValue);
                break;
              case 17:
                opp.setCreateon(sValue);
                break;
              case 18:
                opp.setCloseon(sValue);
                break;
              case 19:
                opp.setUpdateon(sValue);
                break;
              case 20:
                opp.setIdcreateby(getURLValue(td.select("a").attr("href"), "/", 15));
                opp.setCreateby(sValue);
                break;
              case 21:
                opp.setIdaccount(sValue);
                break;
              case 22:
                opp.setAccountname(sValue);
                break;
              case 23:
                opp.setIndustry(sValue);
                break;
              case 24:
                opp.setSubindustry(sValue);
                break;
              case 25:
                opp.setIdparentaccount(sValue);
                break;
              case 26:
                opp.setParentaccount(sValue);
                break;
              case 27:
                opp.setRegion(sValue);
                break;
              case 28:
                opp.setSalesregion(sValue);
                break;
              case 29:
                opp.setSalesteam(sValue);
                break;
              case 30:
                opp.setCyclephase(sValue);
                break;
              case 31:
                opp.setWonreason(sValue);
                break;
              case 32:
                opp.setWondescription(sValue);
                break;
              case 33:
                opp.setWonamount(sValue);
                break;
              case 34:
                opp.setWonamountusd(sValue);
                break;
              case 35:
                opp.setSolutionstructure(sValue);
                break;
              case 36:
                opp.setSolutionscope(sValue);
                break;
              case 38:
                opp.setGeographic(sValue);
                break;
              case 39:
                opp.setModel(sValue);
                break;
              case 40:
                opp.setTechrevenueusd(sValue);
                break;
              case 41:
                opp.setTechgp(sValue);
                break;
              case 42:
                opp.setMsrevenueusd(sValue);
                break;
              case 43:
                opp.setMsgp(sValue);
                break;
              case 44:
                opp.setCsrevenueusd(sValue);
                break;
              case 45:
                opp.setCsgp(sValue);
                break;
              case 46:
                opp.setSsrevenueusd(sValue);
                break;
              case 47:
                opp.setSsgp(sValue);
                break;
              case 48:
                opp.setTsrevenueusd(sValue);
                break;
              case 49:
                opp.setTsgp(sValue);
                break;
              case 50:
                opp.setTotalgpusd(sValue);
                break;
              case 51:
                opp.setTechbgp(sValue);
                break;
              case 52:
                opp.setMsbgp(sValue);
                break;
              case 53:
                opp.setCsbgp(sValue);
                break;
              case 54:
                opp.setSsbgp(sValue);
                break;
              case 55:
                opp.setTsbgp(sValue);
                break;
              case 56:
                opp.setTotalbgp(sValue);
                break;
              case 57:
                opp.setCollaboration(sValue);
                break;
              case 58:
                opp.setCollaborationpartner(sValue);
                break;
              case 59:
                opp.setEngagementtype(sValue);
                break;
              case 60:
                opp.setPrime(sValue);
                break;
              case 61:
                opp.setDiscovery(sValue);
                break;
              case 62:
                opp.setGlobalcompetitor(sValue);
                break;
              case 63:
                opp.setGlobalcompetitorlost(sValue);
                break;
              case 64:
                opp.setOthercompetitor(sValue);
                break;
              case 65:
                opp.setOthercompetitorlost(sValue);
                break;
              case 66:
                opp.setAccountowner(sValue);
                break;
              case 67:
                opp.setAccountowneralias(sValue);
                break;
              case 68:
                opp.setLastmodifyby(sValue);
                break;
              case 69:
                opp.setLastmodifybyalias(sValue);
                break;
            } 
            index++;
          } 
          opp.dbUpdateOpportunity();
        } 
      } 
    } catch (Exception e) {
      System.out.println("ERROR: Timesheet: " + sURL);
      System.out.println(e.getMessage());
    } 
  }
  
  public static void sfdcReportOpportunityProduct(String sReportID) {
    String sContent = "";
    String sURL = "";
    try {
      sURL = "https://nttlimited-global.my.salesforce.com/" + sReportID;
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(5L, TimeUnit.MINUTES)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By css = By.cssSelector("tr[class=\"grandTotal grandTotalTop\"]");
      WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
      sContent = gdriver.getPageSource();
      Document doc = null;
      doc = Jsoup.parse(sContent);
      Elements rows = doc.select("tr");
      int i = 0;
      for (Element tr : rows) {
        String sClass = tr.attr("class");
        if (sClass.equalsIgnoreCase("odd") || sClass.equalsIgnoreCase("even")) {
          Elements tds = tr.select("td");
          int index = 0;
          product prod = new product();
          for (Element td : tds) {
            String sValue = normalize(td.text().trim());
            switch (index) {
              case 0:
                prod.setIdrecord(sValue);
                break;
              case 1:
                prod.setIdproductline(sValue);
                break;
              case 2:
                prod.setIdsystemproduct(sValue);
                break;
              case 3:
                prod.setProductname(sValue);
                break;
              case 4:
                prod.setBusinessunit(sValue);
                break;
              case 5:
                prod.setManufacturer(sValue);
                break;
              case 6:
                prod.setActive(sValue);
                break;
              case 7:
                prod.setProductcode(sValue);
                break;
              case 8:
                prod.setProductdescription(sValue);
                break;
              case 9:
                prod.setListprice(sValue);
                break;
              case 10:
                prod.setQuantity(sValue);
                break;
              case 11:
                prod.setServiceproduct(sValue);
                break;
              case 12:
                prod.setGtmpractice(sValue);
                break;
              case 13:
                prod.setGtmtheme(sValue);
                break;
              case 14:
                prod.setOffering(sValue);
                break;
              case 15:
                prod.setServicedivision(sValue);
                break;
              case 16:
                prod.setServiceelements(sValue);
                break;
              case 17:
                prod.setServiceorg(sValue);
                break;
              case 18:
                prod.setSolution(sValue);
                break;
              case 19:
                prod.setIdrecordopportunity(sValue);
                break;
              case 20:
                prod.setIdopportunity(getURLValue(td.select("a").attr("href"), "/", 15));
                prod.setOpportunityname(sValue);
                break;
              case 21:
                prod.setAmount(sValue);
                break;
              case 22:
                prod.setAmountusd(sValue);
                break;
              case 23:
                prod.setSalesprice(sValue);
                break;
              case 24:
                prod.setSalespriceusd(sValue);
                break;
              case 25:
                prod.setTotalprice(sValue);
                break;
              case 26:
                prod.setTotalpriceusd(sValue);
                break;
              case 27:
                prod.setExpectedproductamount(sValue);
                break;
              case 28:
                prod.setExpectedproductamountusd(sValue);
                break;
              case 29:
                prod.setIsmultiyearcontract(sValue);
                break;
              case 30:
                prod.setPoterm(sValue);
                break;
              case 31:
                prod.setPoexpiration(sValue);
                break;
              case 32:
                prod.setGp(sValue);
                break;
              case 33:
                prod.setGpusd(sValue);
                break;
              case 34:
                prod.setGpp(sValue);
                break;
              case 35:
                prod.setAcv(sValue);
                break;
              case 36:
                prod.setAcvusd(sValue);
                break;
              case 37:
                prod.setTcv(sValue);
                break;
              case 38:
                prod.setTcvusd(sValue);
                break;
              case 39:
                prod.setMcv(sValue);
                break;
              case 40:
                prod.setMcvusd(sValue);
                break;
              case 41:
                prod.setAcvgp(sValue);
                break;
              case 42:
                prod.setAcvgpusd(sValue);
                break;
              case 43:
                prod.setTcvgp(sValue);
                break;
              case 44:
                prod.setTcvgpusd(sValue);
                break;
              case 45:
                prod.setUpdateon(sValue);
                break;
              case 46:
                prod.setIdupdateby(getURLValue(td.select("a").attr("href"), "/", 15));
                prod.setUpdateby(sValue);
                break;
            } 
            index++;
          } 
          prod.dbUpdateOpportunityProduct();
        } 
      } 
    } catch (Exception e) {
      System.out.println("ERROR: Opportunity Product: " + sURL);
      System.out.println(e.getMessage());
    } 
  }
  
  public static void sfdcCase(String sIDCase) {
    String sContent = "";
    String sURL = "";
    try {
      File input = new File("c:\\ppms\\case-detail.html");
      Document doc = null;
      try {
        doc = Jsoup.parse(input, "UTF-8", "");
      } catch (IOException e) {
        e.printStackTrace();
      } 
      Elements rows = doc.select("table[class=\"detailList\"]").select("tr");
      int i = 0;
      String sPrevLabel = "";
      for (Element tr : rows) {
        Elements tds = tr.select("td");
        int index = 0;
        opportunity opp = new opportunity();
        for (Element td : tds) {
          String sClass = td.attr("class");
          String sValue = normalize(td.text().trim());
          if (sClass.contains("labelCol")) {
            sPrevLabel = sValue;
          } else if (sClass.contains("data")) {
            if (sPrevLabel.equalsIgnoreCase("Case Owner")) {
              String sLink = td.select("div").select("a").attr("href");
              System.out.println(String.valueOf(sPrevLabel) + "=" + sLink + "-" + sValue);
            } 
            if (sPrevLabel.equalsIgnoreCase("Requestor Name"))
              System.out.println(String.valueOf(sPrevLabel) + "=" + sValue); 
            if (sPrevLabel.equalsIgnoreCase("Status"))
              System.out.println(String.valueOf(sPrevLabel) + "=" + sValue); 
            if (sPrevLabel.equalsIgnoreCase("Opportunity")) {
              String sLink = td.select("div").select("a").attr("href");
              System.out.println(String.valueOf(sPrevLabel) + "=" + sLink + "-" + sValue);
            } 
            if (sPrevLabel.equalsIgnoreCase("Account Name")) {
              String sLink = td.select("div").select("a").attr("href");
              System.out.println(String.valueOf(sPrevLabel) + "=" + sLink + "-" + sValue);
            } 
            if (sPrevLabel.equalsIgnoreCase("Subject"))
              System.out.println(String.valueOf(sPrevLabel) + "=" + sValue); 
            if (sPrevLabel.equalsIgnoreCase("Description"))
              System.out.println(String.valueOf(sPrevLabel) + "=" + sValue); 
            if (sPrevLabel.equalsIgnoreCase("Due Date"))
              System.out.println(String.valueOf(sPrevLabel) + "=" + sValue); 
            sPrevLabel = "";
          } 
          index++;
        } 
      } 
    } catch (Exception e) {
      System.out.println("ERROR: Timesheet: " + sURL);
      System.out.println(e.getMessage());
    } 
  }
  
  public static  void resetDriverServiceNow() {
	    try {
	    	if (gdriver!=null) {
	    		  System.out.println("resetDriverServiceNow SessionID: " + gdriver.getSessionId());
	    		  System.out.println("resetDriverServiceNow Title: " + gdriver.getTitle());
	    	}
	    } catch (Exception e) {
	      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
	    } 
	    
	   
  }
  
  public static RemoteWebDriver getDriverServiceNow() {
    try {
    	if (gdriver!=null) {
	      gdriver.close();
	      gdriver.quit();
    	}
    } catch (Exception e) {
      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
    } 
    RemoteWebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("download.default_directory", "c:\\ppms\\download\\"+gDBName);
    prefs.put("download.prompt_for_download", false);
    options.setExperimentalOption("prefs", prefs);
    options.setExperimentalOption("useAutomationExtension", false);    
    options.addArguments("--headless");
    options.addArguments(new String[] { "--no-sandbox", "--disable-dev-shm-usage","--disable-gpu",  "--window-size=1920,1200", "--ignore-certificate-errors" });
    
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    options.addArguments(new String[] { "--ignore-certificate-errors" });
    DesiredCapabilities crcapabilities = DesiredCapabilities.chrome();
    crcapabilities.setCapability("goog:chromeOptions", options);
    crcapabilities.setCapability("acceptSslCerts", true);
    crcapabilities.setCapability("acceptInsecureCerts", true);
   
  
    System.setProperty("webdriver.chrome.logfile", "c:\\ppms\\chromedriver.log");
    System.setProperty("webdriver.chrome.driver", "c:\\ppms\\chromedriver.exe");
    ChromeDriverService service = null;
    try {
      service = (ChromeDriverService)((ChromeDriverService.Builder)(new ChromeDriverService.Builder())
        .usingAnyFreePort())
        .withVerbose(true)
        .build();
      service.start();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    driver = new RemoteWebDriver(service.getUrl(), (Capabilities)crcapabilities);

    
    driver.get("https://dimensiondataservices.service-now.com");
    try {
      driver.switchTo().alert().accept();
    } catch (WebDriverException ex) {
      System.out.println("Error=" + ex.getLocalizedMessage());
    } 
    try {
      Thread.sleep(5000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    Set handles = driver.getWindowHandles();
    System.out.println(handles);
    for (String handle1 : driver.getWindowHandles()) {
      System.out.println(handle1);
      System.out.println(driver.getCurrentUrl());
      System.out.println(driver.getSessionId());
      driver.switchTo().window(handle1);
    } 
    RemoteWebDriver remoteWebDriver1 = driver;
    String browserUrl = (String)remoteWebDriver1.executeScript("return window.top.location.href.toString()", new Object[0]);
    System.out.println("Your browser URL is " + browserUrl);
    /*
    String s = browserUrl;
    int loc = s.indexOf("rId=");
    grid = s.substring(loc + 4, loc + 42);
    System.out.println(grid);
    int loc2 = s.indexOf("sno=");
    gsno = s.substring(loc2 + 4, loc2 + 42);
    System.out.println(gsno);
    */
    return driver;
  }
  
  public static RemoteWebDriver getDriverServiceNowEdge() {
	    try {
	    	if (gdriver!=null) {
		      gdriver.close();
		      gdriver.quit();
	    	}
	    } catch (Exception e) {
	      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
	    } 
	    //RemoteWebDriver driver = null;
	    System.setProperty("webdriver.edge.verboseLogging", "false");
	    System.setProperty("webdriver.edge.logfile", "c:\\ppms\\logs\\edgedriver.log");
	    System.setProperty("webdriver.edge.driver", "c:\\ppms\\msedgedriver.exe");
	    EdgeOptions options = new EdgeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("download.default_directory", "c:\\ppms\\download\\"+gDBName);
	    prefs.put("download.prompt_for_download", false);
	    options.setExperimentalOption("prefs", prefs);
	    options.setExperimentalOption("useAutomationExtension", false);    
	    //options.addArguments("--headless");
	    options.addArguments(new String[] { "--no-sandbox", "--disable-dev-shm-usage","--disable-gpu",  "--window-size=1920,1200", "--ignore-certificate-errors" });
	    
	    //options.setBinary("C:\\ppms\\msedgedriver.exe");
	    EdgeDriverService service = EdgeDriverService.createDefaultService();
	    EdgeDriver driver = new EdgeDriver(service, options);
	    DesiredCapabilities crcapabilities = DesiredCapabilities.edge();
	    //driver = (EdgeDriver) new RemoteWebDriver(service.getUrl(), (Capabilities)crcapabilities);

	    
	    driver.get("https://dimensiondataservices.service-now.com");
	    try {
	      driver.switchTo().alert().accept();
	    } catch (WebDriverException ex) {
	      System.out.println("Error=" + ex.getLocalizedMessage());
	    } 
	    try {
	      Thread.sleep(5000L);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } 
	    Set handles = driver.getWindowHandles();
	    System.out.println(handles);
	    for (String handle1 : driver.getWindowHandles()) {
	      System.out.println(handle1);
	      System.out.println(driver.getCurrentUrl());
	      System.out.println(driver.getSessionId());
	      driver.switchTo().window(handle1);
	    } 
	 
	    /*
	    String s = browserUrl;
	    int loc = s.indexOf("rId=");
	    grid = s.substring(loc + 4, loc + 42);
	    System.out.println(grid);
	    int loc2 = s.indexOf("sno=");
	    gsno = s.substring(loc2 + 4, loc2 + 42);
	    System.out.println(gsno);
	    */
	    return driver;
	  }
  
  
  public static RemoteWebDriver getDriverServiceNowCL() {
	    try {
	    	if (gdriver!=null) {
		      gdriver.close();
		      gdriver.quit();
	    	}
	    } catch (Exception e) {
	      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
	    } 
	    RemoteWebDriver driver = null;
	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("download.default_directory", "c:\\ppms\\download\\"+gDBName);
	    prefs.put("download.prompt_for_download", false);
	    options.setExperimentalOption("prefs", prefs);
	    options.setExperimentalOption("useAutomationExtension", false);    
	    options.addArguments("--headless");
	    options.addArguments(new String[] { "--window-size=1920,1200", "--ignore-certificate-errors" });
	    
	    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	    options.addArguments(new String[] { "--ignore-certificate-errors" });
	    DesiredCapabilities crcapabilities = DesiredCapabilities.chrome();
	    crcapabilities.setCapability("goog:chromeOptions", options);
	    crcapabilities.setCapability("acceptSslCerts", true);
	    crcapabilities.setCapability("acceptInsecureCerts", true);
	   
	  
	    System.setProperty("webdriver.chrome.logfile", "c:\\ppms\\chromedriver.log");
	    System.setProperty("webdriver.chrome.driver", "c:\\ppms\\chromedriver.exe");
	    ChromeDriverService service = null;
	    try {
	      service = (ChromeDriverService)((ChromeDriverService.Builder)(new ChromeDriverService.Builder())
	        .usingAnyFreePort())
	        .withVerbose(true)
	        .build();
	      service.start();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	    driver = new RemoteWebDriver(service.getUrl(), (Capabilities)crcapabilities);

	    //driver.get("https://purnama.sidhi%40global.ntt:P@ssw0rd@//dimensiondataservices.service-now.com/sys_report_template.do?XML&jvar_report_id=b32219791bf224d822e92f072d4bcbb7");
	    driver.get("https://google.com");
	    try {
	      driver.switchTo().alert().accept();
	    } catch (WebDriverException ex) {
	      System.out.println("Error=" + ex.getLocalizedMessage());
	    } 
	    try {
	      Thread.sleep(5000L);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } 
	    Set handles = driver.getWindowHandles();
	    System.out.println(handles);
	    for (String handle1 : driver.getWindowHandles()) {
	      System.out.println(handle1);
	      System.out.println(driver.getCurrentUrl());
	      System.out.println(driver.getSessionId());
	      driver.switchTo().window(handle1);
	    } 
	    RemoteWebDriver remoteWebDriver1 = driver;
	    String browserUrl = (String)remoteWebDriver1.executeScript("return window.top.location.href.toString()", new Object[0]);
	    System.out.println("Your browser URL is " + browserUrl);
	    /*
	    String s = browserUrl;
	    int loc = s.indexOf("rId=");
	    grid = s.substring(loc + 4, loc + 42);
	    System.out.println(grid);
	    int loc2 = s.indexOf("sno=");
	    gsno = s.substring(loc2 + 4, loc2 + 42);
	    System.out.println(gsno);
	    */
	    return driver;
	  }
  
  
  public static RemoteWebDriver getDriverPowerBI() {
	    try {
	      gdriverPBI.close();
	      gdriverPBI.quit();
	    } catch (Exception e) {
	      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
	    } 
	    RemoteWebDriver driver = null;
	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("download.default_directory", "c:\\ppms\\download\\"+gDBName);
	    prefs.put("download.prompt_for_download", false);
	    options.setExperimentalOption("prefs", prefs);
	    options.setExperimentalOption("useAutomationExtension", false);    
	    //options.addArguments("--headless");
	    options.addArguments(new String[] { "--window-size=1920,1200", "--ignore-certificate-errors",
	    		"user-data-dir=c:\\ppms\\Chrome\\User Data\\"+gSession,
	    		"--profile-directory=Profile-"+gSession});
	 
	    
	    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	    options.addArguments(new String[] { "--ignore-certificate-errors" });
	    DesiredCapabilities crcapabilities = DesiredCapabilities.chrome();
	    crcapabilities.setCapability("goog:chromeOptions", options);
	    crcapabilities.setCapability("acceptSslCerts", true);
	    crcapabilities.setCapability("acceptInsecureCerts", true);
	   
	  
	    System.setProperty("webdriver.chrome.logfile", "c:\\ppms\\logs\\chromedriver-"+gSession+".log");
	    System.setProperty("webdriver.chrome.driver", "c:\\ppms\\chromedriver.exe");
	    ChromeDriverService service = null;
	    try {
	      service = (ChromeDriverService)((ChromeDriverService.Builder)(new ChromeDriverService.Builder())
	        .usingAnyFreePort())
	        .withVerbose(true)
	        .build();
	      service.start();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	    driver = new RemoteWebDriver(service.getUrl(), (Capabilities)crcapabilities);

	    
	    /*
	    String s = browserUrl;
	    int loc = s.indexOf("rId=");
	    grid = s.substring(loc + 4, loc + 42);
	    System.out.println(grid);
	    int loc2 = s.indexOf("sno=");
	    gsno = s.substring(loc2 + 4, loc2 + 42);
	    System.out.println(gsno);
	    */
	    return driver;
	  }
  
  //https://app.powerbi.com/groups/9d707749-d22a-4b02-af38-6ef3377d5b25/list/dashboards
  
  
  public static void initPBI(RemoteWebDriver tmpDriver, String sUsername, String sPassword, String sGroupName, boolean isKMIEnable) {
	  if (sGroupName==null) sGroupName="me";
	  String sURL = "https://app.powerbi.com/groups/"+sGroupName+"/list/dataflows";
	  tmpDriver.get(sURL);
      String sContent = tmpDriver.getPageSource();
	    FluentWait<WebDriver> wait = (new FluentWait(tmpDriver))
	      .withTimeout(1L, TimeUnit.SECONDS)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    
	    By cssSigninBtn = By.cssSelector("a[data-event-property=\"signin\"]");
	    WebElement btnSignin = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSigninBtn));
	    btnSignin.click();
	    wait = (new FluentWait(tmpDriver))
	      .withTimeout(1L, TimeUnit.MINUTES)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    
	    
		/*
		 * By cssBtn = By.cssSelector("button[class=\"button mb24 secondary wide\"]");
		 * WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.
		 * visibilityOfElementLocated(cssBtn)); btnLogin.click(); wait = (new
		 * FluentWait()) .withTimeout(5L, TimeUnit.MINUTES) .pollingEvery(1L,
		 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		 */
	    
	    By cssUserName = By.cssSelector("input[name=\"loginfmt\"]");
	    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
	    usernameTxt.sendKeys(new CharSequence[] { sUsername});
	    By cssNextBtn = By.cssSelector("input[id=\"idSIButton9\"]");
	    WebElement nextBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextBtn));
	    nextBtn.click();
	    wait = (new FluentWait(tmpDriver))
	      .withTimeout(1L, TimeUnit.MINUTES)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    
	    
	    By cssPassword = By.cssSelector("input[name=\"passwd\"]");
	    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
	    password.sendKeys(new CharSequence[] { sPassword });
	    By cssNextPwdBtn = By.cssSelector("input[id=\"idSIButton9\"]");
	    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
	    nextPwdBtn.click();
	    wait = (new FluentWait(tmpDriver))
	  	      .withTimeout(1L, TimeUnit.MINUTES)
	  	      .pollingEvery(1L, TimeUnit.SECONDS)
	  	      .ignoring(NoSuchElementException.class);
	    
	    if (isKMIEnable) {
		    By cssDontShow = By.cssSelector("input[id=\"KmsiCheckboxField\"]");
		    WebElement cbDontShow = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssDontShow));
		    cbDontShow.click();
		    By cssYes = By.cssSelector("input[id=\"idSIButton9\"]");
		    WebElement cbYes = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssYes));
		    cbYes.click();
	    }
	  }
	  
  
  
  public static void pbiRefresh(RemoteWebDriver tmpDriver, String sGroupName, String sDataSetID) {
	  if (sGroupName==null) sGroupName="me";
	  String sURL = "https://app.powerbi.com/groups/"+sGroupName+"/list/dataflows";
	  tmpDriver.get(sURL);
      String sContent = tmpDriver.getPageSource();
	    FluentWait<WebDriver> wait = (new FluentWait(tmpDriver))
	      .withTimeout(5L, TimeUnit.MINUTES)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    Robot robot;
	    
	   
	    	//2d5da45a-916f-443f-9f5e-1f92c73ec46a
	    	
	    	try {
	    	    By cssdataset = By.cssSelector("a[href=\"/groups/"+sGroupName+"/datasets/"+sDataSetID+"/details\"]");
	    	    WebElement linkDataSet= (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssdataset));
	    	    
	    	    Actions builder = new Actions(tmpDriver);
	            Action mouseOverHome = builder
	                    .moveToElement(linkDataSet)
	                    .build();
	                 
	            mouseOverHome.perform();    
	            
	    	    wait = (new FluentWait(tmpDriver))
	    	      .withTimeout(5L, TimeUnit.MINUTES)
	    	      .pollingEvery(1L, TimeUnit.SECONDS)
	    	      .ignoring(NoSuchElementException.class);
	    	   
	    		} catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    	
		
		
             
           
			/*
			 * try { robot = new Robot(); robot.mouseMove(400, 500);
			 * robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); } catch (AWTException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 */
		try {

			
			System.out.println("Refresh button ... searching");
	    //By cssRefresh = By.cssSelector("button[title=\"Refresh now\"]");
			String cssStr="button[title=\"Refresh now\"]";
			
			//Keppel
			//https://app.powerbi.com/groups/9d707749-d22a-4b02-af38-6ef3377d5b25/datasets/dc8085c9-02b4-443b-96e9-334f762d34d0/details
			//#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(15) > div:nth-child(2) > span > button:nth-child(2)
			if (sDataSetID.equals("dc8085c9-02b4-443b-96e9-334f762d34d0")) {
				cssStr="#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(21) > div:nth-child(2) > span > button:nth-child(2)";
			}
			//CapitaLand
			//#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(6) > div:nth-child(2) > span > button:nth-child(2)
			if (sDataSetID.equals("9eeffad4-ba6b-4361-a693-25b66a6d22fe")) {
				cssStr="#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(8) > div:nth-child(2) > span > button:nth-child(2)";
				// #artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(21) > div:nth-child(2) > span > button:nth-child(2)
			}
			//PPMS Monthly Report
			//https://app.powerbi.com/groups/9d707749-d22a-4b02-af38-6ef3377d5b25/datasets/8eac255e-5b9c-4847-b737-cfd7bb4dfcc3/details
			if (sDataSetID.equals("8eac255e-5b9c-4847-b737-cfd7bb4dfcc3")) {
				cssStr="#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(21) > div:nth-child(2) > span > button:nth-child(2)";
				// #artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(21) > div:nth-child(2) > span > button:nth-child(2)
			}
			//NatSteel - 19d7e157-074c-4afd-a495-1f04d8403815
			//#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(6) > div:nth-child(2) > span > button:nth-child(2)
			////*[@id="artifactContentList"]/div[1]/div[6]/div[2]/span/button[1]
			///html/body/div[1]/root/mat-sidenav-container/mat-sidenav-content/div/div/workspace-view-header/workspace-proxy/fluent-workspace/mat-sidenav-container/mat-sidenav-content/fluent-workspace-table/fluent-list-table-base/cdk-virtual-scroll-viewport/div[1]/div[6]/div[2]/span/button[1]
			if (sDataSetID.equals("19d7e157-074c-4afd-a495-1f04d8403815")) {
				cssStr="#artifactContentList > div.cdk-virtual-scroll-content-wrapper > div:nth-child(16) > div:nth-child(2) > span > button:nth-child(2)";
			}
			By cssRefresh = By.cssSelector(cssStr);
	    WebElement btnRefresh = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssRefresh));
	    
	    btnRefresh.click();
	    System.out.println("Refresh button clicked");
	    wait = (new FluentWait(tmpDriver))
	      .withTimeout(3L, TimeUnit.MINUTES)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
		
		  try { Thread.sleep(10000L); //miliseconds 
		  } catch (InterruptedException e) {
		  e.printStackTrace(); }
		 
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	    
		/*
		 * //close the button //<button _ngcontent-kjy-c71=""
		 * class="flat-button ng-star-inserted" style=""
		 * pbi-focus-tracker-idx="2">Close</button> try { By cssClose =
		 * By.cssSelector("button[_ngcontent-kjy-c71=\"\"]"); WebElement btnClose =
		 * (WebElement)wait.until((Function)ExpectedConditions.
		 * visibilityOfElementLocated(cssClose)); btnClose.click(); wait = (new
		 * FluentWait()) .withTimeout(10L, TimeUnit.SECONDS) .pollingEvery(1L,
		 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		 * 
		 * 
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
    	
    	
    	
		
	    
	  }
  
  public static void snowUpdateEPAACA(String sDBName, String sTicketState) {

	  /*
	   To call the snowAnalyze method for ticket status in WIP, EPA and CA and store into database

            Parameters:
                    sDBName: Capitaland/Keppel/Natsteel
                    sTicketState: WIP/EPA/CA

            Returns:
                     get the status updates from CL servicenow and store into database


	   */
	  //gDBName=sDBName;
	  System.out.println("=============RPA Mode: "+sTicketState);
	  clTicket clTix = new clTicket(sDBName);
	  String[] sTickets= clTix.getEPAACATicketList("Incident",sTicketState);
	  
	  rpaTicket rpaTix= new rpaTicket(sDBName);
	  if (sTickets!=null) {		  
		  if (sTickets.length>0) {
			  for (int i=0; i<sTickets.length; i++) {
				  String sTicket= sTickets[i];
				  String sTicketType="";
				  String sExternalRef="";
				  String[] sTicketA=null;
				  try {
					  sTicketA = sTickets[i].split("\\|");
					  if (sTicketA.length>2) {
						  sTicket= sTicketA[0];
						  sTicketType=sTicketA[1];
						  sExternalRef=sTicketA[2];
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] Analyzing ticket "+sTicket);
						  try {
							  if (sTicketType.equals("FALSE")) {
								  if (sExternalRef.contains("INCTASK")) {
									  snowAnalyze("incident_task", sTicket, rpaTix);
								  } else  snowAnalyze("incident", sTicket, rpaTix);
							  } else {
								  
								  System.out.println("["+(i+1)+"/"+sTickets.length+"] ALERT ticket: "+sTicket);  
							  }
							  ArrayList<String> tabs = new ArrayList<String>(gdriver.getWindowHandles());
							  if (tabs.size()>1) {
								  for (int j=(tabs.size()-1); i>0; j--) {
									  gdriver.switchTo().window(tabs.get(j));
									  gdriver.close();
								  }
								 
								  //gdriver.close();
								  //gdriver.switchTo();
								 
							  }
							  
							  System.gc();
						  } catch (Exception e) {
							  System.out.println("["+(i+1)+"/"+sTickets.length+"] ERROR "+sTicket+" :"+e.getMessage());
							  initDriverServiceNowCL();
							  
						  }
					  }
				  } catch (Exception e) {
					  System.out.println("["+(i+1)+"/"+sTickets.length+"] Error "+sTicket+"; "+e.getMessage());  
				  }
				  
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Analyzed "+sTicket);
			  }
		  }
	  }
	  
  }
  
  public static void snowCancel(String sDBName) {
	  //gDBName=sDBName;
	  clTicket clTix = new clTicket(sDBName);
	  String[] sTickets= clTix.getDAMAlertTickets("Incident");
	  int iTries=0;
	  String sWindowHandle= gdriver.getWindowHandle();
	  if (sTickets!=null) {		  
		  if (sTickets.length>0) {
			  for (int i=0; i<sTickets.length; i++) {
				  String sTicket= sTickets[i];
				  String sTicketType="";
				  sTicket= sTickets[i].split("\\|")[0];
				  sTicketType=sTickets[i].split("\\|")[1];
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Cancelling ticket "+sTicket);
				  iTries=0;
				  while (iTries<3) {
					  try {
						  iTries++;
						 
						  ArrayList<String> tabs = new ArrayList<String>(gdriver.getWindowHandles());
						  System.out.println("Tab Size="+tabs.size());
						  if (tabs.size()>1) {
							  for (int j=(tabs.size()); j>0; j--) {
								  gdriver.switchTo().window(tabs.get(j-1));
								  System.out.println("Set to Tab "+j+" - Tab Size="+tabs.size());
								  if (!gdriver.getWindowHandle().equals(sWindowHandle)) gdriver.close();
							  }
							 
							  //gdriver.close();
							  //gdriver.switchTo();
							 
						  } else {
							  System.out.println("Set to Tab 0 - Tab Size="+tabs.size());
							  gdriver.switchTo().window(tabs.get(0));
							  
						  }
						  snowCancelTicket(sTicket,sTicketType);
						  System.gc();
						  break;
						  
					  } catch (InterruptedException e1) {
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] ["+iTries+"/3] Interrupted ERROR "+sTicket+" :"+e1.getMessage());
						  resetDriverServiceNow();
						  //initDriverServiceNow();
						 
					  } catch (Exception e) {
						
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] ["+iTries+"/3] ERROR "+sTicket+" :"+e.getMessage());
						  resetDriverServiceNow();
						  //initDriverServiceNow();
						  
					  }
				}
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Completed "+sTicket);
			  }
		  }
	  }
	  
  }
  
  public static void snowUpdate(String sDBName) {
	  //gDBName=sDBName;
	  clTicket clTix = new clTicket(sDBName);
	  String[] sTickets= clTix.getSoftCloseTicketList("Incident");
	  int iTries=0;
	  String sWindowHandle= gdriver.getWindowHandle();
	  if (sTickets!=null) {		  
		  if (sTickets.length>0) {
			  for (int i=0; i<sTickets.length; i++) {
				  String sTicket= sTickets[i];
				  String sTicketType="";
				  sTicket= sTickets[i].split("\\|")[0];
				  sTicketType=sTickets[i].split("\\|")[1];
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Closing ticket "+sTicket);
				  iTries=0;
				  while (iTries<3) {
					  try {
						  iTries++;
						 
						  ArrayList<String> tabs = new ArrayList<String>(gdriver.getWindowHandles());
						  System.out.println("Tab Size="+tabs.size());
						  if (tabs.size()>1) {
							  for (int j=(tabs.size()); j>0; j--) {
								  gdriver.switchTo().window(tabs.get(j-1));
								  System.out.println("Set to Tab "+j+" - Tab Size="+tabs.size());
								  if (!gdriver.getWindowHandle().equals(sWindowHandle)) gdriver.close();
							  }
							 
							  //gdriver.close();
							  //gdriver.switchTo();
							 
						  } else {
							  System.out.println("Set to Tab 0 - Tab Size="+tabs.size());
							  gdriver.switchTo().window(tabs.get(0));
							  
						  }
						  snowCloseTicket(sTicket,sTicketType);
						  System.gc();
						  break;
						  
					  } catch (InterruptedException e1) {
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] ["+iTries+"/3] Interrupted ERROR "+sTicket+" :"+e1.getMessage());
						  resetDriverServiceNow();
						  //initDriverServiceNow();
						 
					  } catch (Exception e) {
						
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] ["+iTries+"/3] ERROR "+sTicket+" :"+e.getMessage());
						  resetDriverServiceNow();
						  //initDriverServiceNow();
						  
					  }
				}
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Completed "+sTicket);
			  }
		  }
	  }
	  
  }
  
public static void snowUpdateRequest(String sDBName) {
	  
	  clTicket clTix = new clTicket(sDBName);
	  String[] sTickets= clTix.getSoftCloseTicketList("Request");
	  int iTries=0;
	  String sWindowHandle= gdriver.getWindowHandle();
	  if (sTickets!=null) {		  
		  if (sTickets.length>0) {
			  for (int i=0; i<sTickets.length; i++) {
				  String sTicket= sTickets[i];
				  String sTicketType="";
				  sTicket= sTickets[i].split("\\|")[0];
				  sTicketType=sTickets[i].split("\\|")[1];
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Closing ticket "+sTicket);
				  iTries=0;
				  while (iTries<3) {
					  try {
						  iTries++;
						 
						  ArrayList<String> tabs = new ArrayList<String>(gdriver.getWindowHandles());
						  if (tabs.size()>1) {
							  for (int j=(tabs.size()); j>0; j--) {
								  gdriver.switchTo().window(tabs.get(j-1));
								  System.out.println("Set to Tab "+j+" - Tab Size="+tabs.size());
								  if (!gdriver.getWindowHandle().equals(sWindowHandle)) gdriver.close();
							  }
							 
							 
							  //gdriver.close();
							  //gdriver.switchTo();
							 
						  } else {
							  gdriver.switchTo().window(tabs.get(0));
						  }
						  snowCloseTicketRequest(sTicket);
						  System.gc();
						  break;
					  } catch (InterruptedException e1) {
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] ["+iTries+"/3] ERROR "+sTicket+" :"+e1.getMessage());
						  //initDriverServiceNow();
						  //resetDriverServiceNow();
						
					  } catch (Exception e) {
						
						  System.out.println("["+(i+1)+"/"+sTickets.length+"] ["+iTries+"/3] ERROR "+sTicket+" :"+e.getMessage());
						  //initDriverServiceNow();
						  //resetDriverServiceNow();
						  
					  }
				  }
				  System.out.println("["+(i+1)+"/"+sTickets.length+"] Completed "+sTicket);
			  }
		  }
	  }
	  
  }
  

  private static String setSalesForceDateFormat(String sDateTime) {
	    String temp = null;
	    String sDate="";
	    String sTime="00:00:00";
	    try {
	    	
	    	sDateTime=sDateTime.trim();
	    	
	    String[] sD= sDateTime.split(" ");
	    if (sD!=null) {
	    	if (sD.length==2) {
	    		sDate=sD[0];
	    		sTime=sD[1];
	    	}
	    }
	    	
	      sDate = sDate.trim();
	    } catch (Exception e) {
	      sDate = "";
	    } 
	    if (sDate.equals("")) {
	      temp = "0000-00-00";
	    } else {
	      try {
	        String[] s = sDate.split("-");
	        
	        if (s!=null) {
	        	temp = "0000-00-00";
	        	if (s.length>2) {
				        String sMonth = s[1];
				        if (sMonth!=null) {
				        	switch (sMonth) {
				        	case "Jan" : sMonth="01"; break;
				        	case "Feb" : sMonth="02"; break;
				        	case "Mar" : sMonth="03"; break;
				        	case "Apr" : sMonth="04"; break;
				        	case "May" : sMonth="05"; break;
				        	case "Jun" : sMonth="06"; break;
				        	case "Jul" : sMonth="07"; break;
				        	case "Aug" : sMonth="08"; break;
				        	case "Sep" : sMonth="09"; break;
				        	case "Oct" : sMonth="10"; break;
				        	case "Nov" : sMonth="11"; break;
				        	case "Dec" : sMonth="12"; break;    	
				        	
				        	}
				        }
				        
				        
				        
				        String sDay = s[0];
				        if (sDay.length() == 1)
				          sDay = "0" + sDay; 
				      
				       
				          temp = String.valueOf(s[2]) + "-" + sMonth + "-" + sDay;
	        	}
	        }
	      
	      } catch (Exception e) {
	    	  temp = "0000-00-00";
	      } 
	    } 
	    if (temp == null)
	    	 temp = "0000-00-00";
	    if (temp.equals(""))
	    	 temp = "0000-00-00"; 
	    if (temp.isEmpty())
	    	 temp = "0000-00-00";
	    return temp;
	  }
  
  
 public static void snowCancelTicket( String sTicketNumber, String sTicketType) throws InterruptedException {
	  
	  //By.cssSelector("input[id=\"incident.number\"]");
	  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
	  
	  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
	  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  String sAssignee="Purnama Sidhi";
	  String sRequestor="SCOM Alerts Direct";
	  String sClassification= "MHIS";
	  String currStatus="0";
	  
	 
	  String sDefaultResolutionCode="7b78ad2fdb3a84544a5e56915b961984";
	  String sDefaultClosureDetails="Auto Closure by RPA";
	  String sDefaultResolvedBy="NTTCMS";
	  
	  String sDefaultRC="76d8ed23db7a84544a5e56915b961975";
	  String sDefaultRCComments="Auto Closure by RPA";
	  String sDefaultBCComments="Auto Closure by RPA";
	  
	  String sDefaultCI="";
	  
	  
	  String sDefaultBreachRC="b0b76d27db3a84544a5e56915b96194a";
	  
		By cssTemp = null;
	    WebElement webTemp = null;
	    
	    boolean isUpdate=false;
	    boolean isAging=false;
	    boolean isAutoCloseFail=false;
	    	
	    
	    ArrayList<String> tabs=null;
	    
	    By cssSaveBtn = null;
      	  WebElement saveBtn =null;
      	  
      try {
    	  String sURL = "https://dimensiondataservices.service-now.com/task.do?sysparm_query=number%3D"+sTicketNumber;
          gdriver.get(sURL);
          String sContent = gdriver.getPageSource();
          FluentWait<WebDriver> wait = (new FluentWait(gdriver))
            .withTimeout(20L, TimeUnit.SECONDS)
            .pollingEvery(1L, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
          By css = By.cssSelector("input[id=\"incident.number\"]");
          WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
          sContent = gdriver.getPageSource();
          Document doc = null;
          doc = Jsoup.parse(sContent);
          String sTix = doc.select("input[id=\"incident.number\"]").val();
          if (sTix.equals(sTicketNumber)) {
        	  	System.out.println(sTix+": Record Found");  
        	  	
        	  	//Check ticket status - sys_readonly.incident.state
        	  	
        	  	
        	  	String cssCurrStatus = doc.select("input[id=\"incident.state\"]").val();
	      	   	System.out.println(sTix+": CurrentStatus="+cssCurrStatus);  	
	      	   	if (cssCurrStatus.equals("-15")) {
	      	   	System.out.println(sTix+": Ignore Cancelled ticket");
	      	   	} else if (cssCurrStatus.equals("7")) {
	      	   		System.out.println(sTix+": Ignore Close ticket");
	      	   	} else {
        	  	
        	  	String sCurrRequestor = doc.select("input[id=\"sys_display.incident.u_caller\"]").val();
        	  	
        	  	
        	  	
        	  	//Get the Assignment Group sys_display.incident.assignment_group
        		String sCurrAssignmentGroup = doc.select("input[id=\"sys_display.incident.assignment_group\"]").val();
        		
        		if (!sCurrAssignmentGroup.isEmpty()) {
        			if (sCurrAssignmentGroup.equalsIgnoreCase("NTT.CMS.MHIS") ||  sCurrAssignmentGroup.equalsIgnoreCase("MHIS ITSI Service Desk")) {
        				
        				sAssignee="";     
            	        	      
        				
        			} else {
        				
        				//Resolution Code sys_original.incident.u_task_resolution_code value=a47d4805db89ffc068fd7b5a8c961904
        				// sys_display.incident.u_task_resolution_code value="Other"
        				((JavascriptExecutor) gdriver).executeScript("document.getElementsByName('incident.u_task_resolution_code').item(0).value = 'a47d4805db89ffc068fd7b5a8c961904';");
        				//lookup.incident.u_task_resolution_code
        				
        				sDefaultResolutionCode="a47d4805db89ffc068fd7b5a8c961904";
        				sDefaultResolvedBy="Purnama Sidhi";
        				sDefaultRC="1fb5d1da0fc64a8c7ca9f18362050ec8";
        				sDefaultBreachRC="0f00fbfddb66a4906eeb08a8f496191e";
        				//Root Cause incident.u_task_rootcause 1fb5d1da0fc64a8c7ca9f18362050ec8 lookup.incident.u_task_rootcause
        				
        				//sDefaultCI="155512476";
        				 if (sCurrAssignmentGroup.equalsIgnoreCase("AP.SG.CL.Deskside")) {
        						sAssignee="SR Yeo";     
        						sClassification="Uncovered base";
        						//sDefaultCI="134421191";
             	        }
        			}
        		}
        	  	
        		/*
        	  	//Update Requestor
        	  	By cssRequestor = By.cssSelector("input[id=\"sys_display.incident.u_caller\"]");
      	    	
      	    	if (sCurrRequestor.isEmpty()) {
      	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssRequestor));
      	    		webRequestor.sendKeys(new CharSequence[] { sRequestor });
      	    		 try {
      	    	        Thread.sleep(5000L);
      	    	      isUpdate=true;
      	    	      } catch (InterruptedException e) {
      	    	        e.printStackTrace();
      	    	      } 
      	    	}
      	    	
      	    	*/
      	    	
      	    	//Contact sys_display.incident.u_contract
      	  	String sCurrContract = doc.select("input[id=\"sys_display.incident.u_contract\"]").val();
      	  if (!sCurrContract.isEmpty()) {
      		  if (sCurrContract.equals("MHIS Managed Hybrid Infrastructure Services")) {
      			sDefaultCI="155512476";
      		  }
      		  else if (sCurrContract.equals("Enterprise Infrastructure Management delivered by Ctry")) {
       			sDefaultCI="167691394";
       		  }
      		  else if (sCurrContract.equals("Enterprise Infrastructure Management delivered by CDO")) {
        			sDefaultCI="130450503";
        	 } else if (sCurrContract.equals("Uncovered base")) {
        		 sDefaultCI="134421191";
        	 }
      		 //
      		 
      		 
      		  
      	  }
      	  	
      	    	//Contract CI
      	    	//sys_display.incident.u_contract_ci
      	    	
        	  	String sCurrCI = doc.select("input[id=\"sys_display.incident.u_contract_ci\"]").val();
      	  	By cssCI = By.cssSelector("input[id=\"sys_display.incident.u_contract_ci\"]");  	    	
  	    	if (sCurrCI.isEmpty()) {
  	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCI));
  	    		webRequestor.sendKeys(new CharSequence[] { sDefaultCI });
  	    		 try {
  	    	        Thread.sleep(5000L);
  	    	    	
					//button id="sysverb_update_and_stay"
		  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
		  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
		  	      	  saveBtn.click();
		  	      	  wait = (new FluentWait(gdriver))
		  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		  		  	      .ignoring(NoSuchElementException.class);
		        	      System.out.println(sTix+": Update CI");		
		        	      
		        	      sContent = gdriver.getPageSource();		                  
		                  doc = Jsoup.parse(sContent);
  	    	      } catch (InterruptedException e) {
  	    	        e.printStackTrace();
  	    	      } 
  	    	}
      	    	
      	    	//Update Classification if null
      	    	//sys_display.incident.u_classification
      	    	String cssCurrClassification = doc.select("input[id=\"sys_display.incident.u_classification\"]").val();
	      	  	
	  	    	if (cssCurrClassification.isEmpty()) {
	  	    		By cssClassification = By.cssSelector("input[id=\"sys_display.incident.u_classification\"]");
		  	    	WebElement webClassification = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssClassification));
	  	    		webClassification.sendKeys(new CharSequence[] { sClassification });
	  	    		 try {
	  	    	        Thread.sleep(5000L);
	  	    	      isUpdate=true;
	  	    	      } catch (InterruptedException e) {
	  	    	        e.printStackTrace();
	  	    	      } 
	  	    	}
      	    	
      	    	//Update AffectedContact
      	    	/*
        	  	By cssAffacted = By.cssSelector("input[id=\"sys_display.incident.u_requested_for\"]");
      	    	WebElement webAffected = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssAffacted));
	      	  	if (webAffected.getCssValue("value").isEmpty()) {
	      	    	webAffected.sendKeys(new CharSequence[] { sRequestor });
	      	  	}
	      	  	*/
	      	  	
	  	    	
	  	    	
	  
			
			   		
			   		//Update Assignee
			   		//incident.assigned_to
			   		String sCurrAssignee= doc.select("input[id=\"sys_display.incident.assigned_to\"]").val();
	        	  	By cssAssignee = By.cssSelector("input[id=\"sys_display.incident.assigned_to\"]");
	      	    	
	      	    	if (sCurrAssignee.isEmpty()) {
	      	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssAssignee));
	      	    		webRequestor.sendKeys(new CharSequence[] { sAssignee });
	      	    		 try {
	      	    	        Thread.sleep(5000L);
	      	    	      isUpdate=true;
	      	    	      } catch (InterruptedException e) {
	      	    	        e.printStackTrace();
	      	    	      } 
	      	    	}
	      	    	

	      	   		//Check The Resolution Code - input - sys_display.incident.u_task_resolution_code
	      	   		String sCurrResolutionCode = doc.select("input[id=\"sys_display.incident.u_task_resolution_code\"]").val();
		      	   	if (sCurrResolutionCode.isEmpty()) {
		      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.incident.u_task_resolution_code\"]");
    	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
    	  	      	  saveBtn.click();
    	  	      	  wait = (new FluentWait(gdriver))
    	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
    	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
    	  		  	      .ignoring(NoSuchElementException.class);
    	        	      System.out.println(sTix+": Pick lookup.incident.u_task_resolution_code");
    	        	      
    	        	      
    	        	     tabs = new ArrayList<String>(gdriver.getWindowHandles());
    					  
    					  gdriver.switchTo().window(tabs.get(1));
    	        	      
    	        	      
    	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultResolutionCode+"\"]");
        	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
        	  	      	  saveBtn.click();
        	  	      	  wait = (new FluentWait(gdriver))
        	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
        	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
        	  		  	      .ignoring(NoSuchElementException.class);
        	        	      System.out.println(sTix+": Click "+sDefaultResolutionCode);       	      
        	        	      gdriver.switchTo().window(tabs.get(0));
			      	}
		      	   	
		      	   	
	      	   		//Check the Closure details - textarea - incident.close_notes
	      	   		String sCurrClosureDetails = doc.select("textarea[id=\"incident.close_notes\"]").val();
		      	   	if (sCurrClosureDetails.isEmpty()) {
			      	    cssTemp = By.cssSelector("textarea[id=\"incident.close_notes\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultClosureDetails });
		  	    		
			      	}
		      	   	/*
	      	   		//Check the Resolved by - input - sys_display.incident.u_resolved_by - (NTTCMS/ Purnama Sidhi)
	      	   		String sCurrResolvedBy = doc.select("input[id=\"sys_display.incident.u_resolved_by\"]").val();
		      	   	if (sCurrResolvedBy.isEmpty()) {
			      	    cssTemp = By.cssSelector("input[id=\"sys_display.incident.u_resolved_by\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultResolvedBy });
		  	    		 try {
		  	    	        Thread.sleep(5000L);
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
			      	}
	      	   	*/
	      	   		//Check The Root Cause - input - sys_display.incident.u_task_rootcause
	      	   		String sCurrRC = doc.select("input[id=\"sys_display.incident.u_task_rootcause\"]").val();
		      	   	if (sCurrRC.isEmpty()) {
		      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.incident.u_task_rootcause\"]");
  	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
  	  	      	  saveBtn.click();
  	  	      	  wait = (new FluentWait(gdriver))
  	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
  	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
  	  		  	      .ignoring(NoSuchElementException.class);
  	        	      System.out.println(sTix+": Pick lookup.incident.u_task_rootcause");
  	        	      
  	        	      
  	        	      tabs = new ArrayList<String>(gdriver.getWindowHandles());
  					  
  					  gdriver.switchTo().window(tabs.get(1));
  	        	      
  	        	      
  	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultRC+"\"]");
      	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
      	  	      	  saveBtn.click();
      	  	      	  wait = (new FluentWait(gdriver))
      	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
      	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
      	  		  	      .ignoring(NoSuchElementException.class);
      	        	      System.out.println(sTix+": Click "+sDefaultRC);       	      
      	        	      gdriver.switchTo().window(tabs.get(0));
			      	}
	      	   		//Check the Root Cause Comments - text area - incident.u_root_cause_comments
	      	   		String sCurrRCComments = doc.select("textarea[id=\"incident.u_root_cause_comments\"]").val();
		      	   	if (sCurrRCComments.isEmpty()) {
			      	    cssTemp = By.cssSelector("textarea[id=\"incident.u_root_cause_comments\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultRCComments });
		  	    		
			      	}
	      	   		
			   	
			   	
			   	
		      	   	//Scan Breached Commitments
			      	  Elements rows = doc.select("div[id=\"incident.task_sla.task\"]").select("tr");
			      	  int i = 0;
				      for (Element tr : rows) {
				    	 String sTR=tr.toString();
				    	 if (sTR!=null) {
				    		 if (sTR.contains("Breached")||sTR.contains("Overdue") ) {
				    			 Elements tds = tr.select("td");
				    			 int tdIndex=0;
				    			  for (Element td : tds) {
				    				  
				    				  switch (tdIndex) {
				    				  case 0: break;
				    				  case 1: break;
				    				  case 2: //here
				    					  String sTempURL=sURLBase+td.select("a").attr("href");
				    					  System.out.println(sTix+": sTempURL="+sTempURL);
				    					  
				    					  
				    					  
				    					 
				    					    
				    					  gdriver.executeScript("window.open()");
				    					  
				    					  tabs = new ArrayList<String>(gdriver.getWindowHandles());
				    					  
				    					  gdriver.switchTo().window(tabs.get(1));
				    					 
				    					
				    					    gdriver.get(sTempURL);
				    					    try{
				    					    	
				    					        
				    					          By cssTABreachComments = By.cssSelector("textarea[id=\"task_sla.u_breach_comments\"]");
				    					          WebElement webTABreachComments = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(cssTABreachComments));
				    					          String sTempContent = gdriver.getPageSource();
				    					          Document tempDoc = null;
				    					          tempDoc = Jsoup.parse(sTempContent);
				    					          String sCurTABreachComments = tempDoc.select("textarea[id=\"task_sla.u_breach_comments\"]").val();
				    					      	   	if (sCurTABreachComments.isEmpty()) {
				    						      	    cssTemp = By.cssSelector("textarea[id=\"task_sla.u_breach_comments\"]");
				    						  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
				    						  	    	webTemp.sendKeys(new CharSequence[] { sDefaultBCComments });
				    					  	    		
				    						  	    
				    					      	      
				    						      	}
				    					      	   	
				    					      	   	//sys_display.task_sla.u_breach_reason_code
				    					      	   	//549d58c1db81330468fd7b5a8c9619c1
				    					      	   	
				    					      	   	
					    					      	  String sCurTABreachReason = tempDoc.select("input[id=\"sys_display.task_sla.u_breach_reason_code\"]").val();
					    					      	   	if (sCurTABreachReason.isEmpty()) {
				    					      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.task_sla.u_breach_reason_code\"]");
				    			  	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
				    			  	  	      	  saveBtn.click();
				    			  	  	      	  wait = (new FluentWait(gdriver))
				    			  	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
				    			  	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
				    			  	  		  	      .ignoring(NoSuchElementException.class);
				    			  	        	      System.out.println(sTix+": Pick lookup.task_sla.u_breach_reason_code");
				    			  	        	      
				    			  	        	      
				    			  	        	      tabs = new ArrayList<String>(gdriver.getWindowHandles());
				    			  					  
				    			  					  gdriver.switchTo().window(tabs.get(2));
				    			  	        	      
				    			  	        	      
				    			  	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultBreachRC+"\"]");
				    			      	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
				    			      	  	      	  saveBtn.click();
				    			      	  	      	  wait = (new FluentWait(gdriver))
				    			      	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
				    			      	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
				    			      	  		  	      .ignoring(NoSuchElementException.class);
				    			      	        	      System.out.println(sTix+": Click "+sDefaultRC);   
				    			      	        	      
				    			      	        	      
				    			      	        	      gdriver.switchTo().window(tabs.get(1));
				    						      	}
					    					      	   	
					    					      	   	
				    				      	   	
				    					      	   	
				    					      	   	
				    					      	   	//save - sysverb_update_and_stay
			    						  	    	
				    						  	       cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_bottom\"]");
				    						      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
				    						      	  saveBtn.click();
				    						      	  wait = (new FluentWait(gdriver))
				    							  	      .withTimeout(1L, TimeUnit.MINUTES)
				    							  	      .pollingEvery(1L, TimeUnit.SECONDS)
				    							  	      .ignoring(NoSuchElementException.class);
				    					      	      System.out.println(sTix+": Update Breach Comment.");
				    					      	   
				    					      	      gdriver.close();
				    					      	   	
				    					      	   	
				    					    	
				    					    } catch (Exception e) {
				    					    	
				    					    }
				    					    
				    					    //gdriver.close();
				    					    gdriver.switchTo().window(tabs.get(0));
				    					    
				    					  break;
				    					  default: break;
				    				  
				    				  }
				    				  
				    				  tdIndex++;
				    				  
				    				  
				    			  }
				    		 }
				    		 
				    	 }
				    	 
				      } //end of TR loop
	      	  
			
	      	   		
	      	   	
		      	   	
		      	   	
		      	   	//Set to Cancel
		
	      	   		Select drpStatus = new Select(gdriver.findElement(By.id("incident.u_next_step_displayed")));
	      	    	drpStatus.selectByVisibleText("Set to cancelled");
	      	    	gdriver.switchTo().alert().accept();	
	      	    	isUpdate=true;
	      	      	System.out.println(sTix+": Set ticket to CANCELLED.");
			   
	      	    
	      	    
	      	 
      	    	
				if (  isUpdate) {
					boolean isLoop=true;
					int tries=0;
					while (isLoop) {
		      	  	//button id="sysverb_update_and_stay"
						 isLoop=false;
	      	   	  System.out.println(sTix+": Update is TRUE. Saving...");
			      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
			      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			      	  saveBtn.click();
			      	  wait = (new FluentWait(gdriver))
				  	      .withTimeout(1L, TimeUnit.MINUTES)
				  	      .pollingEvery(1L, TimeUnit.SECONDS)
				  	      .ignoring(NoSuchElementException.class);
			      	 try {
		  	    	        Thread.sleep(5000L);
		  	    	      isUpdate=true;
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
		      	      
		      	      //Read the notification message
		      	      //output_messages
			      	 sContent = gdriver.getPageSource();				          
			          doc = Jsoup.parse(sContent);
			          System.out.println(sTix+": Checking Info Message");
			      	  try {
			      	      Elements divs = doc.select("div[id=\"output_messages\"]").select("div").select("div");
					       
					      for (Element div : divs) {
					    	  String sMessageType= div.select("span").select("span").text();
					    	  String sMessage= div.select("div").text();
					    	  System.out.println(sTix+": "+sMessageType+" :"+sMessage);		
					    	  if (!sMessage.isEmpty()) {
					    		  if (sMessage.contains("The task must have a primary CI")) {
					    			  if (tries<3) {
					    				  
					    				
					    	  	    
					    	  	    	
					    				  isLoop=true;
					    			  }
					    			  tries++;
					    		  }
					    	  }
					      }
					      
					      if (isLoop) {
					    	  	
		    	        	  	
			    	      	  
		    	  	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCI));
		    	  	    		webRequestor.clear();
		    	  	    		webRequestor.sendKeys(new CharSequence[] { sDefaultCI });
		    	  	    		 try {
		    	  	    	        Thread.sleep(5000L);
		    	  	    	    	
		    						//button id="sysverb_update_and_stay"
		    			  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
		    			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
		    			  	      	  saveBtn.click();
		    			  	      	gdriver.switchTo().alert().accept();	
		    			  	      	  wait = (new FluentWait(gdriver))
		    			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		    			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		    			  		  	      .ignoring(NoSuchElementException.class);
		    			        	      System.out.println(sTix+": Update CI");	
		    			        	     

		    			  			
		    			  					 try {
				  				  	    	        Thread.sleep(5000L);
				  				  	    	      isUpdate=true;
				  				  	    	      } catch (InterruptedException e) {
				  				  	    	        e.printStackTrace();
				  				  	    	      } 
			    			        	  	//Set to Close
			    				      	   		 drpStatus = new Select(gdriver.findElement(By.id("incident.u_next_step_displayed")));
			    				      	    	drpStatus.selectByVisibleText("Set to cancelled");
			    				      	    	gdriver.switchTo().alert().accept();	
			    				      	    	 cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
					    			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
					    			  	      	  saveBtn.click();
					    			  	        wait = (new FluentWait(gdriver))
						    			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
						    			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
						    			  		  	      .ignoring(NoSuchElementException.class);
		    			  				
		    	  	    	      } catch (InterruptedException e) {
		    	  	    	        e.printStackTrace();
		    	  	    	      } 
					      }
			      	  } catch (Exception e1) {
			      		  System.out.println(sTix+": Error "+e1.getMessage());
			      	  }
			      	  
				    		  
					}
				    	  
				    	  System.out.println(sTix+": Update Done");
				    	 
				    
				      
		      	      
	      	   	} else {
	      	   		System.out.println(sTix+": Update is FALSE. No Saving");
	      	   	}
      	      
	      	   	}
        	  
          } else {
        	  System.out.println(sTix+": Record NOT Found.");
          }
          
          try {
           
          } catch (Exception ec) {
            System.out.println(ec.getMessage());
          } 
          
          
          System.gc();
        } catch (Exception e1) {
          System.out.println(e1.getMessage());
          
        } 
	    
	   
	
	    
		/*
		 * //close the button //<button _ngcontent-kjy-c71=""
		 * class="flat-button ng-star-inserted" style=""
		 * pbi-focus-tracker-idx="2">Close</button> try { By cssClose =
		 * By.cssSelector("button[_ngcontent-kjy-c71=\"\"]"); WebElement btnClose =
		 * (WebElement)wait.until((Function)ExpectedConditions.
		 * visibilityOfElementLocated(cssClose)); btnClose.click(); wait = (new
		 * FluentWait(gdriver)) .withTimeout(10L, TimeUnit.SECONDS) .pollingEvery(1L,
		 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		 * 
		 * 
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
    	
    	
    	
		
	    
	  }
  
  
  public static void snowCloseTicket( String sTicketNumber, String sTicketType) throws InterruptedException {

	  /*
	   Close tickets that are in review/resovled status and more than 5 days. To close ticket status must change to review first and then set to closed

            Parameters:
                    sTicketNumber: NTT incident ticket number

            Returns:
                     Close tickets that are in review/resovled status and more than 5 days.
                     To close ticket status must change to review first and then set to closed.
                     Certain fields have to be filled up in order to close the tickets.


	   */
	  
	  //By.cssSelector("input[id=\"incident.number\"]");
	  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
	  
	  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
	  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  String sAssignee="Svc sgpbiapp";
//	  String sRequestor="SCOM Alerts Direct";
	  String sRequestor="Monitoring Alerts";
	  String sClassification= "MHIS";
	  String currStatus="0";
	  
	 
	  String sDefaultResolutionCode="7b78ad2fdb3a84544a5e56915b961984";
	  String sDefaultClosureDetails="Auto Closure by RPA";
//	  String sDefaultResolvedBy="NTTCMS";
	  String sDefaultResolvedBy="Svc sgpbiapp";
	  
	  String sDefaultRC="76d8ed23db7a84544a5e56915b961975";
	  String sDefaultRCComments="Auto Closure by RPA";
	  String sDefaultBCComments="Auto Closure by RPA";
	  
	  String sDefaultCI="";
	  
	  
	  String sDefaultBreachRC="b0b76d27db3a84544a5e56915b96194a";
	  
		By cssTemp = null;
	    WebElement webTemp = null;
	    
	 
	    
	    boolean isUpdate=false;
	    boolean isAging=false;
	    boolean isAutoCloseFail=false;
	    	
	    
	    ArrayList<String> tabs=null;
	    
	    By cssSaveBtn = null;
      	  WebElement saveBtn =null;
      	  
      try {
    	  String sURL = "https://dimensiondataservices.service-now.com/task.do?sysparm_query=number%3D"+sTicketNumber;
          gdriver.get(sURL);
          String sContent = gdriver.getPageSource();
          FluentWait<WebDriver> wait = (new FluentWait(gdriver))
            .withTimeout(20L, TimeUnit.SECONDS)
            .pollingEvery(1L, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
          By css = By.cssSelector("input[id=\"incident.number\"]");
          WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
          sContent = gdriver.getPageSource();
          Document doc = null;
          doc = Jsoup.parse(sContent);
          String sTix = doc.select("input[id=\"incident.number\"]").val();
          if (sTix.equals(sTicketNumber)) {
        	  	System.out.println(sTix+": Record Found");  
        	  	
        	  	//Check ticket status - sys_readonly.incident.state
        	  	
        	  	
        	  	String cssCurrStatus = doc.select("input[id=\"incident.state\"]").val();
	      	   	System.out.println(sTix+": CurrentStatus="+cssCurrStatus);  	
	      	   	if (cssCurrStatus.equals("-15")) {
	      	   	System.out.println(sTix+": Ignore Cancelled ticket");
	      	   	} else if (cssCurrStatus.equals("7")) {
	      	   		System.out.println(sTix+": Ignore Close ticket");
	      	   	} else {
        	  	
        	  	String sCurrRequestor = doc.select("input[id=\"sys_display.incident.u_caller\"]").val();
        	  	
        	  	
        	  	
        	  	//Get the Assignment Group sys_display.incident.assignment_group
        		String sCurrAssignmentGroup = doc.select("input[id=\"sys_display.incident.assignment_group\"]").val();
        		
        		if (!sCurrAssignmentGroup.isEmpty()) {
        			if (sCurrAssignmentGroup.equalsIgnoreCase("NTT.CMS.MHIS") ||  sCurrAssignmentGroup.equalsIgnoreCase("MHIS ITSI Service Desk")) {
        				
        				sAssignee="";     
            	        	      
        				
        			} else {
        				
        				//Resolution Code sys_original.incident.u_task_resolution_code value=a47d4805db89ffc068fd7b5a8c961904
        				// sys_display.incident.u_task_resolution_code value="Other"
        				((JavascriptExecutor) gdriver).executeScript("document.getElementsByName('incident.u_task_resolution_code').item(0).value = 'a47d4805db89ffc068fd7b5a8c961904';");
        				//lookup.incident.u_task_resolution_code
        				
        				sDefaultResolutionCode="a47d4805db89ffc068fd7b5a8c961904";
        				sDefaultResolvedBy="Svc sgpbiapp";
        				sDefaultRC="1fb5d1da0fc64a8c7ca9f18362050ec8";
        				sDefaultBreachRC="0f00fbfddb66a4906eeb08a8f496191e";
        				//Root Cause incident.u_task_rootcause 1fb5d1da0fc64a8c7ca9f18362050ec8 lookup.incident.u_task_rootcause
        				
        				//sDefaultCI="155512476";
        				 if (sCurrAssignmentGroup.equalsIgnoreCase("AP.SG.CL.Deskside")) {
        						sAssignee="SR Yeo";     
        						sClassification="Uncovered base";
        						//sDefaultCI="134421191";
             	        }
        			}
        		}
        	  	
        	  	//Update Requestor
        	  	By cssRequestor = By.cssSelector("input[id=\"sys_display.incident.u_caller\"]");
      	    	
      	    	if (sCurrRequestor.isEmpty()) {
      	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssRequestor));
      	    		webRequestor.sendKeys(new CharSequence[] { sRequestor });
      	    		 try {
      	    	        Thread.sleep(5000L);
      	    	      isUpdate=true;
      	    	      } catch (InterruptedException e) {
      	    	        e.printStackTrace();
      	    	      } 
      	    	}
      	    	
      	    	
      	    	
      	    	//Contact sys_display.incident.u_contract
      	  	String sCurrContract = doc.select("input[id=\"sys_display.incident.u_contract\"]").val();
      	  if (!sCurrContract.isEmpty()) {
      		  if (sCurrContract.equals("MHIS Managed Hybrid Infrastructure Services")) {
      			sDefaultCI="155512476";
      		  }
      		  else if (sCurrContract.equals("Enterprise Infrastructure Management delivered by Ctry")) {
       			sDefaultCI="167691394";
       		  }
      		  else if (sCurrContract.equals("Enterprise Infrastructure Management delivered by CDO")) {
        			sDefaultCI="130450503";
        	 } else if (sCurrContract.equals("Uncovered base")) {
        		 sDefaultCI="134421191";
        	 }
      		 //
      		 
      		 
      		  
      	  }
      	  	
      	    	//Contract CI
      	    	//sys_display.incident.u_contract_ci
      	    	
        	  	String sCurrCI = doc.select("input[id=\"sys_display.incident.u_contract_ci\"]").val();
      	  	By cssCI = By.cssSelector("input[id=\"sys_display.incident.u_contract_ci\"]");  	    	
  	    	if (sCurrCI.isEmpty()) {
  	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCI));
  	    		webRequestor.sendKeys(new CharSequence[] { sDefaultCI });
  	    		 try {
  	    	        Thread.sleep(5000L);
  	    	    	
					//button id="sysverb_update_and_stay"
		  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
		  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
		  	      	  saveBtn.click();
		  	      	  wait = (new FluentWait(gdriver))
		  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		  		  	      .ignoring(NoSuchElementException.class);
		        	      System.out.println(sTix+": Update CI");		
		        	      
		        	      sContent = gdriver.getPageSource();		                  
		                  doc = Jsoup.parse(sContent);
  	    	      } catch (InterruptedException e) {
  	    	        e.printStackTrace();
  	    	      } 
  	    	}
      	    	
      	    	//Update Classification if null
      	    	//sys_display.incident.u_classification
      	    	String cssCurrClassification = doc.select("input[id=\"sys_display.incident.u_classification\"]").val();
	      	  	
	  	    	if (cssCurrClassification.isEmpty()) {
	  	    		By cssClassification = By.cssSelector("input[id=\"sys_display.incident.u_classification\"]");
		  	    	WebElement webClassification = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssClassification));
	  	    		webClassification.sendKeys(new CharSequence[] { sClassification });
	  	    		 try {
	  	    	        Thread.sleep(5000L);
	  	    	      isUpdate=true;
	  	    	      } catch (InterruptedException e) {
	  	    	        e.printStackTrace();
	  	    	      } 
	  	    	}
      	    	
      	    	//Update AffectedContact
      	    	/*
        	  	By cssAffacted = By.cssSelector("input[id=\"sys_display.incident.u_requested_for\"]");
      	    	WebElement webAffected = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssAffacted));
	      	  	if (webAffected.getCssValue("value").isEmpty()) {
	      	    	webAffected.sendKeys(new CharSequence[] { sRequestor });
	      	  	}
	      	  	*/
	      	  	
	  	    	
	  	    	
	  	    	
	  	    	//check the last comment. close ticket if last comment >7 days
	  	    	//div id: element.incident.comments.additional
	  	   	//Scan Breached Commitments
		      	  Elements divs = doc.select("div[id=\"element.incident.comments.additional\"]").select("span").select("div").select("div");
			      int i = 0;
			      for (Element div : divs) {
			    	 
			    	  switch (i) {
			    	  case 0: break;
			    	  case 2: //latest comment here
			    		  String sDate= div.select("span").select("strong").text().substring(0,20);
			    		  LocalDate lastDate= LocalDate.parse(setSalesForceDateFormat(sDate));
			    		  LocalDate currDate = LocalDate.now();
			    		  long intervalDays = ChronoUnit.DAYS.between(lastDate, currDate);
			    		  
			    		  System.out.println(sTix+": Last Comment on :"+lastDate.toString()+" - "+intervalDays+" days ago");
			    		  
			    		  if (intervalDays >5) {
			    			  isAging=true;
			    		  }
			    		  break;
			    	default: break;
			    		  
			    	 }
			    	  i++;
			    	 
			      } //end of TR loop
	  	    
	  	    	
			      
			      //Check if Auto Closure Fail by searching keyword= "Auto closure was started but will NOT continue" in worknotes
			      String sWorkNotes = doc.select("div[id=\"element.incident.work_notes.additional\"]").text();
			      if (sWorkNotes.contains("Auto closure was started but will NOT continue")) {
			    	  System.out.println(sTix+": can close as Auto Close Failed");
			    	  isAutoCloseFail=true;
			    	  
			      }			      
			      //Check if close from parent incident
			      //keywords in comment: Closed based on resolution of Parent Incident
			      if (sWorkNotes.contains("Closed based on resolution of Parent Incident")) {
			    	  System.out.println(sTix+": can close as Closed based on resolution of Parent Incident");
			    	  isAutoCloseFail=true;
			    	  //isAging=true;
			      }
	  	    	
	      	  	//getCurrent Status; sys_original.incident.state
			      
			      //Ticket Type
			      if (sTicketType.equals("TRUE")) {
			    	  isAging=true;
			    	  System.out.println(sTix+": Set Aging is True for Alert ticket.");
			      }
			      
			   	if (cssCurrStatus.equals("6") || cssCurrStatus.equals("9") ) {
			   		
			   		//Update Assignee
			   		//incident.assigned_to
			   		String sCurrAssignee= doc.select("input[id=\"sys_display.incident.assigned_to\"]").val();
	        	  	By cssAssignee = By.cssSelector("input[id=\"sys_display.incident.assigned_to\"]");
	      	    	
	      	    	if (sCurrAssignee.isEmpty()) {
	      	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssAssignee));
	      	    		webRequestor.sendKeys(new CharSequence[] { sAssignee });
	      	    		 try {
	      	    	        Thread.sleep(5000L);
	      	    	      isUpdate=true;
	      	    	      } catch (InterruptedException e) {
	      	    	        e.printStackTrace();
	      	    	      } 
	      	    	}
	      	    	

	      	   		//Check The Resolution Code - input - sys_display.incident.u_task_resolution_code
	      	   		String sCurrResolutionCode = doc.select("input[id=\"sys_display.incident.u_task_resolution_code\"]").val();
		      	   	if (sCurrResolutionCode.isEmpty()) {
		      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.incident.u_task_resolution_code\"]");
    	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
    	  	      	  saveBtn.click();
    	  	      	  wait = (new FluentWait(gdriver))
    	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
    	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
    	  		  	      .ignoring(NoSuchElementException.class);
    	        	      System.out.println(sTix+": Pick lookup.incident.u_task_resolution_code");
    	        	      
    	        	      
    	        	     tabs = new ArrayList<String>(gdriver.getWindowHandles());
    					  
    					  gdriver.switchTo().window(tabs.get(1));
    	        	      
    	        	      
    	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultResolutionCode+"\"]");
        	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
        	  	      	  saveBtn.click();
        	  	      	  wait = (new FluentWait(gdriver))
        	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
        	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
        	  		  	      .ignoring(NoSuchElementException.class);
        	        	      System.out.println(sTix+": Click "+sDefaultResolutionCode);       	      
        	        	      gdriver.switchTo().window(tabs.get(0));
			      	}
		      	   	
		      	   	
	      	   		//Check the Closure details - textarea - incident.close_notes
	      	   		String sCurrClosureDetails = doc.select("textarea[id=\"incident.close_notes\"]").val();
		      	   	if (sCurrClosureDetails.isEmpty()) {
			      	    cssTemp = By.cssSelector("textarea[id=\"incident.close_notes\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultClosureDetails });
		  	    		
			      	}
	      	   		//Check the Resolved by - input - sys_display.incident.u_resolved_by - (NTTCMS/ Purnama Sidhi)
	      	   		String sCurrResolvedBy = doc.select("input[id=\"sys_display.incident.u_resolved_by\"]").val();
		      	   	if (sCurrResolvedBy.isEmpty()) {
			      	    cssTemp = By.cssSelector("input[id=\"sys_display.incident.u_resolved_by\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultResolvedBy });
		  	    		 try {
		  	    	        Thread.sleep(5000L);
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
			      	}
	      	   	
	      	   		//Check The Root Cause - input - sys_display.incident.u_task_rootcause
	      	   		String sCurrRC = doc.select("input[id=\"sys_display.incident.u_task_rootcause\"]").val();
		      	   	if (sCurrRC.isEmpty()) {
		      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.incident.u_task_rootcause\"]");
  	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
  	  	      	  saveBtn.click();
  	  	      	  wait = (new FluentWait(gdriver))
  	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
  	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
  	  		  	      .ignoring(NoSuchElementException.class);
  	        	      System.out.println(sTix+": Pick lookup.incident.u_task_rootcause");
  	        	      
  	        	      
  	        	      tabs = new ArrayList<String>(gdriver.getWindowHandles());
  					  
  					  gdriver.switchTo().window(tabs.get(1));
  	        	      
  	        	      
  	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultRC+"\"]");
      	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
      	  	      	  saveBtn.click();
      	  	      	  wait = (new FluentWait(gdriver))
      	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
      	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
      	  		  	      .ignoring(NoSuchElementException.class);
      	        	      System.out.println(sTix+": Click "+sDefaultRC);       	      
      	        	      gdriver.switchTo().window(tabs.get(0));
			      	}
	      	   		//Check the Root Cause Comments - text area - incident.u_root_cause_comments
	      	   		String sCurrRCComments = doc.select("textarea[id=\"incident.u_root_cause_comments\"]").val();
		      	   	if (sCurrRCComments.isEmpty()) {
			      	    cssTemp = By.cssSelector("textarea[id=\"incident.u_root_cause_comments\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultRCComments });
		  	    		
			      	}
	      	   		
			   	}
			   	
			   	
      	    	      	  
				if (cssCurrStatus.equals("6")&& isAging) {
	      	   		
	      	   		Select drpStatus = new Select(gdriver.findElement(By.id("incident.u_next_step_displayed")));
	      	    	drpStatus.selectByVisibleText("Close or cancel task");
	      	  	
	      	    	//button id="sysverb_update_and_stay"
	  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
	  	      	  saveBtn.click();
	  	      	  wait = (new FluentWait(gdriver))
	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
	  		  	      .ignoring(NoSuchElementException.class);
	        	      System.out.println(sTix+": Save Status to Review");
	        	      
	        	      cssCurrStatus="9";
	        	      isUpdate=true;
	        	      try {
		  	    	        Thread.sleep(5000L);
		  	    	      isUpdate=true;
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
	        	      sContent = gdriver.getPageSource();		                  
	                  doc = Jsoup.parse(sContent);
	      	    	//gdriver.switchTo().alert().accept();	
      	    	
	      	   	}
	      	   
	      	  
				if (cssCurrStatus.equals("9") && isAging) {   
	      	   		
	      	   		
		      	   	//check the closure
					String cssCurrAcceptance = doc.select("input[id=\"sys_original.incident.u_auto_close_acceptance\"]").val();
					Select CurrAcceptance = new Select(gdriver.findElement(By.id("incident.u_auto_close_acceptance")));
					if (cssCurrAcceptance.equals("Feedback")) {
						
						CurrAcceptance.selectByVisibleText("Agreed");
						
						 cssTemp = By.cssSelector("textarea[id=\"incident.u_client_closure_comment\"]");
				  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
				  	    	webTemp.sendKeys(new CharSequence[] { sDefaultBCComments });	
				  	    	
						//button id="sysverb_update_and_stay"
			  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			  	      	  saveBtn.click();
			  	      	  wait = (new FluentWait(gdriver))
			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
			  		  	      .ignoring(NoSuchElementException.class);
			        	      System.out.println(sTix+": Save Feedback Status to Agreed");			        	      
			        	      try {
				  	    	        Thread.sleep(5000L);
				  	    	      isUpdate=true;
				  	    	      } catch (InterruptedException e) {
				  	    	        e.printStackTrace();
				  	    	      } 
			        	      sContent = gdriver.getPageSource();		                  
			                  doc = Jsoup.parse(sContent);
			      	    	//gdriver.switchTo().alert().accept();	
			        	      			        	      
					}
					
					By cssLoadListBtn = By.cssSelector("button[class=\"btn btn-default related-list-trigger\"]");
		  	      	WebElement loadListBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssLoadListBtn));
		  	      	loadListBtn.click();
		  	      	wait = (new FluentWait(gdriver))
		  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		  		  	      .ignoring(NoSuchElementException.class);
		        	      
		        	      
		        	By cssLoadList = By.cssSelector("div[id=\"related_lists_wrapper\"]");
		        	WebElement loadList = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssLoadList));
		        	wait = (new FluentWait(gdriver))
			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
			  		  	      .ignoring(NoSuchElementException.class);
			        	      System.out.println(sTix+": Load Related List");
			        	      
        	        sContent = gdriver.getPageSource();		                  
                    doc = Jsoup.parse(sContent);
				
	      	  	
	      	    
					//set the autolosure
					
					//set the comment
					//textarea-incident.u_client_closure_comment
					  
			      
		      	   	
		      	   	//Scan Breached Commitments
		      	  Elements rows = doc.select("div[id=\"incident.task_sla.task\"]").select("tr");
		      	  i = 0;
			      for (Element tr : rows) {
			    	 String sTR=tr.toString();
			    	 if (sTR!=null) {
			    		 if (sTR.contains("Breached")||sTR.contains("Overdue") ) {
			    			 Elements tds = tr.select("td");
			    			 int tdIndex=0;
			    			  for (Element td : tds) {
			    				  
			    				  switch (tdIndex) {
			    				  case 0: break;
			    				  case 1: break;
			    				  case 2: //here
			    					  String sTempURL=sURLBase+td.select("a").attr("href");
			    					  System.out.println(sTix+": sTempURL="+sTempURL);
			    					  
			    					  
			    					  
			    					 
			    					    
			    					  gdriver.executeScript("window.open()");
			    					  
			    					  tabs = new ArrayList<String>(gdriver.getWindowHandles());
			    					  
			    					  gdriver.switchTo().window(tabs.get(1));
			    					 
			    					
			    					    gdriver.get(sTempURL);
			    					    try{
			    					    	
			    					        
			    					          By cssTABreachComments = By.cssSelector("textarea[id=\"task_sla.u_breach_comments\"]");
			    					          WebElement webTABreachComments = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(cssTABreachComments));
			    					          String sTempContent = gdriver.getPageSource();
			    					          Document tempDoc = null;
			    					          tempDoc = Jsoup.parse(sTempContent);
			    					          String sCurTABreachComments = tempDoc.select("textarea[id=\"task_sla.u_breach_comments\"]").val();
			    					      	   	if (sCurTABreachComments.isEmpty()) {
			    						      	    cssTemp = By.cssSelector("textarea[id=\"task_sla.u_breach_comments\"]");
			    						  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			    						  	    	webTemp.sendKeys(new CharSequence[] { sDefaultBCComments });
			    					  	    		
			    						  	    
			    					      	      
			    						      	}
			    					      	   	
			    					      	   	//sys_display.task_sla.u_breach_reason_code
			    					      	   	//549d58c1db81330468fd7b5a8c9619c1
			    					      	   	
			    					      	   	
				    					      	  String sCurTABreachReason = tempDoc.select("input[id=\"sys_display.task_sla.u_breach_reason_code\"]").val();
				    					      	   	if (sCurTABreachReason.isEmpty()) {
			    					      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.task_sla.u_breach_reason_code\"]");
			    			  	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			    			  	  	      	  saveBtn.click();
			    			  	  	      	  wait = (new FluentWait(gdriver))
			    			  	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
			    			  	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
			    			  	  		  	      .ignoring(NoSuchElementException.class);
			    			  	        	      System.out.println(sTix+": Pick lookup.task_sla.u_breach_reason_code");
			    			  	        	      
			    			  	        	      
			    			  	        	      tabs = new ArrayList<String>(gdriver.getWindowHandles());
			    			  					  
			    			  					  gdriver.switchTo().window(tabs.get(2));
			    			  	        	      
			    			  	        	      
			    			  	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultBreachRC+"\"]");
			    			      	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			    			      	  	      	  saveBtn.click();
			    			      	  	      	  wait = (new FluentWait(gdriver))
			    			      	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
			    			      	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
			    			      	  		  	      .ignoring(NoSuchElementException.class);
			    			      	        	      System.out.println(sTix+": Click "+sDefaultRC);   
			    			      	        	      
			    			      	        	      
			    			      	        	      gdriver.switchTo().window(tabs.get(1));
			    						      	}
				    					      	   	
				    					      	   	
			    				      	   	
			    					      	   	
			    					      	   	
			    					      	   	//save - sysverb_update_and_stay
		    						  	    	
			    						  	       cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_bottom\"]");
			    						      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			    						      	  saveBtn.click();
			    						      	  wait = (new FluentWait(gdriver))
			    							  	      .withTimeout(1L, TimeUnit.MINUTES)
			    							  	      .pollingEvery(1L, TimeUnit.SECONDS)
			    							  	      .ignoring(NoSuchElementException.class);
			    					      	      System.out.println(sTix+": Update Breach Comment.");
			    					      	   
			    					      	      gdriver.close();
			    					      	   	
			    					      	   	
			    					    	
			    					    } catch (Exception e) {
			    					    	
			    					    }
			    					    
			    					    //gdriver.close();
			    					    gdriver.switchTo().window(tabs.get(0));
			    					    
			    					  break;
			    					  default: break;
			    				  
			    				  }
			    				  
			    				  tdIndex++;
			    				  
			    				  
			    			  }
			    		 }
			    		 
			    	 }
			    	 
			      } //end of TR loop
			       
		      	   	
		      	   	//if Resolved, set to  'Close or cancel task'
		      	   	
		      	   	
		      	   	
		      	   	//Set to Close
			      if (isAging) {
	      	   		Select drpStatus = new Select(gdriver.findElement(By.id("incident.u_next_step_displayed")));
	      	    	drpStatus.selectByVisibleText("Set to closed");
	      	    	gdriver.switchTo().alert().accept();	
	      	    	isUpdate=true;
	      	      	System.out.println(sTix+": Set ticket to CLOSED.");
			      } else {
			    	  System.out.println(sTix+": Aging if FALSE cannot CLOSE.");
			      }
	      	    
	      	    
	      	   	}
	      	  	
      	    	
				if (  isUpdate) {
					boolean isLoop=true;
					int tries=0;
					while (isLoop) {
		      	  	//button id="sysverb_update_and_stay"
						 isLoop=false;
	      	   	  System.out.println(sTix+": Update is TRUE. Saving...");
			      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
			      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			      	  saveBtn.click();
			      	  wait = (new FluentWait(gdriver))
				  	      .withTimeout(1L, TimeUnit.MINUTES)
				  	      .pollingEvery(1L, TimeUnit.SECONDS)
				  	      .ignoring(NoSuchElementException.class);
			      	 try {
		  	    	        Thread.sleep(5000L);
		  	    	      isUpdate=true;
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
		      	      
		      	      //Read the notification message
		      	      //output_messages
			      	 sContent = gdriver.getPageSource();				          
			          doc = Jsoup.parse(sContent);
			          System.out.println(sTix+": Checking Info Message");
			      	  try {
			      	      divs = doc.select("div[id=\"output_messages\"]").select("div").select("div");
					      i = 0;
					      for (Element div : divs) {
					    	  String sMessageType= div.select("span").select("span").text();
					    	  String sMessage= div.select("div").text();
					    	  System.out.println(sTix+": "+sMessageType+" :"+sMessage);		
					    	  if (!sMessage.isEmpty()) {
					    		  if (sMessage.contains("The task must have a primary CI")) {
					    			  if (tries<3) {
					    				  
					    				
					    	  	    
					    	  	    	
					    				  isLoop=true;
					    			  }
					    			  tries++;
					    		  }
					    	  }
					      }
					      
					      if (isLoop) {
					    	  	
		    	        	  	
			    	      	  
		    	  	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCI));
		    	  	    		webRequestor.clear();
		    	  	    		webRequestor.sendKeys(new CharSequence[] { sDefaultCI });
		    	  	    		 try {
		    	  	    	        Thread.sleep(5000L);
		    	  	    	    	
		    						//button id="sysverb_update_and_stay"
		    			  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
		    			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
		    			  	      	  saveBtn.click();
		    			  	      	gdriver.switchTo().alert().accept();	
		    			  	      	  wait = (new FluentWait(gdriver))
		    			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		    			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		    			  		  	      .ignoring(NoSuchElementException.class);
		    			        	      System.out.println(sTix+": Update CI");	
		    			        	     

		    			  				if (cssCurrStatus.equals("9") && isAging) {  
		    			  					 try {
				  				  	    	        Thread.sleep(5000L);
				  				  	    	      isUpdate=true;
				  				  	    	      } catch (InterruptedException e) {
				  				  	    	        e.printStackTrace();
				  				  	    	      } 
			    			        	  	//Set to Close
			    				      	   		Select drpStatus = new Select(gdriver.findElement(By.id("incident.u_next_step_displayed")));
			    				      	    	drpStatus.selectByVisibleText("Set to closed");
			    				      	    	gdriver.switchTo().alert().accept();	
			    				      	    	 cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
					    			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
					    			  	      	  saveBtn.click();
					    			  	        wait = (new FluentWait(gdriver))
						    			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
						    			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
						    			  		  	      .ignoring(NoSuchElementException.class);
		    			  				}
		    	  	    	      } catch (InterruptedException e) {
		    	  	    	        e.printStackTrace();
		    	  	    	      } 
					      }
			      	  } catch (Exception e1) {
			      		  System.out.println(sTix+": Error "+e1.getMessage());
			      	  }
			      	  
				    		  
					}
				    	  
				    	  System.out.println(sTix+": Update Done");
				    	 
				    
				      
		      	      
	      	   	} else {
	      	   		System.out.println(sTix+": Update is FALSE. No Saving");
	      	   	}
      	      
	      	   	}
        	  
          } else {
        	  System.out.println(sTix+": Record NOT Found.");
          }
          
          try {
           
          } catch (Exception ec) {
            System.out.println(ec.getMessage());
          } 
          
          
          System.gc();
        } catch (Exception e1) {
          System.out.println(e1.getMessage());
          
        } 
	    
	   
	
	    
		/*
		 * //close the button //<button _ngcontent-kjy-c71=""
		 * class="flat-button ng-star-inserted" style=""
		 * pbi-focus-tracker-idx="2">Close</button> try { By cssClose =
		 * By.cssSelector("button[_ngcontent-kjy-c71=\"\"]"); WebElement btnClose =
		 * (WebElement)wait.until((Function)ExpectedConditions.
		 * visibilityOfElementLocated(cssClose)); btnClose.click(); wait = (new
		 * FluentWait(gdriver)) .withTimeout(10L, TimeUnit.SECONDS) .pollingEvery(1L,
		 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		 * 
		 * 
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
    	
    	
    	
		
	    
	  }
  
  
  
 public static void snowCloseTicketRequest( String sTicketNumber) throws InterruptedException {

	  /*
	   Close tickets that are in review/resovled status and more than 7 days. To close ticket status must change to review first and then set to closed

            Parameters:
                    sTicketNumber: NTT request ticket number

            Returns:
                     Close tickets that are in review/resovled status and more than 7 days.
                     To close ticket status must change to review first and then set to closed.
                     Certain fields have to be filled up in order to close the tickets.


	   */
	  
	  //By.cssSelector("input[id=\"incident.number\"]");
	  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
	  
	  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
	  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  
	  String sRequestor="Monitoring Alerts";
	  String sClassification= "MHIS";
	  String currStatus="0";
	  
	 
	  String sDefaultResolutionCode="7b78ad2fdb3a84544a5e56915b961984";
	  String sDefaultClosureDetails="Auto Closure by RPA";
	  String sDefaultResolvedBy="Svc sgpbiapp";
	  
	  String sDefaultRC="76d8ed23db7a84544a5e56915b961975";
	  String sDefaultRCComments="Auto Closure by RPA";
	  String sDefaultBCComments="Auto Closure by RPA";
	  String sDefaultCI="";
	  
	  String sDefaultBreachRC="b0b76d27db3a84544a5e56915b96194a";
	  
		By cssTemp = null;
	    WebElement webTemp = null;
	    
	    boolean isUpdate=false;
	    boolean isAging=false;
	    boolean isAutoCloseFail=false;
	    	
	    
	    ArrayList<String> tabs=null;
	    
	    By cssSaveBtn = null;
      	  WebElement saveBtn =null;
      	  
      try {
    	  String sURL = "https://dimensiondataservices.service-now.com/u_request.do?sysparm_query=number%3D"+sTicketNumber;
          gdriver.get(sURL);
          String sContent = gdriver.getPageSource();
          FluentWait<WebDriver> wait = (new FluentWait(gdriver))
            .withTimeout(20L, TimeUnit.SECONDS)
            .pollingEvery(1L, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
          By css = By.cssSelector("input[id=\"u_request.number\"]");
          WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
          sContent = gdriver.getPageSource();
          Document doc = null;
          doc = Jsoup.parse(sContent);
          String sTix = doc.select("input[id=\"u_request.number\"]").val();
          if (sTix.equals(sTicketNumber)) {
        	  	System.out.println(sTix+": Record Found");  
        	  	
        	  	//Check ticket status - sys_readonly.incident.state
        	  	String cssCurrStatus = doc.select("input[id=\"u_request.state\"]").val();
	      	   	System.out.println(sTix+": CurrentStatus="+cssCurrStatus);  	
	      	   	if (cssCurrStatus.equals("-15")) {
	      	   	System.out.println(sTix+": Ignore Cancelled ticket");
	      	   	} else if (cssCurrStatus.equals("7")) {
	      	   		System.out.println(sTix+": Ignore Close ticket");
	      	   	} else {
        	  	
        	  	String sCurrRequestor = doc.select("input[id=\"sys_display.u_request.u_caller\"]").val();
        	  	
        	  	
        	  	//Get the Assignment Group sys_display.incident.assignment_group
        		String sCurrAssignmentGroup = doc.select("input[id=\"sys_display.u_request.assignment_group\"]").val();
        		
        		if (!sCurrAssignmentGroup.isEmpty()) {
        			if (!sCurrAssignmentGroup.equalsIgnoreCase("NTT.CMS.MHIS")) {
        				//Resolution Code sys_original.incident.u_task_resolution_code value=a47d4805db89ffc068fd7b5a8c961904
        				// sys_display.incident.u_task_resolution_code value="Other"
        				//((JavascriptExecutor) gdriver).executeScript("document.getElementsByName('u_request.u_task_resolution_code').item(0).value = 'a47d4805db89ffc068fd7b5a8c961904';");
        				//lookup.incident.u_task_resolution_code
        				
        				sDefaultResolutionCode="a47d4805db89ffc068fd7b5a8c961904";
        				sDefaultResolvedBy="Svc sgpbiapp";
        				sDefaultRC="1fb5d1da0fc64a8c7ca9f18362050ec8";
        				sDefaultBreachRC="0f00fbfddb66a4906eeb08a8f496191e";
        				//Root Cause incident.u_task_rootcause 1fb5d1da0fc64a8c7ca9f18362050ec8 lookup.incident.u_task_rootcause
            	        	     
            	        	      
        				
        				
        			} 
        		}
        	  	
        	  	//Update Requestor
        	  	By cssRequestor = By.cssSelector("input[id=\"sys_display.u_request.u_caller\"]");
      	    	
      	    	if (sCurrRequestor.isEmpty()) {
      	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssRequestor));
      	    		webRequestor.sendKeys(new CharSequence[] { sRequestor });
      	    		 try {
      	    	        Thread.sleep(5000L);
      	    	      isUpdate=true;
      	    	      } catch (InterruptedException e) {
      	    	        e.printStackTrace();
      	    	      } 
      	    	}
      	    	
      	    	
      	    	String sCurrCI = doc.select("input[id=\"sys_display.u_request.u_contract_ci\"]").val();
          	  	By cssCI = By.cssSelector("input[id=\"sys_display.u_request.u_contract_ci\"]");  	
          	  	
      	   	
      	    	//Contact sys_display.incident.u_contract
      	  	String sCurrContract = doc.select("input[id=\"sys_display.u_request.u_contract\"]").val();
      	  if (!sCurrContract.isEmpty()) {
      		  if (sCurrContract.equals("MHIS Managed Hybrid Infrastructure Services")) {
      			sDefaultCI="155512476";
      		  }
      		  else if (sCurrContract.equals("Enterprise Infrastructure Management delivered by Ctry")) {
       			sDefaultCI="167691394";
       		  }
      		  else if (sCurrContract.equals("Enterprise Infrastructure Management delivered by CDO")) {
        			sDefaultCI="130450503";
        	 }
      		else if (sCurrContract.equals("Enterprise AddOn for Supplier Management")) {
    			sDefaultCI="167691394";
    	 }
      	  }
      		 //
      		  
      	    	
      	    	//Update Classification if null
      	    	//sys_display.incident.u_classification
      	    	String cssCurrClassification = doc.select("input[id=\"sys_display.u_request.u_classification\"]").val();
	      	  	
	  	    	if (cssCurrClassification.isEmpty()) {
	  	    		By cssClassification = By.cssSelector("input[id=\"sys_display.u_request.u_classification\"]");
		  	    	WebElement webClassification = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssClassification));
	  	    		webClassification.sendKeys(new CharSequence[] { sClassification });
	  	    		 try {
	  	    	        Thread.sleep(5000L);
	  	    	      isUpdate=true;
	  	    	      } catch (InterruptedException e) {
	  	    	        e.printStackTrace();
	  	    	      } 
	  	    	}
      	    	
      	    	//Update AffectedContact
      	    	/*
        	  	By cssAffacted = By.cssSelector("input[id=\"sys_display.incident.u_requested_for\"]");
      	    	WebElement webAffected = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssAffacted));
	      	  	if (webAffected.getCssValue("value").isEmpty()) {
	      	    	webAffected.sendKeys(new CharSequence[] { sRequestor });
	      	  	}
	      	  	*/
	      	  	
	  	    	
	  	    	
	  	    	
	  	    	//check the last comment. close ticket if last comment >7 days
	  	    	//div id: element.incident.comments.additional
	  	   	//Scan Breached Commitments
		      	  Elements divs = doc.select("div[id=\"element.u_request.comments.additional\"]").select("span").select("div").select("div");
			      int i = 0;
			      for (Element div : divs) {
			    	 
			    	  switch (i) {
			    	  case 0: break;
			    	  case 2: //latest comment here
			    		  String sDate= div.select("span").select("strong").text().substring(0,20);
			    		  LocalDate lastDate= LocalDate.parse(setSalesForceDateFormat(sDate));
			    		  LocalDate currDate = LocalDate.now();
			    		  long intervalDays = ChronoUnit.DAYS.between(lastDate, currDate);
			    		  
			    		  System.out.println(sTix+": Last Comment on :"+lastDate.toString()+" - "+intervalDays+" days ago");
			    		  
			    		  if (intervalDays >5) {
			    			  isAging=true;
			    		  }
			    		  break;
			    	default: break;
			    		  
			    	 }
			    	  i++;
			    	 
			      } //end of TR loop
	  	    
	  	    	
			      
			      //Check if Auto Closure Fail by searching keyword= "Auto closure was started but will NOT continue" in worknotes
			      String sWorkNotes = doc.select("div[id=\"element.u_request.work_notes.additional\"]").text();
			      if (sWorkNotes.contains("Closure information")) {
			    	  System.out.println(sTix+": can close as Auto Close Failed");
			    	  isAutoCloseFail=true;
			    	  
			      }
			     
	  	    	
	      	  	//getCurrent Status; sys_original.incident.state
			      
			   	if (cssCurrStatus.equals("6") || cssCurrStatus.equals("9") ) {
    				

	      	   		//Check The Resolution Code - input - sys_display.incident.u_task_resolution_code
	      	   		String sCurrResolutionCode = doc.select("input[id=\"sys_display.u_request.u_task_resolution_code\"]").val();
		      	   	if (sCurrResolutionCode.isEmpty()) {
		      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.u_request.u_task_resolution_code\"]");
    	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
    	  	      	  saveBtn.click();
    	  	      	  wait = (new FluentWait(gdriver))
    	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
    	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
    	  		  	      .ignoring(NoSuchElementException.class);
    	        	      System.out.println(sTix+": Pick lookup.u_request.u_task_resolution_code");
    	        	      
    	        	      
    	        	     tabs = new ArrayList<String>(gdriver.getWindowHandles());
    					  
    					  gdriver.switchTo().window(tabs.get(1));
    	        	      
    	        	      
    	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultResolutionCode+"\"]");
        	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
        	  	      	  saveBtn.click();
        	  	      	  wait = (new FluentWait(gdriver))
        	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
        	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
        	  		  	      .ignoring(NoSuchElementException.class);
        	        	      System.out.println(sTix+": Click "+sDefaultResolutionCode);       	      
        	        	      gdriver.switchTo().window(tabs.get(0));
			      	}
		      	   	
		      	   	
	      	   		//Check the Closure details - textarea - incident.close_notes
	      	   		String sCurrClosureDetails = doc.select("textarea[id=\"u_request.close_notes\"]").val();
		      	   	if (sCurrClosureDetails.isEmpty()) {
			      	    cssTemp = By.cssSelector("textarea[id=\"u_request.close_notes\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultClosureDetails });
		  	    		
			      	}
	      	   		//Check the Resolved by - input - sys_display.incident.u_resolved_by - (NTTCMS/ Purnama Sidhi)
	      	   		String sCurrResolvedBy = doc.select("input[id=\"sys_display.u_request.u_resolved_by\"]").val();
		      	   	if (sCurrResolvedBy.isEmpty()) {
			      	    cssTemp = By.cssSelector("input[id=\"sys_display.u_request.u_resolved_by\"]");
			  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			  	    	webTemp.sendKeys(new CharSequence[] { sDefaultResolvedBy });
		  	    		 try {
		  	    	        Thread.sleep(5000L);
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
			      	}
	      	   	
	      	   		
	      	   		
			   	}
      	    	      	  
	      	   	if (cssCurrStatus.equals("6") && isAging) {
	      	   		
	      	   		Select drpStatus = new Select(gdriver.findElement(By.id("u_request.u_next_step_displayed")));
	      	    	drpStatus.selectByVisibleText("Monitor situation");
	      	  	
	      	    	//button id="sysverb_update_and_stay"
	  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
	  	      	  saveBtn.click();
	  	      	  wait = (new FluentWait(gdriver))
	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
	  		  	      .ignoring(NoSuchElementException.class);
	        	      System.out.println(sTix+": Save Status to Review");
	        	      
	        	      cssCurrStatus="9";
	        	      isUpdate=true;
	      	    	//gdriver.switchTo().alert().accept();	
      	    	
	      	   	}
	      	   
	      	  
	      	   	if (cssCurrStatus.equals("9") && isAging) {
	      	   		
	      	   	By cssLoadListBtn = By.cssSelector("button[class=\"btn btn-default related-list-trigger\"]");
	  	      	WebElement loadListBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssLoadListBtn));
	  	      	loadListBtn.click();
	  	      	wait = (new FluentWait(gdriver))
	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
	  		  	      .ignoring(NoSuchElementException.class);
	        	      
	        	      
	        	By cssLoadList = By.cssSelector("div[id=\"related_lists_wrapper\"]");
	        	WebElement loadList = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssLoadList));
	        	wait = (new FluentWait(gdriver))
		  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		  		  	      .ignoring(NoSuchElementException.class);
		        	      System.out.println(sTix+": Load Related List");
		        	      
    	        sContent = gdriver.getPageSource();		                  
                doc = Jsoup.parse(sContent);
	      	   		
	      	   	  	
		      	   	//Scan Breached Commitments
		      	  Elements rows = doc.select("div[id=\"u_request.task_sla.task\"]").select("tr");
		      	  i = 0;
			      for (Element tr : rows) {
			    	 String sTR=tr.toString();
			    	 if (sTR!=null) {
			    		 if (sTR.contains("Breached")||sTR.contains("Overdue") ) {
			    			 Elements tds = tr.select("td");
			    			 int tdIndex=0;
			    			  for (Element td : tds) {
			    				  
			    				  switch (tdIndex) {
			    				  case 0: break;
			    				  case 1: break;
			    				  case 2: //here
			    					  String sTempURL=sURLBase+td.select("a").attr("href");
			    					  System.out.println(sTix+": sTempURL="+sTempURL);
			    					  
			    					  
			    					  
			    					 
			    					    
			    					  gdriver.executeScript("window.open()");
			    					  
			    					  tabs = new ArrayList<String>(gdriver.getWindowHandles());
			    					  
			    					  gdriver.switchTo().window(tabs.get(1));
			    					 
			    					
			    					    gdriver.get(sTempURL);
			    					    try{
			    					    	
			    					        
			    					          By cssTABreachComments = By.cssSelector("textarea[id=\"task_sla.u_breach_comments\"]");
			    					          WebElement webTABreachComments = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(cssTABreachComments));
			    					          String sTempContent = gdriver.getPageSource();
			    					          Document tempDoc = null;
			    					          tempDoc = Jsoup.parse(sTempContent);
			    					          String sCurTABreachComments = tempDoc.select("textarea[id=\"task_sla.u_breach_comments\"]").val();
			    					      	   	if (sCurTABreachComments.isEmpty()) {
			    						      	    cssTemp = By.cssSelector("textarea[id=\"task_sla.u_breach_comments\"]");
			    						  	    	webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
			    						  	    	webTemp.sendKeys(new CharSequence[] { sDefaultBCComments });
			    					  	    		
			    						  	    
			    					      	      
			    						      	}
			    					      	   	
			    					      	   	//sys_display.task_sla.u_breach_reason_code
			    					      	   	//549d58c1db81330468fd7b5a8c9619c1
			    					      	   	
			    					      	   	
				    					      	  String sCurTABreachReason = tempDoc.select("input[id=\"sys_display.task_sla.u_breach_reason_code\"]").val();
				    					      	   	if (sCurTABreachReason.isEmpty()) {
			    					      	   	 cssSaveBtn = By.cssSelector("button[id=\"lookup.task_sla.u_breach_reason_code\"]");
			    			  	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			    			  	  	      	  saveBtn.click();
			    			  	  	      	  wait = (new FluentWait(gdriver))
			    			  	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
			    			  	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
			    			  	  		  	      .ignoring(NoSuchElementException.class);
			    			  	        	      System.out.println(sTix+": Pick lookup.task_sla.u_breach_reason_code");
			    			  	        	      
			    			  	        	      
			    			  	        	      tabs = new ArrayList<String>(gdriver.getWindowHandles());
			    			  					  
			    			  					  gdriver.switchTo().window(tabs.get(2));
			    			  	        	      
			    			  	        	      
			    			  	        	   cssSaveBtn = By.cssSelector("a[name=\""+sDefaultBreachRC+"\"]");
			    			      	  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			    			      	  	      	  saveBtn.click();
			    			      	  	      	  wait = (new FluentWait(gdriver))
			    			      	  		  	      .withTimeout(1L, TimeUnit.MINUTES)
			    			      	  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
			    			      	  		  	      .ignoring(NoSuchElementException.class);
			    			      	        	      System.out.println(sTix+": Click "+sDefaultRC);   
			    			      	        	      
			    			      	        	      
			    			      	        	      gdriver.switchTo().window(tabs.get(1));
			    						      	}
				    					      	   	
				    					      	   	
			    				      	   	
			    					      	   	
			    					      	   	
			    					      	   	//save - sysverb_update_and_stay
		    						  	    	
			    						  	       cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_bottom\"]");
			    						      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			    						      	  saveBtn.click();
			    						      	  wait = (new FluentWait(gdriver))
			    							  	      .withTimeout(1L, TimeUnit.MINUTES)
			    							  	      .pollingEvery(1L, TimeUnit.SECONDS)
			    							  	      .ignoring(NoSuchElementException.class);
			    					      	      System.out.println(sTix+": Update Breach Comment.");
			    					      	   
			    					      	      gdriver.close();
			    					      	   	
			    					      	   	
			    					    	
			    					    } catch (Exception e) {
			    					    	
			    					    }
			    					    
			    					    //gdriver.close();
			    					    gdriver.switchTo().window(tabs.get(0));
			    					    
			    					  break;
			    					  default: break;
			    				  
			    				  }
			    				  
			    				  tdIndex++;
			    				  
			    				  
			    			  }
			    		 }
			    		 
			    	 }
			    	 
			      } //end of TR loop
			       
		      	   	
		      	   	
		      	   	
		      	   	
		      	   	
		      	   	//Set to Close
	      	   		Select drpStatus = new Select(gdriver.findElement(By.id("u_request.u_next_step_displayed")));
	      	    	drpStatus.selectByVisibleText("Set to closed");
	      	    	gdriver.switchTo().alert().accept();	
	      	    	gdriver.switchTo().alert().accept();
	      	      isUpdate=true;
	      	      System.out.println(sTix+": Set ticket to CLOSED.");
	      	   	}
	      	  	
      	    	
	      	   	

				if (  isUpdate) {
					boolean isLoop=true;
					int tries=0;
					while (isLoop) {
		      	  	//button id="sysverb_update_and_stay"
						 isLoop=false;
	      	   	  System.out.println(sTix+": Update is TRUE. Saving...");
			      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
			      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
			      	  saveBtn.click();
			      	gdriver.switchTo().alert().accept();
			      	  wait = (new FluentWait(gdriver))
				  	      .withTimeout(1L, TimeUnit.MINUTES)
				  	      .pollingEvery(1L, TimeUnit.SECONDS)
				  	      .ignoring(NoSuchElementException.class);
			      	 try {
		  	    	        Thread.sleep(5000L);
		  	    	      isUpdate=true;
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
		      	      
		      	      //Read the notification message
		      	      //output_messages
			      	 sContent = gdriver.getPageSource();				          
			          doc = Jsoup.parse(sContent);
			          System.out.println(sTix+": Checking Info Message");
			      	  try {
			      	      divs = doc.select("div[id=\"output_messages\"]").select("div").select("div");
					      i = 0;
					      for (Element div : divs) {
					    	  String sMessageType= div.select("span").select("span").text();
					    	  String sMessage= div.select("div").text();
					    	  System.out.println(sTix+": "+sMessageType+" :"+sMessage);		
					    	  if (!sMessage.isEmpty()) {
					    		  if (sMessage.contains("The task must have a primary CI") || sMessage.contains("The task must have an assigned CI")) {
					    			  if (tries<1) {
					    				  
					    				
					    	  	    
					    	  	    	
					    				  isLoop=true;
					    			  }
					    			  tries++;
					    		  }
//					    		  if (sMessage.contains("The task must have an assigned CI")) {
//					    			  if (tries<3) {
//					    				  
//					    				
//					    	  	    
//					    	  	    	
//					    				  isLoop=true;
//					    			  }
//					    			  tries++;
//					    		  }
					    	  }
					      }
					      
					      if (isLoop) {
					    	  	
		    	        	  	
			    	      	  
		    	  	    		WebElement webRequestor = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCI));
		    	  	    		webRequestor.clear();
		    	  	    		webRequestor.sendKeys(new CharSequence[] { sDefaultCI });
		    	  	    		 try {
		    	  	    	        Thread.sleep(5000L);
		    	  	    	    	
		    						//button id="sysverb_update_and_stay"
		    			  	      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
		    			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
		    			  	      	  saveBtn.click();
		    			  	      	gdriver.switchTo().alert().accept();	
		    			  	      	  wait = (new FluentWait(gdriver))
		    			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
		    			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
		    			  		  	      .ignoring(NoSuchElementException.class);
		    			        	      System.out.println(sTix+": Update CI");	
		    			        	     

		    			  				if (cssCurrStatus.equals("9") && isAging) {  
		    			  					 try {
				  				  	    	        Thread.sleep(5000L);
				  				  	    	      isUpdate=true;
				  				  	    	      } catch (InterruptedException e) {
				  				  	    	        e.printStackTrace();
				  				  	    	      } 
			    			        	  	//Set to Close
			    				      	   		Select drpStatus = new Select(gdriver.findElement(By.id("u_request.u_next_step_displayed")));
			    				      	    	drpStatus.selectByVisibleText("Set to closed");
			    				      	    	gdriver.switchTo().alert().accept();
			    				      	    	gdriver.switchTo().alert().accept();
			    				      	    	 cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
					    			  	      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
					    			  	      	  saveBtn.click();
					    			  	        wait = (new FluentWait(gdriver))
						    			  		  	      .withTimeout(1L, TimeUnit.MINUTES)
						    			  		  	      .pollingEvery(1L, TimeUnit.SECONDS)
						    			  		  	      .ignoring(NoSuchElementException.class);
		    			  				}
		    	  	    	      } catch (InterruptedException e) {
		    	  	    	        e.printStackTrace();
		    	  	    	      } 
					      }
			      	  } catch (Exception e1) {
			      		  System.out.println(sTix+": Error "+e1.getMessage());
			      	  }
			      	  
				    		  
					}
				    	  
				    	  System.out.println(sTix+": Update Done");
				    	 
				    
				      
		      	      
	      	   	} else {
	      	   		System.out.println(sTix+": Update is FALSE. No Saving");
	      	   	}
      	      
	      	   	}
        	  
          } else {
        	  System.out.println(sTix+": Record NOT Found.");
          }
          
          try {
           
          } catch (Exception ec) {
            System.out.println(ec.getMessage());
          } 
          
          
          System.gc();
        } catch (Exception e1) {
          System.out.println(e1.getMessage());
          
        } 
	    
	   
	
	
    	
		
	    
	  }
 
 
 public static void snowUpdateComment(String sTicketNumber, String sComment) {
	 String sType="incident";
	 if (sTicketNumber.contains("SVR") || sTicketNumber.contains("CHG") ) {
		 sType="request";
	 }
	 
	 snowUpdateComment( sType,  sTicketNumber,  sComment);
 }
 
 public static void snowUpdateComment(String sType, String sTicketNumber, String sComment) {
	  
	  
    String sURLBase="https://dimensiondataservices.service-now.com/";
	String sURL="";
	By cssTemp = null;
	WebElement webTemp = null;
	boolean isUpdate=false;
	By cssSaveBtn = null;
    WebElement saveBtn =null;
    sComment="[Update by NTT-SG-BOT]\r\n"+ sComment;
     	  
     try {
    	 //u_request
    	 if (sType.equals("incident")) {
    		 sURL = "https://dimensiondataservices.service-now.com/task.do?sysparm_query=number%3D"+sTicketNumber;
    	 } else {
    		 sURL = "https://dimensiondataservices.service-now.com/u_request.do?sysparm_query=number%3D"+sTicketNumber; 
    	 }
         gdriver.get(sURL);
         String sContent = gdriver.getPageSource();
         FluentWait<WebDriver> wait = (new FluentWait(gdriver))
           .withTimeout(20L, TimeUnit.SECONDS)
           .pollingEvery(1L, TimeUnit.SECONDS)
           .ignoring(NoSuchElementException.class);
         By css = By.cssSelector("input[id=\""+sType+".number\"]");
         WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
         sContent = gdriver.getPageSource();
         Document doc = null;
         doc = Jsoup.parse(sContent);
         String sTix = doc.select("input[id=\""+sType+".number\"]").val();
         if (sTix.equals(sTicketNumber)) {
       	  	System.out.println(sTix+": Record Found");  
       	  	
       	  	
       	  	
	      	   		
	      	   		//Update Comment
	      	   		//#incident\.comments
	      	   			
	      	   			
	      	       	  	css = By.cssSelector("textarea[id=\""+sType+".comments\"]");
	      	     	    element = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(css));
	      	     	    element.clear();
	      	     	    element.sendKeys(new CharSequence[] { sComment });
	      	     	 try {
		  	    	        Thread.sleep(5000L);
		  	    	      isUpdate=true;
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
	      	     	 isUpdate=true;		    	   			     	  
	      	       	   	     	   		
	      	   	
       	  	
		       	  	if (isUpdate) {
		       	  		
			     	
			     	    cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
						saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
						saveBtn.click();
						      	  wait = (new FluentWait(gdriver))
							  	      .withTimeout(1L, TimeUnit.MINUTES)
							  	      .pollingEvery(1L, TimeUnit.SECONDS)
							  	      .ignoring(NoSuchElementException.class);
						     
						      	
						      	System.out.println(sTix+": SNOW Update Completed");
						      	 
						      	 
		       	  	}
       	  	
     	    	
       	  
     	    	
     	      
	      	   	
       	  
         } else {
       	  System.out.println(sTix+": Record NOT Found.");
         }
         
         try {
          
         } catch (Exception ec) {
           System.out.println(ec.getMessage());
         } 
         
         
         System.gc();
       } catch (Exception e1) {
         System.out.println(e1.getMessage());
         
       } 
	    
}
 
 public static void pingSNOW() {
	  
	  
	    String sURLBase="https://dimensiondataservices.service-now.com/";		

	    
	     	  
	     try {
	    	
	         gdriver.get(sURLBase);
	         String sContent = gdriver.getPageSource();
	         FluentWait<WebDriver> wait = (new FluentWait(gdriver))
	           .withTimeout(20L, TimeUnit.SECONDS)
	           .pollingEvery(1L, TimeUnit.SECONDS)
	           .ignoring(NoSuchElementException.class);	        
	       
	         
	         System.gc();
	       } catch (Exception e1) {
	         System.out.println(e1.getMessage());
	         
	       } 
		    
	}
 
 public static void snowReassign(String sType, String sTicketNumber, String sNewAssigneeGroup, String sNewAssignee) {
	  
		  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  String sURL="";
	By cssTemp = null;
	WebElement webTemp = null;
	boolean isUpdate=false;
	By cssSaveBtn = null;
    WebElement saveBtn =null;
    
     	  
     try {
    	 //u_request
    	 if (sType.equals("incident")) {
    		 sURL = "https://dimensiondataservices.service-now.com/task.do?sysparm_query=number%3D"+sTicketNumber;
    	 } else {
    		 sURL = "https://dimensiondataservices.service-now.com/u_request.do?sysparm_query=number%3D"+sTicketNumber; 
    	 }
         gdriver.get(sURL);
         String sContent = gdriver.getPageSource();
         FluentWait<WebDriver> wait = (new FluentWait(gdriver))
           .withTimeout(20L, TimeUnit.SECONDS)
           .pollingEvery(1L, TimeUnit.SECONDS)
           .ignoring(NoSuchElementException.class);
         By css = By.cssSelector("input[id=\""+sType+".number\"]");
         WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
         sContent = gdriver.getPageSource();
         Document doc = null;
         doc = Jsoup.parse(sContent);
         String sTix = doc.select("input[id=\""+sType+".number\"]").val();
         if (sTix.equals(sTicketNumber)) {
       	  	System.out.println(sTix+": Record Found");  
       	  	
       	  	//Check ticket Short Description - sys_readonly.incident.state    	  	
       	  	
       	  	String sCurrShortDescription = doc.select("input[id=\""+sType+".short_description\"]").val();
	      	   	System.out.println(sTix+": Current Short Description="+sCurrShortDescription);  	
	      	   	if (!sCurrShortDescription.contains("#reassign")) {
	      	   		System.out.println(sTix+": Invalid Reassign Ticket");
	      	   
	      	   	} else {
       	  	
	      	   		
	      	   		//Update Assignee group
	      	   		if (sNewAssigneeGroup!=null) {
	      	   			
	      	   			
	      	       	  	css = By.cssSelector("input[id=\"sys_display."+sType+".assignment_group\"]");
	      	     	    element = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(css));
	      	     	    element.clear();
	      	     	    element.sendKeys(new CharSequence[] { sNewAssigneeGroup });
	      	     	 try {
		  	    	        Thread.sleep(5000L);
		  	    	      isUpdate=true;
		  	    	      } catch (InterruptedException e) {
		  	    	        e.printStackTrace();
		  	    	      } 
	      	     	 isUpdate=true;		
	      	   			
	      	   		} else 	  	System.out.println(sTix+": Empty Assignee group");  
	      	   
		      	   		
		      	   		//Update Assignee
		      	   	if (sNewAssignee!=null) {
		      	   		
		      	  	css = By.cssSelector("input[id=\"sys_display."+sType+".assigned_to\"]");
	  	     	    element = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(css));
	  	     	    element.clear();
	  	     	    element.sendKeys(new CharSequence[] { sNewAssignee });
	  	     	 try {
	  	    	        Thread.sleep(5000L);
	  	    	      isUpdate=true;
	  	    	      } catch (InterruptedException e) {
	  	    	        e.printStackTrace();
	  	    	      } 
	  	     	 isUpdate=true;
	      	   			
		      	  } else 	  	System.out.println(sTix+": Empty Assignee");
	      	   		
	      	   	
       	  	
		       	  	if (isUpdate) {
		       	  		sCurrShortDescription=sCurrShortDescription.replaceAll("#reassign", "#re-assigned");
		       	  		css = By.cssSelector("input[id=\""+sType+".short_description\"]");
			     	    element = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(css));
			     	    element.clear();
			     	    element.sendKeys(new CharSequence[] { sCurrShortDescription });
			     	
			     	    cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
						saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
						saveBtn.click();
						      	  wait = (new FluentWait(gdriver))
							  	      .withTimeout(1L, TimeUnit.MINUTES)
							  	      .pollingEvery(1L, TimeUnit.SECONDS)
							  	      .ignoring(NoSuchElementException.class);
						     
						      	
						      	System.out.println(sTix+": Completed");
						      	 
						      	 
		       	  	}
       	  	
     	    	
       	  
     	    	
     	      
	      	   	}
       	  
         } else {
       	  System.out.println(sTix+": Record NOT Found.");
         }
         
         try {
          
         } catch (Exception ec) {
           System.out.println(ec.getMessage());
         } 
         
         
         System.gc();
       } catch (Exception e1) {
         System.out.println(e1.getMessage());
         
       } 
	    
}
 
 public static void checkVendorPortal (String sVendor) {
	 
	 initVendor(sVendor);
	 //get list of tickets
	 clTicket clTix = new clTicket(gDBName);
	 String sPrefix="";
	 
	 if (sVendor.equals("sabre")) {
		 sPrefix="03";		 
	 } else if (sVendor.equals("viseo")) {
		 sPrefix="ASCO01C-";		 
	 }
	 
	 
		 String[] venTix =  clTix.getVendorTickets(sPrefix);
		 if (venTix!=null) {
			 if (venTix.length>0) {
				 int len=venTix.length;
				 for (int i=0;i<len;i++) {
					 String sLine=venTix[i];
					 String[] sValue = sLine.split("\\|");
					 if (sValue!=null) {
						 if (sValue.length>0) {
							 String sNumber = sValue[0];
							 String sTicket =sValue[1];
							 if (sTicket!=null) {
								 String[] sTickets = sTicket.split(",");
								 for (int j=0;j< sTickets.length; j++) {
									 String sTix= sTickets[j];
									 if (sTix!=null) {
										 sTix= sTix.trim();
										 if (sTix.startsWith(sPrefix)) {
											 //check the vendor portal
											 checkVendorTicket(sVendor, sTix, sNumber);
											 //update snow
										 } else {
											 
											 //Ignore the tix
											 System.out.println("Ignore "+sTix);
										 }
									 }
								 }
							 }
						 }
					 }
				 }
			 }
		 }
	 
	 
 }
 
 
 public static void initVendor(String sVendor) {
	
	    if (gdriver!=null) {
	    	System.out.println("Connected");   	
	    
	    } else {
	    	 gdriver = getDriverServiceNow();
	    }
	  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  String sURL="";
	By cssTemp = null;
	WebElement webTemp = null;
	boolean isUpdate=false;
	By cssSaveBtn = null;
    WebElement saveBtn =null;
    
     	  
     try {
    	 //u_request
    	 if (sVendor.equals("sabre")) {
    		 sURL = "https://sabrehospitality-community.force.com/CustomerCommunity/s/login/";
    	 } else if (sVendor.equals("viseo")) {
    		 sURL = "https://support.viseo.com/servicedesk/customer/user/login";
    	 }
         gdriver.get(sURL);
         String sContent = gdriver.getPageSource();
         FluentWait<WebDriver> wait = (new FluentWait(gdriver))
           .withTimeout(20L, TimeUnit.SECONDS)
           .pollingEvery(1L, TimeUnit.SECONDS)
           .ignoring(NoSuchElementException.class);
         
         if (sVendor.equals("sabre")) {
		         By cssUserName = By.cssSelector("input[placeholder=\"Username\"]");
		 	    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
		 	    usernameTxt.sendKeys(new CharSequence[] { "it_helpdesk@capitaland.com" });
		 	   
		 	    By cssPassword = By.cssSelector("input[placeholder=\"Password\"]");
		 	    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
		 	    password.sendKeys(new CharSequence[] { "P@ss123456" });
		 	    By cssNextPwdBtn = By.cssSelector("body > div.ct-body.ct-login.cCtSabre_HC_ThemeLayout_Login > div.ct-content-container > div > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(3) > div > div:nth-child(4) > button");
		 	    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
		 	    nextPwdBtn.click();
         } else if (sVendor.equals("viseo")) {
        	 
        	 	By cssUserName = By.cssSelector("input[placeholder=\"Username\"]");
		 	    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
		 	    usernameTxt.sendKeys(new CharSequence[] { "it_helpdesk@capitaland.com" });
		 	   
		 	    By cssPassword = By.cssSelector("input[placeholder=\"Password\"]");
		 	    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
		 	    password.sendKeys(new CharSequence[] { "P@ss1234" });
		 	    By cssNextPwdBtn = By.cssSelector("#js-login-submit");
		 	    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
		 	    nextPwdBtn.click();         
         }
 	  
 	    System.out.println("initVendor - Completed");
     
         try {
          
         } catch (Exception ec) {
           System.out.println(ec.getMessage());
         } 
         
         
         System.gc();
       } catch (Exception e1) {
         System.out.println(e1.getMessage());
         
       } 
	    
}
 
 public static void checkVendorTicket(String sVendor, String sTicketNumber, String sNumber) {
	  /*

	  Scrap data such as status and comment updates from 3rd party vendor system and update NTT snow (currently not working, suspect due to changes in the login)

            Parameters:
                    sVendor: name of the vendor, currently only Viseo and Sabre
                    sTicketNumber: external vendor ticket number
                    sNumber: NTT ticket number correspond to the external ticket number

            Returns:
                    Get each ticket number, status, date, comment and update on NTT SNOW
	   */
		
	    if (gdriver!=null) {
	    	System.out.println("Connected");   	
	    
	    } else {
	    	 gdriver = getDriverServiceNow();
	    }
	  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  String sURL="";
	
	boolean isUpdate=false;
	By cssSaveBtn = null;
 WebElement saveBtn =null;
 
 String sSelector="";
 By cssCommon = null;
    WebElement commonTxt =null;
    
    String sTpNumber="";
    String sStatus="";
    String sLastUser="";
    String sLastRemarks="";
    String sLastUpdate="";
  	  
  try {
 	 //u_request
 	 if (sVendor.equals("sabre")) {
 		 sURL = "https://sabrehospitality-community.force.com/CustomerCommunity/s/global-search/"+sTicketNumber;
 	 } else if (sVendor.equals("viseo")) {
 		 sURL = "https://support.viseo.com/servicedesk/customer/portal/1/"+sTicketNumber;
 	 }
      gdriver.get(sURL);
      String sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(20L, TimeUnit.SECONDS)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      pause(5);
      if (sVendor.equals("sabre")) {
    	  		sSelector="a[title=\""+sTicketNumber+"\"]";
		         cssCommon = By.cssSelector(sSelector);
		 	     commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		 	    //System.out.println("Found : "+ commonTxt.getText()+ ":"+commonTxt.getAttribute("href"));
		 	    sURL=commonTxt.getAttribute("href");
		 	    //Go to the URL
		 	   gdriver.get(sURL);
		       sContent = gdriver.getPageSource();
		       wait = (new FluentWait(gdriver))
		         .withTimeout(20L, TimeUnit.SECONDS)
		         .pollingEvery(1L, TimeUnit.SECONDS)
		         .ignoring(NoSuchElementException.class);
		       pause(2);
		       
		       //ticket
		       //body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(1) > header > div.slds-page-header.slds-page-header_record-home.forceHighlightsStencilDesktop.forceRecordLayout > ul > li:nth-child(2) > div > div > div > span
		       sSelector = "body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(1) > header > div.slds-page-header.slds-page-header_record-home.forceHighlightsStencilDesktop.forceRecordLayout > ul > li:nth-child(2) > div > div > div > span";
		       cssCommon = By.cssSelector(sSelector);
		       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		       sTpNumber=commonTxt.getText();
		 	    //System.out.println("Ticket : "+ sTpNumber);
		 	    
		       //status
		       //body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(1) > header > div.slds-page-header.slds-page-header_record-home.forceHighlightsStencilDesktop.forceRecordLayout > ul > li:nth-child(1) > div > div > div > span
		       sSelector ="body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(1) > header > div.slds-page-header.slds-page-header_record-home.forceHighlightsStencilDesktop.forceRecordLayout > ul > li:nth-child(1) > div > div > div > span";
		       cssCommon = By.cssSelector(sSelector);
		       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		       sStatus=commonTxt.getText();
		 	    //System.out.println("Status : "+ sStatus);
		 	   
		 	    //User
		 	   sSelector= "body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(2) > div > div.recordHomeSecondaryContent > div > div > div > div:nth-child(1) > article > div:nth-child(2) > div > div > div > div > div.listViewContent > div > div > table > tbody > tr:nth-child(1) > th";
		       cssCommon = By.cssSelector(sSelector);
		       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		       sLastUser=commonTxt.getText();
		 	    //System.out.println("User : "+ sLastUser);
		 	    
		       //Get Date
		       sSelector= "body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(2) > div > div.recordHomeSecondaryContent > div > div > div > div:nth-child(1) > article > div:nth-child(2) > div > div > div > div > div.listViewContent > div > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > span";
		       cssCommon = By.cssSelector(sSelector);
		       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		       sLastUpdate=convertDateTime(commonTxt.getText(),"M/d/yyyy h:mm aaa");
		 	    //System.out.println("Date : "+ sLastUpdate);
		 	    
		 	    //Comment
		 	   sSelector= "body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(2) > div > div.recordHomeSecondaryContent > div > div > div > div:nth-child(1) > article > div:nth-child(2) > div > div > div > div > div.listViewContent > div > div > table > tbody > tr:nth-child(1) > td:nth-child(4)";
		       cssCommon = By.cssSelector(sSelector);
		       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		       sLastRemarks=commonTxt.getText();
		       //System.out.println("Comment : "+ sLastRemarks);
		       
      } else if (sVendor.equals("viseo")) {
    	  
    	
     	 
    	  //ticket
	       //body > div.ct-body.ct-hide-chat.cCtSabre_HC_ThemeLayout_Main > div > div.ct-content-container > div.ct-content > div > div > div > div.slds-col--padded.contentRegion.comm-layout-column > div > div:nth-child(1) > header > div.slds-page-header.slds-page-header_record-home.forceHighlightsStencilDesktop.forceRecordLayout > ul > li:nth-child(2) > div > div > div > span
	       sSelector = "#content > div > header > div > div > div.cv-global-level-title > div.aui-page-header-main.cv-page-title-main > div > ol > li:nth-child(3)";
	       cssCommon = By.cssSelector(sSelector);
	       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
	       sTpNumber=commonTxt.getText();
	 	    //System.out.println("Ticket : "+ sTpNumber);
	 	    
	       //status
	       //#content > div > header > div > div > div.cv-global-level-title > div.aui-page-header-main.cv-page-title-main > h2 > span.request-status-lozenge > span
	 	   sSelector ="#content > div > header > div > div > div.cv-global-level-title > div.aui-page-header-main.cv-page-title-main > h2 > span.request-status-lozenge > span";
	       cssCommon = By.cssSelector(sSelector);
	       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
	       sStatus=commonTxt.getText();
	 	    //System.out.println("Status : "+ sStatus);
	 	   
	 	   
	 	    
	       //Get Date
	       //sSelector= "#content > div > div > div > section > section.cv-request-activity > div > ul > li:nth-child(1) > div > header > time";
	 	    sSelector="#content > div > div > div > section > section.cv-request-activity > div > ul > li:nth-child(1) > div > header > time";
	       cssCommon = By.cssSelector(sSelector);
	       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
	       sLastUpdate=convertDateTime(commonTxt.getText(),"dd/MMM/yy h:mm aaa");
	 	    //System.out.println("Date : "+ sLastUpdate);
	 	   
	 	   
	 	    //Comment
	 	   sSelector= "#content > div > div > div > section > section.cv-request-activity > div > ul > li:nth-child(2) > div > div.content";
	       cssCommon = By.cssSelector(sSelector);
	       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
	       sLastRemarks=commonTxt.getText();
	       //System.out.println("Comment : "+ sLastRemarks);
	       
	       try {
	    	   //User
		 	   sSelector= "#content > div > div > div > section > section.cv-request-activity > div > ul > li:nth-child(1) > div > header > h4";
		       cssCommon = By.cssSelector(sSelector);
		       commonTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssCommon));
		       sLastUser=commonTxt.getText();
		 	    //System.out.println("User : "+ sLastUser);
	       } 
	       catch (Exception e3) {
	    	   sLastUser="SYSTEM";
	    	   //System.out.println("User : SYSTEM");
	       }
	 	    
      }
      
      
      //Insert to DB
      clTicket3P tix3P = new clTicket3P(gDBName);
	  tix3P.setNumber(sNumber);
	  tix3P.setTpnumber(sTpNumber);
	  tix3P.setTpvendorname(sVendor);
	  tix3P.setStatus(sStatus);
	  tix3P.setLast_user(sLastUser);
	  tix3P.setLast_remarks(sLastRemarks);
	  tix3P.setLast_update(sLastUpdate);
	  tix3P.dbLoad();
	  
	  //update NTT SNOW
	  if (tix3P.isInserted) {
		//Compose Comment for SNOW
		 String sComment="3RD PARTY VENDOR UPDATE - "+sVendor+"\r\n"
				 + "Ticket Number: "+ sTpNumber+"\r\n"
				 + "Status: "+ sStatus+"\r\n"
				 + "Last Update by: "+ sLastUser+"\r\n"
				 + "Last Update on: "+ sLastUpdate+"\r\n"
				 + "Remarks: \r\n"+ sLastRemarks;
		 snowUpdateComment(sNumber, sComment);
	  } else {
		  pingSNOW();
	  }
	  
	    System.out.println("checkVendorTicket:"+sVendor+" - Completed");
  
      try {
       
      } catch (Exception e2) {
        System.out.println(e2.getMessage());
      } 
      
      
      System.gc();
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
      
    } 
	    
}
 public static void snowAnalyze(String sType, String sTicketNumber, rpaTicket rpaTix) {

	  /*
	   Scrap data from servicenow and store into database

            Parameters:
                    sType: Ticket classification (Incident/Request)
                    sTicketNumber: Capitaland ticket number
                    rpaTix: rpaTicket object to store the data into rpaTicket table

            Returns:
                    Get each ticket number, status, assignment group, assigned to, requestor, last comment date and store in rpaTiicket table
	   */
	  
	  
	 String sURLBase="https://capitaland.service-now.com/";
	  String sURL="";
	By cssTemp = null;
	WebElement webTemp = null;
	boolean isUpdate=false;
	By cssSaveBtn = null;
    WebElement saveBtn =null;
    int iMaxHistory=10;
     	  
     try {
    	 
    	 //u_request
    	 if (sType.contains("incident")) {
    		 sURL = "https://capitaland.service-now.com/task.do?sysparm_query=correlation_id%3D"+sTicketNumber;
    	 } else {
    		 sURL = "https://capitaland.service-now.com/u_request.do?sysparm_query=correlation_id%3D"+sTicketNumber; 
    	 }
         gdriver.get(sURL);
         String sContent = gdriver.getPageSource();
         FluentWait<WebDriver> wait = (new FluentWait(gdriver))
           .withTimeout(20L, TimeUnit.SECONDS)
           .pollingEvery(1L, TimeUnit.SECONDS)
           .ignoring(NoSuchElementException.class);
         By css = By.cssSelector("input[id=\""+sType+".number\"]");
         WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
         sContent = gdriver.getPageSource();
         Document doc = null;
         doc = Jsoup.parse(sContent);
         //sys_original.incident.description
         String sTix = doc.select("input[id=\"sys_original."+sType+".description\"]").val();
         //if (sTix.contains(sTicketNumber)) {
       	  	//System.out.println(sTix+": Record Found");  
         
     		//Get CL Ticket#
     	String sCLTicket = doc.select("input[id=\""+sType+".number\"]").val();
     	String sCLTaskTicket="";
         if (sType.equals("incident_task")){
        	 sCLTaskTicket=sCLTicket;
        	 sCLTicket = doc.select("input[id=\"sys_display."+sType+".incident\"]").val();
         } else {
    	  
         }
       	  	//Get Ticket Status
       	  	String sStatus = doc.select("input[id=\"sys_original."+sType+".state\"]").val();
       	  	String sStatusString = doc.select("select[id=\""+sType+".state\"]").select("option[selected]").text();
       	  	
       	  	//Get Assignment Group - sys_display.incident.assignment_group
       	  	String sAssignmentGroup = doc.select("input[id=\"sys_display."+sType+".assignment_group\"]").val();
       	  	
       	  	//Get AssignedTo - sys_display.incident.assigned_to
       	  	String sAssignedTo = doc.select("input[id=\"sys_display."+sType+".assigned_to\"]").val();
       	  	
       	  	//Get Requester - sys_display.incident.caller_id
       	  	String sRequester = doc.select("input[id=\"sys_display."+sType+".caller_id\"]").val();
       	  	if (sType.equals("incident_task")){
       	  	sRequester = doc.select("input[id=\"sys_display."+sType+".incident.caller_id\"]").val();
       	  	}
       	  	//Get Last 5 Comments
       	  	
       	  	//if (sStatus.equals("7")) {
       	  		//Close ticket at CL Snow. Proceed with ticket closure at NTT Snow
       	  	//} else {
       	  		//3 - On hold
       	  		
       	  		//Get The Comments -div id: sn_form_inline_stream_entries
       	  	//Scan Breached Commitments
		      	  Elements lis = doc.select("div[id=\"sn_form_inline_stream_entries\"]").select("ul").first().select("li");
		      	  int i = 0;
		      	  String sUpdater="";
		      	String sUpdateType="";
		      	String sUpdateOn="";
		      	String sComment="";
		      	String sHistory="";
		      	String sLastCommentDate="";
		      	String sLastChangeStatus="";
		      	boolean iChanged=false;
			      for (Element li : lis) {
			    	 String sTR=li.toString();
			    	 
			    	 	try {
			    	  sUpdater = li.select("span[class=\"sn-card-component-createdby\"]").text(); //span class="sn-card-component-createdby"
			    	 	} catch (Exception e) {
			    	 		sUpdater="";
			    	 	}
			    	 	try {
			    	  sUpdateType = li.select("span[class=\"sn-card-component-time\"]").select("span").get(1).text();
			    	 	} catch (Exception e) {
			    	 		sUpdateType="";
			    	 	}
			    	 	try {
			    	  sUpdateOn = li.select("div[class=\"date-calendar\"]").text();
			    	 	} catch (Exception e) {
			    	 		sUpdateOn="";
			    	 	}
			    	 	try {
			    	 		
			    	 		if (sUpdateType.equals("Email sent")) {
			    	 			sComment = li.select("div[class=\"sn-card-component sn-card-component_records\"]").text();
			    	 		} else if (sUpdateType.equals("Attachment uploaded")) {
			    	 			//
			    	 			sComment = li.select("div[class^=\"sn-card-component sn-card-component_headline sn-card-component_headline_sm sn-card-component_attachment\"]").text();
			    	 			
			    	 		} else if (sUpdateType.equals("Field changes")) {
			    	 			sComment = li.select("div[class=\"sn-card-component sn-card-component_records\"]").text();//sn-card-component sn-card-component_records
			    	 			if (sComment.toLowerCase().contains("state")) {
			    	 				
			    	 				if (!iChanged) sLastChangeStatus=setSalesForceDateTimeFormat(sUpdateOn);
			    	 				iChanged=true;
			    	 			}
			    	 		} else 
			    	 			sComment = li.select("div[class^=\"sn-card-component sn-card-component_summary\"]").text();//sn-card-component sn-card-component_summary sn-card-component_summary_spacing
			    	 		
			    	 		if (sComment.length()>4096) {
			    	 			sComment=sComment.substring(0, 4096)+"...";
			    	 		}
			    	  
			    	 	} catch (Exception e) {
			    	 		sComment="";
			    	 	}
			    	 	if (sUpdater.length()>1) {
			    	 		if (i==0) {
			    	 			sLastCommentDate=setSalesForceDateTimeFormat(sUpdateOn);
			    	 		}
			    	 		if (i<=iMaxHistory) {
			    	 			sHistory=sHistory+sUpdater+"|"+sUpdateType+"|"+sUpdateOn+"|"+sComment+"\r\n";
			    	 		}
			    	 		i++;
			    	 	}
			    	 	
			    	 	
			    	 	
			      }
			      
			      //System.out.println(sLastCommentDate+":"+sLastChangeStatus+"-History="+sHistory);
			      rpaTix.list.add(sTicketNumber);
			      rpaTix.list.add(sCLTicket);
			      rpaTix.list.add(sCLTaskTicket);
			      rpaTix.list.add(sRequester);
			      rpaTix.list.add(sAssignmentGroup);
			      rpaTix.list.add(sAssignedTo);
			      rpaTix.list.add(sStatusString);
			      rpaTix.list.add(sStatus);
			      rpaTix.list.add(sLastCommentDate);
			      if (sLastChangeStatus.length()<1) {
			    	  sLastChangeStatus=setSalesForceDateTimeFormat(sLastChangeStatus);
			      }
			      rpaTix.list.add(sLastChangeStatus);
			      rpaTix.list.add(sHistory);			  
			      if (rpaTix.Load()) {
			    	  rpaTix.list.clear();
			      }
			      //System.out.println("Done.");
       	  		
       	  	//}
       	  	       	  	//Check the ticket status
       	  	
       	  	
       	  	
       	  	//if ticket is INCTASK:
       	  	//1. check the parent ticket. if parent ticket is closed, send update to close the ticket
       	  	//2. if the parent ticket is not close, check the list of inctask, check the last 5 comments on inc
       	  	//3. if the parent ticket is not close, check the last 5 comments on inctask
       	  	
       	  	
       	  	//Check ticket Short Description - sys_readonly.incident.state    	  	
       	  	
       	  
       	  
         //} else {
       	 // System.out.println(sTix+": Record NOT Found.");
         //}
         
         
         
         
         System.gc();
       } catch (Exception e1) {
         System.out.println(e1.getMessage());
         
       } 
	    
}
 
 
 public static String setSalesForceDateTimeFormat(String sDateTime) {
	    String temp = null;
	    String sDate="";
	    String sTime="00:00:00";
	    try {
	    	
	    	sDateTime=sDateTime.trim();
	    	
	    String[] sD= sDateTime.split(" ");
	    if (sD!=null) {
	    	if (sD.length==2) {
	    		sDate=sD[0];
	    		sTime=sD[1];
	    	}
	    }
	    	
	      sDate = sDate.trim();
	    } catch (Exception e) {
	      sDate = "";
	    } 
	    if (sDate.equals("")) {
	      temp = "0000-00-00";
	    } else {
	      try {
	        String[] s = sDate.split("-");
	        
	        if (s!=null) {
	        	temp = "0000-00-00";
	        	if (s.length>2) {
				        String sMonth = s[1];
				        if (sMonth!=null) {
				        	switch (sMonth) {
				        	case "Jan" : sMonth="01"; break;
				        	case "Feb" : sMonth="02"; break;
				        	case "Mar" : sMonth="03"; break;
				        	case "Apr" : sMonth="04"; break;
				        	case "May" : sMonth="05"; break;
				        	case "Jun" : sMonth="06"; break;
				        	case "Jul" : sMonth="07"; break;
				        	case "Aug" : sMonth="08"; break;
				        	case "Sep" : sMonth="09"; break;
				        	case "Oct" : sMonth="10"; break;
				        	case "Nov" : sMonth="11"; break;
				        	case "Dec" : sMonth="12"; break;    	
				        	
				        	}
				        }
				        
				        
				        
				        String sDay = s[0];
				        if (sDay.length() == 1)
				          sDay = "0" + sDay; 
				      
				       
				          temp = String.valueOf(s[2]) + "-" + sMonth + "-" + sDay;
	        	}
	        }
	      
	      } catch (Exception e) {
	    	  temp = "0000-00-00";
	      } 
	    } 
	    if (temp == null)
	    	 temp = "0000-00-00";
	    if (temp.equals(""))
	    	 temp = "0000-00-00"; 
	    if (temp.isEmpty())
	    	 temp = "0000-00-00";
	    return temp+" "+sTime;
	  }
  
 
 public static void initProperties() {
	 CodeSource codeSource = servicenow.class.getProtectionDomain().getCodeSource();
	 File jarFile;
	try {
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		 File jarDir = jarFile.getParentFile();

		 if (jarDir != null && jarDir.isDirectory()) {
		   File propFile = new File(jarDir, "system.properties");
		 }
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
 
  
  public static void main(String[] args) {

	  /*
	  This is a rpa for capitaland, keppel and natsteel.

	  Capitaland:
	  1. Download reports from capitaland and ntt servicenow, store data into mysql database.

	  2. Get tickets information from captialand snow for status that are work in progress, external provider action and client action,
	  and store into database. Data are used for the wip, epa and ca email reminder.

	  3. Closure of incident/request tickets that are in resolved/review status and last comment date more than 7 days.

	  4. Update velocity table

	  5. Refresh powerbi reports (currently not working)

	  6. Update 3rd party vender (currently not working)

	  Keppel:
	  1. Download reports from ntt servicenow, store data into mysql database.

	  2. Update velocity table

	  3. Refresh powerbi reports


	  Natsteel:
	  1. Download reports from ntt servicenow, store data into mysql database.

	  2. Update velocity table

	  3. Refresh powerbi reports

	   */


    try {
    	gSession = generateRandomStringByUUIDNoDash();
    /*
    	gDBName="keppel";   
    	 updateVelocity();
    	 System.exit(0);
    	 */
    	//Set the databasename
    	
    	gDBName="capitaland";    
    	
      
    	String sTicketState="Client action";
    	if (args!=null) {
    		if (args.length>0) {
    			gDBName=args[0];
    			if (args.length>1) {
    				String tmpIndex=args[1];
    				sTicketState=tmpIndex.replaceAll("-", " ");
    			}
    		}
    	}
    	
    	
    	
    	if (gDBName.equals("RPA-CL")) {
    		
    	} else {
    		initDriverServiceNow();
    	}
    	
    	
    	//
    	
    	
    	//===========CAPITALAND ALL =================
    	//Incident - ALL
    	//08f340a81b7f601c32fe337e0d4bcb46
    	//downloadReport("08f340a81b7f601c32fe337e0d4bcb46");
    	//Request - ALL - cfb598951bbbac1ca604113e1d4bcb35    	
    	//downloadReport("cfb598951bbbac1ca604113e1d4bcb35");
    	//Change - ALL - e92a14d91bfbac1ca604113e1d4bcbbd
    	//downloadReport("e92a14d91bfbac1ca604113e1d4bcbbd");
    	//===========END OF CAPITALAND ALL =================
    	
    	//===========KEPPEL ALL =================
    	//Incident - ALL
    	//1b07585d1bbbac1ca604113e1d4bcb19
    	//downloadReport("1b07585d1bbbac1ca604113e1d4bcb19");
    	//Request - ALL - 69e710511bfbac1ca604113e1d4bcbb3    	
    	//downloadReport("69e710511bfbac1ca604113e1d4bcbb3");
    	//Change - ALL - 2cb858151bfbac1ca604113e1d4bcbc6
    	//downloadReport("2cb858151bfbac1ca604113e1d4bcbc6");    	
    	//Problem - ALL - b9a990191bfbac1ca604113e1d4bcba2
    	//downloadReport("b9a990191bfbac1ca604113e1d4bcba2");
    	//===========END OF KEPPEL ALL =================
    	
    	//System.exit(0);
    	//opportunityCase.dbUpdateIdOpportunity();
    	//System.exit(0);
    	
    	//initPBI(gdriver,"ntt@dutabot.com","12qwasZX", "me", true);pbiRefresh(gdriver,"me", "2d5da45a-916f-443f-9f5e-1f92c73ec46a");
		/*
		 * initDriverPowerBI();
		 * initPBI(gdriverPBI,"purnama.sidhi@global.ntt","P@ssw0rd",
		 * "9d707749-d22a-4b02-af38-6ef3377d5b25", false);
		 * pbiRefresh(gdriverPBI,"9d707749-d22a-4b02-af38-6ef3377d5b25",
		 * "ccc3ee5a-0df0-46b0-9180-df4ffd136622"); System.exit(0);
		 */
    	//2d5da45a-916f-443f-9f5e-1f92c73ec46a
    
    	//snowCloseTicket("ICM126437537");

    	boolean isLoop=true;
    	
    	if (gDBName.equals("capitaland")|| gDBName.equals("keppel") || gDBName.equals("natsteel")) {
    		
    		
    	    		
    		
    		//initPBI(gdriverPBI,"purnama.sidhi@global.ntt","P@ssw0rd", "9d707749-d22a-4b02-af38-6ef3377d5b25", false);
    		
    	
    	}
    	
    	while (isLoop) {

        	System.out.println("Execution Started!===================================");
    	//reasign report 875c1f021b53e05493c0fd5e0d4bcbd6
    	if (gDBName.equals("capitaland")) {
    		System.out.println("1. Reassign Tickets");
    		downloadReport("875c1f021b53e05493c0fd5e0d4bcbd6", "Reassign");
    	}
    	
    	
    	
    	//RPA Cleaning Up =====================
    	if (gDBName.equals("RPA-Keppel")) {
	    	snowUpdate("keppel");
	    	snowUpdateRequest("keppel");
    	}
    	
    	//RPA Cleaning Up =====================
    	if (gDBName.equals("RPA-NatSteel")) {
	    	snowUpdate("natsteel");
	    	snowUpdateRequest("natsteel");
    	}
    	
    	//RPA Cleaning Up =====================
    	if (gDBName.equals("RPA")) {
    		System.out.println("START RPA CL - Closing Tickets");
	    	snowUpdate("capitaland");
//	    	snowUpdateRequest("capitaland");
	    	System.out.println("END RPA CL - Closing Tickets");
	    	isLoop=false;
    	}
    	
    	if (gDBName.equals("RPAREQ")) {
    		System.out.println("START RPA CL - Closing Tickets - REQ");
//	    	snowUpdate("capitaland");
	    	snowUpdateRequest("capitaland");
	    	System.out.println("END RPA CL - Closing Tickets - REQ");
	    	isLoop=false;
    	}
    	
//    	FOR PATCHING ONLY
//    	if (gDBName.equals("capitaland")) {
//    		System.out.println("START patching");
//    		System.out.println("Download Report from NTT SNOW");
//    		downloadReport("1a27facd879605d0923b99373cbb35b8", "SLA");
//    		downloadReport("74d1cf0587da05d0923b99373cbb35a0", "SLA");
//    		downloadReport(reportIDnum, "SLA");
//	    	System.out.println("END patching");
//	    	isLoop=false;
//    	}
    	
    	
    	
    	//RPA Checking Capitaland ===============
    	if (gDBName.equals("RPA-CL")) {
    		initDriverServiceNowCL();
    		System.out.println("START RPA CL - Checking ticket status");
	    	initCapitaLand("fa48b8b7db3ee414955c622fd396192f");
	    	snowUpdateEPAACA("capitaland",sTicketState);    	
	    	System.out.println("END RPA CL - Checking ticket status");
	    	isLoop=false;
    	}
    	
    	//Testing =========================
    	//downloadReport("b8d9edf11b7e24d822e92f072d4bcb80", "SLA");
    	//downloadReport("b32219791bf224d822e92f072d4bcbb7");
    	//System.exit(0);
    	
    	if (gDBName.equals("capitaland")) {
    	
    	
    	System.out.println("2. Download Report from NTT SNOW");
    	//NTT ========================
    	//Problem
    	downloadReport("080b074e1b32ac54b1bdfdd91d4bcba9");
    	//Service Request
    	downloadReport("6d634f0e1bbe6c54b1bdfdd91d4bcb97");
    	//Change
    	downloadReport("4fc3078e1bbe6c54b1bdfdd91d4bcb44");
    	//Incident
    	downloadReport("b32219791bf224d822e92f072d4bcbb7");
    	//SLA
    	downloadReport("b8d9edf11b7e24d822e92f072d4bcb80", "SLA");
    	
    	System.out.println("3. Download Report from CL SNOW");
    	//CAPITALAND ========================
    	initCapitaLand("fa48b8b7db3ee414955c622fd396192f");
    	//Incident 38c9bc3bdb3ee414955c622fd39619be
    	downloadReportCapitaLand("38c9bc3bdb3ee414955c622fd39619be", "INCIDENT");
    	//Incident Task fbfa560cdbe3a49840bb564dd396199d
    	downloadReportCapitaLand("fbfa560cdbe3a49840bb564dd396199d", "INCTASK");    	
    	downloadReportCapitaLand("fa48b8b7db3ee414955c622fd396192f", "SCTASK");
    	// Change
    	//https://capitaland.service-now.com/sys_report_template.do?jvar_report_id=346d78ffdb3ee414955c622fd39619a7
    	downloadReportCapitaLand("346d78ffdb3ee414955c622fd39619a7", "CHANGE");	
    	
    	
    	System.out.println("4. Update Velocity");
    	updateVelocity();
    	
    	//System.out.println("5. Refresh pBI");	
    	//2d5da45a-916f-443f-9f5e-1f92c73ec46a
    	//initPBI(gdriver,"purnama.sidhi@global.ntt","P@ssw0rd", "9d707749-d22a-4b02-af38-6ef3377d5b25", false);
    	//pbiRefresh(gdriver,"9d707749-d22a-4b02-af38-6ef3377d5b25", "9eeffad4-ba6b-4361-a693-25b66a6d22fe");

    	//initDriverPowerBI();
    	//initPBI(gdriverPBI,"ntt@dutabot.com","12qwasZX", "9d707749-d22a-4b02-af38-6ef3377d5b25", false);
    	//pbiRefresh(gdriverPBI,"me", "2d5da45a-916f-443f-9f5e-1f92c73ec46a");
    	//CapitaLand REport
    	//SCTASK - https://capitaland.service-now.com/sys_report_template.do?CSV&jvar_report_id=fa48b8b7db3ee414955c622fd396192f
    	
    	//Update Vendor();
    	System.out.println("6. Update 3rd Party Vendor Status");
    	//get current hour
    	int iCurrHour= LocalDateTime.now().getHour();
    	if (iCurrHour==14 || iCurrHour==2) {
//	    	checkVendorPortal("sabre");
//	    	checkVendorPortal("viseo");
    	} else {
    		System.out.println("Skipped ("+iCurrHour+")");
    	}
    	
    	}
    	
    	if (gDBName.equals("keppel")) {
    		
    		
    	//Keppel =============================    	
    	//Incident
        downloadReport("1cbc664d1b53641493c0fd5e0d4bcb13");  
        //Change
        downloadReport("34c6cc791b536c1493c0fd5e0d4bcb30");  
        //Problem
        downloadReport("7697007d1b536c1493c0fd5e0d4bcb30");  
        //Service Request
        downloadReport("4f270cf91b536c1493c0fd5e0d4bcbd9");  
        //SLA
        downloadReport("0bd70cbd1b536c1493c0fd5e0d4bcb5f", "SLA");
        
        updateVelocityByAssigneeGroup();
        
        //initDriverPowerBI();
        //initPBI(gdriverPBI,"purnama.sidhi@global.ntt","P@ssw0rd", "9d707749-d22a-4b02-af38-6ef3377d5b25", false);
    	//pbiRefresh(gdriver,"9d707749-d22a-4b02-af38-6ef3377d5b25", "dc8085c9-02b4-443b-96e9-334f762d34d0");
    	}
    	
    	
    	
    	if (gDBName.equals("natsteel")) {
    		
        	//NatSteel =============================    	
        	//Incident daily = ba3ecd021b88f450a604113e1d4bcb93 ; ALL= 760f49861b88f450a604113e1d4bcb61
            downloadReport("ba3ecd021b88f450a604113e1d4bcb93");  
            //Change daily = c07f814a1b88f450a604113e1d4bcb43 ; ALL = 9400110e1b88f450a604113e1d4bcbb2
            downloadReport("c07f814a1b88f450a604113e1d4bcb43");  
            //Problem daily = efd1990a1bc8f450a604113e1d4bcbbb ; ALL= a212dd4a1bc8f450a604113e1d4bcbe4
            downloadReport("efd1990a1bc8f450a604113e1d4bcbbb");  
            //Service Request daily= c021ddc21bc8f450a604113e1d4bcbd4 ; ALL = a87111861bc8f450a604113e1d4bcbe9
            downloadReport("c021ddc21bc8f450a604113e1d4bcbd4");  
            //SLA daily = c7701dce1b88f450a604113e1d4bcba9 ; ALL =  64c0d1821bc8f450a604113e1d4bcb81
            downloadReport("c7701dce1b88f450a604113e1d4bcba9", "SLA");
            
            updateVelocity();
            
            //initDriverPowerBI();
            //initPBI(gdriverPBI,"purnama.sidhi@global.ntt","P@ssw0rd", "9d707749-d22a-4b02-af38-6ef3377d5b25", false);
//        	pbiRefresh(gdriver,"9d707749-d22a-4b02-af38-6ef3377d5b25", "19d7e157-074c-4afd-a495-1f04d8403815");
        	}
    	
    	
//      sfdcCase("");
    	//2019
    	//sfdcReportCase("00O4G000007qk5I"); //Mar-Jun 2019
    	//sfdcReportCase("00O4G000007qk5D"); //Mar-Jun 2019
    	//sfdcReportCase("00O4G000007qk58"); //July-Sep 2019
    	//sfdcReportCase("00O4G000007qk53"); //JOct-Dec 2019
    	
    	/*
    	sfdcReportCase("00O4G000007qk4y"); //Jan-March 2020
    	sfdcReportCase("00O4G000007qk4t"); //April-June 2020
    	sfdcReportCase("00O4G000007qk4o"); //July 2020
    	sfdcReportCase("00O4G000007qk4j"); //Aug 2020
    	sfdcReportCase("00O4G000007qk4Z");
    	sfdcReportCase("00O4G000007qk4P");
    	sfdcReportCase("00O4G000007qk4K");
    	sfdcReportCase("00O4G000007qk4F");
    	sfdcReportCase("00O4G000007qQDK");
    	*/
    	
    	//sfdcReportOpportunity("00O4G000007qk6Q");
    	//sfdcReportOpportunity("00O4G000007qk6L");
    	//sfdcReportOpportunity("00O4G000007bP8U"); //DAILY
    	
    	
    	
    	//Product    	
    	//sfdcReportOpportunityProduct("00O4G000007qk5N");
    	//sfdcReportOpportunityProduct("00O4G000007bPCq"); //Daily
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
    	System.out.println("Execution Completed at: "+ dtf.format(now));
    	if (gDBName.equals("keppel") || gDBName.equals("natsteel") || gDBName.equals("capitaland")) isLoop=false;
    	if (isLoop) {

	    	System.out.println("Sleep for 5 minutes");
	    	System.gc();
	    	 pause(300);
    	}
    	System.out.println("================================");
    	} // end Loop
    	
    } catch (Exception e) {
    	System.out.println("Error: "+e.getMessage());
    } finally {
      gdriver.close();
      gdriver.quit();
      System.exit(0);
    } 
  }
}
