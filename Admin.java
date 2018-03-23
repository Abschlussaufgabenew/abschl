package edu.kit.informatik;

public class Admin {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;

    /**
     * Constructor of an Admin instance
     * 
     * @param firstName the admin's first name
     * @param lastName the admin's last name
     * @param userName the admin's user name
     * @param passWord the password associated with the user name
     */
    public Admin(String firstName, String lastName, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.userName = userName;
    }

    /**
     * @return admin's user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return return the password associated with the user name
     */
    public String getPassWord() {
        return passWord;
    }

}