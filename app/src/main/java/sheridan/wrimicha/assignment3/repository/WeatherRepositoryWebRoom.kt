//package sheridan.wrimicha.assignment3.repository
//
//import ca.tetervak.flowerdata.database.WeatherDao
//import sheridan.wrimicha.assignment3.database.FlowerEntity
//import sheridan.wrimicha.assignment3.model.Weather
//import sheridan.wrimicha.assignment3.network.CatalogJson
//import sheridan.wrimicha.assignment3.network.FlowerDataApi
//import sheridan.wrimicha.assignment3.network.FlowerJson
//import sheridan.wrimicha.assignment3.network.IMAGE_FOLDER_URL
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//import javax.inject.Inject
//
//class WeatherRepositoryWebRoom @Inject constructor(
//    private val weatherDao: WeatherDao
//) : WeatherRepository {
//
//    override fun getAll(): Flow<List<Weather>> =
//        weatherDao.getAll()
//            .map { entityList ->
//                entityList.map { entity ->
//                    entity.asFlower()
//                }
//            }.flowOn(Dispatchers.IO)
//
//    override fun get(id: String): Flow<Weather> =
//        flowerDao.get(id)
//            .map { entity -> entity.asFlower() }
//            .flowOn(Dispatchers.IO)
//
//    override suspend fun refresh() {
//        val catalog: CatalogJson = FlowerDataApi.retrofitService.getCatalog()
//        val entityList: List<FlowerEntity> =
//            catalog.flowers.map { flowerJson ->
//                flowerJson.asEntity()
//            }
//        flowerDao.insert(entityList)
//    }
//
//    override suspend fun clear() {
//        flowerDao.deleteAll()
//    }
//}
//
//fun FlowerEntity.asFlower() =
//    Flower(
//        id = id,
//        label = label,
//        price = price,
//        text = text,
//        imageUrl = IMAGE_FOLDER_URL + imageFile,
//        wikiUrl = wikiUrl
//    )
//
//
//
//fun FlowerJson.asEntity() =
//    FlowerEntity(
//        id = id,
//        label = label,
//        price = price.substring(1).toFloat(),
//        text = text,
//        imageFile = pictures.large,
//        wikiUrl = wiki
//    )