package abbos2101.zadacha01.ui.main.adapter

import abbos2101.example.terrabayt.ui.base.BaseAdapter
import abbos2101.testmap.databinding.ItemMainBinding
import abbos2101.zadacha01.module.net.model.childcompanyNet
import abbos2101.zadacha01.ui.main.MainPresenter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val presenter: MainPresenter) : BaseAdapter<childcompanyNet>(presenter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainViewHolder(ItemMainBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = list[position]
        (holder as MainViewHolder).bind(model, presenter)
    }
}