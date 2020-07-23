package com.sdgc.demo.enumerate;

public enum RechargeTypeEnum {

    /**
     * ①网银充值->8.5折；
     */
    E_BANK(1, "网银充值"),
    /**
     * ②商户充值->9.0折；
     */
    BUSI_ACCOUNTS(2, "商户充值"),
    /**
     * ③手机充值->不优惠；
     */
    MOBILE(3, "手机充值"),
    /**
     * ④点卡充值->额外收取1%费用。
     */
    CARD_RECHARGE(4, "点卡充值");

    public Integer index;
    public String name;


    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    RechargeTypeEnum() {
    }

    public static RechargeTypeEnum valueOf(Integer a) {

        switch (a) {
            case 1:
                return RechargeTypeEnum.E_BANK;
            case 2:
                return RechargeTypeEnum.BUSI_ACCOUNTS;
            case 3:
                return RechargeTypeEnum.MOBILE;
            case 4:
                return RechargeTypeEnum.CARD_RECHARGE;
            default:
                return null;
        }


    }

    public Integer getValue() {


        for (RechargeTypeEnum c : RechargeTypeEnum.values()) {
            if (c.getName().equals(name)) {
                return c.getIndex();
            }
        }
        return null;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    RechargeTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }
}
