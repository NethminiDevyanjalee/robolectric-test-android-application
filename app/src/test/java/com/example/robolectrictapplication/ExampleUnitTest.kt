package com.example.robolectrictapplication

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @Test
    fun check_main_activity_text() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        val textView : TextView = activity.findViewById<TextView>(R.id.txtActivity)
        assertEquals("Hello Activity", textView.text)
    }

    @Test
    fun check_first_fragment_text(){
        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().start().resume().get()
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()
        val textView : TextView = activity.findViewById<TextView>(R.id.txtFragment)
        assertEquals("Hello Fragment", textView.text)
    }
}