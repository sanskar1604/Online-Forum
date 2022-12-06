package com.dxc.forum.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.Certification;
import com.dxc.forum.entity.Mentoring;
import com.dxc.forum.helper.ExcelFileExporter;
import com.dxc.forum.helper.MentoringExcelHelper;
import com.dxc.forum.service.MentoringService;
import com.dxc.forum.utils.ErrorMessageConstants;
import com.dxc.forum.utils.MessageConstants;

@RestController
@CrossOrigin("*")
public class MentoringController {

	@Autowired
	private MentoringService mentoringService;

	// Add Data
	@PostMapping("/mentoring")
	public ResponseEntity<?> addMentoring(@RequestBody Mentoring mentoring) {
		try {
			return ResponseEntity.ok( this.mentoringService.addMentoring(mentoring));
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("715", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	// Get All Data
	@GetMapping("/mentoring")
	public ResponseEntity<List<Mentoring>> getAllMentoring() {
		List<Mentoring> listOfMentorings = mentoringService.getAllMentoring();
		return new ResponseEntity<List<Mentoring>>(listOfMentorings, HttpStatus.OK);
	}

	// Get Specific Data using Id
	// /mentoring/id
	@GetMapping("/mentoring/{id}")
	public ResponseEntity<?> getMentoring(@PathVariable("id") Long id) {
		try {
			Mentoring mentoringRetrieved = mentoringService.getMentoring(id);
			return new ResponseEntity<Mentoring>(mentoringRetrieved, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("716", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	// Update Specific Data using Id
	// /mentoring/id
	@PutMapping("/mentoring/{id}")
	public ResponseEntity<?> updateMentoring(@RequestBody Mentoring mentoring, @PathVariable("id") Long id) {
		try {
			Mentoring mentoringUpdated = mentoringService.updateMentoring(mentoring, id);
			return new ResponseEntity<Mentoring>(mentoringUpdated, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("717", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	// Delete Specific Data using Id
	// /mentoring/id
	@DeleteMapping("/mentoring/{id}")
	public ResponseEntity<?> deleteMapping(@PathVariable("id") Long id) {
		try {
			mentoringService.deleteMentoring(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("718", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@PostMapping("/mentoring-excel")
	public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
		if (MentoringExcelHelper.checkExcelFormat(file)) {
			this.mentoringService.uploadExcel(file);
			return ResponseEntity.ok(Map.of("message", MessageConstants.EXCEL_UPLOAD_SUCCESS));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.PLEASE_UPLOAD_EXCEL);
	}

	@GetMapping("/total_employee")
	public Long totalEmployee() {
		return this.mentoringService.totalEmployee();
	}
	
	@GetMapping("/download/mentoring.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Mentoring.xlsx");
        List <Mentoring> mentors = this.mentoringService.getAllMentoring();
        
        ByteArrayInputStream stream = ExcelFileExporter.mentoringListToExcelFile(mentors);
        IOUtils.copy(stream, response.getOutputStream());
    }
}
