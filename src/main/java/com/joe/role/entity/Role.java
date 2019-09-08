package com.joe.role.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
@Data
@TableName("role")
@Builder
@AllArgsConstructor
public class Role{

    private Integer id;

    private String name;

}
