package com.jetpack.demo.vviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author VenRen
 * @time 2019-09-28  01:29
 * @desc
 */
class UserModel : ViewModel() {

    val profileData = MutableLiveData<UserInfo>()
    var userInfo: UserInfo? = null

    override fun onCleared() {
        super.onCleared()
        userInfo = null
    }

    fun fetchUserInfo() {
        if (userInfo == null) run {
            userInfo = UserInfo("花花公子", "23")
        }

        profileData.postValue(userInfo)
    }
}
