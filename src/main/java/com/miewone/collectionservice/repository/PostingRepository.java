package com.miewone.collectionservice.repository;

import com.miewone.collectionservice.Posting;

import java.util.List;
import java.util.Optional;

/**
 * Created by wgPark on 2023-08-05.
 */
public interface PostingRepository {
    Optional<Posting> findById(long id);
    List<Posting> findAll();
}
