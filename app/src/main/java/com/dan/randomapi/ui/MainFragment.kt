package com.dan.randomapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dan.randomapi.R
import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.databinding.FragmentMainBinding
import com.dan.randomapi.ui.adapter.ProfileAdapter
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initObservers()
    }

    private fun initBinding() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.run {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collect{ state ->
                    binding.loadingAnim.isVisible = state.loading
                    state.listUsers?.let {
                        setRecyclerData(it)
                    }
                }
            }
        }
    }

    private fun setRecyclerData(list: List<ResultProfile>) {
        with(binding.recyclerView){
            adapter = ProfileAdapter(list){profile -> onClickItem(profile)}
        }
    }

    private fun onClickItem(user: ResultProfile) {
        val bundle = Bundle()
        bundle.putParcelable("profile", user)
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}