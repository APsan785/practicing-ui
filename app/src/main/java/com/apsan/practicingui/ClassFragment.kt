package com.apsan.practicingui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.apsan.practicingui.databinding.FragmentClassBinding
import com.hoc081098.viewbindingdelegate.viewBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class ClassFragment:Fragment(R.layout.fragment_class) {

    private val binding by viewBinding(FragmentClassBinding::bind)

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

        binding.mirrorScoreCourseAnsLayout.setOnClickListener {
            if(binding.mirrorScoreCourseAnswerTV.visibility == View.VISIBLE){
                binding.mirrorScoreCourseAnswerTV.visibility = View.GONE
                binding.btnMirrorScoreCourseAns.rotation = 90F
            }else{
                binding.mirrorScoreCourseAnswerTV.visibility = View.VISIBLE
                binding.btnMirrorScoreCourseAns.rotation = -90F
                binding.scrollView.post {
                    binding.scrollView.fullScroll(View.FOCUS_DOWN)
                }
            }
        }

    }

}