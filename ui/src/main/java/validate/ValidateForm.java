package validate;

import model.UserBean;

/**
 * Created with IntelliJ IDEA.
 * User: herr
 * Date: 01.10.14
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class ValidateForm {


    UserBean validBean = new UserBean();
    public UserBean validateData(UserBean ubean)
    {
        //if given username value is not valid then seterror
        // message and set empty value to input field
        if(ubean.getUserName().length()==0)
        {
            validBean.setUserNameError("please enter valid name");
            validBean.setIsValid(false);
            validBean.setUserName("");
        }
        else
        if(!ubean.getUserName().matches("[a-zA-Z]*"))
        {
            validBean.setUserNameError("please enter valid name");
            validBean.setIsValid(false);
            validBean.setUserName("");

        }
        //if given username value is valid then seterror message to
        // empty and set value to bean
        else
        {
            validBean.setUserNameError("");
            validBean.setIsValid(true);
            validBean.setUserName(ubean.getUserName());
        }


        //if given username value is not valid then seterror message
        // and set empty value to input field
        if(!ubean.getDateOfBirth().matches("\\d{1,2}-\\d{1,2}-\\d{4}"))
        {
            validBean.setDateOfBirthError("please enter valid date");
            validBean.setIsValid(false);
            validBean.setDateOfBirth("");

        }
        //if given username value is valid then seterror message
        // to empty and set value to bean
        else
        {
            validBean.setDateOfBirthError("");
            validBean.setIsValid(true);
            validBean.setDateOfBirth(ubean.getDateOfBirth());
        }


        //if given username value is not valid then seterror message 
        //and set empty value to input field

        if(!ubean.getEmail().matches("^[a-z]*\\@([\\w]+\\.)+[\\w]+[\\w]$"))
        {
            validBean.setEmailError("please enter valid email");
            validBean.setIsValid(false);
            validBean.setEmail("");
        }
        //if given username value is valid then seterror message
        //to empty and set value to bean
        else
        {
            validBean.setEmailError("");
            validBean.setIsValid(true);
            validBean.setEmail(ubean.getEmail());
        }

        //if given username value is not valid then seterror message
        // and set empty value to input field
        if(!ubean.getPhoneNo().matches("\\d{2}"))
        {
            validBean.setPhoneNoError("please enter valid phoneno");
            validBean.setIsValid(false);
            validBean.setPhoneNo("");
        }
        //if given username value is valid then seterror message to 
        // empty and set value to bean
        else
        {
            validBean.setPhoneNoError("");
            validBean.setIsValid(true);
            validBean.setPhoneNo(ubean.getPhoneNo());
        }
        return validBean;
    }
}


