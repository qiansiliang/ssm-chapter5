package com.learn.ssm.chapter5.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("role")
public class Role {
    private static final long serialVersionUID = 598736524547906734L;

    private Long id;
    private String roleName;
    private String note;
}
