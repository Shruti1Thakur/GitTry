package Excel1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;

public class dataDriven {
	//Identify TCs column by scanning 1st row
		//FileasInputstreamobject
	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C://Users//shruti1.thakur//Downloads//DemoData.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			//Identity the Tc column by scanning entire row
			Iterator<Row> rows=sheet.iterator(); //sheet is collection of rows
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator(); //row is Collection of cells
			int k=0;
			int coloumn=0;
			
			while(ce.hasNext())
			{
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
			{
				coloumn=k;
			}
			k++;
			}
			System.out.println(coloumn);
			
			
		// Once coln is identified then scan entire TCs colm to identify purchase TC row
			
			while(rows.hasNext());
			
			{
				Row r=rows.next();
				if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING)
						{
						a.add(cv.next().getStringCellValue());
						}
						else {
							
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}	
				}
				
			}
		}
		

	}
		return a;

	}
}
