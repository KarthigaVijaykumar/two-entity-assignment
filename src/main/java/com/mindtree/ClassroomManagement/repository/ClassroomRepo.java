package com.mindtree.ClassroomManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.ClassroomManagement.entity.Classroom;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom,Integer>{

}
