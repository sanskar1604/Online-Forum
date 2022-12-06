package com.dxc.forum.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.entity.UploadSession;

public class SessionExcelHelper {

	// check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file) throws NullPointerException {
		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	// Convert excel to list
	public static List<UploadSession> convertExcelToList(InputStream is) {
		List<UploadSession> list = new ArrayList<>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Training");
			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid = 0;
				UploadSession uploadSession = new UploadSession();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					switch (cid) {
					case 0:
						uploadSession.setBatch(cell.getStringCellValue());
						break;
					case 1:
						uploadSession.setTopicName(cell.getStringCellValue());
						break;
					case 2:
						uploadSession.setTrainerName(cell.getStringCellValue());
						break;
					case 3:
						uploadSession.setBatchSize((int)cell.getNumericCellValue());
						break;
					case 4:
						uploadSession.setSessionDate(cell.getDateCellValue());
						break;
					case 5:
						uploadSession.setSessionLink(cell.getStringCellValue());
						break;
					case 6:
						uploadSession.setSessionVideo(cell.getStringCellValue());
						break;
					default:
						break;
					}
					cid++;
				}
				list.add(uploadSession);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
