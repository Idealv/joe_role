package com.joe.role.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author joe
 * @since 2019-09-07
 */
@Data
@TableName("user")
public class User{

    private Integer id;

    private String username;

    private String password;


}
