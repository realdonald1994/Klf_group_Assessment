package com.donald.assessment.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
/**
 * @author Donald
 * @data 03/07/2020 13:18
 */
public class CustomerEmail {
    @NotBlank
    private String username;
    @Email
    private String email;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
