package com.vinhnd.validate_bai_hat.controller;

import com.vinhnd.validate_bai_hat.dto.SongDto;
import com.vinhnd.validate_bai_hat.entity.Song;
import com.vinhnd.validate_bai_hat.exception.DuplicateSongNameException;
import com.vinhnd.validate_bai_hat.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    private final ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String list(Model model){
//        List<SongDto> songDtos = new ArrayList<>();
        try {
            model.addAttribute("songList", songService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "song/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("song", new SongDto());
        return "song/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("song") SongDto songDto, BindingResult result) throws DuplicateSongNameException {
        new SongDto().validate(songDto, result);
        if(result.hasErrors()){
            return "song/form";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Song song;
        try {
            song = songService.findById(id);
            model.addAttribute("song", song);
            model.addAttribute("isEdit", true);
            return "song/form";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/song";
        }
    }



    @ExceptionHandler(DuplicateSongNameException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/inputs-not-acceptable");
    }
}
