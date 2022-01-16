package com.shaza.studyroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.users.observe(this,{
            findViewById<TextView>(R.id.textView).text = it.toString()
        })

        viewModel.userAllData.observe(this,{
            if (it != null)
                findViewById<TextView>(R.id.allData).text = it.toString()
        })
        viewModel.listenToUsers()
    }

    fun addUser(view: View) {
        viewModel.addUsers()
        viewModel.addUser()
    }

    fun addNewCar(view:View) {
        view.isEnabled = false
        viewModel.addCar()
    }
    fun addPosts(view: View) {
        viewModel.addPosts()
    }

    fun getData(view: View) {
        viewModel.getAllData()
    }
}