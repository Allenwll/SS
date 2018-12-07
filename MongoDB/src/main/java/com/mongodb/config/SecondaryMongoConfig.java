package com.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 功能:
 *
 * @date: 2018-10-16 10:33
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Configuration
@EnableMongoRepositories(basePackages = "com.mongodb.model.repository.secondary",
    mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
