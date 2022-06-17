package com.apsan.practicingui

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.apsan.practicingui.databinding.FragmentHomeBinding
import com.hoc081098.viewbindingdelegate.viewBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root

        val slider = binding.imageSlider
        val adapter = SliderAdapter(requireContext())
        slider.setSliderAdapter(adapter)
        adapter.renewItems(
            mutableListOf(
                SliderItem(AppCompatResources.getDrawable(requireContext(), R.drawable.slider_bg)!!),
                SliderItem(AppCompatResources.getDrawable(requireContext(), R.drawable.slider_bg)!!),
                SliderItem(AppCompatResources.getDrawable(requireContext(), R.drawable.slider_bg)!!)
            )
        )
        slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        slider.startAutoCycle();
    }

}