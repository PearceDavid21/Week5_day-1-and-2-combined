package com.example.wk5_day1_2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.wk5_day1_2.R
import com.example.wk5_day1_2.database.HotelDatabase
import com.example.wk5_day1_2.database.HotelEntity
import kotlinx.android.synthetic.main.guest_layout.*

class InputFragment : Fragment() {

    interface FragmentListener{
        fun updateResults()
    }

    fun setListener(fragmentListener: FragmentListener){
        this.fragmentListener = fragmentListener
    }


    lateinit var fragmentListener: FragmentListener
    lateinit var database: HotelDatabase

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.guest_layout, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
                .load(getString(R.string.logo2))
                .into(image)

        activity?.let { FragmentActivity ->
            database = Room.databaseBuilder(
                    FragmentActivity.applicationContext,
                    HotelDatabase::class.java,
                    "Hotel.database"
            )
                    .allowMainThreadQueries()
                    .build()
        }


        add_guest_button.setOnClickListener {
            val room = roomNumber_edittext.text.toString()
            val name = guestName_edittext.text.toString()
            val hotelEntity = HotelEntity(room, name)
            database.HotelDAO().addNewRoom(hotelEntity)
            clearTextFields()
            fragmentListener.updateResults()
            fragmentManager?.popBackStack()
        }
    }


    private fun clearTextFields() {
        guestName_edittext.text.clear()
        roomNumber_edittext.text.clear()
    }
}