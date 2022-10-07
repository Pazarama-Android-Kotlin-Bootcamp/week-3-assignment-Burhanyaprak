package com.burhanyaprak.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookModel (
    val bookName: String,
    val bookWriterName: String,
    val bookDetails: String ): Parcelable