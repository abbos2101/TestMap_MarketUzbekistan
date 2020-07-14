package abbos2101.zadacha01.ui.main.adapter

import abbos2101.example.terrabayt.ui.base.BaseViewHolder
import abbos2101.testmap.R
import abbos2101.testmap.databinding.ItemMainBinding
import abbos2101.zadacha01.module.net.model.childcompanyNet
import abbos2101.zadacha01.module.setSrc
import abbos2101.zadacha01.ui.main.MainPresenter

class MainViewHolder(private val binding: ItemMainBinding) :
    BaseViewHolder<childcompanyNet, MainPresenter>(binding) {
    override fun bind(model: childcompanyNet, presenter: MainPresenter) {
        binding.tvName.text = model.name
        binding.tvCount.text = "${model.companyList.size} ta shaxobcha"
        if (model.mobileImage != null)
            binding.imgLogo.setSrc("https://androidapi.lebazar.uz${model.mobileImage.url}", 1)
        else
            binding.imgLogo.setSrc(R.drawable.ic_logo_off, 1)
        binding.llRoot.setOnClickListener {
            presenter.itemClick(model)
        }
    }
}