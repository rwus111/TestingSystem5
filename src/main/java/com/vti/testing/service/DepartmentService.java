package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
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
