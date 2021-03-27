package com.example.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hr.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {
	List<EmployeeEntity> findAllByBirthYearBetween(int from, int to);
	@Query("select e from EmployeeEntity e where e.birthYear between :from and :to")
	List<EmployeeEntity> gitGetir(int from, int to);
	@Query(value="select e from employees e where e.birth_year between :from and :to",nativeQuery = true)
	List<EmployeeEntity> gitGetirNative(int from, int to);
}
