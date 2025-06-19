package com.vinhnd.hom_thu_dien_tu.repository;

import com.vinhnd.hom_thu_dien_tu.entity.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository{
    private static List<Email> emails;

    static {
        emails = new ArrayList<>();
    }


    @Override
    public List<Email> findAll() {
        return emails;
    }

    @Override
    public void add(Email email) {
        emails.add(email);
    }

    @Override
    public Email findById(int id) {
        for(Email email : emails){
            if(email.getId() == id){
                return email;
            }
        }
        return null;
    }

    @Override
    public void edit(Email email) {
        for(int i = 0; i < emails.size(); i++){
            if(emails.get(i).getId() == email.getId()){
                emails.set(i, email);
                return;
            }
        }
    }
}
