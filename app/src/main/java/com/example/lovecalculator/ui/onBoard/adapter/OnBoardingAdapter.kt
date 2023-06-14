package com.example.lovecalculator.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.example.lovecalculator.R
import com.example.lovecalculator.ui.onBoard.OnBoardModel
import com.example.lovecalculator.databinding.ItemOnboardBinding

class OnBoardingAdapter(private val onClick: (OnBoardModel) -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(

        OnBoardModel(
            title = "Step One",
            desc = "MEET YOUR PARTNER",
           imageResource = R.raw.love
       //   imageResource = "love.json"
                 //  imageResource =// "https://assets5.lottiefiles.com/packages/lf20_XRMbLmFEl3.json"
            // image = "https://previews.123rf.com/images/tatahnka/tatahnka1902/tatahnka190200049/118418801-pink-and-blue-complicated-lined-heart-mess-of-two-colors-chaos-of-feelings-concept-love-symbol-of.jpg"

        ),
       OnBoardModel(
            title = "Step Two",
            desc = "GET TO KNOW HER /HIM /THEY /THEM",
            imageResource = R.raw.dating_app
               //     imageResource = "https://assets5.lottiefiles.com/packages/lf20_XRMbLmFEl3.json"
            //"https://previews.123rf.com/images/ladiseno/ladiseno1307/ladiseno130700577/21124924-two-person-in-love-with-abstract-love-heart-on-white-background.jpg"

        ),
        OnBoardModel(
            title = "Step Three",
            desc = "FALL IN LOVE",
        imageResource = R.raw.dating_candle
            //        imageResource = "https://assets5.lottiefiles.com/packages/lf20_XRMbLmFEl3.json"
            //"https://media.istockphoto.com/id/1356581886/vector/couple-in-love.jpg?s=612x612&w=0&k=20&c=21tAufm2iMYdw6ZVH5g1X62Su00TGDLFJULkg8x_WOA="

        ),
        OnBoardModel(
            title = "Step Four",
            desc = "MAKE FUTURE TOGETHER",
            imageResource = R.raw.wedding
               //     imageResource = "https://assets5.lottiefiles.com/packages/lf20_XRMbLmFEl3.json"
            //"https://i.pinimg.com/564x/1f/d5/24/1fd524a8e133861711545ae0b3e6f6c1.jpg"

        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoardModel) {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }
            with(binding) {
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
              // ivBoard.setAnimation(onBoard.imageResource.toString())
            ivBoard.setAnimation(onBoard.imageResource)
            ivBoard.playAnimation()
              //onBoard.imageResource?.let { binding.ivBoard.setAnimation(it) }

            }


        }
    }
}