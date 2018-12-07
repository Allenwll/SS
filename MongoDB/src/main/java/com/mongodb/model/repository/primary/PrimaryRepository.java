package com.mongodb.model.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 功能:
 *
 * @date: 2018-10-16 10:37
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {
}
