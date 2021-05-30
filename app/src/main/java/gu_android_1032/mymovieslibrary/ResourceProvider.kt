package gu_android_1032.mymovieslibrary

import android.app.Application

class ResourceProvider (val appContext: Application){
    fun getString (resId: Int) = appContext.getString(resId)
}