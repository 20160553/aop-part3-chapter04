package com.example.aop_part3_chapter04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aop_part3_chapter04.api.BookService
import com.example.aop_part3_chapter04.model.BestSellerDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        const val API_KEY = "인터파크 개인 키"
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bookService = retrofit.create(BookService::class.java)

        bookService.getBestSellerBooks(API_KEY)
            .enqueue(object: Callback<BestSellerDto>{

                override fun onResponse(
                    call: Call<BestSellerDto>,
                    response: Response<BestSellerDto>
                ) {
                    //TODO("Not yet implemented")
                    if (response.isSuccessful.not()) {
                        return
                    }

                    response.body()?.let {
                        Log.d(TAG, it.toString())

                        it.books.forEach {book ->
                            Log.d(TAG, book.toString())
                        }
                    }

                }

                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

            })
    }

}