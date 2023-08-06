package com.miewone.collectionservice;

import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;
import java.util.Optional;

import lombok.*;


import java.time.LocalDateTime;
import static java.util.Optional.ofNullable;
import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;

import static java.time.LocalDateTime.now;



/**
 * Created by wgPark on 2023-08-06.
 */

@Getter
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

    public Posting(Long seq, String name, String description, String url, String schedule, LocalDateTime createAt){

        setName(name);
        setDescription(description);
        setUrl(url);
        setSchedule(schedule);
        this.seq = seq;
        this.createAt = defaultIfNull(createAt, now());
    }

    public Optional<String> getDescription(String description){
        return ofNullable(description);
    }
    public void setName(String name) {
        checkArgument(isNotEmpty(name),"name must be provided");
        checkArgument(
                name.length() >= 1 && name.length() <= 50,
                "name length must be between 1 and 50 characters"
        );
        this.name = name;
    }

    public void setDescription(String description) {
        checkArgument(
                isEmpty(description) || description.length() <= 1000,
                "description length must be less than 1000 characters"
        );
        this.description = description;
    }

    public void setUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        checkArgument(
                isNotEmpty(url) && urlValidator.isValid(url),
                "Valid url must be provided"
        );
        this.url = url;
    }

    public void setSchedule(String schedule) {
        checkArgument(
                isValidCron(schedule),
                "Valid cron expression must be provided "
        );
        this.schedule = schedule;
    }



    private boolean isValidCron(String cronExpression) {
        if(StringUtils.isEmpty(cronExpression)){
            return false;
        }
        try {
            CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.UNIX);
            CronParser parser = new CronParser(cronDefinition);
            Cron cron = parser.parse(cronExpression);
            cron.validate();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
