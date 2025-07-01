package com.vinhnd.validate_bai_hat.service;

import com.vinhnd.validate_bai_hat.entity.Song;
import com.vinhnd.validate_bai_hat.exception.DuplicateSongNameException;
import com.vinhnd.validate_bai_hat.repository.ISongRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    private final ISongRepository repository;

    public SongService(ISongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> findAll() throws Exception {
        if(false){
            throw new Exception("Thử nghiệm lỗi");
        }
        return repository.findAll();
    }

    @Override
    public void save(Song song) throws DuplicateSongNameException {
        try{
            repository.save(song);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateSongNameException("Tên bài hát bị trùng");
        }

    }

    @Override
    public Song findById(Long id) throws Exception {
        Song song = repository.findById(id).orElse(null);
        if(song == null){
            throw new Exception("customer not found!");
        }else {
            return song;
        }
    }
}
