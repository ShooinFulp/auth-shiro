package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_user_role
 * @author 
 */
@Data
public class TbUserRole extends TbUserRoleKey implements Serializable {
    private Integer userId;

    private static final long serialVersionUID = 1L;
}