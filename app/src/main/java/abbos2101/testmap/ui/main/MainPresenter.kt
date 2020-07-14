package abbos2101.zadacha01.ui.main

import abbos2101.example.terrabayt.ui.base.BasePresenter
import abbos2101.zadacha01.App
import abbos2101.zadacha01.module.NetInfo
import abbos2101.zadacha01.module.getNetInfo
import abbos2101.zadacha01.module.net.model.childcompanyNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val viewModel: MainViewModel) : BasePresenter() {
    fun loadCompanyList() {
        launch {
            var error = ""
            var list: ArrayList<childcompanyNet> = arrayListOf()
            withContext(Dispatchers.Main) {
                viewModel.setProgressValue(true)
            }
            try {
                val response = App.netProvider.getCompanyListModel()
                if (response.getNetInfo() == NetInfo.SUCCESS)
                    list = response.body()?.data?.list ?: arrayListOf()
                else
                    error = "Xatolik sodir bo'ldi\n${response.getNetInfo()}"
            } catch (e: Exception) {
                error = "Xatolik sodir bo'ldi\n${e.message}"
            }
            withContext(Dispatchers.Main) {
                viewModel.setErrorValue(error)
                viewModel.setProgressValue(false)
                viewModel.setCompanyListValue(list)
            }
        }
    }

    fun itemClick(model: childcompanyNet) {
        viewModel.setCompanyValue(model)
    }
}