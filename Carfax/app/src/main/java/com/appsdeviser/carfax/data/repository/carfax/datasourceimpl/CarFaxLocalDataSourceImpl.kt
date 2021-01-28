package com.appsdeviser.carfax.data.repository.carfax.datasourceimpl

//class CarFaxLocalDataSourceImpl(
//    private val carFaxDao: CarFaxDao
//) : CarFaxLocalDataSource {
//    override suspend fun getCarFaxDataFromDB(): CarFaxData {
//        return carFaxDao.getListing()
//    }
//
//    override suspend fun saveCarFaxDataToDB(carFaxData: CarFaxData) {
//        CoroutineScope(Dispatchers.IO).launch {
//            carFaxDao.saveListing(carFaxData)
//        }
//    }
//
//    override suspend fun clearAll() {
//        CoroutineScope(Dispatchers.IO).launch {
//            carFaxDao.deleteAllListings()
//        }
//    }
//}