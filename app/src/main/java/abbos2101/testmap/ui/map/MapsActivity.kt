package abbos2101.testmap.ui.map

import abbos2101.example.terrabayt.ui.base.BaseActivity
import abbos2101.testmap.R
import abbos2101.testmap.databinding.ActivityMapsBinding
import abbos2101.zadacha01.module.fromJsonObject
import abbos2101.zadacha01.module.lazyFast
import abbos2101.zadacha01.module.net.model.childcompanyNet
import android.view.LayoutInflater
import android.view.MenuItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : BaseActivity<ActivityMapsBinding>(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private val company by lazyFast {
        intent.getStringExtra("company")
            ?.fromJsonObject(childcompanyNet::class.java)
    }

    override fun create() {
        init()
    }

    private fun init() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        supportActionBar?.title = company?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setMinZoomPreference(4.0F)
        company?.companyList?.forEach {
            val name = "${it.name}"
            var lat: Double
            var lng: Double
            if (it.id == 85 || it.id == 86) {
                lat = it.lng
                lng = it.lat
            } else {
                lat = it.lat
                lng = it.lng
            }
            val coordinate = LatLng(lat, lng)
            val marker = MarkerOptions().position(coordinate).title(name)
            mMap.addMarker(marker)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(coordinate))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun setViewBinding(inflater: LayoutInflater) = ActivityMapsBinding.inflate(inflater)
}