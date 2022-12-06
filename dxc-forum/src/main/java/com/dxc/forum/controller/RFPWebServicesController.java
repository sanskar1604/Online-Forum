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
import com.dxc.forum.entity.RFPWebServices;
import com.dxc.forum.service.RFPWebServicesService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/rfpWebServices")
public class RFPWebServicesController {

	@Autowired
	private RFPWebServicesService rfpWebServicesService;

	@PostMapping
	public ResponseEntity<?> addRFPWebServices(@RequestBody RFPWebServices rfpWebServices) {
		try {
			return ResponseEntity.ok(this.rfpWebServicesService.addRFPWebServices(rfpWebServices));
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("50020", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<RFPWebServices>> getAllRFPWebServices() {
		List<RFPWebServices> rfpWebServicesList = this.rfpWebServicesService.getAllRFPWebServices();
		return new ResponseEntity<List<RFPWebServices>>(rfpWebServicesList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRFPWebServices(@PathVariable("id") Long id) {
		try {
			RFPWebServices rfpWebServices = this.rfpWebServicesService.getRFPWebServices(id);
			return new ResponseEntity<RFPWebServices>(rfpWebServices, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("50026", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> uploadRFPWebServices(@PathVariable("id") Long id, @RequestBody RFPWebServices rfpWebServices) {
		try {
			RFPWebServices rfpWebServicesUpdate = this.rfpWebServicesService.updateRFPWebServices(id, rfpWebServices);
			return new ResponseEntity<RFPWebServices>(rfpWebServicesUpdate, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("50047", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteRFPWebServices(@PathVariable("id") Long id) {
		this.rfpWebServicesService.deleteRFPWebServices(id);
	}
	
	@GetMapping("/webservicesbyrfp/{id}")
	public List<RFPWebServices> findByRfpId(@PathVariable("id") RFP id){
		return this.rfpWebServicesService.findByRfpId(id);
	}

}
