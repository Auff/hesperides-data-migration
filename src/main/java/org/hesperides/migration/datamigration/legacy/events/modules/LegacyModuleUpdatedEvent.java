package org.hesperides.migration.datamigration.legacy.events.modules;

import com.google.gson.annotations.SerializedName;
import org.hesperides.domain.modules.ModuleTechnosUpdatedEvent;
import org.hesperides.domain.security.User;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.entities.LegacyModule;
import org.hesperides.migration.datamigration.legacy.events.LegacyInterface;

public class LegacyModuleUpdatedEvent implements LegacyInterface {

    @SerializedName("updated")
    LegacyModule module;


    @Override
    public TemplateContainer.Key getKey() {
        return module.getKey();
    }

    @Override
    public Object toDomainEvent(User user) {
        return new ModuleTechnosUpdatedEvent(getKey(), module.getTechno(), module.getVersionId(), user);
    }
}
