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

       listing.run {
            setUpDetailListingViewData(this)
        }

    }

    /**
     * Setup listing data for view
     */
    private fun setUpDetailListingViewData(listing: Listings) {
        Log.d(mTAG + "Listing :", listing.toString())

        val listingTitle =
            listing.year.toString() + getString(R.string.str_space) + listing.make + getString(R.string.str_space) + listing.model + getString(R.string.str_space) + listing.trim
        val listingPrice = getString(R.string.str_dollar) + Utilities.currencyFormat(listing.currentPrice)
        val listingMileage = listing.mileage
        val listingLocation = listing.dealer.address
        val listingDealer = listing.dealer.phone

        with(binding){

            Glide.with(imageViewDetailListingCarImage.context)
                .load(listing.images.firstPhoto.large)
                .into(imageViewDetailListingCarImage)
            textViewDetailListingCarDetails.text = listingTitle
            textViewDetailListingCarPrice.text = listingPrice
            textViewDetailListingCarMileage.text = Utilities.mileageToRSDecimalStack(listingMileage, false)
            tvVehicleLocation.text = listingLocation
            tvVehicleExteriorColor.text = listing.exteriorColor
            tvVehicleInteriorColor.text = listing.interiorColor
            tvVehicleDriveType.text = listing.drivetype
            tvVehicleTransmission.text = listing.transmission
            tvVehicleBodyStyle.text = listing.bodytype
            tvVehicleEngine.text = listing.engine
            tvVehicleFuel.text = listing.fuel

            binding.btnCallDealer.setOnClickListener {
                callDealer(listingDealer)
            }
        }

    }


    /**
     * Call Dealer
     * @param contactNo
     */
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