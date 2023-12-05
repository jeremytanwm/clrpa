import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class workday {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String dbName="c1ppms";
  
  public static String grid = "";
  
  public static String gsno = "";
  
  public static RemoteWebDriver gdriver = null;
  
  public static String id = "";
  
  public static String idemployee = "";
  
  public static String idmanager = "";
  
  public static String employeename = "";
  
  public static String ename = "";
  
  public static String position = "";
  
  public static String managername = "";
  
  public static String manageremail = "";
  
  public static String mobilenumber = "";
  
  public static String email = "";
  
  public static String createdon = "";
  
  public static String updatedon = "";
  
  public static String getDbusername() {
    return dbusername;
  }
  
  public static void setDbusername(String dbusername) {
    workday.dbusername = dbusername;
  }
  
  public static String getDbpassword() {
    return dbpassword;
  }
  
  public static void setDbpassword(String dbpassword) {
    workday.dbpassword = dbpassword;
  }
  
  public static String getGrid() {
    return grid;
  }
  
  public static void setGrid(String grid) {
    workday.grid = grid;
  }
  
  public static String getGsno() {
    return gsno;
  }
  
  public static void setGsno(String gsno) {
    workday.gsno = gsno;
  }
  
  public static RemoteWebDriver getGdriver() {
    return gdriver;
  }
  
  public static void setGdriver(RemoteWebDriver gdriver) {
    workday.gdriver = gdriver;
  }
  
  public static String getId() {
    return id;
  }
  
  public static void setId(String id) {
    workday.id = id;
  }
  
  public static String getIdemployee() {
    return idemployee;
  }
  
  public static void setIdemployee(String idemployee) {
    workday.idemployee = idemployee;
  }
  
  public static String getIdmanager() {
    return idmanager;
  }
  
  public static void setIdmanager(String idmanager) {
    workday.idmanager = idmanager;
  }
  
  public static String getEmployeename() {
    return employeename;
  }
  
  public static void setEmployeename(String employeename) {
    workday.employeename = employeename;
  }
  
  public static String getEname() {
    return ename;
  }
  
  public static void setEname(String ename) {
    workday.ename = ename;
  }
  
  public static String getPosition() {
    return position;
  }
  
  public static void setPosition(String position) {
    workday.position = position;
  }
  
  public static String getManagername() {
    return managername;
  }
  
  public static void setManagername(String managername) {
    workday.managername = managername;
  }
  
  public static String getManageremail() {
    return manageremail;
  }
  
  public static void setManageremail(String manageremail) {
    workday.manageremail = manageremail;
  }
  
  public static String getMobilenumber() {
    return mobilenumber;
  }
  
  public static void setMobilenumber(String mobilenumber) {
    workday.mobilenumber = mobilenumber;
  }
  
  public static String getEmail() {
    return email;
  }
  
  public static void setEmail(String email) {
    workday.email = email;
  }
  
  public static String getCreatedon() {
    return createdon;
  }
  
  public static void setCreatedon(String createdon) {
    workday.createdon = createdon;
  }
  
  public static String getUpdatedon() {
    return updatedon;
  }
  
  public static void setUpdatedon(String updatedon) {
    workday.updatedon = updatedon;
  }
  
  public int getIntValue(String str) {
    int irslt = 0;
    try {
      if (str.isEmpty())
        str = "0"; 
      irslt = Integer.parseInt(str);
    } catch (Exception e) {
      irslt = 0;
    } 
    return irslt;
  }
  
  public static String queryIDRecord(String sEmail) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `id` from `workday-employee` where `email`=\"" + sEmail + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String id = "";
      int i = 1;
      if (rs.next()) {
        id = (new StringBuilder(String.valueOf(rs.getInt("id")))).toString();
        sRslt = id;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public void dbUpdateWorkdayEmployee() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryIDRecord(getEmail());
      setId(sID);
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `workday-employee`(`idemployee`, `idmanager`, `employeename`, `ename`, `position`, `managername`, `manageremail`, `mobilenumber`, `email`) VALUES (?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdemployee());
        preparedStmt.setString(2, getIdmanager());
        preparedStmt.setString(3, getEmployeename());
        preparedStmt.setString(4, getEname());
        preparedStmt.setString(5, getPosition());
        preparedStmt.setString(6, getManagername());
        preparedStmt.setString(7, getManageremail());
        preparedStmt.setString(8, getMobilenumber());
        preparedStmt.setString(9, getEmail());
        System.out.println(preparedStmt.toString());
        preparedStmt.execute();
        preparedStmt.close();
      } else {
        sQuery = "UPDATE`workday-employee` SET `idemployee`=?, `idmanager`=?, `employeename`=?, `ename`=?, `position`=?, `managername`=?, `manageremail`=?, `mobilenumber`=?, `email`=?, `updatedon`=?  WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdemployee());
        preparedStmt.setString(2, getIdmanager());
        preparedStmt.setString(3, getEmployeename());
        preparedStmt.setString(4, getEname());
        preparedStmt.setString(5, getPosition());
        preparedStmt.setString(6, getManagername());
        preparedStmt.setString(7, getManageremail());
        preparedStmt.setString(8, getMobilenumber());
        preparedStmt.setString(9, getEmail());
        preparedStmt.setTimestamp(10, updatedAt);
        preparedStmt.setInt(11, getIntValue(sID));
        System.out.println(preparedStmt.toString());
        preparedStmt.execute();
        preparedStmt.close();
      } 
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR:" + sQuery);
      System.out.println("ERROR:" + preparedStmt.toString());
      System.out.println("ERROR:" + e.getMessage());
      try {
        conn.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      } 
    } 
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
  
  public static String TableToJson(String source) throws JSONException {
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
  
  public static void waitForElementTextEqualsString(WebElement element, String expectedString, WebDriver driver, int
		  specifiedTimeout) {
		  WebDriverWait wait = new WebDriverWait(driver, specifiedTimeout);
		  ExpectedCondition<Boolean> elementTextEqualsString = arg0 -> element.getText().equals(expectedString);
		  wait.until(elementTextEqualsString);
		  }
  
  public static void initDriverDirects() {
    gdriver = getDriverWorkday();
    CookiePrintAll();
    System.out.println("Cookies=" + getCookie());
    FluentWait<WebDriver> wait = null;
    try {
      wait = (new FluentWait(gdriver))
        .withTimeout(20L, TimeUnit.SECONDS)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By cssUserName = By.cssSelector("input[name=\"loginfmt\"]");
      WebElement usernameTxt = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssUserName));
      usernameTxt.sendKeys(new CharSequence[] { "purnama.sidhi@global.ntt" });
      By cssNextBtn = By.cssSelector("input[id=\"idSIButton9\"]");
      WebElement nextBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextBtn));
      nextBtn.click();
      wait = (new FluentWait(gdriver))
        .withTimeout(50L, TimeUnit.SECONDS)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By cssPassword = By.cssSelector("input[name=\"passwd\"]");
      WebElement password = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssPassword));
      password.sendKeys(new CharSequence[] { "P@ssw0rd" });
      By cssNextPwdBtn = By.cssSelector("input[id=\"idSIButton9\"]");
      WebElement nextPwdBtn = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssNextPwdBtn));
      nextPwdBtn.click();
    } catch (Exception e) {
      System.out.println("Error waiting");
    } 
    RemoteWebDriver remoteWebDriver = gdriver;
    String browserUrl = (String)remoteWebDriver.executeScript("return window.top.location.href.toString()", new Object[0]);
    System.out.println("Your browser URL is " + browserUrl);
    String s = browserUrl;
    try {
      int loc2 = s.indexOf("SessionID=");
      gsno = s.substring(loc2 + 10, loc2 + 46);
      System.out.println(gsno);
    } catch (Exception e) {
      System.out.println("Failed to get the SessionID");
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
  
  public static void sleep(int secondsToSleep) {
    try {
      TimeUnit.SECONDS.sleep(secondsToSleep);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    } 
  }
  
  public static void CookiePrintAll() {
    Set<Cookie> cookies = gdriver.manage().getCookies();
    System.out.println(cookies);
  }
  
  public static String getCookie(String cookieName) {
    Cookie cookie1 = gdriver.manage().getCookieNamed(cookieName);
    return cookie1.toString();
  }
  
  public static String getCookie() {
    Set<Cookie> cookies = gdriver.manage().getCookies();
    return cookies.toString();
  }
  
  public static String decodeValue(String value) {
    try {
      return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException(ex.getCause());
    } 
  }
  
  public static void parseResponse() {
    parseResponse(sRes);
  }
  
  public static void parseResponse(String response) {
    JSONObject obj = new JSONObject(response);
    String sStatus = (new StringBuilder(String.valueOf(obj.getJSONObject("response").getJSONObject("header").getInt("status")))).toString();
    if (sStatus == null)
      sStatus = "900"; 
    if (sStatus.equals("200")) {
      String sTotalRecord = (new StringBuilder(String.valueOf(obj.getJSONObject("response").getJSONObject("responseDetails").getInt("totalRecords")))).toString();
      System.out.println("Total Record=" + sTotalRecord);
      JSONArray arr = obj.getJSONObject("response").getJSONObject("responseDetails").getJSONArray("items");
      for (int i = 0; i < arr.length(); i++) {
        direct dir = new direct();
        try {
          dir.setRegion(String.valueOf(arr.getJSONObject(i).get("regionname")));
        } catch (Exception exception) {}
        try {
          dir.setDdentity(String.valueOf(arr.getJSONObject(i).get("entityname")));
        } catch (Exception exception) {}
        try {
          dir.setBuyername(String.valueOf(arr.getJSONObject(i).get("buyername_a")));
        } catch (Exception exception) {}
        try {
          dir.setPonumber(String.valueOf(arr.getJSONObject(i).get("docnum")));
        } catch (Exception exception) {}
        try {
          dir.setPodate(String.valueOf(arr.getJSONObject(i).get("docdate")));
        } catch (Exception exception) {}
        try {
          dir.setConfirmationno(String.valueOf(arr.getJSONObject(i).get("confirmationnum")));
        } catch (Exception exception) {}
        try {
          dir.setRequester(String.valueOf(arr.getJSONObject(i).get("creatorname_a")));
        } catch (Exception exception) {}
        try {
          dir.setManufacturer(String.valueOf(arr.getJSONObject(i).get("manufacturer")));
        } catch (Exception exception) {}
        try {
          dir.setMfrpartnumber(String.valueOf(arr.getJSONObject(i).get("mfrpartnum")));
        } catch (Exception exception) {}
        try {
          dir.setItemdescription(String.valueOf(arr.getJSONObject(i).get("name")));
        } catch (Exception exception) {}
        try {
          dir.setPreferredsupplier(String.valueOf(arr.getJSONObject(i).get("preferredsupplier")));
        } catch (Exception exception) {}
        try {
          dir.setStatus(String.valueOf(arr.getJSONObject(i).get("itemstatusname")));
        } catch (Exception exception) {}
        try {
          dir.setQuantity(String.valueOf(arr.getJSONObject(i).get("quantity")));
        } catch (Exception exception) {}
        try {
          dir.setGrosscostusd(String.valueOf(arr.getJSONObject(i).get("grossbuyusd")));
        } catch (Exception exception) {}
        try {
          dir.setGrosstotalusd(String.valueOf(arr.getJSONObject(i).get("grosstotalusd")));
        } catch (Exception exception) {}
        try {
          dir.setSalesoficecode(String.valueOf(arr.getJSONObject(i).get("salesofficecode")));
        } catch (Exception exception) {}
        try {
          dir.setSalesoffice(String.valueOf(arr.getJSONObject(i).get("salesoffice")));
        } catch (Exception exception) {}
        try {
          dir.setOrderreason(String.valueOf(arr.getJSONObject(i).get("orderreason")));
        } catch (Exception exception) {}
        try {
          dir.setOrderreasoncode(String.valueOf(arr.getJSONObject(i).get("orderreasoncode")));
        } catch (Exception exception) {}
        try {
          dir.setSo(String.valueOf(arr.getJSONObject(i).get("sonumber")));
        } catch (Exception exception) {}
        try {
          dir.setQuotename(String.valueOf(arr.getJSONObject(i).get("quotename")));
        } catch (Exception exception) {}
        try {
          dir.setQuoteno(String.valueOf(arr.getJSONObject(i).get("quotenumber")));
        } catch (Exception exception) {}
        try {
          dir.setSfdcno(String.valueOf(arr.getJSONObject(i).get("opptrefnum")));
        } catch (Exception exception) {}
        try {
          dir.setProjectcode(String.valueOf(arr.getJSONObject(i).get("projectcode")));
        } catch (Exception exception) {}
        try {
          dir.setDepartment(String.valueOf(arr.getJSONObject(i).get("department")));
        } catch (Exception exception) {}
        try {
          dir.setGrosscost(String.valueOf(arr.getJSONObject(i).get("totalcost")));
        } catch (Exception exception) {}
        try {
          dir.setGrosstotal(String.valueOf(arr.getJSONObject(i).get("totalsell")));
        } catch (Exception exception) {}
        try {
          dir.setPoreceiveddate(String.valueOf(arr.getJSONObject(i).get("porcvdate")));
        } catch (Exception exception) {}
        try {
          dir.setNeededby(String.valueOf(arr.getJSONObject(i).get("needbydate")));
        } catch (Exception exception) {}
        try {
          dir.setDatecreated(String.valueOf(arr.getJSONObject(i).get("dateentered")));
        } catch (Exception exception) {}
        try {
          dir.setDatesubmitted(String.valueOf(arr.getJSONObject(i).get("datesubmitted")));
        } catch (Exception exception) {}
        try {
          dir.setDatepurchased(String.valueOf(arr.getJSONObject(i).get("datepurchased")));
        } catch (Exception exception) {}
        try {
          dir.setDateaccepted(String.valueOf(arr.getJSONObject(i).get("dateaccepted")));
        } catch (Exception exception) {}
        try {
          dir.setDatemfrscheduled(String.valueOf(arr.getJSONObject(i).get("datemfrsched")));
        } catch (Exception exception) {}
        try {
          dir.setDateshipped(String.valueOf(arr.getJSONObject(i).get("dateship")));
        } catch (Exception exception) {}
        try {
          dir.setDatedelivered(String.valueOf(arr.getJSONObject(i).get("datedeliver")));
        } catch (Exception exception) {}
        try {
          dir.setDateinvoiced(String.valueOf(arr.getJSONObject(i).get("dateinvoice")));
        } catch (Exception exception) {}
        try {
          dir.setBudgetcostusd(String.valueOf(arr.getJSONObject(i).get("budgetbuy")));
        } catch (Exception exception) {}
        try {
          dir.setBudgettotalusd(String.valueOf(arr.getJSONObject(i).get("budgettotal")));
        } catch (Exception exception) {}
        try {
          dir.setDealid(String.valueOf(arr.getJSONObject(i).get("dealId")));
        } catch (Exception exception) {}
        try {
          dir.setDateestimatedship(String.valueOf(arr.getJSONObject(i).get("estshipdate")));
        } catch (Exception exception) {}
        try {
          dir.setDateestimateddelivery(String.valueOf(arr.getJSONObject(i).get("estdeliverdate")));
        } catch (Exception exception) {}
        try {
          dir.setItemcategory(String.valueOf(arr.getJSONObject(i).get("itemcategory")));
        } catch (Exception exception) {}
        try {
          dir.setItemtypename(String.valueOf(arr.getJSONObject(i).get("itemtypename")));
        } catch (Exception exception) {}
        try {
          dir.setPlantname(String.valueOf(arr.getJSONObject(i).get("plantname")));
        } catch (Exception exception) {}
        try {
          dir.setProducttype(String.valueOf(arr.getJSONObject(i).get("producttype")));
        } catch (Exception exception) {}
        try {
          dir.setCategory(String.valueOf(arr.getJSONObject(i).get("unspsc")));
        } catch (Exception exception) {}
        try {
          dir.setListpriceusd(String.valueOf(arr.getJSONObject(i).get("listpriceusd")));
        } catch (Exception exception) {}
        try {
          dir.setQuotedcratedby(String.valueOf(arr.getJSONObject(i).get("qtecreatedby")));
        } catch (Exception exception) {}
        try {
          dir.setRequestoremailaddress(String.valueOf(arr.getJSONObject(i).get("requestforemail")));
        } catch (Exception exception) {}
        try {
          dir.setShipcontactname(String.valueOf(arr.getJSONObject(i).get("shipcontactname")));
        } catch (Exception exception) {}
        try {
          dir.setShipcontactemail(String.valueOf(arr.getJSONObject(i).get("shipcontactemail")));
        } catch (Exception exception) {}
        try {
          dir.setNettotalusd(String.valueOf(arr.getJSONObject(i).get("nettotalusd")));
        } catch (Exception exception) {}
        try {
          dir.setNetbuyusd(String.valueOf(arr.getJSONObject(i).get("netbuyusd")));
        } catch (Exception exception) {}
        try {
          dir.setIdrow(String.valueOf(arr.getJSONObject(i).get("rowid")));
        } catch (Exception exception) {}
        try {
          dir.setListprice(String.valueOf(arr.getJSONObject(i).get("listprice")));
        } catch (Exception exception) {}
        try {
          dir.setVendorponumber(String.valueOf(arr.getJSONObject(i).get("ddponumber")));
        } catch (Exception exception) {}
        try {
          dir.setInvoice(String.valueOf(arr.getJSONObject(i).get("customerinvoices.invoicenum")));
        } catch (Exception exception) {}
        try {
          dir.setFinancecode(String.valueOf(arr.getJSONObject(i).get("financecode")));
        } catch (Exception exception) {}
        try {
          dir.setGrossprofit(String.valueOf(arr.getJSONObject(i).get("grossprofit")));
        } catch (Exception exception) {}
        try {
          dir.setOrdermanagement(String.valueOf(arr.getJSONObject(i).get("ordermanagementcode")));
        } catch (Exception exception) {}
        try {
          dir.setCustomercode(String.valueOf(arr.getJSONObject(i).get("customercode")));
        } catch (Exception exception) {}
        try {
          dir.setBuyerurl(String.valueOf(arr.getJSONObject(i).get("buyerurl")));
        } catch (Exception exception) {}
        try {
          dir.setBuyertype(String.valueOf(arr.getJSONObject(i).get("buyertype")));
        } catch (Exception exception) {}
        try {
          dir.setBuyergroup(String.valueOf(arr.getJSONObject(i).get("buyergroup")));
        } catch (Exception exception) {}
        try {
          dir.setDdgroupid(String.valueOf(arr.getJSONObject(i).get("ddgroupid")));
        } catch (Exception exception) {}
        try {
          dir.setIntercompanyno(String.valueOf(arr.getJSONObject(i).get("intercompanynum")));
        } catch (Exception exception) {}
        try {
          dir.setConvertedby(String.valueOf(arr.getJSONObject(i).get("docsource")));
        } catch (Exception exception) {}
        try {
          dir.setIsdataentry(String.valueOf(arr.getJSONObject(i).get("isdataentry")));
        } catch (Exception exception) {}
        try {
          dir.setIsselfservice(String.valueOf(arr.getJSONObject(i).get("isselfservice")));
        } catch (Exception exception) {}
        try {
          dir.setBillcountry(String.valueOf(arr.getJSONObject(i).get("billcountrycode")));
        } catch (Exception exception) {}
        try {
          dir.setDeliverycountry(String.valueOf(arr.getJSONObject(i).get("shipcountry")));
        } catch (Exception exception) {}
        try {
          dir.setCurrency(String.valueOf(arr.getJSONObject(i).get("currencycode")));
        } catch (Exception exception) {}
        try {
          dir.setPosttoerpstatus(String.valueOf(arr.getJSONObject(i).get("erpsubmitstatus")));
        } catch (Exception exception) {}
        try {
          dir.setPosttoerpdesc(String.valueOf(arr.getJSONObject(i).get("erpsubmitdesc")));
        } catch (Exception exception) {}
        try {
          dir.setDatequoterequest(String.valueOf(arr.getJSONObject(i).get("quoterequestdate")));
        } catch (Exception exception) {}
        try {
          dir.setCatalogname(String.valueOf(arr.getJSONObject(i).get("catalogname")));
        } catch (Exception exception) {}
        try {
          dir.setIntercompanyitem(String.valueOf(arr.getJSONObject(i).get("intercompanyitem")));
        } catch (Exception exception) {}
        try {
          dir.setItemcategorycode(String.valueOf(arr.getJSONObject(i).get("itemcategorycode")));
        } catch (Exception exception) {}
        try {
          dir.setPlantcode(String.valueOf(arr.getJSONObject(i).get("plantcode")));
        } catch (Exception exception) {}
        try {
          dir.setPreferredsuppliercode(String.valueOf(arr.getJSONObject(i).get("preferredsuppliercode")));
        } catch (Exception exception) {}
        try {
          dir.setUploaded(String.valueOf(arr.getJSONObject(i).get("uploaded")));
        } catch (Exception exception) {}
        try {
          dir.setCatalogcost(String.valueOf(arr.getJSONObject(i).get("basesellercost")));
        } catch (Exception exception) {}
        try {
          dir.setCatalogsell(String.valueOf(arr.getJSONObject(i).get("basesellprice")));
        } catch (Exception exception) {}
        try {
          dir.setCataloglist(String.valueOf(arr.getJSONObject(i).get("baselistprice")));
        } catch (Exception exception) {}
        try {
          dir.setCatalogcurrency(String.valueOf(arr.getJSONObject(i).get("basecurrency")));
        } catch (Exception exception) {}
        try {
          dir.setRegionalbuyergroup(String.valueOf(arr.getJSONObject(i).get("regbuyertype")));
        } catch (Exception exception) {}
        try {
          dir.setPreelaprice(String.valueOf(arr.getJSONObject(i).get("preelaprice")));
        } catch (Exception exception) {}
        try {
          dir.setPreelabaseprice(String.valueOf(arr.getJSONObject(i).get("preelabaseprice")));
        } catch (Exception exception) {}
        try {
          dir.setSerialnumber(String.valueOf(arr.getJSONObject(i).get("docserialnums.serialnumber")));
        } catch (Exception exception) {}
        try {
          dir.setClientbusinessunit(String.valueOf(arr.getJSONObject(i).get("clientbu")));
        } catch (Exception exception) {}
        try {
          dir.setRewsid(String.valueOf(arr.getJSONObject(i).get("rewsid")));
        } catch (Exception exception) {}
        try {
          dir.setFloor(String.valueOf(arr.getJSONObject(i).get("floor")));
        } catch (Exception exception) {}
        try {
          dir.setConstructionid(String.valueOf(arr.getJSONObject(i).get("constructionid")));
        } catch (Exception exception) {}
        try {
          dir.setRoomtype(String.valueOf(arr.getJSONObject(i).get("roomtype")));
        } catch (Exception exception) {}
        try {
          dir.setFirstdayofbusiness(String.valueOf(arr.getJSONObject(i).get("firstdayofbusiness")));
        } catch (Exception exception) {}
        try {
          dir.setFistdayofinstall(String.valueOf(arr.getJSONObject(i).get("firstdayofinstall")));
        } catch (Exception exception) {}
        try {
          dir.setPosttoerpname(String.valueOf(arr.getJSONObject(i).get("posttoerpname")));
        } catch (Exception exception) {}
        try {
          dir.setPosttoerpemail(String.valueOf(arr.getJSONObject(i).get("posttoerpemail")));
        } catch (Exception exception) {}
        try {
          dir.setStockreservationon(String.valueOf(arr.getJSONObject(i).get("stockreservationcode")));
        } catch (Exception exception) {}
        try {
          dir.setPricerulereference(String.valueOf(arr.getJSONObject(i).get("pricerulereference")));
        } catch (Exception exception) {}
        String srowid = dir.getIdrow().trim();
        if (srowid.length() == 1) {
          srowid = "000" + srowid;
        } else if (srowid.length() == 2) {
          srowid = "00" + srowid;
        } 
        if (srowid.length() == 3)
          srowid = "0" + srowid; 
        String sidrecord = String.valueOf(dir.getConfirmationno()) + srowid;
        dir.setIdrecord(sidrecord);
        System.out.println(String.valueOf(i) + "/" + sTotalRecord + " : " + sidrecord);
        dir.dbUpdateOrder();
      } 
      System.out.println(String.valueOf(sTotalRecord) + " completed");
    } 
  }
  
  public static void initDirectory() {
    sleep(20);
    waitForElementTextEqualsString(gdriver.findElementByXPath("//body/pre"), "sessionSecureToken", (WebDriver)gdriver, 60);
    String sContent = gdriver.getPageSource();
    String sSecureToken = getData(sContent, "sessionSecureToken\":\"", "\",\"sessionTimeoutMinutes\"");
    gsno = sSecureToken;
    System.out.println("secure Token= " + sSecureToken);
  }
  
  public static void getDirectory() {
    LocalDate ld = LocalDate.now();
    int iWeek = 1;
    ld = ld.minusWeeks(iWeek);
    LocalDate eld = LocalDate.now();
    getDirectory(ld.toString(), eld.toString());
  }
  
  public static void getDirectory(String sStartDate, String sEndDate) {
    String sToken = decodeValue(gsno);
    System.out.println("Token=" + sToken);
    String sContent = "";
    String sURL = "";
    try {
      sURL = "https://wd3.myworkday.com/nttlimited/d/inst/1$4290/2501$25.htmld#TABINDEX=0&SUBTABINDEX=0";
      gdriver.get(sURL);
      sleep(20);
      sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(5L, TimeUnit.MINUTES)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By css = By.cssSelector("div[data-automation-id=\"workbooksIconButton\"]");
      WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
      gdriver.findElement(By.xpath(".//*[@class='WKXK WJXK WDWK WHWK WFWK WPRO']")).click();
      sleep(5);
      gdriver.findElement(By.xpath("//span[contains(text(),'Click to download')]")).click();
      sleep(20);
      sContent = gdriver.getPageSource();
      Document doc = null;
      doc = Jsoup.parse(sContent);
      Elements elements = doc.select("div[role=\"row\"]");
    } catch (Exception e) {
      System.out.println("ERROR: Timesheet: " + sURL);
      System.out.println(e.getMessage());
    } 
    System.out.println("done");
  }
  
  public static void directsReport(String sReportID) {
    String sContent = "";
    String sURL = "";
    try {
      sURL = "https://direct.nttltd.global.ntt/NGwww/reports/customer-po-detail/" + sReportID + "/true";
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(5L, TimeUnit.MINUTES)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By css = By.cssSelector("button[class=\"is-button is-primary is-spinner\"]");
      sleep(10);
      WebElement btnLogin = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(css));
      btnLogin.click();
      sleep(10);
      css = By.cssSelector("label[style=\"font-weight: 300;text-align:right;color: #a9a9a9;\"]");
      WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
      sleep(10);
      sContent = gdriver.getPageSource();
      Document doc = null;
      doc = Jsoup.parse(sContent);
      Elements rows = doc.select("div[role=\"row\"]");
      int i = 0;
      System.out.println("Row=" + rows.size());
      for (Element tr2 : rows) {
        String sClass = tr2.attr("role");
        if (sClass.equalsIgnoreCase("row")) {
          Elements tds = tr2.select("div[role=\"gridcell\"]");
          int index = 0;
          direct dir = new direct();
          System.out.println("Cell=" + tds.size());
          for (Element td : tds) {
            String colname = td.attr("col-id");
            String sValue = normalize(td.text().trim());
            if (colname.equalsIgnoreCase("regionname")) {
              dir.setRegion(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("entityname")) {
              dir.setDdentity(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("buyername_a")) {
              dir.setBuyername(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("docnum")) {
              dir.setPonumber(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("docdate")) {
              dir.setPodate(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("confirmationnum")) {
              dir.setConfirmationno(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("creatorname_a")) {
              dir.setRequester(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("manufacturer")) {
              dir.setManufacturer(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("mfrpartnum")) {
              dir.setMfrpartnumber(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("name")) {
              dir.setItemdescription(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("preferredsupplier")) {
              dir.setPreferredsupplier(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("itemstatusname")) {
              dir.setStatus(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("quantity")) {
              dir.setQuantity(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("grossbuyusd")) {
              dir.setGrosscostusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("grosstotalusd")) {
              dir.setGrosstotalusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("salesofficecode")) {
              dir.setSalesoficecode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("salesoffice")) {
              dir.setSalesoffice(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("orderreason")) {
              dir.setOrderreason(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("orderreasoncode")) {
              dir.setOrderreasoncode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("sonumber")) {
              dir.setSo(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("quotename")) {
              dir.setQuotename(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("quotenumber")) {
              dir.setQuoteno(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("opptrefnum")) {
              dir.setSfdcno(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("projectcode")) {
              dir.setProjectcode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("department")) {
              dir.setDepartment(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("totalcost")) {
              dir.setGrosscost(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("totalsell")) {
              dir.setGrosstotal(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("porcvdate")) {
              dir.setPoreceiveddate(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("needbydate")) {
              dir.setNeededby(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("dateentered")) {
              dir.setDatecreated(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("datesubmitted")) {
              dir.setDatesubmitted(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("datepurchased")) {
              dir.setDatepurchased(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("dateaccepted")) {
              dir.setDateaccepted(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("datemfrsched")) {
              dir.setDatemfrscheduled(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("dateship")) {
              dir.setDateshipped(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("datedeliver")) {
              dir.setDatedelivered(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("dateinvoice")) {
              dir.setDateinvoiced(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("budgetbuy")) {
              dir.setBudgetcostusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("budgettotal")) {
              dir.setBudgettotalusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("dealId")) {
              dir.setDealid(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("estshipdate")) {
              dir.setDateestimatedship(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("estdeliverdate")) {
              dir.setDateestimateddelivery(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("itemcategory")) {
              dir.setItemcategory(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("itemtypename")) {
              dir.setItemtypename(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("plantname")) {
              dir.setPlantname(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("producttype")) {
              dir.setProducttype(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("unspsc")) {
              dir.setCategory(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("listpriceusd")) {
              dir.setListpriceusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("qtecreatedby")) {
              dir.setQuotedcratedby(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("requestforemail")) {
              dir.setRequestoremailaddress(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("shipcontactname")) {
              dir.setShipcontactname(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("shipcontactemail")) {
              dir.setShipcontactemail(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("nettotalusd")) {
              dir.setNettotalusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("netbuyusd")) {
              dir.setNetbuyusd(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("rowid")) {
              dir.setIdrow(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("listprice")) {
              dir.setListprice(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("ddponumber")) {
              dir.setVendorponumber(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("customerinvoices.invoicenum")) {
              dir.setInvoice(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("financecode")) {
              dir.setFinancecode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("grossprofit")) {
              dir.setGrossprofit(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("ordermanagementcode")) {
              dir.setOrdermanagement(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("customercode")) {
              dir.setCustomercode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("buyerurl")) {
              dir.setBuyerurl(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("buyertype")) {
              dir.setBuyertype(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("buyergroup")) {
              dir.setBuyergroup(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("ddgroupid")) {
              dir.setDdgroupid(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("intercompanynum")) {
              dir.setIntercompanyno(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("docsource")) {
              dir.setConvertedby(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("isdataentry")) {
              dir.setIsdataentry(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("isselfservice")) {
              dir.setIsselfservice(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("billcountrycode")) {
              dir.setBillcountry(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("shipcountry")) {
              dir.setDeliverycountry(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("currencycode")) {
              dir.setCurrency(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("erpsubmitstatus")) {
              dir.setPosttoerpstatus(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("erpsubmitdesc")) {
              dir.setPosttoerpdesc(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("quoterequestdate")) {
              dir.setDatequoterequest(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("catalogname")) {
              dir.setCatalogname(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("intercompanyitem")) {
              dir.setIntercompanyitem(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("itemcategorycode")) {
              dir.setItemcategorycode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("plantcode")) {
              dir.setPlantcode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("preferredsuppliercode")) {
              dir.setPreferredsuppliercode(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("uploaded")) {
              dir.setUploaded(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("basesellercost")) {
              dir.setCatalogcost(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("basesellprice")) {
              dir.setCatalogsell(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("baselistprice")) {
              dir.setCataloglist(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("basecurrency")) {
              dir.setCatalogcurrency(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("regbuyertype")) {
              dir.setRegionalbuyergroup(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("preelaprice")) {
              dir.setPreelaprice(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("preelabaseprice")) {
              dir.setPreelabaseprice(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("docserialnums.serialnumber")) {
              dir.setSerialnumber(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("clientbu")) {
              dir.setClientbusinessunit(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("rewsid")) {
              dir.setRewsid(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("floor")) {
              dir.setFloor(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("constructionid")) {
              dir.setConstructionid(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("roomtype")) {
              dir.setRoomtype(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("firstdayofbusiness")) {
              dir.setFirstdayofbusiness(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("firstdayofinstall")) {
              dir.setFistdayofinstall(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("posttoerpname")) {
              dir.setPosttoerpname(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("posttoerpemail")) {
              dir.setPosttoerpemail(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("stockreservationcode")) {
              dir.setStockreservationon(sValue);
              continue;
            } 
            if (colname.equalsIgnoreCase("pricerulereference"))
              dir.setPricerulereference(sValue); 
          } 
          String srowid = dir.getIdrow().trim();
          if (srowid.length() == 1) {
            srowid = "000" + srowid;
          } else if (srowid.length() == 2) {
            srowid = "00" + srowid;
          } 
          if (srowid.length() == 3)
            srowid = "0" + srowid; 
          String sSO = dir.getSo().trim();
          if (sSO.length() == 5)
            sSO = "0000" + sSO; 
          dir.setSo(sSO);
          String sidrecord = String.valueOf(dir.getConfirmationno()) + srowid;
          dir.setIdrecord(sidrecord);
          dir.dbUpdateOrder();
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
  
  public static RemoteWebDriver getDriver() {
    try {
      gdriver.close();
      gdriver.quit();
    } catch (Exception e) {
      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
    } 
    RemoteWebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("useAutomationExtension", Boolean.valueOf(false));
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    options.addArguments(new String[] { "--headless", "--window-size=1920,1200", "--ignore-certificate-errors" });
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
  
  public static RemoteWebDriver getDriverWorkday() {
    try {
      gdriver.close();
      gdriver.quit();
    } catch (Exception e) {
      System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
    } 
    RemoteWebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("useAutomationExtension", Boolean.valueOf(false));
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    options.addArguments(new String[] { "--ignore-certificate-errors" });
    String downloadFilepath = "C:\\ppms\\files";
    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("profile.default_content_settings.popups", Integer.valueOf(0));
    chromePrefs.put("download.default_directory", downloadFilepath);
    options.setExperimentalOption("prefs", chromePrefs);
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
    //driver.get("https://wd3.myworkday.com/nttlimited/inst/1$4290/2501$25.htmld");
    driver.get("https://wd3.myworkday.com/nttlimited/d/inst/1$4290/2501$25.htmld#TABINDEX=0&SUBTABINDEX=0");
    
    /*
     * 
     * NTT Singapore:
https://wd3.myworkday.com/nttlimited/d/inst/1$4290/2501$195.htmld#TABINDEX=0&SUBTABINDEX=0

NTT Singapore Solutions
https://wd3.myworkday.com/nttlimited/d/inst/1$4290/2501$25.htmld#TABINDEX=0&SUBTABINDEX=0
     * 
     * 
     */
    try {
      driver.switchTo().alert().accept();
    } catch (WebDriverException ex) {
      System.out.println("Error=" + ex.getLocalizedMessage());
    } 
    Set handles = driver.getWindowHandles();
    System.out.println(handles);
    for (String handle1 : driver.getWindowHandles()) {
      System.out.println(handle1);
      System.out.println(driver.getCurrentUrl());
      System.out.println(driver.getSessionId());
      driver.switchTo().window(handle1);
    } 
    return driver;
  }
  
  public static void main(String[] args) {
    try {
      //initDriverDirects();
      //initDirectory();
      //getDirectory();
    } finally {
      gdriver.close();
      gdriver.quit();
    } 
  }
}