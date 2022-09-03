package com.bitcode.recyclerviewwithviewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerProducts : RecyclerView
    private lateinit var products : ArrayList<Product>
    private lateinit var advertisements : ArrayList<Advertisement>
    private lateinit var productsAdapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initData()
        initRecyclerView()
    }

    private fun initRecyclerView(){
        productsAdapter = ProductsAdapter(products,advertisements)
        recyclerProducts.adapter = productsAdapter
        recyclerProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    private fun initData(){
        products = ArrayList<Product>()
        for(i in 0..20){
            products.add(Product(i, "Product $i", 10 * i + 5, R.mipmap.ic_launcher))
        }

        advertisements = ArrayList<Advertisement>()
        for(i in 0..4){
             advertisements.add(Advertisement(i,"Advertisement $i",R.mipmap.ic_launcher))
        }
    }

    private fun initViews(){
        recyclerProducts = findViewById(R.id.recyclerProducts)
    }
}