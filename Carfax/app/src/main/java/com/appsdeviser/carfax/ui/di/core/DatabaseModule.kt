package com.appsdeviser.carfax.ui.di.core

//@Module
//class DatabaseModule {
//    @Singleton
//    @Provides
//    fun provideCarFaxDataBase(context: Context) : CarFaxDatabase {
//        return Room.databaseBuilder(context,CarFaxDatabase::class.java,"db_carfax").build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideCarFaxDao(carFaxDatabase: CarFaxDatabase) : CarFaxDao{
//        return carFaxDatabase.carFaxDao()
//    }
//}