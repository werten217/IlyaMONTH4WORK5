package com.ilya.therickandmorty.view.fragments.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.ilya.therickandmorty.view.adapters.CharacterAdapter
import com.ilya.therickandmorty.viewmodel.CharacterViewModel
import com.sultan.therickandmorty.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {

    private lateinit var binding : FragmentCharacterBinding
    private val viewModel : CharacterViewModel by viewModels()
    private val adapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("ololo", "onViewCreated: data loading" )
        viewModel.getCharacter()
        initialize()
    }

    private fun initialize() {
        initializeAdapter1()
        initializeObserver2()
    }

    private fun initializeAdapter1() {
        binding.characterRecyclerView.adapter = adapter
    }

    private fun initializeObserver2() {
        viewModel.character.observe(viewLifecycleOwner) { characterResponse ->
            Log.e("ololo", "initializeObserver: $characterResponse" )
            adapter.submitList(characterResponse?.results)
        }
    }

}