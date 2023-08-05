package com.miewone.collectionservice;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by wgPark on 2023-08-06.
 */

@Data
@ToString
@EqualsAndHashCode
public class Posting {

    private final Long seq;

    private String name;

    private String description;

    private String url;

    private String schedule;

    private LocalDateTime createAt;


    @lombok.Builder
    @Data
    static public class PostingBuilder {
        private Long seq;
        private String name;
        private String description;
        private int reviewCount;
        private LocalDateTime createAt;

        public PostingBuilder() {/*empty*/}


    }
}
