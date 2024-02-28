package Utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utility {
  public static FileInputStream fi;
  public static FileOutputStream fo;
  public static XSSFWorkbook wb;
  public static XSSFSheet ws;
  public static XSSFRow row;
  public static XSSFCell cell;
  public static CellStyle style;
  public  String xlfile; 
  
  
  public excel_utility(String xlfile)
  {
    this.xlfile=xlfile;
  }
  public String getCellData(String xlsheet,int rownum,int colnum) throws IOException, FileNotFoundException
  {
    fi = new FileInputStream(xlfile);
    wb = new XSSFWorkbook(fi);
    ws=wb.getSheet(xlsheet);
    row=ws.getRow(rownum);
    cell=row.getCell(colnum);
  
    String data;
    try 
    {
      //data=cell.toString();
      
      DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            return data;
    }
    catch (Exception e) 
    {
      data="";
    }
    
    wb.close();
    fi.close();
    return data;
  }
  
  public void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException
  {
    fi=new FileInputStream(xlfile);
    wb=new XSSFWorkbook(fi);
    ws=wb.getSheet(xlsheet);
    row=ws.createRow(rownum);
    row=ws.getRow(rownum);
    cell=row.getCell(colnum);
    cell=row.createCell(colnum);
    cell.setCellValue(data);
    fo=new FileOutputStream(xlfile);
    wb.write(fo);    
    wb.close();
    fi.close();
    fo.close();
   }
   }
  
  