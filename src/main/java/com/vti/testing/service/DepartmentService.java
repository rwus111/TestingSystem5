package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartmentsByName(String name) {
        return departmentRepository.findByNameContaining(name);
    }

    @Override
    public List<Department> getDepartmentsTotalMemberByRange(int from, int to) {
        return departmentRepository.findByTotalMemberBetween(from, to);
    }

    @Override
    public void deleteByName(String name) {
        departmentRepository.deleteByName(name);
    }
}
