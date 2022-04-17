package com.example.androidasignment2.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SingsModel(
    val artistName:String,
    val collectionName:String,
    val artworkUrl60:String,//image
    val trackPrice:String,
    val previewUrl : String//audio
):Parcelable

data class SingsList (
    public val results :  List<SingsModel>,
    public val resultCount:Int
 )