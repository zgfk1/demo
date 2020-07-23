package com.sdgc.demo.factory;

import com.sdgc.demo.enumerate.RechargeTypeEnum;
import com.sdgc.demo.service.Strategy;
import com.sdgc.demo.service.impl.BusiAcctStrategyImpl;
import com.sdgc.demo.service.impl.CardStrategyImpl;
import com.sdgc.demo.service.impl.EBankStrategyImpl;
import com.sdgc.demo.service.impl.MobileStrategyImpl;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    //    private static StrategyFactory factory = new StrategyFactory();
    //    private StrategyFactory(){
    //    }
    //    private static Map strategyMap = new HashMap<>();
    //    static{
    //        strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategyImpl());
    //        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategyImpl());
    //        strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategyImpl());
    //        strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategyImpl());
    //    }
    //    public Strategy creator(Integer type){
    //        return strategyMap.get(type);
    //    }
    //    public static StrategyFactory getInstance(){
    //        return factory;
    //    }
}
