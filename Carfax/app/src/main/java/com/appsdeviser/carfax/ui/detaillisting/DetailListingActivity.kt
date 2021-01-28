package com.appsdeviser.carfax.ui.detaillisting

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.appsdeviser.carfax.R
import com.appsdeviser.carfax.data.model.Listings
import com.appsdeviser.carfax.databinding.ActivityDetailListingBinding
import com.appsdeviser.carfax.utils.Utilities
import com.bumptech.glide.Glide


class DetailListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailListingBinding
    private val mTAG = DetailListingActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_listing)

        val intent = intent
        val listing = intent.extras?.get("SINGLE_LISTING") as Listings

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_listing)

        setUpDetailListingViewData(listing)

    }

    private fun setUpDetailListingViewData(listing: Listings) {
        Log.d(mTAG + "Listing :", listing.toString())

        val listingTitle =
            listing.year.toString() + " " + listing.make + " " + listing.model + " " + listing.trim
        val listingPrice = "$" + Utilities.currencyFormat(listing.currentPrice)
        val listingMileage = listing.mileage
        val listingLocation = listing.dealer.address
        val listingDealer = listing.dealer.phone

        Glide.with(binding.imageViewDetailListingCarImage.context)
            .load(listing.images.firstPhoto.large)
            .into(binding.imageViewDetailListingCarImage)
        binding.textViewDetailListingCarDetails.text = listingTitle
        binding.textViewDetailListingCarPrice.text = listingPrice
        binding.textViewDetailListingCarMileage.text =
            Utilities.mileageToRSDecimalStack(listingMileage, false)
        binding.tvVehicleLocation.text = listingLocation
        binding.tvVehicleExteriorColor.text = listing.exteriorColor
        binding.tvVehicleInteriorColor.text = listing.interiorColor
        binding.tvVehicleDriveType.text = listing.drivetype
        binding.tvVehicleTransmission.text = listing.transmission
        binding.tvVehicleBodyStyle.text = listing.bodytype
        binding.tvVehicleEngine.text = listing.engine
        binding.tvVehicleFuel.text = listing.fuel

        binding.btnCallDealer.setOnClickListener {
            callDealer(listingDealer)
        }
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