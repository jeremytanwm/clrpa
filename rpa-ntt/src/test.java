import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
  public static String getDataJsoup(String sContent, String startKeyword, String endKeyword) {
    String temp = "";
    Document document = Jsoup.parse(sContent);
    System.out.println(document.title());
    Elements paragraphs = document.getElementsByTag("p");
    for (Element paragraph : paragraphs)
      System.out.println(paragraph.text()); 
    System.out.println(temp);
    return temp;
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
  
  
  public String convertDateTime(String sOriginalDate, String sSourceDateFormat, String sToDateFormat) {
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
	      
	      System.out.println("Date is converted from "+sSourceDateFormat+" format to "+sToDateFormat);
	      System.out.println("Converted date is : " + sRslt);
	      
	    }
	    catch(ParseException pe)
	    { 
	      System.out.println("Parse Exception : " + pe);
	    }
	  
	  return sRslt;
	  
  }
  
  public static void main(String[] args) {
	  
	  
	  System.out.println(LocalDateTime.now().getHour());
	  String strDate = "6/25/2021 7:55 PM";
	    
	    try
	    {
	      //create SimpleDateFormat object with source string date format
	      SimpleDateFormat sdfSource = new SimpleDateFormat("M/d/yyyy h:mm aaa");
	      
	      //parse the string into Date object
	      Date date = sdfSource.parse(strDate);
	      
	      //create SimpleDateFormat object with desired date format
	      SimpleDateFormat sdfDestination = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	      
	      //parse the date into another format
	      strDate = sdfDestination.format(date);
	      
	      System.out.println("Date is converted from d/MM/yyyy h:mm aaa format to MM-dd-yyyy hh:mm:ss");
	      System.out.println("Converted date is : " + strDate);
	      
	    }
	    catch(ParseException pe)
	    { 
	      System.out.println("Parse Exception : " + pe);
	    }
	    
	    System.exit(0);
	  
	  String ss="28-Jan-2021 15:36:28";
	  System.out.println(ss.substring(ss.length()-8, ss.length()));
	  System.exit(0);
			  
	  
	  String s="SGP/CL/2021/REQ/00006807 || Request to grant access to eQMS at Plaza Singapura as Concierge will be on exchange program";
	  System.out.println(s);
	  s=s.replaceAll("[^\\p{ASCII}]", "");
	  System.out.println(s);	  
	  System.exit(0);	  
			  
			  
	  
	  System.out.println(setSalesForceDateTimeFormat("28-Jan-2021 15:36:28"));
	  System.exit(0);
    String cssfilter = "title#Master_MasterPageTitle, div.profileRow, div.udfRow";
    File input = new File("E:\\ppms\\tets.htm");
    Document doc = null;
    try {
      doc = Jsoup.parse(input, "UTF-8", "");
    } catch (IOException e) {
      e.printStackTrace();
    } 
    String sContractNumber = doc.select("h1[id=\"Master_IdPageHeaderTitle\"]").text();
    String sBillingOffice = doc.select("div[id=\"BillingOffice\"]").select("span").text();
    String sStatus = doc.select("div[id=\"EngagementStatus\"]").select("span").text();
    String sContractValue = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(0)).text();
    String sCurrency = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(1)).text();
    String sTotalRR = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(2)).text();
    String sTotalCR = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(3)).text();
    String sTotalPCTD = ((Element)doc.select("div[id*=\"ctrl:EngagementText\"]").get(4)).text();
    Element tb = doc.select("table[id=\"RelatedProjects_tblMain\"]").first();
    Element tbody = tb.select("tbody").first();
    Element tr = tbody.selectFirst("tr");
    Elements tds = tr.select("td");
    int index = 0;
    String sIDProject = "";
    String sProjectName = "";
    String sIDPM = "";
    String sPMName = "";
    String sBillable = "";
    String sProjectStatus = "";
    for (Element td : tds) {
      switch (index) {
        case 0:
          sIDProject = td.select("a").attr("href");
          sProjectName = td.select("a").text();
          break;
        case 1:
          sIDPM = td.select("a").attr("href");
          sPMName = td.select("a").text();
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
    System.out.println("end");
  }
}


/* Location:              D:\Rpa\rpappms\!\test.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */