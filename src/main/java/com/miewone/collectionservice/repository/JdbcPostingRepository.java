package com.miewone.collectionservice.repository;

import com.miewone.collectionservice.Posting;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.miewone.collectionservice.utils.DateTimeUtils.dateTimeOf;

/**
 * Created by wgPark on 2023-08-06.
 */

@Repository
public class JdbcPostingRepository implements PostingRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcPostingRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Optional<Posting> findById(long id) {
        List<Posting> results = jdbcTemplate.query(
                "SELECT * FROM POSTINGS WHERE SEQ=?",
                mapper,
                id
        );

        return Optional.empty();
    }

    @Override
    public List<Posting> findAll() {
        return null;
    }

    static RowMapper<Posting> mapper = (rs, rowNum) ->
            new Posting.builder()
                    .seq(rs.getLong("seq"))
                    .name(rs.getString("name"))
                    .details(rs.getString("details"))
                    .reviewCount(rs.getInt("review_count"))
                    .createAt(dateTimeOf(rs.getTimestamp("create_at")))
                    .build();
}
