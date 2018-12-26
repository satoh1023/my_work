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
<title>reviewWriteConfirm画面</title>

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
			<p>ReviewWriteConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="ReviewWriteCompleteAction">
				<tr id="box">
					<td>
						<label>商品名</label>
					</td>
					<td>
						<s:property value="session.reviewItemName" escape="false"/>
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>評価</label>
					</td>
					<td>
						☆<s:property value="session.rating" escape="false"/>
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>コメント</label>
					</td>
					<td>
						<textarea rows="5" cols="30" maxLength="90"><s:property value="session.comment"/>
						</textarea>
					</td>
				</tr>
				<div>
					<s:submit value="完了"/>
				</div>
				<p>書き直す場合は<a href='reviewWrite.jsp'>こちら</a></p>
				</s:form>
			</table>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>