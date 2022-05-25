package com.example.robolectrictapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNavigate = findViewById(R.id.btnNavigate) as Button

        btnNavigate.setOnClickListener{
            val firstFragment = FirstFragment()
            val fragment: Fragment? = supportFragmentManager.findFragmentByTag(FirstFragment::class.java.simpleName)
            if(fragment !is FirstFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.linearFragment, firstFragment, FirstFragment::class.java.simpleName)
                    .commit()
            }
        }
    }
}