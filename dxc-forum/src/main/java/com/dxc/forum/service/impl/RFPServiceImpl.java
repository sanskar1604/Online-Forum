package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.repository.RFPRepo;
import com.dxc.forum.service.RFPService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class RFPServiceImpl implements RFPService {

	@Autowired
	private RFPRepo rfpRepo;

	@Override
	public RFP addRFP(RFP rfp) {
		if (rfp.getRfpTitle().isEmpty() || rfp.getRfpTitle().length() == 0) {
			throw new BusinessException("1301", ErrorMessageConstants.PROPER_RFP_TITLE);
		} else if (rfp.getClient().isEmpty() || rfp.getClient().length() == 0) {
			throw new BusinessException("1302", ErrorMessageConstants.PROPER_RFP_CLIENT);
		} else if (rfp.getStatus().isEmpty() || rfp.getStatus().length() == 0) {
			throw new BusinessException("1303", ErrorMessageConstants.PROPER_RFP_STATUS);
		} else if (rfp.getRegion().isEmpty() || rfp.getRegion().length() == 0) {
			throw new BusinessException("1304", ErrorMessageConstants.PROPER_RFP_REGION);
		} else if (rfp.getTechnology().isEmpty() || rfp.getTechnology().length() == 0) {
			throw new BusinessException("1305", ErrorMessageConstants.PROPER_RFP_TECHNOLOGY);
		} else if (rfp.getJavaCapabilityRfpTeam().isEmpty() || rfp.getJavaCapabilityRfpTeam().length() == 0) {
			throw new BusinessException("1306", ErrorMessageConstants.PROPER_RFP_JAVA_TEAM);
		} else if (rfp.getDxcSolutioningLead().isEmpty() || rfp.getDxcSolutioningLead().length() == 0) {
			throw new BusinessException("1307", ErrorMessageConstants.PROPER_RFP_DXC_SOLUTIONING_LEAD);
		} else if (rfp.getType().isEmpty() || rfp.getType().length() == 0) {
			throw new BusinessException("1308", ErrorMessageConstants.PROPER_RFP_TYPE);
		} else if (rfp.getNotes().isEmpty() || rfp.getNotes().length() == 0) {
			throw new BusinessException("1309", ErrorMessageConstants.PROPER_RFP_NOTES);
		} else if (rfp.getTotalDealValue().isEmpty() || rfp.getTotalDealValue().length() == 0) {
			throw new BusinessException("1310", ErrorMessageConstants.PROPER_RFP_TOTAL_DEAL_VALUE);
		} else if (rfp.getOpxId().isEmpty() || rfp.getOpxId().length() == 0) {
			throw new BusinessException("1311", ErrorMessageConstants.PROPER_RFP_OPX_ID);
		}
//		else if (rfp.getDateOfEntry().isEmpty() || rfp.getDateOfEntry().length() == 0) {
//			throw new BusinessException("1312", ErrorMessageConstants.PROPER_RFP_DATE_OF_ENTRY);
//		} else if (rfp.getEtaToSubmitRfp().isEmpty() || rfp.getEtaToSubmitRfp().length() == 0) {
//			throw new BusinessException("1313", ErrorMessageConstants.PROPER_RFP_ETA_SUBMIT);
//		} else if (rfp.getRealizationDate().isEmpty() || rfp.getRealizationDate().length() == 0) {
//			throw new BusinessException("1314", ErrorMessageConstants.PROPER_RFP_REALIZATION_DATE);
//		} 
		else if (rfp.getTcvUsd().isEmpty() || rfp.getTcvUsd().length() == 0) {
			throw new BusinessException("1315", ErrorMessageConstants.PROPER_RFP_TCV_USD);
		} else if (rfp.getEffort().isEmpty() || rfp.getEffort().length() == 0) {
			throw new BusinessException("1316", ErrorMessageConstants.PROPER_RFP_EFFORT);
		} else if (rfp.getProjectPlannedStatus().isEmpty() || rfp.getProjectPlannedStatus().length() == 0) {
			throw new BusinessException("1317", ErrorMessageConstants.PROPER_RFP_PROJECT_PLANNED_STATUS);
		}
		try {
			return this.rfpRepo.save(rfp);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1318", ErrorMessageConstants.RFP_ID_NULL + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1319", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public List<RFP> getAllRFP() {
		try {
			List<RFP> rfpList = this.rfpRepo.findAll();
			if (rfpList.isEmpty()) {
				throw new BusinessException("1321", ErrorMessageConstants.EMPTY_LIST);
			}
			return rfpList;
		} catch (Exception e) {
			throw new BusinessException("1322", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFP getRFP(Long id) {
		try {
			return this.rfpRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1323", ErrorMessageConstants.RFP_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("1324", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1325", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public RFP updateRFP(Long id, RFP rfp) {
		if (rfp.getRfpTitle().isEmpty() || rfp.getRfpTitle().length() == 0) {
			throw new BusinessException("1327", ErrorMessageConstants.PROPER_RFP_TITLE);
		} else if (rfp.getClient().isEmpty() || rfp.getClient().length() == 0) {
			throw new BusinessException("1328", ErrorMessageConstants.PROPER_RFP_CLIENT);
		} else if (rfp.getStatus().isEmpty() || rfp.getStatus().length() == 0) {
			throw new BusinessException("1329", ErrorMessageConstants.PROPER_RFP_STATUS);
		} else if (rfp.getRegion().isEmpty() || rfp.getRegion().length() == 0) {
			throw new BusinessException("1330", ErrorMessageConstants.PROPER_RFP_REGION);
		} else if (rfp.getTechnology().isEmpty() || rfp.getTechnology().length() == 0) {
			throw new BusinessException("1331", ErrorMessageConstants.PROPER_RFP_TECHNOLOGY);
		} else if (rfp.getJavaCapabilityRfpTeam().isEmpty() || rfp.getJavaCapabilityRfpTeam().length() == 0) {
			throw new BusinessException("1332", ErrorMessageConstants.PROPER_RFP_JAVA_TEAM);
		} else if (rfp.getDxcSolutioningLead().isEmpty() || rfp.getDxcSolutioningLead().length() == 0) {
			throw new BusinessException("1333", ErrorMessageConstants.PROPER_RFP_DXC_SOLUTIONING_LEAD);
		} else if (rfp.getType().isEmpty() || rfp.getType().length() == 0) {
			throw new BusinessException("1334", ErrorMessageConstants.PROPER_RFP_TYPE);
		} else if (rfp.getNotes().isEmpty() || rfp.getNotes().length() == 0) {
			throw new BusinessException("1335", ErrorMessageConstants.PROPER_RFP_NOTES);
		} else if (rfp.getTotalDealValue().isEmpty() || rfp.getTotalDealValue().length() == 0) {
			throw new BusinessException("1336", ErrorMessageConstants.PROPER_RFP_TOTAL_DEAL_VALUE);
		} else if (rfp.getOpxId().isEmpty() || rfp.getOpxId().length() == 0) {
			throw new BusinessException("1337", ErrorMessageConstants.PROPER_RFP_OPX_ID);
		} 
//		else if (rfp.getDateOfEntry().isEmpty() || rfp.getDateOfEntry().length() == 0) {
//			throw new BusinessException("1338", ErrorMessageConstants.PROPER_RFP_DATE_OF_ENTRY);
//		} else if (rfp.getEtaToSubmitRfp().isEmpty() || rfp.getEtaToSubmitRfp().length() == 0) {
//			throw new BusinessException("1339", ErrorMessageConstants.PROPER_RFP_ETA_SUBMIT);
//		} else if (rfp.getRealizationDate().isEmpty() || rfp.getRealizationDate().length() == 0) {
//			throw new BusinessException("1340", ErrorMessageConstants.PROPER_RFP_REALIZATION_DATE);
//		} 
		else if (rfp.getTcvUsd().isEmpty() || rfp.getTcvUsd().length() == 0) {
			throw new BusinessException("1341", ErrorMessageConstants.PROPER_RFP_TCV_USD);
		} else if (rfp.getEffort().isEmpty() || rfp.getEffort().length() == 0) {
			throw new BusinessException("1342", ErrorMessageConstants.PROPER_RFP_EFFORT);
		} else if (rfp.getProjectPlannedStatus().isEmpty() || rfp.getProjectPlannedStatus().length() == 0) {
			throw new BusinessException("1343", ErrorMessageConstants.PROPER_RFP_PROJECT_PLANNED_STATUS);
		}
		try {
			RFP rfpData = this.rfpRepo.findById(id).orElse(null);
			rfpData.setRfpTitle(rfp.getRfpTitle());
			rfpData.setClient(rfp.getClient());
			rfpData.setStatus(rfp.getStatus());
			rfpData.setRegion(rfp.getRegion());
			rfpData.setTechnology(rfp.getTechnology());
			rfpData.setJavaCapabilityRfpTeam(rfp.getJavaCapabilityRfpTeam());
			rfpData.setDxcSolutioningLead(rfp.getDxcSolutioningLead());
			rfpData.setType(rfp.getType());
			rfpData.setNotes(rfp.getNotes());
			rfpData.setTotalDealValue(rfp.getTotalDealValue());
			rfpData.setOpxId(rfp.getOpxId());
			rfpData.setDateOfEntry(rfp.getDateOfEntry());
			rfpData.setEtaToSubmitRfp(rfp.getEtaToSubmitRfp());
			rfpData.setRealizationDate(rfp.getRealizationDate());
			rfpData.setTcvUsd(rfp.getTcvUsd());
			rfpData.setEffort(rfp.getEffort());
			rfpData.setProjectPlannedStatus(rfp.getProjectPlannedStatus());
			return this.rfpRepo.save(rfpData);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1344", ErrorMessageConstants.RFP_ID_NULL + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("1345", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1346", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	@Override
	public void deleteRFP(Long id) {
		this.rfpRepo.deleteById(id);
	}

}
