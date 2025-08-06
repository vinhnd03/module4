package com.vinhnd.validate_form_dang_ky.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto implements Validator {
    private Long id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String phone;
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
	//UserRequestDto.class.isAssignableFrom(clazz);
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto user = (UserRequestDto) target;

        if(user.getLastName().length() < 5 || user.getLastName().length() > 45){
            errors.rejectValue("lastName", "invalidLastName");
        } else if (user.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "lastNameEmpty");
        }

        if(user.getFirstName().length() < 5 || user.getFirstName().length() > 45){
            errors.rejectValue("firstName", "invalidFirstName");
        } else if (user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "firstNameEmpty");
        }

        if(user.getPhone().isEmpty()){
            errors.rejectValue("phone", "phoneEmpty");
        }else if(!user.getPhone().matches("^0[0-9]{9}[0-9]?$")){
            errors.rejectValue("phone", "invalidPhone");
        }

        if(user.getAge() == null){
            errors.rejectValue("age", "emptyAge");
        }else if(user.getAge() < 18){
            errors.rejectValue("age", "invalidAge");
        }

        if(user.getEmail().isEmpty()){
            errors.rejectValue("email", "emailEmpty");
        } else if(!user.getEmail().matches("^\\w+@\\w+(\\.[A-Za-z]+)+$")){
            errors.rejectValue("email", "invalidEmail");
        }
    }
}
