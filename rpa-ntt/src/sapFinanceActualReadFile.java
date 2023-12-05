import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class sapFinanceActualReadFile {
  
	private static String getDBDateFormat(String sFromDate) {
		 String rslt="";
		 try{
		 if (sFromDate==null) {
			 sFromDate=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 }
		 
		 
		  LocalDate convertedDate = LocalDate.parse(sFromDate);
		
		  rslt=convertedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		  
		 } catch (Exception e) {
			 System.out.println(e.getLocalizedMessage());
		 }
		  
		  return rslt;
	  }
	
	
	public static void search(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }

        }
    }
	
  public static void loadfile(String sFileName, String sYearMonth, String sCompanyCode, String sPCCode) {
    try {
      FileInputStream excelFile = new FileInputStream(new File(sFileName));
      XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = xSSFWorkbook.getSheetAt(0);
      Iterator<Row> iterator = datatypeSheet.iterator();
      int iLine=0;
      
      
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      
      Row row = datatypeSheet.getRow(0); //Get first row
      //following is boilerplate from the java doc
      short minColIx = row.getFirstCellNum(); //get the first column index for a row
      short maxColIx = row.getLastCellNum(); //get the last column index for a row
      
      for(short colIx=minColIx; colIx<maxColIx; colIx++) { //loop from first to last index
         Cell cell = row.getCell(colIx); //get the cell
       
		map.put(cell.getStringCellValue(),cell.getColumnIndex()); //add the cell contents (name of column) and cell index to the map
       }
      
      iterator.next();
      dbSAPFinanceActual db = new dbSAPFinanceActual();      
      db.initIndex(map);
      db.delete(sYearMonth, sCompanyCode, sPCCode);
      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
        
        for(short colIx=minColIx; colIx<maxColIx; colIx++) { //loop from first to last index
            Cell cell = currentRow.getCell(colIx); //get the cell
            String sValue="";
            if (cell!=null) {
            	
	            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	            	
	            	if (HSSFDateUtil.isCellDateFormatted(cell)) {
	            		try {
	            			sValue= cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()+"";
	            		} catch (Exception e) {
	            			sValue= null;
	            		}
	            	} else {
	            		sValue = cell.getNumericCellValue()+"";
	            	}
	            } else {
	            	 sValue = cell.getStringCellValue();
	            }
            }
            
            if (sValue.equals("")) sValue=null;
           
            
           db.list.add(sValue);
            
            //System.out.println(iLine+"["+colIx+"]: "+sValue);
            
            
          }
        
        //add additional code
        db.CompanyCode=sCompanyCode;
        db.PCCode = sPCCode;
        //insert record here
        db.Load();
        iLine++;
       
      }
      
      db.close();
      
      excelFile.close();
      excelFile=null;
      System.gc();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
    	e.printStackTrace();
    }
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
  
  
 public static void processFile(String sYearMonth, String sCompanyCode, String sPCCode) {
	  
	  File dir = new File("C:\\ppms\\download\\SAP");
	  File gFDownloaded = null;
	     
     
    	            File[] filesInDir = dir.listFiles();
    	            for (File fileInDir : filesInDir) {
    	                if (fileInDir.getName().endsWith(".xlsx")) {
    	                		
    	                	gFDownloaded=fileInDir;
    	                	System.out.println("Found File: "+gFDownloaded.getName());
    	                	
    	                	//load record
    	                	loadfile(gFDownloaded.getPath(), sYearMonth, sCompanyCode, sPCCode);
    	                	 //remove the file after processed
    	              	    try {
    	                  	String sNewFile ="c:\\ppms\\archive\\SAP\\"+gFDownloaded.getName();
    	                  	moveFile(gFDownloaded.getPath(), sNewFile);
    	                  	System.out.println("Moved File: "+gFDownloaded.getName());
    	              	    } catch (Exception e) {
    	              	    	System.out.println("ERROR: movefile: " + gFDownloaded);
    	              		      System.out.println(e.getMessage());
    	              	    }
    	                  	
    	                	
    	                } else {
    	                	System.out.print("File not found");
    	                }
    	            }
    	       
  }
  
  public static void main(String[] args) {
	 
	  
	  processFile("2022/01","SG01", "SharedServices");
    	       

          
       
  	    
      
      
    //loadfile("C:\\ppms\\download\\SAP\\8aec267c1a144b2bb9588882fc46a6b9-01.03.2021-31.03.2021.xlsx");
  }
}


/* Location:              D:\Rpa\rpappms\!\ApachePOIExcelRead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */