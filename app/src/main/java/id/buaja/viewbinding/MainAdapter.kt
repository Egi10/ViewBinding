package id.buaja.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.buaja.viewbinding.databinding.ItemMainBinding
import id.buaja.viewbinding.extensions.loadImage
import id.buaja.viewbinding.model.Cat

/**
 * Created By Julsapargi Nursam 4/26/20
 */


class MainAdapter(private val data: List<Cat>, private val listener: (Cat) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(data[position], listener)

    class ViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cat, listener: (Cat) -> Unit) {
            with(binding) {
                tvKet.text = item.ket
                tvRas.text = item.ras
                ivImage.loadImage(item.image)
                itemCard.setOnClickListener {
                    listener(item)
                }
            }
        }
    }
}