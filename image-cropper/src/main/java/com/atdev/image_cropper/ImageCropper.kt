package com.atdev.image_cropper

import android.app.Activity
import androidx.fragment.app.FragmentActivity

class ImageCropper {

    fun start(activity: Activity, callback: (androidx.activity.result.ActivityResult) -> Unit) {

        val intent = CropImage.activity().build(activity)
        ActivityResultRequester(activity as FragmentActivity)
                .request(intent, callback)
    }
}