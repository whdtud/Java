package jun23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel01 {
	
	public static void main(String[] args) {
		Workbook wb = new HSSFWorkbook(); // 2003 under version - xls
		//Workbook wb1 = new XSSFWorkbook(); // 2003 upper version - xlsx
		
		Sheet sheet = wb.createSheet();
		
		Row row = null;
		Cell cell = null;
		
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("이름");
		cell = row.createCell(1);
		cell.setCellValue("나이");
		cell = row.createCell(2);
		cell.setCellValue("사는곳");

		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("홍길동");
		cell = row.createCell(1);
		cell.setCellValue(150);
		cell = row.createCell(2);
		cell.setCellValue("서울");
		
		File xlsFile = new File("./test.xls");
		
		try {
			FileOutputStream fos = new FileOutputStream(xlsFile);
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("출력완료");
	}
}
