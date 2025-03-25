package com.vti.testing.controller;

import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable String name) {
        return departmentService.getDepartmentsByName(name);
    }

    @GetMapping("totalmember/range")
    public List<Department> getDepartmentsTotalMemberByRange(int from, int to){
        return departmentService.getDepartmentsTotalMemberByRange(from, to);
    }
}
