package com.pht.base.role.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色类型(SysRoleType)实体类
 *
 * @author pht
 * @since 2021-03-14 12:31:52
 */
public class SysRoleType implements Serializable {
    private static final long serialVersionUID = 350932860119120177L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 角色类型
    */
    private String type;
    /**
    * 角色类型名称
    */
    private String name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}