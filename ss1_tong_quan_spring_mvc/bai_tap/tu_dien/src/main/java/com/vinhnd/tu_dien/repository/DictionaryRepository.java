package com.vinhnd.tu_dien.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static Map<String, String> wordList = new LinkedHashMap<>();

    static {
        wordList.put("Hello", "Xin chào");
        wordList.put("What", "Cái gì");
        wordList.put("How", "Như thế nào");
        wordList.put("Why", "Tại sao");
        wordList.put("When", "Khi nào");
        wordList.put("Who", "Ai");
        wordList.put("Which", "Cái nào");
        wordList.put("Whose", "Của ai");
    }

    @Override
    public String findByWord(String word) {
        for(Map.Entry<String, String> entry : wordList.entrySet()){
            if(entry.getKey().equalsIgnoreCase(word)){
                return entry.getValue();
            }
        }
        return null;
    }
}
