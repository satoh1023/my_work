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
<title>reviewWrite画面</title>

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
</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ReviewWrite</p>
		</div>
			<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
		<div>
			<s:property value="reviewItemName"/>
		</div>
		<table>
			<s:form action="ReviewWriteConfirmAction">
				<tr>
					<td>
						<label>評価</label>
					</td>
					<td>
						☆<input type="text" name="rating" size="3" placeholder="1.0~5.0" maxLength="3"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>コメント</label>
					</td>
					<td>
						<textarea name="comment" rows="5" cols="30" placeholder="90字以内" wrap="hard" maxLength="90" >
						</textarea>
					</td>
				</tr>
				<p>
					<s:submit value="送信"/>
				</p>
			</s:form>
		</table>
		<div id="text-right">
			<p>Mypageへ戻る場合は<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>