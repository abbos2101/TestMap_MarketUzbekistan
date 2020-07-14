package abbos2101.zadacha01.module.net.model

data class CompanyListNet(
    val data: childlistNet,
    val status: String,
    val httpStatusCode: Int
)

data class childlistNet(
    val list: ArrayList<childcompanyNet>,
    val count: Int
)

data class childcompanyNet(
    val id: Int,
    val name: String,
    val image: imageNet,
    val mobileImage: imageNet,
    val companyList: ArrayList<childCompanyListNet>
)

data class childCompanyListNet(
    val id: Int,
    val companyCode: String,
    val name: String,
    val lat: Double,
    val lng: Double,
    val line1: String
)

data class imageNet(
    val id: Int,
    val url: String
)