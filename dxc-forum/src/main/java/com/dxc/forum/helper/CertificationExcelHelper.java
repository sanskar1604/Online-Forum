package com.dxc.forum.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.entity.Certification;

public class CertificationExcelHelper {

	//check that file is of excel type or not
			public static boolean checkExcelFormat(MultipartFile file) throws NullPointerException {
				String contentType = file.getContentType();
				if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
					return true;
				}else {
					return false;
				}
			}
			
			//Convert excel to list
			public static List<Certification> convertExcelToList(InputStream is){
				List<Certification> list = new ArrayList<>();
				try {
					XSSFWorkbook workbook = new XSSFWorkbook(is);
					XSSFSheet sheet = workbook.getSheet("Certificate");
					int rowNumber = 0;
					Iterator<Row> iterator = sheet.iterator();
					while(iterator.hasNext()) {
						Row row = iterator.next();
						if(rowNumber == 0) {
							rowNumber++;
							continue;
						}
						Iterator<Cell> cells = row.iterator();
						int cid = 0;
						Certification certificate = new Certification();
						while(cells.hasNext()) {
							Cell cell = cells.next();
							switch(cid) {
								case 0: 
									certificate.setEmpId((int)cell.getNumericCellValue());
									break;
								case 1:
									certificate.setEmpName(cell.getStringCellValue());
									break;
								case 2:
									certificate.setEmpEmail(cell.getStringCellValue());
									break;
								case 3: 
									certificate.setVoucher(cell.getStringCellValue());
									break;
								case 4:
									certificate.setStatus(cell.getStringCellValue());
									break;
								case 5:
									certificate.setDate(cell.getDateCellValue());
									break;
								case 6:
									certificate.setRemarks(cell.getStringCellValue());
									break;
								default:
									break;
							}
							cid++;
						}
						list.add(certificate);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return list;
			}
}
