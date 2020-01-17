package com.learn.ssm.chapter5.main;

import com.learn.ssm.chapter5.mapper.EmployeeMapper;
import com.learn.ssm.chapter5.mapper.RoleMapper;
import com.learn.ssm.chapter5.mapper2.RoleMapper2;
import com.learn.ssm.chapter5.param.PageParams;
import com.learn.ssm.chapter5.param.RoleParams;
import com.learn.ssm.chapter5.pojo.Employee;
import com.learn.ssm.chapter5.pojo.Role;
import com.learn.ssm.chapter5.pojo2.Role2;
import com.learn.ssm.chapter5.pojo2.User2;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.learn.ssm.chapter5.utils.SqlSessionFactoryUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Chapter5Application {

    public static void main(String[] args) {
//        testGetRole();
//        testGetRoleUseResultMap();
//        testFindRolesByMap();
//        testFindRolesByAnnotation();
//        testFindRolesByBean();
//        testFindRolesByMix();
//        testFindRolesByRowBounds();
//        testInsertRole();
//        testUpdateRole();
//        testInsertRole();
//        testGetEmployee();
//        testGetEmployee2();
//        testGetRole2();
//		testOneLevelCache();
		testOneLevelCache2();
    }

    public static void testGetRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
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

    public static void testFindRolesByRowBounds() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RowBounds rowBounds = new RowBounds(0, 20);
            List<Role> roles = roleMapper.findRolesByRowBounds("role_name", "note", rowBounds);
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

    public static void testInsertRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name_4");
            role.setNote("note_4");
            roleMapper.insertRole(role);
            //回填
            System.out.println(role.getId());
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testUpdateRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setId(4L);
            role.setRoleName("role_name_5");
            role.setNote("note_5");
            int res = roleMapper.updateRole(role);
            //回填
            System.out.println(res);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testDeleteRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int res = roleMapper.deleteRole(4L);
            //回填
            System.out.println(res);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testGetEmployee() {
    	SqlSession sqlSession = null;
    	try {
    		sqlSession = SqlSessionFactoryUtils.openSqlSession();
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getEmployee(1L);
			log.debug(employee.getWorkCard().getPosition());
		} catch (Exception ex) {
    		ex.printStackTrace();
		} finally {
    		if (sqlSession != null) {
    			sqlSession.close();
			}
		}
	}

	public static void testGetEmployee2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getEmployee2(1L);
			log.debug(employee.getWorkCard().getPosition());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testGetRole2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
			Role2 role2 = roleMapper2.getRole(1L);
			for (User2 user2: role2.getUserList()) {
				log.debug(user2.getEmail());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testOneLevelCache() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			// 存在commit的时候，表示有增删改，会删除一级缓存
			// sqlSession.commit();
			log.info("再获取一次POJO......");
			Role role2 = roleMapper.getRole(1L);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testOneLevelCache2() {
		SqlSession sqlSession = null;
		SqlSession sqlSession2 = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			sqlSession2 = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			//需要提交，如果是一级缓存，MyBatis才会缓存对象到SqlSessionFactory层面
			sqlSession.commit();
			log.info("不同sqlSession再获取一次POJO......");
			RoleMapper roleMapper2 = sqlSession2.getMapper(RoleMapper.class);
			Role role2 = roleMapper2.getRole(1L);
			//需要提交，MyBatis才缓存对象到SQLSessionFactory
			sqlSession2.commit();
		} catch(Exception e) {
			log.info(e.getMessage(), e);
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
			if (sqlSession2 != null) {
				sqlSession.close();
			}
		}
	}
}
