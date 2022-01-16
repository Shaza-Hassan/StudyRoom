package com.shaza.studyroom

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndCarAndPosts(
    @Embedded val user: User,
    @Relation(
        parentColumn = "uid",
        entityColumn = "carOwnerId"
    )
    val car: Car,

    @Relation(
        parentColumn = "uid",
        entityColumn = "postCreatorId"
    )
    val posts: List<Post>
)
