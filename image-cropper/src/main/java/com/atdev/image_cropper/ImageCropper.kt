package com.atdev.image_cropper

import android.app.Activity
import android.net.Uri
import androidx.fragment.app.FragmentActivity

class ImageCropper(private val activity: Activity) {

    fun start(uri: Uri, callback: (androidx.activity.result.ActivityResult) -> Unit) {

        val intent = CropImage.activity(uri).build(activity)
        RequesterActivityResult(activity as FragmentActivity)
            .request(intent, callback)
    }

}