package com.example.shayariapplication

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.shayariapplication.databinding.ActivityMainBinding
import com.example.shayariapplication.databinding.ActivityShayariDisplayBinding

class ShayariDisplayActivity : AppCompatActivity() {

    lateinit var binding: ActivityShayariDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShayariDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        var ShayariName: String? = intent.getStringExtra("ShayariItem")
        binding.txtShayariDisplay.text = ShayariName

        binding.imgBack.setOnClickListener {
            onBackPressed()
        }

        binding.imgshare.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plan"

            share.putExtra(Intent.EXTRA_SUBJECT, "Share")
            share.putExtra(Intent.EXTRA_TEXT, " " + ShayariName)
            startActivity(Intent.createChooser(share, "Share"))
        }

        binding.imgCopy.setOnClickListener {
            val clipboard: ClipboardManager =
                getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", ShayariName)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Copy Successfully", Toast.LENGTH_SHORT).show()
        }

        binding.imgAdd.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            gallery_Launcher.launch(intent)
        }
    }

    var gallery_Launcher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val uri = data!!.data
            binding.imgShow.setImageURI(uri)
        }
        binding.imgDownload.setOnClickListener {
            val z: View = binding.Screenshot
            z.isDrawingCacheEnabled = true
            val totalHeight: Int = z.getHeight()
            val totalWidth: Int = z.getWidth()
            z.layout(0, 0, totalWidth, totalHeight)
            z.buildDrawingCache(true)
            val bm: Bitmap = Bitmap.createBitmap(z.drawingCache)
            z.isDrawingCacheEnabled = false
            Toast.makeText(this@ShayariDisplayActivity, "Download Successfully", Toast.LENGTH_SHORT)
                .show()
            MediaStore.Images.Media.insertImage(contentResolver, bm, null, null)

        }
    }
}