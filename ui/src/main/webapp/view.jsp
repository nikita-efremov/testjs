<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*" %>
<%@page import="model.UserBean" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/insertupdate.jsp">back</a>
<table width="100%"border="1">
    <tr>
        <th>Usename</th>
        <th>date of birth</th>
        <th>email</th>
        <th>phone no</th>
        <th>action</th>
    </tr>
    <%
        List list = (List)request.getAttribute("list");
        if(list!=null)
        {
            for(int i=0 ; i< list.size();i++)
            {
                UserBean ubean =(UserBean) list.get(i);

    %>
    <tr>
        <td><%=ubean.getUserName()%></td>
        <td><%=ubean.getDateOfBirth()%></td>
        <td><%=ubean.getEmail()%></td>
        <td><%=ubean.getPhoneNo()%></td>
        <td>
            <a href="ControllerServlet?action=edit&userName=<%=ubean.getUserName()%>">update</a>|
            <a href="ControllerServlet?action=delete&userName=<%=ubean.getUserName()%>">delete</a></td>

    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
