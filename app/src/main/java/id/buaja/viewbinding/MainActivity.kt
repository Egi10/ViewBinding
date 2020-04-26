package id.buaja.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.buaja.viewbinding.databinding.ActivityMainBinding
import id.buaja.viewbinding.extensions.toast
import id.buaja.viewbinding.model.Cat

class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainAdapter
    private var list: MutableList<Cat> = mutableListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Set Title Toolbar
        title = "Ras Kucing"

        //Initialize in adapter
        mainAdapter = MainAdapter(list) {
            toast(it.ras.toString())
        }

        //Get Data
        loadData()

        //Set to RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = mainAdapter
    }

    private fun loadData() {
        val image = resources.getStringArray(R.array.image)
        val ras = resources.getStringArray(R.array.ras)
        val ket = resources.getStringArray(R.array.ket)

        for (i in ras.indices) {
            list.add(
                Cat(
                    image = image[i],
                    ras = ras[i],
                    ket = ket[i]
                )
            )
        }
        mainAdapter.notifyDataSetChanged()
    }
}
