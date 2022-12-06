package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPPhases;
import com.dxc.forum.repository.RFPPhasesRepo;
import com.dxc.forum.service.RFPPhasesService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class RFPPhasesServiceImpl implements RFPPhasesService {

	@Autowired
	private RFPPhasesRepo rfpPhasesRepo;

	@Override
	public RFPPhases addRFPPhases(RFPPhases rfpPhases) {
		
//		if (rfpPhases.getPhases().isEmpty() || rfpPhases.getPhases().length() == 0) {
//			throw new BusinessException("2001", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} 
//		if (rfpPhases.getEstimationVariable().isEmpty() || rfpPhases.getEstimationVariable().length() == 0) {
//			throw new BusinessException("2002", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpPhases.getEffortPh().isEmpty() || rfpPhases.getEffortPh().length() == 0) {
//			throw new BusinessException("2003", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} 
//		else if (rfpPhases.getEffortManMonths().isEmpty() || rfpPhases.getEffortManMonths().length() == 0) {
//			throw new BusinessException("2004", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			return this.rfpPhasesRepo.save(rfpPhases);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("2005", ErrorMessageConstants.RFPPHASES_ID_NULL + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("2006", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public List<RFPPhases> getAllRFPPhases() {
		try {
			List<RFPPhases> rfpPhasesList = this.rfpPhasesRepo.findAll();
			if (rfpPhasesList.isEmpty()) {
				throw new BusinessException("2007", ErrorMessageConstants.EMPTY_LIST);
			}
			return rfpPhasesList;
		} catch (Exception e) {
			throw new BusinessException("2007", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPPhases getRFPPhases(Long id) {
		try {
			return this.rfpPhasesRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("2008", ErrorMessageConstants.RFPPHASES_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("2009", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("2010", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

//	@Override
//	public RFPPhases updateRFPPhases(Long id, RFPPhases rfpPhases) {
////		if (rfpPhases.getPhases().isEmpty() || rfpPhases.getPhases().length() == 0) {
////			throw new BusinessException("2011", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
////		} else if (rfpPhases.getEstimationVariable().isEmpty() || rfpPhases.getEstimationVariable().length() == 0) {
////			throw new BusinessException("2012", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
////		} else if (rfpPhases.getEffortPh().isEmpty() || rfpPhases.getEffortPh().length() == 0) {
////			throw new BusinessException("2013", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
////		} else if (rfpPhases.getEffortManMonths().isEmpty() || rfpPhases.getEffortManMonths().length() == 0) {
////			throw new BusinessException("2014", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
////		}
//		try {
//			RFPPhases rfpPhasesData = this.rfpPhasesRepo.findById(id).orElse(null);
//			rfpPhasesData.setPhases(rfpPhases.getPhases());
//			rfpPhasesData.setEstimationVariable(rfpPhases.getEstimationVariable());
//			rfpPhasesData.setEffortPh(rfpPhases.getEffortPh());
//			rfpPhasesData.setEffortManMonths(rfpPhases.getEffortManMonths());
//			return this.rfpPhasesRepo.save(rfpPhasesData);
//		} catch (IllegalArgumentException e) {
//			throw new BusinessException("2015", ErrorMessageConstants.RFPPHASES_ID_NULL + e.getMessage());
//		} catch (NoSuchElementException e) {
//			throw new BusinessException("2016", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
//		} catch (Exception e) {
//			throw new BusinessException("2017", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
//		}
//	}

	@Override
	public void deleteRFPPhases(Long id) {
		this.rfpPhasesRepo.deleteById(id);
	}

	@Override
	public RFPPhases updateRFPPhases(Long id, RFPPhases rfpPhases) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RFPPhases> findByRfpId(RFP rfp_id) {
		// TODO Auto-generated method stub
		return this.rfpPhasesRepo.findByRfp(rfp_id);
	}

}
