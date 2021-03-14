package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_role_resource
 * @author 
 */
@Data
public class TbRoleResource extends TbRoleResourceKey implements Serializable {
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}