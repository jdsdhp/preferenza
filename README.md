Preferenza
=======

Utility to store and consult preferences on Android. It allows to use several XML files for a better distribution of the information.

[![JitPack](https://jitpack.io/v/jdsdhp/preferenza.svg)](https://jitpack.io/#jdsdhp/preferenza) 
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/jdsdhp/preferenza/blob/master/LICENSE) 
[![Twitter](https://img.shields.io/badge/Twitter-@jdsdhp-9C27B0.svg)](https://twitter.com/jdsdhp)

## Including in your project

#### Gradle

```gradle
allprojects  {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    implementation 'com.github.jdsdhp:preferenza:$version'
}
```
<br>

## Usage

### Kotlin
Everything will be saved and recovered as string.

```kotlin
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
```

## Sample project

It's very important to check out the sample app. Most techniques that you would want to implement are already implemented in the examples.

View the sample app's source code [here](https://github.com/jdsdhp/preferenza/tree/master/app)

License
=======

    Copyright (c) 2020 jesusd0897.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.