package com.pht.sms.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 短信详情(SmsDetails)实体类
 *
 * @author makejava
 * @since 2021-03-04 16:34:54
 */
@Data
public class SmsDetails implements Serializable {
    private static final long serialVersionUID = 244275792138034883L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 状态
     */
    private String status;
    /**
     * 客户编号
     */
    private String custCode;
    /**
     * 短信模板编号
     */
    private String smsTemplateCode;
    /**
     * 手机号码
     */
    private String telPhone;
    /**
     * 模板业务参数
     */
    private String templateParam;
    /**
     * 短信内容
     */
    private String content;
    /**
     * 短信响应状态
     */
    private String smsStatus;
    /**
     * 短信id
     */
    private String ssmId;
    /**
     * 扣费金额
     */
    private BigDecimal consumption;
    /**
     * 余额
     */
    private BigDecimal tmoney;
    /**
     * 发送条数
     */
    private String smsSend;

    /**
     * 批次编号
     */

    private String batchNum;


    /**
     * 描述
     */
    private String dsc;
    /**
     * 创建时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 操作人名称
     */
    private String operateName;
}
