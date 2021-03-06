package com.pht.base.system.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 字典表(SysDict)实体类
 *
 * @author makejava
 * @since 2021-03-05 23:01:29
 */
@Data
public class SysDict implements Serializable {
    private static final long serialVersionUID = -41778105586503603L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 字典类型
     */
    private String type;
    /**
     * 值
     */
    private String value;
    /**
     * 描述
     */
    private String label;
    /**
     * 父类型
     */
    private String parentType;
    /**
     * 父字典值
     */
    private String parentValue;
    /**
     * 创建时间
     */
    private Date createTime;

    private List<SysDict> subDicts;


}
