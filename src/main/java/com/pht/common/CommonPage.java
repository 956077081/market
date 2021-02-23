package com.pht.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 封装列表页
 * @param <T>
 */
public class CommonPage<T> {
    private Integer currPage;//当前页

    private Integer pageSize;//页大小

    private Integer totalPage;//总页数

    private Long totalSize;//总数量

    private List<T> content;//业务数据

    public static  <T> CommonPage<T> crtPageContent(List<T> content){
        PageInfo<T> pageInfo =new PageInfo<>(content);
        CommonPage<T> page = new CommonPage<>();
        page.setCurrPage(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotalPage(pageInfo.getPages());
        page.setTotalSize(pageInfo.getTotal());
        page.setContent(pageInfo.getList());
        return page;
    }
    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
