package com.joe.role.mapper;

import com.joe.role.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
@Component
public interface RoleMapper extends BaseMapper<Role> {
    Role findRoleByUserId(Integer id);

}
