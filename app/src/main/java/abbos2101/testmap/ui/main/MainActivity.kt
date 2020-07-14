package abbos2101.testmap.ui.main

import abbos2101.example.terrabayt.ui.base.BaseActivityFull
import abbos2101.testmap.databinding.ActivityMainBinding
import abbos2101.testmap.ui.map.MapsActivity
import abbos2101.zadacha01.module.*
import abbos2101.zadacha01.ui.main.MainPresenter
import abbos2101.zadacha01.ui.main.MainViewModel
import abbos2101.zadacha01.ui.main.adapter.MainAdapter
import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.Observer

class MainActivity : BaseActivityFull<ActivityMainBinding, MainPresenter, MainViewModel>() {
    private val adapter by lazyFast { MainAdapter(presenter!!) }
    override fun create() {
        init()
        initViewModel()
    }

    private fun init() {
        binding!!.rv.adapter = adapter
        presenter!!.loadCompanyList()
    }

    private fun initViewModel() {
        if (viewModel != null && binding != null) {
            viewModel!!.getCompanyList().observe(this, Observer {
                adapter.addList(it)
            })
            viewModel!!.getCompany().observe(this, Observer {
                val intent = Intent(this, MapsActivity::class.java)
                intent.putExtra("company", it.toJsonString())
                startActivity(intent)
            })
            viewModel!!.getProgress().observe(this, Observer {
                binding!!.pb.setVisible(it)
            })
            viewModel!!.getError().observe(this, Observer {
                if (it.trim().isNotEmpty())
                    showSnackbar("$it")
            })
        } else showSnackbar("Xatolik sodir bo'ldi:(")
    }

    override fun setViewBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)
    override fun setPresenter() = MainPresenter(viewModel!!)
    override fun setViewModel() = getViewModel(MainViewModel::class.java)
}