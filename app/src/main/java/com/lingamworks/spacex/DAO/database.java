package com.lingamworks.spacex.DAO;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.lingamworks.spacex.Data.Crew;

@Database(entities = {Crew.class},version = 1)
@TypeConverters(Converters.class)
public abstract class database extends RoomDatabase {
    public abstract CrewDAO crewDAO();
}
