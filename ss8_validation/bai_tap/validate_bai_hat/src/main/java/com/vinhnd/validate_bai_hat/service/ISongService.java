package com.vinhnd.validate_bai_hat.service;

import com.vinhnd.validate_bai_hat.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Long id);
}
