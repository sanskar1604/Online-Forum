package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPSpringboot;
import com.dxc.forum.repository.RFPSpringbootRepo;
import com.dxc.forum.service.RFPSpringbootService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class RFPSpringbootServiceImpl implements RFPSpringbootService {

	@Autowired
	private RFPSpringbootRepo rfpSpringbootRepo;

	@Override
	public RFPSpringboot addRFPSpringboot(RFPSpringboot rfpSpringboot) {
		
//		if (rfpSpringboot.getSpringboot().isEmpty() || rfpSpringboot.getSpringboot().length() == 0) {
//			throw new BusinessException("5001", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} 
//		if (rfpSpringboot.getEstimationVariable().isEmpty() || rfpSpringboot.getEstimationVariable().length() == 0) {
//			throw new BusinessException("5002", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpSpringboot.getEffortPh().isEmpty() || rfpSpringboot.getEffortPh().length() == 0) {
//			throw new BusinessException("5003", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} 
//		else if (rfpSpringboot.getEffortManMonths().isEmpty() || rfpSpringboot.getEffortManMonths().length() == 0) {
//			throw new BusinessException("5004", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			return this.rfpSpringbootRepo.save(rfpSpringboot);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("5005", ErrorMessageConstants.RFPSPRINGBOOT_ID_NULL + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("5006", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public List<RFPSpringboot> getAllRFPSpringboot() {
		try {
			List<RFPSpringboot> rfpSpringbootList = this.rfpSpringbootRepo.findAll();
			if (rfpSpringbootList.isEmpty()) {
				throw new BusinessException("5007", ErrorMessageConstants.EMPTY_LIST);
			}
			return rfpSpringbootList;
		} catch (Exception e) {
			throw new BusinessException("5018", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPSpringboot getRFPSpringboot(Long id) {
		try {
			return this.rfpSpringbootRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("5008", ErrorMessageConstants.RFPSPRINGBOOT_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("5009", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("5010", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPSpringboot updateRFPSpringboot(Long id, RFPSpringboot rfpSpringboot) {
//		if (rfpSpringboot.getSpringboot().isEmpty() || rfpSpringboot.getSpringboot().length() == 0) {
//			throw new BusinessException("5011", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} else if (rfpSpringboot.getEstimationVariable().isEmpty() || rfpSpringboot.getEstimationVariable().length() == 0) {
//			throw new BusinessException("5012", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpSpringboot.getEffortPh().isEmpty() || rfpSpringboot.getEffortPh().length() == 0) {
//			throw new BusinessException("5013", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} else if (rfpSpringboot.getEffortManMonths().isEmpty() || rfpSpringboot.getEffortManMonths().length() == 0) {
//			throw new BusinessException("5014", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			RFPSpringboot rfpSpringbootData = this.rfpSpringbootRepo.findById(id).orElse(null);
			rfpSpringbootData.setSimpleDB(rfpSpringboot.getSimpleDB());
			rfpSpringbootData.setMediumDB(rfpSpringboot.getMediumDB());
			rfpSpringbootData.setComplexDB(rfpSpringboot.getComplexDB());
			rfpSpringbootData.setVeryComplexDB(rfpSpringboot.getVeryComplexDB());
			rfpSpringbootData.setSimplePI(rfpSpringboot.getSimplePI());
			rfpSpringbootData.setMediumPI(rfpSpringboot.getMediumPI());
			rfpSpringbootData.setComplexPI(rfpSpringboot.getComplexPI());
			rfpSpringbootData.setVeryComplexPI(rfpSpringboot.getVeryComplexPI());
			return this.rfpSpringbootRepo.save(rfpSpringbootData);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("5015", ErrorMessageConstants.RFPSPRINGBOOT_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("5016", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("5017", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public void deleteRFPSpringboot(Long id) {
		this.rfpSpringbootRepo.deleteById(id);
	}
	
	public List<RFPSpringboot> findByRfpId(RFP rfp_id) {
		// TODO Auto-generated method stub
		return this.rfpSpringbootRepo.findByRfp(rfp_id);
	}

}
