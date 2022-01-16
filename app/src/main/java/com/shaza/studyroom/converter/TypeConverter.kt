package com.shaza.studyroom.converter

import com.google.gson.Gson
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken




class Converter {

    @TypeConverter
    fun carToString(carConverter: CarConverter): String {
      return  Gson().toJson(carConverter)
    }

    @TypeConverter
    fun stringToCar(string: String): CarConverter {
       return Gson().fromJson(string,CarConverter::class.java)
    }

    @TypeConverter
    fun fromCountryLangList(countryLang: List<PostConverter>): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<PostConverter>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<PostConverter>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<PostConverter>?>() {}.type
        return gson.fromJson<List<PostConverter>>(countryLangString, type)
    }
}