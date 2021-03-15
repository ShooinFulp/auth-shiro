package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_role
 * @author 
 */
@Data
public class TbRole implements Serializable {
    private Integer id;

    private String roleName;

    private static final long serialVersionUID = 1L;
}