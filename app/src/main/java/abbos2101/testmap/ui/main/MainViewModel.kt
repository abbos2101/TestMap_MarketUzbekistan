package abbos2101.zadacha01.ui.main

import abbos2101.example.terrabayt.ui.base.BaseViewModel
import abbos2101.zadacha01.module.net.model.childcompanyNet
import androidx.lifecycle.MutableLiveData

class MainViewModel : BaseViewModel() {
    private val _companyList: MutableLiveData<ArrayList<childcompanyNet>> = MutableLiveData()
    private val _company: MutableLiveData<childcompanyNet> = MutableLiveData()
    private val _progress: MutableLiveData<Boolean> = MutableLiveData()
    private val _error: MutableLiveData<String> = MutableLiveData()

    fun getCompanyList(): MutableLiveData<ArrayList<childcompanyNet>> = this._companyList
    fun setCompanyListValue(value: ArrayList<childcompanyNet>) {
        this._companyList.value = value
    }

    fun getCompany(): MutableLiveData<childcompanyNet> = this._company
    fun setCompanyValue(value: childcompanyNet) {
        this._company.value = value
    }

    fun getProgress(): MutableLiveData<Boolean> = this._progress
    fun setProgressValue(value: Boolean) {
        this._progress.value = value
    }

    fun getError(): MutableLiveData<String> = this._error
    fun setErrorValue(value: String) {
        this._error.value = value
    }
}