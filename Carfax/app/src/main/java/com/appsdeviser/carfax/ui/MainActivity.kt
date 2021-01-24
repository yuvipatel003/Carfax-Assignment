package com.appsdeviser.carfax.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsdeviser.carfax.R
import com.appsdeviser.carfax.data.api.ApiInterface
import com.appsdeviser.carfax.data.xxx.CarFaxData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTeamsList()
    }



    /**
     * get list of teams
     * make a network call using ApiInterface(retrofit) through Co-routine
     */
    private fun getTeamsList() {
        Log.d("TAG", "getTeamsList()")
        val apiInterface = ApiInterface.create().getCarFaxData()

        // Network call using Co-routine
        CoroutineScope(Dispatchers.IO).launch {
            val data: Response<CarFaxData> = apiInterface.execute()
            val listOfTeams = data.body()
            Log.d("Data : ", listOfTeams.toString())
        }
    }
}