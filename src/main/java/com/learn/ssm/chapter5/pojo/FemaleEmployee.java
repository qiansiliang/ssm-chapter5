package com.learn.ssm.chapter5.pojo;

import lombok.Data;

@Data
public class FemaleEmployee extends Employee{
	private FemaleHealthForm femaleHealthForm = null;
}
