package org.hesperides.migration.datamigration.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoTokenRepository extends MongoRepository<Token, String> {

    List<Token> findAllByStatus(int status);

    List<Token> findAllByType(String type);

    Token findByKey(String key);

    //    List<Token>findAllByTypeAndByStatus(String type,int status);
    List<Token> findAllByTypeAndStatus(String type, int status);

    List<Token> findAllByTypeAndStatusNot(String type, int status);
}
