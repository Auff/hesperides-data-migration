package org.hesperides.migration.datamigration.legacy.entities;

import com.google.gson.annotations.SerializedName;
import lombok.Value;
import org.hesperides.domain.technos.entities.Techno;
import org.hesperides.domain.templatecontainers.entities.Template;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;

@Value
public class LegacyTemplate {
    String name;
    String filename;
    String location;
    String content;
    String namespace;
    Template.Rights rights;

    @SerializedName("version_id")
    Long versionId;

    public Template toDomainTemplate(TemplateContainer.Key key) {
        if (rights == null) {
            Template.Rights rights = getNullRights();
            return new Template(name, filename, location, content, rights, versionId, key);

        }
        return new Template(name, filename, location, content, rights, versionId, key);
    }

    public TemplateContainer.Key getKeyFromNamespace() {
        String[] temp = namespace.split("#");
        TemplateContainer.Key key = new Techno.Key(temp[1], temp[2],
                "WORKINGCOPY".equals(temp[3]) ? TemplateContainer.VersionType.workingcopy : TemplateContainer.VersionType.release);
        return key;
    }

    public Template.Rights getNullRights() {
        return new Template.Rights(new Template.FileRights(null, null, null), new Template.FileRights(null, null, null), new Template.FileRights(null, null, null));
    }
}