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

import com.dxc.forum.entity.Mentoring;

public class MentoringExcelHelper {

	
	//check that file is of excel type or not
		public static boolean checkExcelFormat(MultipartFile file)throws NullPointerException {
			String contentType = file.getContentType();
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				return true;
			}else {
				return false;
			}
		}
		
		//Convert excel to list
		public static List<Mentoring> convertExcelToList(InputStream is){
			List<Mentoring> list = new ArrayList<>();
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(is);
				XSSFSheet sheet = workbook.getSheet("Mentoring");
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
					Mentoring mentor = new Mentoring();
					while(cells.hasNext()) {
						Cell cell = cells.next();
						switch(cid) {
							case 0: 
								mentor.setBatch(cell.getStringCellValue());
								break;
							case 1:
								mentor.setEmpId((int)cell.getNumericCellValue());
								break;
							case 2:
								mentor.setName(cell.getStringCellValue());
								break;
							case 3: 
								mentor.setEmail(cell.getStringCellValue());
								break;
							case 4:
								mentor.setHeScore((int)cell.getNumericCellValue());
								break;
							case 5:
								mentor.setUpdateDate(cell.getDateCellValue());
								break;
							case 6:
								mentor.setHeRank((int)cell.getNumericCellValue());
								break;
							case 7:
								mentor.setProject(cell.getStringCellValue());
								break;
							case 8:
								mentor.setProjectTitle(cell.getStringCellValue());
								break;
							case 9:
								mentor.setTechStack(cell.getStringCellValue());
								break;
							case 10:
								mentor.setProjectStatus(cell.getStringCellValue());
								break;
							default:
								break;
						}
						cid++;
					}
					list.add(mentor);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
}
