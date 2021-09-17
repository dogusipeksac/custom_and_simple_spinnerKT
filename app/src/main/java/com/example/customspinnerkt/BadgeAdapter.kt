package com.example.customspinnerkt

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class BadgeAdapter(context:Context,badgeList:List<Badge>)
    :ArrayAdapter<Badge>(context,0,badgeList)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup) :View{
        val badge=getItem(position)
        val view =convertView?:LayoutInflater.from(context).inflate(
            R.layout.spinner_item,parent,false)
        var imageViewBadge:ImageView=view.findViewById(R.id.image_spinner)
        var textSpinnerTitle:TextView=view.findViewById(R.id.text_spinner_title)
        if(badge!=null){
            imageViewBadge.setImageResource(badge!!.imageId)
            textSpinnerTitle.text=badge.title
        }

            return view
    }

}