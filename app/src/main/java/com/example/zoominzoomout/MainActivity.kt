package com.example.zoominzoomout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Fade
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // assigning id of the button
        // which zoom in the image
        val buttonZoomIn: Button = findViewById(R.id.zoomInButton)

        // assigning id of the button
        // which zoom out the image
        val buttonZoomOut: Button = findViewById(R.id.zoomOutButton)

        // assigning id of imageview on
        // which zoom in/out will be performed
        val image: ImageView = findViewById(R.id.imageView)

        // actions to be performed when
        // "Zoom In" button is clicked
        buttonZoomIn.setOnClickListener() {

            // loading the animation of
            // zoom_in.xml file into a variable
            val animZoomIn = AnimationUtils.loadAnimation(
                this,
                R.anim.zoomin
            )
            // assigning that animation to
            // the image and start animation
            image.startAnimation(animZoomIn)
        }

        // actions to be performed when
        // "Zoom Out" button is clicked
        buttonZoomOut.setOnClickListener() {

            // loading the animation of
            // zoom_out.xml file into a variable
            val animZoomOut = AnimationUtils.loadAnimation(
                this,
                R.anim.zoomout
            )

            // assigning that animation to
            // the image and start animation
            image.startAnimation(animZoomOut)
        }

        // fade in and fade out
        val text: TextView= findViewById(R.id.textView)
        val buttonfadein:Button=findViewById(R.id.fadein)
        buttonfadein.setOnClickListener {
            text.visibility= View.VISIBLE
            //loading our custom made animations
            val animation = AnimationUtils.loadAnimation(this, R.anim.fadein)
            //starting the animation
            text.startAnimation(animation)
        }
        val buttonfadeout:Button=findViewById(R.id.fadeout)
        buttonfadeout.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.fadeout)
            text.startAnimation(animation)
            //textview will be invisible after the specified amount
            // of time elapses, here it is 1000 milliseconds
            Handler().postDelayed({
                text.visibility = View.GONE
            }, 1000)
        }
    }
}