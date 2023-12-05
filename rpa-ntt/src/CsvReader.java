import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvReader {
	
	


	// Java code to illustrate reading a 
	// all data at once 
	public static void readAllDataAtOnce(String file) 
	{ 
	    try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object and skip first Line 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // print Data 
	        for (String[] row : allData) { 
	            for (String cell : row) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 
	
	public static void readDataLineByLine(String file) 
	{ 
	  
	    try { 
	  
	        // Create an object of filereader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object passing 
	        // file reader as a parameter 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	  
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        	int i=0;
	            for (String cell : nextRecord) { 
	                System.out.print(i++ + ":"+ cell + "\t"); 
	            } 
	            System.out.println("----------------------"); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 
	
	
	  public static void main(String[] args) throws Exception {

	        // loads CSV file from the resource folder.
	        //URL resource = Csvparser.class.getClassLoader().getResource("csv/monitor.csv");
	    	
	        //File file = Paths.get(resource.toURI()).toFile();
	        File file = Paths.get("c:\\ppms\\download\\incident-80e34b61f3d5449b9ce63ac4c670b14c.csv").toFile();

	        readDataLineByLine("c:\\ppms\\download\\incident-80e34b61f3d5449b9ce63ac4c670b14c.csv");
	        //readAllDataAtOnce("c:\\ppms\\download\\incident-80e34b61f3d5449b9ce63ac4c670b14c.csv");
	        
	  }
	

}
