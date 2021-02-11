package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.exceptions.APIException;

public interface UserValidator {
    void validateuserLogin(LoginDTO user) throws APIException;
    void validateUserSignUp(UserDTO user) throws APIException;
}