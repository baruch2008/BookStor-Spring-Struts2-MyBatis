<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookStor</title>
</head>
<body>
	<div align="center">
		<s:form action="login" namespace="/">
			<s:fielderror cssStyle="color:red"></s:fielderror>
			<s:textfield label="用户名" name="user.name" required="true" maxlength="255"></s:textfield>
			<s:password label="密码" name="user.pwd" required="true" maxlength="6"></s:password>
			<tr>
	            <td colspan="2" align="center">
	                <s:submit value="登录" theme="simple" id="login"/><s:reset value="重置" theme="simple"/>
	            </td>
            </tr>
		</s:form>
	</div>
</body>
</html>