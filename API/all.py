#! /usr/bin/python
# -*- coding:utf-8 -*-

import requests, json

"""检查用户名是否可注册"""
host = "https://beta.fengjr.com"
parameterslist = [{'loginName':''},{'loginName':'1'},{'loginName':'12'},{'loginName':'123456789012345'},{'loginName':'a;flma;fm;'},{'loginName':'laklknglklf'},{'loginName':'nick'},{'loginName':'lkanflknlgknlanfjahkjdfkjjhkjhkjasdkfnamnfakj'}]
login_params = {'client_id':'bddc1dbb-0fe9-44ef-a3dc-6bdce55bd95e','client_secret':'118b58a26b5759bc68db33f196430d567ec4fd03e38a105cf8e6c8b75964a950','grant_type':'password','username':'nick','password':'123456'}

print "-" * 100
print "本次测试访问域名为beta.fengjr.com"
print "-" * 100
# 检查用户名是否可注册	https://beta.fengjr.com/api/v2/register/check_login_name
def check_login_name(host,params):
	uri = "/api/v2/register/check_login_nam"
	url = host + uri
	r = requests.post(url,params)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content == data_checkloginname:
			print " Pass | checkloginname"
		else:
			print " Fales | checkloginname"
	else:
		print r.status_code,r.text


# 注册				https://beta.fengjr.com/api/v2/register
def register(host,params):
	uri = "/api/v2/register"
	url = host + uri
	r = requests.post(url,params)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content == data_register:
			print " Pass | register"
		else:
			print " Fales | register"
	else:
		print r.status_code,r.text

# 登录				https://beta.fengjr.com/api/v2/token
def token(host):
	uri = "/api/v2/token"
	url = host + uri
	r = requests.post(url,login_params)
	if r.status_code == 200:
		content = json.loads(r.content)
		token = content["access_token"]
		if token:
			return token
		else:
			print "False | 获取token失败."
	else:
		print r.status_code, r.content


# header
def header(token):
	header = {"Authorization":"Bearer " + str(token)}
	return header

# 个人资金信息		https://beta.fengjr.com/api/v2/user/MYSELF/userfund
key_userfund = [u'depositAmount', u'availableAmount', u'userId', u'rechargeAmount', u'frozenAmount', u'transferAmount', u'dueInAmount', u'withdrawAmount', u'dueOutAmount']
def userfund(host):
	uri = "/api/v2/user/MYSELF/userfund"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url,headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		key = []
		for i in content:
			key.append(i)
		if key == key_userfund:
			print " Pass | 个人资金信息"
		else:
			print " False | 个人资金信息"
	else:
		print r.status_code, r.content
userfund(host)

# 协议状态			https://beta.fengjr.com/api/v2/user/MYSELF/agreement
def agreement(host):
	uri = "/api/v2/user/MYSELF/agreement"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url,headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["userId"]:
			print " Pass | 协议状态"
		else:
			print " False | 协议状态"
	else:
		print r.status_code, r.content
agreement(host)

# 第三方托管庄户信息	https://beta.fengjr.com/api/v2/user/MYSELF/payment
def payment(host):
	uri = "/api/v2/user/MYSELF/payment"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["userId"]:
			print " Pass | 第三方托管信息"
		else:
			print " False | 第三方托管信息"
	else:
		print r.status_code, r.content
payment(host)

# 个人投资统计		https://beta.fengjr.com/api/v2/user/MYSELF/statistics
def statistics(host):
	uri = "/api/v2/user/MYSELF/statistics"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["invest"]["investStatistics"]["userId"]:
			print " Pass | 个人资金统计"
		else:
			print " False | 个人资金统计,userId is null"
	else:
		print r.status_code, r.content
statistics(host)


# 个人投资记录		https://beta.fengjr.com/api/v2/user/MYSELF/invests?pageSize=10&page=1
def my_invest_record(host):
	uri = "/api/v2/user/MYSELF/invests"
	url = host + uri
	headers = header(token(host))
	params = {"pageSize":"10","page":"1"}
	r = requests.get(url, headers = headers, params = params)
	if r.status_code == 200:
		content = json.loads(r.content)
		if int(content["totalSize"]) == 0:
			print " Pass | 投资记录 | 没有投资记录"
		else:
			print " Pass | 投资记录 | 有" + str(content["totalSize"]) + "条投资记录"
	else:
		print r.status_code, r.content
my_invest_record(host)


# 绑定银行卡信息		https://beta.fengjr.com/api/v2/user/MYSELF/fundaccounts
def fundaccounts(host):
	uri = "/api/v2/user/MYSELF/fundaccounts"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if len(content) > 0 and "userId" in content[0]:
			print " Pass | 已经绑定银行卡 "
		else:
			print " Pass | 还未绑定银行卡 "
	else:
		print r.status_code + "绑定银行卡信息" + r.content
fundaccounts(host)


# 资金流水			https://beta.fengjr.com/api/v2/user/MYSELF/funds?pageSize=10&page=1&type=ALL&allStatus=false&allOperation=true&startDate=1369843200000&endDate=1417000330205
def userfunds(host):
	uri = "/api/v2/user/MYSELF/funds"
	url = host + uri
	headers = header(token(host))
	params = {"pageSize":"10","page":"1","type":"ALL","allStatus":"false","allOperation":"true","startDate":"1369843200000","endDate":"1417000330205"}
	r = requests.get(url, headers = headers, params = params)
	if r.status_code == 200:
		content = json.loads(r.content)
		if len(content) == 2:
			print " Pass | 资金流水"
		else:
			print " False | 资金流水 "
	else:
		print r.status_code, r.content
userfunds(host)


# 支持的众筹			https://beta.fengjr.com/api/v2/crowdfundings/MYSELF/listInvestedProjects?pageSize=10&page=1
def invest_crowdfundings(host):
	uri = "/api/v2/user/MYSELF/listInvestedInfoProjects"
	url = host + uri
	headers = header(token(host))
	params = {"pageSize":"10","page":"1","status":"FROZEN","status":"FINISHED","status":"SETTLED","status":"CLEARED"}
	r = requests.get(url, headers = headers, params = params)
	if r.status_code == 200:
		content = json.loads(r.content)
		if "totalSize" in content:
			print " Pass | 支持的众筹"
		else:
			print " False | 支持的众筹"
	else:
		print r.status_code, r.content
invest_crowdfundings(host)


# 关注的众筹			https://beta.fengjr.com/api/v2/crowdfundings/MYSELF/listFavoritesByUser?pageSize=10&page=1
def favorite_crowdfundings(host):
	uri = "/api/v2/crowdfundings/MYSELF/listFavoritesByUser?pageSize=10&page=1"
	url = host + uri
	headers = header(token(host))
	params = {"pageSize":"10","page":"1"}
	r = requests.get(url, headers = headers, params = params)
	if r.status_code == 200:
		content = json.loads(r.content)
		if "totalSize" in content:
			print " Pass | 关注的众筹"
		else:
			print " False | 关注的众筹"
	else:
		print r.status_code, r.content
favorite_crowdfundings(host)


# 是否“赞”一个众筹	https://beta.fengjr.com/api/v2/user/MYSELF/isMyLikeProject/820799E8-F2FB-4127-BEC9-14CB9AE59294
def is_my_like_crowdfunding(host):
	uri = "/api/v2/user/MYSELF/isMyLikeProject/B6475E16-C897-4884-A145-7FB1C485B16E"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["data"] == False:
			print " Pass | 没有赞这个众筹"
		elif content["data"] == True:
			print " Pass | 赞了这个众筹"
		else:
			print " False | 请检查赞众筹项目接口"
	else:
		print r.status_code, r.content
is_my_like_crowdfunding(host)


# 是否“收藏”一个众筹	https://beta.fengjr.com/api/v2/crowdfunding/MYSELF/isFavoriteProject/820799E8-F2FB-4127-BEC9-14CB9AE59294
def is_my_favorite_crowdfunding(host):
	uri = "/api/v2/crowdfunding/MYSELF/isFavoriteProject/820799E8-F2FB-4127-BEC9-14CB9AE59294"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["data"] == False:
			print " Pass | 没有收藏这个众筹"
		elif content["data"] == True:
			print " Pass | 收藏了这个众筹"
		else:
			print " False | 请检查收藏众筹项目接口"
	else:
		print r.status_code, r.content
is_my_favorite_crowdfunding(host)


# “赞”一个众筹		https://beta.fengjr.com/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/markLike
def likecrowdfunding(host):
	uri = "/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/markLike"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["success"] == True:
			print " Pass | 赞了众筹项目"
		else:
			print " false | 请检查赞一个众筹项目接口"
	else:
		print r.status_code, r.content
likecrowdfunding(host)


# “收藏”一个众筹		https://beta.fengjr.com/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/markFavorite
def favoritecrowdfunding(host):
	uri = "/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/markFavorite"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["success"] == True:
			print " Pass | 收藏了众筹项目"
		else:
			print " False | 请检查收藏一个众筹项目接口"
	else:
		print r.status_code, r.content
favoritecrowdfunding(host)


# 取消“赞”一个众筹	https://beta.fengjr.com/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/unmarkLike
def unlikecrowdfunding(host):
	uri = "/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/unmarkLike"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["success"] == True:
			print " Pass | 成功取消赞一个众筹"
		else:
			print " False | 请检查取消赞众筹项目接口"
	else:
		print r.status_code, r.content
unlikecrowdfunding(host)


# 取消“收藏”一个众筹	https://beta.fengjr.com/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/unmarkFavorite
def unfavoritecrowdfunding(host):
	uri = "/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/user/MYSELF/unmarkFavorite"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["success"] == True:
			print " Pass | 成功取消收藏一个众筹项目"
		else:
			print " False | 请检查取消收藏众筹项目接口"
	else:
		print r.status_code, r.content
unfavoritecrowdfunding(host)


# 理理财借款人信息	https://beta.fengjr.com/api/v2/loan/845C8546-3D23-48A7-BBB2-391381A4A631/user
def borrower_info(host):
	uri = "/api/v2/loan/845C8546-3D23-48A7-BBB2-391381A4A631/user"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content.keys() == [u'statistics', u'avadar', u'userCredit', u'user', u'certificates', u'userFund', u'userInfo']:
			print " Pass | 借款人信息"
		else:
			print " False | 借款人信息"
	else:
		print " False | 借款人信息 |", r.status_code, r.content
borrower_info(host)


# 手机banner			https://beta.fengjr.com/api/v2/cms/mobileBanners 
def getbanners(host):
	uri = "/api/v2/cms/mobileBanners"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if len(content) > 0:
			print " Pass | Banners"
		else:
			print " False | Banner为空，请检查"
	else:
		print r.status_code, r.content
getbanners(host)


# 众筹列表			https://beta.fengjr.com/api/v2/crowdfundings?lastProjectId=0&pageSize=10&status=OPENED
params_crowdfundinglist = {"lastProjectId":"0", "pageSize":"10", "status":"OPENED"}
def crowdfundinglist(host):
	uri = "/api/v2/crowdfundings"
	url = host + uri
	r = requests.get(url,params = params_crowdfundinglist)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content :
			print " Pass | 众筹列表 | 获取列表成功"
		else:
			print " False | 众筹列表"
	else:
		print r.status_code, r.content
crowdfundinglist(host)


# 众筹赞的数量		https://beta.fengjr.com/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/likeCount
def likecount(host):
	uri = "/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/likeCount"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content:
			print " Pass | 众筹赞的数量 "
		else:
			print " False | 众筹赞的数量"
	else:
		print r.status_code, r.content
likecount(host)


# 众筹收藏的数量		https://beta.fengjr.com/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/favoriteCount
def favoritecount(host):
	uri = "/api/v2/crowdfunding/820799E8-F2FB-4127-BEC9-14CB9AE59294/favoriteCount"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content:
			print " Pass | 众筹收藏的数量"
		else:
			print " False | 众筹收藏的数量"
	else:
		print r.status_code, r.content
favoritecount(host)


# 众筹支持方式		https://beta.fengjr.com/api/v2/crowdfunding/2B5BA862-81DA-404A-9573-08F6208BA2E5/rewards
data_crowdfundingrewards = [{u'raiseNumber': 0, u'description': u'\u95e8\u7968+\u9001\u73b0\u573a\u8f6f\u996e\u4e00\u4e2a\uff0c\u95e8\u7968\u53ca\u5176\u4ed6\u5b9e\u7269\u56de\u62a5\uff0c\u5728\u6f14\u51fa\u5f53\u5929\u51ed\u652f\u6301\u8005\u59d3\u540d\u53ca\u624b\u673a\u53f7\u5728\u73b0\u573a\u9886\u53d6\uff0c\u82e5\u672a\u80fd\u5230\u573a\u8005\uff0c\u5b9e\u7269\u56de\u62a5\u7531\u53d1\u8d77\u65b9\u627f\u62c5\u7269\u6d41\u8d39\u7528\uff0c\u5feb\u9012\u7ed9\u652f\u6301\u8005\t', u'deliveryTime': u'2015.01.04', u'projectId': u'2B5BA862-81DA-404A-9573-08F6208BA2E5', u'deliveryDetail': u'0', u'leftNumber': 1000000, u'limitNumber': 1000000, u'amount': 50.0, u'hardLimit': False, u'id': u'51CC4618-3321-449D-B0FD-69B5DAEF6ADB', u'raiseAmount': None}, {u'raiseNumber': 0, u'description': u'\u95e8\u7968+\u9001\u73b0\u573a\u8f6f\u996e\u4e00\u4e2a+\u5955\u4e39\u4eb2\u7b14\u7b7e\u540dEP\uff0c\u95e8\u7968\u53ca\u5176\u4ed6\u5b9e\u7269\u56de\u62a5\uff0c\u5728\u6f14\u51fa\u5f53\u5929\u51ed\u652f\u6301\u8005\u59d3\u540d\u53ca\u624b\u673a\u53f7\u5728\u73b0\u573a\u9886\u53d6\uff0c\u82e5\u672a\u80fd\u5230\u573a\u8005\uff0c\u5b9e\u7269\u56de\u62a5\u7531\u53d1\u8d77\u65b9\u627f\u62c5\u7269\u6d41\u8d39\u7528\uff0c\u5feb\u9012\u7ed9\u652f\u6301\u8005\t', u'deliveryTime': u'2015.01.04', u'projectId': u'2B5BA862-81DA-404A-9573-08F6208BA2E5', u'deliveryDetail': u'0', u'leftNumber': 1000000, u'limitNumber': 1000000, u'amount': 80.0, u'hardLimit': False, u'id': u'D782BD3E-988A-4495-909F-08A3ED8709AC', u'raiseAmount': None}]
def crowdfundingrewards(host):
	uri = "/api/v2/crowdfunding/2B5BA862-81DA-404A-9573-08F6208BA2E5/rewards"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content == data_crowdfundingrewards:
			print " Pass | 众筹支持方式"
		else:
			print " False | 众筹支持方式"
	else:
		print " Error | 众筹支持方式 |", r.status_code, r.content
crowdfundingrewards(host)


# 众筹项目详情页		https://beta.fengjr.com/api/v2/crowdfunding/2B5BA862-81DA-404A-9573-08F6208BA2E5
data_crowdfundingdetail = {u'invests': [], u'projTags': [{u'alias': u'\u97f3\u4e50\u4f1a', u'realm': u'FUNDINGPROJECT', u'name': u'002', u'description': u'\u97f3\u4e50\u4f1a'}], u'rewards': [{u'raiseNumber': 0, u'description': u'\u95e8\u7968+\u9001\u73b0\u573a\u8f6f\u996e\u4e00\u4e2a\uff0c\u95e8\u7968\u53ca\u5176\u4ed6\u5b9e\u7269\u56de\u62a5\uff0c\u5728\u6f14\u51fa\u5f53\u5929\u51ed\u652f\u6301\u8005\u59d3\u540d\u53ca\u624b\u673a\u53f7\u5728\u73b0\u573a\u9886\u53d6\uff0c\u82e5\u672a\u80fd\u5230\u573a\u8005\uff0c\u5b9e\u7269\u56de\u62a5\u7531\u53d1\u8d77\u65b9\u627f\u62c5\u7269\u6d41\u8d39\u7528\uff0c\u5feb\u9012\u7ed9\u652f\u6301\u8005\t', u'deliveryTime': u'2015.01.04', u'projectId': u'2B5BA862-81DA-404A-9573-08F6208BA2E5', u'deliveryDetail': u'0', u'leftNumber': 1000000, u'limitNumber': 1000000, u'amount': 50.0, u'hardLimit': False, u'id': u'51CC4618-3321-449D-B0FD-69B5DAEF6ADB', u'raiseAmount': None}, {u'raiseNumber': 0, u'description': u'\u95e8\u7968+\u9001\u73b0\u573a\u8f6f\u996e\u4e00\u4e2a+\u5955\u4e39\u4eb2\u7b14\u7b7e\u540dEP\uff0c\u95e8\u7968\u53ca\u5176\u4ed6\u5b9e\u7269\u56de\u62a5\uff0c\u5728\u6f14\u51fa\u5f53\u5929\u51ed\u652f\u6301\u8005\u59d3\u540d\u53ca\u624b\u673a\u53f7\u5728\u73b0\u573a\u9886\u53d6\uff0c\u82e5\u672a\u80fd\u5230\u573a\u8005\uff0c\u5b9e\u7269\u56de\u62a5\u7531\u53d1\u8d77\u65b9\u627f\u62c5\u7269\u6d41\u8d39\u7528\uff0c\u5feb\u9012\u7ed9\u652f\u6301\u8005\t', u'deliveryTime': u'2015.01.04', u'projectId': u'2B5BA862-81DA-404A-9573-08F6208BA2E5', u'deliveryDetail': u'0', u'leftNumber': 1000000, u'limitNumber': 1000000, u'amount': 80.0, u'hardLimit': False, u'id': u'D782BD3E-988A-4495-909F-08A3ED8709AC', u'raiseAmount': None}], u'ext': {u'project': {u'raiseNumber': 0, u'userId': u'B9ACE729-A474-44C1-A7AC-37EBFB6A0493', u'loanAmont': 0.0, u'id': u'2B5BA862-81DA-404A-9573-08F6208BA2E5', u'category': u'FENG_CZ', u'blog': u'', u'openTime': 1417438980000, u'title': u'\u5955\u4e39\u4e2a\u4eba LiVE Sho', u'introduction': u'\u6211\u662f\u5955\u4e39\uff0c\u53ea\u60f3\u5531\u6b4c\u7ed9\u4f60\u542c', u'detail': u'', u'website': u'', u'location': u'\u5317\u4eac\u661f\u79d1', u'detailDescription': u'07\u5e74\u7b7e\u7ea6\u5531\u7247\u516c\u53f8\uff0c\u4e0e\u8521\u5065\u96c5\u3001\u82cf\u6253\u7eff\u540c\u95e8\uff0c\u5e76\u63a8\u51fa\u7b2c\u4e00\u5f20\u4e2a\u4eba\u4e13\u8f91\u300a\u5982\u679c\u574f\u300b\uff0c\u5728\u6f14\u827a\u5de5\u4f5c\u84b8\u84b8\u65e5\u4e0a\u65f6\uff0c\u56e0\u9ad8\u5bc6\u5ea6\u5de5\u4f5c\u5b89\u6392\u5bfc\u81f4\u4e2a\u4eba\u5065\u5eb7\u53d7\u635f\uff0c\u53ea\u80fd\u6cea\u522b\u5fc3\u7231\u7684\u821e\u53f0\uff0c\u4e03\u5e74\u540e\u4ee5\u524d\u79cd\u79cd\u65e9\u5df2\u7269\u662f\u4eba\u975e\uff0c\u5386\u7ecf\u591a\u5e74\u6c89\u6dc0\uff0c\u6211\u7684\u5fc3\u6001\u66f4\u52a0\u4ece\u5bb9', u'email': u'', u'raiseAmount': 0.0, u'status': u'OPENED', u'selfDescription': u'\u5955\u4e39\uff0c\u4e00\u540d\u6781\u5177\u4e2a\u4eba\u98ce\u683c\uff0c\u6df1\u53d7\u5927\u5bb6\u559c\u7231\u7684\u5185\u5730\u5973\u6b4c\u624b\u30022007\u5e74\u53d1\u884c\u9996\u5f20\u4e2a\u4eba\u4e13\u8f91\u300a\u5982\u679c\u574f\u300b\u3002\u5148\u540e\u7b7e\u7ea6\u4e8e\u4e9a\u795e\u97f3\u4e50\u3001\u5317\u4eac\u661f\u601d\u8def\u6587\u5316\u7b49\u516c\u53f8\u3002', u'noReward': False, u'timeOut': 720, u'finishTime': None, u'videoUrl': u'', u'goalAmount': 2000.0, u'mobile': u'', u'acknowledgement': u'', u'favorite': 2, u'loanAmount': 0.0, u'ordinal': None, u'qualification': u'', u'productId': None}, u'userName': u'mickeybricks', u'images': {u'bannerImage': [u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-0E431BA2E307479A89FFC90E5B39698D.jpg'], u'preImage': [], u'projectImage': [u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-1F69F3F0578842168C56E4DAB4A559A0.jpg', u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-4C63AECFABE3403B84068D86395B0A0E.jpg', u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-0F5B2194BE524E28AE8E47E28A1CDD5F.jpg', u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-ADCC937DC1D74E60A7E85690FC9433BA.jpg', u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-9F22B96DF60E4433BE116D5B24C27FFA.jpg'], u'mobileImage': [u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-8206532F972742F2870F13B42E86C860.jpg']}, u'tags': None}, u'tags': {u'totalSize': 5, u'results': [{u'alias': u'\u68a6\u60f3\u72ec\u5bb6', u'realm': u'FUNDINGPROJECT', u'name': u'001', u'description': u'\u68a6\u60f3\u72ec\u5bb6'}, {u'alias': u'\u97f3\u4e50\u4f1a', u'realm': u'FUNDINGPROJECT', u'name': u'002', u'description': u'\u97f3\u4e50\u4f1a'}, {u'alias': u'\u6b4c\u821e\u5267', u'realm': u'FUNDINGPROJECT', u'name': u'003', u'description': u'\u6b4c\u821e\u5267'}, {u'alias': u'\u8bdd\u5267', u'realm': u'FUNDINGPROJECT', u'name': u'004', u'description': u'\u8bdd\u5267'}, {u'alias': u'\u6f14\u5531\u4f1a', u'realm': u'FUNDINGPROJECT', u'name': u'005', u'description': u'\u6f14\u5531\u4f1a'}]}}
def crowdfundingdetail(host):
	uri = "/api/v2/crowdfunding/2B5BA862-81DA-404A-9573-08F6208BA2E5"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content == data_crowdfundingdetail:
			print " Pass | 众筹项目详情页"
		else:
			print " False | 众筹项目详情页"
	else:
		print " Error | 众筹项目详情页 |", r.status_code, r.content
crowdfundingdetail(host)


# 众筹tag			https://beta.fengjr.com/api/v2/crowdfundings/tags
data_crowdfundingtags = [{u'alias': u'\u68a6\u60f3\u72ec\u5bb6', u'realm': u'FUNDINGPROJECT', u'name': u'001', u'description': u''}, {u'alias': u'\u97f3\u4e50\u4f1a', u'realm': u'FUNDINGPROJECT', u'name': u'002', u'description': u''}, {u'alias': u'\u6b4c\u821e\u5267', u'realm': u'FUNDINGPROJECT', u'name': u'003', u'description': u''}, {u'alias': u'\u8bdd\u5267', u'realm': u'FUNDINGPROJECT', u'name': u'004', u'description': u''}, {u'alias': u'\u6f14\u5531\u4f1a', u'realm': u'FUNDINGPROJECT', u'name': u'005', u'description': u''}, {u'alias': u'\u7535\u5f71', u'realm': u'FUNDINGPROJECT', u'name': u'006', u'description': u''}, {u'alias': u'MV', u'realm': u'FUNDINGPROJECT', u'name': u'007', u'description': u''}, {u'alias': u'\u5531\u7247', u'realm': u'FUNDINGPROJECT', u'name': u'008', u'description': u''}, {u'alias': u'\u51fa\u7248', u'realm': u'FUNDINGPROJECT', u'name': u'009', u'description': u''}, {u'alias': u'\u6d3b\u52a8', u'realm': u'FUNDINGPROJECT', u'name': u'010', u'description': u''}, {u'alias': u'\u667a\u80fd\u4ea7\u54c1', u'realm': u'FUNDINGPROJECT', u'name': u'011', u'description': u''}, {u'alias': u'\u65f6\u88c5', u'realm': u'FUNDINGPROJECT', u'name': u'012', u'description': u''}, {u'alias': u'\u516c\u76ca', u'realm': u'FUNDINGPROJECT', u'name': u'013', u'description': u''}, {u'alias': u'\u66f2\u827a', u'realm': u'FUNDINGPROJECT', u'name': u'014', u'description': u''}, {u'alias': u'\u5176\u5b83', u'realm': u'FUNDINGPROJECT', u'name': u'015', u'description': u''}]
def crowdfundingtags(host):
	uri = "/api/v2/crowdfundings/tags"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content == data_crowdfundingtags:
			print " Pass | 众筹tag"
		else:
			print " False | 众筹tag"
	else:
		print r.status_code, r.content
crowdfundingtags(host)


# 理理财列表			https://beta.fengjr.com/api/v2/loans/filter?lastLoanId=0&purpose=FENG_CX&pageSize=10&status=SCHEDULED
def loansfilter(host):
	uri = "/api/v2/loans/filter?lastLoanId=0&purpose=FENG_CX&pageSize=10&status=SCHEDULED"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = r.content
		if content:
			print " Pass | 理理财列表"
		else:
			print " False | 理理财列表为空"
	else:
		print r.status_code, r.content
loansfilter(host)


# 理理财项目详情		/api/v2/loan/0293521B-706E-4AAF-B3C6-3632AFFDD941/detail
data_loandetail = {u'data': {u'corporation': {u'info': {u'registeredCapital': 1040000000.0, u'contactPhone': u'13552552316', u'description': u'\u6210\u7acb\u4e8e2000\u5e74\u7684\u5e7f\u4e1c\u94f6\u8fbe\u878d\u8d44\u62c5\u4fdd\u6295\u8d44\u96c6\u56e2\u6709\u9650\u516c\u53f8\u662f\u4e00\u5bb6\u5c06\u4fe1\u7528\u8bc4\u4ef7\u3001\u4fe1\u7528\u62c5\u4fdd\u548c\u4fe1\u7528\u7ba1\u7406\u76f8\u7ed3\u5408\u7684\u5927\u578b\u4e2d\u5c0f\u4f01\u4e1a\u878d\u8d44\u670d\u52a1\u673a\u6784\uff0c\u76ee\u524d\u96c6\u56e2\u6ce8\u518c\u8d44\u672c10.4\u4ebf\u5143\uff0c\u603b\u8d44\u4ea730\u4ebf\u5143\uff0c\u662f\u5e7f\u4e1c\u7701\u5185\u9996\u5bb6\u6ce8\u518c\u8d44\u672c\u8d85\u8fc710\u4ebf\u5143\u7684\u5546\u4e1a\u62c5\u4fdd\u516c\u53f8\u3002\u94f6\u8fbe\u62c5\u4fdd\u96c6\u56e2\u62e5\u6709\u7740\u826f\u597d\u7684\u80a1\u6743\u7ed3\u6784\u548c\u4f18\u79c0\u7684\u80a1\u4e1c\u80cc\u666f\uff0c\u5305\u62ec\u56fd\u9645\u77e5\u540d\u6295\u8d44\u57fa\u91d1\u8d5b\u5bcc\u4e9a\u6d32 \u3001\u56fd\u6709\u80a1\u4e1c\u5e7f\u4e1c\u7ca4\u8d22\u521b\u4e1a\u6295\u8d44\u6709\u9650\u516c\u53f8\u7b49\uff0c\u5f62\u6210\u4e86\u4ee5\u653f\u5e9c\u8d44\u91d1\u4e3a\u5f15\u5bfc\uff0c\u793e\u4f1a\u8d44\u672c\u4e3a\u4e3b\u4f53\uff0c\u5e02\u573a\u5316\u8fd0\u4f5c\uff0c\u80a1\u4efd\u5236\u5efa\u8bbe\u7684\u516c\u53f8\u6cbb\u7406\u7ed3\u6784\u3002 \u94f6\u8fbe\u62c5\u4fdd\u96c6\u56e2\u5df2\u4e0e\u56fd\u5185\u5916\u8fd130\u5bb6\u91d1\u878d\u673a\u6784\u5efa\u7acb\u4e86\u5bc6\u5207\u7684\u5408\u4f5c\u5173\u7cfb\uff0c\u4e3a\u6570\u5343\u5bb6\u4e2d\u5c0f\u4f01\u4e1a\u548c\u4e0a\u4e07\u540d\u79c1\u8425\u5c0f\u4e1a\u4e3b\u3001\u521b\u4e1a\u8005\u63d0\u4f9b\u4e86\u5404\u79cd\u7c7b\u578b\u7684\u62c5\u4fdd\uff0c\u7d2f\u8ba1\u62c5\u4fdd\u91d1\u989d\u8fbe600\u4ebf\u5143\u4eba\u6c11\u5e01\u3002\u4eca\u65e5\u7684\u94f6\u8fbe\u5df2\u6210\u4e3a\u5168\u56fd\u8d44\u4ea7\u89c4\u6a21\u6700\u5927\u3001\u7efc\u5408\u5b9e\u529b\u6700\u5f3a\u3001\u4e1a\u52a1\u54c1\u79cd\u6700\u9f50\u5168\u3001\u98ce\u63a7\u6c34\u5e73\u6700\u9ad8\u548c\u6700\u53d7\u94f6\u884c\u548c\u4e2d\u5c0f\u4f01\u4e1a\u4fe1\u8d56\u7684\u5927\u578b\u4e13\u4e1a\u62c5\u4fdd\u96c6\u56e2\u4e4b\u4e00\u3002 \u94f6\u8fbe\u62c5\u4fdd\u96c6\u56e2\u4f5c\u4e3a\u5e7f\u4e1c\u7701\u4fe1\u7528\u62c5\u4fdd\u534f\u4f1a\u7684\u6267\u884c\u4f1a\u957f\u5355\u4f4d\uff0c\u4ee5\u53ca\u5168\u56fd\u4e2d\u5c0f\u4f01\u4e1a\u4fe1\u7528\u62c5\u4fdd\u673a\u6784\u8d1f\u8d23\u4eba\u8054\u5e2d\u4f1a\u8bae\u7684\u4e3b\u8981\u53d1\u8d77\u4eba\u4e4b\u4e00\uff0c\u66fe\u88ab\u6211\u56fd\u6743\u5a01\u4fe1\u7528\u8bc4\u7ea7\u673a\u6784\u8bc4\u4e3aAAA-\u4fe1\u7528\u7b49\u7ea7\uff0c\u662f\u5e7f\u5dde\u5e02\u552f\u4e00\u4e00\u5bb6\u88ab\u8bc4\u9009\u4e3a\u201c\u5168\u56fd\u5341\u5927\u6700\u5177\u5f71\u54cd\u529b\u4e2d\u5c0f\u4f01\u4e1a\u4fe1\u7528\u62c5\u4fdd\u673a\u6784\u201d\u7684\u878d\u8d44\u62c5\u4fdd\u673a\u6784\uff0c\u8363\u83b7\u201c\u5168\u56fd\u4e2d\u5c0f\u4f01\u4e1a\u4fe1\u7528\u62c5\u4fdd\u673a\u6784\u4e09\u5341\u5f3a\u201d\u7b49\u591a\u9879\u8363\u8a89\u3002', u'creditRank': u'HR', u'url': u'/financing/gdyd', u'businessScope': u'\u4ee5\u81ea\u6709\u8d44\u91d1\u8fdb\u884c\u4fe1\u7528\u62c5\u4fdd\uff1b\u4e0e\u62c5\u4fdd\u6709\u5173\u7684\u6295\u8d44\u53ca\u54a8\u8be2\u7b49\u914d\u5957\u670d\u52a1\uff1b\u505c\u8f66\u573a\u7ecf\u8425\uff08\u9650\u5206\u652f\u673a\u6784\u7ecf\u8425\uff09\uff1b\uff08\u5177\u4f53\u7ecf\u8425\u9879\u76ee\u8bf7\u767b\u5f55\u5e7f\u5dde\u5e02\u5546\u4e8b\u4e3b\u4f53\u4fe1\u606f\u516c\u793a\u5e73\u53f0\u67e5\u8be2\u3002\u7ecf\u8425\u8303\u56f4\u4ee5\u5ba1\u6279\u673a\u5173\u6838\u5b9a\u7684\u4e3a\u51c6\uff0c\u4f9d\u6cd5\u987b\u7ecf\u6279\u51c6\u7684\u9879\u76ee\uff0c\u7ecf\u76f8\u5173\u90e8\u95e8\u6279\u51c6\u540e\u65b9\u53ef\u5f00\u5c55\u7ecf\u8425\u6d3b\u52a8\u3002\uff09', u'userId': u'087CDEF8-A911-4BA1-A08A-B7F4C17E09F4', u'registeredLocation': u'\u5e7f\u5dde\u5e02\u8d8a\u79c0\u533a\u5bfa\u53f3\u65b0\u9a6c\u8def111-115\u53f71306\u623f', u'contactEmail': u'275191210@qq.com', u'timeEstablished': {u'dayOfWeek': 4, u'weekyear': 2000, u'fields': [{u'supported': True, u'name': u'year', u'maximumValue': 292278993, u'rangeDurationField': None, u'durationField': {u'precise': False, u'unitMillis': 31556952000, u'supported': True, u'type': {u'name': u'years'}, u'name': u'years'}, u'lenient': False, u'minimumValue': -292275054, u'type': {u'durationType': {u'name': u'years'}, u'name': u'year', u'rangeDurationType': None}, u'leapDurationField': {u'precise': True, u'unitMillis': 86400000, u'supported': True, u'type': {u'name': u'days'}, u'name': u'days'}}, {u'supported': True, u'name': u'monthOfYear', u'maximumValue': 12, u'rangeDurationField': {u'precise': False, u'unitMillis': 31556952000, u'supported': True, u'type': {u'name': u'years'}, u'name': u'years'}, u'durationField': {u'precise': False, u'unitMillis': 2629746000, u'supported': True, u'type': {u'name': u'months'}, u'name': u'months'}, u'lenient': False, u'minimumValue': 1, u'type': {u'durationType': {u'name': u'months'}, u'name': u'monthOfYear', u'rangeDurationType': {u'name': u'years'}}, u'leapDurationField': {u'precise': True, u'unitMillis': 86400000, u'supported': True, u'type': {u'name': u'days'}, u'name': u'days'}}, {u'supported': True, u'name': u'dayOfMonth', u'maximumValue': 31, u'unitMillis': 86400000, u'rangeDurationField': {u'precise': False, u'unitMillis': 2629746000, u'supported': True, u'type': {u'name': u'months'}, u'name': u'months'}, u'durationField': {u'precise': True, u'unitMillis': 86400000, u'supported': True, u'type': {u'name': u'days'}, u'name': u'days'}, u'lenient': False, u'minimumValue': 1, u'type': {u'durationType': {u'name': u'days'}, u'name': u'dayOfMonth', u'rangeDurationType': {u'name': u'months'}}, u'leapDurationField': None}], u'centuryOfEra': 20, u'fieldTypes': [{u'durationType': {u'name': u'years'}, u'name': u'year', u'rangeDurationType': None}, {u'durationType': {u'name': u'months'}, u'name': u'monthOfYear', u'rangeDurationType': {u'name': u'years'}}, {u'durationType': {u'name': u'days'}, u'name': u'dayOfMonth', u'rangeDurationType': {u'name': u'months'}}], u'chronology': {u'zone': {u'fixed': True, u'id': u'UTC'}}, u'yearOfCentury': 0, u'yearOfEra': 2000, u'dayOfYear': 300, u'values': [2000, 10, 26], u'era': 1, u'year': 2000, u'monthOfYear': 10, u'weekOfWeekyear': 43, u'dayOfMonth': 26}, u'background': u'', u'address': u'\u5e7f\u5dde\u5e02\u8d8a\u79c0\u533a\u5bfa\u53f3\u65b0\u9a6c\u8def111-115\u53f71306\u623f', u'contactPersion': u'\u5b59\u5609\u52b1'}, u'user': {u'category': u'\u6709\u9650\u8d23\u4efb\u516c\u53f8', u'userName': None, u'userEmail': u'notavailable@fengjr.com', u'taxCode': u'440102725023250', u'name': u'\u5e7f\u4e1c\u94f6\u8fbe\u878d\u8d44\u62c5\u4fdd\u6295\u8d44\u96c6\u56e2\u6709\u9650\u516c\u53f8', u'rtpo': True, u'contractSealCode': u'72502325-0001', u'userId': u'087CDEF8-A911-4BA1-A08A-B7F4C17E09F4', u'userMobile': u'13552552316', u'lastLoginDate': None, u'loginName': u'\u94f6\u8fbe\u62c5\u4fdd', u'busiCode': u'440101000002375', u'user': {u'idNumber': None, u'loginName': u'\u94f6\u8fbe\u62c5\u4fdd', u'name': None, u'mobile': u'13552552316', u'registryRewarded': False, u'enabled': True, u'lastModifiedBy': None, u'email': u'notavailable@fengjr.com', u'clientCode': u'FENG', u'source': u'BACK', u'referralEntity': None, u'lastLoginDate': None, u'enterprise': True, u'registerDate': 1417421585000, u'referralRewarded': False, u'id': u'087CDEF8-A911-4BA1-A08A-B7F4C17E09F4', u'channel': None, u'employeeId': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D'}, u'orgCode': u'725023250', u'shortName': u'\u94f6\u8fbe\u62c5\u4fdd', u'registerDate': 1417421585000, u'type': u'GUARANTEE', u'id': u'087CDEF8-A911-4BA1-A08A-B7F4C17E09F4', u'legalPersonId': u'', u'userIdNumber': None}}, u'loan': {u'status': u'SETTLED', u'investAmount': 2000000, u'rate': 900, u'duration': {u'totalDays': 360, u'months': 0, u'totalMonths': 12, u'days': 0, u'years': 1}, u'rewarded': False, u'id': u'0293521B-706E-4AAF-B3C6-3632AFFDD941', u'timeCleared': None, u'corporationUrl': u'/financing/gdyd', u'corporationId': None, u'title': u'\u51e4\u4fdd\u5b9d-YDDB-20141202-001', u'available': 0, u'timeSettled': 1417500267000, u'hidden': False, u'countDownTime': -1, u'method': u'MonthlyInterest', u'timeOpen': 1417448520000, u'ordinal': 1, u'timeFinished': 1417451574000, u'timeLeft': -1, u'timeout': 72, u'bidNumber': 66, u'leftBidTime': 9223372036854775807, u'corporationName': u'\u5e7f\u4e1c\u94f6\u8fbe\u878d\u8d44\u62c5\u4fdd\u6295\u8d44\u96c6\u56e2\u6709\u9650\u516c\u53f8', u'investPercent': 1.0, u'corporationShortName': u'\u94f6\u8fbe\u62c5\u4fdd', u'loanRequest': {u'guaranteeInfo': u' \u5e7f\u4e1c\u94f6\u8fbe\u878d\u8d44\u62c5\u4fdd\u6295\u8d44\u96c6\u56e2\u6709\u9650\u516c\u53f8\u63d0\u4f9b100%\u672c\u606f\u4fdd\u969c\u3002', u'riskInfo': u' (a) \u501f\u6b3e\u4f01\u4e1a\u5b9e\u9645\u63a7\u5236\u4eba\u674e\u5e73\u627f\u62c5\u4e2a\u4eba\u65e0\u9650\u8fde\u5e26\u8d23\u4efb\u4fdd\u8bc1\u62c5\u4fdd\uff1b\t\t\n (b) \u5e7f\u5dde\u5e02\u5929\u9ad8\u96c6\u56e2\u6709\u9650\u516c\u53f8\u3001\u5929\u5fb7\uff08\u4e9a\u6d32\uff09\u6709\u9650\u516c\u53f8\u5206\u522b\u63d0\u4f9b\u8fde\u5e26\u8d23\u4efb\u4fdd\u8bc1\u62c5\u4fdd\uff1b\t\t\n (c) \u501f\u6b3e\u4f01\u4e1a\u63d0\u4f9b\u65e0\u9650\u8fde\u5e26\u8d23\u4efb\u62c5\u4fdd\u3002\t\t', u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'rate': 900, u'duration': {u'totalDays': 360, u'months': 0, u'totalMonths': 12, u'days': 0, u'years': 1}, u'mortgageInfo': u'\u501f\u6b3e\u4f01\u4e1a\u5c063\u5957\u7269\u4e1a\u4f4d\u4e8e\u5e7f\u5dde\u5e02\u5929\u6cb3\u533a\u9f99\u53e3\u897f\u8def\u91d1\u7530\u5317\u885715\u53f7304\u623f\u3001305\u623f\uff0c\u5929\u6cb3\u5317\u8def689\u53f71015\u623f\uff0c\u603b\u9762\u79ef\u4e3a834.52\u33a1\u7684\u4f4f\u5b85\u7c7b\u623f\u4ea7\u62b5\u62bc\u7ed9\u5e7f\u4e1c\u94f6\u8fbe\u878d\u8d44\u62c5\u4fdd\u6295\u8d44\u96c6\u56e2\u6709\u9650\u516c\u53f8\uff0c\u8be5\u623f\u4ea7\u7ecf\u8d44\u4ea7\u8bc4\u4f30\u516c\u53f8\u8bc4\u4f30\uff0c\u8bc4\u4f30\u4ef7\u503c\u4e3a1600\u4e07\u5143\uff0c\u94f6\u8fbe\u62c5\u4fdd\u63d0\u4f9b4500\u4e07\u5143\u7efc\u5408\u62c5\u4fdd\u6388\u4fe1\u989d\u5ea6\u3002', u'id': u'984485FD-B44F-4A98-BA0A-26935F405871', u'employeeId': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D', u'reviewComment': u' \u540c\u610f', u'title': u'\u51e4\u4fdd\u5b9d-YDDB-20141202-001', u'source': u'BACK', u'hidden': False, u'method': u'MonthlyInterest', u'productId': u'BE192E7E-F9DC-493A-94BF-C22DA97827D9', u'status': u'PUBLISHED', u'description': u'\u672c\u6b21\u878d\u8d44\u4e3b\u8981\u7528\u4e8e\u501f\u6b3e\u4f01\u4e1a\u8865\u5145\u8d38\u6613\u9879\u4e0b\u6d41\u52a8\u8d44\u91d1\u3002\t\t\t\t\n\t\t\t\t\t', u'productKey': u'FENG_CX', u'timeSubmit': 1417446301000, u'investRule': {u'stepAmount': 5000, u'minAmount': 5000, u'maxTotalAmount': 0, u'maxTimes': 0, u'maxAmount': 2000000}, u'purpose': u'CORPORATION', u'serial': None, u'clientPriv': None, u'mortgageType': [], u'guaranteeEntity': {u'entityId': u'087CDEF8-A911-4BA1-A08A-B7F4C17E09F4', u'realm': u'CORPORATIONUSER'}, u'guarantyStyle': u'Guarantee', u'mortgaged': False, u'amount': 2000000, u'requestProvider': {u'entityId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'realm': u'CORPORATION'}, u'user': {u'idNumber': None, u'loginName': u'\u5929\u9ad8\u516c\u53f8', u'name': None, u'mobile': u'18610089390', u'registryRewarded': False, u'enabled': True, u'lastModifiedBy': None, u'email': u'notavailable@fengjr.com', u'clientCode': u'FENG', u'source': u'BACK', u'referralEntity': None, u'lastLoginDate': None, u'enterprise': True, u'registerDate': 1417422831000, u'referralRewarded': False, u'id': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'channel': None, u'employeeId': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D'}}, u'mortgaged': False, u'bidAmount': 2000000, u'amount': 2000000, u'timeElapsed': 3054000, u'autoSplitted': False, u'balance': 0}, u'proofs': [{u'submitTime': 1417446700000, u'uri': u'https://img.fengjr.com/upload/image/2014/12/1/FENGJR-1A941733AA844FD8BC8DAFF546C72E37.jpg', u'content': u'/2014/12/1/FENGJR-1A941733AA844FD8BC8DAFF546C72E37.jpg', u'source': u'BACK', u'proofType': u'LOANPURPOSE', u'uploader': u'', u'uploaderId': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D', u'id': u'87F222F3-23BD-46E4-8F6B-DF9B7107AFE3', u'proof': {u'contentType': u'IMAGE', u'description': u'', u'submitTime': 1417446700000, u'cover': False, u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'longitude': None, u'content': u'/2014/12/1/FENGJR-1A941733AA844FD8BC8DAFF546C72E37.jpg', u'source': u'BACK', u'proofType': u'LOANPURPOSE', u'employee': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D', u'owner': {u'entityId': u'984485FD-B44F-4A98-BA0A-26935F405871', u'realm': u'LOANREQUEST'}, u'latitude': None, u'id': u'87F222F3-23BD-46E4-8F6B-DF9B7107AFE3', u'mosaic': False}}], u'user': {u'statistics': {u'settledLoans': 1, u'overdueLoanAmount': {u'totalAmount': 0, u'interest': 0, u'principal': 0}, u'totalLoanAmount': 2000000, u'publishedLoans': 1, u'breachLoans': 0, u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'dueInvestAmount': {u'totalAmount': 0, u'interest': 0, u'principal': 0}, u'successfulLoans': 1, u'dueLoanAmount': {u'totalAmount': 2180000.0, u'interest': 180000.0, u'principal': 2000000.0}, u'clearedLoans': 0, u'totalInvestAmount': 0, u'overdueLoans': 0}, u'userCredit': {u'timeCreated': 1417422831000, u'creditAvailable': 0, u'creditRank': u'HR', u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'timeLastUpdated': 1417422831000, u'lastModifiedBy': u'SYSTEM', u'creditLimit': 0, u'assessment': {u'score': 0}}, u'userInfo': {u'personal': {u'male': True, u'children': False}, u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'user': {u'idNumber': None, u'loginName': u'\u5929\u9ad8\u516c\u53f8', u'name': None, u'mobile': u'18610089390', u'registryRewarded': False, u'enabled': True, u'lastModifiedBy': None, u'email': u'notavailable@fengjr.com', u'clientCode': u'FENG', u'source': u'BACK', u'referralEntity': None, u'lastLoginDate': None, u'enterprise': True, u'registerDate': 1417422831000, u'referralRewarded': False, u'id': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'channel': None, u'employeeId': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D'}, u'priv': None}, u'certificates': {u'LOANPURPOSE': {u'status': u'UNCHECKED', u'timeCreated': 1417446700000, u'assessment': {u'score': 0}, u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'auditInfo': u'create', u'auditor': u'SYSTEM', u'type': u'LOANPURPOSE', u'id': u'AED8BC59-191D-465B-9D94-B9E5BBBBED7D', u'timeLastModified': 1417446700000}}, u'userFund': {u'depositAmount': 0.0, u'availableAmount': 5.0, u'userId': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'rechargeAmount': 0.0, u'frozenAmount': 0.0, u'transferAmount': 0.0, u'dueInAmount': 0.0, u'withdrawAmount': 1999995.0, u'dueOutAmount': 2180000.0}, u'user': {u'idNumber': None, u'loginName': u'\u5929\u9ad8\u516c\u53f8', u'name': None, u'mobile': u'18610089390', u'registryRewarded': False, u'enabled': True, u'lastModifiedBy': None, u'email': u'notavailable@fengjr.com', u'clientCode': u'FENG', u'source': u'BACK', u'referralEntity': None, u'lastLoginDate': None, u'enterprise': True, u'registerDate': 1417422831000, u'referralRewarded': False, u'id': u'EA82516B-25D3-4EBB-9C99-E9886AB55F9E', u'channel': None, u'employeeId': u'7FD47ED2-6AA3-437D-AB71-5393DC1F580D'}}}, u'success': True, u'error': []}
def loandetail(host):
	uri = "/api/v2/loan/0293521B-706E-4AAF-B3C6-3632AFFDD941/detail"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		del content["data"]["serverDate"]
		del content["data"]["loan"]["serverDate"]
		if content == data_loandetail:
			print " Pass | 理理财项目详情"
		else:
			print " False | 理理财项目详情有变化，请检查"
	else:
		print " Error | 理理财项目详情 |", r.status_code, r.content
loandetail(host)


# /api/v2/loan/request/A27F2F33-6043-4893-A972-35F8E8AF8BEF
def loan_request(host):
	uri = "/api/v2/loan/request/A27F2F33-6043-4893-A972-35F8E8AF8BEF"
	url = host + uri
	headers = header(token(host))
	r = requests.get(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["data"]:
			print " Pass | loan_request"
		else:
			print " False | loan_request is none"
	else:
		print r.status_code, r.content
loan_request(host)


# 理理财项目投资记录	/api/v2/loan/C100BEEF-00F6-4F3A-9D08-5BEEEBD364B4/invests
def loan_invests_record(host):
	uri = "/api/v2/loan/C100BEEF-00F6-4F3A-9D08-5BEEEBD364B4/invests"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		print " Pass | 理理财项目投资记录"
	else:
		print " Error | 理理财项目投资记录 ", r.status_code, r.content
loan_invests_record(host)


# 确认项目是否可投		https://beta.fengjr.com/api/v2/loan/0293521B-706E-4AAF-B3C6-3632AFFDD941
def check_status(host):
	uri = "/api/v2/loan/0293521B-706E-4AAF-B3C6-3632AFFDD941"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["balance"] == 0:
			print " Pass | 确认项目是否可投 | 项目不可投"
		elif content["balance"] < 0:
			print " Error | 确认项目是否可投 | 可投金额小于0，请检查"
		else:
			print " Pass | 确认项目是否可投 | 项目可投"
	else:
		print " Error | 确认项目是否可投 ", r.status_code, r.content
check_status(host)

# 理理财投资			https://beta.fengjr.com/api/v2/upayment/tenderNoPwd/user/MYSELF/loan/2147089C-6137-46E8-B778-ADD971D61FDA/amount/1.0
def invest(host):
	uri = "/api/v2/upayment/tenderNoPwd/user/MYSELF/loan/2147089C-6137-46E8-B778-ADD971D61FDA/amount/1.0"
	url = host + uri 
	headers = header(token(host))
	r = requests.post(url, headers = headers)
	if r.status_code == 200:
		print " Pass | invest | success"
	else:
		print " Error | invest |", r.status_code, r.content
invest(host)

# 担保/借款企业信息	https://bate.fengjr.com/api/v2/loan/getCorporation/EA82516B-25D3-4EBB-9C99-E9886AB55F9E
def corporation_info(host):
	uri = "/api/v2/loan/getCorporation/EA82516B-25D3-4EBB-9C99-E9886AB55F9E"
	url = host + uri
	r = requests.get(url)
	if r.status_code == 200:
		content = json.loads(r.content)
		if len(content) > 1 and content["corp"] and content["info"]:
			print " Pass | corporation_info"
		else:
			print " False | no corporation_info"
	else:
		print r.status_code, r.content
corporation_info(host)


# post with token
# 用户反馈			https://beta.fengjr.com/api/v2/user/MYSELF/feedback
def feedback(host):
	uri = "/api/v2/user/MYSELF/feedback"
	url = host + uri
	headers = header(token(host))
	data = {'contact':'13800138000','name':'David','feedback':'{"version":"1.1.0","content":"测试","lang":"zh","model":"MI 3","resolution":"1080:1920","sdk":"19","code":10}'}
	r = requests.post(url, headers = headers, data = data)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["success"]:
			print " Pass | feedback"
		else:
			print " False | feedback"
	else:
		print r.status_code, r.content
feedback(host)


# 众筹预支付			https://beta.fengjr.com/api/v2/upayment/prepareProjectTender/MYSELF
def prepare_pay_crowdfunding(host):
	uri = "/api/v2/upayment/prepareProjectTender/MYSELF"
	url = host + uri
	headers = header(token(host))
	data = {'projectId':'7373AF4F-6544-4B2F-A7C2-18CD4BF9EDA0','rewardId':'0C218B6E-8085-4201-8806-FF9203E99B61','needInvoice':'false','fee':'0.0','address':'Beijing','name':'Nick'}
	r = requests.post(url, headers = headers, data = data)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["data"]["order"]["id"]:
			print " Pass | 获取众筹支付订单号成功"
			return content["data"]["order"]["id"]	
		else:
			print " False | 获取众筹支付订单号失败"
	else:
		print " Error | 获取众筹支付订单号 ", r.status_code, r.content


# 众筹完成支付		https://beta.fengjr.com/api/v2/upayment/projectTenderNoPwd/user/MYSELF/project/1A016C6F-699F-47C4-87D5-92437450597A/invest/EB0692BA-D5CD-4D8F-8C94-32AF01D314D0
def paycrowdfunding(host):
	order_id = prepare_pay_crowdfunding(host)
	if order_id == None:
		uri = "/api/v2/upayment/projectTenderNoPwd/user/MYSELF/project/7373AF4F-6544-4B2F-A7C2-18CD4BF9EDA0/invest/" 
	else:
		uri = "/api/v2/upayment/projectTenderNoPwd/user/MYSELF/project/7373AF4F-6544-4B2F-A7C2-18CD4BF9EDA0/invest/" + order_id		
	url = host + uri
	headers = header(token(host))
	r = requests.post(url, headers = headers)
	if r.status_code == 200:
		content = json.loads(r.content)
		if content["success"] == True:
			print " Pass | 众筹项目支持成功"
		else:
			print " False | 众筹项目支持失败"
	else:
		print " Error | 支付众筹 |", r.status_code, r.content
paycrowdfunding(host)






