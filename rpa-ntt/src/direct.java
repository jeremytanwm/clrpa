import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class direct {
  public String id = "";
  
  public String idrecord = "";
  
  public String region = "";
  
  public String ddentity = "";
  
  public String buyername = "";
  
  public String ponumber = "";
  
  public String podate = "";
  
  public String confirmationno = "";
  
  public String requester = "";
  
  public String manufacturer = "";
  
  public String mfrpartnumber = "";
  
  public String itemdescription = "";
  
  public String preferredsupplier = "";
  
  public String status = "";
  
  public String quantity = "";
  
  public String grosscostusd = "";
  
  public String grosstotalusd = "";
  
  public String salesoficecode = "";
  
  public String salesoffice = "";
  
  public String orderreason = "";
  
  public String orderreasoncode = "";
  
  public String so = "";
  
  public String quotename = "";
  
  public String quoteno = "";
  
  public String sfdcno = "";
  
  public String projectcode = "";
  
  public String department = "";
  
  public String grosscost = "";
  
  public String grosstotal = "";
  
  public String poreceiveddate = "";
  
  public String neededby = "";
  
  public String datecreated = "";
  
  public String datesubmitted = "";
  
  public String datepurchased = "";
  
  public String dateaccepted = "";
  
  public String datemfrscheduled = "";
  
  public String dateshipped = "";
  
  public String datedelivered = "";
  
  public String dateinvoiced = "";
  
  public String budgetcostusd = "";
  
  public String budgettotalusd = "";
  
  public String dealid = "";
  
  public String dateestimatedship = "";
  
  public String dateestimateddelivery = "";
  
  public String itemcategory = "";
  
  public String itemtypename = "";
  
  public String plantname = "";
  
  public String producttype = "";
  
  public String category = "";
  
  public String listpriceusd = "";
  
  public String quotedcratedby = "";
  
  public String requestoremailaddress = "";
  
  public String shipcontactname = "";
  
  public String shipcontactemail = "";
  
  public String nettotalusd = "";
  
  public String netbuyusd = "";
  
  public String idrow = "";
  
  public String listprice = "";
  
  public String vendorponumber = "";
  
  public String invoice = "";
  
  public String financecode = "";
  
  public String grossprofit = "";
  
  public String ordermanagement = "";
  
  public String customercode = "";
  
  public String buyerurl = "";
  
  public String buyertype = "";
  
  public String buyergroup = "";
  
  public String ddgroupid = "";
  
  public String intercompanyno = "";
  
  public String convertedby = "";
  
  public String isdataentry = "";
  
  public String isselfservice = "";
  
  public String billcountry = "";
  
  public String deliverycountry = "";
  
  public String currency = "";
  
  public String posttoerpstatus = "";
  
  public String posttoerpdesc = "";
  
  public String datequoterequest = "";
  
  public String catalogname = "";
  
  public String intercompanyitem = "";
  
  public String itemcategorycode = "";
  
  public String plantcode = "";
  
  public String preferredsuppliercode = "";
  
  public String uploaded = "";
  
  public String catalogcost = "";
  
  public String catalogsell = "";
  
  public String cataloglist = "";
  
  public String catalogcurrency = "";
  
  public String regionalbuyergroup = "";
  
  public String preelaprice = "";
  
  public String preelabaseprice = "";
  
  public String serialnumber = "";
  
  public String clientbusinessunit = "";
  
  public String rewsid = "";
  
  public String floor = "";
  
  public String constructionid = "";
  
  public String roomtype = "";
  
  public String firstdayofbusiness = "";
  
  public String fistdayofinstall = "";
  
  public String posttoerpname = "";
  
  public String posttoerpemail = "";
  
  public String stockreservationon = "";
  
  public String pricerulereference = "";
  
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
  
  public String getRegion() {
    return this.region;
  }
  
  public void setRegion(String region) {
    this.region = region;
  }
  
  public String getDdentity() {
    return this.ddentity;
  }
  
  public void setDdentity(String ddentity) {
    this.ddentity = ddentity;
  }
  
  public String getBuyername() {
    return this.buyername;
  }
  
  public void setBuyername(String buyername) {
    this.buyername = buyername;
  }
  
  public String getPonumber() {
    return this.ponumber;
  }
  
  public void setPonumber(String ponumber) {
    this.ponumber = ponumber;
  }
  
  public String getPodate() {
    return this.podate;
  }
  
  public void setPodate(String podate) {
    this.podate = podate;
  }
  
  public String getConfirmationno() {
    return this.confirmationno;
  }
  
  public void setConfirmationno(String confirmationno) {
    this.confirmationno = confirmationno;
  }
  
  public String getRequester() {
    return this.requester;
  }
  
  public void setRequester(String requester) {
    this.requester = requester;
  }
  
  public String getManufacturer() {
    return this.manufacturer;
  }
  
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
  
  public String getMfrpartnumber() {
    return this.mfrpartnumber;
  }
  
  public void setMfrpartnumber(String mfrpartnumber) {
    this.mfrpartnumber = mfrpartnumber;
  }
  
  public String getItemdescription() {
    return this.itemdescription;
  }
  
  public void setItemdescription(String itemdescription) {
    this.itemdescription = itemdescription;
  }
  
  public String getPreferredsupplier() {
    return this.preferredsupplier;
  }
  
  public void setPreferredsupplier(String preferredsupplier) {
    this.preferredsupplier = preferredsupplier;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getQuantity() {
    return this.quantity;
  }
  
  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
  
  public String getGrosscostusd() {
    return this.grosscostusd;
  }
  
  public void setGrosscostusd(String grosscostusd) {
    this.grosscostusd = grosscostusd;
  }
  
  public String getGrosstotalusd() {
    return this.grosstotalusd;
  }
  
  public void setGrosstotalusd(String grosstotalusd) {
    this.grosstotalusd = grosstotalusd;
  }
  
  public String getSalesoficecode() {
    return this.salesoficecode;
  }
  
  public void setSalesoficecode(String salesoficecode) {
    this.salesoficecode = salesoficecode;
  }
  
  public String getSalesoffice() {
    return this.salesoffice;
  }
  
  public void setSalesoffice(String salesoffice) {
    this.salesoffice = salesoffice;
  }
  
  public String getOrderreason() {
    return this.orderreason;
  }
  
  public void setOrderreason(String orderreason) {
    this.orderreason = orderreason;
  }
  
  public String getOrderreasoncode() {
    return this.orderreasoncode;
  }
  
  public void setOrderreasoncode(String orderreasoncode) {
    this.orderreasoncode = orderreasoncode;
  }
  
  public String getSo() {
    return this.so;
  }
  
  public void setSo(String so) {
    this.so = so;
  }
  
  public String getQuotename() {
    return this.quotename;
  }
  
  public void setQuotename(String quotename) {
    this.quotename = quotename;
  }
  
  public String getQuoteno() {
    return this.quoteno;
  }
  
  public void setQuoteno(String quoteno) {
    this.quoteno = quoteno;
  }
  
  public String getSfdcno() {
    return this.sfdcno;
  }
  
  public void setSfdcno(String sfdcno) {
    this.sfdcno = sfdcno;
  }
  
  public String getProjectcode() {
    return this.projectcode;
  }
  
  public void setProjectcode(String projectcode) {
    this.projectcode = projectcode;
  }
  
  public String getDepartment() {
    return this.department;
  }
  
  public void setDepartment(String department) {
    this.department = department;
  }
  
  public String getGrosscost() {
    return this.grosscost;
  }
  
  public void setGrosscost(String grosscost) {
    this.grosscost = grosscost;
  }
  
  public String getGrosstotal() {
    return this.grosstotal;
  }
  
  public void setGrosstotal(String grosstotal) {
    this.grosstotal = grosstotal;
  }
  
  public String getPoreceiveddate() {
    return this.poreceiveddate;
  }
  
  public void setPoreceiveddate(String poreceiveddate) {
    this.poreceiveddate = poreceiveddate;
  }
  
  public String getNeededby() {
    return this.neededby;
  }
  
  public void setNeededby(String neededby) {
    this.neededby = neededby;
  }
  
  public String getDatecreated() {
    return this.datecreated;
  }
  
  public void setDatecreated(String datecreated) {
    this.datecreated = datecreated;
  }
  
  public String getDatesubmitted() {
    return this.datesubmitted;
  }
  
  public void setDatesubmitted(String datesubmitted) {
    this.datesubmitted = datesubmitted;
  }
  
  public String getDatepurchased() {
    return this.datepurchased;
  }
  
  public void setDatepurchased(String datepurchased) {
    this.datepurchased = datepurchased;
  }
  
  public String getDateaccepted() {
    return this.dateaccepted;
  }
  
  public void setDateaccepted(String dateaccepted) {
    this.dateaccepted = dateaccepted;
  }
  
  public String getDatemfrscheduled() {
    return this.datemfrscheduled;
  }
  
  public void setDatemfrscheduled(String datemfrscheduled) {
    this.datemfrscheduled = datemfrscheduled;
  }
  
  public String getDateshipped() {
    return this.dateshipped;
  }
  
  public void setDateshipped(String dateshipped) {
    this.dateshipped = dateshipped;
  }
  
  public String getDatedelivered() {
    return this.datedelivered;
  }
  
  public void setDatedelivered(String datedelivered) {
    this.datedelivered = datedelivered;
  }
  
  public String getDateinvoiced() {
    return this.dateinvoiced;
  }
  
  public void setDateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
  }
  
  public String getBudgetcostusd() {
    return this.budgetcostusd;
  }
  
  public void setBudgetcostusd(String budgetcostusd) {
    this.budgetcostusd = budgetcostusd;
  }
  
  public String getBudgettotalusd() {
    return this.budgettotalusd;
  }
  
  public void setBudgettotalusd(String budgettotalusd) {
    this.budgettotalusd = budgettotalusd;
  }
  
  public String getDealid() {
    return this.dealid;
  }
  
  public void setDealid(String dealid) {
    this.dealid = dealid;
  }
  
  public String getDateestimatedship() {
    return this.dateestimatedship;
  }
  
  public void setDateestimatedship(String dateestimatedship) {
    this.dateestimatedship = dateestimatedship;
  }
  
  public String getDateestimateddelivery() {
    return this.dateestimateddelivery;
  }
  
  public void setDateestimateddelivery(String dateestimateddelivery) {
    this.dateestimateddelivery = dateestimateddelivery;
  }
  
  public String getItemcategory() {
    return this.itemcategory;
  }
  
  public void setItemcategory(String itemcategory) {
    this.itemcategory = itemcategory;
  }
  
  public String getItemtypename() {
    return this.itemtypename;
  }
  
  public void setItemtypename(String itemtypename) {
    this.itemtypename = itemtypename;
  }
  
  public String getPlantname() {
    return this.plantname;
  }
  
  public void setPlantname(String plantname) {
    this.plantname = plantname;
  }
  
  public String getProducttype() {
    return this.producttype;
  }
  
  public void setProducttype(String producttype) {
    this.producttype = producttype;
  }
  
  public String getCategory() {
    return this.category;
  }
  
  public void setCategory(String category) {
    this.category = category;
  }
  
  public String getListpriceusd() {
    return this.listpriceusd;
  }
  
  public void setListpriceusd(String listpriceusd) {
    this.listpriceusd = listpriceusd;
  }
  
  public String getQuotedcratedby() {
    return this.quotedcratedby;
  }
  
  public void setQuotedcratedby(String quotedcratedby) {
    this.quotedcratedby = quotedcratedby;
  }
  
  public String getRequestoremailaddress() {
    return this.requestoremailaddress;
  }
  
  public void setRequestoremailaddress(String requestoremailaddress) {
    this.requestoremailaddress = requestoremailaddress;
  }
  
  public String getShipcontactname() {
    return this.shipcontactname;
  }
  
  public void setShipcontactname(String shipcontactname) {
    this.shipcontactname = shipcontactname;
  }
  
  public String getShipcontactemail() {
    return this.shipcontactemail;
  }
  
  public void setShipcontactemail(String shipcontactemail) {
    this.shipcontactemail = shipcontactemail;
  }
  
  public String getNettotalusd() {
    return this.nettotalusd;
  }
  
  public void setNettotalusd(String nettotalusd) {
    this.nettotalusd = nettotalusd;
  }
  
  public String getNetbuyusd() {
    return this.netbuyusd;
  }
  
  public void setNetbuyusd(String netbuyusd) {
    this.netbuyusd = netbuyusd;
  }
  
  public String getIdrow() {
    return this.idrow;
  }
  
  public void setIdrow(String idrow) {
    this.idrow = idrow;
  }
  
  public String getListprice() {
    return this.listprice;
  }
  
  public void setListprice(String listprice) {
    this.listprice = listprice;
  }
  
  public String getVendorponumber() {
    return this.vendorponumber;
  }
  
  public void setVendorponumber(String vendorponumber) {
    this.vendorponumber = vendorponumber;
  }
  
  public String getInvoice() {
    return this.invoice;
  }
  
  public void setInvoice(String invoice) {
    this.invoice = invoice;
  }
  
  public String getFinancecode() {
    return this.financecode;
  }
  
  public void setFinancecode(String financecode) {
    this.financecode = financecode;
  }
  
  public String getGrossprofit() {
    return this.grossprofit;
  }
  
  public void setGrossprofit(String grossprofit) {
    this.grossprofit = grossprofit;
  }
  
  public String getOrdermanagement() {
    return this.ordermanagement;
  }
  
  public void setOrdermanagement(String ordermanagement) {
    this.ordermanagement = ordermanagement;
  }
  
  public String getCustomercode() {
    return this.customercode;
  }
  
  public void setCustomercode(String customercode) {
    this.customercode = customercode;
  }
  
  public String getBuyerurl() {
    return this.buyerurl;
  }
  
  public void setBuyerurl(String buyerurl) {
    this.buyerurl = buyerurl;
  }
  
  public String getBuyertype() {
    return this.buyertype;
  }
  
  public void setBuyertype(String buyertype) {
    this.buyertype = buyertype;
  }
  
  public String getBuyergroup() {
    return this.buyergroup;
  }
  
  public void setBuyergroup(String buyergroup) {
    this.buyergroup = buyergroup;
  }
  
  public String getDdgroupid() {
    return this.ddgroupid;
  }
  
  public void setDdgroupid(String ddgroupid) {
    this.ddgroupid = ddgroupid;
  }
  
  public String getIntercompanyno() {
    return this.intercompanyno;
  }
  
  public void setIntercompanyno(String intercompanyno) {
    this.intercompanyno = intercompanyno;
  }
  
  public String getConvertedby() {
    return this.convertedby;
  }
  
  public void setConvertedby(String convertedby) {
    this.convertedby = convertedby;
  }
  
  public String getIsdataentry() {
    return this.isdataentry;
  }
  
  public void setIsdataentry(String isdataentry) {
    this.isdataentry = isdataentry;
  }
  
  public String getIsselfservice() {
    return this.isselfservice;
  }
  
  public void setIsselfservice(String isselfservice) {
    this.isselfservice = isselfservice;
  }
  
  public String getBillcountry() {
    return this.billcountry;
  }
  
  public void setBillcountry(String billcountry) {
    this.billcountry = billcountry;
  }
  
  public String getDeliverycountry() {
    return this.deliverycountry;
  }
  
  public void setDeliverycountry(String deliverycountry) {
    this.deliverycountry = deliverycountry;
  }
  
  public String getCurrency() {
    return this.currency;
  }
  
  public void setCurrency(String currency) {
    this.currency = currency;
  }
  
  public String getPosttoerpstatus() {
    return this.posttoerpstatus;
  }
  
  public void setPosttoerpstatus(String posttoerpstatus) {
    this.posttoerpstatus = posttoerpstatus;
  }
  
  public String getPosttoerpdesc() {
    return this.posttoerpdesc;
  }
  
  public void setPosttoerpdesc(String posttoerpdesc) {
    this.posttoerpdesc = posttoerpdesc;
  }
  
  public String getDatequoterequest() {
    return this.datequoterequest;
  }
  
  public void setDatequoterequest(String datequoterequest) {
    this.datequoterequest = datequoterequest;
  }
  
  public String getCatalogname() {
    return this.catalogname;
  }
  
  public void setCatalogname(String catalogname) {
    this.catalogname = catalogname;
  }
  
  public String getIntercompanyitem() {
    return this.intercompanyitem;
  }
  
  public void setIntercompanyitem(String intercompanyitem) {
    this.intercompanyitem = intercompanyitem;
  }
  
  public String getItemcategorycode() {
    return this.itemcategorycode;
  }
  
  public void setItemcategorycode(String itemcategorycode) {
    this.itemcategorycode = itemcategorycode;
  }
  
  public String getPlantcode() {
    return this.plantcode;
  }
  
  public void setPlantcode(String plantcode) {
    this.plantcode = plantcode;
  }
  
  public String getPreferredsuppliercode() {
    return this.preferredsuppliercode;
  }
  
  public void setPreferredsuppliercode(String preferredsuppliercode) {
    this.preferredsuppliercode = preferredsuppliercode;
  }
  
  public String getUploaded() {
    return this.uploaded;
  }
  
  public void setUploaded(String uploaded) {
    this.uploaded = uploaded;
  }
  
  public String getCatalogcost() {
    return this.catalogcost;
  }
  
  public void setCatalogcost(String catalogcost) {
    this.catalogcost = catalogcost;
  }
  
  public String getCatalogsell() {
    return this.catalogsell;
  }
  
  public void setCatalogsell(String catalogsell) {
    this.catalogsell = catalogsell;
  }
  
  public String getCataloglist() {
    return this.cataloglist;
  }
  
  public void setCataloglist(String cataloglist) {
    this.cataloglist = cataloglist;
  }
  
  public String getCatalogcurrency() {
    return this.catalogcurrency;
  }
  
  public void setCatalogcurrency(String catalogcurrency) {
    this.catalogcurrency = catalogcurrency;
  }
  
  public String getRegionalbuyergroup() {
    return this.regionalbuyergroup;
  }
  
  public void setRegionalbuyergroup(String regionalbuyergroup) {
    this.regionalbuyergroup = regionalbuyergroup;
  }
  
  public String getPreelaprice() {
    return this.preelaprice;
  }
  
  public void setPreelaprice(String preelaprice) {
    this.preelaprice = preelaprice;
  }
  
  public String getPreelabaseprice() {
    return this.preelabaseprice;
  }
  
  public void setPreelabaseprice(String preelabaseprice) {
    this.preelabaseprice = preelabaseprice;
  }
  
  public String getSerialnumber() {
    return this.serialnumber;
  }
  
  public void setSerialnumber(String serialnumber) {
    this.serialnumber = serialnumber;
  }
  
  public String getClientbusinessunit() {
    return this.clientbusinessunit;
  }
  
  public void setClientbusinessunit(String clientbusinessunit) {
    this.clientbusinessunit = clientbusinessunit;
  }
  
  public String getRewsid() {
    return this.rewsid;
  }
  
  public void setRewsid(String rewsid) {
    this.rewsid = rewsid;
  }
  
  public String getFloor() {
    return this.floor;
  }
  
  public void setFloor(String floor) {
    this.floor = floor;
  }
  
  public String getConstructionid() {
    return this.constructionid;
  }
  
  public void setConstructionid(String constructionid) {
    this.constructionid = constructionid;
  }
  
  public String getRoomtype() {
    return this.roomtype;
  }
  
  public void setRoomtype(String roomtype) {
    this.roomtype = roomtype;
  }
  
  public String getFirstdayofbusiness() {
    return this.firstdayofbusiness;
  }
  
  public void setFirstdayofbusiness(String firstdayofbusiness) {
    this.firstdayofbusiness = firstdayofbusiness;
  }
  
  public String getFistdayofinstall() {
    return this.fistdayofinstall;
  }
  
  public void setFistdayofinstall(String fistdayofinstall) {
    this.fistdayofinstall = fistdayofinstall;
  }
  
  public String getPosttoerpname() {
    return this.posttoerpname;
  }
  
  public void setPosttoerpname(String posttoerpname) {
    this.posttoerpname = posttoerpname;
  }
  
  public String getPosttoerpemail() {
    return this.posttoerpemail;
  }
  
  public void setPosttoerpemail(String posttoerpemail) {
    this.posttoerpemail = posttoerpemail;
  }
  
  public String getStockreservationon() {
    return this.stockreservationon;
  }
  
  public void setStockreservationon(String stockreservationon) {
    this.stockreservationon = stockreservationon;
  }
  
  public String getPricerulereference() {
    return this.pricerulereference;
  }
  
  public void setPricerulereference(String pricerulereference) {
    this.pricerulereference = pricerulereference;
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
    direct.dbusername = dbusername;
  }
  
  public static String getDbpassword() {
    return dbpassword;
  }
  
  public static void setDbpassword(String dbpassword) {
    direct.dbpassword = dbpassword;
  }
	
	public static String dbName="c1ppms";
	
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static void main(String[] args) {}
  
  private String setMysqDateDirects(String sDate) {
    String sResult = "";
    if (sDate == null)
      sDate = "9999-01-01"; 
    if (sDate.equals(""))
      sDate = "9999-01-01"; 
    if (sDate.contentEquals("null"))
      sDate = "9999-01-01"; 
    try {
      sResult = sDate.substring(0, 10);
    } catch (Exception e) {
      System.out.println("Error Convert Date Directs = " + e.getLocalizedMessage());
      sResult = "9999-01-01";
    } 
    return sResult;
  }
  
  private String setDateDirects(String sDate) {
    String sResult = "";
    if (sDate == null)
      sDate = ""; 
    if (sDate.equals(""))
      sDate = ""; 
    if (sDate.contentEquals("null"))
      sDate = ""; 
    try {
      if (sDate.length() >= 10) {
        sResult = sDate.substring(0, 10);
      } else {
        sResult = sDate;
      } 
    } catch (Exception e) {
      System.out.println("Error Convert Date Directs = " + e.getLocalizedMessage());
      sResult = "9999-01-01";
    } 
    return sResult;
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
    String query = "SELECT `id` from `direct` where `idrecord`=\"" + sIDRecord + "\"";
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
  
  public String setMaxSize(String sData, int iMax, boolean fromLeft) {
    String sResult = "";
    if (sData == null)
      sData = ""; 
    if (sData.equals(""))
      sData = ""; 
    if (sData.contentEquals("null"))
      sData = ""; 
    if (sData.length() >= iMax)
      if (fromLeft) {
        sResult = sData.substring(0, iMax);
      } else {
        sResult = sData.substring(sData.length() - iMax, sData.length());
      }  
    return sResult;
  }
  
  public void dbUpdateOrder() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryIDRecord(getIdrecord());
      setId(sID);
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `direct`(`idrecord`, `region`, `ddentity`, `buyername`, `ponumber`, `podate`, `confirmationno`, `requester`, `manufacturer`, `mfrpartnumber`, `itemdescription`, `preferredsupplier`, `status`, `quantity`, `grosscostusd`, `grosstotalusd`, `salesoficecode`, `salesoffice`, `orderreason`, `orderreasoncode`, `so`, `quotename`, `quoteno`, `sfdcno`, `projectcode`, `department`, `grosscost`, `grosstotal`, `poreceiveddate`, `neededby`, `datecreated`, `datesubmitted`, `datepurchased`, `dateaccepted`, `datemfrscheduled`, `dateshipped`, `datedelivered`, `dateinvoiced`, `budgetcostusd`, `budgettotalusd`, `dealid`, `dateestimatedship`, `dateestimateddelivery`, `itemcategory`, `itemtypename`, `plantname`, `producttype`, `category`, `listpriceusd`, `quotedcratedby`, `requestoremailaddress`, `shipcontactname`, `shipcontactemail`, `nettotalusd`, `netbuyusd`, `idrow`, `listprice`, `vendorponumber`, `invoice`, `financecode`, `grossprofit`, `ordermanagement`, `customercode`, `buyerurl`, `buyertype`, `buyergroup`, `ddgroupid`, `intercompanyno`, `convertedby`, `isdataentry`, `isselfservice`, `billcountry`, `deliverycountry`, `currency`, `posttoerpstatus`, `posttoerpdesc`, `datequoterequest`, `catalogname`, `intercompanyitem`, `itemcategorycode`, `plantcode`, `preferredsuppliercode`, `uploaded`, `catalogcost`, `catalogsell`, `cataloglist`, `catalogcurrency`, `regionalbuyergroup`, `preelaprice`, `preelabaseprice`, `serialnumber`, `clientbusinessunit`, `rewsid`, `floor`, `constructionid`, `roomtype`, `firstdayofbusiness`, `fistdayofinstall`, `posttoerpname`, `posttoerpemail`, `stockreservationon`, `pricerulereference`, `createdon`, `updatedon`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdrecord());
        preparedStmt.setString(2, getRegion());
        preparedStmt.setString(3, getDdentity());
        preparedStmt.setString(4, getBuyername());
        preparedStmt.setString(5, getPonumber());
        preparedStmt.setString(6, setMysqDateDirects(getPodate()));
        preparedStmt.setString(7, getConfirmationno());
        preparedStmt.setString(8, getRequester());
        preparedStmt.setString(9, getManufacturer());
        preparedStmt.setString(10, getMfrpartnumber());
        preparedStmt.setString(11, getItemdescription());
        preparedStmt.setString(12, getPreferredsupplier());
        preparedStmt.setString(13, getStatus());
        preparedStmt.setFloat(14, getFloatValue(getQuantity()).floatValue());
        preparedStmt.setFloat(15, getFloatValue(getGrosscostusd()).floatValue());
        preparedStmt.setFloat(16, getFloatValue(getGrosstotalusd()).floatValue());
        preparedStmt.setString(17, getSalesoficecode());
        preparedStmt.setString(18, getSalesoffice());
        preparedStmt.setString(19, getOrderreason());
        preparedStmt.setString(20, getOrderreasoncode());
        preparedStmt.setString(21, getSo());
        preparedStmt.setString(22, getQuotename());
        preparedStmt.setString(23, getQuoteno());
        preparedStmt.setString(24, setMaxSize(getSfdcno(), 18, true));
        preparedStmt.setString(25, getProjectcode());
        preparedStmt.setString(26, getDepartment());
        preparedStmt.setFloat(27, getFloatValue(getGrosscost()).floatValue());
        preparedStmt.setFloat(28, getFloatValue(getGrosstotal()).floatValue());
        preparedStmt.setString(29, setMysqDateDirects(getPoreceiveddate()));
        preparedStmt.setString(30, setMysqDateDirects(getNeededby()));
        preparedStmt.setString(31, setMysqDateDirects(getDatecreated()));
        preparedStmt.setString(32, setMysqDateDirects(getDatesubmitted()));
        preparedStmt.setString(33, setMysqDateDirects(getDatepurchased()));
        preparedStmt.setString(34, setMysqDateDirects(getDateaccepted()));
        preparedStmt.setString(35, setMysqDateDirects(getDatemfrscheduled()));
        preparedStmt.setString(36, setMysqDateDirects(getDateshipped()));
        preparedStmt.setString(37, setMysqDateDirects(getDatedelivered()));
        preparedStmt.setString(38, setMysqDateDirects(getDateinvoiced()));
        preparedStmt.setFloat(39, getFloatValue(getBudgetcostusd()).floatValue());
        preparedStmt.setFloat(40, getFloatValue(getBudgettotalusd()).floatValue());
        preparedStmt.setString(41, getDealid());
        preparedStmt.setString(42, setMysqDateDirects(getDateestimatedship()));
        preparedStmt.setString(43, setMysqDateDirects(getDateestimateddelivery()));
        preparedStmt.setString(44, getItemcategory());
        preparedStmt.setString(45, getItemtypename());
        preparedStmt.setString(46, getPlantname());
        preparedStmt.setInt(47, getIntValue(getProducttype()));
        preparedStmt.setString(48, getCategory());
        preparedStmt.setFloat(49, getFloatValue(getListpriceusd()).floatValue());
        preparedStmt.setString(50, getQuotedcratedby());
        preparedStmt.setString(51, getRequestoremailaddress());
        preparedStmt.setString(52, getShipcontactname());
        preparedStmt.setString(53, getShipcontactemail());
        preparedStmt.setFloat(54, getFloatValue(getNettotalusd()).floatValue());
        preparedStmt.setFloat(55, getFloatValue(getNetbuyusd()).floatValue());
        preparedStmt.setInt(56, getIntValue(getIdrow()));
        preparedStmt.setFloat(57, getFloatValue(getListprice()).floatValue());
        preparedStmt.setString(58, getVendorponumber());
        preparedStmt.setString(59, getInvoice());
        preparedStmt.setString(60, getFinancecode());
        preparedStmt.setFloat(61, getFloatValue(getGrossprofit()).floatValue());
        preparedStmt.setString(62, getOrdermanagement());
        preparedStmt.setString(63, getCustomercode());
        preparedStmt.setString(64, getBuyerurl());
        preparedStmt.setString(65, getBuyertype());
        preparedStmt.setString(66, getBuyergroup());
        preparedStmt.setString(67, getDdgroupid());
        preparedStmt.setString(68, getIntercompanyno());
        preparedStmt.setString(69, getConvertedby());
        preparedStmt.setString(70, getIsdataentry());
        preparedStmt.setString(71, getIsselfservice());
        preparedStmt.setString(72, getBillcountry());
        preparedStmt.setString(73, getDeliverycountry());
        preparedStmt.setString(74, getCurrency());
        preparedStmt.setString(75, getPosttoerpstatus());
        preparedStmt.setString(76, getPosttoerpdesc());
        preparedStmt.setString(77, setMysqDateDirects(getDatequoterequest()));
        preparedStmt.setString(78, getCatalogname());
        preparedStmt.setString(79, getIntercompanyitem());
        preparedStmt.setString(80, getItemcategorycode());
        preparedStmt.setString(81, getPlantcode());
        preparedStmt.setString(82, getPreferredsuppliercode());
        preparedStmt.setString(83, getUploaded());
        preparedStmt.setFloat(84, getFloatValue(getCatalogcost()).floatValue());
        preparedStmt.setFloat(85, getFloatValue(getCatalogsell()).floatValue());
        preparedStmt.setFloat(86, getFloatValue(getCataloglist()).floatValue());
        preparedStmt.setString(87, getCatalogcurrency());
        preparedStmt.setString(88, getRegionalbuyergroup());
        preparedStmt.setFloat(89, getFloatValue(getPreelaprice()).floatValue());
        preparedStmt.setFloat(90, getFloatValue(getPreelabaseprice()).floatValue());
        preparedStmt.setString(91, getSerialnumber());
        preparedStmt.setString(92, getClientbusinessunit());
        preparedStmt.setString(93, getRewsid());
        preparedStmt.setString(94, getFloor());
        preparedStmt.setString(95, getConstructionid());
        preparedStmt.setString(96, getRoomtype());
        preparedStmt.setString(97, setDateDirects(getFirstdayofbusiness()));
        preparedStmt.setString(98, setDateDirects(getFistdayofinstall()));
        preparedStmt.setString(99, getPosttoerpname());
        preparedStmt.setString(100, getPosttoerpemail());
        preparedStmt.setString(101, setMysqDateDirects(getStockreservationon()));
        preparedStmt.setString(102, getPricerulereference());
        preparedStmt.setTimestamp(103, updatedAt);
        preparedStmt.setTimestamp(104, updatedAt);
        preparedStmt.execute();
        preparedStmt.close();
      } else {
        sQuery = "UPDATE `direct` set `idrecord`=?, `region`=?, `ddentity`=?, `buyername`=?, `ponumber`=?, `podate`=?, `confirmationno`=?, `requester`=?, `manufacturer`=?, `mfrpartnumber`=?, `itemdescription`=?, `preferredsupplier`=?, `status`=?, `quantity`=?, `grosscostusd`=?, `grosstotalusd`=?, `salesoficecode`=?, `salesoffice`=?, `orderreason`=?, `orderreasoncode`=?, `so`=?, `quotename`=?, `quoteno`=?, `sfdcno`=?, `projectcode`=?, `department`=?, `grosscost`=?, `grosstotal`=?, `poreceiveddate`=?, `neededby`=?, `datecreated`=?, `datesubmitted`=?, `datepurchased`=?, `dateaccepted`=?, `datemfrscheduled`=?, `dateshipped`=?, `datedelivered`=?, `dateinvoiced`=?, `budgetcostusd`=?, `budgettotalusd`=?, `dealid`=?, `dateestimatedship`=?, `dateestimateddelivery`=?, `itemcategory`=?, `itemtypename`=?, `plantname`=?, `producttype`=?, `category`=?, `listpriceusd`=?, `quotedcratedby`=?, `requestoremailaddress`=?, `shipcontactname`=?, `shipcontactemail`=?, `nettotalusd`=?, `netbuyusd`=?, `idrow`=?, `listprice`=?, `vendorponumber`=?, `invoice`=?, `financecode`=?, `grossprofit`=?, `ordermanagement`=?, `customercode`=?, `buyerurl`=?, `buyertype`=?, `buyergroup`=?, `ddgroupid`=?, `intercompanyno`=?, `convertedby`=?, `isdataentry`=?, `isselfservice`=?, `billcountry`=?, `deliverycountry`=?, `currency`=?, `posttoerpstatus`=?, `posttoerpdesc`=?, `datequoterequest`=?, `catalogname`=?, `intercompanyitem`=?, `itemcategorycode`=?, `plantcode`=?, `preferredsuppliercode`=?, `uploaded`=?, `catalogcost`=?, `catalogsell`=?, `cataloglist`=?, `catalogcurrency`=?, `regionalbuyergroup`=?, `preelaprice`=?, `preelabaseprice`=?, `serialnumber`=?, `clientbusinessunit`=?, `rewsid`=?, `floor`=?, `constructionid`=?, `roomtype`=?, `firstdayofbusiness`=?, `fistdayofinstall`=?, `posttoerpname`=?, `posttoerpemail`=?, `stockreservationon`=?, `pricerulereference`=?, `updatedon`=? WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdrecord());
        preparedStmt.setString(2, getRegion());
        preparedStmt.setString(3, getDdentity());
        preparedStmt.setString(4, getBuyername());
        preparedStmt.setString(5, getPonumber());
        preparedStmt.setString(6, setMysqDateDirects(getPodate()));
        preparedStmt.setString(7, getConfirmationno());
        preparedStmt.setString(8, getRequester());
        preparedStmt.setString(9, getManufacturer());
        preparedStmt.setString(10, getMfrpartnumber());
        preparedStmt.setString(11, getItemdescription());
        preparedStmt.setString(12, getPreferredsupplier());
        preparedStmt.setString(13, getStatus());
        preparedStmt.setFloat(14, getFloatValue(getQuantity()).floatValue());
        preparedStmt.setFloat(15, getFloatValue(getGrosscostusd()).floatValue());
        preparedStmt.setFloat(16, getFloatValue(getGrosstotalusd()).floatValue());
        preparedStmt.setString(17, getSalesoficecode());
        preparedStmt.setString(18, getSalesoffice());
        preparedStmt.setString(19, getOrderreason());
        preparedStmt.setString(20, getOrderreasoncode());
        preparedStmt.setString(21, getSo());
        preparedStmt.setString(22, getQuotename());
        preparedStmt.setString(23, getQuoteno());
        preparedStmt.setString(24, setMaxSize(getSfdcno(), 18, true));
        preparedStmt.setString(25, getProjectcode());
        preparedStmt.setString(26, getDepartment());
        preparedStmt.setFloat(27, getFloatValue(getGrosscost()).floatValue());
        preparedStmt.setFloat(28, getFloatValue(getGrosstotal()).floatValue());
        preparedStmt.setString(29, setMysqDateDirects(getPoreceiveddate()));
        preparedStmt.setString(30, setMysqDateDirects(getNeededby()));
        preparedStmt.setString(31, setMysqDateDirects(getDatecreated()));
        preparedStmt.setString(32, setMysqDateDirects(getDatesubmitted()));
        preparedStmt.setString(33, setMysqDateDirects(getDatepurchased()));
        preparedStmt.setString(34, setMysqDateDirects(getDateaccepted()));
        preparedStmt.setString(35, setMysqDateDirects(getDatemfrscheduled()));
        preparedStmt.setString(36, setMysqDateDirects(getDateshipped()));
        preparedStmt.setString(37, setMysqDateDirects(getDatedelivered()));
        preparedStmt.setString(38, setMysqDateDirects(getDateinvoiced()));
        preparedStmt.setFloat(39, getFloatValue(getBudgetcostusd()).floatValue());
        preparedStmt.setFloat(40, getFloatValue(getBudgettotalusd()).floatValue());
        preparedStmt.setString(41, getDealid());
        preparedStmt.setString(42, setMysqDateDirects(getDateestimatedship()));
        preparedStmt.setString(43, setMysqDateDirects(getDateestimateddelivery()));
        preparedStmt.setString(44, getItemcategory());
        preparedStmt.setString(45, getItemtypename());
        preparedStmt.setString(46, getPlantname());
        preparedStmt.setInt(47, getIntValue(getProducttype()));
        preparedStmt.setString(48, getCategory());
        preparedStmt.setFloat(49, getFloatValue(getListpriceusd()).floatValue());
        preparedStmt.setString(50, getQuotedcratedby());
        preparedStmt.setString(51, getRequestoremailaddress());
        preparedStmt.setString(52, getShipcontactname());
        preparedStmt.setString(53, getShipcontactemail());
        preparedStmt.setFloat(54, getFloatValue(getNettotalusd()).floatValue());
        preparedStmt.setFloat(55, getFloatValue(getNetbuyusd()).floatValue());
        preparedStmt.setInt(56, getIntValue(getIdrow()));
        preparedStmt.setFloat(57, getFloatValue(getListprice()).floatValue());
        preparedStmt.setString(58, getVendorponumber());
        preparedStmt.setString(59, getInvoice());
        preparedStmt.setString(60, getFinancecode());
        preparedStmt.setFloat(61, getFloatValue(getGrossprofit()).floatValue());
        preparedStmt.setString(62, getOrdermanagement());
        preparedStmt.setString(63, getCustomercode());
        preparedStmt.setString(64, getBuyerurl());
        preparedStmt.setString(65, getBuyertype());
        preparedStmt.setString(66, getBuyergroup());
        preparedStmt.setString(67, getDdgroupid());
        preparedStmt.setString(68, getIntercompanyno());
        preparedStmt.setString(69, getConvertedby());
        preparedStmt.setString(70, getIsdataentry());
        preparedStmt.setString(71, getIsselfservice());
        preparedStmt.setString(72, getBillcountry());
        preparedStmt.setString(73, getDeliverycountry());
        preparedStmt.setString(74, getCurrency());
        preparedStmt.setString(75, getPosttoerpstatus());
        preparedStmt.setString(76, getPosttoerpdesc());
        preparedStmt.setString(77, setMysqDateDirects(getDatequoterequest()));
        preparedStmt.setString(78, getCatalogname());
        preparedStmt.setString(79, getIntercompanyitem());
        preparedStmt.setString(80, getItemcategorycode());
        preparedStmt.setString(81, getPlantcode());
        preparedStmt.setString(82, getPreferredsuppliercode());
        preparedStmt.setString(83, getUploaded());
        preparedStmt.setFloat(84, getFloatValue(getCatalogcost()).floatValue());
        preparedStmt.setFloat(85, getFloatValue(getCatalogsell()).floatValue());
        preparedStmt.setFloat(86, getFloatValue(getCataloglist()).floatValue());
        preparedStmt.setString(87, getCatalogcurrency());
        preparedStmt.setString(88, getRegionalbuyergroup());
        preparedStmt.setFloat(89, getFloatValue(getPreelaprice()).floatValue());
        preparedStmt.setFloat(90, getFloatValue(getPreelabaseprice()).floatValue());
        preparedStmt.setString(91, getSerialnumber());
        preparedStmt.setString(92, getClientbusinessunit());
        preparedStmt.setString(93, getRewsid());
        preparedStmt.setString(94, getFloor());
        preparedStmt.setString(95, getConstructionid());
        preparedStmt.setString(96, getRoomtype());
        preparedStmt.setString(97, setDateDirects(getFirstdayofbusiness()));
        preparedStmt.setString(98, setDateDirects(getFistdayofinstall()));
        preparedStmt.setString(99, getPosttoerpname());
        preparedStmt.setString(100, getPosttoerpemail());
        preparedStmt.setString(101, setMysqDateDirects(getStockreservationon()));
        preparedStmt.setString(102, getPricerulereference());
        preparedStmt.setTimestamp(103, updatedAt);
        preparedStmt.setInt(104, getIntValue(sID));
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


/* Location:              D:\Rpa\rpappms\!\direct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */