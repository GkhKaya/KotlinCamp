package com.example.usepicassolibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //http://gkhkaya.com/kotlincamp/maxresdefault%20%281%29.jpg

        buttonShowImage.setOnClickListener{
            val url = "https://gkhkaya.com/kotlincamp/maxresdefault%20%281%29.jpg"
            Picasso.get()
                .load(url)
                .resize(400,600)
                .rotate(90f)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(imageView)
        }
    }
}