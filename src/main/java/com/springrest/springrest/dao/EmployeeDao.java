package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.EmployeeDTO;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<EmployeeDTO, Long>
{
    EmployeeDTO findByeId(long l);


// Optional<EmployeeDTO> findByEid(long id);
}