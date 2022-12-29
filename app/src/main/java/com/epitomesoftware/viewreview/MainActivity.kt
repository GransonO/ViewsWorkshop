package com.epitomesoftware.viewreview

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewStub
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.epitomesoftware.viewreview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)

        var progressBar: ProgressBar? = null
        var stubView: View? = null

        binding.apply {

            val x = newsTitle.stubTest

            // Stub Toggle
            toggleStub.setOnClickListener {
                try {
                    stubView = x.inflate()
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }

            // Verify/interact with stub component
            verifyStub.setOnClickListener {
                progressBar = findViewById(R.id.progressBar)
                try {
                    Log.e("MainActivity", "___ ${progressBar?.isVisible}")

                } catch (e: java.lang.Exception){
                    e.printStackTrace()
                }
            }

            // Toggle Merge
            hideStub.setOnClickListener {
                progressBar?.let {
                    if(it.isVisible)
                        it.visibility = GONE
                    else
                        it.visibility = VISIBLE
                }
            }

            // Window Insets Manipulation
            windowInsets.setOnClickListener {
                if(supportActionBar?.isShowing == false){

                     supportActionBar?.show()
                     windowInsetsController?.isAppearanceLightNavigationBars = false
                     windowInsetsController?.show(WindowInsetsCompat.Type.systemBars())
                    WindowCompat.setDecorFitsSystemWindows(window, false)
                } else{

                     supportActionBar?.hide()
                     windowInsetsController?.isAppearanceLightNavigationBars = true
                     windowInsetsController?.hide(WindowInsetsCompat.Type.systemBars())
                    WindowCompat.setDecorFitsSystemWindows(window, false)
                }
            }
        }

    }

}