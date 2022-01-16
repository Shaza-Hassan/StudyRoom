package com.shaza.studyroom.converter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserForConverter(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    val firstName: String?,
    val lastName: String?,
    val carConverter: CarConverter,
    val posts:List<PostConverter>
)
