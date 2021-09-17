package com.example.customspinnerkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.widget.Toast




class MainActivity : AppCompatActivity() {


    lateinit var badgeArrayList: ArrayList<Badge>
    lateinit var simple_spinner:Spinner
    lateinit var custom_spinner:Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        initList()
        setupSimpleSpinner()
        setupCustomSpinner()


    }

    private fun setupCustomSpinner() {
        custom_spinner=findViewById(R.id.custom_spinner)
        val adapter=BadgeAdapter(this,badgeArrayList)
        custom_spinner.adapter=adapter
        custom_spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var badgeSeleceted:Badge= parent?.getItemAtPosition(position) as Badge
                var clickedBadgeName:String=badgeSeleceted.title
                Toast.makeText(this@MainActivity,clickedBadgeName+"selected",Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    private fun setupSimpleSpinner() {
        simple_spinner=findViewById(R.id.simple_spinner)
        val adapter=ArrayAdapter.createFromResource(
            this,
            R.array.country,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        simple_spinner.adapter=adapter
        simple_spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem=parent!!.getItemAtPosition(position)
                Toast.makeText(
                    this@MainActivity,
                    "$selectedItem Selected",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }



    fun initList(){
        badgeArrayList=ArrayList()
        badgeArrayList.add(Badge("Sorun Çözücü",R.drawable.image10))
        badgeArrayList.add(Badge("Lider",R.drawable.image3))
        badgeArrayList.add(Badge("Problemci",R.drawable.image5))
        badgeArrayList.add(Badge("Lider Yardımcısı",R.drawable.image8))

    }
}