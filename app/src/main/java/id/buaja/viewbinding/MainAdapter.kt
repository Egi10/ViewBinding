package id.buaja.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.buaja.viewbinding.databinding.ItemMainBinding
import id.buaja.viewbinding.databinding.ItemTextMainBinding
import id.buaja.viewbinding.extensions.loadImage
import id.buaja.viewbinding.model.Cat

/**
 * Created By Julsapargi Nursam 4/26/20
 */

class MainAdapter(private val data: List<Cat>, private val listener: (Cat) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_IMAGE = 0
        private const val ITEM_TEXT = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_IMAGE -> {
                ViewHolder(
                    ItemMainBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                ViewHolderText(
                    ItemTextMainBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_IMAGE -> {
                val imageHolder = holder as ViewHolder
                imageHolder.bind(data[position], listener)
            }

            else -> {
                val textHolder = holder as ViewHolderText
                textHolder.bind(data[position], listener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].image.isNullOrEmpty()) {
            ITEM_TEXT
        } else {
            ITEM_IMAGE
        }
    }

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

    class ViewHolderText(private val binding: ItemTextMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cat, listener: (Cat) -> Unit) {
            with(binding) {
                tvKet.text = item.ket
                tvRas.text = item.ras
                itemCard.setOnClickListener {
                    listener(item)
                }
            }
        }
    }
}