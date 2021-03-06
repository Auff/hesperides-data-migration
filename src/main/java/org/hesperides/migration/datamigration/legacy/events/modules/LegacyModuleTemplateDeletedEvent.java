package org.hesperides.migration.datamigration.legacy.events.modules;

import lombok.Value;
import org.hesperides.domain.modules.TemplateDeletedEvent;
import org.hesperides.domain.modules.entities.Module;
import org.hesperides.domain.security.User;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.hesperides.migration.datamigration.legacy.events.LegacyInterface;

@Value
public class LegacyModuleTemplateDeletedEvent implements LegacyInterface {
    public static final String EVENT_TYPE = "com.vsct.dt.hesperides.templating.modules.ModuleTemplateDeletedEvent";

    String moduleName;
    String moduleVersion;
    String templateName;


    @Override
    public TemplateContainer.Key getKey() {
        //le type est workingcopy, étant donnée qu'on ne peut supprimer un template d'une version released
        return new Module.Key(
                moduleName
                , moduleVersion,
                TemplateContainer.VersionType.workingcopy);
    }

    @Override
    public Object toDomainEvent(User user) {
        return new TemplateDeletedEvent(getKey(), templateName, user);
    }
}
