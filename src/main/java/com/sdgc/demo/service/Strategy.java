package com.sdgc.demo.service;

import com.sdgc.demo.enumerate.RechargeTypeEnum;

@FunctionalInterface
public interface Strategy {
    Double calRecharge(Double charge, RechargeTypeEnum type);

}
