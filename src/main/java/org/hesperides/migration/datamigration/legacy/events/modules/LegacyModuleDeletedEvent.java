package org.hesperides.migration.datamigration.legacy.events.modules;

import lombok.Value;
import org.hesperides.domain.modules.ModuleDeletedEvent;
import org.hesperides.domain.modules.entities.Module;
import org.hesperides.domain.security.User;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.events.LegacyInterface;

@Value
public class LegacyModuleDeletedEvent implements LegacyInterface {
    public static final String EVENT_TYPE = "com.vsct.dt.hesperides.templating.modules.ModuleDeletedEvent";

    String moduleName;
    String moduleVersion;
    boolean workingCopy;

    @Override
    public TemplateContainer.Key getKey() {
        return new Module.Key(
                moduleName,
                moduleVersion,
                workingCopy ? TemplateContainer.VersionType.workingcopy : TemplateContainer.VersionType.release);
    }

    @Override
    public Object toDomainEvent(User user) {
        return new ModuleDeletedEvent(getKey(), user);
    }
}
