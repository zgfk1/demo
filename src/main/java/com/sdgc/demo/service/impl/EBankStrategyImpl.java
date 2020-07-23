package com.sdgc.demo.service.impl;

import com.sdgc.demo.enumerate.RechargeTypeEnum;
import com.sdgc.demo.service.Strategy;

public class EBankStrategyImpl implements Strategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge;
    }
}