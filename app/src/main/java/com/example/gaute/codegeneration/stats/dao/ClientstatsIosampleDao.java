package com.example.gaute.codegeneration.stats.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.example.gaute.codegeneration.stats.entity.ClientstatsIosampleEntity;

/**
 * ClientstatsIosampleDao is responsible to provides all the Database Access related functionality.
 *
 * @author gaute
 */

@Dao
public interface ClientstatsIosampleDao {

    /**
     * Counts the number of ioSamples in the table.
     *
     * @return The number of IOSamples.
     */
    @Query("SELECT COUNT(*) FROM iosample_tbl")
    int count();

    /**
     * Inserts a clientstatsIosampleEntity into the table.
     *
     * @param clientstatsIosampleEntity A new ClientstatsIosampleEntity.
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ClientstatsIosampleEntity clientstatsIosampleEntity);

    /**
     * Inserts multiple IOSamples into the database
     *
     * @param ioSampleEntities An array of new ioSampleEntities.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ClientstatsIosampleEntity[] ioSampleEntities);

    /**
     * Select all IOSamples.
     *
     * @return A {@link Cursor} of all the ioSamples in the table.
     */
    @Query("SELECT * FROM iosample_tbl")
    Cursor selectAll();

    /**
     * Select a ClientstatsIosampleEntity by the timeStamp.
     *
     * @param timeStamp The row timeStamp.
     * @return A {@link Cursor} of the selected ClientstatsIosampleEntity.
     */
    @Query("SELECT * FROM iosample_tbl WHERE timeStamp = :timeStamp")
    Cursor selectById(String timeStamp);


    /**
     * Select a IOSamples of intervals (two timeStamp values)
     *
     * @param timeStamp1 the fist timeStamp
     * @param timeStamp2 the second timeStamp
     * @return A list of {@link Cursor}
     */
    @Query("SELECT * FROM iosample_tbl WHERE timeStamp >= :timeStamp1 AND  timeStamp >= :timeStamp2")
    Cursor selectFromInterval(String timeStamp1, String timeStamp2);


    /**
     * Delete a ClientstatsIosampleEntity by the timeStamp.
     *
     * @param timeStamp The row ID.
     * @return A number of ClientstatsIosampleEntity deleted.
     */
    @Query("SELECT * FROM iosample_tbl WHERE timeStamp = :timeStamp")
    int deleteById(String timeStamp);

    /**
     * Delete a all records from the ClientstatsIosampleEntity table.
     *
     * @return A number of IOSamples deleted.
     */
    @Query("DELETE FROM iosample_tbl")
    int deleteEverything();

    /**
     * Update the ClientstatsIosampleEntity. The ClientstatsIosampleEntity is identified by the row timeStamp.
     *
     * @param clientstatsIosampleEntity The ClientstatsIosampleEntity to update.
     * @return A number of IOSamples updated.
     */
    @Update
    int update(ClientstatsIosampleEntity clientstatsIosampleEntity);


}
