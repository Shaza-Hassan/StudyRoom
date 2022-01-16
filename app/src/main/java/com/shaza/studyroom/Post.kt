package com.shaza.studyroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true) var postId:Int = 0,
    var postCreatorId : Long,
    var postContent: String
)
