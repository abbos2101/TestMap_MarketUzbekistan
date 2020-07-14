package abbos2101.example.terrabayt.ui.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<MODEL, PRESENTER : BasePresenter>(private val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(model: MODEL, presenter: PRESENTER)
}