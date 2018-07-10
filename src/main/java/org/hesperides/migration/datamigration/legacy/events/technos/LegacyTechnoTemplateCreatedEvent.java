package org.hesperides.migration.datamigration.legacy.events.technos;

import com.google.gson.annotations.SerializedName;
import org.hesperides.domain.security.User;
import org.hesperides.domain.technos.TemplateAddedToTechnoEvent;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.entities.LegacyTemplate;
import org.hesperides.migration.datamigration.legacy.events.LegacyInterface;

public class LegacyTechnoTemplateCreatedEvent implements LegacyInterface {

    @SerializedName("created")
    LegacyTemplate legacyTemplate;

    @Override
    public TemplateContainer.Key getKey() {
        return legacyTemplate.getKeyFromNamespace();
    }

    @Override
    public Object toDomainEvent(User user) {
        TemplateContainer.Key key = getKey();
        return new TemplateAddedToTechnoEvent(key, legacyTemplate.toDomainTemplate(key), user);
    }
}
