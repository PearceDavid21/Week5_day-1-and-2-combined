package com.example.wk5_day1_2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wk5_day1_2.database.HotelEntity
import org.greenrobot.eventbus.EventBus

import com.example.wk5_day1_2.R
import kotlinx.android.synthetic.main.room_fragment.*
import org.greenrobot.eventbus.Subscribe
import java.util.*


class DisplayRooms : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.room_fragment, container, false)


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
    fun receiveRooms(rooms: ArrayList<String>){
        roomNumbers.text = rooms.toString()
    }


}
