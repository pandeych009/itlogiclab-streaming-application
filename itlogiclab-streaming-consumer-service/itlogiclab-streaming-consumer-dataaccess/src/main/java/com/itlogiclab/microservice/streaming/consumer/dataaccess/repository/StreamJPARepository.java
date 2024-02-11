package com.itlogiclab.microservice.streaming.consumer.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlogiclab.microservice.streaming.consumer.dataaccess.entity.StreamEntity;

@Repository
public interface StreamJPARepository extends JpaRepository<StreamEntity, Long>{

}
