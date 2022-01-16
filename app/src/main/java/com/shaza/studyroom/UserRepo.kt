package com.shaza.studyroom

import com.shaza.studyroom.converter.UserForConverter
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val userDao: UserDao
){

    fun getAllUsers() = userDao.getAll()

    fun getAllUser() = userDao.getAllUser()

    fun getAllData() = userDao.getAllData()

    suspend fun addUsers(vararg users:UserForConverter) {
        userDao.insertAll(*users)
    }

    suspend fun addUser( users:User) {
        userDao.insertUser(users)
    }

    suspend fun addCar(car: Car){
        userDao.insertCar(car)
    }

    suspend fun addPosts(vararg posts:Post){
        userDao.insertPosts(*posts)
    }
}