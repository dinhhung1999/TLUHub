package com.example.tlu_hub.model.student

import com.google.gson.annotations.SerializedName

data class Student(
   @SerializedName("id")
   val id: Int,

   @SerializedName("major")
   val major: Major,

   @SerializedName("code_student")
   val code_student: String,

   @SerializedName("name_student")
   val name_student: String,

   @SerializedName("birthday_student")
   val birthday_student: String,

   @SerializedName("hometown_student")
   val hometown_student: String,

   @SerializedName("gender_student")
   val gender_student: String,

   @SerializedName("class")
   val Class: Class,

   @SerializedName("course")
   val course: course,

   @SerializedName("faculty")
   val faculty: faculty,

   @SerializedName("users_permissions_user")
   val users_permissions_user: String,

   @SerializedName("published_at")
   val published_at: String,

   @SerializedName("created_at")
   val created_at: String,

   @SerializedName("updated_at")
   val updated_at: String,

   @SerializedName("avatar_student")
   val avatar_student: avatarStudent,
)