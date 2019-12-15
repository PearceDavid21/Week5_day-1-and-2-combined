package com.example.wk5_day1_2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Hotel")
class HotelEntity(
        @PrimaryKey(autoGenerate = true) var HotelId: Int?,
        @ColumnInfo(name = "RoomNumber") val roomNumber: String,
        @ColumnInfo(name = "Guest") val guestName: String

) {
    constructor(roomNumber: String, guestName: String) : this(null, roomNumber, guestName)
}

