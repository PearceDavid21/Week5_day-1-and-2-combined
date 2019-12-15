package com.example.wk5_day1_2.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wk5_day1_2.R
import com.example.wk5_day1_2.database.HotelEntity
import com.example.wk5_day1_2.model.Guests
import org.greenrobot.eventbus.EventBus


class GuestAdapter(private val roomTaken: List<HotelEntity>) :
        RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {


        val view = LayoutInflater.from(parent.context)
                .inflate(
                        R.layout.guest_item_layout,
                        parent,
                        false
                )

        var rooms = mutableListOf<String>()
        val builder = StringBuilder()
        var count = 0

        for (i in roomTaken) {

            rooms.add(roomTaken[count].roomNumber)

            builder.append("${roomTaken[count].guestName}")
            builder.append(" ")

            count++
        }

        EventBus.getDefault()
                .post(
                        rooms
                )

        EventBus.getDefault()
                .post(
                        Guests(builder.toString())
                )

        return GuestViewHolder(view)

    }

    override fun getItemCount(): Int {
        return roomTaken.size
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {


        holder.apply {
            roomNumber.text = "${roomTaken[position].roomNumber}"


            guestName.text = "${roomTaken[position].guestName}"
        }
    }


    inner class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomNumber: TextView = itemView.findViewById(R.id.guest_room_textview)
        val guestName: TextView = itemView.findViewById(R.id.guest_name_textview)
    }
}
