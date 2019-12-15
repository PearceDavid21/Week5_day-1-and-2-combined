package com.example.wk5_day1_2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wk5_day1_2.R
import com.example.wk5_day1_2.model.Guests
import kotlinx.android.synthetic.main.customer_fragment.*
import kotlinx.android.synthetic.main.room_fragment.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class DisplayGuest : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.customer_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EventBus.getDefault().register(this)

    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun receiveGues(Gues: Guests) {

        names.text = "${Gues.name}"
    }


}
