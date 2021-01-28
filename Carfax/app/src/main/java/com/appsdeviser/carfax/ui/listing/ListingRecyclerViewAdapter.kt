package com.appsdeviser.carfax.ui.listing

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.appsdeviser.carfax.R
import com.appsdeviser.carfax.data.model.Listings
import com.appsdeviser.carfax.databinding.ListListingItemBinding
import com.appsdeviser.carfax.utils.Utilities
import com.appsdeviser.carfax.utils.Utilities.Companion.currencyFormat
import com.bumptech.glide.Glide

class ListingRecyclerViewAdapter(
    private val selectedListListener: (Listings) -> Unit,
    private val callDealerListener: (String) -> Unit
) : RecyclerView.Adapter<ListingItemViewHolder>() {

    private val mTag = ListingRecyclerViewAdapter::class.java.simpleName
    private val mListing = ArrayList<Listings>()

    /**
     * set Listing list
     * @param listItems - list of Listings
     */
    fun setList(listItems: List<Listings>) {
        mListing.clear()
        mListing.addAll(listItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListListingItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_listing_item,
            parent,
            false
        )
        return ListingItemViewHolder(binding)
    }

    /**
     * Get list size
     * @return size
     */
    override fun getItemCount(): Int {
        return mListing.size
    }

    override fun onBindViewHolder(holder: ListingItemViewHolder, position: Int) {
        holder.bind(mListing[position], selectedListListener, callDealerListener)
    }

}


class ListingItemViewHolder(private val binding: ListListingItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val mTag = ListingItemViewHolder::class.java.simpleName

    fun bind(
        listing: Listings,
        selectedListListener: (Listings) -> Unit,
        callDealerListener: (String) -> Unit
    ) {
        Log.d(mTag + "Images :", listing.images.toString())
        Log.d(mTag, listing.images.firstPhoto.large)
        Glide.with(binding.imageViewListingCarImage.context)
            .load(listing.images.firstPhoto.large)
            .into(binding.imageViewListingCarImage)

        val listingTitle =
            listing.year.toString() + " " + listing.make + " " + listing.model + " " + listing.trim
        binding.textViewListingCarDetails.text = listingTitle

        val listingPrice = "$ " + currencyFormat(listing.currentPrice)
        binding.textViewListingCarPrice.text = listingPrice

        val listingMileage = listing.mileage
        val listingLocation = listing.dealer.address
        val listingDealer = listing.dealer.phone

        binding.textViewListingCarMileage.text =
            Utilities.mileageToRSDecimalStack(listingMileage, false)
        binding.textViewListingAddress.text = listingLocation
        binding.textViewListingDealer.setOnClickListener { callDealerListener(listingDealer) }

        binding.cardViewListing.setOnClickListener { selectedListListener(listing) }
    }
}