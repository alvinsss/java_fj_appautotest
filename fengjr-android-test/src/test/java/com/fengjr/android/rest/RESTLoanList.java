package com.fengjr.android.rest;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.fengjr.android.lexicon.imp.LoanItem;
import com.fengjr.android.utils.Result;
import com.fengjr.api.REST;
import com.fengjr.event.request.LoansFilterRequest;
import com.fengjr.event.response.LoansFilterResponse;
import com.fengjr.model.FilterParam;
import com.fengjr.model.Loan;
import com.fengjr.model.enums.LoanPurpose;

public class RESTLoanList extends RestBase {

	private List<Loan> loans;
	private FilterParam mParam = new FilterParam();
	private Logger logger;

	public RESTLoanList() {
		mParam.purpose = LoanPurpose.FENG_CX;
		mParam.lastLoanId = "0";
		mParam.pageSize = "10000";
		mParam.status = "SCHEDULED";
		mParam.minDuration = "0";
		mParam.maxDuration = "60";
		mParam.minRate = "0";
		mParam.maxRate = "100";
		logger = Logger.getLogger(getClass().getPackage().getName());
	}

	public RESTLoanList(LoanPurpose purpose) {
		this();
		mParam.purpose = purpose;
	}
	
	public RESTLoanList(FilterParam param) {
		this();
		mParam = param;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void request() {

		LoansFilterRequest loadFilterRequest = new LoansFilterRequest(
				getContext(), mParam);
		REST rest = new REST();
		LoansFilterResponse response = rest.response(loadFilterRequest);

		loans = (List<Loan>) response.result.data;
	}

	/**
	 * 检查服务器返回项目列表排序是否正确
	 * @return
	 */
	public boolean checkItemOrder() {
		throw new UnsupportedOperationException(getClass().getName());
	}

	/**
	 * 比较客户端列表与服务器返回列表是否一致
	 * @param clientLoanList
	 * @return
	 */
	public Result compareLoansOrder(List<LoanItem> clientLoanList) {
		int clientSize = clientLoanList.size();
		int remoteSize = loans.size();
		if (clientSize != remoteSize) {
			StringBuilder sb = new StringBuilder();
			logger.info("理理财项目列表数目与请求返回项目数目不一致, expected：" + remoteSize
					+ ", actully：" + clientSize + "\n");
			return new Result(sb.toString(), false);
		} else {
			for (int i = 0; i < clientLoanList.size(); i++) {
				String clientItemTitle = clientLoanList.get(i).getTitle();
				String remoteItemTitle = loans.get(i).getTitle();
				if (!clientItemTitle.equals(remoteItemTitle)) {
					StringBuilder sb = new StringBuilder();
					logger.info(clientItemTitle + "项目位置与请求列表中位置不一致, position:" + i);
					return new Result(sb.toString(), false);
				}
			}
		}
		String message = "Passed: 理理财项目列表与服务器返回列表排序一致";
		logger.info(message);
		return new Result(message, true);
	}

	/**
	 * 比较贷款期限显示是否正常，是否与服务器返回数据一致
	 * @param investList
	 * @return
	 */
	public Result compareLoansExpire(List<LoanItem> clientLoans) {
		int size = clientLoans.size() < loans.size() ? clientLoans.size() : loans.size();
		for (int i = 0; i < size; i++) {
			LoanItem serverItem = new LoanItem(loans.get(i));
			String serverDuration = serverItem.getDuration();
			String clientDuration = clientLoans.get(i).getDuration();
			if (clientDuration.equals(serverDuration)) {
				continue;
			} else {
				return new Result("贷款期限显示异常，expected:" + serverDuration + 
						", actually:" + clientDuration + ", position:" + i, false);
			}
		}
		return new Result("贷款期限显示正常", true);
	}

	/**
	 * 比较贷款利率是否与服务器返回一致
	 * @param investList
	 * @return
	 */
	public Result compareLoansRate(List<LoanItem> clientLoans) {
		int size = clientLoans.size() < loans.size() ? clientLoans.size() : loans.size();
		for (int i = 0; i < size; i++) {
			LoanItem serverItem = new LoanItem(loans.get(i));
			String serverRate = serverItem.getRate();
			String clientRate = clientLoans.get(i).getRate();
			if (clientRate.equals(serverRate)) {
				continue;
			} else {
				return new Result("贷款利率显示异常，expected:" + serverRate + 
						", actually:" + clientRate + ", position:" + i, false);
			}
		}
		return new Result("贷款利率显示正常", true);
	}

	/**
	 * 比较贷款金额是否与服务器返回一致
	 * @param investList
	 * @return
	 */
	public Result compareLoansAmmount(List<LoanItem> clientLoans) {
		int size = clientLoans.size() < loans.size() ? clientLoans.size() : loans.size();
		for (int i = 0; i < size; i++) {
			LoanItem serverItem = new LoanItem(loans.get(i));
			String serverAmmount = serverItem.getAmount();
			String clientAmmount = clientLoans.get(i).getAmount();
			if (clientAmmount.equals(serverAmmount)) {
				continue;
			} else {
				return new Result("贷款金额显示异常，expected:" + serverAmmount + 
						", actually:" + clientAmmount + ", position:" + i, false);
			}
		}
		return new Result("贷款金额显示正常", true);
	}
	
	/**
	 * 比较贷款状态是否与服务器返回一致
	 * @param investList
	 * @return
	 */
	public Result compareLoansStatus(List<LoanItem> clientLoans) {
		int size = clientLoans.size() < loans.size() ? clientLoans.size() : loans.size();
		for (int i = 0; i < size; i++) {
			LoanItem serverItem = new LoanItem(loans.get(i));
			String serverStatus = serverItem.getStatus();
			String clientStatus = clientLoans.get(i).getStatus();
			if (clientStatus.equals(serverStatus)) {
				continue;
			} else {
				return new Result("贷款金额显示异常，expected:" + serverStatus + 
						", actually:" + clientStatus + ", position:" + i, false);
			}
		}
		return new Result("贷款金额显示正常", true);
	}

//	private void logCompareData(List<LoanItem> clientData,
//			List<Loan> serverData) {
//		logger.info("client data:");
//		for (LoanItem item : clientData) {
//			logger.info(item.getTitle() + "\t" + item.getStatus() + "\t"
//					+ item.getRate() + "\t" + item.getAmount() + "\t"
//					+ item.getDuration());
//		}
//		logger.info("server data:");
//		for (Loan item : serverData) {
//			logger.info(item.getTitle() + "\t" + item.getStatus() + "\t"
//					+ item.getRate() + "\t" + item.getAmount() + "\t"
//					+ item.getDuration());
//		}
//	}
	
	@Test
	public void testLoanList() {
		request();

		Iterator<Loan> iter = loans.iterator();
		while (iter.hasNext()) {
			Loan loan = iter.next();
			System.out.println(loan.title + ";" + loan.status);
		}
	}


}
