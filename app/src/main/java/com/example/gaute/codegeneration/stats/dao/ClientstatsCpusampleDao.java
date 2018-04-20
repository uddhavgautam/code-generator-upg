package com.example.gaute.codegeneration.stats.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.example.gaute.codegeneration.stats.entity.ClientstatsCpusampleEntity;

/**
 * ClientstatsCpusampleDao is responsible to provides all the Database Access related functionality.
 *
 * @author gaute
 */

@Dao
public interface ClientstatsCpusampleDao {

    /**
     * Counts the number of cpuSamples in the table.
     *
     * @return The number of CPUSamples.
     */
    @Query("SELECT COUNT(*) FROM cpusample_tbl")
    int count();

    /**
     * Inserts a clientClientstatsCpusampleEntity into the table.
     *
     * @param clientClientstatsCpusampleEntity A new ClientCPUSampleEntity.
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ClientstatsCpusampleEntity clientClientstatsCpusampleEntity);

    /**
     * Inserts multiple CPUSamples into the database
     *
     * @param cpuSampleEntities An array of new cpuSampleEntities.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ClientstatsCpusampleEntity[] cpuSampleEntities);

    /**
     * Select all CPUSamples.
     *
     * @return A {@link Cursor} of all the cpuSamples in the table.
     */
    @Query("SELECT COUNT(*) FROM cpusample_tbl")
    Cursor selectAll();

    /**
     * Select a ClientCPUSampleEntity by the timeStamp.
     *
     * @param timeStamp The row timeStamp.
     * @return A {@link Cursor} of the selected ClientCPUSampleEntity.
     */
    @Query("SELECT * FROM cpusample_tbl WHERE timeStamp = :timeStamp")
    Cursor selectById(String timeStamp);


    /**
     * Select a CPUSamples of intervals (two timeStamp values)
     *
     * @param timeStamp1 the fist timeStamp
     * @param timeStamp2 the second timeStamp
     * @return A list of {@link Cursor}
     */
    @Query("SELECT * FROM cpusample_tbl WHERE timeStamp >= :timeStamp1 AND  timeStamp >= :timeStamp2")
    Cursor selectFromInterval(String timeStamp1, String timeStamp2);


    /**
     * Delete a ClientCPUSampleEntity by the timeStamp.
     *
     * @param timeStamp The row ID.
     * @return A number of ClientCPUSampleEntity deleted.
     */
    @Query("SELECT * FROM cpusample_tbl WHERE timeStamp = :timeStamp")
    int deleteById(String timeStamp);

    /**
     * Delete a all records from the ClientCPUSampleEntity table.
     *
     * @return A number of CPUSamples deleted.
     */
    @Query("DELETE FROM cpusample_tbl")
    int deleteEverything();

    /**
     * Update the ClientCPUSampleEntity. The ClientCPUSampleEntity is identified by the row timeStamp.
     *
     * @param clientClientstatsCpusampleEntity The ClientCPUSampleEntity to update.
     * @return A number of CPUSamples updated.
     */
    @Update
    int update(ClientstatsCpusampleEntity clientClientstatsCpusampleEntity);


}
