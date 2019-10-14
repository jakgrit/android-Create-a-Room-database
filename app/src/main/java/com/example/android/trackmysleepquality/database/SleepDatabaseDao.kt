/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SleepDatabaseDao{

    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    @Query("Select * From daily_sleep_quality_table Where nightId = :key")
    fun get(key: Long): SleepNight

    @Query("Delete From daily_sleep_quality_table")
    fun clear()

    @Query("Select * From daily_sleep_quality_table Order by nightId Desc Limit 1")
    fun getTonight(): SleepNight?

    @Query("Select * From daily_sleep_quality_table Order by nightId Desc")
    fun getAllNight(): LiveData<List<SleepNight>>
}
