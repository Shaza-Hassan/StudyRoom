package com.shaza.studyroom

import androidx.room.*
import com.shaza.studyroom.converter.UserForConverter
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Query("SELECT * FROM userforconverter")
    fun getAll(): Flow<List<UserForConverter>>

    @Query("SELECT * FROM userforconverter")
    fun getAllUsers(): List<UserForConverter>

    @Query("SELECT * FROM userforconverter WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserForConverter>

    @Query("SELECT * FROM userforconverter WHERE firstName LIKE :first AND " +
            "lastName LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserForConverter

    @Insert
    suspend fun insertAll(vararg users: UserForConverter)

//    @Insert
//    suspend fun insertCar(car: Car)
//
//    @Insert
//    suspend fun insertPosts(vararg posts:Post)
//
//    @Transaction
//    @Query("SELECT * FROM user where uid = 1")
//    fun getAllData() : Flow<UserAndCarAndPosts>

    @Delete
    fun delete(user: UserForConverter)
}