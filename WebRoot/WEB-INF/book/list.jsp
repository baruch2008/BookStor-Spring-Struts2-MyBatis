<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%-- <%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="java.util.List" %>
<%@ page import="com.baruch.model.Book" %> --%>
<s:debug></s:debug>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookStor</title>
<style type="text/css">
	.table-b table td{border:1px solid #F00}
</style>

<!-- 此处需要使用绝对路径，也就是/js/lib，不能是js/lib，否则执行时会在前面加action的namespace，比如book，这样就找不到资源文件了 -->
<script type="text/javascript" src="/js/lib/jquery/jquery-3.2.1.js"></script> 
<script type="text/javascript">
	function previous() {
	    var curPageNum = $("#curPageNum").val();
	    if (curPageNum -1 <= 0) {
			curPageNum = 1;
	    }else {
			curPageNum = curPageNum -1;
	    }
	    var uri = "/book/view.do?pageNum="+curPageNum;
	    submit(uri, "post");
	}
	
	function next() {
	    var curPageNum = $("#curPageNum").val();
	    var totalPageNum = $("#totalPageNum").val();
	    if (curPageNum +1 >= totalPageNum) {
			curPageNum = totalPageNum;
	    }else {
			curPageNum = curPageNum + 1;
	    }
	    
	    var uri = "/book/view.do?pageNum="+curPageNum;
	    submit(uri, "post");
	}
	
	function jump() {
	    var pageNum = $("#pageNum").val();
	    var totalPageNum = $("#totalPageNum").val();
	    if (pageNum >= totalPageNum) {
			pageNum = totalPageNum;
	    } else if(pageNum <=1) {
			pageNum = 1;
	    }
	    var uri = "/book/view.do?pageNum=" + pageNum;
	    submit(uri, "post");
	} 
	
	function submit(uri, method) {
	    var form = document.createElement("form");
	    form.action = uri;
	    form.method=method;
	    document.body.appendChild(form);
	    form.submit();
	}
</script>
</head>
<body>
	<div align="left">
		<table>
			<tr>
				<td>
					<s:form action="view" namespace="/book">
						<tr>
							<td><s:select name="queryType" headerkey="1" headerValue="ISBN" list="#{'0':'请选择','1':'ISBN','2':'名称','3':'作者'}" theme="simple"></s:select></td>
							<td><s:textfield name="queryValue" required="true" maxlength="255" size="20" theme="simple"></s:textfield></td>
							<td><s:submit id="queryBtn" value="查询" theme="simple"></s:submit></td>
						</tr>
					</s:form>
				</td>
				<td>
					<s:form action="upload" method="post" enctype="multipart/form-data" theme="simple">
						<s:file label="上传" theme="simple" name="upload"></s:file>
						<s:submit value="导入" theme="simple"/>
					</s:form>
				</td>
			</tr>
		</table>
	</div>
	<%-- <s:property value="#Test"/>
	<s:property value="name"/>
	<s:property value="pwd"/> --%>
	<div align="left">
		<table>
			<thead>
				<tr><td>ISBN</td> <td>名称</td> <td>作者</td> <td>出版社</td> <td>价格</td>
				</tr>
			</thead>
			<%-- <%
				ValueStack vs = (ValueStack)request.getAttribute("struts.valueStack");
			%> --%>
			<tbody>
				<s:iterator value="books" status="bookStatus" var="book">
					<tr>
						<td><s:property value="#book.isbn"/></td>
						<td><s:property value="#book.name"/></td>
						<td><s:property value="#book.author"/></td>
						<td><s:property value="#book.press"/></td>
						<td><s:property value="#book.price"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<div align="left">
			<s:hidden value="%{pageNum}" name="curPageNum" id="curPageNum"></s:hidden>
			<s:hidden value="%{totalPageNum}" name="totalPageNum" id="totalPageNum"></s:hidden>
			<a href="javascript:previous();">上一页</a>
			<s:property value="pageNum"/>
			<a href="javascript:next();">下一页</a>
			<s:textfield value="%{pageNum}" name="pageNum" id="pageNum" size="5" theme="simple"/>
			<s:submit value="GO" onclick="javascript:jump();" theme="simple"/>
		</div>
	</div>
</body>
</html>