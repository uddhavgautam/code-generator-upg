package com.example.gaute.codegeneration.stats;

import android.content.Context;

import com.example.gaute.codegeneration.CodeGenApplication;
import com.example.gaute.codegeneration.stats.dao.ClientstatsCpusampleDao;
import com.example.gaute.codegeneration.stats.dao.ClientstatsIosampleDao;
import com.example.gaute.codegeneration.stats.entity.ClientstatsCpusampleEntity;
import com.example.gaute.codegeneration.stats.entity.ClientstatsIosampleEntity;

import javax.inject.Inject;

/**
 * ClientStatsCollector, which is a normal thread, is used to both cpu samples and io samples.
 * To collect cpu samples, ClientCPUSampleEntity model class is used.
 * To collect io samples, ClientstatsIosampleEntity model class is used.
 * <p>
 * Since, ClientStatsCollector stores the collected data in database, and database operation
 * is expensive, we should use separate worker thread for all database related transactions.
 * This is why, ClientStatsCollector is a Thread.
 *
 * @author gaute
 */
public class ClientStatsCollector extends Thread {

    @Inject
    CodeGenApplication context;

    private ClientstatsDb clientstatsDb;

    public ClientStatsCollector() {
        clientstatsDb = ClientstatsDb.create((Context) context, false);
    }

    @Override
    public void run() {
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateCPUSampleTable(String timeStamp, String userTime, String systemTime, String cpuUsage) {
        ClientstatsCpusampleDao clientstatsCpusampleDao = clientstatsDb.cpuSampleDAO();
        ClientstatsCpusampleEntity clientstatsCpusampleEntity = new ClientstatsCpusampleEntity(timeStamp, userTime, systemTime, cpuUsage);
        clientstatsCpusampleDao.insert(clientstatsCpusampleEntity);
    }

    private void updateIOSampleTable(String timeStamp, String readBytes, String writeBytes) {
        ClientstatsIosampleDao clientstatsIosampleDao = clientstatsDb.ioSampleDAO();
        ClientstatsIosampleEntity clientstatsIosampleEntity = new ClientstatsIosampleEntity(timeStamp, readBytes, writeBytes);
        clientstatsIosampleDao.insert(clientstatsIosampleEntity);
    }
}
