package com.vti.testing.controller;

import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentService.getAllDepartments(pageable);
    }

    @GetMapping("name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable String name) {
        return departmentService.getDepartmentsByName(name);
    }

    @GetMapping("totalmember/range")
    public List<Department> getDepartmentsTotalMemberByRange(int from, int to){
        return departmentService.getDepartmentsTotalMemberByRange(from, to);
    }

    @DeleteMapping("name/{name}")
    public void deleteByName(@PathVariable String name){
        departmentService.deleteByName(name);
    }
}
