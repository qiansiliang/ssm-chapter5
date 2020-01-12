package com.learn.ssm.chapter5.main;

import com.learn.ssm.chapter5.mapper.RoleMapper;
import com.learn.ssm.chapter5.param.PageParams;
import com.learn.ssm.chapter5.param.RoleParams;
import com.learn.ssm.chapter5.pojo.Role;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.SqlSessionFactoryUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Chapter5Application {

    public static void main(String[] args) {
        testGetRoleUseResultMap();
//        testFindRolesByMap();
//        testFindRolesByAnnotation();
//        testFindRolesByBean();
//        testFindRolesByMix();
    }

    public static void testGetRoleUseResultMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRoleUseResultMap(1L);
            log.debug(role.getRoleName());
            log.debug(role.getNote());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testFindRolesByMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("roleName", "role_1");
            parameterMap.put("note", "note_1");
            List<Role> roles = roleMapper.findRolesByMap(parameterMap);
            for (Role role : roles) {
                log.debug(role.getRoleName());
                log.debug(role.getNote());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testFindRolesByAnnotation() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles = roleMapper.findRolesByAnnotation("role_1", "note_1");
            for (Role role : roles) {
                log.debug(role.getRoleName());
                log.debug(role.getNote());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testFindRolesByMix() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RoleParams roleParams = new RoleParams();
            roleParams.setRoleName("role_1");
            roleParams.setNote("note_1");
            PageParams pageParams = new PageParams();
            pageParams.setOffset(0);
            pageParams.setLimit(2);
            List<Role> roles= roleMapper.findRolesByMix(roleParams, pageParams);
            for (Role role : roles) {
                log.debug(role.getRoleName());
                log.debug(role.getNote());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
