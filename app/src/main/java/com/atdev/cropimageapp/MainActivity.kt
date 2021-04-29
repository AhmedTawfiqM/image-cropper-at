package com.atdev.cropimageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.atdev.image_cropper.ImageCropper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartCrop= findViewById<Button>(R.id.btnStartCrop)
        btnStartCrop.setOnClickListener {
            ImageCropper(this).start {
                Toast.makeText(this,"result ${it.data}",Toast.LENGTH_LONG).show()
            }
        }
    }
}