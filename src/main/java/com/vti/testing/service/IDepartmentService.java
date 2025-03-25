package com.vti.testing.service;

import com.vti.testing.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> getAllDepartments(Pageable pageable);

    List<Department> getDepartmentsByName(String name);

    List<Department> getDepartmentsTotalMemberByRange(int from, int to);

    void deleteByName(String name);
}
