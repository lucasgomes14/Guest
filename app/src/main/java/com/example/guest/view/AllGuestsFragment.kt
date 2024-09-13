package com.example.guest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guest.databinding.FragmentAllGuestsBinding
import com.example.guest.view.adapter.GuestAdapter
import com.example.guest.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null
    private val binding get() = _binding!!

    private val adapter = GuestAdapter()
    private lateinit var viewModel: AllGuestsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        viewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        // layout como se comporta
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)

        // definir adapter
        binding.recyclerAllGuests.adapter = adapter

        observe()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }

    private fun observe() {
        viewModel.listGuest.observe(viewLifecycleOwner) {
            adapter.updateGuest(it)
        }
    }
}