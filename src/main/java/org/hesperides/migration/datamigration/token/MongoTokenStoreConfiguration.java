package org.hesperides.migration.datamigration.token;//package org.hesperides.batch.token;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;

@Component
@Getter
@Setter
@Validated
@ConfigurationProperties("projection_repository")
//@PropertySource("classpath:org/hesperides/application-mongoClient.yml")
public class MongoTokenStoreConfiguration {
    @NotNull
    private String host;
    @NotNull
    private String port;
    private String database;
    private String username;
    private String password;

    @Bean
    @Qualifier("token")
    public Mongo mongoClient() {
        if (username.isEmpty()) {
            return new MongoClient(new ServerAddress(host, Integer.parseInt(port)), Collections.singletonList(MongoCredential.createCredential(username, database, password.toCharArray())));
        } else {
            return new MongoClient(host, Integer.parseInt(port));
        }
    }

    @Bean()
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }


}
