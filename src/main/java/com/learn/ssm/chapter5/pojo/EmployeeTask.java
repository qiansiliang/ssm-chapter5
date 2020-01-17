package com.learn.ssm.chapter5.pojo;

import lombok.Data;

@Data
public class EmployeeTask {
    private Long id;
    private Long empId;
    private Task task = null;
    private String taskName;
    private String note;
}
