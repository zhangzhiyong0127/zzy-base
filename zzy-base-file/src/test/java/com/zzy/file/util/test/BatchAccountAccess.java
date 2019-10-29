package com.zzy.file.util.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: xiao.wf
 * Date: 2019-02-28
 * Time: 15:59
 */
@Data
public class BatchAccountAccess {

    /**
     * 账务业务流水号
     */
    @Expose
    @SerializedName("accBusiSerialNo")
    protected String accBusiSerialNo;

    /**
     * 业务接入系统定义的业务系统编号，用于标识对接业务系统
     */
    @Expose
    @SerializedName("busiAccessSysNo")
    protected String busiAccessSysNo;

    /**
     * 业务接入流水号
     */
    @Expose
    @SerializedName("busiAccessSerialNo")
    protected String busiAccessSerialNo;

    /**
     * 业务接入批次号
     */
    @Expose
    @SerializedName("busiAccessBatchNo")
    protected String busiAccessBatchNo;

    /**
     * WORK_DATE
     */
    @Expose
    @SerializedName("sysAccDate")
    protected String sysAccDate;

    /**
     * 所属前端业务平台
     */
    @Expose
    @SerializedName("busiPlatform")
    protected String busiPlatform;

    /**
     * 核算机构
     */
    @Expose
    @SerializedName("accountOrg")
    protected String accountOrg;

    @Expose
    @SerializedName("marketProduct")
    protected String marketProduct;

    @Expose
    @SerializedName("mainBodyType")
    protected String mainBodyType;

    /**
     * 账户类型 对账户进行分类定义，见参数表
     */
    @Expose
    @SerializedName("accountType")
    protected String accountType;

    /**
     * 交易码
     */
    @Expose
    @SerializedName("transCode")
    protected String transCode;

    /**
     * 交易摘要 对业务处理进行备注说明
     */
    @Expose
    @SerializedName("transMemo")
    protected String transMemo;

    /**
     * 账户账号
     */
    @Expose
    @SerializedName("accountNo")
    protected String accountNo;

    /**
     * 账户别名
     */
    @Expose
    @SerializedName("accountName")
    protected String accountName;

    /**
     * 客户编号 客户编号，原则上同一客户在系统中唯一
     */
    @Expose
    @SerializedName("customerNo")
    protected String customerNo;

    /**
     * 用户编号
     * 用户编号，商户客户对应商户分户号，个人客户对应用户号，其他对应各自编号
     */
    @Expose
    @SerializedName("userNo")
    protected String userNo;

    /**
     * 提现模式  0-代办提现(账务寻找银行卡信息); 1-自主提现(前端报文送银行卡信息); 2-不提现; 3-支付转代付
     */
    @Expose
    @SerializedName("withdrawMode")
    protected String withdrawMode;

    /**
     * 币种
     */
    @Expose
    @SerializedName("currency")
    protected String currency;

    /**
     * 授信标识	01-无授信，02-循环额度(还款后恢复)，03-周期额度(按周期恢复)
     */
    @Expose
    @SerializedName("creditFlag")
    protected String creditFlag;

    /**
     * 授信额度
     */
    @Expose
    @SerializedName("creditAmt")
    protected BigDecimal creditAmt;

    /**
     * 开户辅助信息 组合字段，保存不同类型账户的个性化信息，例如商户号，商户名称等
     */
    @Expose
    @SerializedName("assistInfo")
    protected String assistInfo;

    /**
     * 账户有效期
     */
    @Expose
    @SerializedName("expiredDate")
    protected String expiredDate;

    /**
     * 处理状态 00-成功 01-初始 02-处理中 03-失败 04-超时 05-未知
     */
    @Expose
    @SerializedName("transResult")
    protected String transResult;

    /**
     * 错误码
     */
    @Expose
    @SerializedName("errorCode")
    protected String errorCode;

    /**
     * 错误说明
     */
    @Expose
    @SerializedName("errorMsg")
    protected String errorMsg;

    /**
     * 业务请求时间
     */
    @Expose
    @SerializedName("requestTime")
    protected String requestTime;

    /**
     * 记录生成时间
     */
    @Expose
    @SerializedName("insertTime")
    protected Date insertTime;

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(accountNo).append("|");
        buffer.append(accountName).append("|");
        buffer.append(userNo).append("|");
        buffer.append(transResult).append("|");
        buffer.append(errorCode).append("|");
        buffer.append(errorMsg);
        return buffer.toString();
    }

}
