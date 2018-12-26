<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>itemList画面</title>

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
min-height: 500px;
text-align: center;
}
#footer {
width: 100%;
height: 80px;
background-color: black;
clear:both;
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
			<p>ItemList</p>
		</div>
		<div>
		<s:if test="itemListDTOList.isEmpty">
			<h3>商品情報はありません</h3>
		</s:if>
		<s:else>
				<h3>商品情報は以下になります。</h3>
			<s:iterator value="itemListDTOList">
			<table>
				<tr>
						<th>id</th>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
						<th>登録日</th>
						<th>更新日</th>
				</tr>

					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="itemName" /></td>
						<td><s:property value="itemPrice" /><span>円</span></td>
						<td><s:property value="itemStock" /><span>個</span></td>
						<td><s:property value="insert_date" /></td>
						<td><s:property value="update_date" /></td>
					</tr>

				</table>
				<s:form action="ItemListDeleteConfirmAction">
					<s:submit value="削除"/>
					<input type="hidden" name="id" value="<s:property value="id"/>"/>
				</s:form>
				<br>
			</s:iterator>
			<br><br>
				<s:form action="ItemListDeleteAllConfirmAction">
					<s:submit value="全部削除"/>
				</s:form>
		</s:else>
			<div >
				<p>管理者TOP画面へ戻る場合は<a href='admin.jsp'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>


</body>
</html>