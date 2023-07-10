package com.example.recyclerviewpagination

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var isLoading = false
    private var currentPage = 1
    private var isLastPage = false
    lateinit var adapater: StudentAdapter

    lateinit var rcvStudentList: RecyclerView
    lateinit var Progressbar: ProgressBar
    var list: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        rcvStudentList = findViewById(R.id.rcvStudentList)
        Progressbar = findViewById(R.id.Progressbar)

        list.add("test")
        list.add("test1")
        list.add("test2")
        list.add("test3")
        list.add("test3")
        list.add("test3")
        list.add("test3")
        list.add("test3")
        list.add("test3")
        list.add("test3")

        adapater = StudentAdapter(list)
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcvStudentList.layoutManager = manager
        rcvStudentList.adapter = adapater


        rcvStudentList.addOnScrollListener(object : PaginationScrollListener(manager) {
            override fun loadMoreItems() {

                this@MainActivity.isLoading = true;
                currentPage += 1;
                loadNextPage();

            }

            override fun isLastPage(): Boolean {
                return this@MainActivity.isLastPage;
            }

            override fun isLoading(): Boolean {
                return this@MainActivity.isLoading;
            }

        })
    }

    private fun loadNextPage() {


        Log.e("TAG", "loadNextPage: data " + "call new data ")

        Progressbar.setVisibility(View.VISIBLE)

        val h = Handler(Looper.getMainLooper())
        h.postDelayed(Runnable {


            Progressbar.setVisibility(View.GONE)

            isLoading = false


            adapater.updateData(10)
            if (adapater.getSize() == 30) {
                isLastPage = true
            }
            Log.e("TAG", "loadNextPage: $currentPage")

        }, 2000)
    }

}