package com.mongodb.config.props;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 功能:
 *
 * @date: 2018-10-16 10:34
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {
    private MongoProperties primary = new MongoProperties();
    private MongoProperties secondary = new MongoProperties();
    
    public MongoProperties getPrimary() {
        return primary;
    }
    
    public void setPrimary(final MongoProperties primary) {
        this.primary = primary;
    }
    
    public MongoProperties getSecondary() {
        return secondary;
    }
    
    public void setSecondary(final MongoProperties secondary) {
        this.secondary = secondary;
    }
}
