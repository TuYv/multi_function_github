package com.longbig.multifunction.dto;

import lombok.Data;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 交易员当前订单
 * @create 2023-06-27 15:28
 **/
@Data
public class TraderCurrentDTO {
    /**
     * 跟单号
     */
    private String trackingNo;
    /**
     * 逐仓/全仓(fixed 逐仓/crossed 全仓)
     */
    private String holdMode;
    /**
     * 持仓方向(long 多/short 空)
     */
    private String holdSide;
    /**
     * 杠杆
     */
    private String leverage;
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 开仓均价
     */
    private String openPrice;
    /**
     * 开仓时间 （毫秒时间戳）
     */
    private String openTime;
    /**
     * 开仓数量（左币）
     */
    private String openAmount;
    /**
     * 此笔订单跟单人数
     */
    private String followerNum;
    /**
     * 止盈价
     */
    private String takeProfitPrice;
    /**
     * 止损价
     */
    private String stopLossPrice;
    /**
     * 保证金
     */
    private String marginAmount;
}
