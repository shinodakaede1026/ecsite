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
	<title>ItemCreate画面</title>
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
			<p>ItemCreate</p>
		</div>
		<div>
			<s:if test="errorMessage!=''">
				<s:property value="errorMessage" escape="false" />
			</s:if>
			<table>
				<s:form action="ItemCreateConfirmAction">
					<tr>
						<td><label>商品名:</label></td>
						<td><input type="text" name="itemName" value="" /></td>
					</tr>
					<tr>
						<td><label>商品価格:</label></td>
						<td><input type="number" name="itemPrice"/>円</td>
					</tr>

					<tr>
						<td><label>商品在庫:</label></td>
						<td><input type="number" name="itemStock" />個</td>
					</tr>
					<s:submit value="登録" />
				</s:form>
			</table>
			<div>
				<p>
					前画面に戻る場合は <a href='<s:url action="HomeAction"/>'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>