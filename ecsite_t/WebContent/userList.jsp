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
	<title>UserList画面</title>
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
			<p>UserList</p>
		</div>
		<div>
				<table border="1">
				<tr>
					<th>ID</th>
					<th>ログインID</th>
					<th>パスワード</th>
					<th>名前</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="Id"/></td>
						<td><s:property value="loginId"/></td>
						<td><s:property value="loginPassword"/><span></span></td>
						<td><s:property value="userName"/><span></span></td>
						<td>
							<s:form action="UserDetailsAction">
								<s:hidden name="nId" value="%{id}"/>
								<s:submit value="詳細"/>
							</s:form>
						</td>
					</tr>
				</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>