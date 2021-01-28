package com.appsdeviser.carfax.repository

import com.appsdeviser.carfax.data.model.*
import com.appsdeviser.carfax.domain.repository.CarFaxRepository

class FakeRepository : CarFaxRepository {


    private val response = "{ \n" +
            " \"searchArea\":{ \n" +
            " \"city\":\"Beverly Hills\", \n" +
            " \"state\":\"CA\", \n" +
            " \"zip\":\"90210\", \n" +
            " \"latitude\":34.099800000000, \n" +
            " \"longitude\":118.412800000000, \n" +
            " \"radius\":50.0, \n" +
            " \"dynamicRadius\":false, \n" +
            " \"dynamicRadii\":[ \n" +
            " 50.0, \n" +
            " 100.0, \n" +
            " 200.0 \n" +
            " ] \n" +
            " }, \n" +
            " \"totalListingCount\":56, \n" +
            " \"enhancedCount\":29,\n" +
            "\n" +
            " \"backfillCount\":27, \n" +
            " \"dealerNewCount\":37, \n" +
            " \"dealerUsedCount\":19, \n" +
            " \"page\":1, \n" +
            " \"pageSize\":1, \n" +
            " \"totalPageCount\":3, \n" +
            " \"listings\":[ \n" +
            " { \n" +
            " \"dealer\":{ \n" +
            " \"carfaxId\":\"LIHRKUUOIE\", \n" +
            " \"dealerInventoryUrl\":\"http://www.iemotorsdirect.com\",  \"name\":\"California Motors Direct - Montclair\", \n" +
            " \"address\":\"10385 Central Ave\", \n" +
            " \"city\":\"Montclair\", \n" +
            " \"state\":\"CA\", \n" +
            " \"zip\":\"91763-4472\", \n" +
            " \"phone\":\"8663014042\", \n" +
            " \"latitude\":\"34.06525\", \n" +
            " \"longitude\":\"-117.68873\", \n" +
            " \"dealerAverageRating\":3.5, \n" +
            " \"dealerReviewDate\":\"2018-09-06 05:26:14\", \n" +
            " \"dealerReviewReviewer\":\"Arturo P.\", \n" +
            " \"dealerReviewRating\":5, \n" +
            " \"dealerReviewCount\":2, \n" +
            " \"onlineOnly\":false \n" +
            " }, \n" +
            " \"id\":\"19UDE2F3XGA025865LIHRKUUOIE20190122\", \n" +
            " \"vin\":\"19UDE2F3XGA025865\", \n" +
            " \"year\":2016, \n" +
            " \"make\":\"Acura\", \n" +
            " \"model\":\"ILX\", \n" +
            " \"trim\":\"Unspecified\", \n" +
            " \"subTrim\":\"Unspecified\", \n" +
            " \"topOptions\":[ \n" +
            " \"Aux Audio Adapter\", \n" +
            " \"CD (Single Disc)\", \n" +
            " \"Handsfree/Bluetooth Integration\", \n" +
            " \"Leather Seats\" \n" +
            " ], \n" +
            " \"mileage\":40192, \n" +
            " \"listPrice\":15599.0, \n" +
            " \"currentPrice\":15599.0, \n" +
            " \"monthlyPaymentEstimate\":{ \n" +
            " \"price\":15599.0, \n" +
            " \"downPaymentPercent\":10.0, \n" +
            " \"interestRate\":4.0, \n" +
            " \"termInMonths\":60, \n" +
            " \"loanAmount\":14039.1, \n" +
            " \"downPaymentAmount\":1559.9, \n" +
            " \"monthlyPayment\":258.55 \n" +
            " }, \n" +
            " \"onePrice\":16680.0, \n" +
            " \"badge\":\"GREAT\", \n" +
            " \"exteriorColor\":\"Gray\", \n" +
            " \"interiorColor\":\"Gray\", \n" +
            " \"engine\":\"4 Cyl\", \n" +
            " \"displacement\":\"2.4 L\", \n" +
            " \"drivetype\":\"FWD\", \n" +
            " \"transmission\":\"Automatic\", \n" +
            " \"fuel\":\"Gasoline\", \n" +
            " \"mpgCity\":25, \n" +
            " \"mpgHighway\":35, \n" +
            " \"bodytype\":\"Sedan\", \n" +
            " \"vehicleCondition\":\"Used\",\n" +
            "\n" +
            " \"cabType\":\"Unspecified\", \n" +
            " \"bedLength\":\"Unspecified\", \n" +
            " \"followCount\":13, \n" +
            " \"stockNumber\":\"025865\", \n" +
            " \"imageCount\":13, \n" +
            " \"images\":{ \n" +
            " \"baseUrl\":\"https://carfax-img.vast.com/carfax/-6601530003191280406/\",  \"large\":[ \n" +
            " \"https://carfax-img.vast.com/carfax/-6601530003191280406/1/640x480\"  ], \n" +
            " \"medium\":[ \n" +
            " \"https://carfax-img.vast.com/carfax/-6601530003191280406/1/344x258\"  ], \n" +
            " \"small\":[ \n" +
            " \"https://carfax-img.vast.com/carfax/-6601530003191280406/1/120x90\"  ], \n" +
            " \"firstPhoto\":{ \n" +
            "\"small\":\"https://carfax-img.vast.com/carfax/-6601530003191280406/1/120x90\", \"large\":\"https://carfax-img.vast.com/carfax/-6601530003191280406/1/640x480\", \n" +
            "\"medium\":\"https://carfax-img.vast.com/carfax/-6601530003191280406/1/344x258\"  } \n" +
            " }, \n" +
            " \"firstSeen\":\"2019-01-22\", \n" +
            " \"oneOwner\":true, \n" +
            " \"noAccidents\":true, \n" +
            " \"serviceRecords\":true, \n" +
            " \"personalUse\":true, \n" +
            " \"distanceToDealer\":41.50362974656333, \n" +
            " \"hasViewed\":false, \n" +
            " \"sentLead\":false, \n" +
            " \"sentLeadAt\":null, \n" +
            " \"recordType\":\"ENHANCED\", \n" +
            " \"dealerType\":\"USED\", \n" +
            " \"backfill\":false, \n" +
            " \"advantage\":true, \n" +
            " \"vdpUrl\":\"https://www.carfax.com/vehicle/19UDE2F3XGA025865\",  \"sortScore\":186.25, \n" +
            " \"isEnriched\":false, \n" +
            " \"following\":false, \n" +
            " \"onlineOnly\":false, \n" +
            " \"certified\":false \n" +
            " } \n" +
            " ] \n" +
            "}\n"


    private lateinit var carFaxItem: CarFaxData


    init {
        val firstPhoto = FirstPhoto("", "", "")
        val monthlyPaymentEstimate = MonthlyPaymentEstimate(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 12)
        val images = Images(
            "base_url",
            firstPhoto,
            arrayListOf("", "", ""),
            arrayListOf("", "", ""),
            arrayListOf("", "", "")
        )
        val dealer = Dealer(
            "null",
            "null",
            "null",
            1.0,
            "null",
            1,
            "null",
            1,
            "null",
            "null",
            "null",
            "null",
            true,
            "null",
            "null",
            "null"
        )
        val singleListing = Listings(
            false,
            false,
            "badge",
            "null",
            "sedan",
            "null",
            true,
            (12000).toDouble(),
            dealer,
            "null",
            "null",
            1.0,
            "null",
            "null",
            "null",
            "null",
            1,
            true,
            "null",
            true,
            "null",
            1,
            images,
            "null",
            true,
            1.0,
            "null",
            1,
            "null",
            monthlyPaymentEstimate,
            1,
            1,
            true,
            true,
            (1000).toDouble(),
            true,
            true,
            "null",
            false,
            false,
            false,
            (1000).toDouble(),
            "null",
            "null",
            arrayListOf("null", "null"),
            "null",
            "null",
            "null",
            "null",
            "null",
            2020
        )
        val listing: List<Listings> = mutableListOf<Listings>()
        listing.plus(singleListing)
        listing.plus(singleListing)
        val searchArea = SearchArea("", arrayListOf(1.0, 1.0), false, 1.0, 1.0, 1.0, "5", "")
        carFaxItem = CarFaxData(0, 0, 0, 0, listing, 1, 1, searchArea, 1, 1)

    }

    override suspend fun getCarFaxData(): CarFaxData? {
        return carFaxItem
    }
}