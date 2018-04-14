package com.txcsmad.mad.ui.fragments


import android.app.Fragment
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.txcsmad.mad.R
import kotlinx.android.synthetic.main.fragment_info.view.*

class InfoFragment : Fragment() {
    private val MAD_LINK = "https://www.txcsmad.com/"
    private val MADCON_LINK = "https://www.txcsmad.com/madcon/"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_info, container, false)

        view.text_mad_link.setOnClickListener { view ->
            val url = Uri.parse(MAD_LINK)
            val intent = Intent(Intent.ACTION_VIEW, url)
            if (intent.resolveActivity(activity?.packageManager) != null) {
                startActivity(intent)
            }
        }
        view.text_madcon_link.setOnClickListener { view ->
            val url = Uri.parse(MADCON_LINK)
            val intent = Intent(Intent.ACTION_VIEW, url)
            if (intent.resolveActivity(activity?.packageManager) != null) {
                startActivity(intent)
            }
        }

        return view
    }
}
