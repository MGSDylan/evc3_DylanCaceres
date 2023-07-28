package com.dylancaceres.EVC.UI.fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dylancaceres.EVC.data.repository.retroFit.StarwarsInterface


import com.dylancaceres.EVC.databinding.FragmentHomeBinding
import com.dylancaceres.EVC.model.Personaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {



    private lateinit var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        binding.rvPersonajes.layoutManager=LinearLayoutManager(requireContext())
    }



    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.thecatapi.com/")
            .build()
            .create(StarwarsInterface::class.java)

        val retrofitData = retrofitBuilder.getAllPersonajes()

        retrofitData.enqueue(object : Callback<List<Personaje>?> {
            override fun onResponse(
                call: Call<List<Personaje>?>,
                response: Response<List<Personaje>?>
            ) {
                val responseBody = response.body()!!
                binding.rvPersonajes.adapter = RVpersonajeAdapter(responseBody)

            }

            override fun onFailure(call: Call<List<Personaje>?>, t: Throwable) {
                Log.d("MainActivity","Request Failed"+t.message)
            }
        })
    }



}