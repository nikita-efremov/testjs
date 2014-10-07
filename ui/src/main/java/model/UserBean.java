package model;

/**
 * Created with IntelliJ IDEA.
 * User: herr
 * Date: 01.10.14
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class UserBean {

    private String userName ;
    private String dateOfBirth ;
    private String email ;
    private String phoneNo ;

    //for validation error messages

    private String userNameError;
    private String dateOfBirthError;
    private String emailError;
    private String phoneNoError;
    private boolean isValid;

    //this is for action means edit or submit or delete or update
    private String action;
    //construtor.it is invoked when we run jsp page.
    //so first time no values will display in jsp page
    public UserBean()
    {
        userName ="";
        dateOfBirth ="";
        email="";
        phoneNo="";

        userNameError="";
        dateOfBirthError="";
        emailError="";
        phoneNoError="-";

        action = "submit";
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //setter and getter methods for errors

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }
    public String getDateOfBirthError() {
        return dateOfBirthError;
    }

    public void setDateOfBirthError(String dateOfBirthError) {
        this.dateOfBirthError = dateOfBirthError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneNoError() {
        return phoneNoError;
    }

    public void setPhoneNoError(String phoneNoError) {
        this.phoneNoError = phoneNoError;
    }

    public boolean getIsValid() {
        return isValid;
    }
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

}