package com.atdev.image_cropper

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.fragment.app.FragmentActivity

class RequesterActivityResult(private val activity: FragmentActivity) {

    fun request(intent: Intent, callback: (ActivityResult) -> Unit) {
        ActivityResultFragment.request(intent, activity, callback)
    }
}