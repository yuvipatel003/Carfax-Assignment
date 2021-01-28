package com.appsdeviser.carfax.ui.listing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appsdeviser.carfax.data.model.*
import com.appsdeviser.carfax.domain.usecase.GetCarFaxDataUseCase
import com.appsdeviser.carfax.repository.FakeRepository
import com.appsdeviser.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(AndroidJUnit4::class)
class ListingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var mListingViewModel: ListingViewModel

    @Before
    fun setUp() {
        val fakeRepository = FakeRepository()
        val getCarFaxDataUseCase = GetCarFaxDataUseCase(fakeRepository)
        mListingViewModel = ListingViewModel(getCarFaxDataUseCase)
    }

    @Test
    fun getCarFaxData_returnsCorrectCarFaxData() {

        val firstPhoto = FirstPhoto("","","")
        val monthlyPaymentEstimate = MonthlyPaymentEstimate(0.0,0.0,0.0,0.0,0.0,0.0,12)
        val images = Images("base_url", firstPhoto, arrayListOf("","",""),arrayListOf("","",""),arrayListOf("","",""))
        val dealer = Dealer("null","null","null",1.0,"null",1,"null",1,"null","null","null","null",true,"null","null","null")
        val singleListing = Listings(false,false,"badge","null","sedan","null",true,(12000).toDouble(),dealer,"null","null",1.0,"null","null","null",
            "null",1,true,"null",true,"null",1,images,"null",true,1.0,"null",
            1,"null",monthlyPaymentEstimate,1,1,true,true,(1000).toDouble(),true,true,
            "null",false,false,false,(1000).toDouble(),"null","null",
            arrayListOf("null","null"),
            "null","null","null","null","null",2020)
        val listing : List<Listings> = mutableListOf<Listings>()
        listing.plus(singleListing)
        listing.plus(singleListing)
        val searchArea = SearchArea("", arrayListOf(1.0,1.0),false,1.0,1.0,1.0,"5","")
        val carFaxItem = CarFaxData(0,0,0,0,listing,1,1,searchArea,1,1)

        val currentCarFax = mListingViewModel.getCarFaxData().getOrAwaitValue()
        assertThat(carFaxItem).isEqualTo(currentCarFax)
    }
}