package com.example.wk5_day1_2.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HotelDAO {

    @Insert
    fun addNewRoom(HotelEntity: HotelEntity)

    @Query("SELECT * FROM Hotel")

    fun retrieveAllRooms(): List<HotelEntity>


    @Query("SELECT * FROM Hotel")
    fun retrieveAllGuests(): Cursor


}