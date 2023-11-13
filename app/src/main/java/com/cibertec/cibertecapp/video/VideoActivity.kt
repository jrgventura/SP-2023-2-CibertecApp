package com.cibertec.cibertecapp.video

import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cibertec.cibertecapp.R

class VideoActivity : AppCompatActivity() {

    private val READ_STORAGE_PERMISSION_REQUEST = 50
    private val READ_STORAGE_PERMISSION_REQUES2T = 2

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

        }

    }

}