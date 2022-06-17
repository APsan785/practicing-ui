package com.apsan.practicingui


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.apsan.practicingui.databinding.ImageSliderLayoutItem1Binding
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(private val context: Context) :
    SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {
    private var mSliderItems: MutableList<SliderItem> = ArrayList()
    fun renewItems(sliderItems: MutableList<SliderItem>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mSliderItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: SliderItem) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val binding = ImageSliderLayoutItem1Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SliderAdapterVH(binding)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem: SliderItem = mSliderItems[position]
        viewHolder.bindit(sliderItem)
        viewHolder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(context, "This is item in position $position", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mSliderItems.size
    }

    inner class SliderAdapterVH(private val binding: ImageSliderLayoutItem1Binding) :
        ViewHolder(binding.root) {

        fun bindit(sliderItem: SliderItem) {
            binding.apply {
                binding.ivAutoImageSlider.setImageDrawable(sliderItem.img)
            }
        }

    }

}