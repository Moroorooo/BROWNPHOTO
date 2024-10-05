package com.example.photobrowser

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.photobrowser.ui.theme.PhotoBrowserTheme

class PhotoListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoBrowserTheme {
                PhotoListScreen(
                    photos = listOf(
                        R.drawable.sample_photo_1,
                        R.drawable.sample_photo_2,
                        R.drawable.sample_photo_3
                    ),
                    onPhotoClick = { photoId -> navigateToPhotoDetail(photoId) }
                )
            }
        }
    }

    private fun navigateToPhotoDetail(photoId: Int) {
        val intent = Intent(this, PhotoDetailActivity::class.java)
        intent.putExtra("photoId", photoId)
        startActivity(intent)
    }
}

@Composable
fun PhotoListScreen(photos: List<Int>, onPhotoClick: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(photos) { photo ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onPhotoClick(photo) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = photo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Photo $photo")
            }
        }
    }
}
