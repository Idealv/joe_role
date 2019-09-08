package com.joe.role.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.joe.role.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
