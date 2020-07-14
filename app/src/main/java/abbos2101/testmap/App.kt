package abbos2101.zadacha01

import abbos2101.zadacha01.module.lazyFast
import android.app.Application
import android.content.Context
import com.example.module.common.NetProvider

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        var context: Context? = null
        val netProvider by lazyFast { NetProvider.instance("https://androidapi.lebazar.uz/") }
    }
}