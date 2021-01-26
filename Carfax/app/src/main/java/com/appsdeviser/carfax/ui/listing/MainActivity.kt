package com.appsdeviser.carfax.ui.listing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsdeviser.carfax.R
import com.appsdeviser.carfax.data.api.ApiInterface
import com.appsdeviser.carfax.data.xxx.CarFaxData
import com.appsdeviser.carfax.databinding.ActivityMainBinding
import com.appsdeviser.carfax.ui.di.Injector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val mTAG = MainActivity::class.java.simpleName
    @Inject
    lateinit var mFactory: ListingViewModelFactory

    private lateinit var mViewModel: ListingViewModel
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: ListingRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as Injector).createListingSubComponent()
            .inject(this)

        mViewModel = ViewModelProvider(this, mFactory).get(ListingViewModel::class.java)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel.getCarFaxData().observe(this, Observer {
            Log.d("Data : ", it.toString())
        })


        initRecyclerView()
    }

    /**
     * Initialize RecyclerView
     */
    private fun initRecyclerView() {
        mBinding.recyclerViewListing.layoutManager = LinearLayoutManager(this)
        mAdapter = ListingRecyclerViewAdapter()
        mBinding.recyclerViewListing.adapter = mAdapter
        displayAllListing()
    }


    private fun displayAllListing() {
        mViewModel.getCarFaxData().observe(this, Observer{

            val list = it?.listings
            Log.d(mTAG, "Item Size: ${list?.size}")
            if(list != null) {
                mAdapter.setList(list)
                mAdapter.notifyDataSetChanged()
            }

        })
    }

}