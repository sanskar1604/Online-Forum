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
import com.dxc.forum.entity.DetailedData;
import com.dxc.forum.service.DetailedDataService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/data")
public class DetailedDataController {
	
	@Autowired
	private DetailedDataService detailedDataService;

	@PostMapping
	public ResponseEntity<?> addData(@RequestBody DetailedData data) {
		try {
			return ResponseEntity.ok(this.detailedDataService.addData(data));
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("6020", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<DetailedData>> getAllData() {
		List<DetailedData> dataList = this.detailedDataService.getAllData();
		return new ResponseEntity<List<DetailedData>>(dataList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getData(@PathVariable("id") Long id) {
		try {
			DetailedData data = this.detailedDataService.getData(id);
			return new ResponseEntity<DetailedData>(data, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("6026", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> upload(@PathVariable("id") Long id, @RequestBody DetailedData data) {
		try {
			DetailedData dataUpdate = this.detailedDataService.updateData(id, data);
			return new ResponseEntity<DetailedData>(dataUpdate, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("6047", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteData(@PathVariable("id") Long id) {
		this.detailedDataService.deleteData(id);
	}


}
