package com.example.sportx.data.remote

import android.util.Log
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class DateGenerator() {


    companion object {
       fun fromInPast() : String {
           val currentDate = LocalDate.now()
           val thirtyDaysAgo = currentDate.minusDays(30)
           return thirtyDaysAgo.format(DateTimeFormatter.ISO_DATE)
       }
        fun toInPast() : String {
            val currentDate = LocalDate.now()
            val yesterday = currentDate.minusDays(1)
            return yesterday.format(DateTimeFormatter.ISO_DATE)
        }
//        fun fromInFuture() : String {
//
//        }
//        fun toInFuture() : String {
//
//        }

   }
}

