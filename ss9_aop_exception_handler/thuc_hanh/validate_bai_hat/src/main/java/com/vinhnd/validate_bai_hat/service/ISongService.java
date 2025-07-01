package com.vinhnd.validate_bai_hat.service;

import com.vinhnd.validate_bai_hat.entity.Song;
import com.vinhnd.validate_bai_hat.exception.DuplicateSongNameException;

import java.util.List;

public interface ISongService {
    List<Song> findAll() throws Exception;

    void save(Song song) throws DuplicateSongNameException;

    Song findById(Long id) throws Exception;
}
