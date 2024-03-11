package com.eslam.taskManger.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class WebUser {
    @NotNull(message = "required")
    @Size(min=1,message = "required")
    private String userName;
    @NotNull(message = "required")
    @Size(min=1,message = "required")
    private String password;

    @NotNull(message = "required")
    @Size(min = 1, message = "required")
    private String firstName;

    @NotNull(message = "required")
    @Size(min = 1, message = "required")
    private String lastName;

    @NotNull(message = "required")
    @Size(min = 1, message = "required")
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    ,message = "Invalid Email Format")
    private String email;

    public WebUser() {
    }

    public WebUser(String userName, String password, String firstName, String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
