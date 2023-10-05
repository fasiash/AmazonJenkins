package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility_Amazon {
	
	public int GetRowCount(String path, int sheetno) throws Exception
	{
	FileInputStream f=new FileInputStream(path);
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheetAt(sheetno);
	int rowcount=ws.getLastRowNum();
	wb.close();
	return rowcount;

	}

	public Row getRowData(String path,int sheetno,int r) throws Exception
	{
	FileInputStream f=new FileInputStream(path);
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheetAt(sheetno);
	Row row=ws.getRow(r);
	wb.close();
	return row;
	}

	public String getCellData(String path,int sheetno,int r,int c) throws IOException
	{
	FileInputStream f=new FileInputStream(path);
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheetAt(sheetno);
	String data=ws.getRow(r).getCell(c).getStringCellValue();
	wb.close();
	return data;
	}

	public double getCellValue(String path,int sheetno,int r,int c) throws IOException
	{
	FileInputStream f=new FileInputStream(path);
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheetAt(sheetno);
	double data=ws.getRow(r).getCell(c).getNumericCellValue();
	wb.close();
	return data;
	}

	public void setStringCellValue(String data,String path,int Sheetno, int r, int c) throws IOException
	{
	FileInputStream fis=new FileInputStream(path);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet ws= wb.getSheetAt(Sheetno);
	ws.getRow(r).createCell(c).setCellValue(data);
	fis.close();
	FileOutputStream fout=new FileOutputStream(new File(path));
	wb.write(fout);
	fout.close();
	wb.close();
	}

	public void setNumericCellValue(int data,String path,int Sheetno, int r, int c) throws IOException
	{
	FileInputStream fis=new FileInputStream(path);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet ws= wb.getSheetAt(Sheetno);
	ws.getRow(r).createCell(c).setCellValue(data);
	fis.close();
	FileOutputStream fout=new FileOutputStream(new File(path));
	wb.write(fout);
	fout.close();
	wb.close();
	}

}
