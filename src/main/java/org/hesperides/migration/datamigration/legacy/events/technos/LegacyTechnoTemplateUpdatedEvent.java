package org.hesperides.migration.datamigration.legacy.events.technos;

import com.google.gson.annotations.SerializedName;
import org.hesperides.domain.security.User;
import org.hesperides.domain.technos.TechnoTemplateUpdatedEvent;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.entities.LegacyTemplate;
import org.hesperides.migration.datamigration.legacy.events.LegacyInterface;

public class LegacyTechnoTemplateUpdatedEvent implements LegacyInterface {
    @SerializedName("updated")
    LegacyTemplate legacyTemplate;

    @Override
    public TemplateContainer.Key getKey() {
        return legacyTemplate.getKeyFromNamespace();
    }

    @Override
    public Object toDomainEvent(User user) {
        TemplateContainer.Key key = getKey();
        return new TechnoTemplateUpdatedEvent(key, legacyTemplate.toDomainTemplate(key), user);
    }
}
