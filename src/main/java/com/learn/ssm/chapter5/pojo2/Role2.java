package com.learn.ssm.chapter5.pojo2;

import lombok.Data;

import java.util.List;

@Data
public class Role2 {
	private Long id;
	private String roleName;
	private String note;
	private List<User2> userList;
}
