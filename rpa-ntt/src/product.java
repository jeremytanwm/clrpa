import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class product {
  public String id = "";
  
  public String idrecord = "";
  
  public String idproductline = "";
  
  public String idsystemproduct = "";
  
  public String productname = "";
  
  public String businessunit = "";
  
  public String manufacturer = "";
  
  public String active = "";
  
  public String productcode = "";
  
  public String productdescription = "";
  
  public String listprice = "";
  
  public String quantity = "";
  
  public String serviceproduct = "";
  
  public String gtmpractice = "";
  
  public String gtmtheme = "";
  
  public String offering = "";
  
  public String servicedivision = "";
  
  public String serviceelements = "";
  
  public String serviceorg = "";
  
  public String solution = "";
  
  public String idrecordopportunity = "";
  
  public String idopportunity = "";
  
  public String opportunityname = "";
  
  public String amount = "";
  
  public String amountusd = "";
  
  public String salesprice = "";
  
  public String salespriceusd = "";
  
  public String totalprice = "";
  
  public String totalpriceusd = "";
  
  public String expectedproductamount = "";
  
  public String expectedproductamountusd = "";
  
  public String ismultiyearcontract = "";
  
  public String poterm = "";
  
  public String poexpiration = "";
  
  public String gp = "";
  
  public String gpp = "";
  
  public String gpusd = "";
  
  public String acv = "";
  
  public String acvusd = "";
  
  public String tcv = "";
  
  public String tcvusd = "";
  
  public String mcv = "";
  
  public String mcvusd = "";
  
  public String acvgp = "";
  
  public String acvgpusd = "";
  
  public String tcvgp = "";
  
  public String tcvgpusd = "";
  
  public String updateon = "";
  
  public String idupdateby = "";
  
  public String updateby = "";
  
  public String createdon = "";
  
  public String updatedon = "";
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getIdrecord() {
    return this.idrecord;
  }
  
  public void setIdrecord(String idrecord) {
    this.idrecord = idrecord;
  }
  
  public String getIdproductline() {
    return this.idproductline;
  }
  
  public void setIdproductline(String idproductline) {
    this.idproductline = idproductline;
  }
  
  public String getIdsystemproduct() {
    return this.idsystemproduct;
  }
  
  public void setIdsystemproduct(String idsystemproduct) {
    this.idsystemproduct = idsystemproduct;
  }
  
  public String getProductname() {
    return this.productname;
  }
  
  public void setProductname(String productname) {
    this.productname = productname;
  }
  
  public String getBusinessunit() {
    return this.businessunit;
  }
  
  public void setBusinessunit(String businessunit) {
    this.businessunit = businessunit;
  }
  
  public String getManufacturer() {
    return this.manufacturer;
  }
  
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
  
  public String getActive() {
    return this.active;
  }
  
  public void setActive(String active) {
    this.active = active;
  }
  
  public String getProductcode() {
    return this.productcode;
  }
  
  public void setProductcode(String productcode) {
    this.productcode = productcode;
  }
  
  public String getProductdescription() {
    return this.productdescription;
  }
  
  public void setProductdescription(String productdescription) {
    this.productdescription = productdescription;
  }
  
  public String getListprice() {
    return this.listprice;
  }
  
  public void setListprice(String listprice) {
    this.listprice = listprice;
  }
  
  public String getQuantity() {
    return this.quantity;
  }
  
  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
  
  public String getServiceproduct() {
    return this.serviceproduct;
  }
  
  public void setServiceproduct(String serviceproduct) {
    this.serviceproduct = serviceproduct;
  }
  
  public String getGtmpractice() {
    return this.gtmpractice;
  }
  
  public void setGtmpractice(String gtmpractice) {
    this.gtmpractice = gtmpractice;
  }
  
  public String getGtmtheme() {
    return this.gtmtheme;
  }
  
  public void setGtmtheme(String gtmtheme) {
    this.gtmtheme = gtmtheme;
  }
  
  public String getOffering() {
    return this.offering;
  }
  
  public void setOffering(String offering) {
    this.offering = offering;
  }
  
  public String getServicedivision() {
    return this.servicedivision;
  }
  
  public void setServicedivision(String servicedivision) {
    this.servicedivision = servicedivision;
  }
  
  public String getServiceelements() {
    return this.serviceelements;
  }
  
  public void setServiceelements(String serviceelements) {
    this.serviceelements = serviceelements;
  }
  
  public String getServiceorg() {
    return this.serviceorg;
  }
  
  public void setServiceorg(String serviceorg) {
    this.serviceorg = serviceorg;
  }
  
  public String getSolution() {
    return this.solution;
  }
  
  public void setSolution(String solution) {
    this.solution = solution;
  }
  
  public String getIdrecordopportunity() {
    return this.idrecordopportunity;
  }
  
  public void setIdrecordopportunity(String idrecordopportunity) {
    this.idrecordopportunity = idrecordopportunity;
  }
  
  public String getIdopportunity() {
    return this.idopportunity;
  }
  
  public void setIdopportunity(String idopportunity) {
    this.idopportunity = idopportunity;
  }
  
  public String getOpportunityname() {
    return this.opportunityname;
  }
  
  public void setOpportunityname(String opportunityname) {
    this.opportunityname = opportunityname;
  }
  
  public String getAmount() {
    return this.amount;
  }
  
  public void setAmount(String amount) {
    this.amount = amount;
  }
  
  public String getAmountusd() {
    return this.amountusd;
  }
  
  public void setAmountusd(String amountusd) {
    this.amountusd = amountusd;
  }
  
  public String getSalesprice() {
    return this.salesprice;
  }
  
  public void setSalesprice(String salesprice) {
    this.salesprice = salesprice;
  }
  
  public String getSalespriceusd() {
    return this.salespriceusd;
  }
  
  public void setSalespriceusd(String salespriceusd) {
    this.salespriceusd = salespriceusd;
  }
  
  public String getTotalprice() {
    return this.totalprice;
  }
  
  public void setTotalprice(String totalprice) {
    this.totalprice = totalprice;
  }
  
  public String getTotalpriceusd() {
    return this.totalpriceusd;
  }
  
  public void setTotalpriceusd(String totalpriceusd) {
    this.totalpriceusd = totalpriceusd;
  }
  
  public String getExpectedproductamount() {
    return this.expectedproductamount;
  }
  
  public void setExpectedproductamount(String expectedproductamount) {
    this.expectedproductamount = expectedproductamount;
  }
  
  public String getExpectedproductamountusd() {
    return this.expectedproductamountusd;
  }
  
  public void setExpectedproductamountusd(String expectedproductamountusd) {
    this.expectedproductamountusd = expectedproductamountusd;
  }
  
  public String getIsmultiyearcontract() {
    return this.ismultiyearcontract;
  }
  
  public void setIsmultiyearcontract(String ismultiyearcontract) {
    this.ismultiyearcontract = ismultiyearcontract;
  }
  
  public String getPoterm() {
    return this.poterm;
  }
  
  public void setPoterm(String poterm) {
    this.poterm = poterm;
  }
  
  public String getPoexpiration() {
    return this.poexpiration;
  }
  
  public void setPoexpiration(String poexpiration) {
    this.poexpiration = poexpiration;
  }
  
  public String getGp() {
    return this.gp;
  }
  
  public void setGp(String gp) {
    this.gp = gp;
  }
  
  public String getGpp() {
    return this.gpp;
  }
  
  public void setGpp(String gpp) {
    this.gpp = gpp;
  }
  
  public String getGpusd() {
    return this.gpusd;
  }
  
  public void setGpusd(String gpusd) {
    this.gpusd = gpusd;
  }
  
  public String getAcv() {
    return this.acv;
  }
  
  public void setAcv(String acv) {
    this.acv = acv;
  }
  
  public String getAcvusd() {
    return this.acvusd;
  }
  
  public void setAcvusd(String acvusd) {
    this.acvusd = acvusd;
  }
  
  public String getTcv() {
    return this.tcv;
  }
  
  public void setTcv(String tcv) {
    this.tcv = tcv;
  }
  
  public String getTcvusd() {
    return this.tcvusd;
  }
  
  public void setTcvusd(String tcvusd) {
    this.tcvusd = tcvusd;
  }
  
  public String getMcv() {
    return this.mcv;
  }
  
  public void setMcv(String mcv) {
    this.mcv = mcv;
  }
  
  public String getMcvusd() {
    return this.mcvusd;
  }
  
  public void setMcvusd(String mcvusd) {
    this.mcvusd = mcvusd;
  }
  
  public String getAcvgp() {
    return this.acvgp;
  }
  
  public void setAcvgp(String acvgp) {
    this.acvgp = acvgp;
  }
  
  public String getAcvgpusd() {
    return this.acvgpusd;
  }
  
  public void setAcvgpusd(String acvgpusd) {
    this.acvgpusd = acvgpusd;
  }
  
  public String getTcvgp() {
    return this.tcvgp;
  }
  
  public void setTcvgp(String tcvgp) {
    this.tcvgp = tcvgp;
  }
  
  public String getTcvgpusd() {
    return this.tcvgpusd;
  }
  
  public void setTcvgpusd(String tcvgpusd) {
    this.tcvgpusd = tcvgpusd;
  }
  
  public String getUpdateon() {
    return this.updateon;
  }
  
  public void setUpdateon(String updateon) {
    this.updateon = updateon;
  }
  
  public String getIdupdateby() {
    return this.idupdateby;
  }
  
  public void setIdupdateby(String idupdateby) {
    this.idupdateby = idupdateby;
  }
  
  public String getUpdateby() {
    return this.updateby;
  }
  
  public void setUpdateby(String updateby) {
    this.updateby = updateby;
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
  
  public static String getDbusername() {
    return dbusername;
  }
  
  public static void setDbusername(String dbusername) {
    product.dbusername = dbusername;
  }
  
  public static String getDbpassword() {
    return dbpassword;
  }
  
  public static void setDbpassword(String dbpassword) {
    product.dbpassword = dbpassword;
  }
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String dbName="c1ppms";
  
  public static void main(String[] args) {}
  
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
    //if (temp == null)
    //  temp = "9999-12-31"; 
    if (temp.equals(""))
      temp = "9999-12-31"; 
    if (temp.isEmpty())
      temp = "9999-12-31"; 
    return temp;
  }
  
  public Float getFloatValue(String str) {
    Float frslt = null;
    try {
      if (str.isEmpty()) {
        str = "0";
      } else {
        str = str.replaceAll(",", "");
        str = str.replaceAll("\\p{Alpha}", "");
        str = str.replaceAll("\\%", "");
      } 
      frslt = Float.valueOf(str);
    } catch (Exception e) {
      frslt = Float.valueOf("0");
    } 
    return frslt;
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
  
  public static String queryIDRecord(String sIDRecord) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `id` from `opportunity-product` where `idrecord`=\"" + sIDRecord + "\"";
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
  
  public void dbUpdateOpportunityProduct() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryIDRecord(getIdrecord());
      setId(sID);
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `opportunity-product`(`updatedon`,`idrecord`, `idproductline`, `idsystemproduct`, `productname`, `businessunit`, `manufacturer`, `active`, `productcode`, `productdescription`, `listprice`, `quantity`, `serviceproduct`, `gtmpractice`, `gtmtheme`, `offering`, `servicedivision`, `serviceelements`, `serviceorg`, `solution`, `idrecordopportunity`, `idopportunity`, `opportunityname`, `amount`, `amountusd`, `salesprice`, `salespriceusd`, `totalprice`, `totalpriceusd`, `expectedproductamount`, `expectedproductamountusd`, `ismultiyearcontract`, `poterm`, `poexpiration`, `gp`, `gpusd`, `acv`, `acvusd`, `tcv`, `tcvusd`, `mcv`, `mcvusd`, `acvgp`, `acvgpusd`, `tcvgp`, `tcvgpusd`, `updateon`, `idupdateby`, `updateby`, `createdon`, gpp )  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getIdrecord());
        preparedStmt.setString(3, getIdproductline());
        preparedStmt.setString(4, getIdsystemproduct());
        preparedStmt.setString(5, getProductname());
        preparedStmt.setString(6, getBusinessunit());
        preparedStmt.setString(7, getManufacturer());
        preparedStmt.setString(8, getActive());
        preparedStmt.setString(9, getProductcode());
        preparedStmt.setString(10, getProductdescription());
        preparedStmt.setFloat(11, getFloatValue(getListprice()).floatValue());
        preparedStmt.setFloat(12, getFloatValue(getQuantity()).floatValue());
        preparedStmt.setString(13, getServiceproduct());
        preparedStmt.setString(14, getGtmpractice());
        preparedStmt.setString(15, getGtmtheme());
        preparedStmt.setString(16, getOffering());
        preparedStmt.setString(17, getServicedivision());
        preparedStmt.setString(18, getServiceelements());
        preparedStmt.setString(19, getServiceorg());
        preparedStmt.setString(20, getSolution());
        preparedStmt.setString(21, getIdrecordopportunity());
        preparedStmt.setString(22, getIdopportunity());
        preparedStmt.setString(23, getOpportunityname());
        preparedStmt.setFloat(24, getFloatValue(getAmount()).floatValue());
        preparedStmt.setFloat(25, getFloatValue(getAmountusd()).floatValue());
        preparedStmt.setFloat(26, getFloatValue(getSalesprice()).floatValue());
        preparedStmt.setFloat(27, getFloatValue(getSalespriceusd()).floatValue());
        preparedStmt.setFloat(28, getFloatValue(getTotalprice()).floatValue());
        preparedStmt.setFloat(29, getFloatValue(getTotalpriceusd()).floatValue());
        preparedStmt.setFloat(30, getFloatValue(getExpectedproductamount()).floatValue());
        preparedStmt.setFloat(31, getFloatValue(getExpectedproductamountusd()).floatValue());
        preparedStmt.setString(32, getIsmultiyearcontract());
        preparedStmt.setFloat(33, getFloatValue(getPoterm()).floatValue());
        preparedStmt.setString(34, setMysqDate(getPoexpiration()));
        preparedStmt.setFloat(35, getFloatValue(getGp()).floatValue());
        preparedStmt.setFloat(36, getFloatValue(getGpusd()).floatValue());
        preparedStmt.setFloat(37, getFloatValue(getAcv()).floatValue());
        preparedStmt.setFloat(38, getFloatValue(getAcvusd()).floatValue());
        preparedStmt.setFloat(39, getFloatValue(getTcv()).floatValue());
        preparedStmt.setFloat(40, getFloatValue(getTcvusd()).floatValue());
        preparedStmt.setFloat(41, getFloatValue(getMcv()).floatValue());
        preparedStmt.setFloat(42, getFloatValue(getMcvusd()).floatValue());
        preparedStmt.setFloat(43, getFloatValue(getAcvgp()).floatValue());
        preparedStmt.setFloat(44, getFloatValue(getAcvgpusd()).floatValue());
        preparedStmt.setFloat(45, getFloatValue(getTcvgp()).floatValue());
        preparedStmt.setFloat(46, getFloatValue(getTcvgpusd()).floatValue());
        preparedStmt.setString(47, setMysqDate(getUpdateon()));
        preparedStmt.setString(48, getIdupdateby());
        preparedStmt.setString(49, getUpdateby());
        preparedStmt.setTimestamp(50, updatedAt);
        preparedStmt.setFloat(51, getFloatValue(getGpp()).floatValue());
        System.out.println(preparedStmt.toString());
        preparedStmt.execute();
        preparedStmt.close();
      } else {
        sQuery = "UPDATE `opportunity-product` SET `updatedon`=?,`idrecord`=?, `idproductline`=?, `idsystemproduct`=?, `productname`=?, `businessunit`=?, `manufacturer`=?, `active`=?, `productcode`=?, `productdescription`=?,`listprice`=?, `quantity`=?, `serviceproduct`=?, `gtmpractice`=?, `gtmtheme`=?, `offering`=?, `servicedivision`=?, `serviceelements`=?, `serviceorg`=?, `solution`=?, `idrecordopportunity`=?, `idopportunity`=?, `opportunityname`=?, `amount`=?, `amountusd`=?, `salesprice`=?, `salespriceusd`=?, `totalprice`=?, `totalpriceusd`=?,`expectedproductamount`=?, `expectedproductamountusd`=?, `ismultiyearcontract`=?, `poterm`=?, `poexpiration`=?, `gp`=?, `gpusd`=?, `acv`=?, `acvusd`=?, `tcv`=?, `tcvusd`=?, `mcv`=?, `mcvusd`=?, `acvgp`=?, `acvgpusd`=?, `tcvgp`=?, `tcvgpusd`=?,`updateon`=?, `idupdateby`=?, `updateby`=?, gpp=?  WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getIdrecord());
        preparedStmt.setString(3, getIdproductline());
        preparedStmt.setString(4, getIdsystemproduct());
        preparedStmt.setString(5, getProductname());
        preparedStmt.setString(6, getBusinessunit());
        preparedStmt.setString(7, getManufacturer());
        preparedStmt.setString(8, getActive());
        preparedStmt.setString(9, getProductcode());
        preparedStmt.setString(10, getProductdescription());
        preparedStmt.setFloat(11, getFloatValue(getListprice()).floatValue());
        preparedStmt.setFloat(12, getFloatValue(getQuantity()).floatValue());
        preparedStmt.setString(13, getServiceproduct());
        preparedStmt.setString(14, getGtmpractice());
        preparedStmt.setString(15, getGtmtheme());
        preparedStmt.setString(16, getOffering());
        preparedStmt.setString(17, getServicedivision());
        preparedStmt.setString(18, getServiceelements());
        preparedStmt.setString(19, getServiceorg());
        preparedStmt.setString(20, getSolution());
        preparedStmt.setString(21, getIdrecordopportunity());
        preparedStmt.setString(22, getIdopportunity());
        preparedStmt.setString(23, getOpportunityname());
        preparedStmt.setFloat(24, getFloatValue(getAmount()).floatValue());
        preparedStmt.setFloat(25, getFloatValue(getAmountusd()).floatValue());
        preparedStmt.setFloat(26, getFloatValue(getSalesprice()).floatValue());
        preparedStmt.setFloat(27, getFloatValue(getSalespriceusd()).floatValue());
        preparedStmt.setFloat(28, getFloatValue(getTotalprice()).floatValue());
        preparedStmt.setFloat(29, getFloatValue(getTotalpriceusd()).floatValue());
        preparedStmt.setFloat(30, getFloatValue(getExpectedproductamount()).floatValue());
        preparedStmt.setFloat(31, getFloatValue(getExpectedproductamountusd()).floatValue());
        preparedStmt.setString(32, getIsmultiyearcontract());
        preparedStmt.setFloat(33, getFloatValue(getPoterm()).floatValue());
        preparedStmt.setString(34, setMysqDate(getPoexpiration()));
        preparedStmt.setFloat(35, getFloatValue(getGp()).floatValue());
        preparedStmt.setFloat(36, getFloatValue(getGpusd()).floatValue());
        preparedStmt.setFloat(37, getFloatValue(getAcv()).floatValue());
        preparedStmt.setFloat(38, getFloatValue(getAcvusd()).floatValue());
        preparedStmt.setFloat(39, getFloatValue(getTcv()).floatValue());
        preparedStmt.setFloat(40, getFloatValue(getTcvusd()).floatValue());
        preparedStmt.setFloat(41, getFloatValue(getMcv()).floatValue());
        preparedStmt.setFloat(42, getFloatValue(getMcvusd()).floatValue());
        preparedStmt.setFloat(43, getFloatValue(getAcvgp()).floatValue());
        preparedStmt.setFloat(44, getFloatValue(getAcvgpusd()).floatValue());
        preparedStmt.setFloat(45, getFloatValue(getTcvgp()).floatValue());
        preparedStmt.setFloat(46, getFloatValue(getTcvgpusd()).floatValue());
        preparedStmt.setString(47, setMysqDate(getUpdateon()));
        preparedStmt.setString(48, getIdupdateby());
        preparedStmt.setString(49, getUpdateby());
        preparedStmt.setFloat(50, getFloatValue(getGpp()).floatValue());
        preparedStmt.setInt(51, getIntValue(sID));
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
}


/* Location:              D:\Rpa\rpappms\!\product.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */