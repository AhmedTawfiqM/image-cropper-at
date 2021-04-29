# Image Cropper
image cropper is powerful library in android  
that make Powerful (Zoom, Rotation, Multi-Source), customizable (Shape, Limits, Style), optimized (Async, Sampling, Matrix) and simple image cropping library for Android.


### Setup Guide

1- Include the library



```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}

```


```

dependencies {
  	 implementation 'com.github.AhmedTawfiqM:image-cropper-at:1.0.5'
	}
  
  ```


2- Add CropImageActivity into your AndroidManifest.xml

```

 <activity android:name="com.atdev.image_cropper.CropImageActivity"
  android:theme="@style/Base.Theme.AppCompat"/> <!-- optional (needed if default theme has no action bar) --
```


### Usage
```

 ImageCropper(this).start {
                Toast.makeText(this,"result ${it.data}", Toast.LENGTH_LONG).show()
            }
```

see Example [Image Cropper Example](https://github.com/AhmedTawfiqM/image-cropper-at/blob/master/app/src/main/java/com/atdev/cropimageapp/MainActivity.kt)
            


