package com.example.gaute.codegeneration.stats.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Clientstats represents clientstats_db database name
 * Iosample represents iosample_tbl table name
 * Entity represents this class should be Entity class
 *
 * @author gaute
 */
@Entity(tableName = "iosample_tbl")
public class ClientstatsIosampleEntity {

    @PrimaryKey
    @NonNull
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String timeStamp;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String readBytes;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String writeBytes;

    public ClientstatsIosampleEntity() {
    }

    @Ignore
    public ClientstatsIosampleEntity(String timeStamp, String readBytes, String writeBytes) {
        this.timeStamp = timeStamp; //primary key
        this.readBytes = readBytes;
        this.writeBytes = writeBytes;
    }
}
