package org.hesperides.migration.datamigration.service;

import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.entities.LegacyEvent;
import org.hesperides.migration.datamigration.token.MongoTokenRepository;
import org.hesperides.migration.datamigration.token.Token;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class PlatformMigrationService extends AbstractMigrationService {
    static {
        //TODO : être sur de cet aggregat
        AGGREGATE_TYPE = "PlatformAggregate";
        LEGACY_EVENTS_DICTIONARY = new HashMap<>();


    }

    public PlatformMigrationService(RestTemplate restTemplate, ListOperations<String, LegacyEvent> listOperations, MongoTokenRepository mongoTokenRepository, String legacyURI, String refonteURI) {
        super(restTemplate, listOperations, mongoTokenRepository, legacyURI, refonteURI);
    }


    @Override
    void verify(TemplateContainer.Key key) {

    }

    @Override
    protected void checkIfDeleted(Token token) {

    }
}
