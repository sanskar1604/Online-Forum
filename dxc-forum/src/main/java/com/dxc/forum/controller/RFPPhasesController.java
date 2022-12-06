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
import com.dxc.forum.entity.RFPPhases;
import com.dxc.forum.service.RFPPhasesService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/rfpPhases")
public class RFPPhasesController {

	@Autowired
	private RFPPhasesService rfpPhasesService;

	@PostMapping
	public ResponseEntity<?> addRFPPhases(@RequestBody RFPPhases rfpPhases) {
		try {
			return ResponseEntity.ok(this.rfpPhasesService.addRFPPhases(rfpPhases));
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("2020", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<RFPPhases>> getAllRFPPhases() {
		List<RFPPhases> rfpPhasesList = this.rfpPhasesService.getAllRFPPhases();
		return new ResponseEntity<List<RFPPhases>>(rfpPhasesList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRFPPhases(@PathVariable("id") Long id) {
		try {
			RFPPhases rfpPhases = this.rfpPhasesService.getRFPPhases(id);
			return new ResponseEntity<RFPPhases>(rfpPhases, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("2026", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> uploadRFPPhases(@PathVariable("id") Long id, @RequestBody RFPPhases rfpPhases) {
		try {
			RFPPhases rfpPhasesUpdate = this.rfpPhasesService.updateRFPPhases(id, rfpPhases);
			return new ResponseEntity<RFPPhases>(rfpPhasesUpdate, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("2047", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteRFPPhases(@PathVariable("id") Long id) {
		this.rfpPhasesService.deleteRFPPhases(id);
	}
	
	@GetMapping("/phasesbyrfp/{id}")
	public List<RFPPhases> findByRfpId(@PathVariable("id") RFP id){
		return this.rfpPhasesService.findByRfpId(id);
	}

}
