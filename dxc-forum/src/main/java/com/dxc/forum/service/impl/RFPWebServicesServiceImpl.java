package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPWebServices;
import com.dxc.forum.repository.RFPWebServicesRepo;
import com.dxc.forum.service.RFPWebServicesService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class RFPWebServicesServiceImpl implements RFPWebServicesService {

	@Autowired
	private RFPWebServicesRepo rfpWebServicesRepo;

	@Override
	public RFPWebServices addRFPWebServices(RFPWebServices rfpWebServices) {
		
//		if (rfpWebServices.getWebServices().isEmpty() || rfpWebServices.getWebServices().length() == 0) {
//			throw new BusinessException("5001", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} 
//		if (rfpWebServices.getEstimationVariable().isEmpty() || rfpWebServices.getEstimationVariable().length() == 0) {
//			throw new BusinessException("5002", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpWebServices.getEffortPh().isEmpty() || rfpWebServices.getEffortPh().length() == 0) {
//			throw new BusinessException("5003", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} 
//		else if (rfpWebServices.getEffortManMonths().isEmpty() || rfpWebServices.getEffortManMonths().length() == 0) {
//			throw new BusinessException("5004", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			return this.rfpWebServicesRepo.save(rfpWebServices);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("50005", ErrorMessageConstants.RFPWEBSERVICES_ID_NULL + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("50006", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public List<RFPWebServices> getAllRFPWebServices() {
		try {
			List<RFPWebServices> rfpWebServicesList = this.rfpWebServicesRepo.findAll();
			if (rfpWebServicesList.isEmpty()) {
				throw new BusinessException("50007", ErrorMessageConstants.EMPTY_LIST);
			}
			return rfpWebServicesList;
		} catch (Exception e) {
			throw new BusinessException("50018", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPWebServices getRFPWebServices(Long id) {
		try {
			return this.rfpWebServicesRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("50008", ErrorMessageConstants.RFPWEBSERVICES_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("50009", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("50010", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFPWebServices updateRFPWebServices(Long id, RFPWebServices rfpWebServices) {
//		if (rfpWebServices.getWebServices().isEmpty() || rfpWebServices.getWebServices().length() == 0) {
//			throw new BusinessException("5011", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} else if (rfpWebServices.getEstimationVariable().isEmpty() || rfpWebServices.getEstimationVariable().length() == 0) {
//			throw new BusinessException("5012", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpWebServices.getEffortPh().isEmpty() || rfpWebServices.getEffortPh().length() == 0) {
//			throw new BusinessException("5013", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} else if (rfpWebServices.getEffortManMonths().isEmpty() || rfpWebServices.getEffortManMonths().length() == 0) {
//			throw new BusinessException("5014", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		try {
			RFPWebServices rfpWebServicesData = this.rfpWebServicesRepo.findById(id).orElse(null);
			rfpWebServicesData.setWsimpleDB(rfpWebServices.getWsimpleDB());
			rfpWebServicesData.setWmediumDB(rfpWebServices.getWmediumDB());
			rfpWebServicesData.setWcomplexDB(rfpWebServices.getWcomplexDB());
			rfpWebServicesData.setWveryComplexDB(rfpWebServices.getWveryComplexDB());
			rfpWebServicesData.setWsimplePI(rfpWebServices.getWsimplePI());
			rfpWebServicesData.setWmediumPI(rfpWebServices.getWmediumPI());
			rfpWebServicesData.setWcomplexPI(rfpWebServices.getWcomplexPI());
			rfpWebServicesData.setWveryComplexPI(rfpWebServices.getWveryComplexPI());
			return this.rfpWebServicesRepo.save(rfpWebServicesData);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("50015", ErrorMessageConstants.RFPWEBSERVICES_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("50016", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("50017", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public void deleteRFPWebServices(Long id) {
		this.rfpWebServicesRepo.deleteById(id);
	}
	
	public List<RFPWebServices> findByRfpId(RFP rfp_id) {
		// TODO Auto-generated method stub
		return this.rfpWebServicesRepo.findByRfp(rfp_id);
	}

}
