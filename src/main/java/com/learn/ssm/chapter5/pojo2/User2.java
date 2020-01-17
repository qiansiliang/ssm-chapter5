package com.learn.ssm.chapter5.pojo2;

import com.learn.ssm.chapter5.enumeration.SexEnum;
import lombok.Data;

import java.util.List;

@Data
public class User2 {
	private Long id;
	private String userName;
	private String realName;
	private SexEnum sex;
	private String mobile;
	private String email;
	private String note;
	private List<Role2> roleList;
}
