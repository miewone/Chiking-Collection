package com.miewone.collectionservice.repository;

import com.miewone.collectionservice.Posting;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.miewone.collectionservice.utils.DateTimeUtils.dateTimeOf;
import static java.util.Optional.ofNullable;

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
                "SELECT * FROM postings WHERE SEQ=?",
                mapper,
                id
        );

        return ofNullable(results.isEmpty() ? null : results.get(0));

    }

    @Override
    public List<Posting> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM postings",
                mapper
        );
    }

    static RowMapper<Posting> mapper = (rs, rowNum) ->
            Posting.builder()
                    .seq(rs.getLong("seq"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .url(rs.getString("url"))
                    .schedule(rs.getString("schedule"))
                    .createAt(dateTimeOf(rs.getTimestamp("createAt")))
                    .build();
}
