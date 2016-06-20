package testngpackage;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelLib {
	
	Workbook wrkBook = null;
	Sheet wrkSheet = null;
	Hashtable dict= new Hashtable();
			
	public ExcelLib(String path)  {
		try {
			wrkBook = Workbook.getWorkbook(new File(path));
			wrkSheet = wrkBook.getSheet("Sheet1");
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Returns the number of rows
	public int rowCount(){
		return wrkSheet.getRows();
	}
	
	//Returns the cell value by taking row and column values as argument
	public String GetCellValue(int colNumber, int rowNumber){
		return wrkBook.getSheet(0).getCell(colNumber, rowNumber).getContents();
	}
	
	public String GetCellValue1(String columnName, int rowNumber){
		return GetCellValue(Cellvalue(columnName), rowNumber);
	}
	
	//Create Column Dictionary to hold all the Column Names
	public void ColumnDictionary()
		{
			//Iterate through all the columns in the Excel sheet and store the value in Hashtable
			for(int col=0; col<wrkSheet.getColumns(); col++)
			{
				dict.put(GetCellValue(col,0), col);
			}
		}
	 
		//Read Column Names
		public int Cellvalue(String colName)
		{
			try {
				int value;
				value = ((Integer) dict.get(colName)).intValue();
				return value;
			} catch (NullPointerException e) {
				return (0);
	 
			}
		}


}
