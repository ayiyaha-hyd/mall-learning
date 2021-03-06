package com.hyd.mall.tiny.dao;

import com.hyd.mall.tiny.mbg.model.UmsPermission;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 */
@Repository
public interface UmsAdminRoleRelationDao {
	/**
	 * 获取用户所有权限(包括+-权限)
	 */
	List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
