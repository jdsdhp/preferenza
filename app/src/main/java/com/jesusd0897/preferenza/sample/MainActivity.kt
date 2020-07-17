package com.jesusd0897.preferenza.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jesusd0897.preferenza.consultPreference
import com.jesusd0897.preferenza.storePreference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Everything will be saved as string
        storePreference(
            context = this,
            generalKey = "GENERAL_LIST_KEY",
            map = hashMapOf(
                "PARAM_1_KEY" to "Havana City", // "Havana City"
                "PARAM_2_KEY" to true,  // true.toString() = "true"
                "PARAM_3_KEY" to 666,   // 666.toString() = "666"
                "PARAM_4_KEY" to Any().toString()   // Any().toString() = "object identifier in this case"
            )
        )

        val havanaCity = consultPreference(
            this,
            "GENERAL_LIST_KEY",
            "PARAM_1_KEY",
            ""
        )
        Log.d("LOG", "CITY = $havanaCity") // Show "CITY = Havana City"

        val numberRecovered = consultPreference(
            this,
            "GENERAL_LIST_KEY",
            "PARAM_3_KEY",
            ""
        )
        Log.d("LOG", "SUM = ${numberRecovered.toInt() + 2}") // Show "SUM = 668"
    }
}