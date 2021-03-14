package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_role_resource
 * @author 
 */
@Data
public class TbRoleResourceKey implements Serializable {
    private Integer id;

    private Integer resourceId;

    private static final long serialVersionUID = 1L;
}