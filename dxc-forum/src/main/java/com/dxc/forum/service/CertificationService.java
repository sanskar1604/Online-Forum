package com.dxc.forum.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.entity.Certification;

public interface CertificationService {

	Certification addCertificationEntity(Certification certificationEntity);

	List<Certification> getCertificationEntities();

	public Certification updateCerticationEntity(Certification certificationEntity, long id);

	public Certification getCertificationEntityById(long id);

	ResponseEntity<Certification> deleteCertificationEntityById(long id);
	//Upload Excel Sheet
	public void uploadExcel(MultipartFile file);

	public Long totalCertificate();
	
	public Long totalExamStatusPass();
	
	public Long totalExamStatusScheduled();
	
	public Long totalExamStatusExpiredAndFail();
	
	public Long totalVoucherIssued();
}
