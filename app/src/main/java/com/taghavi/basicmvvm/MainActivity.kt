package com.taghavi.basicmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getRandomDog()

        randomDog.setOnClickListener {
            viewModel.getRandomDog()
        }

        viewModel.message.observe(
                this,
                {
                    Glide.with(this)
                            .load(it)
                            .into(imageViewDog)
                }
        )
    }
}