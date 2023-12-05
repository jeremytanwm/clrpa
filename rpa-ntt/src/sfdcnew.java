import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
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
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

public class sfdcnew {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String grid = "";
  
  public static String gsno = "";  
  public static String gSession = "";
  
  
  
  public static File gFDownloaded = null;
  
  public static String gDBName = "sap";
    
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
    //Using Ley Ying account to login, also not click in SSO method
    By cssUserName = By.cssSelector("input[name=\"username\"]");
    WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
    usernameTxt.sendKeys(new CharSequence[] { "ley-ying.wat@global.ntt.lightning" });
    
    By cssPassword = By.cssSelector("input[name=\"pw\"]");
    WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
    password.sendKeys(new CharSequence[] { "NTTP@55w0rd" });
    By cssNextPwdBtn = By.cssSelector("input[name=\"Login\"]");
    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
    nextPwdBtn.click();
    
    /*
    By cssBtn = By.cssSelector("button[class=\"button mb24 secondary wide\"]");
    WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssBtn));
    btnLogin.click();
    wait = (new FluentWait(gdriver))
      .withTimeout(5L, TimeUnit.MINUTES)
      .pollingEvery(1L, TimeUnit.SECONDS)
      .ignoring(NoSuchElementException.class);
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
    password.sendKeys(new CharSequence[] { "Desire8220212" });
    By cssNextPwdBtn = By.cssSelector("input[id=\"idSIButton9\"]");
    WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
    nextPwdBtn.click();
    */
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
	      sURL = "https://nttlimited.my.salesforce.com/" + sReportID;
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
	  
  public static void loadfile(String sFileName, String sMode) {
	    try {    	
	    	 
	    	 Document doc = null;
	         doc = Jsoup.parse(gFDownloaded, "UTF-8");
	         Elements rows = doc.select("tr");
	         int i = 0;
	         ArrayList<String> recordList = new ArrayList<String>();
	         
	         if (sMode.equals("case")) {
	        	 dbSFDCNewOpportunityCase db = new dbSFDCNewOpportunityCase();
	        	
	        	 for (Element tr : rows) {
			         
		             Elements tds = tr.select("td");
		             int index = 1;
		             i++;
		             System.out.print(i+"/"+rows.size()+":");
		             for (Element td : tds) {
			               String sValue = normalize(td.text().trim());
			               switch (index)  {
			              
				               	
				               default:
				                  db.list.add(sValue);
				                   break;
			               } 
			               index++;
		             	} 
		             
		                if (db.list!=null) {
			            	
			            		db.Load();
			            	
			            	
			            	db.list.clear();
			            }
			            
			         
		           
		           
		         	}// end for
		         recordList.clear();
		         recordList=null;
		         
		         db.close();
		         
	         
	         
	         } else if (sMode.equals("team")) {
	        	 dbSFDCNewOpportunityTeam db = new dbSFDCNewOpportunityTeam();
	        	
	        	 for (Element tr : rows) {
			         
		             Elements tds = tr.select("td");
		             int index = 1;
		             i++;
		             System.out.print(i+"/"+rows.size()+":");
		             String sOpportunityID="";
		             for (Element td : tds) {
			               String sValue = normalize(td.text().trim());
			               switch (index)  {
			              
			               		case 2: db.list.add(sValue); sOpportunityID=sValue;
			               			break;
				               default:
				                  db.list.add(sValue);
				                   break;
			               } 
			               index++;
		             	} 
		             
		             if (db.list!=null) {
			            	if (db.list.size()>5) {
			            		db.Load(!recordList.contains(sOpportunityID));
			            	
			            	}
			            	db.list.clear();
			            }
			            
			            if (!recordList.contains(sOpportunityID)) {
			            	recordList.add(sOpportunityID);	         
			            }
		           
			            
			         
		           
		           
		         	}// end for
		         recordList.clear();
		         recordList=null;
		         
		         db.close();
		         
	         
	         
	         } else {
	        	 dbSFDCNewOpportunity db = new dbSFDCNewOpportunity();
	         
	         
			         for (Element tr : rows) {
			          
			             Elements tds = tr.select("td");
			             int index = 1;
			             i++;
			             System.out.print(i+"/"+rows.size()+":");
			             String sRecordID="";
			             for (Element td : tds) {
				               String sValue = normalize(td.text().trim());
				               switch (index)  {
				               	
					               case 1: db.list.add(sValue); sRecordID=sValue;
					               	break;
					               	
					               default:
					                  db.list.add(sValue);
					                   break;
				               } 
				               index++;
			             	} 
			             
			             
				            if (db.list!=null) {
				            	if (db.list.size()==48) {
				            		db.Load(!recordList.contains(sRecordID));
				            	
				            	}
				            	db.list.clear();
				            }
				            
				            if (!recordList.contains(sRecordID)) {
				            	recordList.add(sRecordID);	         
				            }
			           
			           
			         	}// end for
			         recordList.clear();
			         recordList=null;
			         
			         db.close();
			         
	         }
	         System.gc();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	  }
  
  public static void sfdcReport(String sReportID) {
	  sfdcReport("", sReportID);
  }
  
  public static void sfdcReport(String sMode, String sReportID) {
	    String sContent = "";
	    String sURL = "";
	    try {
	    	//https://nttlimited.my.salesforce.com/00O4J000005BizmUAC?isdtp=p1
	    	//https://nttlimited.my.salesforce.com/00O4J000005BizmUAC?isdtp=nv
	    	//https://nttlimited.my.salesforce.com/00O4J000005BizmUAC?isdtp=nv&enc=ISO-8859-1&xf=xls&export=Export
	    	
	    	//DAILY UPDATE - based on last update date
	    	//https://nttlimited.my.salesforce.com/00O4J000005BizmUAC?isdtp=nv&enc=ISO-8859-1&xf=xls&export=Export&quarter_c=LAST_UPDATE&quarter_q=custom&quarter_s=4/1/2000&quarter_e=3/31/2022
	    	//https://nttlimited.my.salesforce.com/00O4J000005BizmUAC?isdtp=nv&enc=ISO-8859-1&xf=localcsv&export=Export&quarter_c=LAST_UPDATE&quarter_q=custom&quarter_s=10/06/2021&quarter_e=16/06/2021
	    	
	    	
	    	//DAILY UPDATE - based on Closed update date
	    	//https://nttlimited.my.salesforce.com/00O4J000005BizmUAC?isdtp=nv&enc=ISO-8859-1&xf=xls&export=Export&quarter_c=CLOSE_DATE&quarter_q=curfy&quarter_s=4/1/2021&quarter_e=3/31/2022
	    	String sFromDate="";
	    	Date dt = new Date();  // current time    	
	    	int hours = dt.getHours();
	    	if (hours==1) {
	    		sFromDate= getSFDCReportDate(null,0, -2, 0,0) ;
	    	} else {
	    		sFromDate= getSFDCReportDate(null,0, 0, 0,-3) ;
	    	}
	    	//sFromDate= getSFDCReportDate(null,-3, 0, 0,0) ;
		
	    	String sToDate= getSFDCReportDate(null,0, 0, 0, 0) ;
	    	
	    	if (sMode.equals("case")) {
	    		//https://nttlimited.my.salesforce.com/00O4J000004nhROUAY?isdtp=nv&enc=ISO-8859-1&xf=xls&export=Export&colDt=LAST_UPDATEONLY&colDt_q=custom&sdate=3/1/2000&edate=12/31/2021	
	    			sURL = "https://nttlimited.my.salesforce.com/" + sReportID +"?isdtp=nv&enc=ISO-8859-1&xf=xls&export=Export&colDt=LAST_UPDATEONLY&colDt_q=custom&sdate="+sFromDate+"&edate="+sToDate;
	    	} else 
	    		sURL = "https://nttlimited.my.salesforce.com/" + sReportID +"?isdtp=nv&enc=ISO-8859-1&xf=xls&export=Export&quarter_c=LAST_UPDATE&quarter_q=custom&quarter_s="+sFromDate+"&quarter_e="+sToDate;
	      
	    	gdriver.get(sURL);
	      Thread.sleep(10000);
	      int count = 1;
	      do {
	      	if (get_downloaded_files((RemoteWebDriver) gdriver).toString().contains("report")){ //Note: multiple file downloads on the same grid node of the same file name will increment the file name like 50MB(2).zip 
	      		System.out.println("FILE DOWNLOADED TO GRID NODE");
	  			break;
	  		} else {
	  			System.out.println("DOWNLOAD PROGRESS: " + get_download_progress_all((RemoteWebDriver) gdriver));	
	  		}
	           count++;
	           Thread.sleep(10000);
	      } while (count < 11);
	      
	      
	      ArrayList downloaded_files_arraylist = get_downloaded_files((RemoteWebDriver) gdriver);
	  
	      
	      if (downloaded_files_arraylist.size()>0) {
	    	 // for (int i=0;i<downloaded_files_arraylist.size();i++) {
		    	  gFDownloaded= new File(downloaded_files_arraylist.get(0).toString());
		    	  System.out.println("Found File: "+gFDownloaded.getName());
		      		loadfile(gFDownloaded.getPath(), sMode);
		      	 
		    	  
		    	  //remove the file after processed
		    	    try {
		        	String sNewFile ="c:\\ppms\\archive\\sfdc\\"+gFDownloaded.getName();
		        	moveFile(gFDownloaded.getPath(), sNewFile);
		        	System.out.println("Moved File: "+gFDownloaded.getName());
		    	    } catch (Exception e) {
		    	    	System.out.println("ERROR: movefile: " + gFDownloaded);
		    		      System.out.println(e.getMessage());
		    	    }
	        	
	    	    
	    	  //}
	    	    
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
      sURL = "https://nttlimited.my.salesforce.com/" + sReportID;
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
  
  public static void moveFile(String fromFile, String toFile) {
		

      Path source = Paths.get(fromFile);
      Path target = Paths.get(toFile);

      try {

          
          Files.move(source, target);

     

      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
  
  
  private static String get_file_content(RemoteWebDriver remoteDriver,String path) {
		String file_content = null;
			try {
				if(!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
				remoteDriver.get("chrome://downloads/");
				}


			    WebElement elem = (WebElement) remoteDriver.executeScript(
					    "var input = window.document.createElement('INPUT'); "+
					    "input.setAttribute('type', 'file'); "+
					    "input.hidden = true; "+
					    "input.onchange = function (e) { e.stopPropagation() }; "+
					    "return window.document.documentElement.appendChild(input); "
					    ,"" );
				
				 elem.sendKeys(path);
			
			 file_content = (String) remoteDriver.executeAsyncScript(
						    "var input = arguments[0], callback = arguments[1]; "+
						    "var reader = new FileReader(); "+
						    "reader.onload = function (ev) { callback(reader.result) }; "+
						    "reader.onerror = function (ex) { callback(ex.message) }; "+
						    "reader.readAsDataURL(input.files[0]); "+
						    "input.remove(); "
						    , elem);
				
				if (!file_content.startsWith("data:")){
					System.out.println("Failed to get file content");
				}
			
			} catch (Exception e) {
				System.err.println(e);
			}
return file_content;

		}

	 
	 
	 private static ArrayList get_downloaded_files(RemoteWebDriver remoteDriver) {
		 ArrayList filesFound = null;
			try {
				//if(!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
				Thread.sleep(10000);
				remoteDriver.get("chrome://downloads/");
				Thread.sleep(10000);
				//}
				filesFound =  (ArrayList)  remoteDriver.executeScript(
				  "return  document.querySelector('downloads-manager')  "+
			      " .shadowRoot.querySelector('#downloadsList')         "+
			      " .items.filter(e => e.state === 'COMPLETE')          "+
			      " .map(e => e.filePath || e.file_path || e.fileUrl || e.file_url); ","");
			} catch (Exception e) {
				System.err.println(e);
			}
			return filesFound;
		}
	 
	 private static String get_download_progress(RemoteWebDriver remoteDriver) {
		 String progress = null;
			try {
				if(!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
				remoteDriver.get("chrome://downloads/");
				}
				progress=  (String) remoteDriver.executeScript(						
						"var tag = document.querySelector('downloads-manager').shadowRoot;"+
					    "var intag = tag.querySelector('downloads-item').shadowRoot;"+
					    "var progress_tag = intag.getElementById('progress');"+
					    "var progress = null;"+
					   " if(progress_tag) { "+
					    "    progress = progress_tag.value; "+
					  "  }" +
					    "return progress;"
						,"");
				
	
			} catch (Exception e) {
				System.err.println(e);
			}
			return progress;
		}

	 
	 
	 
	 private static ArrayList get_download_progress_all(RemoteWebDriver remoteDriver) {
		 ArrayList progress = null;
			try {
				if(!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
				remoteDriver.get("chrome://downloads/");
				}
				progress=  (ArrayList) remoteDriver.executeScript(						
						" var tag = document.querySelector('downloads-manager').shadowRoot;" + 
						"			    var item_tags = tag.querySelectorAll('downloads-item');" + 
						"			    var item_tags_length = item_tags.length;" + 
						"			    var progress_lst = [];" + 
						"			    for(var i=0; i<item_tags_length; i++) {" + 
						"			        var intag = item_tags[i].shadowRoot;" + 
						"			        var progress_tag = intag.getElementById('progress');" + 
						"			        var progress = null;" + 
						"			        if(progress_tag) {" + 
						"			            var progress = progress_tag.value;" + 
						"			        }" + 
						"			        progress_lst.push(progress);" + 
						"			    }" + 
						"			    return progress_lst",
						"");
				
	
			} catch (Exception e) {
				System.err.println(e);
			}
			return progress;
		}	
	


  
  public static RemoteWebDriver getDriverSFDC() {
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
  public static String generateRandomStringByUUID() {
      return UUID.randomUUID().toString();
  }

  public static String generateRandomStringByUUIDNoDash() {
      return UUID.randomUUID().toString().replace("-", "");
  }
  
  
  private static String getSFDCReportDate(String sFromDate, int iYear, int iMonth, int iWeeks, int iDays) {
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
		 
		  
		  rslt=convertedDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		  
		 } catch (Exception e) {
			 System.out.println(e.getLocalizedMessage());
		 }
		  
		  return rslt;
	  }
  public static void main(String[] args) {
    try {
    	gSession = generateRandomStringByUUIDNoDash();
    	
    	gDBName="sfdc";   
    	
    	
    	String sTeam="team";
    	String sOpportunity="";
    	String sCase="case";
    	
    	initDriverSFDC();
    	//sfdcReport(sCase,"00O4J000004nhROUAY"); 
    	//Singapore
    	/*
    	System.out.println("==== SINGAPORE START =========");
    	System.out.println("==== SINGAPORE START - OPPORTUNITY =========");
    	sfdcReport("00O4J000005BizmUAC");    
    	System.out.println("==== SINGAPORE START - OPPORTUNITY TEAM =========");
    	sfdcReport(sTeam,"00O4J000004ncVyUAI");
    	System.exit(0);
    	*/
    	
    	//SG CASE 00O4J000004nhROUAY
    	
    	//opportunityCase.dbUpdateIdOpportunity();
    	//System.exit(0);
    	/*
    	sfdcReport(sCase,"00O4J000004nhROUAY");
    	System.out.println("==== SINGAPORE END =========");
    	System.exit(0);
    	//Singapore
    	System.out.println("==== SINGAPORE START =========");
    	System.out.println("==== SINGAPORE START - OPPORTUNITY =========");
    	sfdcReport(sOpportunity,"00O4J000005BizmUAC");    
    	System.out.println("==== SINGAPORE START - OPPORTUNITY TEAM =========");
    	sfdcReport(sTeam,"00O4J000004ncVyUAI");
    	System.out.println("==== SINGAPORE END =========");
    	System.exit(0);
    	*/
    	
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
    	//DB
    	// Pipeline - 00O4J0000053nkOUAQ
    	// Team - 00O4J0000053o0vUAA
    	
    	System.out.println("==== TE START =========");
    	System.out.println("==== TE START - OPPORTUNITY =========");
    	sfdcReport("00O4J0000053nkOUAQ");    
    	System.out.println("==== TE START - OPPORTUNITY TEAM =========");
    	sfdcReport(sTeam,"00O4J0000053o0vUAA");
    	System.out.println("==== TE END =========");
    	
    	
    	//Singapore
    	System.out.println("==== SINGAPORE START =========");
    	System.out.println("==== SINGAPORE START - OPPORTUNITY =========");
    	sfdcReport("00O4J000005BizmUAC");    
    	System.out.println("==== SINGAPORE START - OPPORTUNITY TEAM =========");
    	sfdcReport(sTeam,"00O4J000004ncVyUAI");
    	System.out.println("==== SINGAPORE START - CASE =========");
    	sfdcReport(sCase,"00O4J000004nhROUAY");    	
    	System.out.println("==== SINGAPORE END =========");
    	
    	
    	//Malaysia
    	System.out.println("==== MALAYSIA START =========");
    	System.out.println("==== MALAYSIA START - OPPORTUNITY =========");
    	sfdcReport("00O4J000004nhQLUAY");
    	System.out.println("==== MALAYSIA START - OPPORTUNITY TEAM =========");
     	sfdcReport(sTeam,"00O4J000004nhQgUAI");
     	System.out.println("==== MALAYSIA END =========");
     	
     	//Vietnam
    	System.out.println("==== VIETNAM START =========");
    	System.out.println("==== VIETNAM START - OPPORTUNITY =========");
    	sfdcReport("00O4J000004nhQVUAY");
    	System.out.println("==== VIETNAM START - OPPORTUNITY TEAM =========");
     	sfdcReport(sTeam,"00O4J000004nhQWUAY");
     	System.out.println("==== VIETNAM END =========");     	
    	//Phillipines
    	System.out.println("==== PHILIPPINES START =========");
    	System.out.println("==== PHILIPPINES START - OPPORTUNITY =========");
    	sfdcReport("00O4J000004ndulUAA");
    	System.out.println("==== PHILIPPINES START - OPPORTUNITY TEAM =========");
     	sfdcReport(sTeam,"00O4J000004ndxQUAQ");
     	System.out.println("==== PHILIPPINES END =========");
     	
    	
     	//Thailand
    	System.out.println("==== THAILAND START =========");
    	System.out.println("==== THAILAND START - OPPORTUNITY =========");
    	sfdcReport("00O4J000004nhQMUAY");
    	System.out.println("==== THAILAND START - OPPORTUNITY TEAM =========");
     	sfdcReport(sTeam,"00O4J000004nhQzUAI");
     	System.out.println("==== THAILAND END =========");
     	
     	//Indonesia
    	System.out.println("==== INDONESIA START =========");
    	System.out.println("==== INDONESIA START - OPPORTUNITY =========");
    	sfdcReport("00O4J000004nhQBUAY");
    	System.out.println("==== INDONESIA START - OPPORTUNITY TEAM =========");
     	sfdcReport(sTeam,"00O4J000004nhQfUAI");
     	System.out.println("==== INDONESIA END =========");
     	
     	
    	
    	//Product    	
    	//sfdcReportOpportunityProduct("00O4G000007qk5N");
    	//sfdcReportOpportunityProduct("00O4G000007bPCq"); //Daily 
    	
     
    } finally {
      gdriver.close();
      gdriver.quit();
    } 
  }
}
