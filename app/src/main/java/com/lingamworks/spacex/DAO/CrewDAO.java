package com.lingamworks.spacex.DAO;

import androidx.annotation.WorkerThread;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverter;

import com.lingamworks.spacex.Data.Crew;

import java.util.List;

@Dao
public interface CrewDAO {
    @Insert
    @TypeConverter
    void insertAll(Crew crews);
    @Query("DELETE FROM crew")
    void clearCrew();
    @Query("select * from crew")
    List<Crew> getcrew();
}
