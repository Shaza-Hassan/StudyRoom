package com.shaza.studyroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey (autoGenerate = true) var carId:Int = 0,
    val carOwnerId: Int,
    val carName:String,
)
