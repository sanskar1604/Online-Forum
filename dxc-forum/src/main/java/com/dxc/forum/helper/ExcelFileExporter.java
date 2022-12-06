package com.dxc.forum.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dxc.forum.entity.Certification;
import com.dxc.forum.entity.Mentoring;
import com.dxc.forum.entity.UploadSession;

public class ExcelFileExporter {

	//For Certificate Excel Download
	public static ByteArrayInputStream certificateListToExcelFile(List<Certification> certificates) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Certificate");
			
			Row row = sheet.createRow(0);
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        Cell cell = row.createCell(0);
	        cell.setCellValue("empId");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("empName");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(2);
	        cell.setCellValue("empEmail");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("voucher");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(4);
	        cell.setCellValue("status");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(5);
	        cell.setCellValue("date");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(6);
	        cell.setCellValue("remarks");
	        cell.setCellStyle(headerCellStyle);
	        
	     // Creating data rows for each customer
	        for(int i = 0; i < certificates.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(certificates.get(i).getEmpId());
	        	dataRow.createCell(1).setCellValue(certificates.get(i).getEmpName());
	        	dataRow.createCell(2).setCellValue(certificates.get(i).getEmpEmail());
	        	dataRow.createCell(3).setCellValue(certificates.get(i).getVoucher());
	        	dataRow.createCell(4).setCellValue(certificates.get(i).getStatus());
	        	dataRow.createCell(5).setCellValue(certificates.get(i).getDate());
	        	dataRow.createCell(6).setCellValue(certificates.get(i).getRemarks());
	        }
	        
	     // Making size of column auto resize to fit with data
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        sheet.autoSizeColumn(4);
	        sheet.autoSizeColumn(5);
	        sheet.autoSizeColumn(6);
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//For Mentor Excel Download
		public static ByteArrayInputStream mentoringListToExcelFile(List<Mentoring> mentor) {
			try(Workbook workbook = new XSSFWorkbook()){
				Sheet sheet = workbook.createSheet("Mentoring");
				
				Row row = sheet.createRow(0);
				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		        
		        Cell cell = row.createCell(0);
		        cell.setCellValue("batch");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(1);
		        cell.setCellValue("empId");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(2);
		        cell.setCellValue("name");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(3);
		        cell.setCellValue("email");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(4);
		        cell.setCellValue("heScore");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(5);
		        cell.setCellValue("updateDate");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(6);
		        cell.setCellValue("heRank");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(7);
		        cell.setCellValue("project");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(8);
		        cell.setCellValue("projectTitle");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(9);
		        cell.setCellValue("techStack");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(10);
		        cell.setCellValue("projectStatus");
		        cell.setCellStyle(headerCellStyle);
		        
		     // Creating data rows for each customer
		        for(int i = 0; i < mentor.size(); i++) {
		        	Row dataRow = sheet.createRow(i + 1);
		        	dataRow.createCell(0).setCellValue(mentor.get(i).getBatch());
		        	dataRow.createCell(1).setCellValue(mentor.get(i).getEmpId());
		        	dataRow.createCell(2).setCellValue(mentor.get(i).getName());
		        	dataRow.createCell(3).setCellValue(mentor.get(i).getEmail());
		        	dataRow.createCell(4).setCellValue(mentor.get(i).getHeScore());
		        	dataRow.createCell(5).setCellValue(mentor.get(i).getUpdateDate());
		        	dataRow.createCell(6).setCellValue(mentor.get(i).getHeRank());
		        	dataRow.createCell(7).setCellValue(mentor.get(i).getProject());
		        	dataRow.createCell(8).setCellValue(mentor.get(i).getProjectTitle());
		        	dataRow.createCell(9).setCellValue(mentor.get(i).getTechStack());
		        	dataRow.createCell(10).setCellValue(mentor.get(i).getProjectStatus());
		        }
		        
		     // Making size of column auto resize to fit with data
		        sheet.autoSizeColumn(0);
		        sheet.autoSizeColumn(1);
		        sheet.autoSizeColumn(2);
		        sheet.autoSizeColumn(3);
		        sheet.autoSizeColumn(4);
		        sheet.autoSizeColumn(5);
		        sheet.autoSizeColumn(6);
		        sheet.autoSizeColumn(7);
		        sheet.autoSizeColumn(8);
		        sheet.autoSizeColumn(9);
		        sheet.autoSizeColumn(10);
		        
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        workbook.write(outputStream);
		        return new ByteArrayInputStream(outputStream.toByteArray());
			} catch (IOException ex) {
				ex.printStackTrace();
				return null;
			}
		}
		
		//For Training Excel Download
		public static ByteArrayInputStream trainingListToExcelFile(List<UploadSession> training) {
			try(Workbook workbook = new XSSFWorkbook()){
				Sheet sheet = workbook.createSheet("Training");
				
				Row row = sheet.createRow(0);
				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		        
		        Cell cell = row.createCell(0);
		        cell.setCellValue("batch");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(1);
		        cell.setCellValue("topicName");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(2);
		        cell.setCellValue("trainerName");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(3);
		        cell.setCellValue("batchSize");
		        cell.setCellStyle(headerCellStyle);
		        
		        cell = row.createCell(4);
		        cell.setCellValue("sessionDate");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(5);
		        cell.setCellValue("sessionLink");
		        cell.setCellStyle(headerCellStyle);
		
		        cell = row.createCell(6);
		        cell.setCellValue("sessionVideo");
		        cell.setCellStyle(headerCellStyle);
		        
		     // Creating data rows for each customer
		        for(int i = 0; i < training.size(); i++) {
		        	Row dataRow = sheet.createRow(i + 1);
		        	dataRow.createCell(0).setCellValue(training.get(i).getBatch());
		        	dataRow.createCell(1).setCellValue(training.get(i).getTopicName());
		        	dataRow.createCell(2).setCellValue(training.get(i).getTrainerName());
		        	dataRow.createCell(3).setCellValue(training.get(i).getBatch());
		        	dataRow.createCell(4).setCellValue(training.get(i).getSessionDate());
		        	dataRow.createCell(5).setCellValue(training.get(i).getSessionLink());
		        	dataRow.createCell(6).setCellValue(training.get(i).getSessionVideo());
		        }
		        
		     // Making size of column auto resize to fit with data
		        sheet.autoSizeColumn(0);
		        sheet.autoSizeColumn(1);
		        sheet.autoSizeColumn(2);
		        sheet.autoSizeColumn(3);
		        sheet.autoSizeColumn(4);
		        sheet.autoSizeColumn(5);
		        sheet.autoSizeColumn(6);
		        
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        workbook.write(outputStream);
		        return new ByteArrayInputStream(outputStream.toByteArray());
			} catch (IOException ex) {
				ex.printStackTrace();
				return null;
			}
		}
}
