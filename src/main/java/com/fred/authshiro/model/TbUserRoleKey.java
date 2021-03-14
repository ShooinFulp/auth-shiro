package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_user_role
 * @author 
 */
@Data
public class TbUserRoleKey implements Serializable {
    private Integer id;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}