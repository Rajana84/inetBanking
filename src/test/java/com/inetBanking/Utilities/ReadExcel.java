package com.inetBanking.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	FileInputStream oFile;
	XSSFWorkbook oWorkBook;
	XSSFSheet oSheet;
	XSSFRow oRow;
	XSSFCell oCol;
	
	public ReadExcel(String filepath,String sheetNam) throws IOException {
	oFile = new FileInputStream(filepath);
	oWorkBook = new XSSFWorkbook(oFile);
	oSheet = oWorkBook.getSheet(sheetNam);				
	}
	
	public String getcelldata(int rownum,int cellnum) throws IOException {
		XSSFRow oRow = oSheet.getRow(rownum);
		XSSFCell oCol = oRow.getCell(cellnum);
		String cellVal = oCol.getStringCellValue();
		oWorkBook.close();
		return cellVal;
	}
	
	public Object[][]readcelldata() throws IOException {
		
		Object[][]PefinExcl= null;
		
		oRow = oSheet.getRow(0);
		
		int rownum =oSheet.getLastRowNum();
		int cellnum = oRow.getLastCellNum();
		
		PefinExcl = new String [rownum][cellnum];
		
	 for(int i=1;i<=rownum;i++) {
		for(int j=0;j<cellnum;j++) {
			PefinExcl[i-1][j]=this.getcelldata(i,j);							
			}
		}
	return PefinExcl;
	}
}
