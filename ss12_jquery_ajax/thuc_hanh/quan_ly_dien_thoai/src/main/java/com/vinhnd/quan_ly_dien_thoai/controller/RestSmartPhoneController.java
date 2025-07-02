package com.vinhnd.quan_ly_dien_thoai.controller;

import com.vinhnd.quan_ly_dien_thoai.entity.SmartPhone;
import com.vinhnd.quan_ly_dien_thoai.service.ISmartPhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/smartphones")
public class RestSmartPhoneController {
    private final ISmartPhoneService smartPhoneService;

    public RestSmartPhoneController(ISmartPhoneService smartPhoneService) {
        this.smartPhoneService = smartPhoneService;
    }

    @PostMapping
    public ResponseEntity<SmartPhone> create(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SmartPhone>> list(){
        List<SmartPhone> smartPhones = smartPhoneService.findAll();
        if(smartPhones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> delete(@PathVariable("id") Long id){
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if(!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.NO_CONTENT);
    }
}
