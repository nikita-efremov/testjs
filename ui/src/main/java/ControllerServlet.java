import model.UserBean;
import validate.ValidateForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: herr
 * Date: 01.10.14
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {

    //declare values to get form values from jsp page
    String userName;
    String dateOfBirth;
    String email;
    String phoneNo;
    String action;

    UserBean bean = new UserBean();
    ValidateForm validateform = new ValidateForm();
    DBClass dbobject = new DBClass();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //get the values from jsp page
            userName = request.getParameter("userName");
            dateOfBirth = request.getParameter("dateOfBirth");
            email = request.getParameter("email");
            phoneNo = request.getParameter("phoneNo");
            action = request.getParameter("action");
            if(action.equals("submit"))
            {
                //set values to bean.For this call below method
                setValuesToBean();

                //check all form values are valid or not. send bean object
                UserBean checkedbean = validateform.validateData(bean);
                if(!checkedbean.getIsValid())
                {

                    //if data is invalid.set bean object in request and pass that request to
                    //insertupdate.jsp using forward
                    checkedbean.setAction("submit");
                    request.setAttribute("error",checkedbean);

                    RequestDispatcher rd = request.getRequestDispatcher("insertupdate.jsp");
                    rd.forward(request, response);
                    //now display errors in that jsp page
                }
                else
                {
                    //using DBClass object call insertDetails method and pass bean object
                    dbobject.insertDetails(bean);
                    List list = dbobject.getAlldetails();
                    request.setAttribute("list", list);
                    //forward to insertupdate page using requestdispatcher
                    RequestDispatcher rd= request.getRequestDispatcher("view.jsp");
                    //display a message to client.store message in request object
                    //forwarding to jsp
                    rd.forward(request, response);


                }
            }
            if (action.equals("viewtable")) {
                List list = dbobject.getAlldetails();
                request.setAttribute("list", list);
                //forward to insertupdate page using requestdispatcher
                RequestDispatcher rd= request.getRequestDispatcher("view.jsp");
                //display a message to client.store message in request object
                //forwarding to jsp
                rd.forward(request, response);
            }
            if(action.equals("edit"))
            {
                //get userdetails of particular name
                UserBean ubean = dbobject.getDetails(userName);
                request.setAttribute("updateuser",ubean);
                RequestDispatcher rd = request.getRequestDispatcher("insertupdate.jsp");
                rd.forward(request, response);
            }
            if(action.equals("update"))
            {
                setValuesToBean();
                UserBean checkedbean = validateform.validateData(bean);
                if(!checkedbean.getIsValid())
                {

                    //if data is invalid.set bean object in request and pass that request to
                    //insertupdate.jsp using forward
                    checkedbean.setAction("update");
                    request.setAttribute("error",checkedbean);
                    RequestDispatcher rd = request.getRequestDispatcher("insertupdate.jsp");
                    rd.forward(request, response);
                    //now display errors in that jsp page
                }
                else
                {
                    //using DBClass object call insertDetails method and pass bean object
                    dbobject.UpateDetails(bean, userName);
                    List list = dbobject.getAlldetails();
                    request.setAttribute("list", list);
                    //forward to insertupdate page using requestdispatcher
                    RequestDispatcher rd= request.getRequestDispatcher("view.jsp");
                    //display a message to client.store message in request object
                    //forwarding to jsp
                    rd.forward(request, response);


                }

            }
            if(action.equals("delete"))
            {
                //delete userdetails of particular name
                dbobject.deleteDetails(userName);
                List list = dbobject.getAlldetails();
                request.setAttribute("list", list);
                //forward to insertupdate page using requestdispatcher
                RequestDispatcher rd= request.getRequestDispatcher("view.jsp");
                //display a message to client.store message in request object
                //forwarding to jsp
                rd.forward(request, response);
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        finally {
            out.close();
        }
    }
    //this method is used to setvalues to bean
    public void setValuesToBean()
    {
        bean.setUserName(userName);
        bean.setDateOfBirth(dateOfBirth);
        bean.setEmail(email);
        bean.setPhoneNo(phoneNo);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    public String getServletInfo() {
        return "Short description";
    }

}
