package com.pht.base.role.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 菜单(SysMenu)实体类
 *
 * @author pht
 * @since 2021-03-14 12:30:26
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 111046044296835504L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 编号
    */
    private String code;
    /**
    * 名称
    */
    private String name;
    /**
    * 路由
    */
    private String url;
    /**
    * 父级路由
    */
    private String parentUrl;
    /**
    * 排序号
    */
    private String sortNo;
    /**
    * 创建时间
    */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}