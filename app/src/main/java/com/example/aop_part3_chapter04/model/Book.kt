package com.example.aop_part3_chapter04.model

import com.google.gson.annotations.SerializedName

data class Book(
    //서버와 클라이언트 변수 이름 동기화
    @SerializedName("itemId") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("coverSmallUrl") val coverSmallUrl: String
)
