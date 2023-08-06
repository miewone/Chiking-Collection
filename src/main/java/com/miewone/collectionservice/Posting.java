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
@Builder
public class Posting {

    private Long seq;

    private String name;

    private String description;

    private String url;

    private String schedule;

    private LocalDateTime createAt;


}
