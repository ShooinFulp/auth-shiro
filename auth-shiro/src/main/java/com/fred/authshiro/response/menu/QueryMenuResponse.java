package com.fred.authshiro.response.menu;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/29 11:00 下午
 */
@Data
public class QueryMenuResponse {
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
    private Boolean hidden;

    private List<QueryMenuResponse> children;

    @JsonGetter
    public boolean hasChildren() {
        return Objects.nonNull(children) && !children.isEmpty();
    }
}
