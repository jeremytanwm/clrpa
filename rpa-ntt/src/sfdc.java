import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import org.json.JSONObject;

public class sfdc {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String grid = "";
  
  public static String gsno = "";
  
  public static RemoteWebDriver gdriver = null;
  
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
  
  public static void initDriver() {
    gdriver = getDriver();
  }
  
  public static void initDriverSFDC() {
    gdriver = getDriverSFDC();
    FluentWait<WebDriver> wait = (new FluentWait(gdriver))
      .withTimeout(5L, TimeUnit.SECONDS)
      .pollingEvery(1L, TimeUnit.SECONDS)
      .ignoring(NoSuchElementException.class);
    By cssBtn = By.cssSelector("button[class=\"button mb24 secondary wide\"]");
    WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssBtn));
    btnLogin.click();
    wait = (new FluentWait(gdriver))
      .withTimeout(5L, TimeUnit.MINUTES)
      .pollingEvery(1L, TimeUnit.SECONDS)
      .ignoring(NoSuchElementException.class);
    By cssUserName = By.cssSelector("input[name=\"loginfmt\"]");
    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
    usernameTxt.sendKeys(new CharSequence[] { "ley-ying.wat@global.ntt.lightning" });
    By cssNextBtn = By.cssSelector("input[id=\"idSIButton9\"]");
    WebElement nextBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextBtn));
    nextBtn.click();
    wait = (new FluentWait(gdriver))
      .withTimeout(5L, TimeUnit.MINUTES)
      .pollingEvery(1L, TimeUnit.SECONDS)
      .ignoring(NoSuchElementException.class);
    By cssPassword = By.cssSelector("input[name=\"passwd\"]");
    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
    password.sendKeys(new CharSequence[] { "NTTP@55w0rd" });
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
  
  public static RemoteWebDriver getDriver() {
    try {
      gdriver.close();
      gdriver.quit();
    } catch (Exception e) {
      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
    } 
    RemoteWebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    DesiredCapabilities crcapabilities = DesiredCapabilities.chrome();
    try {
   
    options.setExperimentalOption("useAutomationExtension", false);
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    options.addArguments(new String[] { "--headless", "--window-size=1920,1200", "--ignore-certificate-errors" });
    options.addArguments(new String[] { "--ignore-certificate-errors" });
    
    crcapabilities.setCapability("goog:chromeOptions", options);
    crcapabilities.setCapability("acceptSslCerts", true);
    crcapabilities.setCapability("acceptInsecureCerts", true);
    System.setProperty("webdriver.chrome.logfile", "c:\\ppms\\chromedriver.log");
    System.setProperty("webdriver.chrome.driver", "c:\\ppms\\chromedriver.exe");    
    
    } catch (Exception e1) {
        System.out.println("getDriver ERROR: " + e1.getLocalizedMessage());
    } 
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
    driver.get("http://purnama.sidhi:P@ssw0rd@ppms.ap.dimensiondata.com/RP-STS_ISAPI/?wa=wsignin1.0&wtrealm=https%3A%2F%2Fppms.ap.dimensiondata.com%2F&wctx=rm%3D0%26id%3Dpassive%26ru%3D%252F");
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
    String s = browserUrl;
    int loc = s.indexOf("rId=");
    grid = s.substring(loc + 4, loc + 42);
    System.out.println(grid);
    int loc2 = s.indexOf("sno=");
    gsno = s.substring(loc2 + 4, loc2 + 42);
    System.out.println(gsno);
    return driver;
  }
  
  public static RemoteWebDriver getDriverSFDC() {
    try {
      gdriver.close();
      gdriver.quit();
    } catch (Exception e) {
      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
    } 
    RemoteWebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("useAutomationExtension", false);    
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
    driver.get("https://nttlimited.my.salesforce.com");
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
  
  public static void main(String[] args) {
    try {
    	//opportunityCase.dbUpdateIdOpportunity();
    	//System.exit(0);
    	initDriverSFDC();
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
    	
    	sfdcReportOpportunity("00O4G000007qk6Q");
    	sfdcReportOpportunity("00O4G000007qk6L");
    	//sfdcReportOpportunity("00O4G000007bP8U"); //DAILY
    	
    	
    	
    	//Product    	
    	//sfdcReportOpportunityProduct("00O4G000007qk5N");
    	//sfdcReportOpportunityProduct("00O4G000007bPCq"); //Daily 
    	
      System.exit(0);
    } finally {
      gdriver.close();
      gdriver.quit();
    } 
  }
}
