package com.example.unitconverter.di

import android.content.Context
import androidx.room.Room
import com.example.unitconverter.data.db.ConversionDAO
import com.example.unitconverter.data.db.ConversionDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideConversionDAO(conversionDatabase: ConversionDatabase): ConversionDAO {
        return conversionDatabase.getConversionDAO()
    }

    @Singleton
    @Provides
    fun provideConversionDatabase(context: Context): ConversionDatabase {
        return Room.databaseBuilder(context, ConversionDatabase::class.java, "conversion_db")
            .build()
    }
}