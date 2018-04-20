package com.example.gaute.codegeneration.stats;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.example.gaute.codegeneration.stats.dao.ClientstatsCpusampleDao;
import com.example.gaute.codegeneration.stats.dao.ClientstatsIosampleDao;
import com.example.gaute.codegeneration.stats.entity.ClientstatsCpusampleEntity;
import com.example.gaute.codegeneration.stats.entity.ClientstatsIosampleEntity;

/**
 * This class is responsible to provide database for both ClientCPUSampleEntity and ClientstatsIosampleEntity
 * Note: You should follow the singleton design pattern when instantiating an ClientstatsDb object,
 * as each RoomDatabase instance is fairly expensive, and you rarely need access to multiple instances.
 *
 * @author gaute
 */


@Database(entities = {ClientstatsCpusampleEntity.class, ClientstatsIosampleEntity.class}, version = 1)
public abstract class ClientstatsDb extends RoomDatabase {

    @VisibleForTesting
    private static final String DATABASE_NAME = "clientstats_db";
    private static ClientstatsDb clientstatsDb;

    /**
     * Gets the singleton instance of ClientstatsDb. It also provides functionality to return in-memory database.
     *
     * @param context
     * @param memoryOnly The boolean to check if database is memory only
     * @return The singleton instance of ClientstatsDb
     */
    public static synchronized ClientstatsDb create(Context context, final boolean memoryOnly) {
        if (clientstatsDb == null) {
            clientstatsDb = memoryOnly
                    ?
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), ClientstatsDb.class)
                            .build()
                    :
                    Room.databaseBuilder(context.getApplicationContext(), ClientstatsDb.class, DATABASE_NAME)
                            .build();
        }
        return clientstatsDb;
    }

    /**
     * @return CPUSampleDao instance
     */
    public abstract ClientstatsCpusampleDao cpuSampleDAO();

    /**
     * @return ClientstatsIosampleDao instance
     */
    public abstract ClientstatsIosampleDao ioSampleDAO();
}
