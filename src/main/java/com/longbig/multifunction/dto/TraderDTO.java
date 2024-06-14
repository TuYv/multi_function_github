package com.longbig.multifunction.dto;

import java.util.List;
import lombok.Data;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 交易员dto
 * @create 2023-06-26 23:12
 **/
@Data
public class TraderDTO {
    /**
     * 是否可跟
     */
    private boolean canTrace;
    /**
     * 交易员uid
     */
    private String traderUid;
    /**
     * 交易员昵称
     */
    private String traderNickName;
    /**
     * 最大可跟人数
     */
    private String maxFollowCount;
    /**
     * 已跟人数
     */
    private String followCount;
    /**
     * 交易员简介
     */
    private String profile;
    /**
     * 可跟单币对
     */
    private List<String> tradingPairsAvailable;
    /**
     * 交易员交易指标数据
     */
    private List<ColumnListBean> columnList;

    /**
     * 累计跟单人数
     */
    private String totalFollowers;
    /**
     * 盈利单数
     */
    private String profitOrderCount;
    /**
     * 亏损单数
     */
    private String lossOrderCount;
    /**
     * 总交易单数
     */
    private String totalTradeCount;
    /**
     * 交易员头像
     */
    private String traderHeadPic;
    /**
     * 最大回撤率
     */
    private String maxCallbackRate;
    /**
     * 平均胜率
     */
    private String averageWinRate;
    /**
     * 最近每日收益率
     */
    private List<DailyProfitRateBean> dailyProfitRate;

    /**
     * 最近每日收益
     */
    private List<DailyProfitBean> dailyProfit;
    /**
     * 最近24小时收益率
     */
    private List<DailyProfitRateBean> profitRate24h;
    /**
     * 最近24小时收益
     */
    private List<DailyProfitBean> profit24h;
    /**
     * 最近交易时间
     */
    private String lastTradeTime;
    /**
     * 跟单天数
     */
    private String copyTradeDays;

    @Data
    public class DailyProfitBean {
        /**
         * amount : 10910.6538
         * ctime : 1685721600000
         */

        private String amount;
        private String ctime;
    }
    @Data
    public class DailyProfitRateBean {
        /**
         * rate : 4552.229633
         * ctime : 1685721600000
         */

        private String rate;
        private String ctime;
    }

    @Data
    public class ColumnListBean {
        /**
         * describe : ROI
         * value : 909.94
         */

        private String describe;
        private String value;
    }
}
