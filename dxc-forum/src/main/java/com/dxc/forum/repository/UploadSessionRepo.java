package com.dxc.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.forum.entity.UploadSession;

@Repository
public interface UploadSessionRepo extends JpaRepository<UploadSession,Long> {

	UploadSession findByTopicName(String topicName);

}
