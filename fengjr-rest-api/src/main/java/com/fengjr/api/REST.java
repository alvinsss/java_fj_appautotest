package com.fengjr.api;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import android.text.TextUtils;
import android.util.Log;

import com.fengjr.event.Request;
import com.fengjr.event.Response;
import com.fengjr.event.request.ApplyExperienceRequest;
import com.fengjr.event.request.AuthenticatesRequest;
import com.fengjr.event.request.BannerListRequest;
import com.fengjr.event.request.BindCardRequest;
import com.fengjr.event.request.CheckLoginNameRequest;
import com.fengjr.event.request.CorporationRequest;
import com.fengjr.event.request.CreateCreditAssignRequest;
import com.fengjr.event.request.CreditAssignExpectedRequest;
import com.fengjr.event.request.CreditAssignSendMobileCaptchaRequest;
import com.fengjr.event.request.FavoriteCountRequest;
import com.fengjr.event.request.FeedbackRequest;
import com.fengjr.event.request.FundAccountRequest;
import com.fengjr.event.request.FundRecordsRequest;
import com.fengjr.event.request.FundRequest;
import com.fengjr.event.request.IsFavoriteProjectRequest;
import com.fengjr.event.request.IsLikeProjectRequest;
import com.fengjr.event.request.LikeCountRequest;
import com.fengjr.event.request.LoanDetailNewRequest;
import com.fengjr.event.request.LoanDetailRequest;
import com.fengjr.event.request.LoanInvestsRequest;
import com.fengjr.event.request.LoanRequest;
import com.fengjr.event.request.LoanUserRequest;
import com.fengjr.event.request.LoansFilterRequest;
import com.fengjr.event.request.LoansRequest;
import com.fengjr.event.request.LoansSummaryRequest;
import com.fengjr.event.request.LoginRequest;
import com.fengjr.event.request.MarkAllRequest;
import com.fengjr.event.request.MarkFavoriteRequest;
import com.fengjr.event.request.MarkLikeRequest;
import com.fengjr.event.request.MediaNewsRequest;
import com.fengjr.event.request.MyInvestRecordAssignedAlreadyRequest;
import com.fengjr.event.request.MyInvestRecordHoldRequest;
import com.fengjr.event.request.MyInvestsRequest;
import com.fengjr.event.request.OrderDetailRequest;
import com.fengjr.event.request.PaymentInfoRequest;
import com.fengjr.event.request.ProjectFavoritesRequest;
import com.fengjr.event.request.ProjectInvestInfosRequest;
import com.fengjr.event.request.ProjectInvestsRequest;
import com.fengjr.event.request.ProjectListRequest;
import com.fengjr.event.request.ProjectListWithOrdinalRequest;
import com.fengjr.event.request.ProjectRequest;
import com.fengjr.event.request.ProjectRewardsRequest;
import com.fengjr.event.request.ProjectTenderNoPwdRequest;
import com.fengjr.event.request.ProjectUpaymentRequest;
import com.fengjr.event.request.ProjectsRequest;
import com.fengjr.event.request.ProjectsSummaryRequest;
import com.fengjr.event.request.ProofsRequest;
import com.fengjr.event.request.PublicKeyRequest;
import com.fengjr.event.request.PublicationRequest;
import com.fengjr.event.request.ReadRewardContractRequest;
import com.fengjr.event.request.RegisterRequest;
import com.fengjr.event.request.RepaymentPlanCreditAssignRequest;
import com.fengjr.event.request.RepaymentPlanRequest;
import com.fengjr.event.request.ReturnMoneyQueryRequest;
import com.fengjr.event.request.RewardConfirmRequest;
import com.fengjr.event.request.RewardRelateRequest;
import com.fengjr.event.request.ShippingAddressRequest;
import com.fengjr.event.request.SmsCaptchaRequest;
import com.fengjr.event.request.StatisticsRequest;
import com.fengjr.event.request.TenderNoPwdRequest;
import com.fengjr.event.request.TransferBuyRequest;
import com.fengjr.event.request.TransferExceptRequest;
import com.fengjr.event.request.TransferLoanDetailRequest;
import com.fengjr.event.request.TransferLoanRequest;
import com.fengjr.event.request.TransferRepayRequest;
import com.fengjr.event.request.UnmarkFavoriteRequest;
import com.fengjr.event.request.UnmarkLikeRequest;
import com.fengjr.event.request.UpaymentAgreementRequest;
import com.fengjr.event.request.UpaymentBindAgreementRequest;
import com.fengjr.event.request.UpaymentRegisterRequest;
import com.fengjr.event.request.UpaymentRequest;
import com.fengjr.event.request.VersionRequest;
import com.fengjr.event.request.ViewInvestContractCreditAssignAlreadyRequest;
import com.fengjr.event.request.ViewInvestContractCreditAssignRequest;
import com.fengjr.event.request.ViewInvestContractRequest;
import com.fengjr.event.request.ViewLoanTemplateRequest;
import com.fengjr.event.request.WebNewNotificationsRequest;
import com.fengjr.event.request.WebNotificationsRequest;
import com.fengjr.event.response.ApplyExperienceResponse;
import com.fengjr.event.response.AuthenticatesResponse;
import com.fengjr.event.response.BannerListResponse;
import com.fengjr.event.response.BindCardResponse;
import com.fengjr.event.response.CheckLoginNameResponse;
import com.fengjr.event.response.CorporationResponse;
import com.fengjr.event.response.CreateCreditAssignResponse;
import com.fengjr.event.response.CreditAssignExpectedResponse;
import com.fengjr.event.response.CreditAssignSendMobileCaptchaResponse;
import com.fengjr.event.response.FavoriteCountResponse;
import com.fengjr.event.response.FeedbackResponse;
import com.fengjr.event.response.FundAccountResponse;
import com.fengjr.event.response.FundRecordsResponse;
import com.fengjr.event.response.FundResponse;
import com.fengjr.event.response.IsFavoriteProjectResponse;
import com.fengjr.event.response.IsLikeProjectResponse;
import com.fengjr.event.response.LikeCountResponse;
import com.fengjr.event.response.LoanDetailNewResponse;
import com.fengjr.event.response.LoanDetailResponse;
import com.fengjr.event.response.LoanInvestsResponse;
import com.fengjr.event.response.LoanResponse;
import com.fengjr.event.response.LoanUserResponse;
import com.fengjr.event.response.LoansFilterResponse;
import com.fengjr.event.response.LoansResponse;
import com.fengjr.event.response.LoansSummaryResponse;
import com.fengjr.event.response.LoginResponse;
import com.fengjr.event.response.MarkAllResponse;
import com.fengjr.event.response.MarkFavoriteResponse;
import com.fengjr.event.response.MarkLikeResponse;
import com.fengjr.event.response.MediaNewsResponse;
import com.fengjr.event.response.MyInvestRecordAssignedAlreadyResponse;
import com.fengjr.event.response.MyInvestRecordHoldResponse;
import com.fengjr.event.response.MyInvestsResponse;
import com.fengjr.event.response.OrderDetailResponse;
import com.fengjr.event.response.PaymentInfoResponse;
import com.fengjr.event.response.ProjectFavoritesResponse;
import com.fengjr.event.response.ProjectInvestInfosResponse;
import com.fengjr.event.response.ProjectInvestsResponse;
import com.fengjr.event.response.ProjectListResponse;
import com.fengjr.event.response.ProjectListWithOrdinalResponse;
import com.fengjr.event.response.ProjectResponse;
import com.fengjr.event.response.ProjectRewardsResponse;
import com.fengjr.event.response.ProjectTenderNoPwdResponse;
import com.fengjr.event.response.ProjectUpaymentResponse;
import com.fengjr.event.response.ProjectsResponse;
import com.fengjr.event.response.ProjectsSummaryResponse;
import com.fengjr.event.response.ProofsResponse;
import com.fengjr.event.response.PublicKeyResponse;
import com.fengjr.event.response.PublicationsResponse;
import com.fengjr.event.response.ReadRewardContractResponse;
import com.fengjr.event.response.RegisterResponse;
import com.fengjr.event.response.RepaymentPlanCreditAssignResponse;
import com.fengjr.event.response.RepaymentPlanResponse;
import com.fengjr.event.response.ReturnMoneyQueryRespone;
import com.fengjr.event.response.RewardConfirmResponse;
import com.fengjr.event.response.RewardRelateResponse;
import com.fengjr.event.response.ShippingAddressResponse;
import com.fengjr.event.response.SmsCaptchaResponse;
import com.fengjr.event.response.StatisticsResponse;
import com.fengjr.event.response.TenderNoPwdResponse;
import com.fengjr.event.response.TransferBuyResponse;
import com.fengjr.event.response.TransferExceptResponse;
import com.fengjr.event.response.TransferLoanDetailResponse;
import com.fengjr.event.response.TransferLoanResponse;
import com.fengjr.event.response.TransferRepayResponse;
import com.fengjr.event.response.UnmarkFavoriteResponse;
import com.fengjr.event.response.UnmarkLikeResponse;
import com.fengjr.event.response.UpaymentAgreementResponse;
import com.fengjr.event.response.UpaymentBindAgreementResponse;
import com.fengjr.event.response.UpaymentRegisterResponse;
import com.fengjr.event.response.UpaymentResponse;
import com.fengjr.event.response.VersionResponse;
import com.fengjr.event.response.ViewInvestContractCreditAssignAlreadyResponse;
import com.fengjr.event.response.ViewInvestContractCreditAssignResponse;
import com.fengjr.event.response.ViewInvestContractResponse;
import com.fengjr.event.response.ViewLoanTemplateResponse;
import com.fengjr.event.response.WebNewNotificationsResponse;
import com.fengjr.event.response.WebNotificationsResponse;
import com.fengjr.model.Agreement;
import com.fengjr.model.AllProjectsItemWithOrdinal;
import com.fengjr.model.ApiError;
import com.fengjr.model.ApiError_;
import com.fengjr.model.ApiResult;
import com.fengjr.model.Banner;
import com.fengjr.model.Claims;
import com.fengjr.model.CorporationExt;
import com.fengjr.model.CreditAssignExpectedResult;
import com.fengjr.model.FundAccount;
import com.fengjr.model.FundRecords;
import com.fengjr.model.FundingInvesetExts;
import com.fengjr.model.FundingInvestInfoExt;
import com.fengjr.model.FundingProjectDetail;
import com.fengjr.model.FundingProjectExt;
import com.fengjr.model.FundingProjects;
import com.fengjr.model.FundingReward;
import com.fengjr.model.Invest;
import com.fengjr.model.Invests;
import com.fengjr.model.Loan;
import com.fengjr.model.LoanDetail;
import com.fengjr.model.LoanDetailNewData;
import com.fengjr.model.Payment;
import com.fengjr.model.ProjectFavoritesExt;
import com.fengjr.model.ProofExt;
import com.fengjr.model.RegisterExt;
import com.fengjr.model.RepaymentPlan;
import com.fengjr.model.ReturnMoneyDayItem;
import com.fengjr.model.TenderPrepare;
import com.fengjr.model.TransferBuyInfo;
import com.fengjr.model.TransferExpect;
import com.fengjr.model.TransferLoanDetail;
import com.fengjr.model.TransferLoanList;
import com.fengjr.model.TransferRepayInfo;
import com.fengjr.model.UserAuthenticate;
import com.fengjr.model.UserDetail;
import com.fengjr.model.UserFund;
import com.fengjr.model.UserLoginExt;
import com.fengjr.model.UserStatistics;
import com.fengjr.model.Version;
import com.fengjr.model.WebNotifications;
import com.fengjr.util.FengjrFileUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class REST {

	public static final String TAG = "Remote";

	public RestTemplate restTemplate;

	public ClientHttpRequestFactory factory;

	public REST() {
		initRestTemplate();
	}

	void initRestTemplate() {
		// Create a new RestTemplate instance
		restTemplate = new RestTemplate();

		// Add the String message converter
		restTemplate.getMessageConverters().add(
				new StringHttpMessageConverter());
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		factory = restTemplate.getRequestFactory();
		// List<ClientHttpRequestInterceptor> interceptors = new
		// ArrayList<ClientHttpRequestInterceptor>();
		// interceptors.add(new HttpRequestInterceptor());
		// restTemplate.setInterceptors(interceptors);
		restTemplate
				.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	}

	public LoginResponse response(LoginRequest request) {
		ApiResult apiResult = new ApiResult();

		try {
			ResponseEntity<String> response = restTemplate.exchange(
					request.api, HttpMethod.POST,
					get(request.ext, request.request), String.class);
			HttpStatus status = response.getStatusCode();
			String res = toUtf8(response.getBody(), true);

			if (BuildConfig.DEBUG && !TextUtils.isEmpty(res)) {
				Log.i(TAG, res);
			}

			if (status == HttpStatus.BAD_REQUEST) {
				apiResult.error.add(getErrorMsg(res));
			} else if (status == HttpStatus.FORBIDDEN) {
				if (invalidToken(res)) {
					ApiError error = new ApiError();
					error.message = "token失效，请重新登录";
					apiResult.error.add(getErrorMsg(res));
				} else {
					apiResult.error.add(getErrorMsg(res));
				}

			} else if (status != HttpStatus.OK) {
				apiResult.error.add(getErrorMsg(res));
				apiResult.success = false;
			} else {
				apiResult.data = new JsonParser().parse(res);
				apiResult.success = true;
			}

		} catch (HttpStatusCodeException e) {
			apiResult.success = false;

			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				apiResult.add(e.getResponseBodyAsString());
			} else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				String error = e.getResponseBodyAsString();
				JsonObject obj = new JsonParser().parse(error)
						.getAsJsonObject();
				if (obj.has("error_description")) {
					obj = obj.get("error_description").getAsJsonObject();

					if (obj.has("failedAttempts")) {
						if (obj.has("result")
								&& !obj.get("result").getAsString()
										.equals("FAILED")) {
							String result = obj.get("result").getAsString();
							if (result.contentEquals("USER_DISABLED")) {
								apiResult.needToLogin(-2);
							}
						} else {
							apiResult.needToLogin(obj.get("failedAttempts")
									.getAsInt());
						}
					}
				}
			} else {
				String error = e.getResponseBodyAsString();
				// 区分加密失败服务器返回的消息
				// 目前 判断加密是否失败 通过服务器返回的errMsg为
				// 加密公钥与解密私钥不一致
				// "Cannot read property 'keyByteLength' of undefined"
				// 加密解密 padding mode 不一致 Cannot read property 'length' of null
				// 加密后的密码错误 Incorrect data or key

				if (!TextUtils.isEmpty(error)
						&& (error.contains("Cannot read property") || error
								.contains("Incorrect data or key"))) {
					ApiError apiError = new ApiError();
					// 加密错误 返回上层的错误改为一致 encrypt error
					apiError.message = "encrypt error";
					apiResult.error.add(apiError);
				} else {
					apiResult.copy(ApiResult.build());
				}
				// apiResult.copy(ApiResult.build());
			}
			Log.e(TAG, e.getResponseBodyAsString());
		} catch (ResourceAccessException rae) {
			if (isCertificatedError(rae.getMessage())) {
				apiResult.error_code = Response.ERROR_CERTIFICATE;
			} else {
				apiResult.error_code = Response.ERROR_UNKNOWN;
			}
			ApiError error = new ApiError();
			error.message = rae.getMessage();
			apiResult.error.add(error);
		} catch (Exception e) {
			apiResult.copy(ApiResult.build());
			e.printStackTrace();
		}

		if (apiResult.data != null && apiResult.success) {
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					UserLoginExt.class);
		} else {
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					ApiError_.class);
		}
		return new LoginResponse(apiResult);

	}

	public boolean isCertificatedError(String error) {
		if (error.contains("No peer certificate")
				&& error.contains("I/O error")) {
			return true;
		}
		return false;
	}

	public ProjectRewardsResponse response(ProjectRewardsRequest request) {
		ApiResult apiResult = new ApiResult();

		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<FundingReward>>() {
					}.getType());
		return new ProjectRewardsResponse(apiResult);
	}

	public RewardRelateResponse response(RewardRelateRequest request) {
		ApiResult apiResult = new ApiResult();

		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					TenderPrepare.class);
		return new RewardRelateResponse(apiResult);
	}

	public OrderDetailResponse response(OrderDetailRequest request) {
		ApiResult apiResult = new ApiResult();

		postForData(request, apiResult);

		return new OrderDetailResponse(apiResult);
	}

	public RegisterResponse response(RegisterRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);
		if (apiResult.data != null) {
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					RegisterExt.class);
		}
		return new RegisterResponse(apiResult);
	}

	public CheckLoginNameResponse response(CheckLoginNameRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new CheckLoginNameResponse(apiResult);
	}

	public SmsCaptchaResponse response(SmsCaptchaRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new SmsCaptchaResponse(apiResult);
	}

	public ShippingAddressResponse response(ShippingAddressRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);
		return new ShippingAddressResponse(apiResult);
	}

	public TenderNoPwdResponse response(TenderNoPwdRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		try {
			if (apiResult.data != null)
				apiResult = new Gson().fromJson((JsonElement) apiResult.data,
						ApiResult.class);
		} catch (Exception e) {
		}

		return new TenderNoPwdResponse(apiResult);
	}

	public ProjectTenderNoPwdResponse response(ProjectTenderNoPwdRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		try {
			if (apiResult.data != null)
				apiResult = new Gson().fromJson((JsonElement) apiResult.data,
						ApiResult.class);
		} catch (Exception e) {
		}

		return new ProjectTenderNoPwdResponse(apiResult);
	}

	public UpaymentBindAgreementResponse response(
			UpaymentBindAgreementRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null)
			try {
				apiResult = new Gson().fromJson((JsonElement) apiResult.data,
						ApiResult.class);
			} catch (Exception e) {

			}
		return new UpaymentBindAgreementResponse(apiResult);
	}

	public UpaymentAgreementResponse response(UpaymentAgreementRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			try {
				apiResult.data = new Gson().fromJson(
						(JsonElement) apiResult.data, Agreement.class);
			} catch (Exception e) {

			}
		}
		return new UpaymentAgreementResponse(apiResult);
	}

	public UpaymentRegisterResponse response(UpaymentRegisterRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null && !apiResult.hasError()) {
			try {
				apiResult.data = new Gson().fromJson(
						(JsonElement) apiResult.data, Payment.class);
			} catch (Exception e) {

			}
		} else {
			if (null != apiResult.data) {
				apiResult.data = null;
			}
		}

		return new UpaymentRegisterResponse(apiResult);
	}

	public PaymentInfoResponse response(PaymentInfoRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					Payment.class);
		return new PaymentInfoResponse(apiResult);
	}

	public LoansSummaryResponse response(LoansSummaryRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			apiResult.data = gson.fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Loan>>() {
					}.getType());
		}
		return new LoansSummaryResponse(apiResult, request);
	}

	public LoansResponse response(LoansRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Loan>>() {
					}.getType());
		return new LoansResponse(apiResult);
	}

	public ProjectsSummaryResponse response(ProjectsSummaryRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					FundingProjects.class);
		return new ProjectsSummaryResponse(apiResult);
	}

	public ProjectsResponse response(ProjectsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<FundingProjectExt>>() {
					}.getType());
		return new ProjectsResponse(apiResult);
	}

	public ProjectListResponse response(ProjectListRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<FundingProjectExt>>() {
					}.getType());
		return new ProjectListResponse(apiResult);
	}

	public MyInvestsResponse response(MyInvestsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					Invests.class);
		return new MyInvestsResponse(apiResult, request);
	}

	public ProofsResponse response(ProofsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<ProofExt>>() {
					}.getType());
		return new ProofsResponse(apiResult);
	}

	public ProjectListWithOrdinalResponse response(
			ProjectListWithOrdinalRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<AllProjectsItemWithOrdinal>>() {
					}.getType());
		return new ProjectListWithOrdinalResponse(apiResult);
	}

	public LoanResponse response(LoanRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					Loan.class);
		return new LoanResponse(apiResult);
	}

	public LoanDetailResponse response(LoanDetailRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					LoanDetail.class);
		return new LoanDetailResponse(apiResult);
	}

	public LoanDetailNewResponse response(LoanDetailNewRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson(apiResult.data.toString(),
					LoanDetailNewData.class);
		return new LoanDetailNewResponse(apiResult, request.mLoanid);
	}

	public FundAccountResponse response(FundAccountRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<FundAccount>>() {
					}.getType());
		return new FundAccountResponse(apiResult);
	}

	public AuthenticatesResponse response(AuthenticatesRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					UserAuthenticate.class);
		return new AuthenticatesResponse(apiResult);
	}

	public FundResponse response(FundRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					UserFund.class);
		return new FundResponse(apiResult);
	}

	public FundRecordsResponse response(FundRecordsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					FundRecords.class);
		return new FundRecordsResponse(apiResult);
	}

	public StatisticsResponse response(StatisticsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					UserStatistics.class);
		return new StatisticsResponse(apiResult);
	}

	public LoanInvestsResponse response(LoanInvestsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Invest>>() {
					}.getType());
		return new LoanInvestsResponse(apiResult, request.mLoanid);
	}

	public UpaymentResponse response(UpaymentRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null)
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		return new UpaymentResponse(apiResult);
	}

	public ProjectUpaymentResponse response(ProjectUpaymentRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null)
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		return new ProjectUpaymentResponse(apiResult);
	}

	public ProjectResponse response(ProjectRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					FundingProjectDetail.class);
		return new ProjectResponse(apiResult);
	}

	public BannerListResponse response(BannerListRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Banner>>() {
					}.getType());
		return new BannerListResponse(apiResult);
	}

	public PublicationsResponse response(PublicationRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Banner>>() {
					}.getType());
		return new PublicationsResponse(apiResult);
	}

	public MediaNewsResponse response(MediaNewsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Banner>>() {
					}.getType());
		return new MediaNewsResponse(apiResult);
	}

	public LoansFilterResponse response(LoansFilterRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {

			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<Loan>>() {
					}.getType());
		}
		return new LoansFilterResponse(apiResult, request);
	}

	public TransferLoanResponse response(TransferLoanRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {

			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<TransferLoanList>() {
					}.getType());
		}
		return new TransferLoanResponse(apiResult, request);
	}

	public TransferExceptResponse response(TransferExceptRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {

			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<TransferExpect>() {
					}.getType());
		}
		return new TransferExceptResponse(apiResult, request);
	}

	public TransferLoanDetailResponse response(TransferLoanDetailRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {

			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<TransferLoanDetail>() {
					}.getType());
		}
		return new TransferLoanDetailResponse(apiResult, request);
	}

	public TransferBuyResponse response(TransferBuyRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null) {

			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<TransferBuyInfo>() {
					}.getType());
		}
		return new TransferBuyResponse(apiResult, request);
	}

	public TransferRepayResponse response(TransferRepayRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {

			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<TransferRepayInfo>() {
					}.getType());
		}
		return new TransferRepayResponse(apiResult, request);
	}

	public MarkFavoriteResponse response(MarkFavoriteRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new MarkFavoriteResponse(apiResult);
	}

	public UnmarkFavoriteResponse response(UnmarkFavoriteRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new UnmarkFavoriteResponse(apiResult);
	}

	public FavoriteCountResponse response(FavoriteCountRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new FavoriteCountResponse(apiResult);
	}

	public IsFavoriteProjectResponse response(IsFavoriteProjectRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new IsFavoriteProjectResponse(apiResult);
	}

	public MarkLikeResponse response(MarkLikeRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new MarkLikeResponse(apiResult);
	}

	public UnmarkLikeResponse response(UnmarkLikeRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new UnmarkLikeResponse(apiResult);
	}

	public LikeCountResponse response(LikeCountRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new LikeCountResponse(apiResult);
	}

	public IsLikeProjectResponse response(IsLikeProjectRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null) {
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		}
		return new IsLikeProjectResponse(apiResult);
	}

	public BindCardResponse response(BindCardRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null)
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		return new BindCardResponse(apiResult);
	}

	public LoanUserResponse response(LoanUserRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					UserDetail.class);
		return new LoanUserResponse(apiResult, request.mLoanid);
	}

	public CorporationResponse response(CorporationRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					CorporationExt.class);
		return new CorporationResponse(apiResult, request.mLoanid);
	}

	public VersionResponse response(VersionRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					Version.class);
		return new VersionResponse(apiResult);

		// try {
		// ResponseEntity<String> response = restTemplate
		// .exchange(request.api, HttpMethod.GET, get(request.ext),
		// String.class);
		// HttpStatus status = response.getStatusCode();
		// String res = toUtf8(response.getBody(), false);
		//
		// if (BuildConfig.DEBUG && !TextUtils.isEmpty(res)) {
		// Log.i(TAG, res);
		// }
		//
		// if (status == HttpStatus.OK) {
		// apiResult.data = new Gson().fromJson(res, Version.class);
		// return new VersionResponse(apiResult);
		// } else {
		// apiResult.error.add(getErrorMsg(res));
		// return new VersionResponse(apiResult);
		// }
		// } catch (Exception e) {
		// apiResult.error.add(getErrorMsg(""));
		// return new VersionResponse(apiResult);
		// }

	}

	public ProjectInvestInfosResponse response(ProjectInvestInfosRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					new TypeToken<List<FundingInvestInfoExt>>() {
					}.getType());
		return new ProjectInvestInfosResponse(apiResult);
	}

	public ProjectFavoritesResponse response(ProjectFavoritesRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					ProjectFavoritesExt.class);
		return new ProjectFavoritesResponse(apiResult);
	}

	public ProjectInvestsResponse response(ProjectInvestsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					FundingInvesetExts.class);
		return new ProjectInvestsResponse(apiResult);
	}

	public PublicKeyResponse response(PublicKeyRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		// if (apiResult.data != null){
		// apiResult = new Gson().fromJson(
		// (JsonElement) apiResult.data,
		// ApiResult.class);
		// }
		return new PublicKeyResponse(apiResult);
	}

	public FeedbackResponse response(FeedbackRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		return new FeedbackResponse(apiResult);
	}

	public RepaymentPlanResponse response(RepaymentPlanRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					RepaymentPlan.class);
		return new RepaymentPlanResponse(apiResult);
	}
	
	public RepaymentPlanCreditAssignResponse response(RepaymentPlanCreditAssignRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					RepaymentPlan.class);
		return new RepaymentPlanCreditAssignResponse(apiResult);
	}

	public ReturnMoneyQueryRespone response(ReturnMoneyQueryRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);

		// 回款查询接口返回的是一个JsonArray，而不是一个JsonObject,所以这里要做JsonArray和List的转换
		if (apiResult.data != null) {
			List<ReturnMoneyDayItem> lists = new ArrayList<ReturnMoneyDayItem>();
			JsonArray jArray = (JsonArray) apiResult.data;

			try {
				for (JsonElement obj : jArray) {
					lists.add(new Gson()
							.fromJson(obj, ReturnMoneyDayItem.class));
				}
				apiResult.data = lists;
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}

		}
		return new ReturnMoneyQueryRespone(apiResult);
	}

	public ViewLoanTemplateResponse response(ViewLoanTemplateRequest request) {
		ApiResult apiResult = new ApiResult();
		try {
			Log.d("pdf", "(ViewLoanTemplateResponse response),request.api: "
					+ request.api);

			URL url = new URL(request.api);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			int code = urlConnection.getResponseCode();
			Log.d("pdf", "(ViewLoanTemplateResponse response),code: " + code);

			if (200 == code) {
				String fileName = request.getFileId() + request.getFileExt();
				FengjrFileUtil.saveInputStreamToFile(fileName,
						urlConnection.getInputStream());
			} else {
				apiResult.add(new ApiError("资源不存在！"));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			apiResult.error.add(new ApiError(e.getMessage()));
		}

		// 因为在handleError里，判断apiResult.data为空会直接返回，造成不能打开文档，所以这里给apiResult.data赋一个值
		if (null == apiResult.data) {
			apiResult.data = new Object();
		}
		return new ViewLoanTemplateResponse(apiResult, request.getFileId());
	}

	public ReadRewardContractResponse response(ReadRewardContractRequest request) {

		ApiResult apiResult = new ApiResult();
		try {
			Log.d("pdf", "(ViewInvestContractResponse response),request.api: "
					+ request.api);

			URL url = new URL(request.api);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			urlConnection.setRequestProperty("Authorization",
					request.ext.token_type + " " + request.ext.access_token);
			int code = urlConnection.getResponseCode();
			Log.d("pdf", "(DownloadFileRequest request),code: " + code);

			if (200 == code) {
				String fileName = request.getFileId() + request.getFileExt();
				FengjrFileUtil.saveInputStreamToFile(fileName,
						urlConnection.getInputStream());
			} else {
				apiResult.add(new ApiError("资源不存在！"));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			apiResult.error.add(new ApiError(e.getMessage()));
		}

		// 因为在handleError里，判断apiResult.data为空会直接返回，造成不能打开文档，所以这里给apiResult.data赋一个值
		if (null == apiResult.data) {
			apiResult.data = new Object();
		}
		return new ReadRewardContractResponse(apiResult, request.getFileId());

	}

	public ViewInvestContractResponse response(ViewInvestContractRequest request) {

		ApiResult apiResult = new ApiResult();
		try {
			Log.d("pdf", "(ViewInvestContractResponse response),request.api: "
					+ request.api);

			URL url = new URL(request.api);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			urlConnection.setRequestProperty("Authorization",
					request.ext.token_type + " " + request.ext.access_token);
			int code = urlConnection.getResponseCode();
			Log.d("pdf", "(DownloadFileRequest request),code: " + code);

			if (200 == code) {
				String fileName = request.getFileName() + request.getFileExt();
				FengjrFileUtil.saveInputStreamToFile(fileName,
						urlConnection.getInputStream());
			} else {
				apiResult.add(new ApiError("资源不存在！"));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			apiResult.error.add(new ApiError(e.getMessage()));
		}

		// 因为在handleError里，判断apiResult.data为空会直接返回，造成不能打开文档，所以这里给apiResult.data赋一个值
		if (null == apiResult.data) {
			apiResult.data = new Object();
		}
		return new ViewInvestContractResponse(apiResult, request.getFileId(),request.getFileName());

	}
	
	/**
	 * 债券转让标的下载的是zip格式文件
	 * @param request
	 * @return
	 */
	public ViewInvestContractCreditAssignResponse response(ViewInvestContractCreditAssignRequest request) {

		ApiResult apiResult = new ApiResult();
		try {
			Log.d("zip", "(ViewInvestContractCreditAssignResponse response),request.api: "
					+ request.api);

			URL url = new URL(request.api);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			urlConnection.setRequestProperty("Authorization",
					request.ext.token_type + " " + request.ext.access_token);
			int code = urlConnection.getResponseCode();
			Log.d("zip", "(ViewInvestContractCreditAssignResponse request),code: " + code);

			if (200 == code) {
				String fileName = request.getFileName() + request.getFileExt();
				FengjrFileUtil.saveInputStreamToFile(fileName,
						urlConnection.getInputStream());
				FengjrFileUtil.unZip(FengjrFileUtil.getFengjrDownloadFileDir() + fileName, FengjrFileUtil.getFengjrDownloadFileDir() + request.getFileName());
				FengjrFileUtil.deleteFile(FengjrFileUtil.getFengjrDownloadFileDir() + fileName);
			} else {
				apiResult.add(new ApiError("资源不存在！"));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			apiResult.error.add(new ApiError(e.getMessage()));
		}

		// 因为在handleError里，判断apiResult.data为空会直接返回，造成不能打开文档，所以这里给apiResult.data赋一个值
		if (null == apiResult.data) {
			apiResult.data = new Object();
		}
		return new ViewInvestContractCreditAssignResponse(apiResult, request.getFileId(),request.getFileName());

	}
	
	/**
	 * 债券转让标的下载的是zip格式文件
	 * @param request
	 * @return
	 */
	public ViewInvestContractCreditAssignAlreadyResponse response(ViewInvestContractCreditAssignAlreadyRequest request) {

		ApiResult apiResult = new ApiResult();
		try {
			Log.d("zip", "(ViewInvestContractCreditAssignAlreadyResponse response),request.api: "
					+ request.api);

			URL url = new URL(request.api);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			urlConnection.setRequestProperty("Authorization",
					request.ext.token_type + " " + request.ext.access_token);
			int code = urlConnection.getResponseCode();
			Log.d("zip", "(ViewInvestContractCreditAssignResponse request),code: " + code);

			if (200 == code) {
				String fileName = request.getFileName() + request.getFileExt();
				FengjrFileUtil.saveInputStreamToFile(fileName,
						urlConnection.getInputStream());
				FengjrFileUtil.unZip(FengjrFileUtil.getFengjrDownloadFileDir() + fileName, FengjrFileUtil.getFengjrDownloadFileDir() + request.getFileName());
				FengjrFileUtil.deleteFile(FengjrFileUtil.getFengjrDownloadFileDir() + fileName);
			} else {
				apiResult.add(new ApiError("资源不存在！"));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			apiResult.error.add(new ApiError(e.getMessage()));
		}

		// 因为在handleError里，判断apiResult.data为空会直接返回，造成不能打开文档，所以这里给apiResult.data赋一个值
		if (null == apiResult.data) {
			apiResult.data = new Object();
		}
		return new ViewInvestContractCreditAssignAlreadyResponse(apiResult, request.getFileId(),request.getFileName());

	}

	/**
	 * 申请体验确认请求
	 * 
	 * @param request
	 * @return
	 */
	public ApplyExperienceResponse response(ApplyExperienceRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		return new ApplyExperienceResponse(apiResult);
	}

	public RewardConfirmResponse response(RewardConfirmRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					RewardConfirmResponse.class);
		return new RewardConfirmResponse(apiResult);
	}
	
	public MyInvestRecordHoldResponse response(MyInvestRecordHoldRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					Invests.class);
		return new MyInvestRecordHoldResponse(apiResult);
	}
	
	public MyInvestRecordAssignedAlreadyResponse response(MyInvestRecordAssignedAlreadyRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					Claims.class);
		return new MyInvestRecordAssignedAlreadyResponse(apiResult);
	}

	/**
	 * 债权转让 预期 数据
	 * 
	 * @param request
	 * @return
	 */
	public CreditAssignExpectedResponse response(
			CreditAssignExpectedRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					CreditAssignExpectedResult.class);
		return new CreditAssignExpectedResponse(apiResult);
	}

	/**
	 * 获取债权转让 验证码
	 * 
	 * @param request
	 * @return
	 */
	public CreditAssignSendMobileCaptchaResponse response(
			CreditAssignSendMobileCaptchaRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null)
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					CreditAssignSendMobileCaptchaResponse.class);
		return new CreditAssignSendMobileCaptchaResponse(apiResult);
	}

	/**
	 * 债权转让 确认请求
	 * 
	 * @param request
	 * @return
	 */
	public CreateCreditAssignResponse response(CreateCreditAssignRequest request) {
		ApiResult apiResult = new ApiResult();
		postForData(request, apiResult);
		if (apiResult.data != null)
			apiResult = new Gson().fromJson((JsonElement) apiResult.data,
					ApiResult.class);
		return new CreateCreditAssignResponse(apiResult);
	}
	
	/**
	 * 站内信消息
	 * @param request
	 * @return
	 */
	public WebNotificationsResponse response(WebNotificationsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null) {
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					WebNotifications.class);
		}
		return new WebNotificationsResponse(apiResult);
	}	
	
	/**
	 * 站内信消息
	 * @param request
	 * @return
	 */
	public WebNewNotificationsResponse response(WebNewNotificationsRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		if (apiResult.data != null) {
			apiResult.data = new Gson().fromJson((JsonElement) apiResult.data,
					WebNotifications.class);
		}
		return new WebNewNotificationsResponse(apiResult);
	}	
	
	/**
	 * 标记所有消息为已读
	 * @param request
	 * @param apiResult
	 * @return
	 */
	public MarkAllResponse response(MarkAllRequest request) {
		ApiResult apiResult = new ApiResult();
		getForData(request, apiResult);
		return new MarkAllResponse(apiResult);
	}	
	
	
	boolean postForData(Request request, ApiResult apiResult) {
		return postForData(request, apiResult, false);
	}

	boolean postForData(Request request, ApiResult apiResult, boolean decode) {

		try {
			ResponseEntity<String> response = restTemplate.exchange(
					request.api, HttpMethod.POST,
					get(request.ext, request.request), String.class);
			HttpStatus status = response.getStatusCode();
			String res = toUtf8(response.getBody(), decode);

			if (BuildConfig.DEBUG && !TextUtils.isEmpty(res)) {
				Log.i(TAG, res);
			}

			if (status == HttpStatus.BAD_REQUEST) {
				apiResult.error.add(getErrorMsg(res));
				return false;
			} else if (status == HttpStatus.FORBIDDEN) {
				if (invalidToken(res)) {
					ApiError error = new ApiError();
					error.message = "token失效，请重新登录";
					apiResult.error.add(getErrorMsg(res));
				} else {
					apiResult.error.add(getErrorMsg(res));
				}

				return false;
			} else if (status != HttpStatus.OK) {
				apiResult.error.add(getErrorMsg(res));
				return false;
			} else {
				apiResult.data = new JsonParser().parse(res);
				return true;
			}

		} catch (HttpStatusCodeException e) {

			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				apiResult.add(e.getResponseBodyAsString());
			} else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				apiResult.copy(new Gson().fromJson(e.getResponseBodyAsString(),
						ApiResult.class));
			} else if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				apiResult.needToLogin(-1);
				apiResult.error_code = Response.ERROR_UNAUTHORIZED;
			} else {
				// apiResult.copy(ApiResult.build());
				String error = e.getResponseBodyAsString();
				// 区分加密失败服务器返回的消息
				// 目前 判断加密是否失败 通过服务器返回的errMsg为
				// 加密公钥与解密私钥不一致
				// "Cannot read property 'keyByteLength' of undefined"
				// 加密解密 padding mode 不一致 Cannot read property 'length' of null
				// 加密后的密码错误 Incorrect data or key
				if (!TextUtils.isEmpty(error)
						&& (error.contains("Cannot read property") || error
								.contains("Incorrect data or key"))) {
					apiResult.error.add(getErrorMsg(error));
				} else {
					apiResult.copy(ApiResult.build());
				}
			}
			Log.e(TAG, e.getResponseBodyAsString());
			return false;
		} catch (ResourceAccessException rae) {
			if (isCertificatedError(rae.getMessage())) {
				apiResult.error_code = Response.ERROR_CERTIFICATE;
			} else {
				apiResult.error_code = Response.ERROR_UNKNOWN;
			}
			ApiError error = new ApiError();
			error.message = rae.getMessage();
			apiResult.error.add(error);
			return false;
		} catch (Exception e) {
			apiResult.copy(ApiResult.build());
			e.printStackTrace();
			return false;
		}
	}

	boolean getForData(Request request, ApiResult apiResult) {
		return getForData(request, apiResult, false);
	}

	boolean getForData(Request request, ApiResult apiResult, boolean decode) {

		try {
			Iterator<Entry<String, List<String>>> iter = request.request
					.entrySet().iterator();
			StringBuffer params = new StringBuffer();

			for (int i = 0; iter.hasNext(); i++) {
				Entry<String, List<String>> entry = iter.next();
				String key = entry.getKey();
				List<String> val = entry.getValue();
				params.append(i == 0 ? "?" : "&").append(key).append("=")
						.append(val.get(0));
			}

			ResponseEntity<String> response = restTemplate.exchange(request.api
					+ params, HttpMethod.GET, get(request.ext), String.class);
			HttpStatus status = response.getStatusCode();
			String res = toUtf8(response.getBody(), decode);

			if (BuildConfig.DEBUG && !TextUtils.isEmpty(res)) {
				Log.i(TAG, res);
			}

			if (status == HttpStatus.BAD_REQUEST) {
				apiResult.error.add(getErrorMsg(res));
				apiResult.error_code = Response.ERROR_BAD_REQUEST;
				return false;
			} else if (status == HttpStatus.FORBIDDEN) {
				if (invalidToken(res)) {
					ApiError error = new ApiError();
					error.message = "token失效，请重新登录";
					apiResult.error.add(getErrorMsg(res));
					apiResult.error_code = Response.ERROR_FORBIDDEN;
				} else {
					apiResult.error.add(getErrorMsg(res));
					apiResult.error_code = Response.ERROR_UNKNOWN;
				}

				return false;
			} else if (status == HttpStatus.NO_CONTENT) {
				apiResult.error_code = Response.ERROR_NOCONTENT;
				return true;
			} else if (status != HttpStatus.OK) {
				apiResult.error.add(getErrorMsg(res));
				apiResult.error_code = Response.ERROR_UNKNOWN;
				return false;
			} else {
				if (TextUtils.isEmpty(res)) {
					apiResult.data = null;
				} else {
					apiResult.data = new JsonParser().parse(res);
				}
				return true;
			}

		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				apiResult.add(e.getResponseBodyAsString());
				apiResult.error_code = Response.ERROR_NOT_FOUND;
			} else if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				apiResult.needToLogin(-1);
				apiResult.error_code = Response.ERROR_UNAUTHORIZED;
			} else {
				apiResult.copy(ApiResult.build());
				apiResult.error_code = Response.ERROR_UNKNOWN;
			}
			Log.e(TAG, e.getResponseBodyAsString());
			return false;
		} catch (ResourceAccessException rae) {
			if (isCertificatedError(rae.getMessage())) {
				apiResult.error_code = Response.ERROR_CERTIFICATE;
			} else {
				apiResult.error_code = Response.ERROR_UNKNOWN;
			}
			ApiError error = new ApiError();
			error.message = rae.getMessage();
			apiResult.error.add(error);
			return false;
		} catch (Exception e) {
			apiResult.copy(ApiResult.build());
			e.printStackTrace();
			apiResult.error_code = Response.ERROR_UNKNOWN;
			return false;
		}
	}

	/**
	 * { error: "access_denied", error_description: "invalid token" }
	 */

	boolean invalidToken(String plain) {
		JsonObject jsonObject = new JsonParser().parse(plain).getAsJsonObject();

		if (jsonObject.has("error_description")) {
			String error = jsonObject.get("error_description").getAsString();

			if (error.contentEquals("invalid token")) {
				return true;
			} else if (error.contentEquals("access token is required")) {
				return true;
			}
		}
		return false;
	}

	HttpEntity<?> get(UserLoginExt ext,
			LinkedMultiValueMap<String, String> values) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		if (ext == null) {
			return new HttpEntity<MultiValueMap<String, String>>(values,
					headers);
		}

		headers.add("Authorization", ext.token_type + " " + ext.access_token);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
				values, headers);
		// HttpEntity<?> request = new HttpEntity<Object>(headers);
		return request;
	}

	HttpEntity<?> get(UserLoginExt ext) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		if (ext == null) {
			return new HttpEntity<Object>(headers);
		}

		headers.add("Authorization", ext.token_type + " " + ext.access_token);
		HttpEntity<?> request = new HttpEntity<Object>(headers);
		return request;
	}

	boolean get(Request event, ApiResult result) {
		Iterator<Entry<String, List<String>>> iter = event.request.entrySet()
				.iterator();
		StringBuffer params = new StringBuffer();

		for (int i = 0; iter.hasNext(); i++) {
			Entry<String, List<String>> entry = iter.next();
			String key = entry.getKey();
			List<String> val = entry.getValue();
			params.append(i == 0 ? "?" : "&").append(key).append("=")
					.append(val.get(0));
		}

		ResponseEntity<String> response = restTemplate.exchange(event.api
				+ params, HttpMethod.GET, get(event.ext, event.request),
				String.class);
		// response = restTemplate.getForEntity(event.api + params,
		// String.class);

		HttpStatus status = response.getStatusCode();
		String res = toUtf8(response.getBody(), false);
		if (status == HttpStatus.BAD_REQUEST) {
			result.error.add(getErrorMsg(res));
			return false;
		} else if (status != HttpStatus.OK) {
			result.error.add(getErrorMsg(res));
			return false;
		} else {
			result.copy(new Gson().fromJson(res, ApiResult.class));
			// result.data = new
			// JsonParser().parse(toUtf8(response.getBody()));
			return true;
		}
	}

	boolean post(Request event, ApiResult result) {
		ResponseEntity<String> response = restTemplate.exchange(event.api,
				HttpMethod.POST, get(event.ext, event.request), String.class);
		// response = restTemplate.postForEntity(event.api,
		// event.request, String.class);
		// restTemplate.exchange(event.api, HttpMethod.POST, null,
		// String.class, event.request);
		HttpStatus status = response.getStatusCode();
		String res = toUtf8(response.getBody(), false);
		if (status == HttpStatus.BAD_REQUEST) {
			result.error.add(getErrorMsg(res));
			return false;
		} else if (status != HttpStatus.OK) {
			result.error.add(getErrorMsg(res));
			return false;
		} else {
			result.copy(new Gson().fromJson(res, ApiResult.class));
			// result.data = new
			// JsonParser().parse(toUtf8(response.getBody()));
			return true;
		}
	}

	ApiError getErrorMsg(String plain) {
		String default_ = "网络连接错误，请检查网络连接";
		ApiError error = new ApiError();
		error.message = default_;
		if (TextUtils.isEmpty(plain)) {
			return error;
		} else {
			try {
				ApiError_ e = new Gson().fromJson(plain, ApiError_.class);
				if (e == null || TextUtils.isEmpty(e.error_description)) {
					return error;
				} else {
					error.message = e.error_description;
					return error;
				}
			} catch (Exception e) {
				return error;
			}
		}
	}

	String toUtf8(String src, boolean decode) {
		if (!decode)
			return src;

		if (TextUtils.isEmpty(src))
			return "";
		try {
			String result = new String(src.getBytes("ISO-8859-1"), "UTF-8");
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			info("rest response:" + e.getMessage());
		}
		return null;
	}

	void debug(String msg) {
		if (TextUtils.isEmpty(msg)) {
			return;
		}

		Log.d(TAG, msg);
	}

	void info(String msg) {
		if (TextUtils.isEmpty(msg))
			return;
		Log.i(TAG, msg);
	}

}
