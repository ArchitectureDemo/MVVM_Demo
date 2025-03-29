package mvvm.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import mvvm.activity.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

//      ViewModelProvider provider = new ViewModelProvider(this);
        ViewModelProvider provider = new ViewModelProvider(this, new LoginViewModelFactory());
        loginViewModel = provider.get(LoginViewModel.class);

        binding.setData(loginViewModel);
        binding.setLifecycleOwner(this);

//      网络登录结果
        loginViewModel.loginResult.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String loginResult) {
                Toast.makeText(getApplicationContext(), "欢迎 " + loginResult, Toast.LENGTH_LONG).show();
            }
        });
    }

}