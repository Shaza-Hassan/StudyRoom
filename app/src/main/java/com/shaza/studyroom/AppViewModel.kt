package com.shaza.studyroom

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shaza.studyroom.converter.CarConverter
import com.shaza.studyroom.converter.PostConverter
import com.shaza.studyroom.converter.UserForConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    application:Application,
    private val userRepo: UserRepo
) : AndroidViewModel(application) {
    private val tag = this::class.java.simpleName
    val users = MutableLiveData<UserAndCarAndPosts>()
    val userAllData = MutableLiveData<UserForConverter>()

    fun listenToUsers(){
        viewModelScope.launch {
            userRepo.getAllUser()
                .catch {
                    Log.e(tag,it.localizedMessage)
                }
                .collect {
                    userAllData.postValue(it)
                }
        }
    }

    fun getAllData(){
        viewModelScope.launch {
            userRepo.getAllData().catch {
                Log.e(tag,it.localizedMessage)
            }.collect {
                users.postValue(it)
            }
        }
    }

    fun addUsers(){
        val user1 = UserForConverter(firstName = "Shaza 1", lastName = "Hassan"
        , carConverter = CarConverter("Suzuki","Red"),
            posts = listOf(
                PostConverter("content 1"),
                PostConverter("content 2"),
                PostConverter("content 3"),
                PostConverter("content 4"),
                PostConverter("content 5"),
            )
        )
        val user2 = UserForConverter(firstName = "Shaza 2" , lastName = "Hassan"
            , carConverter = CarConverter("Suzuki","Red"),
            posts = listOf(
                PostConverter("content 1"),
                PostConverter("content 2"),
                PostConverter("content 3"),
                PostConverter("content 4"),
                PostConverter("content 5"),
            ))
        val user3 = UserForConverter(firstName = "Shaza 3", lastName = "Hassan"
            , carConverter = CarConverter("Suzuki","Red"),
            posts = listOf(
                PostConverter("content 1"),
                PostConverter("content 2"),
                PostConverter("content 3"),
                PostConverter("content 4"),
                PostConverter("content 5"),
            ))
        val user4 = UserForConverter(firstName = "Shaza 4", lastName = "Hassan"
            , carConverter = CarConverter("Suzuki","Red"),
            posts = listOf(
                PostConverter("content 1"),
                PostConverter("content 2"),
                PostConverter("content 3"),
                PostConverter("content 4"),
                PostConverter("content 5"),
            ))
        val user5 = UserForConverter(firstName = "Shaza 5", lastName = "Hassan"
            , carConverter = CarConverter("Suzuki","Red"),
            posts = listOf(
                PostConverter("content 1"),
                PostConverter("content 2"),
                PostConverter("content 3"),
                PostConverter("content 4"),
                PostConverter("content 5"),
            ))

        viewModelScope.launch {
            userRepo.addUsers(user1,user2,user3,user4,user5)
        }
    }

    fun addUser(){
        val user = User(
            firstName = "First",
            lastName = "Last"
        )
        viewModelScope.launch {
            userRepo.addUser(user)
        }
    }

    fun addCar(){
        val car = Car(carOwnerId = 1, carName = "Suzuki")
        viewModelScope.launch {
            userRepo.addCar(car)
        }
    }

    fun addPosts(){
        val post1 = Post(postCreatorId = 1, postContent = "ay kalam 1")
        val post2 = Post(postCreatorId = 1, postContent = "ay kalam 2")
        val post3 = Post(postCreatorId = 1, postContent = "ay kalam 3")
        val post4 = Post(postCreatorId = 1, postContent = "ay kalam 4")
        val post5 = Post(postCreatorId = 1, postContent = "ay kalam 5")
        val post6 = Post(postCreatorId = 1, postContent = "ay kalam 6")
        val post7 = Post(postCreatorId = 1, postContent = "ay kalam 7")
        val post8 = Post(postCreatorId = 1, postContent = "ay kalam 8")
        val post9 = Post(postCreatorId = 1, postContent = "ay kalam 9")
        viewModelScope.launch {
            userRepo.addPosts(post1,post2,post3,post4,post5,post6,post7,post8,post9)
        }
    }
}