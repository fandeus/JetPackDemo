package com.jetpack.demo.vviewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jetpack.demo.R

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val user: TextView = findViewById(R.id.user_name)
        val age: TextView = findViewById(R.id.user_ager)

        val userModel by lazy { ViewModelProviders.of(this).get(UserModel::class.java) }

        userModel.profileData.observe(this, Observer {
            it?.also {
                user.text = it.names
                age.text = it.age
            }
        })

        userModel.fetchUserInfo()
    }
}
