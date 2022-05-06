package org.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

	public FileInputStream fi;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	String path = null;

	public Utility(String path) {

		this.path = path;
	}

	public int getRowCount(String name) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(name);

		int rowCount = sh.getLastRowNum();
		fi.close();

		return rowCount;

	}

	public int getCellCount(String name, int rownum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(name);
		row = sh.getRow(rownum);
		int cellCount = row.getLastCellNum();
		fi.close();
		return cellCount;
	}

	public String getCellData(String name, int rownum,int cellnum) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(name);
		row = sh.getRow(rownum);
		cell = row.getCell(cellnum);

		DataFormatter formatter = new DataFormatter();
		String data;

		try {
			data=formatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}
		fi.close();
		return data;
	}

}
