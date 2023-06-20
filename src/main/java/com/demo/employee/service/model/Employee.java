package com.demo.employee.service.model;

import lombok.Data;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
