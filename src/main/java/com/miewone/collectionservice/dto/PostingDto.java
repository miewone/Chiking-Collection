package com.miewone.collectionservice.dto;

import com.miewone.collectionservice.Posting;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * Created by wgPark on 2023-08-05.
 */

@Getter
@Setter
@ToString
public class PostingDto {

    private Long seq;

    private String name;

    private String description;

    private String url;

    private String schedule;

    private LocalDateTime createAt;

    public PostingDto(Posting source) {
        copyProperties(source, this);

        this.description = source.getDescription(description).orElse(null);
    }
}
