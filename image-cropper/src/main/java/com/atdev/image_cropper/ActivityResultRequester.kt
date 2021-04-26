package com.atdev.image_cropper

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.fragment.app.FragmentActivity

class ActivityResultRequester(private val activity: FragmentActivity) {

    fun request(intent: Intent, callback: (ActivityResult) -> Unit) {
        ActivityResultFrag.request(intent, activity, callback)
    }
}