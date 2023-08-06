package com.miewone.collectionservice.controller;

import com.miewone.collectionservice.Posting;
import com.miewone.collectionservice.dto.PostingDto;
import com.miewone.collectionservice.errors.NotFoundException;
import com.miewone.collectionservice.service.PostingService;
import com.miewone.collectionservice.utils.ApiUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.miewone.collectionservice.utils.ApiUtils.success;
import static com.miewone.collectionservice.utils.ApiUtils.ApiResult;

@RestController
@RequestMapping("/platform")
public class PostingPlatformController {
    private final PostingService postingService;

    public PostingPlatformController(PostingService postingService){
        this.postingService = postingService;
    }

    @GetMapping(path = "{id}")
    public ApiResult<PostingDto> findById(@PathVariable Long id) {
        return success(postingService.findById(id)
                .map(PostingDto::new)
                .orElseThrow(()-> new NotFoundException("Could not found posting for " + id)));
    }

    @GetMapping("/all")
    public ApiResult<List<PostingDto>> findAll() {
        return success(postingService.findAll());
    }
}
