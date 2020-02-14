package com.sample.blueline.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sample.blueline.databinding.FragmentMessageDetailBinding

class MessageDetailFragment : Fragment() {

    private val args: MessageDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMessageDetailBinding.inflate(inflater, container, false)

        binding.message = args.message

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}
