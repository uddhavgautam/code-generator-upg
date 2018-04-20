package com.example.gaute.codegeneration.stats.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Clientstats represents clientstats_db database name
 * Cpusample represents cpusample_tbl table name
 * Entity represents this class should be Entity class
 *
 * @author gaute
 */
@Entity(tableName = "cpusample_tbl")
public class ClientstatsCpusampleEntity {

    @PrimaryKey
    @NonNull
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String timeStamp;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String userTime;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String systemTime;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String cpuUsage;

    public ClientstatsCpusampleEntity() {
    }

    @Ignore
    public ClientstatsCpusampleEntity(String timeStamp, String userTime, String systemTime, String cpuUsage) {
        this.timeStamp = timeStamp;
        this.userTime = userTime;
        this.systemTime = systemTime;
        this.cpuUsage = cpuUsage;
    }
}
