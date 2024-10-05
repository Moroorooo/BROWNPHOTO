package com.example.photobrowser

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.photobrowser.ui.theme.PhotoBrowserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoBrowserTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    BrowsePhotosScreen(
                        onBrowseClick = { navigateToPhotoList() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun navigateToPhotoList() {
        val intent = Intent(this, PhotoListActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun BrowsePhotosScreen(onBrowseClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onBrowseClick,
        modifier = modifier
    ) {
        Text(text = "Browse Photos")
    }
}

@Preview(showBackground = true)
@Composable
fun BrowsePhotosScreenPreview() {
    PhotoBrowserTheme {
        BrowsePhotosScreen(onBrowseClick = {})
    }
}
