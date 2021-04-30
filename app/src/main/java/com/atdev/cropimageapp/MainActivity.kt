package com.atdev.cropimageapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.atdev.image_cropper.CropImage
import com.atdev.image_cropper.ImageCropper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartCrop = findViewById<Button>(R.id.btnStartCrop)

        btnStartCrop.setOnClickListener {

            ImageCropper(this).start {

                if (it.resultCode == Activity.RESULT_OK) return@start
                if (it.data == null) return@start

                val result = CropImage.getActivityResult(it.data)
                val uri = result?.uri
                Log.d("ImageCropper", "Uri: $uri")
            }
        }
    }
}