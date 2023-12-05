import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
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

import com.opencsv.CSVReader;

//import javafx.concurrent.Task;


import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONObject;

public class sap {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  public static String dbName = "c1ppms";
  
  public static String grid = "";
  
  public static String gsno = "";
  
  public static String gSession = "";
  
  public static RemoteWebDriver gdriver = null;
  
  public static File gFDownloaded = null;
  
  public static String gDBName = "sap";
  
  
  
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
  





  public static void initDriverSAP() {
    gdriver = getDriverSAP();
    if (gdriver!=null) {
    	System.out.println("Connected");   	
    
    }
    
    FluentWait<WebDriver> wait = (new FluentWait(gdriver))
    	      .withTimeout(5L, TimeUnit.SECONDS)
    	      .pollingEvery(1L, TimeUnit.SECONDS)
    	      .ignoring(NoSuchElementException.class);
	/*
	 * By cssBtn = By.cssSelector("button[class=\"button mb24 secondary wide\"]");
	 * WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.
	 * visibilityOfElementLocated(cssBtn)); btnLogin.click(); wait = (new
	 * FluentWait(gdriver)) .withTimeout(5L, TimeUnit.MINUTES) .pollingEvery(1L,
	 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
	 */
    	    By cssUserName = By.cssSelector("input[name=\"loginfmt\"]");
    	    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
    	    usernameTxt.sendKeys(new CharSequence[] { "svc.sgpbiapp@global.ntt" });
    	    By cssNextBtn = By.cssSelector("input[id=\"idSIButton9\"]");
    	    WebElement nextBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextBtn));
    	    nextBtn.click();
    	    wait = (new FluentWait(gdriver))
    	      .withTimeout(5L, TimeUnit.MINUTES)
    	      .pollingEvery(1L, TimeUnit.SECONDS)
    	      .ignoring(NoSuchElementException.class);
    	    By cssPassword = By.cssSelector("input[name=\"passwd\"]");
    	    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
    	    password.sendKeys(new CharSequence[] { "P@ssw0rd20210909" });
    	    By cssNextPwdBtn = By.cssSelector("input[id=\"idSIButton9\"]");
    	    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
    	    nextPwdBtn.click();
	
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
  
  
  public static RemoteWebDriver getDriverSAP() {
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
    //options.addArguments("--headless");
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

    driver.get("https://glcadsvgtpcen.gd.didata.local/sap/bc/nwbc/?sap-client=500&sap-language=EN&sap-theme=sap_corbu&sap-nwbc-node=0000000371");
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
  
  
  //https://app.powerbi.com/groups/9d707749-d22a-4b02-af38-6ef3377d5b25/list/dashboards
  
  
  public static void initPBI(String sUsername, String sPassword, String sGroupName, boolean isKMIEnable) {
	  if (sGroupName==null) sGroupName="me";
	  String sURL = "https://app.powerbi.com/groups/"+sGroupName+"/list/dataflows";
      gdriver.get(sURL);
      String sContent = gdriver.getPageSource();
	    FluentWait<WebDriver> wait = (new FluentWait(gdriver))
	      .withTimeout(1L, TimeUnit.SECONDS)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    
	    By cssSigninBtn = By.cssSelector("a[data-event-property=\"signin\"]");
	    WebElement btnSignin = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSigninBtn));
	    btnSignin.click();
	    wait = (new FluentWait(gdriver))
	      .withTimeout(1L, TimeUnit.MINUTES)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    
	    
		/*
		 * By cssBtn = By.cssSelector("button[class=\"button mb24 secondary wide\"]");
		 * WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.
		 * visibilityOfElementLocated(cssBtn)); btnLogin.click(); wait = (new
		 * FluentWait(gdriver)) .withTimeout(5L, TimeUnit.MINUTES) .pollingEvery(1L,
		 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		 */
	    
	    By cssUserName = By.cssSelector("input[name=\"loginfmt\"]");
	    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
	    usernameTxt.sendKeys(new CharSequence[] { sUsername});
	    By cssNextBtn = By.cssSelector("input[id=\"idSIButton9\"]");
	    WebElement nextBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextBtn));
	    nextBtn.click();
	    wait = (new FluentWait(gdriver))
	      .withTimeout(1L, TimeUnit.MINUTES)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    
	    
	    By cssPassword = By.cssSelector("input[name=\"passwd\"]");
	    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
	    password.sendKeys(new CharSequence[] { sPassword });
	    By cssNextPwdBtn = By.cssSelector("input[id=\"idSIButton9\"]");
	    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
	    nextPwdBtn.click();
	    wait = (new FluentWait(gdriver))
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
	  
  
  
  public static void pbiRefresh( String sGroupName, String sDataSetID) {
	  if (sGroupName==null) sGroupName="me";
	  String sURL = "https://app.powerbi.com/groups/"+sGroupName+"/list/dataflows";
      gdriver.get(sURL);
      String sContent = gdriver.getPageSource();
	    FluentWait<WebDriver> wait = (new FluentWait(gdriver))
	      .withTimeout(1L, TimeUnit.SECONDS)
	      .pollingEvery(1L, TimeUnit.SECONDS)
	      .ignoring(NoSuchElementException.class);
	    Robot robot;
	    
	   
	    	//2d5da45a-916f-443f-9f5e-1f92c73ec46a
	    	
	    	try {
	    	    By cssdataset = By.cssSelector("a[href=\"/groups/"+sGroupName+"/datasets/"+sDataSetID+"/details\"]");
	    	    WebElement linkDataSet= (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssdataset));
	    	    
	    	    Actions builder = new Actions(gdriver);
	            Action mouseOverHome = builder
	                    .moveToElement(linkDataSet)
	                    .build();
	                 
	            mouseOverHome.perform();    
	            
	    	    wait = (new FluentWait(gdriver))
	    	      .withTimeout(1L, TimeUnit.MINUTES)
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
	    By cssRefresh = By.cssSelector("button[title=\"Refresh now\"]");
	    WebElement btnRefresh = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssRefresh));
	    btnRefresh.click();
	    System.out.println("Refresh button clicked");
	    wait = (new FluentWait(gdriver))
	      .withTimeout(1L, TimeUnit.MINUTES)
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
		 * FluentWait(gdriver)) .withTimeout(10L, TimeUnit.SECONDS) .pollingEvery(1L,
		 * TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		 * 
		 * 
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
    	
    	
    	
		
	    
	  }
  
 private static String getFirstDateofTheMonth(String sFromDate, int iYear, int iMonth, int iWeeks, int iDays) {
	 String rslt="";
	 try{
	 if (sFromDate==null) {
		 sFromDate=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	 }
	  LocalDate convertedDate = LocalDate.parse(sFromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	  if (iYear!=0) {
		  convertedDate=convertedDate.plusYears(iYear);
	  }
	  if (iMonth!=0) {
		  convertedDate=convertedDate.plusMonths(iMonth);
	  }
	  if (iWeeks!=0) {
		  convertedDate=convertedDate.plusWeeks(iWeeks);
	  }
	  if (iDays!=0) {
		  convertedDate=convertedDate.plusDays(iDays);
	  }
	  convertedDate = convertedDate.withDayOfMonth(1);
	  
	  rslt=convertedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	  
	 } catch (Exception e) {
		 System.out.println(e.getLocalizedMessage());
	 }
	  
	  return rslt;
  }
  
  private static String getLastDateofTheMonth(String sDate) {
	  
	  LocalDate convertedDate = LocalDate.parse(sDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	  convertedDate = convertedDate.withDayOfMonth(
	                                  convertedDate.getMonth().length(convertedDate.isLeapYear()));
	  
	  return convertedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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
  
  
  
  public static void processFile(String sFilename) {
	  File dir = new File("C:\\ppms\\download\\SAP");
	  //boolean isFound=false;
      
	     
      FluentWait<WebDriver> wait = new FluentWait<WebDriver>(gdriver);
    	        wait.pollingEvery(5, TimeUnit.SECONDS);
    	        wait.withTimeout(60, TimeUnit.MINUTES);
    	        wait.until(x -> {
    	            File[] filesInDir = dir.listFiles();
    	            for (File fileInDir : filesInDir) {
    	                if (fileInDir.getName().endsWith(sFilename)) {
    	                	System.out.println("File Downloaded");	
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
    	            //insert gFDownloadFile To DB
    	            insertNewFielToDB("SAP",gFDownloaded.getPath());
    	}
    	
    	
  }
  
  
 
  public static void sapProcurementOrderList() {
	  
	  //By.cssSelector("input[id=\"incident.number\"]");
	  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
	  
	  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
	  
	 String sURLBase="https://glcadsvgtpcen.gd.didata.local/sap/bc/nwbc/?sap-client=500&sap-language=EN&sap-theme=SAP_CORBU&sap-nwbc-node=0000000050";
	  
	  String sFromDate="01.04.2021";
	  String sToDate="03.04.2021";
	
	  int iTotalMonths=-1;
	  
	 
	  
		By cssTemp = null;
	    WebElement webTemp = null;
	    
	    boolean isUpdate=false;
	    boolean isAging=false;
	    boolean isAutoCloseFail=false;
	    	
	    
	    ArrayList<String> tabs=null;
	    
	    By cssSaveBtn = null;
      	  WebElement saveBtn =null;
      	 String sContent = null;
      	  
      try {
    	  
          gdriver.get(sURLBase);
          try {
  	        Thread.sleep(10000L);
  	      isUpdate=true;
  	      } catch (InterruptedException e) {
  	        e.printStackTrace();
  	      } 
         
          FluentWait<WebDriver> wait = (new FluentWait(gdriver))
            .withTimeout(30L, TimeUnit.SECONDS)
            .pollingEvery(1L, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
         
          
          int size = gdriver.findElements(By.tagName("iframe")).size();
          
          gdriver.switchTo().frame(size-1);
          
          int size2 = gdriver.findElements(By.tagName("iframe")).size();
          
          if (size2>0) gdriver.switchTo().frame(0);
          
          //Init
         // By css = By.cssSelector("input[id=\"M0\\:46\\:\\:\\:48\\:34\"]");
         // By css = By.cssSelector("input[id=\"M0:46:::48:34\"]");
          //WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
          sContent = gdriver.getPageSource();
          Document doc = null;
          doc = Jsoup.parse(sContent);
          
          //update class       	    	

		    By csscheckbox = By.cssSelector("span[id=\"M0:46:::61:2\"]");
		    WebElement btncheckbox = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(csscheckbox));
		    btncheckbox.click();
          
         
          
          try {
        	  
        	for (int j=0; j>iTotalMonths; j--) {  
        	  //Repeat
        		  sContent = gdriver.getPageSource();
                  
                  doc = Jsoup.parse(sContent);
        		sFromDate=getFirstDateofTheMonth(null,0,j,0,0);
        		sToDate=getLastDateofTheMonth(sFromDate);
          	
        	  
        	  String sFileNameDefault=generateRandomStringByUUIDNoDash()+"-"+sFromDate+"-"+sToDate+".xlsx";
        	  
        	  //From Date sCurrTo
      	  	cssTemp = By.cssSelector("input[id=\"M0:46:::48:34\"]");
      	  	
      	  	String sCurrFrom = doc.select("input[id=\"M0:46:::48:34\"]").val();
    	    	if (!sCurrFrom.isEmpty()) {
    	    		webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
    	    		webTemp.clear();
    	    		webTemp.sendKeys(new CharSequence[] { sFromDate });
    	    		
    	    		
    	    	}
    	    	
    	    	
    	    	//To Date
          	  	cssTemp = By.cssSelector("input[id=\"M0:46:::48:59\"]");
          	  	String sCurrTo = doc.select("input[id=\"M0:46:::48:59\"]").val();
        	    	if (!sCurrTo.isEmpty()) {
        	    		webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
        	    		webTemp.clear();
        	    		webTemp.sendKeys(new CharSequence[] { sToDate });
        	    		
        	    	
        	    	}
        	    	
        	    	
        	
        	    
        	    	
        	    //Filename
              	  	cssTemp = By.cssSelector("input[id=\"M0:46:::62:34\"]");
              	  	String sFileName = doc.select("input[id=\"M0:46:::62:34\"]").val();
            	    	
            	    		webTemp = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTemp));
            	    		webTemp.clear();
            	    		webTemp.sendKeys(new CharSequence[] { sFileNameDefault });
            	    		
            	    		
            	    		//Click Execute Button div = M0:37::btn[8]
            	    		 System.out.println("Trying to Click Save Button");
            	    		 By cssExecute = By.cssSelector("div[id=\"M0:37::btn\\[8\\]\"]");
            	 		    WebElement btnExecute= (WebElement)wait.until((Function)ExpectedConditions.elementToBeClickable(cssExecute));
            	 		   btnExecute.click();
            	 		  System.out.println("Clicked Save Button");
							/*
							 * //sendkey F8 Robot robot = new Robot(); //Press key Ctrl+Shift+i
							 * robot.keyPress(KeyEvent.VK_F8);
							 */
            	    		
            	    		 try {
            	    	  	        
            	    	  	      	processFile(sFileNameDefault);
            	    	  	      
            	    	  	      
            	    	  	      
            	    	  	      } catch (Exception e) {
            	    	  	        e.printStackTrace();
            	    	  	      } 
            	    		 

            	    		 //robot.keyPress(KeyEvent.VK_ENTER); 
            	    		 
            	    		 System.out.println("Downloaded for "+sFromDate+" to "+sToDate+". Filename: "+sFileNameDefault);
        	} //end loop
           
          } catch (Exception ec) {
            System.out.println(ec.getMessage());
          } 
          
          
          System.gc();
        } catch (Exception e1) {
          System.out.println(e1.getMessage());
          
        } 
	    
	   
	
	 
	    
	  }
  
  
 public static void Loading(String sSelector) {
	  
	  System.out.print("Loading : ");
	  FluentWait<WebDriver> wait = (new FluentWait(gdriver))
       	      .withTimeout(5L, TimeUnit.SECONDS)
       	      .pollingEvery(1L, TimeUnit.SECONDS)
       	      .ignoring(NoSuchElementException.class);
	    boolean isWaiting=true;
	    while (isWaiting) {
	    	try {
	    		pause(5);
	    		wait = (new FluentWait(gdriver))
	    	    	      .withTimeout(5L, TimeUnit.SECONDS)
	    	    	      .pollingEvery(1L, TimeUnit.SECONDS)
	    	    	      .ignoring(NoSuchElementException.class);
	    	By cssWait = By.cssSelector(sSelector);
	    	WebElement spanWait = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssWait));
	    	System.out.print(".");	    	
	    	} catch (Exception e) {
	    		System.out.println("Loaded");
	    		isWaiting=false;
	    	}
	    } 
	    wait = null;	  	    
	    
  }
  
  public static boolean sapFAGLL03(String sMenuElement, 
		    String sFiscalYear,
		    String sFromPeriod,
		    String sToPeriod,
		    String sCompanyCode,
		    String sPCMenu) {
		  
		  //By.cssSelector("input[id=\"incident.number\"]");
		  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
		  
		  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
		
		boolean rslt=false;
		  
		 String sURLBase="https://glcadsvgtpcen.gd.didata.local/sap/bc/nwbc/?sap-nwbc-node=0000000371";
		  
		 String sReportMenu="FAGLL03";
		 

		
		  int iTotalMonths=-1;
		  
		 
		  
			By cssTemp = null;
		    WebElement webTemp = null;
		    
		    boolean isUpdate=false;
		    boolean isAging=false;
		    boolean isAutoCloseFail=false;
		    	
		    
		    ArrayList<String> tabs=null;
		    
		    By cssSaveBtn = null;
	      	  WebElement saveBtn =null;
	      	 String sContent = null;
	      	  
	      try {
	    	  
	          gdriver.get(sURLBase);
	          try {
	  	        Thread.sleep(10000L);
	  	      isUpdate=true;
	  	      } catch (InterruptedException e) {
	  	        e.printStackTrace();
	  	      } 
	         
	          FluentWait<WebDriver> wait = (new FluentWait(gdriver))
	            .withTimeout(30L, TimeUnit.SECONDS)
	            .pollingEvery(1L, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);
	         
	          
	          int size = gdriver.findElements(By.tagName("iframe")).size();
	          
	          gdriver.switchTo().frame(size-1);
	          
	          int size2 = gdriver.findElements(By.tagName("iframe")).size();
	          
	          if (size2>0) gdriver.switchTo().frame(0);
	          pause(3);
	          //Init
	         // By css = By.cssSelector("input[id=\"M0\\:46\\:\\:\\:48\\:34\"]");
	         // By css = By.cssSelector("input[id=\"M0:46:::48:34\"]");
	          //WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
	          sContent = gdriver.getPageSource();
	          Document doc = null;
	          doc = Jsoup.parse(sContent);
	          
	          //update class       	    	

			    By cssMenu = By.cssSelector("input[id=\"ToolbarOkCode\"]");
			    WebElement webMenu = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssMenu));
			    webMenu.clear();
			    webMenu.sendKeys(new CharSequence[] { sReportMenu });
			    
			    webMenu.sendKeys(Keys.ENTER);
	          
	         
			    pause(3);
			    
			    
			    By cssTextBox = null; 
			    WebElement webTextBox = null;
			    
			    
			    
			    
			    
			    //click multiple button 
			    //M0:46:::1:78
			    sendClick(wait, "div[id=\"M0:46:::1:78\"]");
			    
			    sendClick(wait, "div[id=\"M1:46:1::0:1-title\"]");
			   
			    pause(3);
			    //tbl2[1,2]_c
			    enterText(wait, "input[id*=\"[1,2]_c\"]", "400000");
			    //tbl2[1,3]_c
			    enterText(wait, "input[id*=\"[1,3]_c\"]", "499999");
			    //tbl2[2,2]_c
			    enterText(wait, "input[id*=\"[2,2]_c\"]", "700000");
			    //tbl2[2,3]_c
			    enterText(wait, "input[id*=\"[2,3]_c\"]", "899999");
			    
			    //click thick button
			    //M1:37::btn[0]
			    sendClick(wait, "div[id=\"M1:37::btn[0]\"]");
			    
			    pause(3);
			    //SAPLALDB3000_1-close
			    sendClick(wait, "a[id=\"SAPLALDB3000_1-close\"]");
			    
			    pause(2);
			    
			    //M2:46:::3:6
			    sendClick(wait, "div[id=\"M2:46:::3:6\"]");
			    
			    
			    
			    pause(3);
			    
			   //click date range
			    //#M0\:46\:\:\:18\:4
			    //#M0\:46\:\:\:18\:4 > input
			    //#M0\:46\:\:\:18\:4
			    
			    sendClick(wait, "#M0\\:46\\:\\:\\:18\\:4");
			    //from date M0:46:::19:34
			    enterText(wait, "input[id=\"M0:46:::19:34\"]", "01.04.2021");
			    //to date 
			    enterText(wait, "input[id=\"M0:46:::19:59\"]", "30.04.2021");
			  
			    
			    //Layout as SA-COSTGL
			    //M0:46:::28:34
			    enterText(wait, "input[id=\"M0:46:::27:34\"]", "SA-COSTGL");
			    pause(2);
			    
			    //Generate
			    sendKeys(wait, "input[id=\"M0:46:::27:34\"]", Keys.F8);
			    pause(5);
			   //loading			    
			    //#ur-loading-itm2
			    Loading("#ur-loading-itm2");
			    
			    //Excel
			    //id="M0:46:::0:0_l"
			    sendMultipleKeys(wait, "div[id=\"M0:46:::0:0_l\"]", Keys.SHIFT, Keys.F4);
			    pause(5);
				   //loading			    
				    //#ur-loading-itm2
				    Loading("#ur-loading-itm2");
				    
			    /*
			     * fiscal year = input id="M0:46:::1:34"
	from period = input id="M0:46:::4:34"
	to period   = input id="M0:46:::5:34" 

	selection group... or value(s) = input id="M0:46:::10:34" = SG01
	profit and loss accounts group = input id="M0:46:::11:34"  = IERP
	Balance sheet account group = input id="M0:46:::13:34"  = BSRP
	Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
			     */
			  
				/*
				 * System.out.println("Process File: "); try {
				 * 
				 * sapFinanceActualReadFile sapFile = new sapFinanceActualReadFile();
				 * //processFile(String sYearMonth, String sCompanyCode, String sPCCode) if
				 * (sFromPeriod.length()==1) sFromPeriod="0"+sFromPeriod;
				 * sapFile.processFile(sFiscalYear+"/"+sFromPeriod, sCompanyCode, sPCMenu);
				 * rslt=true;
				 * 
				 * 
				 * } catch (Exception e) { e.printStackTrace(); }
				 */
			    
	          System.gc();
	        } catch (Exception e1) {
	          System.out.println(e1.getMessage());
	          
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
  
  public static void enterText(FluentWait<WebDriver> wait, String sCSS, String sValue) {
	  
	  By cssTextBox = null; 
	    WebElement webTextBox = null; 
	    /*
	     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
	     */

	    
	    
	    //fiscal year
	    cssTextBox = By.cssSelector(sCSS);
	    webTextBox = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTextBox));
	    webTextBox.clear();
	    webTextBox.sendKeys(new CharSequence[] { sValue });
  }
  
public static void gotoElementAndSelect(FluentWait<WebDriver> wait, RemoteWebDriver tmpDriver, String sCSS) {
	  
	 
	    WebElement webTextBox = null; 
	    /*
	     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
	     */
	
	 String sID="";
	    boolean isFound=false;
	    System.out.print("Searching for "+sCSS+" ");
	    while(!isFound) {
		    try {
		      //div[id="screenarea-scrollV-Nxt"]
		 //userarealist0-scrollV-hdl
		    	//sendClick(wait, "div[id=\"screenarea-scrollV-Nxt\"]");
		    	sendClick(wait, "div[id=\"userarealist0-scrollV-Nxt\"]");
		    	 //sendKeys(wait, "div[id=\"M1:46:::1:1_l\"]", Keys.PAGE_DOWN);
		       webTextBox = tmpDriver.findElementByXPath(sCSS);
		       isFound=true;sID= webTextBox.getAttribute("id");
		       System.out.print("Found - ID:"+sID);
		       
		       String[] aID=sID.split(":");
		       String iID= aID[aID.length-2];
		       try {
		    	   int id= Integer.parseInt(iID);
		    	   id--;
		    	   sID=sID.replaceAll(iID, id+"");
		       } catch (Exception e1) {
		    	   
		       }
		       
		       sendClick(wait, "div[id=\""+sID+"\"]");
		       pause(1);
		    } catch (Exception e) {
		    	System.out.print(".");
		    }
	    }
	    
	    try {
	    	sendKeys(wait, "div[id=\""+sID+"\"]", Keys.F2);
	    } catch (Exception e) {
	    	System.out.println("Error while select (F2) :"+e.getMessage());
	    }
	   
  }
  
  public static void sendKeys(FluentWait<WebDriver> wait, String sCSS,Keys tmpKeys) {
	  
	  By cssTextBox = null; 
	    WebElement webTextBox = null; 
	    /*
	     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
	     */

	    
	    
	    //fiscal year
	    cssTextBox = By.cssSelector(sCSS);
	    webTextBox = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTextBox));	    
	    webTextBox.sendKeys(tmpKeys);
  }
  
  
public static void sendMultipleKeys(FluentWait<WebDriver> wait, String sCSS,Keys tmpKeys1,Keys tmpKeys2,Keys tmpKeys3) {
	  
	  By cssTextBox = null; 
	    WebElement webTextBox = null; 
	    /*
	     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
	     */

	    
	    
	    //fiscal year
	    cssTextBox = By.cssSelector(sCSS);
	    webTextBox = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTextBox));	
	    if (tmpKeys3!=null) {
	    	webTextBox.sendKeys(tmpKeys1 , tmpKeys2 , tmpKeys3);
	    } else {
	    	webTextBox.sendKeys(tmpKeys1 , tmpKeys2);
	    }
  }
  

public static void sendMultipleKeys(FluentWait<WebDriver> wait, String sCSS,Keys tmpKeys1,Keys tmpKeys2) {
	sendMultipleKeys(wait,  sCSS, tmpKeys1, tmpKeys2, null) ;
}
  
public static void sendClick(FluentWait<WebDriver> wait, String sCSS) {
	  
	  By cssTextBox = null; 
	    WebElement webTextBox = null; 
	    /*
	     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
	     */

	    
	    
	    //fiscal year
	    cssTextBox = By.cssSelector(sCSS);
	    webTextBox = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssTextBox));	    
	    webTextBox.click();
  }


public static void sendClickXPath(FluentWait<WebDriver> wait, String sCSS) {
	  
	  By cssTextBox = null; 
	    WebElement webTextBox = null; 
	    /*
	     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
	     */

	    
	  
	    //fiscal year
	    cssTextBox = By.cssSelector(sCSS);
	    webTextBox = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(sCSS)));	    
	    webTextBox.click();
}
  
public static boolean sapActualExpenses(String sMenuElement, 
	    String sFiscalYear,
	    String sFromPeriod,
	    String sToPeriod,
	    String sCompanyCode,
	    String sPCMenu) {
	  
	  //By.cssSelector("input[id=\"incident.number\"]");
	  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
	  
	  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
	
	boolean rslt=false;
	  
	 String sURLBase="https://glcadsvgtpcen.gd.didata.local/sap/bc/nwbc/?sap-client=500&sap-language=EN&sap-theme=sap_corbu&sap-nwbc-node=0000000371";
	  
	 String sReportMenu="Y_GTD_64000015";
	 

	
	  int iTotalMonths=-1;
	  
	 
	  
		By cssTemp = null;
	    WebElement webTemp = null;
	    
	    boolean isUpdate=false;
	    boolean isAging=false;
	    boolean isAutoCloseFail=false;
	    	
	    
	    ArrayList<String> tabs=null;
	    
	    By cssSaveBtn = null;
      	  WebElement saveBtn =null;
      	 String sContent = null;
      	  
      try {
    	  
          gdriver.get(sURLBase);
          try {
  	        Thread.sleep(10000L);
  	      isUpdate=true;
  	      } catch (InterruptedException e) {
  	        e.printStackTrace();
  	      } 
         
          FluentWait<WebDriver> wait = (new FluentWait(gdriver))
            .withTimeout(30L, TimeUnit.SECONDS)
            .pollingEvery(1L, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
         
          
          int size = gdriver.findElements(By.tagName("iframe")).size();
          
          gdriver.switchTo().frame(size-1);
          
          int size2 = gdriver.findElements(By.tagName("iframe")).size();
          
          if (size2>0) gdriver.switchTo().frame(0);
          pause(3);
          //Init
         // By css = By.cssSelector("input[id=\"M0\\:46\\:\\:\\:48\\:34\"]");
         // By css = By.cssSelector("input[id=\"M0:46:::48:34\"]");
          //WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
          sContent = gdriver.getPageSource();
          Document doc = null;
          doc = Jsoup.parse(sContent);
          
          //update class       	    	

		    By cssMenu = By.cssSelector("input[id=\"ToolbarOkCode\"]");
		    WebElement webMenu = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssMenu));
		    webMenu.clear();
		    webMenu.sendKeys(new CharSequence[] { sReportMenu });
		    
		    webMenu.sendKeys(Keys.ENTER);
          
         
		    pause(3);
		    
		    
		    By cssTextBox = null; 
		    WebElement webTextBox = null; 
		    /*
		     * fiscal year = input id="M0:46:::1:34"
from period = input id="M0:46:::4:34"
to period   = input id="M0:46:::5:34" 

selection group... or value(s) = input id="M0:46:::10:34" = SG01
profit and loss accounts group = input id="M0:46:::11:34"  = IERP
Balance sheet account group = input id="M0:46:::13:34"  = BSRP
Profit Center Group = input id="M0:46:::15:34"   = PC_APSG
		     */
		    
		    //String sFiscalYear = "2022";
		    //String sFromPeriod = "1";
		    //String sToPeriod = "2";
		    //String sCompanyCode ="SG01";
		    String sProfitAccountGroup ="IERP";
		    String sBalanceAccountGroup ="BSRP";
		    String sProfitCenterGroup ="PC_APSG";
		    
		    
		    //fiscal year
		    enterText(wait, "input[id=\"M0:46:::1:34\"]", sFiscalYear);
		    enterText(wait, "input[id=\"M0:46:::4:34\"]", sFromPeriod);
		    enterText(wait, "input[id=\"M0:46:::5:34\"]", sToPeriod);
		    enterText(wait, "input[id=\"M0:46:::10:34\"]", sCompanyCode);
		    enterText(wait, "input[id=\"M0:46:::11:34\"]", sProfitAccountGroup);
		    enterText(wait, "input[id=\"M0:46:::13:34\"]", sBalanceAccountGroup);
		    enterText(wait, "input[id=\"M0:46:::15:34\"]", sProfitCenterGroup);
		    
		    sendKeys(wait, "input[id=\"M0:46:::15:34\"]", Keys.F8);
		    
		    pause(10);
		    
		    //"span[id=\"tree#106#10#1#COL1#i\"]"
		    String[] aMenuElement = sMenuElement.split("\\|");
		    if (aMenuElement.length>1) {
		    	int iTmp= aMenuElement.length;
		    	for (int i=0;i<iTmp;i++) {
		    		sendClick(wait, aMenuElement[i]);	
		    		pause(2);
		    	}
		    	
		    } else {
		    	sendClick(wait, sMenuElement);
		    	pause(2);
		    }
		    //sendClickXPath(wait, sMenuElement);
		    
		    
		    //hide menu Ctrl+Shift+F10
		    sendClick(wait, "div[id=\"M0:37::btn[46]\"]");
		    //scrollpage
		    //*****  Profit Before Interest & Tax  
		    gotoElementAndSelect(wait, gdriver, "//div[contains(text(),'Profit Before Interest & Tax')]");
		
		    //chose
		  //id="M1:46:::1:1_l"
		    sendClick(wait, "div[id=\"M1:46:::1:1_l\"]");
		    sendKeys(wait, "div[id=\"M1:46:::1:1_l\"]", Keys.F2);
		    
		    
		    //G/L Account Line Item Display G/L View

		    boolean isFound=false;
		    System.out.print("Loading ");
		    int iLoading=0;
		    while(!isFound) {
			    try {
			      //div[id="screenarea-scrollV-Nxt"]
			 
			    	sendClick(wait, "div[id=\"userarealist0-scrollV-Nxt\"]");
			    	
			       webTextBox = gdriver.findElementByXPath("//div[contains(text(),'G/L Account Line Item Display G/L View')]");
			       isFound=true;String sID= webTextBox.getAttribute("id");
			       System.out.print("Found - ID:"+sID);
			       
			       
			    } catch (Exception e) {
			    	System.out.print(".");
			    	iLoading++;
			    }
		    }
		    
		    
		    pause(5);
		    sendMultipleKeys(wait, "div[id=\"M0:46:::0:0_l\"]", Keys.SHIFT, Keys.F4);
		    pause(iLoading*10);
          
		    System.out.println("Process File: ");
		    try {
	  	        
	  	      	sapFinanceActualReadFile sapFile = new sapFinanceActualReadFile();
	  	      	//processFile(String sYearMonth, String sCompanyCode, String sPCCode)
	  	      	if (sFromPeriod.length()==1) sFromPeriod="0"+sFromPeriod;
	  	      sapFile.processFile(sFiscalYear+"/"+sFromPeriod, sCompanyCode, sPCMenu);
	  	      rslt=true;
	  	      
	  	      
	  	      } catch (Exception e) {
	  	        e.printStackTrace();
	  	      } 
		    
          System.gc();
        } catch (Exception e1) {
          System.out.println(e1.getMessage());
          
        } 
	    
	   
	return rslt;
	 
	    
	  }
  
  
 public static void snowCloseTicketRequest( String sTicketNumber) {
	  
	  //By.cssSelector("input[id=\"incident.number\"]");
	  //Requestor="SCOM Alerts Direct" - b56d81de6f6c2e4427ae51dc5d3ee44f id=incident.u_caller
	  
	  //Affected id=sys_display.incident.u_requested_for id=incident.u_requested_for value=b56d81de6f6c2e4427ae51dc5d3ee44f
	  
	 String sURLBase="https://dimensiondataservices.service-now.com/";
	  
	  String sRequestor="SCOM Alerts Direct";
	  String sClassification= "MHIS";
	  String currStatus="0";
	  
	 
	  String sDefaultResolutionCode="7b78ad2fdb3a84544a5e56915b961984";
	  String sDefaultClosureDetails="Auto Closure by RPA";
	  String sDefaultResolvedBy="NTTCMS";
	  
	  String sDefaultRC="76d8ed23db7a84544a5e56915b961975";
	  String sDefaultRCComments="Auto Closure by RPA";
	  String sDefaultBCComments="Auto Closure by RPA";
	  
	  
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
        				sDefaultResolvedBy="Purnama Sidhi";
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
			    		  
			    		  if (intervalDays >7) {
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
      	    	      	  
	      	   	if (cssCurrStatus.equals("6")) {
	      	   		
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
	      	      isUpdate=true;
	      	      System.out.println(sTix+": Set ticket to CLOSED.");
	      	   	}
	      	  	
      	    	
	      	   	
		      	   	if (  isUpdate) {
			      	  	//button id="sysverb_update_and_stay"
				      	   cssSaveBtn = By.cssSelector("button[id=\"sysverb_update_and_stay\"]");
				      	   saveBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssSaveBtn));
				      	  saveBtn.click();
				      	  wait = (new FluentWait(gdriver))
					  	      .withTimeout(1L, TimeUnit.MINUTES)
					  	      .pollingEvery(1L, TimeUnit.SECONDS)
					  	      .ignoring(NoSuchElementException.class);
			      	      System.out.println(sTix+": Update Done");
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
 
 public static void initProperties() {
	 CodeSource codeSource = sap.class.getProtectionDomain().getCodeSource();
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
	  
 
 public static void insertNewFielToDB(String sModuleName,String sFileName) {
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    PreparedStatement preparedStmt = null;
	    String sStmt=null;
	    try {
	    	
	      String sUpdate = "";
	      sUpdate = "insert into `downloadFile` (`modulename`,`filelocation`,`status`) values (?,?,?)";
	      preparedStmt = (PreparedStatement)conn.prepareStatement(sUpdate);
	      preparedStmt.setString(1,sModuleName);
	      preparedStmt.setString(2,sFileName);
	      preparedStmt.setString(3,"new");
	        
	        
	        
	        sStmt= preparedStmt.toString();
	        preparedStmt.executeUpdate();
	        preparedStmt.close();        
	      
	    
	     
	      
	      conn.close();
	    } catch (Exception e) {
	      System.out.println(e.getMessage()+" Error ="+sStmt);
	    } 
	  }
  
 
 public static void generateSAPActualReport(String sFiscalYear,String sFromPeriod,String sToPeriod,String sCompanyCode){
	 
	 
	 System.out.println("==== START - GENERATING SAP ACTUAL REPORT: "+sCompanyCode+" for "+sFiscalYear+" from: "+sFromPeriod+" to: "+sToPeriod+" ====");
	 
	     
	 boolean rslt=false;
	 int iMaxTries=10;
	 int iCounter=0;
	 
	 
	 //Shared Services - tree#106#7#1#COL1#i - tree#106#8#1#COL2#i
	 System.out.println("==== START - SG01SH ====");
	 rslt=false;iCounter=0;	
	while (!rslt) { 
		iCounter++;
		rslt=sapActualExpenses("#tree\\#106\\#7\\#1 > table > tbody > tr > td.lsSTHierarchicalSpace > span|span[id=\"tree#106#8#1#COL2#i\"]",
 			sFiscalYear,sFromPeriod,sToPeriod,sCompanyCode, "SG01SH");   	
		if (rslt) {
			break;
		} else {
			if (iCounter>iMaxTries) {
				System.out.println("==== REACHED MAXIMUM TRIES #"+iCounter+"/ "+iMaxTries+" - SG01SH ====");
				break;
			} System.out.println("==== RETRY#"+iCounter+" - SG01SH ====");
		}
	}
	System.out.println("==== END - SG01SH ===");
	
	 
 	//Core Business Support - tree#106#8#1#COL2#i - tree#106#9#1#COL2#i tree#114#9#1#COL2#i    	
 	System.out.println("==== START - SG01SBS800 ====");
	 rslt=false;iCounter=0;
 	while (!rslt) { 
		iCounter++;
		rslt=sapActualExpenses("#tree\\#106\\#8\\#1 > table > tbody > tr > td.lsSTHierarchicalSpace > span|span[id=\"tree#106#9#1#COL2#i\"]",
 			sFiscalYear,sFromPeriod,sToPeriod,sCompanyCode,"SG01SBS800");
		if (rslt) {
			break;
		} else {
			if (iCounter>iMaxTries) {
				System.out.println("==== REACHED MAXIMUM TRIES #"+iCounter+"/ "+iMaxTries+" - SG01SBS800 ====");
				break;
			} System.out.println("==== RETRY#"+iCounter+" - SG01SBS800 ====");
		}
 	}
 	System.out.println("==== END - SG01SBS800 ====");
 	
 	//TPS Business Support - tree#106#22#1#COL2#i - tree#106#23#1#COL2#i    	
 	System.out.println("==== START - SG01PBS ====");
 	 rslt=false;iCounter=0; 	
 	while (!rslt) { 
		iCounter++;
		rslt=sapActualExpenses("span[id=\"tree#106#10#1#COL1#i\"]",
 			sFiscalYear,sFromPeriod,sToPeriod,sCompanyCode,"SG01PBS");
		if (rslt) {
			break;
		} else {
			if (iCounter>iMaxTries) {
				System.out.println("==== REACHED MAXIMUM TRIES #"+iCounter+"/ "+iMaxTries+" - SG01PBS ====");
				break;
			} else System.out.println("==== RETRY#"+iCounter+" - SG01PBS ====");
		}
 	}
 	System.out.println("==== END - SG01PBS ====");
 	
 	
 	System.out.println("==== END - GENERATING SAP ACTUAL REPORT: "+sCompanyCode+" for "+sFiscalYear+" from: "+sFromPeriod+" to: "+sToPeriod+" ====");
 	
 }
 
 public static String getFiscalCalendar(String sMode) {
	 String rslt="1";
	 String sDay="1";
	 String sMonth="1";
	 String sYear="2022";
	
	sYear=LocalDate.now().minus(Period.ofDays(1)).format(DateTimeFormatter.ofPattern("yyyy"));
	sMonth=LocalDate.now().minus(Period.ofDays(1)).format(DateTimeFormatter.ofPattern("MM"));
	sDay=LocalDate.now().minus(Period.ofDays(1)).format(DateTimeFormatter.ofPattern("dd"));
	
	sYear = (Integer.parseInt(sYear)+1)+"";
	if (sMonth.equals("01")|| sMonth.equals("02") ||sMonth.equals("03")) {
		sYear = (Integer.parseInt(sYear)-1)+"";
		sMonth=(Integer.parseInt(sMonth)+9)+"";	
		
	} else {
		sMonth=(Integer.parseInt(sMonth)-3)+"";			
	} 		 
	
	if (sMode.equals("year")) {
		rslt=sYear;
	} else if (sMode.equals("month")) {
		rslt=sMonth;
	} 
		
	 return rslt;
 }
 
 
 
  public static void main(String[] args) {
    try {
    	gSession = generateRandomStringByUUIDNoDash();
    	
    	gDBName="sap";    
    	
    	String sMode="material";
    	if (args!=null) {
    		if (args.length>0) {
    			sMode=args[0];    			
    		}
    	}
    	
    	
    
    	//System.out.println(getLastDateofTheMonth("2021-04-03"));
    	//System.out.println(getFirstDateofTheMonth("2021-04-03",0,-6,0,0));
    	
    	//System.exit(0);
    	initDriverSAP();
    	
    	
    	//sapFAGLL03("","","","","","");
    	//System.exit(0);
    	
    	
    	if (sMode.equals("actual")) {
    		System.out.println("=== START ACTUAL MODE ===");
		    String sFiscalYear = getFiscalCalendar("year");
		    String sFromPeriod = getFiscalCalendar("month");
		    sFromPeriod="3";
		    String sToPeriod = sFromPeriod;
		    /*
		    if (sFromPeriod.equals("1")) {
		    	
		    } else {
		    	sFromPeriod= (Integer.parseInt(sFromPeriod)-1)+"";
		    }
		    */
		    
		    String sCompanyCode ="SG01";
		    String sPCMenu="";
		    
		    /*
		    int iYearStart=2018;
		    int iYearEnd=2020;
		    
		    for (int i=iYearEnd; i>=iYearStart; i--) {
		    
		    	for (int j=12; j>=1; j--) {
		    		
		    		sFiscalYear=i+"";
		    		sFromPeriod=j+"";
		    		sToPeriod=sFromPeriod;
		    		
		    		generateSAPActualReport( sFiscalYear, sFromPeriod, sToPeriod, sCompanyCode);
			    	
		    	}
		    }
		    */
		    generateSAPActualReport( sFiscalYear, sFromPeriod, sToPeriod, sCompanyCode);
		    System.out.println("=== END ACTUAL MODE ===");
    	}
    	
    	if (sMode.equals("material")) {
    		System.out.println("=== START MATERIAL MODE ===");
    		sapProcurementOrderList();
    		System.out.println("=== END MATERIAL MODE ===");
    	}
    	
    	
    	
    	
    	
    	
    	
    } catch (Exception e) {
    	System.out.println("Error: "+e.getMessage());
    } finally {
      gdriver.close();
      gdriver.quit();
      System.exit(0);
    } 
  }
}
