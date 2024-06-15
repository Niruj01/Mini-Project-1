package com.springBoot.EmployeeManagement.EmployeeList.Repository;

import com.springBoot.EmployeeManagement.EmployeeList.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}
