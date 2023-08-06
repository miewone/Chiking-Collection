package com.miewone.collectionservice.controller;

import com.miewone.collectionservice.Posting;
import com.miewone.collectionservice.service.PostingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgPark on 2023-08-05.
 */
@RestController
@RequestMapping("/")
public class PostingController {


    @GetMapping("/health_check")
    public Integer status(){
        return 200;
    }


}
