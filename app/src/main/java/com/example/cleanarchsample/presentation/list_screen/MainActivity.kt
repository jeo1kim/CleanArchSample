package com.example.rvsample.presentation.list_screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchsample.R
import com.example.cleanarchsample.presentation.detail_screen.DetailActivity
import com.example.cleanarchsample.presentation.list_screen.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        val itemClickListener = this
        val myAdapter = CustomAdapter(listOf(), itemClickListener)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }

        viewModel.coin.observe(this, Observer {
            it?.let {
                myAdapter.updateList(it)
            }
        })

        viewModel.getCoins()

    }

    override fun onItemClick(coinId: String) {
        Log.d("MainActivity", coinId)
        // open next page

        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        val b = Bundle()
        b.putString("coinId", coinId) //Your id
        intent.putExtras(b) //Put your id to your next Intent
        startActivity(intent)
    }
}

interface ItemClickListener {

    fun onItemClick(coinId: String)
}