package id.buaja.viewbinding.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.buaja.viewbinding.R

/**
 * Created By Julsapargi Nursam 4/26/20
 */
 
fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .transform(CenterCrop(), RoundedCorners(20))
        .into(this)
}