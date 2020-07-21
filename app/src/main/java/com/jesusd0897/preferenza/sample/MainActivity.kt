/*
 * Copyright (c) 2020 jesusd0897.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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