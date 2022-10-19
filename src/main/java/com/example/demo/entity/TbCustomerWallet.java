package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "tb_customer_wallet")
@Data
public class TbCustomerWallet {
    /**
     * 主键
     */
    @TableId(value = "c_pk_id", type = IdType.ASSIGN_ID)
    private String cPkId;

    /**
     * 用户id
     */
    @TableField(value = "c_user_id")
    private String cUserId;

    /**
     * 账户余额
     */
    @TableField(value = "n_balance")
    private Integer nBalance;

    /**
     * 版本号
     */
    @TableField(value = "n_versions")
    private Integer nVersions;

    /**
     * 最新标识
     */
    @TableField(value = "c_new_flag")
    private String cNewFlag;

    public static final String COL_C_PK_ID = "c_pk_id";

    public static final String COL_C_USER_ID = "c_user_id";

    public static final String COL_N_BALANCE = "n_balance";

    public static final String COL_N_VERSIONS = "n_versions";

    public static final String COL_C_NEW_FLAG = "c_new_flag";


}