package org.hesperides.migration.datamigration.legacy.events.modules;

import com.google.gson.annotations.SerializedName;
import lombok.Value;
import org.hesperides.domain.modules.ModuleCreatedEvent;
import org.hesperides.domain.security.User;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.entities.LegacyModule;
import org.hesperides.migration.datamigration.legacy.entities.LegacyTemplate;
import org.hesperides.migration.datamigration.legacy.events.LegacyInterface;

import java.util.List;

@Value
//@EqualsAndHashCode(callSuper = true)
public class LegacyModuleCreatedEvent implements LegacyInterface {
    public static final String EVENT_TYPE = "com.vsct.dt.hesperides.templating.modules.ModuleCreatedEvent";

    @SerializedName("moduleCreated")
    LegacyModule module;


    List<LegacyTemplate> templates;


    @Override
    public TemplateContainer.Key getKey() {
        return (module.getKey());
    }

    @Override
    public Object toDomainEvent(User user) {
        return new ModuleCreatedEvent(module.toDomainModule(templates), user);
    }

}
