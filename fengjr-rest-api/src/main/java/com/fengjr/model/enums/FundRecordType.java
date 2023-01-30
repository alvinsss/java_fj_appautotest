package com.fengjr.model.enums;
/**
 * 
 * @author suetming (suetming.ma@fengjr.com)
 *
 * 创建时间：2014-3-17 下午3:54:15
 *
 */
public enum FundRecordType implements BaseEnum {

	    ALL("ALL"),
	    INVEST("投标"),
	    WITHDRAW("取现"),
	    DEPOSIT("充值"),
	    LOAN("放款"),
	    LOAN_REPAY("贷款还款"),
	    DISBURSE("垫付还款"),
	    INVEST_REPAY("投资还款"),
	    CREDIT_ASSIGN("债权转让"),
	    TRANSFER("转账扣款"),//商户用
	    /**
	     * 奖励
	     */
	    REWARD_REGISTER("注册奖励"),
	    REWARD_INVEST("投标奖励"),
	    REWARD_DEPOSIT("充值奖励"),

	    /**
	     * 服务管理手续费
	     */
	    FEE_WITHDRAW("提现手续费"),
	    FEE_AUTHENTICATE("身份验证手续费"),
	    FEE_INVEST_INTEREST("回款利息管理费"),
	    FEE_LOAN_SERVICE("借款服务费"),
	    FEE_LOAN_MANAGE("借款管理费"),
	    FEE_LOAN_INTEREST("还款利息管理费"),
	    FEE_LOAN_VISIT("实地考察费"),
	    FEE_LOAN_GUARANTEE("担保费"),//一般对应担保类贷款
	    FEE_LOAN_RISK("风险管理费"),//一般对应信用类贷款
	    FEE_LOAN_OVERDUE("逾期管理费"),
	    FEE_LOAN_PENALTY("逾期罚息(给商户)"),//商户收取
	    FEE_LOAN_PENALTY_INVEST("逾期罚息(给投资人)"),//投资人收取
	    FEE_DEPOSIT("充值手续费"),
	    FEE_ADVANCE_REPAY("提前还款违约金(给商户)"),//商户收取
	    FEE_ADVANCE_REPAY_INVEST("提前还款违约金(给投资人)"),//投资人收取
	    FEE_CREDIT_ASSIGN("债权转让手续费"),

	    /**
	     * 生利宝
	     */
	    FSS("生利宝");
	    
	    private final String key;

	    private FundRecordType(String key) {
	        this.key = key;
	    }

	    @Override
	    public String getKey() {
	        return key;
	    }
	}
