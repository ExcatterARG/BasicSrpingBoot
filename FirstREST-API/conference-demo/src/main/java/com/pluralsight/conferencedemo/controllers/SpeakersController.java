package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    private Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker session){
        return speakerRepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //Todo: Add the logic for deleting children records
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker){
        //Todo: Make the corresponding validations
        Speaker existingSpreaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpreaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpreaker);
    }
}
