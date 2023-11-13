package com.cibertec.cibertecapp.video

import android.app.Instrumentation.ActivityResult
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cibertec.cibertecapp.R

class VideoActivity : AppCompatActivity() {

    private val READ_STORAGE_PERMISSION_REQUEST = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        // Video desde url
        val videoView = findViewById<VideoView>(R.id.videoView)
        // val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
        // videoView.setVideoURI(Uri.parse(videoUrl))
        // videoView.start()

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Video desde el app
        val videoPath = "android.resource://"+packageName+"/"+R.raw.forbiggerfun
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()

        val btnVideo = findViewById<Button>(R.id.btnVideo)
        btnVideo.setOnClickListener {
            if (checkPermission()) {
                // acceder a videos
                videoLauncher.launch("video/*")
            } else {
                // pedir permiso
                requestPermission()
            }
        }

    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE),
            READ_STORAGE_PERMISSION_REQUEST)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == READ_STORAGE_PERMISSION_REQUEST) {
            if(grantResults.isNotEmpty() && grantResults[0]
                == PackageManager.PERMISSION_GRANTED) {
                videoLauncher.launch("video/*")
            } else {
                Toast.makeText(this, "Permiso denegado",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    private val videoLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            playVideo(uri)
        }
    }

    private fun playVideo(uri: Uri) {
        val videoView = findViewById<VideoView>(R.id.videoView)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(uri)
        videoView.start()
    }

}