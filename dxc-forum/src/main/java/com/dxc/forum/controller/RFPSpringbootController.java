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
import com.dxc.forum.entity.RFPSpringboot;
import com.dxc.forum.service.RFPSpringbootService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/rfpSpringboot")
public class RFPSpringbootController {

	@Autowired
	private RFPSpringbootService rfpSpringbootService;

	@PostMapping
	public ResponseEntity<?> addRFPSpringboot(@RequestBody RFPSpringboot rfpSpringboot) {
		try {
			return ResponseEntity.ok(this.rfpSpringbootService.addRFPSpringboot(rfpSpringboot));
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("5020", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<RFPSpringboot>> getAllRFPSpringboot() {
		List<RFPSpringboot> rfpSpringbootList = this.rfpSpringbootService.getAllRFPSpringboot();
		return new ResponseEntity<List<RFPSpringboot>>(rfpSpringbootList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRFPSpringboot(@PathVariable("id") Long id) {
		try {
			RFPSpringboot rfpSpringboot = this.rfpSpringbootService.getRFPSpringboot(id);
			return new ResponseEntity<RFPSpringboot>(rfpSpringboot, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("5026", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> uploadRFPSpringboot(@PathVariable("id") Long id, @RequestBody RFPSpringboot rfpSpringboot) {
		try {
			RFPSpringboot rfpSpringbootUpdate = this.rfpSpringbootService.updateRFPSpringboot(id, rfpSpringboot);
			return new ResponseEntity<RFPSpringboot>(rfpSpringbootUpdate, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("5047", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteRFPSpringboot(@PathVariable("id") Long id) {
		this.rfpSpringbootService.deleteRFPSpringboot(id);
	}
	
	@GetMapping("/springbootbyrfp/{id}")
	public List<RFPSpringboot> findByRfpId(@PathVariable("id") RFP id){
		return this.rfpSpringbootService.findByRfpId(id);
	}

}
