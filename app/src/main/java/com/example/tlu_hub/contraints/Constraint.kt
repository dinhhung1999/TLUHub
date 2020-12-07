package com.example.tlu_hub.contraints

import com.example.tlu_hub.model.category.Category
import com.example.tlu_hub.model.student.Student
import com.example.tlu_hub.model.userData.UserData
import java.util.*
import kotlin.collections.ArrayList

class Constraint {
    interface API_STATUS {
        companion object {
            const val SUCCESS = "success"
            const val ERROR = "error"
            var isLogin : Boolean = false
        }
    }
    companion object {
        var account: UserData? = null
        var codeUser = String()
        var userData = ArrayList<Student>()
        var new = ArrayList<Category>()
    }

}