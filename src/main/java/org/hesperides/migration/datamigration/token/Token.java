package org.hesperides.migration.datamigration.token;

import lombok.Data;
import org.hesperides.domain.templatecontainers.entities.TemplateContainer;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "token")
public class Token {

    public static final int WIP = 0;
    public static final int OK = 1;
    public static final int DELETED = 2;
    public static final int KO = 3;
    public static final int MODULE_ERRORED = 4;
    public static final int PROPERTIES_DIFFERENCE = 5;
    public static final int ITERABLE_PROPERTIES_DIFFERENCE = 6;

    @Id
    private String key;
    private String type;
    private int status;
    private int legacyEventCount;
    private int refonteEventCount;
    @Nullable
    private TemplateContainer.Key refonteKey;

    public Token(String key, String type) {
        this.key = key;
        this.type = type;
        this.legacyEventCount = 0;
        this.refonteEventCount = 0;
        this.status = WIP;
    }

//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public void setRefonteEventCount(int refonteEventCount) {
//        this.refonteEventCount = refonteEventCount;
//    }
//
//    public void setLegacyEventCount(int legacyEventCount){
//        this.legacyEventCount =legacyEventCount;
//        setStatus(0);
//    }


}
