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
import com.dxc.forum.helper.CertificationExcelHelper;
import com.dxc.forum.helper.ExcelFileExporter;
import com.dxc.forum.service.CertificationService;
import com.dxc.forum.utils.ErrorMessageConstants;
import com.dxc.forum.utils.MessageConstants;

@CrossOrigin("*")
@RestController
//@RequestMapping("/certification")
public class CertificationController {

	@Autowired
	private CertificationService certificationService;

	public CertificationController() {
		super();
	}

	public CertificationController(CertificationService certificationService) {
		super();
		this.certificationService = certificationService;
	}

	@PostMapping("/certification")
	public ResponseEntity<?> addCertificationEntity(@RequestBody Certification certificationEntity) {
		try {
			 Certification certificationsaved=certificationService.addCertificationEntity(certificationEntity);
			return new ResponseEntity<Certification>(certificationsaved,HttpStatus.CREATED);
		     }
		catch(BusinessException e) 
		    {
			ControllerException ce= new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			}

		catch(Exception e)
		{
			ControllerException ce= new ControllerException("1111", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/certification")
	public ResponseEntity<?> getCertificationEntities() {
		
		try {
		return ResponseEntity.ok(this.certificationService.getCertificationEntities());
		}
	
	    catch(BusinessException e) {
		ControllerException ce= new ControllerException(e.getErrorcode(),e.getErrorMsg());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND );
		}
		catch(Exception e) {
			ControllerException ce= new ControllerException("1112", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND );
			}
		}

	@PutMapping("/certification/{id}")
	public ResponseEntity<?> updatCertificationEntity(@RequestBody Certification certificationEntity,
			@PathVariable long id) {
		try {
			return ResponseEntity.ok(this.certificationService.updateCerticationEntity(certificationEntity, id));
		}
		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			}
			catch(Exception e) {
				ControllerException ce= new ControllerException("1113", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER + e.getMessage());
				return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
				}
		
	}

	@GetMapping("/certification/{id}")
	public ResponseEntity<?> getCertificationEntityById(@PathVariable long id) {
		try {
	    Certification certificationRetrieved= certificationService.getCertificationEntityById(id);
		return new ResponseEntity<Certification>(certificationRetrieved, HttpStatus.OK);
				}
		
		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} 
		
		catch(Exception e) {
			ControllerException ce= new ControllerException("1114", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/certification/{id}")
	public ResponseEntity<?> deleteCertificationEntityById(@PathVariable long id) {
	
			return  certificationService.deleteCertificationEntityById(id);
		
	
	}

	@PostMapping("/certification-excel")
	public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
		try {
		if (CertificationExcelHelper.checkExcelFormat(file)) {
			this.certificationService.uploadExcel(file);
			return ResponseEntity.ok(Map.of("message", MessageConstants.EXCEL_UPLOAD_SUCCESS));
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please uplaod Excel File");
	}
	catch(BusinessException e) {
        ControllerException ce=new ControllerException(e.getErrorcode(),e.getErrorMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ce);
    }
	catch(Exception e){
        ControllerException ce=new ControllerException("1116", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ce);
    }
	}

	@GetMapping("/total_certificate")
	public Long totalCertificate() {
		return this.certificationService.totalCertificate();
	}
	
	@GetMapping("/total_certificate/pass")
	public Long totalExamStatusPass(){
		return this.certificationService.totalExamStatusPass();
	}
	
	@GetMapping("/total_certificate/scheduled")
	public Long totalExamStatusScheduled(){
		return this.certificationService.totalExamStatusScheduled();
	}
	
	
	@GetMapping("/total_certificate/expired_and_fail")
	public Long totalExamStatusExpired(){
		return this.certificationService.totalExamStatusExpiredAndFail();
	}
	
	@GetMapping("/total_voucher")
	public Long totalVoucherIssued(){
		return this.certificationService.totalVoucherIssued();
	}

	@GetMapping("/download/certificate.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Certificate.xlsx");
        List <Certification> certificates = this.certificationService.getCertificationEntities();
        
        ByteArrayInputStream stream = ExcelFileExporter.certificateListToExcelFile(certificates);
        IOUtils.copy(stream, response.getOutputStream());
    }
}
