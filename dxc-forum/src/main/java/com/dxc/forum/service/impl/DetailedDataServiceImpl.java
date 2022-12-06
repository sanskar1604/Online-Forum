package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.DetailedData;
import com.dxc.forum.repository.DetailedDataRepo;
import com.dxc.forum.service.DetailedDataService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class DetailedDataServiceImpl implements DetailedDataService {
	
	@Autowired
	private DetailedDataRepo detailedDataRepo;

	@Override
	public DetailedData addData(DetailedData data) {
		
		if (data.getModule().isEmpty() || data.getModule().length() == 0) {
			throw new BusinessException("6001", ErrorMessageConstants.PROPER_DATA_MODULE);
		} else if (data.getRequirement().isEmpty() || data.getRequirement().length() == 0) {
			throw new BusinessException("6002", ErrorMessageConstants.PROPER_DATA_REQUIREMENT);
		} else if (data.getRequirement_details().isEmpty() || data.getRequirement_details().length() == 0) {
			throw new BusinessException("6003", ErrorMessageConstants.PROPER_DATA_REQUIREMENT_DETAILS);
		} else if (data.getComplexity().isEmpty() || data.getComplexity().length() == 0) {
			throw new BusinessException("6004", ErrorMessageConstants.PROPER_DATA_COMPLEXITY);
		}
		
		try {
			return this.detailedDataRepo.save(data);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("6005", ErrorMessageConstants.DATA_ID_NULL + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("6006", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public List<DetailedData> getAllData() {
		
		try {
			List<DetailedData> dataList = this.detailedDataRepo.findAll();
			if (dataList.isEmpty()) {
				throw new BusinessException("6007", ErrorMessageConstants.EMPTY_LIST);
			}
			return dataList;
		} catch (Exception e) {
			throw new BusinessException("6008", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public DetailedData getData(Long id) {
		try {
			return this.detailedDataRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("6009", ErrorMessageConstants.DATA_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("6010", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("6011", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public DetailedData updateData(Long id, DetailedData data) {
//		if (rfpPhases.getPhases().isEmpty() || rfpPhases.getPhases().length() == 0) {
//			throw new BusinessException("2011", ErrorMessageConstants.PROPER_RFPPHASES_PHASES);
//		} else if (rfpPhases.getEstimationVariable().isEmpty() || rfpPhases.getEstimationVariable().length() == 0) {
//			throw new BusinessException("2012", ErrorMessageConstants.PROPER_RFPPHASES_ESTIMATION_VARIABLE);
//		} else if (rfpPhases.getEffortPh().isEmpty() || rfpPhases.getEffortPh().length() == 0) {
//			throw new BusinessException("2013", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_PH);
//		} else if (rfpPhases.getEffortManMonths().isEmpty() || rfpPhases.getEffortManMonths().length() == 0) {
//			throw new BusinessException("2014", ErrorMessageConstants.PROPER_RFPPHASES_EFFORT_MAN_MONTHS);
//		}
		
		if (data.getModule().isEmpty() || data.getModule().length() == 0) {
			throw new BusinessException("1612", ErrorMessageConstants.PROPER_DATA_MODULE);
		} else if (data.getRequirement().isEmpty() || data.getRequirement().length() == 0) {
			throw new BusinessException("1613", ErrorMessageConstants.PROPER_DATA_REQUIREMENT);
		} else if (data.getRequirement_details().isEmpty() || data.getRequirement_details().length() == 0) {
			throw new BusinessException("1614", ErrorMessageConstants.PROPER_DATA_REQUIREMENT_DETAILS);
		} else if (data.getComplexity().isEmpty() || data.getComplexity().length() == 0) {
			throw new BusinessException("1615", ErrorMessageConstants.PROPER_DATA_COMPLEXITY);
		}
		
		try {
			DetailedData detailedData = this.detailedDataRepo.findById(id).orElse(null);
			detailedData.setModule(data.getModule());
			detailedData.setRequirement(data.getRequirement());
			detailedData.setRequirement_details(data.getRequirement_details());
			detailedData.setUnits(data.getUnits());
			detailedData.setComplexity(data.getComplexity());
			detailedData.setCut_estimation(data.getCut_estimation());
			detailedData.setAssumptions(data.getAssumptions());
			detailedData.setComments(data.getComments());
			return this.detailedDataRepo.save(detailedData);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("6016", ErrorMessageConstants.DATA_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("6017", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("6018", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public void deleteData(Long id) {
		this.detailedDataRepo.deleteById(id);
	}

}
