package com.fred.authshiro.request.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Fred
 * @date 2021/3/13 14:24
 */
@Data
public class Pagination<T> extends PageSize {
    private List<T> rows;
    private int pageTotal;
    private long rowTotal;

    public static <R> Pagination<R> build(List<R> list) {
        Pagination<R> pagination = new Pagination<>();
        if (list instanceof Page) {
            // TODO 需要检查获取的数据是否正确
            Page<R> page = (Page) list;
            pagination.setRowTotal(page.getTotal());
            pagination.setPageTotal(page.getPages());
            pagination.setRows(page.getResult());
            pagination.setPage(page.getPageNum());
            pagination.setPageSize(page.getPageSize());
        }
        return pagination;
    }
}
