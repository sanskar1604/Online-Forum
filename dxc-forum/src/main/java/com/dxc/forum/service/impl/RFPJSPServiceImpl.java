package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPJSP;
import com.dxc.forum.repository.RFPJSPRepo;
import com.dxc.forum.service.RFPJSPService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class RFPJSPServiceImpl implements RFPJSPService {

	@Autowired
	private RFPJSPRepo rfpJSPRepo;

	@Override
	public RFPJSP addRFPJSP(RFPJSP rfpJSP) {
		
//		if (rfpJSP.getJSP().isEmpty() || rfpJSP.getJSP().length() == 0) {
//			throw new BusinessException("5001", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} 
//		if (rfpJSP.getEstimationVariable().isEmpty() || rfpJSP.getEstimationVariable().length() == 0) {
//			throw new BusinessException("5002", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpJSP.getEffortPh().isEmpty() || rfpJSP.getEffortPh().length() == 0) {
//			throw new BusinessException("5003", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} 
//		else if (rfpJSP.getEffortManMonths().isEmpty() || rfpJSP.getEffortManMonths().length() == 0) {
//			throw new BusinessException("5004", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			return this.rfpJSPRepo.save(rfpJSP);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("505", ErrorMessageConstants.RFPJSP_ID_NULL + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("506", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public List<RFPJSP> getAllRFPJSP() {
		try {
			List<RFPJSP> rfpJSPList = this.rfpJSPRepo.findAll();
			if (rfpJSPList.isEmpty()) {
				throw new BusinessException("507", ErrorMessageConstants.EMPTY_LIST);
			}
			return rfpJSPList;
		} catch (Exception e) {
			throw new BusinessException("518", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPJSP getRFPJSP(Long id) {
		try {
			return this.rfpJSPRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("508", ErrorMessageConstants.RFPJSP_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("509", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("510", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPJSP updateRFPJSP(Long id, RFPJSP rfpJSP) {
//		if (rfpJSP.getJSP().isEmpty() || rfpJSP.getJSP().length() == 0) {
//			throw new BusinessException("5011", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} else if (rfpJSP.getEstimationVariable().isEmpty() || rfpJSP.getEstimationVariable().length() == 0) {
//			throw new BusinessException("5012", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpJSP.getEffortPh().isEmpty() || rfpJSP.getEffortPh().length() == 0) {
//			throw new BusinessException("5013", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} else if (rfpJSP.getEffortManMonths().isEmpty() || rfpJSP.getEffortManMonths().length() == 0) {
//			throw new BusinessException("5014", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			RFPJSP rfpJSPData = this.rfpJSPRepo.findById(id).orElse(null);
			rfpJSPData.setJsimpleDB(rfpJSP.getJsimpleDB());
			rfpJSPData.setJmediumDB(rfpJSP.getJmediumDB());
			rfpJSPData.setJcomplexDB(rfpJSP.getJcomplexDB());
			rfpJSPData.setJveryComplexDB(rfpJSP.getJveryComplexDB());
			rfpJSPData.setJsimplePI(rfpJSP.getJsimplePI());
			rfpJSPData.setJmediumPI(rfpJSP.getJmediumPI());
			rfpJSPData.setJcomplexPI(rfpJSP.getJcomplexPI());
			rfpJSPData.setJveryComplexPI(rfpJSP.getJveryComplexPI());
			return this.rfpJSPRepo.save(rfpJSPData);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("515", ErrorMessageConstants.RFPJSP_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("516", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("517", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public void deleteRFPJSP(Long id) {
		this.rfpJSPRepo.deleteById(id);
	}
	
	public List<RFPJSP> findByRfpId(RFP rfp_id) {
		// TODO Auto-generated method stub
		return this.rfpJSPRepo.findByRfp(rfp_id);
	}

}
