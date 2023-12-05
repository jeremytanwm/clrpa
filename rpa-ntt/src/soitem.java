import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class soitem {
  public String id = "";
  
  public String idsoitem = "";
  
  public String idcontract = "";
  
  public String contractnumber = "";
  
  public String contractstatus = "";
  
  public String companycode = "";
  
  public String sonumber = "";
  
  public String soitem = "";
  
  public String wbselement = "";
  
  public String networknumber = "";
  
  public String soldto = "";
  
  public String shipto = "";
  
  public String shiptocustomer = "";
  
  public String dateordercreation = "";
  
  public String profitcenter = "";
  
  public String lccurrency = "";
  
  public String lcrevenue = "";
  
  public String lccost = "";
  
  public String dccurrency = "";
  
  public String dcrevenue = "";
  
  public String dccost = "";
  
  public String createdby = "";
  
  public String matgroup = "";
  
  public String matgroupdesc = "";
  
  public String mpn = "";
  
  public String poclientnumber = "";
  
  public String salesoffice = "";
  
  public String salesgroup = "";
  
  public String procurementnotes = "";
  
  public String clientnotes = "";
  
  public String classification = "";
  
  public String createdon = "";
  
  public String updatedon = "";
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getIdsoitem() {
    return this.idsoitem;
  }
  
  public void setIdsoitem(String idsoitem) {
    this.idsoitem = idsoitem;
  }
  
  public String getIdcontract() {
    return this.idcontract;
  }
  
  public void setIdcontract(String idcontract) {
    this.idcontract = idcontract;
  }
  
  public String getContractnumber() {
    return this.contractnumber;
  }
  
  public void setContractnumber(String contractnumber) {
    this.contractnumber = contractnumber;
  }
  
  public String getContractstatus() {
    return this.contractstatus;
  }
  
  public void setContractstatus(String contractstatus) {
    this.contractstatus = contractstatus;
  }
  
  public String getCompanycode() {
    return this.companycode;
  }
  
  public void setCompanycode(String companycode) {
    this.companycode = companycode;
  }
  
  public String getSonumber() {
    return this.sonumber;
  }
  
  public void setSonumber(String sonumber) {
    this.sonumber = sonumber;
  }
  
  public String getSoitem() {
    return this.soitem;
  }
  
  public void setSoitem(String str) {
    this.soitem = str;
  }
  
  public String getWbselement() {
    return this.wbselement;
  }
  
  public void setWbselement(String wbselement) {
    this.wbselement = wbselement;
  }
  
  public String getNetworknumber() {
    return this.networknumber;
  }
  
  public void setNetworknumber(String networknumber) {
    this.networknumber = networknumber;
  }
  
  public String getSoldto() {
    return this.soldto;
  }
  
  public void setSoldto(String soldto) {
    this.soldto = soldto;
  }
  
  public String getShipto() {
    return this.shipto;
  }
  
  public void setShipto(String shipto) {
    this.shipto = shipto;
  }
  
  public String getShiptocustomer() {
    return this.shiptocustomer;
  }
  
  public void setShiptocustomer(String shiptocustomer) {
    this.shiptocustomer = shiptocustomer;
  }
  
  public String getDateordercreation() {
    return this.dateordercreation;
  }
  
  public void setDateordercreation(String dateordercreation) {
    this.dateordercreation = dateordercreation;
  }
  
  public String getProfitcenter() {
    return this.profitcenter;
  }
  
  public void setProfitcenter(String profitcenter) {
    this.profitcenter = profitcenter;
  }
  
  public String getLccurrency() {
    return this.lccurrency;
  }
  
  public void setLccurrency(String lccurrency) {
    this.lccurrency = lccurrency;
  }
  
  public String getLcrevenue() {
    return this.lcrevenue;
  }
  
  public void setLcrevenue(String lcrevenue) {
    this.lcrevenue = lcrevenue;
  }
  
  public String getLccost() {
    return this.lccost;
  }
  
  public void setLccost(String lccost) {
    this.lccost = lccost;
  }
  
  public String getDccurrency() {
    return this.dccurrency;
  }
  
  public void setDccurrency(String dccurrency) {
    this.dccurrency = dccurrency;
  }
  
  public String getDcrevenue() {
    return this.dcrevenue;
  }
  
  public void setDcrevenue(String dcrevenue) {
    this.dcrevenue = dcrevenue;
  }
  
  public String getDccost() {
    return this.dccost;
  }
  
  public void setDccost(String dccost) {
    this.dccost = dccost;
  }
  
  public String getCreatedby() {
    return this.createdby;
  }
  
  public void setCreatedby(String createdby) {
    this.createdby = createdby;
  }
  
  public String getMatgroup() {
    return this.matgroup;
  }
  
  public void setMatgroup(String matgroup) {
    this.matgroup = matgroup;
  }
  
  public String getMatgroupdesc() {
    return this.matgroupdesc;
  }
  
  public void setMatgroupdesc(String matgroupdesc) {
    this.matgroupdesc = matgroupdesc;
  }
  
  public String getMpn() {
    return this.mpn;
  }
  
  public void setMpn(String mpn) {
    this.mpn = mpn;
  }
  
  public String getPoclientnumber() {
    return this.poclientnumber;
  }
  
  public void setPoclientnumber(String poclientnumber) {
    this.poclientnumber = poclientnumber;
  }
  
  public String getSalesoffice() {
    return this.salesoffice;
  }
  
  public void setSalesoffice(String salesoffice) {
    this.salesoffice = salesoffice;
  }
  
  public String getSalesgroup() {
    return this.salesgroup;
  }
  
  public void setSalesgroup(String salesgroup) {
    this.salesgroup = salesgroup;
  }
  
  public String getProcurementnotes() {
    return this.procurementnotes;
  }
  
  public void setProcurementnotes(String procurementnotes) {
    this.procurementnotes = procurementnotes;
  }
  
  public String getClientnotes() {
    return this.clientnotes;
  }
  
  public void setClientnotes(String clientnotes) {
    this.clientnotes = clientnotes;
  }
  
  public String getClassification() {
    return this.classification;
  }
  
  public void setClassification(String classification) {
    this.classification = classification;
  }
  
  public String getCreatedon() {
    return this.createdon;
  }
  
  public void setCreatedon(String createdon) {
    this.createdon = createdon;
  }
  
  public String getUpdatedon() {
    return this.updatedon;
  }
  
  public void setUpdatedon(String updatedon) {
    this.updatedon = updatedon;
  }
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String dbName="c1ppms";
  
  public static String getDbusername() {
    return dbusername;
  }
  
  public static void setDbusername(String dbusername) {
    dbusername = dbusername;
  }
  
  public static String getDbpassword() {
    return dbpassword;
  }
  
  public static void setDbpassword(String dbpassword) {
    dbpassword = dbpassword;
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
  
  public Float getFloatValue(String str) {
    Float frslt = null;
    try {
      if (str.isEmpty())
        str = "0"; 
      frslt = Float.valueOf(str);
    } catch (Exception e) {
      frslt = Float.valueOf("0");
    } 
    return frslt;
  }
  
  private String setMysqDate(String sDate) {
    String temp = null;
    try {
      sDate = sDate.trim();
    } catch (Exception e) {
      sDate = "";
    } 
    if (sDate.equals("")) {
      temp = "9999-12-31";
    } else {
      try {
        String[] s = sDate.split("/");
        String sMonth = s[1];
        if (sMonth.length() == 1)
          sMonth = "0" + sMonth; 
        String sDay = s[0];
        if (sDay.length() == 1)
          sDay = "0" + sDay; 
        int iMonth = 0;
        try {
          iMonth = Integer.parseInt(sMonth);
        } catch (Exception exception) {}
        if (iMonth <= 12) {
          temp = String.valueOf(s[2]) + "-" + sMonth + "-" + sDay;
        } else {
          temp = String.valueOf(s[2]) + "-" + sDay + "-" + sMonth;
        } 
      } catch (Exception e) {
        temp = "9999-12-31";
      } 
    } 
  //  if (temp == null)
   //   temp = "9999-12-31"; 
    if (temp.equals(""))
      temp = "9999-12-31"; 
    if (temp.isEmpty())
      temp = "9999-12-31"; 
    return temp;
  }
  
  public void dbLoadSOItem() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    try {
      String sIdSO = String.valueOf(getSonumber()) + getSoitem();
      String sSelect = "Select `id` from `soitem` where `idso`=\"" + sIdSO + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `soitem` SET `updatedon`=?,`idsoitem`=?,`idcontract`=?,`contractnumber`=?,`contractstatus`=?,`companycode`=?,`sonumber`=?,`soitem`=?,`wbselement`=?,`networknumber`=?,`soldto`=?,`shipto`=?,`shiptocustomer`=?,`dateordercreation`=?,`profitcenter`=?,`lccurrency`=?,`lcrevenue`=?,`lccost`=?,`dccurrency`=?,`dcrevenue`=?,`dccost`=?,`createdby`=?,`matgroup`=?,`matgroupdesc`=?,`mpn`=?,`poclientnumber`=?,`salesoffice`=?,`salesgroup`=?,`procurementnotes`=?,`clientnotes`=?,`classification`=?, `idso`=?  WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getIdsoitem());
        preparedStmt.setString(3, getIdcontract());
        preparedStmt.setString(4, getContractnumber());
        preparedStmt.setString(5, getContractstatus());
        preparedStmt.setString(6, getCompanycode());
        preparedStmt.setString(7, getSonumber());
        preparedStmt.setString(8, getSoitem());
        preparedStmt.setString(9, getWbselement());
        preparedStmt.setString(10, getNetworknumber());
        preparedStmt.setString(11, getSoldto());
        preparedStmt.setString(12, getShipto());
        preparedStmt.setString(13, getShiptocustomer());
        preparedStmt.setString(14, setMysqDate(getDateordercreation()));
        preparedStmt.setString(15, getProfitcenter());
        preparedStmt.setString(16, getLccurrency());
        preparedStmt.setFloat(17, getFloatValue(getLcrevenue()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getLccost()).floatValue());
        preparedStmt.setString(19, getDccurrency());
        preparedStmt.setFloat(20, getFloatValue(getDcrevenue()).floatValue());
        preparedStmt.setFloat(21, getFloatValue(getDccost()).floatValue());
        preparedStmt.setString(22, getCreatedby());
        preparedStmt.setString(23, getMatgroup());
        preparedStmt.setString(24, getMatgroupdesc());
        preparedStmt.setString(25, getMpn());
        preparedStmt.setString(26, getPoclientnumber());
        preparedStmt.setString(27, getSalesoffice());
        preparedStmt.setString(28, getSalesgroup());
        preparedStmt.setString(29, getProcurementnotes());
        preparedStmt.setString(30, getClientnotes());
        preparedStmt.setString(31, getClassification());
        preparedStmt.setString(32, sIdSO);
        preparedStmt.setInt(33, getIntValue((new StringBuilder(String.valueOf(rs.getInt(1)))).toString()));
        preparedStmt.execute();
      } else {
        sQuery = "INSERT INTO `soitem`(`updatedon`, `idsoitem`,`idcontract`,`contractnumber`,`contractstatus`,`companycode`,`sonumber`,`soitem`,`wbselement`,`networknumber`,`soldto`,`shipto`,`shiptocustomer`,`dateordercreation`,`profitcenter`,`lccurrency`,`lcrevenue`,`lccost`,`dccurrency`,`dcrevenue`,`dccost`,`createdby`,`matgroup`,`matgroupdesc`,`mpn`,`poclientnumber`,`salesoffice`,`salesgroup`,`procurementnotes`,`clientnotes`,`classification`,`createdon`, `idso`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getIdsoitem());
        preparedStmt.setString(3, getIdcontract());
        preparedStmt.setString(4, getContractnumber());
        preparedStmt.setString(5, getContractstatus());
        preparedStmt.setString(6, getCompanycode());
        preparedStmt.setString(7, getSonumber());
        preparedStmt.setString(8, getSoitem());
        preparedStmt.setString(9, getWbselement());
        preparedStmt.setString(10, getNetworknumber());
        preparedStmt.setString(11, getSoldto());
        preparedStmt.setString(12, getShipto());
        preparedStmt.setString(13, getShiptocustomer());
        preparedStmt.setString(14, setMysqDate(getDateordercreation()));
        preparedStmt.setString(15, getProfitcenter());
        preparedStmt.setString(16, getLccurrency());
        preparedStmt.setFloat(17, getFloatValue(getLcrevenue()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getLccost()).floatValue());
        preparedStmt.setString(19, getDccurrency());
        preparedStmt.setFloat(20, getFloatValue(getDcrevenue()).floatValue());
        preparedStmt.setFloat(21, getFloatValue(getDccost()).floatValue());
        preparedStmt.setString(22, getCreatedby());
        preparedStmt.setString(23, getMatgroup());
        preparedStmt.setString(24, getMatgroupdesc());
        preparedStmt.setString(25, getMpn());
        preparedStmt.setString(26, getPoclientnumber());
        preparedStmt.setString(27, getSalesoffice());
        preparedStmt.setString(28, getSalesgroup());
        preparedStmt.setString(29, getProcurementnotes());
        preparedStmt.setString(30, getClientnotes());
        preparedStmt.setString(31, getClassification());
        preparedStmt.setTimestamp(32, updatedAt);
        preparedStmt.setString(33, sIdSO);
        preparedStmt.execute();
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: LOAD SOItem:" + sQuery);
      System.out.println("ERROR: LOAD SOItem:" + e.getMessage());
      System.out.println("ERROR:" + preparedStmt.toString());
    } 
  }
}


/* Location:              D:\Rpa\rpappms\!\soitem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */