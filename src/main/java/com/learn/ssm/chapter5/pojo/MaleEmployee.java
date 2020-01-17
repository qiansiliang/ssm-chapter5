package com.learn.ssm.chapter5.pojo;

import lombok.Data;

@Data
public class MaleEmployee extends Employee {
	private MaleHealthForm maleHealthForm = null;
}
