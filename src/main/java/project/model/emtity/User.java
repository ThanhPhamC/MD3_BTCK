package project.model.emtity;


import java.util.Date;

public class User {
    private int userId;
    private String fullName;
    private Date birthDate;
    private boolean gender;
    private String avatar;
    private String email;
    private String addressUser;
    private int closeCustumer;
    private String phoneUser;
    private String userName;
    private String passWords;
    private int permission;
    private boolean userStatus;

    public User() {
    }

    public User(int userId, String fullName, Date birthDate, boolean gender, String avatar, String email, String addressUser, int closeCustumer, String phoneUser, String userName, String passWords, int permission, boolean userStatus) {
        this.userId = userId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.avatar = avatar;
        this.email = email;
        this.addressUser = addressUser;
        this.closeCustumer = closeCustumer;
        this.phoneUser = phoneUser;
        this.userName = userName;
        this.passWords = passWords;
        this.permission = permission;
        this.userStatus = userStatus;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public int getCloseCustumer() {
        return closeCustumer;
    }

    public void setCloseCustumer(int closeCustumer) {
        this.closeCustumer = closeCustumer;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWords() {
        return passWords;
    }

    public void setPassWords(String passWords) {
        this.passWords = passWords;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
