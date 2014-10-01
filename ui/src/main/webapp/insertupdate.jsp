<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.UserBean" %>
<%@ page import="java.util.Enumeration" %>
<% UserBean bean;
    bean = new UserBean();
    Enumeration e = request.getAttributeNames();
    //get request from servlet if data is invalid
    if(request.getAttribute("error")!=null)
    {
        bean = (UserBean)request.getAttribute("error");
    }
    if(request.getAttribute("updateuser")!=null)
    {
        bean = (UserBean)request.getAttribute("updateuser");
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<form method="post" action="ControllerServlet">
    <CENTER>
        <TABLE border="0"width="600px">
            <TR>
                <TD width="150px">Name:</TD>
                <TD>
                    <INPUT TYPE="text" NAME="userName" value="<%=bean.getUserName()%>">
                </TD>
                <TD width="350px">
                    <font color="red"><%=bean.getUserNameError()%> &nbsp;</font>
                </TD>
            </TR>
            <TR>
                <TD width="150px">Date Of Birth:</TD>
                <TD>
                    <INPUT TYPE="text" NAME="dateOfBirth" value="<%=bean.getDateOfBirth()%>">
                </TD>
                <TD>
                    <font color="red"><%=bean.getDateOfBirthError()%> </font>
                </TD>
            </TR>
            <TR>
                <TD width="150px">E-Mail</TD>
                <TD>
                    <INPUT TYPE="text" NAME="email" value="<%=bean.getEmail()%>">
                </TD>
                <TD>
                    <font color="red"><%=bean.getEmailError()%> </font>
                </TD>
            </TR>
            <TR>
                <TD width="150px">Phone no:</TD>
                <TD>
                    <INPUT TYPE="text" NAME="phoneNo" value="<%=bean.getPhoneNo()%>" <%=request.getAttribute("updateuser")!=null?"readonly":""%>>
                </TD>
                <TD>
                    <font color="red"><%=bean.getPhoneNoError()%> </font>
                </TD>
            </TR>
            <TR>
                <TD colspan="2" align="center">
                    <INPUT TYPE="submit" value="<%=bean.getAction()%>" name="action">
                    <INPUT TYPE="submit" value="viewtable" name="action">
                </TD>
                <TD>
                    &nbsp;
                </TD>
            </TR>
        </TABLE>
    </CENTER>
</form>
<a href="<%=request.getContextPath()%>/view.jsp">return to table</a>
</body>
</html>
