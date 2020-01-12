package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.param.PageParams;
import com.learn.ssm.chapter5.param.RoleParams;
import com.learn.ssm.chapter5.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    public Role getRole(Long id);

    public Role getRoleUseResultMap(Long id);

    public List<Role> findRolesByMap(Map<String, Object> parameterMap);

    public List<Role> findRolesByAnnotation(@Param("roleName") String roleName, @Param("note") String note);

    public List<Role> findRolesByBean(RoleParams roleParams);

    public List<Role> findRolesByMix(@Param("params") RoleParams roleParams, @Param("page")PageParams pageParams);
}
