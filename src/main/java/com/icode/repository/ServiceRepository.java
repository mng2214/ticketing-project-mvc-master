package com.icode.repository;

import com.icode.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);


}
