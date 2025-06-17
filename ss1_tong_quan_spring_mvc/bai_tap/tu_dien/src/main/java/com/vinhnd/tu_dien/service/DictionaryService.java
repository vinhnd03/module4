package com.vinhnd.tu_dien.service;

import com.vinhnd.tu_dien.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    public IDictionaryRepository repository;


    @Override
    public String findByWord(String word) {
        return repository.findByWord(word);
    }
}
