package com.txcsmad.mad.ui.activities

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.txcsmad.mad.R
import com.txcsmad.mad.ui.fragments.InfoFragment
import com.txcsmad.mad.ui.fragments.MadconFragment
import com.txcsmad.mad.ui.fragments.ScheduleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fragments: Array<Fragment>
    private var prevPosition = 0

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val position = when (item.itemId) {
            R.id.navigation_schedule -> 0
            R.id.navigation_madcon -> 1
            R.id.navigation_about -> 2
            else -> 0
        }
        val oldFragment = fragments[prevPosition]
        if (fragmentManager.findFragmentByTag(prevPosition.toString()) != null)
        {
            fragmentManager.beginTransaction()
                    .hide(oldFragment)
                    .commit()
        }
        inflateFragment(position)
        prevPosition = position
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.app_long_name)

        fragments = arrayOf(ScheduleFragment(), MadconFragment(), InfoFragment())
        navigation_bottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        inflateFragment(0)
    }

    private fun inflateFragment(position: Int) {
        val fragment = fragments[position]
        if (fragmentManager.findFragmentByTag(position.toString()) == null)
        {
            fragmentManager.beginTransaction()
                    .add(R.id.frame_content, fragment, position.toString())
                    .commit()
        }
        else
        {
            fragmentManager.beginTransaction()
                    .show(fragment)
                    .commit()
        }
    }
}
