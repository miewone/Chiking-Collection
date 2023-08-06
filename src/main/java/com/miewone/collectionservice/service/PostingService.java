package com.miewone.collectionservice.service;

import com.miewone.collectionservice.Posting;
import com.miewone.collectionservice.repository.PostingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wgPark on 2023-08-05.
 */
@Service
@AllArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    @Transactional(readOnly = true)
    public Optional<Posting> findById(Long postingId) {
        checkNotNull(postingId, "postingId must be provided");

        return postingRepository.findById(postingId);
    }

}
