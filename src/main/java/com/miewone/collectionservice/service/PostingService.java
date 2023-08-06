package com.miewone.collectionservice.service;

import com.miewone.collectionservice.Posting;
import com.miewone.collectionservice.dto.PostingDto;
import com.miewone.collectionservice.errors.NotFoundException;
import com.miewone.collectionservice.repository.PostingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.stream.Collectors.toList;

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

    @Transactional
    public List<PostingDto> findAll() {
        List<PostingDto> result = postingRepository.findAll()
                .stream()
                .map(PostingDto::new)
                .collect(toList());

        if (result.isEmpty()) {
            throw new NotFoundException("Empty Posting");
        }

        return result;

    }

}
