package com.example.photobrowser

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.photobrowser.ui.theme.PhotoBrowserTheme

class PhotoDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Nhận photoId từ Intent
        val photoId = intent.getIntExtra("photoId", -1)

        // testing và log giá trị photoId
//        if (photoId != -1) {
//            Log.d("PhotoDetail", "Received image ID: $photoId")
//        } else {
//            Log.d("PhotoDetail", "No image received")
//        }

        // setup nội dung
        setContent {
            PhotoBrowserTheme {
                Image(
                    painter = painterResource(id = photoId),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
