package mvvm.activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import mvvm.data.LoginRepository;

public class LoginViewModel extends ViewModel {

    MutableLiveData<String> loginResult = new MutableLiveData<>();
    LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public void login(String username) {
        String result =  loginRepository.login(username);
        loginResult.setValue(result);
    }

    //布局文件绑定数据时，必须要有get方法
    public MutableLiveData<String> getLoginResult() {
        return loginResult;
    }

}


/*

ObservableField<String> name = new ObservableField<>();
MutableLiveData<String> name = new MutableLiveData<>();

LiveData.setValue()  在主线程调用
LiveData.postValue() 可以在后台线程中调用

LiveData是一个数据持有类，持有数据并且这个数据能被观察者所监听到，
而且它是和Lifecycle绑定的，具有生命周期感知，解决内存泄漏和引用问题。
和普通observable不同的是，LiveData能感知activity，fragment，service组件的生命周期变化，从而确保数据的更新是在组件的active状态

*/