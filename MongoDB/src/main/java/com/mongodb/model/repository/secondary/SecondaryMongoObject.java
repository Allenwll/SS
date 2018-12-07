package com.mongodb.model.repository.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 功能:
 *
 * @date: 2018-10-16 10:40
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "second_mongo")
public class SecondaryMongoObject {
    @Id
    private String id;
    
    private String value;
    
    public SecondaryMongoObject(final String id, final String value) {
        this.id = id;
        this.value = value;
    }
    @Override
    public String toString() {
        return "SecondaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
               + '}';
    }
}
