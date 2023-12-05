import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
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
import org.openqa.selenium.support.ui.Select;

//import com.sun.org.apache.bcel.internal.generic.Select;

import org.json.JSONException;
import org.json.JSONObject;

public class ppms {
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  public static String dbName="c1ppms";
  
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
  
  public static void employeeRefresh() {
    String sData = "tvEngRes0ff7264a_0ed2_403f_b852_728afd48575c|1||res_e_p|1||Akilan Sundararasu|1|||1|||1|||1||0|1||0|2||tvEngRescd52fe1a_060c_4dfb_b013_38c4ddc981d3|1||res_e|1||Anjaneyulu Muvva|1|||1|||1|||1||0|1||0|2||tvEngRese8797b9e_6154_4a99_a942_e6c6a559619c|1||res_e_p|1||Anthony Steven|1|||1|||1|||1||0|1||0|2||tvEngResc31e4c29_34d0_4e06_a5b0_ea63b78df2e2|1||res_e_p|1||Ashwani Kumar|1|||1|||1|||1||0|1||0|2||tvEngRescedc5240_1391_4080_bdfb_27a6f4fc3a32|1||res_e_p|1||Bhadrachari Devu Naga Veer|1|||1|||1|||1||0|1||0|2||tvEngRes6191e6ed_f6fc_461a_ac4f_029e0646b088|1||res_e_p|1||Bian Wei Tan|1|||1|||1|||1||0|1||0|2||tvEngRes427d49c0_f1b2_4c74_9dc0_fb121efb0725|1||res_e_p|1||Cheng Huat Chew|1|||1|||1|||1||0|1||0|2||tvEngRes11751425_dd20_47f7_865c_e0160f521f4f|1||res_e_p|1||Christian Godi|1|||1|||1|||1||0|1||0|2||tvEngResd92150df_1ed3_40d7_a75b_f745514f9911|1||res_e_p|1||Enid Tee|1|||1|||1|||1||0|1||0|2||tvEngRescb853332_2c55_41ab_910c_7bd1fc342063|1||res_e_p|1||Farihah Binte Omar|1|||1|||1|||1||0|1||0|2||tvEngRes04712c71_56ac_44cf_a179_18459a99c718|1||res_e_p|1||Feri Gunawan|1|||1|||1|||1||0|1||0|2||tvEngRes77dd55d0_508f_4129_b81c_fb656b4ed0f9|1||res_e_p|1||Gemilene Co Uy|1|||1|||1|||1||0|1||0|2||tvEngResde66baf6_cc64_45fc_8025_00f66a030517|1||res_e_p|1||Han Ming Ong|1|||1|||1|||1||0|1||0|2||tvEngResa53240b6_edc2_4c6a_a286_3cbb9a6663ef|1||res_e_p|1||Jia Yee Toh|1|||1|||1|||1||0|1||0|2||tvEngResc97929c4_80a6_4640_8a42_c1a6cf0acd7f|1||res_e_p|1||Jiang Feng Goh|1|||1|||1|||1||0|1||0|2||tvEngResbf64e0d9_e2df_49e9_8a4a_2aec7b0e0865|1||res_e_p|1||John Soriano Cabanero|1|||1|||1|||1||0|1||0|2||tvEngRes5495e926_a59e_4b75_9f2f_9944c71707a7|1||res_e_p|1||Joy Kevin Machado|1|||1|||1|||1||0|1||0|2||tvEngResa3f2f84e_de2e_4192_8e25_1ce56a5d1062|1||res_e_p|1||Kian Chuan Goh|1|||1|||1|||1||0|1||0|2||tvEngRes283dc93b_a5c2_446c_8b41_f4a613ddbc06|1||res_e_p|1||Laura Fayre Kelly|1|||1|||1|||1||0|1||0|2||tvEngResc61459ae_8532_467c_9fa6_800f4c4146c7|1||res_e_p|1||Leo Lu|1|||1|||1|||1||0|1||0|2||tvEngRes854362b8_23b0_4f47_b5ad_965cd71a1d7d|1||res_e_p|1||Ley Ying Wat|1|||1|||1|||1||0|1||0|2||tvEngRes31ca129b_de5d_47dd_b843_ccba2dbb43c8|1||res_e_p|1||Liang Hui Raphael Chua|1|||1|||1|||1||0|1||0|2||tvEngRese09fd73a_45d4_41f3_b494_77ded9bc2a97|1||res_e_p|1||Michael Albert Rodriguez Santos|1|||1|||1|||1||0|1||0|2||tvEngResf2c3d29e_a46b_4467_8806_80716cf7430d|1||res_e_p|1||Min San|1|||1|||1|||1||0|1||0|2||tvEngRes346f7198_af33_40f4_a198_18a681768258|1||res_e_p|1||Min Xuan Yong|1|||1|||1|||1||0|1||0|2||tvEngResacf13cd3_2200_4cdf_a73f_4d4ded82c3de|1||res_e_p|1||Ming Wei|1|||1|||1|||1||0|1||0|2||tvEngResedf0c4e3_051b_4345_bcb5_d47024d880b3|1||res_e_p|1||Mohamed Anees Faizal Abdul Azhad|1|||1|||1|||1||0|1||0|2||tvEngRes1e22fd90_6816_4bbd_befe_0505e13f8007|1||res_e_p|1||Muhammad Fathurrahman Bin Maideen|1|||1|||1|||1||0|1||0|2||tvEngRes29ac71c2_7fa3_4114_a7a7_d67f58737eff|1||res_e_p|1||Neil Ivann Duplon Chua|1|||1|||1|||1||0|1||0|2||tvEngRese8d8490a_ad73_4f18_befd_01c6ecbac94a|1||res_e_p|1||Nevin Kit Ming Tay|1|||1|||1|||1||0|1||0|2||tvEngRes043cf176_1ff1_4519_ac4c_df09fab77fbf|1||res_e_p|1||Phu Pwint Wai|1|||1|||1|||1||0|1||0|2||tvEngRes66972d06_03ce_4a84_95bb_7460dac3a1f0|1||res_e_p|1||Pineda Maria Alnor Concepcion|1|||1|||1|||1||0|1||0|2||tvEngRes9046edad_01e3_49d0_bfeb_de5b7a72b6fb|1||res_e_p|1||Pyae Phyo|1|||1|||1|||1||0|1||0|2||tvEngRes83f442e0_862e_41a4_a227_49e3fa2bed57|1||res_e_p|1||Qinni Lin|1|||1|||1|||1||0|1||0|2||tvEngRes9f493ebe_c6f7_4182_94b7_9f5e5a5aab5a|1||res_e_p|1||Rajeswari Rajkumar|1|||1|||1|||1||0|1||0|2||tvEngRes848ce05f_4a5d_4863_bcb0_6aa1483e438a|1||res_e_p|1||Rajkumar Venugopal|1|||1|||1|||1||0|1||0|2||tvEngResc507a170_7ab2_4a3d_95c9_a24dcd021a7d|1||res_e_p|1||Ralph Joshua Versoza Batula|1|||1|||1|||1||0|1||0|2||tvEngResaf092710_58ea_417c_9a3d_578d5011c449|1||res_e_p|1||Rama Krishna Enaganti|1|||1|||1|||1||0|1||0|2||tvEngRes9f207c97_5c28_48f5_920b_fba5041ea038|1||res_e_p|1||Ronnie Sia Tan|1|||1|||1|||1||0|1||0|2||tvEngRes54812977_e70f_4c66_8e1b_7373b6e4b332|1||res_e_p|1||Sok Nam Vickie Ng|1|||1|||1|||1||0|1||0|2||tvEngRes6c7e5dd6_3a7b_4dba_92c5_de286d1800ab|1||res_e_p|1||Subhash Reddy Gangidi|1|||1|||1|||1||0|1||0|2||tvEngResfc07521e_a316_411c_a720_5d4577ef2131|1||res_e_p|1||Sudarpo Chong|1|||1|||1|||1||0|1||0|2||tvEngResee77c633_6932_424b_96c4_bf9203f95a03|1||res_e_p|1||Thulasiraman Rajaram|1|||1|||1|||1||0|1||0|2||tvEngResb4491132_ce39_40c0_9c5d_5bb18dd82be2|1||res_e_p|1||Valery Fun|1|||1|||1|||1||0|1||0|2||tvEngResc489b168_b403_4ef7_aa26_7db0e60ae50c|1||res_e_p|1||Vincenzo Lauretta|1|||1|||1|||1||0|1||0|2||tvEngRes75100fa1_3a12_48ed_b36b_3a6db6987b93|1||res_e_p|1||Vinod Reddy Bojja|1|||1|||1|||1||0|1||0|2||tvEngRes04f4f9b1_38a4_4cdf_9130_9d058e981344|1||res_e_p|1||Xun Wei Peh|1|||1|||1|||1||0|1||0|2||tvEngResee5787e7_9831_43a6_9360_9d28877bcbf5|1||res_e_p|1||Yi Chao Matthew Lee|1|||1|||1|||1||0|1||0|2||tvEngRes50ab3c79_9d2c_4875_a144_5917a45d83ca|1||res_e_p|1||You Month Leong|1|||1|||1|||1||0|1||0";
    String[] aData = sData.split("tvEngRes");
    try {
      for (int i = 0; i < aData.length; i++) {
        if (aData[i].length() > 0) {
          String[] sRecord = aData[i].split("\\|");
          String sEmployeeID = sRecord[0];
          if (sEmployeeID.length() > 10)
            sEmployeeID = sEmployeeID.replaceAll("_", "-").toUpperCase(); 
          System.out.println(sEmployeeID);
          updateUserProfile(sEmployeeID);
        } 
      } 
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static void employeeRefresh(String sno) {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sFilter = "";
    if (!sno.isEmpty() && 
      sno.length() > 0)
      sFilter = " where idemployee = '" + sno + "'"; 
    String query = "SELECT eid,idemployee FROM employee " + sFilter;
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int total = rs.getFetchSize();
      int i = 1;
      while (rs.next()) {
        System.out.println(String.valueOf(i) + "/" + total);
        updateUserProfile(rs.getInt(1), rs.getString(2));
        i++;
      } 
      rs.close();
      query = "update employee inner join workday set reportsto=workday.managername where workday.email=employee.email ";
      st.execute(query);
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static void updatePhoneNumber() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT eid,email FROM employee";
    try {
      Statement st = (Statement)conn.createStatement();
      Statement st2 = (Statement)conn.createStatement();
      Statement st3 = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int total = rs.getFetchSize();
      int i = 1;
      while (rs.next()) {
        String sEmail = rs.getString("email");
        if (sEmail != null && 
          sEmail.length() > 0)
          sEmail = sEmail.toLowerCase(); 
        String sselect = "select mobilenumber from workday where email='" + sEmail + "'";
        ResultSet rs2 = (ResultSet)st2.executeQuery(sselect);
        if (rs2.next()) {
          String sMobile = rs2.getString("mobilenumber");
          if (sMobile != null) {
            sMobile = sMobile.replaceAll(" ", "");
            sMobile = sMobile.replaceAll("\\(Telep", "");
            if (sMobile.indexOf("+") < 0)
              sMobile = "+65" + sMobile; 
          } 
          String supdate = "update employee set mobilenumber='" + sMobile + "' where eid=" + rs.getString("eid");
          st3.execute(supdate);
        } 
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static void backupdatase() {
    System.out.println("Backup Task Database");
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String formattedString = localDate.format(formatter);
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "";
    try {
      Statement st = (Statement)conn.createStatement();
      query = "CREATE table `c1ppms`.`task-" + formattedString + "` LIKE c1ppms.task";
      st.execute(query);
      query = "INSERT INTO `c1ppms`.`task-" + formattedString + "` SELECT * FROM c1ppms.task";
      st.execute(query);
      query = "CREATE table `c1ppms`.`projecthealth-" + formattedString + "` LIKE c1ppms.projecthealth";
      st.execute(query);
      query = "INSERT INTO `c1ppms`.`projecthealth-" + formattedString + "` SELECT * FROM c1ppms.projecthealth";
      st.execute(query);
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } finally {
      System.out.println("Backup Task Database -  COMPLETED");
    } 
  }
  
  public static void timesheetRefresh() {
    System.out.println("Executing timesheetRefresh");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT eid,idemployee, ename FROM employee where billable='yes'";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int total = rs.getFetchSize();
      int i = 1;
      while (rs.next()) {
        System.out.println("Updating Timesheet for " + rs.getString(2) + " " + rs.getString(3));
        updateTimesheet(rs.getString(2), "", "");
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } finally {
      System.gc();
    } 
  }
  
  public static void ppmsProjectByStatusByPM(int eid, String idemployee) {
    employee emp = new employee();
    try {
      gdriver.get("https://ppms.ap.dimensiondata.com/Reports/rpProjectByStatus_PM.asp?rid=" + grid + "&sno=" + gsno + "&ui=W");
      String sContent = gdriver.getPageSource();
      gdriver.findElement(By.id("cpCtrl_1230")).click();
      Select se = new Select(gdriver.findElement(By.id("cpCtrl_1003")));
      se.selectByVisibleText("Purnama Sidhi");
      gdriver.findElement(By.id("btnSubmit")).submit();
    } catch (Exception e) {
      System.out.println("error");
    } 
  }
  
  public static void updateUserProfile(String idemployee) {
    updateUserProfile(0, idemployee);
  }
  
  public static void updateUserProfile(int eid, String idemployee) {
    employee emp = new employee();
    gdriver.get("https://ppms.ap.dimensiondata.com/core/forms/frUserPage.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&u={" + idemployee + "}");
    String sContent = gdriver.getPageSource();
    emp.setIdemployee((new StringBuilder(String.valueOf(idemployee))).toString());
    emp.setEmployee(sContent);
    if (eid == 0) {
      String sEid = emp.queryEID(idemployee);
      if (sEid.length() > 0)
        try {
          eid = Integer.parseInt(sEid);
        } catch (Exception e) {
          eid = 0;
        }  
    } 
    emp.setEid((new StringBuilder(String.valueOf(eid))).toString());
    emp.dbUpdateEmployee();
  }
  
  public static void viewResourceTreeSingapore() {
    employee emp = new employee();
    try {
      gdriver.get("https://ppms.ap.dimensiondata.com/Core/Treeviews/ifrTvResource.aspx?cid=tvEngRes&rid=" + grid + "&sno=" + gsno + "&ui=W&LoginWorkgroupId={C0407862-4730-40F6-A4A6-4EB610DB2D7A}&loadfor=0&cptype=gwp&id=97973f52-b849-4270-bacb-a907ea031fc7");
      String sContent = gdriver.getPageSource();
      String sTreeData = sContent.substring(sContent.indexOf("', \"tvEngRes") + 4, sContent.indexOf("\", 16"));
      if (sTreeData != null) {
        String[] aData = sTreeData.split("tvEngRes");
        try {
          for (int i = 0; i < aData.length; i++) {
            if (aData[i].length() > 0) {
              String[] sRecord = aData[i].split("\\|");
              String sGroup = sRecord[0];
              if (sGroup.length() > 10)
                sGroup = sGroup.replaceAll("_", "-").toLowerCase(); 
              viewResourceTreeGroup(sGroup);
            } 
          } 
        } catch (Exception ex) {
          System.out.println(ex.getMessage());
        } 
      } 
    } catch (Exception exception) {
    
    } finally {
      employee.dbCleanUp();
    } 
  }
  
  public static void viewResourceTreeGroup(String sGroupID) {
    employee emp = new employee();
    try {
      gdriver.get("https://ppms.ap.dimensiondata.com/Core/Treeviews/ifrTvResource.aspx?cid=tvEngRes&rid=" + grid + "&sno=" + gsno + "&ui=W&LoginWorkgroupId={C0407862-4730-40F6-A4A6-4EB610DB2D7A}&loadfor=0&cptype=wgp_ex_p&id=" + sGroupID);
      String sContent = gdriver.getPageSource();
      String sTreeData = sContent.substring(sContent.indexOf("', \"tvEngRes") + 4, sContent.indexOf("\", 16"));
      if (sTreeData != null) {
        String[] aData = sTreeData.split("tvEngRes");
        try {
          for (int i = 0; i < aData.length; i++) {
            if (aData[i].length() > 0) {
              String[] sRecord = aData[i].split("\\|");
              String sEmployeeID = sRecord[0];
              if (sEmployeeID.length() > 10)
                sEmployeeID = sEmployeeID.replaceAll("_", "-").toUpperCase(); 
              if (sEmployeeID.length() == 36)
                updateUserProfile(sEmployeeID); 
            } 
          } 
        } catch (Exception ex) {
          System.out.println(ex.getMessage());
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public static void updateRateCard() {
    employee emp = new employee();
    employee.employeeRateRefresh();
  }
  
  public static void dbCleanUp() {
    task task = new task();
    task.dbCleanUp();
    timesheet tsheet = new timesheet();
    tsheet.dbCleanUp();
    project pject = new project();
    pject.dbCleanUp();
    contract cont = new contract();
    contract.dbCleanUp();
  }
  
  public static void updateLongName() {
    employee emp = new employee();
    employee.employeeUpdateLongName();
  }
  
  public static void updateProjects() {
    timesheet ts = new timesheet();
    ts.dbRefreshProject();
  }
  
  public static void updateTimesheet(String idEmployee, String sStartDate, String sEndDate) {
    LocalDate ld = LocalDate.now();
    int iWeek = 3;
    if (ld.getDayOfMonth() == 25)
      iWeek = 6; 
    ld = ld.minusWeeks(iWeek);
    LocalDate eld = LocalDate.now();
    eld = eld.plusWeeks(1L);
    System.out.println("################################# START FOR " + idEmployee + " For " + ld.toString() + "#################################");
    while (ld.compareTo(eld) < 0) {
      ld = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
      updateTimesheet(idEmployee, ld.toString());
      System.out.println("END Timesheet: " + idEmployee + " For " + ld.toString());
    } 
    System.out.println("################################# END FOR " + idEmployee + " For " + ld.toString() + "#################################");
  }
  
  public static void updateTimesheet(String idEmployee, String sDates) {
    String sContent = "";
    String sURL = "";
    try {
      System.out.println("Timesheet: " + idEmployee + " For " + sDates);
      String[] aDate = sDates.split("-");
      String sYear = aDate[0];
      String sMonth = aDate[1];
      String sDay = aDate[2];
      sURL = "https://ppms.ap.dimensiondata.com/Core/Time_Sheet/dcTimeSheet.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&reid={" + idEmployee + "}&forceTablet=0&interval=pweek&sdate=" + sDay + "&sdatem=" + sMonth + "&sdatey=" + sYear;
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(5L, TimeUnit.SECONDS)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("table[id=\"tblTimeSheet_tblFixedCol\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        Elements project = doc.select("table#tblTimeSheet_tblFixedCol");
        Elements projects = project.select("tr");
        int i = 0;
        for (Element tr : projects) {
          String pid = tr.attr("pid");
          String sProjectName = "";
          String sTaskName = "";
          String sProjectID = "";
          String sTaskID = "";
          String sServiceID = "";
          Elements tds = tr.select("td");
          int j = 0;
          for (Element td : tds) {
            if (j == 0) {
              sProjectName = td.attr("cv");
              String sProjectURL = td.select("a").attr("href");
              if (!sProjectURL.equals("")) {
                int indexPID = sProjectURL.indexOf("ProjectId={");
                int serviceID = sProjectURL.indexOf("reqid={");
                if (indexPID > 0) {
                  sProjectID = sProjectURL.substring(indexPID + "ProjectId={".length(), indexPID + "ProjectId={".length() + 36);
                } else {
                  sServiceID = sProjectURL.substring(serviceID + "reqid={".length(), serviceID + "reqid={".length() + 36);
                } 
              } 
            } else {
              sTaskName = td.attr("cv");
              String sTaskURL = td.select("a").attr("href");
              if (!sTaskURL.equals("")) {
                int indexTask = sTaskURL.indexOf("sTaskId={");
                if (indexTask > 0) {
                  sTaskID = sTaskURL.substring(indexTask + "sTaskId={".length(), indexTask + "sTaskId={".length() + 36);
                  if (!task.isViewUpdated(sTaskID)) {
                    viewTaskDetails(sTaskID);
                  } else {
                    System.out.println("timesheet: task viewed " + sTaskID);
                  } 
                } else {
                  sTaskID = sServiceID;
                } 
              } 
            } 
            j++;
          } 
          Elements hgroup = doc.select("table#tblTimeSheet_tblMain");
          Elements hours = hgroup.select("[PID=" + pid + "]").select("td");
          String sOldDate = "";
          for (Element hour : hours) {
            String sTimesheetID = hour.attr("id");
            String sDate = hour.attr("celldate");
            String sHour = hour.attr("cv");
            String sTimeType = hour.attr("timetype");
            String sDescription = hour.attr("title");
            String sBillable = "1";
            String sStyle = hour.attr("style");
            String sStatus = "Entered";
            if (!sDate.contentEquals("") && 
              !sHour.equals("")) {
              if (sTaskID.contentEquals(""))
                sBillable = "0"; 
              if (!sServiceID.contentEquals(""))
                sBillable = "8"; 
              if (!sProjectName.contentEquals("") && 
                sProjectName.startsWith("TXR"))
                sBillable = "10"; 
              if (!sStyle.isEmpty())
                if (sStyle.contains("color:#808090;")) {
                  sStatus = "Submitted";
                } else if (sStyle.contains("color:#008000;")) {
                  sStatus = "Approved";
                } else if (sStyle.contains("color:#rejected;")) {
                  sStatus = "Rejected";
                }  
              timesheet dbt = new timesheet();
              dbt.setClockdate(sDate);
              dbt.setProjectname(sProjectName);
              dbt.setIdproject(sProjectID);
              dbt.setTaskname(sTaskName);
              dbt.setIdtask(sTaskID);
              dbt.setDescription(sDescription);
              dbt.setHours(sHour);
              dbt.setHourstype(sTimeType);
              dbt.setBillable(sBillable);
              dbt.setIdtimesheet(String.valueOf(sTimesheetID) + "-" + sTimeType);
              dbt.setIdemployee(idEmployee);
              dbt.setStatus(sStatus);
              dbt.dbRefreshTimeSheet();
            } 
          } 
        } 
      } else {
        System.out.println("SESSION INVALID - Timesheet: " + idEmployee + " For " + sDates);
        initDriver();
        updateTimesheet(idEmployee, sDates);
      } 
    } catch (Exception e) {
      System.out.println("ERROR: Timesheet: " + sURL);
      System.out.println(e.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        updateTimesheet(idEmployee, sDates);
      } 
    } 
  }
  
  public static void reportProfitability(String user) {
    gdriver.get("https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&reportid=%7bB8FD6FE3-135C-4ED6-9260-9B8D16DEB76C%7d&ui=W&Portal=True");
    String sContent = gdriver.getPageSource();
    Document doc = null;
    doc = Jsoup.parse(sContent);
    Elements links = doc.select("div#Master_tblSectionDiv6");
    int i = 0;
    for (Element link : links) {
      String linkID = link.attr("id");
      String linkHref = link.attr("title");
      String linkText = link.text();
      System.out.println(String.valueOf(i) + ":" + linkID + ":" + linkHref + "====" + linkText);
      i++;
    } 
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
  
  public static void viewProjectDetails() {
    System.out.println("Executing viewProjectDetails");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT timesheet.`idproject` from `timesheet` inner join projecthealth on timesheet.idproject=projecthealth.idproject where projecthealth.ProjectStatus not in ('Closed','Completed') group by timesheet.`idproject` order by timesheet.idproject";
    String sIDProject = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int i = 1;
      while (rs.next()) {
        sIDProject = rs.getString(1);
        if (sIDProject.length() == 36) {
          System.out.println("Retrieving Project Profile for " + sIDProject);
          viewProjectDetails(sIDProject);
        } else {
          System.out.println("Invalid Project Profile for " + sIDProject);
        } 
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (Exception exception) {
    
    } finally {
      System.gc();
    } 
  }
  
  public static void viewProjectHealthDetails() {
    System.out.println("Executing viewProjectDetails");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idproject` from `projecthealth` where `projectstatus`='Active' group by `idproject` order by idproject ";
    String sIDProject = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int i = 1;
      while (rs.next()) {
        sIDProject = rs.getString(1);
        if (sIDProject.length() == 36) {
          System.out.println("Retrieving Project Profile for " + sIDProject);
          viewProjectDetails(sIDProject);
        } else {
          System.out.println("Invalid Project Profile for " + sIDProject);
        } 
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (Exception exception) {
    
    } finally {
      System.gc();
    } 
  }
  
  public static boolean isSessionInvalid(String sContent) {
    boolean rslt = false;
    Document doc = null;
    doc = Jsoup.parse(sContent);
    String sMessage = "";
    try {
      sMessage = doc.select("h3").text();
      if (sMessage != null && 
        sMessage.contains("Your session is no longer active"))
        rslt = true; 
    } catch (Exception exception) {}
    return rslt;
  }
  
  public static void viewProjectDetails(String sIDProject) {
    String sContent = "";
    String sURL = "";
    try {
      sURL = "https://ppms.ap.dimensiondata.com/core/views/vwProjDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ProjectId={" + sIDProject + "}&CoMgrandSumMgrFlag=1111110";
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(3L, TimeUnit.SECONDS)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("div[id=\"Master_tblSectionDiv1\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        String sContractID = "";
        String sCustomerID = "";
        String sProjectName = doc.select("h1#Master_IdPageHeaderTitle").text();
        Elements divs = doc.select("div#Master_tblSectionDiv1");
        int i = 0;
        for (Element div : divs) {
          System.out.println(String.valueOf(i) + ": Element found " + sProjectName);
          String sProjectID = div.select("div#ProjectId").select("span").text();
          String sProjectManager = div.select("div#ProjectManager").select("a").text();
          String sProjectManagerURL = div.select("div#ProjectManager").select("a").attr("href");
          String sContract = div.select("div#Engagement").select("a").text();
          String sContractURL = div.select("div#Engagement").select("a").attr("href");
          String sCustomer = div.select("div#Customer").select("a").text();
          String sCustomerURL = div.select("div#Customer").select("a").attr("href");
          String sStatus = div.select("div#Status").select("span").text();
          String sType = div.select("div#Type").select("span").text();
          String sBillable = div.select("div#Billable").select("span").text();
          String sPhase = div.select("div#ProposedPhase").select("span").text();
          sProjectManagerID = getURLValue(sProjectManagerURL, "u={", 36);
          sContractID = getURLValue(sContractURL, "sEngageId={", 36);
          sCustomerID = getURLValue(sCustomerURL, "CustId={", 36);
          project dbp = new project();
          dbp.setProjectname(sProjectName);
          dbp.setIdproject(sIDProject);
          dbp.setProjectID(sProjectID);
          dbp.setProjectManager(sProjectManager);
          dbp.setIdpm(sProjectManagerID);
          dbp.setContractno(sContract);
          dbp.setContractid(sContractID);
          dbp.setClient(sCustomer);
          dbp.setClientid(sCustomerID);
          dbp.setProjectStatus(sStatus);
          dbp.setProjectType(sType);
          dbp.setBillable(sBillable);
          dbp.setProposedPhase(sPhase);
          dbp.dbRefreshProfile();
          i++;
        } 
        System.out.println(String.valueOf(i) + ": END " + sProjectName);
        project pject = new project();
        pject.dbCleanUp();
        System.gc();
      } else {
        initDriver();
        viewProjectDetails(sIDProject);
      } 
    } catch (Exception e1) {
      System.out.println("URL: " + sURL);
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        viewProjectDetails(sIDProject);
      } 
    } 
  }
  
  public static void viewTaskDetails() {
    System.out.println("Executing viewTaskDetails");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idtask` from `timesheet` inner join projecthealth on timesheet.idproject=projecthealth.idproject where projecthealth.ProjectStatus not in ('Closed','Completed') AND (`timesheet`.`projectname` not like 'TXR%' AND `timesheet`.`projectname` not like 'SSR%' AND `timesheet`.`projectname` not like 'ISR_%') group by `timesheet`.`idtask` order by `timesheet`.`idtask`";
    String sTaskID = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int i = 1;
      while (rs.next()) {
        sTaskID = rs.getString(1);
        if (sTaskID.length() == 36) {
          System.out.println("Retrieving Task Profile for " + sTaskID);
          viewTaskDetails(sTaskID);
        } else {
          System.out.println("Invalid Task Profile for " + sTaskID);
        } 
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (Exception exception) {
    
    } finally {
      System.gc();
    } 
  }
  
  public static void viewTaskDetailsAll() {
    System.out.println("Executing viewTaskDetails");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idtask` from `task` where (`projectname` not like 'TXR%' AND `projectname` not like 'SSR%' AND `projectname` not like 'ISR_%') group by `idtask` order by `idtask` ";
    String sTaskID = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int i = 1;
      while (rs.next()) {
        sTaskID = rs.getString(1);
        if (sTaskID.length() == 36) {
          System.out.println("Retrieving Task Profile for " + sTaskID);
          viewTaskDetails(sTaskID);
        } else {
          System.out.println("Invalid Task Profile for " + sTaskID);
        } 
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (Exception exception) {
    
    } finally {
      System.gc();
    } 
  }
  
  public static void viewContractDetails() {
    System.out.println("Executing viewContractDetails");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idcontract` from `contract` where status <> 'Closed'";
    String sContractID = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int i = 1;
      while (rs.next()) {
        sContractID = rs.getString(1);
        if (sContractID.length() == 36) {
          System.out.println("Retrieving Contract Profile for " + sContractID);
          viewContractDetails(sContractID);
        } else {
          System.out.println("Invalid Contract Profile for " + sContractID);
        } 
        i++;
      } 
      contract.dbCleanUp();
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (Exception exception) {
    
    } finally {
      System.gc();
    } 
  }
  
  public static void viewContractDetails(String sContractID) {
    String sContent = "";
    String sTaskName = "";
    String sIDProject = "";
    try {
      String sURL = "https://ppms.ap.dimensiondata.com/core/contact/frEngagementInfo.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&sEngageId={" + sContractID + "}";
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(3L, TimeUnit.SECONDS)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By css = By.cssSelector("div[id=\"Master_tblContent1\"]");
      WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
      sContent = gdriver.getPageSource();
      Document doc = null;
      doc = Jsoup.parse(sContent);
      String sContractNumber = doc.select("h1[id=\"Master_IdPageHeaderTitle\"]").text();
      String sBillingOffice = doc.select("div[id=\"BillingOffice\"]").select("span").text();
      String sStatus = doc.select("div[id=\"EngagementStatus\"]").select("span").text();
      String sContractValue = "0";
      String sCurrency = "";
      String sTotalRR = "0";
      String sTotalCR = "0";
      String sTotalPCTD = "0";
      try {
        sContractValue = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(0)).text();
        sCurrency = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(1)).text();
        sTotalRR = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(2)).text();
        sTotalCR = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(3)).text();
        sTotalPCTD = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(4)).text();
      } catch (Exception ec) {
        System.out.println(ec.getMessage());
      } 
      String sProjectName = "";
      String sIDPM = "";
      String sPMName = "";
      String sBillable = "";
      String sProjectStatus = "";
      try {
        Element tb = doc.select("table[id=\"RelatedProjects_tblMain\"]").first();
        Element tbody = tb.select("tbody").first();
        Element tr = tbody.selectFirst("tr");
        Elements tds = tr.select("td");
        int index = 0;
        for (Element td : tds) {
          switch (index) {
            case 0:
              sIDProject = td.select("a").attr("href");
              sProjectName = td.select("a").text();
              if (!sIDProject.isEmpty())
                sIDProject = getURLValue(sIDProject, "ProjectId={", 36); 
              break;
            case 1:
              sIDPM = td.select("a").attr("href");
              sPMName = td.select("a").text();
              if (!sIDPM.isEmpty())
                sIDPM = getURLValue(sIDPM, "u={", 36); 
              break;
            case 2:
              sProjectStatus = td.text();
              break;
            case 4:
              sBillable = td.select("img").attr("src");
              break;
          } 
          index++;
        } 
      } catch (Exception exception) {}
      String sClosedDate = "";
      Element cf = doc.select("div[id=\"Master_cphBody_divContentUdf3\"]").first();
      try {
        sClosedDate = ((Element)cf.select("div[id*=\"ctrl:EngagementText\"]").get(1)).text();
      } catch (Exception ec) {
        System.out.println(ec.getMessage());
      } 
      if (!sContractNumber.isEmpty() && 
        sContractNumber.length() > 0) {
        contract ct = new contract();
        ct.setIdcontract(sContractID);
        if (sIDProject.length() == 0) {
          project pj = new project();
          sIDProject = project.queryIDProjectByIDContract(sContractID);
          if (sIDProject.length() == 0)
            sIDProject = project.queryIDRequestByIDContract(sContractID); 
        } 
        ct.setIdproject(sIDProject);
        ct.setStatus(sStatus);
        ct.setContractservicevalue(sContractValue);
        ct.setPlannedCost(sTotalPCTD);
        ct.setRevenueRecognized(sTotalRR);
        ct.setCostRecognized(sTotalCR);
        ct.setCurrency(sCurrency);
        ct.setIdpm(sIDPM);
        ct.setCloseddate(sClosedDate);
        ct.dbUpdateContract();
      } 
      System.gc();
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        viewContractDetails(sContractID);
      } 
    } 
  }
  
  public static void viewTaskDetails(String sIDTask) {
    String sContent = "";
    String sTaskName = "";
    String sIDProject = "";
    String sURL = "";
    try {
      sURL = "https://ppms.ap.dimensiondata.com/core/views/vwTaskDetail.asp?rid=" + grid + "&sno=" + gsno + "&ui=W&sTaskId={" + sIDTask + "}&CoMgrandSumMgrFlag=1111115";
      gdriver.get(sURL);
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(3L, TimeUnit.SECONDS)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("div[id=\"Master_IdDivContainer\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        sTaskName = doc.select("input[id=\"TaskName\"]").attr("value");
        sIDProject = doc.select("input[id=\"ProjId\"]").attr("value");
        if (sIDProject != null) {
          sIDProject = sIDProject.replaceAll("\\{", "");
          sIDProject = sIDProject.replaceAll("\\}", "");
          sIDProject = sIDProject.toUpperCase();
        } 
        String sBillable = "No";
        String sSOItem = "No";
        String sCompleted = "No";
        Elements divs = doc.select("div#Master_IdDivContainer");
        int i = 0;
        for (Element div : divs) {
          Elements spans = div.select("span");
          int index = 0;
          for (Element span : spans) {
            switch (index) {
              case 1:
                sBillable = span.text();
                break;
              case 2:
                sSOItem = span.text();
                break;
              case 3:
                sCompleted = span.text();
                break;
            } 
            index++;
          } 
          task dbt = new task();
          dbt.setBillable(sBillable);
          dbt.setSOItem(sSOItem);
          dbt.setCompleted(sCompleted);
          dbt.setTaskname(sTaskName);
          dbt.setIdproject(sIDProject);
          dbt.setIdtask(sIDTask);
          dbt.dbUpdateProfileTask();
          i++;
        } 
        System.out.println(String.valueOf(i) + ": END " + sIDTask + "-" + sTaskName);
        System.gc();
      } else {
        initDriver();
        viewTaskDetails(sIDTask);
      } 
    } catch (Exception e1) {
      System.out.println("sURL: " + sURL);
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        viewTaskDetails(sIDTask);
      } 
    } 
  }
  
  public static void reportProgressByProject() {
    System.out.println("Executing reportProgressByProject");
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idproject`, `projectname` from `projecthealth` where `projectstatus`='Active' order by `id` desc";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      int total = rs.getFetchSize();
      int i = 1;
      while (rs.next()) {
        System.out.println("Updating Task for " + rs.getString(1) + " | " + rs.getString(2));
        reportProgressByProject(rs.getString(1));
        i++;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } finally {
      System.gc();
    } 
  }
  
  public static void reportProgressByProject(String sIDProject) {
    String sContent = null;
    String sURL = "";
    try {
      sURL = "https://ppms.ap.dimensiondata.com/Reports/rpProjectProgress.asp?rid=" + grid + "&sno=" + gsno + "&ui=W&action=view&IncludeSubProject=true&projId={" + sIDProject + "}";
      gdriver.get(sURL);
      waitForReport();
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("class");
          if (tableclass.isEmpty()) {
            String sTempTaskName = "";
            String sTempTaskID = "";
            Elements rows = table.select("tr");
            int irow = 0;
            String sTaskName = "";
            String sTaskID = "";
            task dbTask = new task();
            dbTask.setIdpm(sProjectManagerID);
            for (Element row : rows) {
              Elements tds = row.select("td");
              boolean isDataRow = true;
              int iCol = 0;
              dbTask.setIdproject(sIDProject);
              for (Element td : tds) {
                if (isDataRow) {
                  String sClass = td.attr("class");
                  if (sClass.isEmpty()) {
                    isDataRow = false;
                  } else if (sClass.equals("TableList1")) {
                    task ts = new task();
                    String sValue = td.text();
                    if (iCol == 0) {
                      sTempTaskName = sValue;
                      if (!sTempTaskName.isEmpty()) {
                        sTaskName = sTempTaskName;
                        String ahref = td.select("a").attr("href");
                        int sloc = ahref.indexOf("sTaskId=") + 9;
                        sTempTaskID = ahref.substring(sloc, sloc + 36);
                        sTaskID = sTempTaskID;
                      } 
                      dbTask.setTaskname(sTaskName);
                      dbTask.setIdtask(sTaskID);
                    } else if (iCol == 1) {
                      String ahref = td.select("a").attr("href");
                      int sloc = ahref.indexOf("u=") + 3;
                      String sEmployeID = ahref.substring(sloc, sloc + 36);
                      dbTask.setIdemployee(sEmployeID);
                    } else if (iCol == 2) {
                      dbTask.setPstart(sValue);
                    } else if (iCol == 3) {
                      dbTask.setPend(sValue);
                    } else if (iCol == 4) {
                      dbTask.setPhour(sValue);
                    } else if (iCol == 5) {
                      dbTask.setFstart(sValue);
                    } else if (iCol == 6) {
                      dbTask.setFend(sValue);
                    } else if (iCol == 7) {
                      dbTask.setAstart(sValue);
                    } else if (iCol == 8) {
                      dbTask.setAend(sValue);
                    } else if (iCol == 9) {
                      dbTask.setFhour(sValue);
                      dbTask.setAhour(sValue);
                    } else if (iCol == 10) {
                      dbTask.setRhour(sValue);
                    } else if (iCol == 11) {
                      dbTask.setThour(sValue);
                    } else if (iCol == 12) {
                      dbTask.setPcomplete(sValue);
                    } 
                  } else {
                    isDataRow = false;
                  } 
                } 
                iCol++;
              } 
              if (isDataRow) {
                System.out.println(String.valueOf(irow) + ":" + row.text());
                dbTask.dbLoadTask();
              } 
              irow++;
            } 
          } else if (tableclass.equals("SummaryHead")) {
            String sProjectManagerName = "";
            Elements rows = table.select("tr");
            int irow = 0;
            for (Element row : rows) {
              if (irow == 1) {
                Elements tds = row.select("td");
                int iCol = 0;
                for (Element td : tds) {
                  if (iCol == 1) {
                    sProjectManagerName = td.text();
                    sProjectManagerID = employee.queryIDEmployee(sProjectManagerName);
                  } 
                  iCol++;
                } 
              } 
              irow++;
            } 
          } 
          i++;
        } 
        project pject = new project();
        pject.dbCleanUp();
        System.gc();
      } else {
        initDriver();
        reportProgressByProject(sIDProject);
      } 
    } catch (Exception e1) {
      System.out.println("URL: " + sURL);
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        reportProgressByProject(sIDProject);
      } 
    } 
  }
  
  public static void reportProjectProfitability() {
    System.out.println("Executing reportProjectProfitability");
    try {
      String sURL = "https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ReportId={3B610E7A-7272-4E33-8572-5F7132404141}&bypass=true";
      gdriver.get(sURL);
      System.out.println(sURL);
      waitForReport();
      String sContent = gdriver.getPageSource();
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(60L, TimeUnit.MINUTES)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("table[id*=\"tblList\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("id");
          if (!tableclass.isEmpty() && 
            tableclass.contains("_tblMain")) {
            Elements trs = table.select("tbody").select("tr");
            System.out.println("There are " + trs.size() + " records found.");
            for (Element tr : trs) {
              project pr = new project();
              String sProjectID = tr.attr("p0").toUpperCase();
              Elements tds = tr.select("td");
              int itd = 1;
              pr.setIdproject(sProjectID);
              for (Element td : tds) {
                String sValue = td.attr("cv");
                if (!sValue.isEmpty())
                  sValue = sValue.trim(); 
                switch (itd) {
                  case 18:
                    pr.setPOCP(sValue);
                    break;
                  case 19:
                    pr.setTotalMaterialCost(sValue);
                    break;
                  case 20:
                    pr.setSAPPlannedRevenue(sValue);
                    break;
                  case 21:
                    pr.setSAPPlannedRevenueUSD(sValue);
                    break;
                  case 22:
                    pr.setSAPPlannedExternalCost(sValue);
                    break;
                  case 23:
                    pr.setPlannedInternalCostB0(sValue);
                    break;
                  case 24:
                    pr.setPlannedInternalCostB1(sValue);
                    break;
                  case 25:
                    pr.setPlannedInternalCostA(sValue);
                    break;
                  case 26:
                    pr.setYTDActualRevRec(sValue);
                    break;
                  case 27:
                    pr.setYTDActualRevRecP(sValue);
                    break;
                  case 28:
                    pr.setActualExternalCosttoDate(sValue);
                    break;
                  case 29:
                    pr.setActualInternalCosttoDate(sValue);
                    break;
                  case 30:
                    pr.setTotalActualCosttoDate(sValue);
                    break;
                  case 31:
                    pr.setTotalDerivedInternalCosttoDate(sValue);
                    break;
                  case 32:
                    pr.setTotalDerivedActualCosttoDate(sValue);
                    break;
                  case 33:
                    pr.setSAPDerivedGMB0(sValue);
                    break;
                  case 34:
                    pr.setSAPDerivedGMUSDB0(sValue);
                    break;
                  case 35:
                    pr.setSAPDerivedGMPB0(sValue);
                    break;
                  case 36:
                    pr.setSAPDerivedGMB1(sValue);
                    break;
                  case 37:
                    pr.setSAPDerivedGMUSDB1(sValue);
                    break;
                  case 38:
                    pr.setSAPDerivedGMPB1(sValue);
                    break;
                  case 39:
                    pr.setTotalDerivedRemainingCost(sValue);
                    break;
                  case 40:
                    pr.setTotalDerivedRemainingGP(sValue);
                    break;
                  case 41:
                    pr.setTotalDerivedRemainingGPP(sValue);
                    break;
                  case 42:
                    pr.setTotalEstimatedGMatCompletion(sValue);
                    break;
                  case 43:
                    pr.setTotalEstimatedGMatCompletionUSD(sValue);
                    break;
                  case 44:
                    pr.setTotalEstimatedGMatCompletionP(sValue);
                    break;
                  case 45:
                    pr.setProfitabilitywithintolerance(sValue);
                    break;
                  case 46:
                    pr.setReasonfornotonbudgetmainclassification(sValue);
                    break;
                  case 47:
                    pr.setReasonfornotonbudgetsubclassification(sValue);
                    break;
                } 
                itd++;
              } 
              pr.dbUpdateProfitability();
            } 
            System.out.println(String.valueOf(trs.size()) + " records processed");
          } 
          i++;
        } 
        System.gc();
      } else {
        initDriver();
        reportProjectProfitability();
      } 
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
    } 
  }
  
  public static void reportProjectHealth() {
    System.out.println("Executing reportProjectHealth");
    try {
      String sURL = "https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ReportId={B8FD6FE3-135C-4ED6-9260-9B8D16DEB76C}&bypass=true";
      gdriver.get(sURL);
      System.out.println(sURL);
      waitForReport();
      String sContent = gdriver.getPageSource();
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(60L, TimeUnit.MINUTES)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("table[id*=\"tblList\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("id");
          if (!tableclass.isEmpty() && 
            tableclass.contains("_tblMain")) {
            Elements trs = table.select("tbody").select("tr");
            System.out.println("There are " + trs.size() + " records found.");
            for (Element tr : trs) {
              project pr = new project();
              String sProjectID = tr.attr("p0").toUpperCase();
              Elements tds = tr.select("td");
              int itd = 1;
              pr.setIdproject(sProjectID);
              for (Element td : tds) {
                String sValue = td.attr("cv");
                if (!sValue.isEmpty())
                  sValue = sValue.trim(); 
                switch (itd) {
                  case 1:
                    pr.setBillingOffice(sValue);
                    break;
                  case 2:
                    pr.setProjectID(sValue);
                    break;
                  case 3:
                    pr.setWBSElement(sValue);
                    break;
                  case 4:
                    pr.setProjectname(sValue);
                    break;
                  case 5:
                    pr.setProjectStatus(sValue);
                    break;
                  case 6:
                    pr.setProjectClassification(sValue);
                    break;
                  case 7:
                    pr.setProjectType(sValue);
                    break;
                  case 8:
                    pr.setClient(sValue);
                    break;
                  case 9:
                    pr.setBillable(sValue);
                    break;
                  case 10:
                    pr.setProjectManagersHealthAssessment(sValue);
                    break;
                  case 11:
                    pr.setSystemGeneratedHealthAssessment(sValue);
                    break;
                  case 12:
                    pr.setSystemGeneratedMetrics(sValue);
                    break;
                  case 13:
                    pr.setProjectManager(sValue);
                    break;
                  case 14:
                    pr.setSONumber(sValue);
                    break;
                  case 15:
                    pr.setProposedPhase(sValue);
                    break;
                  case 16:
                    pr.setBaselinedEndDate(sValue);
                    break;
                  case 17:
                    pr.setProjectCreationDate(sValue);
                    break;
                  case 18:
                    pr.setProjectClosedDate(sValue);
                    break;
                  case 19:
                    pr.setContractClosedDate(sValue);
                    break;
                  case 20:
                    pr.setLateDays(sValue);
                    break;
                  case 21:
                    pr.setCompleteeffort(sValue);
                    break;
                  case 22:
                    pr.setProjectDescription(sValue);
                    break;
                  case 23:
                    pr.setReleaseToSAP(sValue);
                    break;
                  case 24:
                    pr.setIncludesConsulting(sValue);
                    break;
                  case 25:
                    pr.setCompanyCodeCurrency(sValue);
                    break;
                  case 26:
                    pr.setContractServiceValue(sValue);
                    break;
                  case 27:
                    pr.setContractServiceValueUSD(sValue);
                    break;
                  case 28:
                    pr.setBaseline0(sValue);
                    break;
                  case 29:
                    pr.setBaseline1(sValue);
                    break;
                  case 30:
                    pr.setEAC(sValue);
                    break;
                  case 31:
                    pr.setTotalDeliverableMilestones(sValue);
                    break;
                  case 32:
                    pr.setCompletedDeliverableMilestones(sValue);
                    break;
                  case 33:
                    pr.setTotalPaymentMilestones(sValue);
                    break;
                  case 34:
                    pr.setBehindSchedule(sValue);
                    break;
                  case 35:
                    pr.setTotalChanges(sValue);
                    break;
                  case 36:
                    pr.setClosedChanges(sValue);
                    break;
                  case 37:
                    pr.setEscalatedChanges(sValue);
                    break;
                  case 38:
                    pr.setTotalRisks(sValue);
                    break;
                  case 39:
                    pr.setClosedRisks(sValue);
                    break;
                  case 40:
                    pr.setEscalatedRisks(sValue);
                    break;
                  case 41:
                    pr.setTotalIssues(sValue);
                    break;
                  case 42:
                    pr.setClosedIssues(sValue);
                    break;
                  case 43:
                    pr.setEscalatedIssues(sValue);
                    break;
                } 
                itd++;
              } 
              pr.dbRefreshData();
            } 
            System.out.println(String.valueOf(trs.size()) + " records processed");
          } 
          i++;
        } 
        System.gc();
      } else {
        initDriver();
        reportProjectHealth();
      } 
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
    } 
  }
  
  
  public static void waitForReport() {
	  
	  System.out.print("Report Downloading : ");
	  FluentWait<WebDriver> wait = (new FluentWait(gdriver))
       	      .withTimeout(5L, TimeUnit.SECONDS)
       	      .pollingEvery(1L, TimeUnit.SECONDS)
       	      .ignoring(NoSuchElementException.class);
	    boolean isWaiting=true;
	    while (isWaiting) {
	    	try {
	    		//pause(5);
	    		wait = (new FluentWait(gdriver))
	    	    	      .withTimeout(5L, TimeUnit.SECONDS)
	    	    	      .pollingEvery(1L, TimeUnit.SECONDS)
	    	    	      .ignoring(NoSuchElementException.class);
	    	By cssWait = By.cssSelector("#divWaitMsg");
	    	WebElement spanWait = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(cssWait));
	    	System.out.print(".");	    	
	    	} catch (Exception e) {
	    		System.out.println("Downloaded");
	    		isWaiting=false;
	    	}
	    } 
	    wait = null;	  	    
	    
  }
  public static void reportTraxHealth() {
    String sContent = "";
    try {
    	 FluentWait<WebDriver> wait = (new FluentWait(gdriver))
       	      .withTimeout(5L, TimeUnit.SECONDS)
       	      .pollingEvery(1L, TimeUnit.SECONDS)
       	      .ignoring(NoSuchElementException.class);
    	 
      String sURL = "https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ReportId={247F3E2D-FE0A-4558-9C96-C729DCCE0994}&bypass=true";
      gdriver.get(sURL);
      System.out.println(sURL);
     
      waitForReport();
	  
	    sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
       wait = (new FluentWait(gdriver))
          .withTimeout(60L, TimeUnit.MINUTES)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("table[id*=\"_tblMain\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("id");
          if (!tableclass.isEmpty() && 
            tableclass.contains("_tblMain")) {
            Elements trs = table.select("tbody").select("tr");
            System.out.println("There are " + trs.size() + " records found.");
            for (Element tr : trs) {
              project pr = new project();
              String sProjectID = tr.attr("p1").toUpperCase();
              String sTaskID = tr.attr("p2").toUpperCase();
              Elements tds = tr.select("td");
              int itd = 0;
              pr.setIdproject(sProjectID);
              pr.setIdrequest(sTaskID);
              for (Element td : tds) {
                String sValue = td.attr("cv");
                if (!sValue.isEmpty())
                  sValue = sValue.trim(); 
                switch (itd) {
                  case 0:
                    pr.setBillingOffice(sValue);
                    break;
                  case 3:
                    pr.setSONumber(sValue);
                    break;
                  case 4:
                    pr.setClient(sValue);
                    break;
                  case 5:
                    pr.setProjectID(sValue);
                    break;
                  case 6:
                    pr.setProjectDescription(sValue);
                    break;
                  case 7:
                    pr.setProjectStatus(sValue);
                    break;
                  case 9:
                    pr.setBillable(sValue);
                    break;
                  case 10:
                    pr.setReleaseToSAP(sValue);
                    break;
                  case 11:
                    pr.setProjectCreationDate(sValue);
                    pr.setContractCreationDate(sValue);
                    break;
                  case 12:
                    pr.setProjectClosedDate(sValue);
                    pr.setContractClosedDate(sValue);
                    break;
                  case 13:
                    pr.setProjectname(sValue);
                    break;
                  case 14:
                    pr.setProjectname(String.valueOf(pr.getProjectname()) + " " + sValue);
                    break;
                  case 15:
                    pr.setRequestCreationDate(sValue);
                    break;
                  case 17:
                    pr.setAssignedresource(sValue);
                    break;
                  case 18:
                    pr.setWorkflowStatus(sValue);
                    break;
                  case 19:
                    pr.setRequestFinishDate(sValue);
                    break;
                  case 20:
                    pr.setRequestClosedDate(sValue);
                    break;
                  case 21:
                    pr.setCompanyCodeCurrency(sValue);
                    break;
                  case 22:
                    pr.setContractServiceValue(sValue);
                    break;
                  case 23:
                    pr.setContractServiceValueUSD(sValue);
                    break;
                  case 24:
                    pr.setBaseline1(sValue);
                    break;
                  case 25:
                    pr.setBaseline0(sValue);
                    break;
                  case 26:
                    pr.setLateDays(sValue);
                    break;
                  case 27:
                    pr.setPlannedInternalCostB0(sValue);
                    break;
                  case 28:
                    pr.setTotalActualCosttoDate(sValue);
                    break;
                  case 29:
                    pr.setTotalDerivedRemainingCost(sValue);
                    break;
                  case 33:
                    pr.setProfitabilitywithintolerance(sValue);
                    break;
                } 
                itd++;
              } 
              pr.dbTraxRefreshData();
              String sProjectStatus = pr.getProjectStatus();
              if (!sProjectStatus.equals("Closed"))
                viewRequestDetail(sProjectID, sTaskID); 
            } 
            System.out.println(String.valueOf(trs.size()) + " records processed");
          } 
          i++;
        } 
        System.gc();
      } else {
        initDriver();
        reportTraxHealth();
      } 
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        reportTraxHealth();
      } 
    } 
  }
  
  public static void reportTraxActive() {
    String sContent = "";
    try {
      String sURL = "https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ReportId={F1EE7931-44E3-486D-BFA4-26A35C9FF0EC}&bypass=true";
      gdriver.get(sURL);
      System.out.println(sURL);
      waitForReport();
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(60L, TimeUnit.MINUTES)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("table[id*=\"_tblMain\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("id");
          if (!tableclass.isEmpty() && 
            tableclass.contains("_tblMain")) {
            Elements trs = table.select("tbody").select("tr");
            System.out.println("There are " + trs.size() + " records found.");
            for (Element tr : trs) {
              task ts = new task();
              String sProjectID = tr.attr("pid").toUpperCase();
              String sTaskID = tr.attr("p0").toUpperCase();
              Elements tds = tr.select("td");
              int itd = 0;
              ts.setIdproject(sProjectID);
              ts.setIdtask(sTaskID);
              for (Element td : tds) {
                String sValue = td.attr("cv");
                if (!sValue.isEmpty())
                  sValue = sValue.trim(); 
                switch (itd) {
                  case 8:
                    ts.setEname(td.text().trim());
                    break;
                  case 10:
                    ts.setPhour(sValue);
                    break;
                  case 11:
                    ts.setAhour(sValue);
                    break;
                } 
                itd++;
              } 
              if (!ts.getEname().isEmpty() && 
                ts.getEname().length() > 0)
                ts.dbUpdateTaskTXR(); 
            } 
            System.out.println(String.valueOf(trs.size()) + " records processed");
          } 
          i++;
        } 
        dbCleanUp();
        System.gc();
      } else {
        initDriver();
        reportTraxActive();
      } 
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        reportTraxActive();
      } 
    } 
  }
  
  public static void pause(int iSeconds) {
	  try {
	        Thread.sleep(iSeconds * 1000);
	    
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      } 
  }
  
  public static void reportContractByClient() {
    String sContent = "";
    try {
      String sURL = "https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ReportId={CE6655FD-CEEC-431D-A128-F1822E6499C6}&bypass=true";
      gdriver.get(sURL);
      System.out.println(sURL);
      waitForReport();
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(60L, TimeUnit.MINUTES)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        
        By css = By.cssSelector("table[id*=\"_tblMain\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("id");
          if (!tableclass.isEmpty() && 
            tableclass.contains("_tblMain")) {
            Elements trs = table.select("tbody").select("tr");
            System.out.println("There are " + trs.size() + " records found.");
            for (Element tr : trs) {
              contract ct = new contract();
              String sIdClient = tr.attr("pid").toUpperCase();
              String sIdContract = tr.attr("p0").toUpperCase();
              Elements tds = tr.select("td");
              int itd = 0;
              ct.setIdclient(sIdClient);
              ct.setIdcontract(sIdContract);
              for (Element td : tds) {
                String sValue = td.attr("cv");
                if (!sValue.isEmpty())
                  sValue = sValue.trim(); 
                switch (itd) {
                  case 0:
                    ct.setBillingoffice(sValue);
                    break;
                  case 1:
                    ct.setClientname(sValue);
                    break;
                  case 2:
                    ct.setContractnumber(sValue);
                    break;
                  case 3:
                    ct.setStatus(sValue);
                    break;
                  case 4:
                    ct.setBillable(sValue);
                    break;
                  case 5:
                    ct.setCreatedby(sValue);
                    break;
                  case 6:
                    ct.setCreatedon(sValue);
                    break;
                  case 7:
                    ct.setUpdatedby(sValue);
                    break;
                  case 8:
                    ct.setUpdatedon(sValue);
                    break;
                } 
                itd++;
              } 
              ct.dbLoadContract();
            } 
            System.out.println(String.valueOf(trs.size()) + " records processed");
          } 
          i++;
        } 
        System.gc();
      } else {
        initDriver();
        reportContractByClient();
      } 
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        reportContractByClient();
      } 
    } 
  }
  
  public static void reportSOItems() {
    String sContent = "";
    try {
      System.out.println("Executing reportSOItems");
      String sURL = "https://ppms.ap.dimensiondata.com/ReportExecEngine/ReportDetail.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&ReportId={6D80EC8B-67CB-4251-BE8F-6166460998A2}&bypass=true&LinkFromProfile=false";
      gdriver.get(sURL);
      waitForReport();
      sContent = gdriver.getPageSource();
      if (!isSessionInvalid(sContent)) {
        FluentWait<WebDriver> wait = (new FluentWait(gdriver))
          .withTimeout(60L, TimeUnit.MINUTES)
          .pollingEvery(1L, TimeUnit.SECONDS)
          .ignoring(NoSuchElementException.class);
        By css = By.cssSelector("table[id*=\"_tblMain\"]");
        WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
        sContent = gdriver.getPageSource();
        Document doc = null;
        doc = Jsoup.parse(sContent);
        String sProjectManagerID = "";
        employee dbEp = new employee();
        Elements tables = doc.select("table");
        int i = 0;
        for (Element table : tables) {
          String tableclass = table.attr("id");
          if (!tableclass.isEmpty() && 
            tableclass.contains("_tblMain")) {
            Elements trs = table.select("tbody").select("tr");
            System.out.println("There are " + trs.size() + " records found.");
            for (Element tr : trs) {
              soitem si = new soitem();
              String sIdSOItem = tr.attr("id").toUpperCase();
              String sIdContract = tr.attr("pid").toUpperCase();
              Elements tds = tr.select("td");
              int itd = 0;
              si.setIdsoitem(sIdSOItem);
              si.setIdcontract(sIdContract);
              for (Element td : tds) {
                String sValue = td.attr("cv");
                if (!sValue.isEmpty())
                  sValue = sValue.trim(); 
                switch (itd) {
                  case 0:
                    si.setContractnumber(sValue);
                    break;
                  case 1:
                    si.setContractstatus(sValue);
                    break;
                  case 2:
                    si.setCompanycode(sValue);
                    break;
                  case 4:
                    si.setSonumber(sValue);
                    break;
                  case 5:
                    si.setSoitem(sValue);
                    break;
                  case 6:
                    si.setWbselement(sValue);
                    break;
                  case 7:
                    si.setNetworknumber(sValue);
                    break;
                  case 8:
                    si.setSoldto(sValue);
                    break;
                  case 9:
                    si.setShipto(sValue);
                    break;
                  case 10:
                    si.setDateordercreation(sValue);
                    break;
                  case 11:
                    si.setProfitcenter(sValue);
                    break;
                  case 12:
                    si.setLccurrency(sValue);
                    break;
                  case 13:
                    si.setLcrevenue(sValue);
                    break;
                  case 14:
                    si.setLccost(sValue);
                    break;
                  case 15:
                    si.setDccurrency(sValue);
                    break;
                  case 16:
                    si.setDcrevenue(sValue);
                    break;
                  case 17:
                    si.setDccost(sValue);
                    break;
                  case 18:
                    si.setCreatedby(sValue);
                    break;
                  case 19:
                    si.setMatgroup(sValue);
                    break;
                  case 20:
                    si.setMatgroupdesc(sValue);
                    break;
                  case 21:
                    si.setMpn(sValue);
                    break;
                  case 22:
                    si.setPoclientnumber(sValue);
                    break;
                  case 23:
                    si.setSalesoffice(sValue);
                    break;
                  case 24:
                    si.setSalesgroup(sValue);
                    break;
                  case 25:
                    si.setProcurementnotes(sValue);
                    break;
                  case 26:
                    si.setClientnotes(sValue);
                    break;
                  case 27:
                    si.setClassification(sValue);
                    break;
                } 
                itd++;
              } 
              si.dbLoadSOItem();
            } 
            System.out.println(String.valueOf(trs.size()) + " records processed");
          } 
          i++;
        } 
        System.gc();
      } else {
        initDriver();
        reportSOItems();
      } 
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        reportSOItems();
      } 
    } finally {
      System.out.println("Completed reportSOItems");
    } 
  }
  
  public static void viewRequestDetail(String sIDProject, String sRequestID) {
    String sContent = "";
    try {
      String sURL = "https://ppms.ap.dimensiondata.com/HelpDesk/frRequestInfo.aspx?rid=" + grid + "&sno=" + gsno + "&ui=W&reqId={" + sRequestID + "}";
      gdriver.get(sURL);
      System.out.println(sURL);
      sContent = gdriver.getPageSource();
      FluentWait<WebDriver> wait = (new FluentWait(gdriver))
        .withTimeout(3L, TimeUnit.SECONDS)
        .pollingEvery(1L, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
      By css = By.cssSelector("div[id*=\"Master_tblContent1\"]");
      WebElement element = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated(css));
      sContent = gdriver.getPageSource();
      Document doc = null;
      doc = Jsoup.parse(sContent);
      String sRequestName = doc.select("title").attr("id", "Master_MasterPageTitle").text();
      System.out.println("sRequestName=" + sRequestName);
      String sTaskStatus = doc.getElementById("RequestStatus").select("span").text();
      String sContractName = doc.getElementById("RequestEngagment").select("a").text();
      String sIdpm = "";
      String sPMName = "";
      try {
        Element pm = doc.getElementById("RequestAssignee");
        sPMName = pm.select("a").text();
        String sPMUrl = pm.select("a").attr("href");
        if (!sPMUrl.isEmpty())
          sIdpm = getURLValue(sPMUrl, "U={", 36); 
      } catch (Exception exception) {}
      System.out.println("Task Status=" + sTaskStatus);
      Elements trs = doc.getElementById("ResourceDemandInformation_tblMain").select("tbody").first().select("tr");
      System.out.println("There are " + trs.size() + " records found.");
      for (Element tr : trs) {
        task ts = new task();
        String sIdEmployee = "";
        Elements tds = tr.select("td");
        boolean isValid = false;
        int itd = 0;
        for (Element td : tds) {
          String sEngineerName, sEngineerURL, sValue = td.attr("cv");
          if (!sValue.isEmpty())
            sValue = sValue.trim(); 
          ts.setIdtask(sRequestID);
          ts.setIdproject(sIDProject);
          ts.setTaskname(sRequestName);
          ts.setIdpm(sIdpm);
          ts.setPmname(sPMName);
          if (!sTaskStatus.isEmpty())
            if (sTaskStatus.contains("Closed")) {
              ts.setCompleted("Yes");
              ts.setProjectstatus("Completed");
            } else {
              ts.setCompleted("No");
              ts.setProjectstatus("Active");
            }  
          ts.setBillable("Yes");
          ts.setSOItem("Yes");
          switch (itd) {
            case 0:
              sEngineerName = td.select("a").text();
              sEngineerURL = td.select("a").attr("href");
              if (!sEngineerName.isEmpty()) {
                isValid = true;
                sIdEmployee = getURLValue(sEngineerURL, "u={", 36);
                ts.setIdemployee(sIdEmployee);
                ts.setEname(sEngineerName);
              } 
              break;
            case 3:
              ts.setPhour(sValue);
              break;
            case 4:
              ts.setPstart(sValue);
              break;
            case 5:
              ts.setPend(sValue);
              break;
          } 
          itd++;
        } 
        if (isValid) {
          ts.dbLoadTaskTXR();
          continue;
        } 
        System.out.println("Invalid task data");
      } 
      System.out.println(String.valueOf(trs.size()) + " records processed");
      System.gc();
    } catch (Exception e1) {
      System.out.println("LOAD TASK TXR:" + e1.getMessage());
      if (isSessionInvalid(sContent)) {
        initDriver();
        viewRequestDetail(sIDProject, sRequestID);
      } 
    } 
  }
  
  public static void initDriver() {
    gdriver = getDriver();
  }
  
  public static RemoteWebDriver getDriver() {
    RemoteWebDriver driver = null;
    try {
      try {
        if (gdriver != null) {
          gdriver.close();
          gdriver.quit();
        } else {
          System.out.println("getDriver is NULL");
        } 
      } catch (Exception e) {
        System.out.println("getDriver ERROR: " + e.getLocalizedMessage());
      } 
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
      driver.get("http://svc.sgpbiapp@global.ntt:NTTP@55w0rd2021@ppms.ap.dimensiondata.com/RP-STS_ISAPI/?wa=wsignin1.0&wtrealm=https%3A%2F%2Fppms.ap.dimensiondata.com%2F&wctx=rm%3D0%26id%3Dpassive%26ru%3D%252F");

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
      RemoteWebDriver remoteWebDriver = driver;
      String browserUrl = (String)remoteWebDriver.executeScript("return window.top.location.href.toString()", new Object[0]);
      System.out.println("Your browser URL is " + browserUrl);
      String s = browserUrl;
      int loc = s.indexOf("rId=");
      grid = s.substring(loc + 4, loc + 42);
      System.out.println(grid);
      int loc2 = s.indexOf("sno=");
      gsno = s.substring(loc2 + 4, loc2 + 42);
      System.out.println(gsno);
    } catch (Exception e) {
      System.out.println("getDriver END ERROR: " + e.getLocalizedMessage());
      System.out.println("getDriver END ERROR: " + e.getMessage());
    } 
    return driver;
  }
  
  public static void main(String[] args) {
    backupdatase();
    try {
      initDriver();       
      reportProgressByProject();
      ApachePOIExcelRead.loadfile();
      viewResourceTreeSingapore();
      timesheetRefresh();
      dbCleanUp();
      reportProjectHealth();
      reportProjectProfitability();
      reportProgressByProject();
      dbCleanUp();
      viewProjectDetails();
      viewContractDetails();
      reportTraxHealth(); //OK
      reportTraxActive(); //OK
      reportContractByClient();//ok
      viewTaskDetails();
      viewProjectHealthDetails();
      reportSOItems(); //ok
      project.updateProjectSO();
      //download report
      
    } finally {
      dbCleanUp();
      gdriver.close();
      gdriver.quit();
    } 
  }
}
