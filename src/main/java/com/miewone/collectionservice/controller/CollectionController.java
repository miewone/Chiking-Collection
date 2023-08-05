package com.miewone.collectionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgPark on 2023-08-05.
 */
@RestController
@RequestMapping("/")
public class CollectionController {

    @GetMapping("/health_check")
    public Integer status(){
        return 200;
    }
}
