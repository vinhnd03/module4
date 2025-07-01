package com.vinhnd.validate_bai_hat.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto implements Validator {
    private Long id;
    private String name;
    private String singer;
    private String category;

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if(songDto.getName().isEmpty()){
            errors.rejectValue("name", null, "Tên bài hát không được để trống");
        } else if (songDto.getName().length() > 800) {
            errors.rejectValue("name", null, "Tên bài hát không được vượt quá 800 ký tự");
        } else if (songDto.getName().matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~`.,;:'\"\\\\/-].*")){
            errors.rejectValue("name", name, "Tên bài hát không được chứa kí tự đặc biệt");
        }

        if(songDto.getSinger().isEmpty()){
            errors.rejectValue("singer", null, "Tên ca sĩ không được để trống");
        } else if (songDto.getSinger().length() > 300) {
            errors.rejectValue("singer", null, "Tên ca sĩ không được vượt quá 800 ký tự");
        } else if (songDto.getSinger().matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~`.,;:'\"\\\\/-].*")){
            errors.rejectValue("singer", null, "Tên ca sĩ không được chứa kí tự đặc biệt");
        }

        if(songDto.getCategory().isEmpty()){
            errors.rejectValue("category", null, "Tên thể loại không được để trống");
        } else if (songDto.getCategory().length() > 1000) {
            errors.rejectValue("category", null, "Tên thể loại không được vượt quá 800 ký tự");
        } else if (songDto.getCategory().matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~`.;:'\"\\\\/-].*")){
            errors.rejectValue("category", null, "Tên thể loại không được chứa kí tự đặc biệt");
        }
    }
}