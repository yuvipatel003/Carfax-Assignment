package com.appsdeviser.carfax.ui.listing

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsdeviser.carfax.R
import com.appsdeviser.carfax.data.model.Listings
import com.appsdeviser.carfax.databinding.ActivityMainBinding
import com.appsdeviser.carfax.ui.detaillisting.DetailListingActivity
import com.appsdeviser.carfax.ui.di.Injector
import com.appsdeviser.carfax.utils.Utilities
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
        mAdapter = ListingRecyclerViewAdapter({ selectedListing: Listings ->
            selectedListing(selectedListing)
        }, { contactNo: String -> callDealer(contactNo) })
        mBinding.recyclerViewListing.adapter = mAdapter
        displayAllListing()
    }


    private fun displayAllListing() {
        mViewModel.getCarFaxData().observe(this, Observer {

            val list = it?.listings
            Log.d(mTAG, "Item Size: ${list?.size}")
            if (list != null) {
                mAdapter.setList(list)
                mAdapter.notifyDataSetChanged()
            }

        })
    }


    private fun selectedListing(singleListing: Listings) {
        Log.d(mTAG, "Selected : $singleListing")

        val intent = Intent(this, DetailListingActivity::class.java)
        intent.putExtra("SINGLE_LISTING", singleListing as Parcelable)
        startActivity(intent)
    }

    private fun callDealer(contactNo: String) {
        Log.d(mTAG, "Selected : $contactNo")

        if (Utilities.checkPermission(Manifest.permission.CALL_PHONE, this)) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$contactNo")
            startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                Utilities.MAKE_CALL_PERMISSION_REQUEST_CODE
            )
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            Utilities.MAKE_CALL_PERMISSION_REQUEST_CODE -> {
                return
            }
        }
    }


}