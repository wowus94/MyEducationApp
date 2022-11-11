package com.example.myeducationapp.main


import com.example.myeducationapp.datasource.DataSourceLocal
import com.example.myeducationapp.datasource.DataSourceRemote
import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.presenter.Presenter
import com.example.myeducationapp.repository.RepositoryImplementation
import com.example.myeducationapp.rx.SchedulerProvider
import com.example.myeducationapp.view.base.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class MainPresenterImpl<T : AppState, V : View>(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    ),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()

) : Presenter<T, V>, com.example.myeducationapp.view.base.View {
    private var currentView: V? = null


    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {

            }
        }
    }

    override fun renderData(appState: AppState) {
        TODO("Not yet implemented")
    }
}