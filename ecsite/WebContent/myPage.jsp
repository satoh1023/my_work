<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>MyPage画面</title>

<style type="text/css">

body {
margin:0;
padding:0;
line-height:1.6;
letter-spacing:1px;
font-family:Verdana, Helvetica, sans-serif;
font-size:12px;
color:#333;
background:#fff;
}
table {
text-align:center;
margin:0 auto;
}
#top {
width:780px;
margin:30px auto;
border:1px solid #333;
}
#header {
width: 100%;
height: 80px;
background-color: black;
}
#main {
width: 100%;
height: 500px;
text-align: center;
}
#footer {
width: 100%;
height: 80px;
background-color: black;
}
#text-right {
display: inline-block;
text-align: right;

}
</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div>
		<s:if test="message != null">
			<h3><s:property value="message"/></h3>
		</s:if>
		<s:elseif test="myPageList.isEmpty()">
			<h3>ご購入情報はありません。</h3>
		</s:elseif>
		<s:elseif test="message == null">
			<h3>ご購入情報は以下になります。</h3>
			<s:iterator value="myPageList">
			<table>
			<tr>
				<th>商品名</th>
				<th>購入個数</th>
				<th>合計金額</th>
				<th>支払い方法</th>
				<th>購入日</th>
			</tr>

				<tr>
					<td><s:property value="itemName"/></td>
					<td><s:property value="totalCount"/><span>個</span></td>
					<td><s:property value="totalPrice"/><span>円</span></td>
					<td><s:property value="payment"/></td>
					<td><s:property value="insert_date"/></td>
				</tr>

			<s:form action="ReviewWriteAction">
				<s:submit value="レビューを書く"/>
				<input type="hidden" name="reviewId" value="<s:property value="item_transaction_id"/>"/>
				<input type="hidden" name="reviewItemName" value="<s:property value="itemName"/>"/>
			</s:form>

			<s:form action="MyPageAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete"/>

				<input type="hidden" name="itemId" value="<s:property value="item_transaction_id"/>"/>
				<input type="hidden" name="insert_date" value="<s:property value="insert_date"/>"/>
			</s:form>
			</table>
			<br>
			</s:iterator>

		</s:elseif>

		<div id="text-right">
		<s:if test = "deleteFlg == 1">
			<p>マイページへ戻る場合は<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
		</s:if>
			<p>商品一覧へ戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
		</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>