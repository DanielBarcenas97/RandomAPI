package com.dan.randomapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {

            val profile = this.getParcelable<ResultProfile>(ARG_OBJECT)

            binding.tvName.text = profile?.name?.first
            binding.tvNameComplete.text = profile?.name?.first + profile?.name?.last
            binding.tvAlias.text = profile?.dob?.age.toString()

            binding.tvDate.text = profile?.dob?.date

            Glide.with(requireContext())
                .load(profile?.picture?.large)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ivPhoto)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val ARG_OBJECT = "profile"
    }

}