package com.dxc.forum.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPJSP;
import com.dxc.forum.service.RFPJSPService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/rfpJSP")
public class RFPJSPController {

	@Autowired
	private RFPJSPService rfpJSPService;

	@PostMapping
	public ResponseEntity<?> addRFPJSP(@RequestBody RFPJSP rfpJSP) {
		try {
			return ResponseEntity.ok(this.rfpJSPService.addRFPJSP(rfpJSP));
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("520", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<RFPJSP>> getAllRFPJSP() {
		List<RFPJSP> rfpJSPList = this.rfpJSPService.getAllRFPJSP();
		return new ResponseEntity<List<RFPJSP>>(rfpJSPList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRFPJSP(@PathVariable("id") Long id) {
		try {
			RFPJSP rfpJSP = this.rfpJSPService.getRFPJSP(id);
			return new ResponseEntity<RFPJSP>(rfpJSP, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("526", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> uploadRFPJSP(@PathVariable("id") Long id, @RequestBody RFPJSP rfpJSP) {
		try {
			RFPJSP rfpJSPUpdate = this.rfpJSPService.updateRFPJSP(id, rfpJSP);
			return new ResponseEntity<RFPJSP>(rfpJSPUpdate, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("547", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteRFPJSP(@PathVariable("id") Long id) {
		this.rfpJSPService.deleteRFPJSP(id);
	}
	
	@GetMapping("/jspbyrfp/{id}")
	public List<RFPJSP> findByRfpId(@PathVariable("id") RFP id){
		return this.rfpJSPService.findByRfpId(id);
	}

}
