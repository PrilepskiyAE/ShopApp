package com.prilepskiy.core.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.prilepskiy.core.domain.interactors.GetBannerTestUseCase
import com.prilepskiy.core.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.core.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.core.domain.interactors.GetProductCashUseCase
import com.prilepskiy.core.domain.interactors.GetProductInfoCashUseCase
import com.prilepskiy.core.domain.interactors.GetProductInfoNetworkUseCase
import com.prilepskiy.core.domain.interactors.GetProductNetworkUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.model.MealInfoModel
import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.job
import kotlinx.coroutines.launch


class HomeFragmentViewModel(
    private val getProductNetworkUseCase: GetProductNetworkUseCase,
    private val getProductInfoNetworkUseCase: GetProductInfoNetworkUseCase,
    private val getCategoryNetworkUseCase: GetCategoryNetworkUseCase,
     private val getCategoryCashUseCase: GetCategoryCashUseCase,
    private val getProductCashUseCase: GetProductCashUseCase,
    private val getProductInfoCashUseCase: GetProductInfoCashUseCase,
    private val getBannerTestUseCase: GetBannerTestUseCase
) : BaseViewModel() {
    private val _categoryModel: MutableStateFlow<List<CategoryModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val categoryModel = _categoryModel.asStateFlow()
    private val tempTegs = mutableSetOf<CategoryModel>()
    private val _bannerModel: MutableStateFlow<List<String>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val bannerModel=  _bannerModel.asStateFlow()

    private val _mealModel: MutableStateFlow<List<MealModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val mealModel = _mealModel.asStateFlow()


    private val _mealInfoModel: MutableStateFlow<List<MealInfoModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val mealInfoModel = _mealInfoModel.asStateFlow()

    fun getBanners(){
        viewModelScope.launch {
            getBannerTestUseCase.invoke().collectLatest {
                _bannerModel.emit(it)
            }
        }
    }

    fun getMeat(categoryName:String){
        viewModelScope.launch {
val securety:Boolean=true
            when (val result = getProductNetworkUseCase(categoryName)){

                is ActionResult.Success -> {

                    Log.d(TAG, "getMeat success: ${result.data.size}")
                    _mealModel.emit(result.data)
                }
                is ActionResult.Error ->{
                    Log.d(TAG, "getMeat: error ${result.errors}")
                    getProductCashUseCase(categoryName).collect {
                        _mealModel.emit(it)
                        this.coroutineContext.job.cancel()
                    }
                }
            }

        }
    }
    fun getCategory(){
        viewModelScope.launch {
            when (val result = getCategoryNetworkUseCase()){
                is ActionResult.Success -> {
                    Log.d(TAG, "getCategory success: ${result.data.size}")
                    _categoryModel.emit(result.data)
                }
                is ActionResult.Error ->{
                    Log.d(TAG, "getCategory: error ${result.errors}")
                    getCategoryCashUseCase().collect {
                        _categoryModel.emit(it)
                    }
                }
            }

        }
    }
    fun getInfoMeat(id:String){
        viewModelScope.launch {
            when (val result = getProductInfoNetworkUseCase(id)){
                is ActionResult.Success -> {

                    Log.d(TAG, "getInfoMeat success: ${result.data.size}")
                    _mealInfoModel.emit(result.data)
                }
                is ActionResult.Error ->{
                    Log.d(TAG, "getInfoMeat: error ${result.errors}")
                    getProductInfoCashUseCase(id).collect {
                        _mealInfoModel.emit(it)
                    }
                }
            }

        }


    }
    fun activatioTeg(item: CategoryModel, tagsList: List<CategoryModel>) {
        viewModelScope.launch {


            var stationItems = mutableListOf<CategoryModel>()
            tagsList.forEach {
                stationItems.add(it.copy(isActive = false))
            }
            var updatedItem = stationItems.find { it.strCategory == item.strCategory }
            val index = stationItems.indexOf(updatedItem)
            if (updatedItem != null) {
                updatedItem = updatedItem.copy(isActive = true)
            }
            if (index == -1) {
                _categoryModel.emit(tempTegs.toList())
            }
            stationItems = stationItems.toMutableList().apply {
                if (updatedItem != null) {
                    this[index] = updatedItem
                }
            }

            _categoryModel.emit(stationItems)
        }
    }
    companion object{
        const val TAG="HomeFragmentViewModel"
    }
}