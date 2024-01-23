package com.example.ejercicio3rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio3rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var gatoAdapter: gatoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val gatos = mutableListOf(
            Gato("gato1","nose",4),
            Gato("gato2","nose",6),
            Gato("gato3","nose",8),

        )

        gatoAdapter = gatoAdapter(gatos, this)

        binding.rvGatos.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = gatoAdapter
        }

        binding.btnAnadir.setOnClickListener{
            if(binding.etNombre.text.toString().isNotEmpty()){
                val gato = Gato(binding.etNombre.text.toString(),"nose",20)

                addGatoAuto(gato)

                binding.etNombre.text?.clear()
            }
        }




    }

    private fun addGatoAuto(gato: Gato){
        gatoAdapter.addGato(gato)
    }



}