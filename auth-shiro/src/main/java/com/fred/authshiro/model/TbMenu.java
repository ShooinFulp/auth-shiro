package com.fred.authshiro.model;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_menu
 * @author 
 */
@Data
public class TbMenu implements Serializable {
    private Integer id;

    /**
     * 父级ID
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级数
     */
    private Integer level;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 前端图标
     */
    private String icon;

    /**
     * 前端隐藏
     */
    private Integer hidden;

    private static final long serialVersionUID = 1L;
}