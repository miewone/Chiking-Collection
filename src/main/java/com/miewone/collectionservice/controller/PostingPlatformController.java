package com.miewone.collectionservice.controller;

import com.miewone.collectionservice.Posting;
import com.miewone.collectionservice.dto.PostingDto;
import com.miewone.collectionservice.errors.NotFoundException;
import com.miewone.collectionservice.service.PostingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PostingPlatformController {
    private final PostingService postingService;

    public PostingPlatformController(PostingService postingService){
        this.postingService = postingService;
    }

    @GetMapping(path = "{id}")
    public Posting findById(@PathVariable Long id) {
        postingService.findById(id)
                .map(PostingDto::new)
                .orElseThrow(()-> new NotFoundException("Could not found product for " + id));
    }
}
