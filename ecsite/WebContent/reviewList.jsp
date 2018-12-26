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
<title>ReviewList画面</title>

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
			<p>ReviewList</p>
		</div>
		<div>
		<s:if test="reviewListDTOList.isEmpty">
			<h3>レビューはありません。</h3>
		</s:if>
		<s:else>
			<h3><s:property value="itemName"/> のレビュー</h3>
			<h3>平均 ☆<s:property value="session.ratingAverage"/></h3>

			<s:iterator value="reviewListDTOList">
			<table>
			<tr>
				<th>評価</th>
				<td>☆<s:property value="rating"/></td>
			</tr>

				<tr>
					<th>コメント</th>
					<td><textarea rows="5" cols="30" maxLength="90"><s:property value="comment"/></textarea></td>
				</tr>
			</table>
			<br><br>
			</s:iterator>
		</s:else>
		</div>
		<p>前画面に戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>