package com.icode.repository;

import com.icode.entity.Project;
import com.icode.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);

    List<Project> findAllByAssignedManager(User user);

}
