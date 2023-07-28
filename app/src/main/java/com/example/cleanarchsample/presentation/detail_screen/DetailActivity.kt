package com.example.cleanarchsample.presentation.detail_screen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cleanarchsample.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val viewModel = DetailViewModel()
        val coinNameView = findViewById<TextView>(R.id.coin_name)


        viewModel.coinDetail.observe(this, Observer {
            it?.let {
                coinNameView.text = it.name
            }
        })

        intent.extras?.getString("coinId")?.let {
            viewModel.getCoinDetail(it)
        }
    }
}