package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	public static void main (String args[]) throws IOException {
		String filepath=".//File//data.xlsx";
	   FileInputStream fis= new FileInputStream(filepath);
	   XSSFWorkbook wb=new XSSFWorkbook(fis);
	   XSSFSheet sh=wb.getSheetAt(0);
	   int row=sh.getLastRowNum();
	   int col=sh.getRow(1).getLastCellNum();
       
    for(int r=0;r<row;r++) {
    	XSSFRow rowdata =sh.getRow(r); 
    	for(int c=0;c<col;c++) {
    		XSSFCell cell=rowdata.getCell(c);
    		System.out.println("the value is "+cell.getStringCellValue());
    	}
    }
	}
}
