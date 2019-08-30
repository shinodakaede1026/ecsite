<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>Item詳細画面</title>
	<style type="text/css">
		body {
			margin: 0;
			padding: 0;
			line-height: 1.6;
			letter-spacing: 1px;
			font-family: Verdana, Helvetica, sans-serif;
			font-size: 12 px;
			color: #333;
			background: #fff;
		}
		table {
			text-align: center;
			margin: 0 auto;
		}
		/*========ecsite LAYOUT========*/
		#top {
			width: 780px;
			margin: 30px auto;
			border: 1px solid #333;
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
			clear: both;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>Item詳細</p>
		</div>
		<div>
				<table border="1">
				<tr>
					<th>ID</th>
					<th></th>
					<th>商品名</th>
					<th>商品価格</th>
					<th>在庫個数</th>
				</tr>
				<s:iterator value="itemListD">
					<tr>
						<td><s:property value="id"/><td>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/><span>円</span></td>
						<td><s:property value="itemStock"/><span>個</span></td>
					</tr>
				</s:iterator>
				</table>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>