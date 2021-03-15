package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_resource
 * @author 
 */
@Data
public class TbResource implements Serializable {
    private Integer id;

    private String path;

    private String name;

    private static final long serialVersionUID = 1L;
}