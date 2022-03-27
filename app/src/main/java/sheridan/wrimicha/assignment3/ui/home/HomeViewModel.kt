package sheridan.wrimicha.assignment3.ui.home

import androidx.lifecycle.*
//import ca.tetervak.flowerdata.domain.Flower
//import ca.tetervak.flowerdata.repository.FlowerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sheridan.wrimicha.assignment3.model.Weather
import sheridan.wrimicha.assignment3.repository.WeatherRepository
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

   // val weather: LiveData<List<Weather>> = repository.get().asLiveData()

    enum class Status { STARTED, REFRESHING, LOADED, ERROR }
    private val _status = MutableLiveData(Status.STARTED)
    val status: LiveData<Status> = _status

    fun refresh(){
        viewModelScope.launch(Dispatchers.IO){
            _status.postValue(Status.REFRESHING)
            delay(1500) // fake delay
            try{
                repository.refresh()
                _status.postValue(Status.LOADED)
            }catch(error: IOException){
                _status.postValue(Status.ERROR)
            }
        }
    }

//    fun clear(){
//        viewModelScope.launch(Dispatchers.IO){
//            repository.clear()
//            _status.postValue(Status.STARTED)
//        }
//    }

    fun reset(){
        _status.value = Status.STARTED
    }
}