package com.sample.blueline.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.sample.blueline.adapters.MessageAdapter
import com.sample.blueline.databinding.FragmentCommunicationsBinding
import com.sample.blueline.utilities.InjectorUtils
import com.sample.blueline.viewmodels.MessageViewModel

class CommunicationsFragment : Fragment() {

    lateinit var binding: FragmentCommunicationsBinding

    private val viewModel: MessageViewModel by activityViewModels {
        InjectorUtils.provideMessageViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunicationsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.messageRecyclerView.adapter = MessageAdapter(viewModel).also { adapter ->

            viewModel.messages.observe(viewLifecycleOwner) { messages ->
                adapter.submitList(messages)
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}