package com.vinhnd.validate_bai_hat.service;

import com.vinhnd.validate_bai_hat.entity.Song;
import com.vinhnd.validate_bai_hat.repository.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    private final ISongRepository repository;

    public SongService(ISongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public Song findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
