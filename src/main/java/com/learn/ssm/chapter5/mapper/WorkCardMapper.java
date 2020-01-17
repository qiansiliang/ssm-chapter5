package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.pojo.WorkCard;

public interface WorkCardMapper {
	public WorkCard getWorkCardByEmpId(Long empId);
}
