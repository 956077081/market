package com.pht.base.system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统配置(SysParamConfig)实体类
 *
 * @author makejava
 * @since 2021-03-04 16:57:13
 */
public class SysParamConfig implements Serializable {
    private static final long serialVersionUID = 176823133510999655L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 级别
     */
    private String level;
    /**
     * 模块
     */
    private String module;
    /**
     * 配置名称
     */
    private String name;
    /**
     * 描述
     */
    private String dsc;
    /**
     * 值
     */
    private String value;
    /**
     * 默认值
     */
    private String defValue;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
