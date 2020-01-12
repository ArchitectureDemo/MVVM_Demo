package mvvm.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import mvvm.activity.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        LoginViewModelFactory factory = new LoginViewModelFactory();
        ViewModelProvider provider = ViewModelProviders.of(this, factory);
        loginViewModel = provider.get(LoginViewModel.class);
        binding.setData(loginViewModel);
        binding.setLifecycleOwner(this);

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(binding.username.getText().toString(), binding.password.getText().toString());
            }
        };
        binding.username.addTextChangedListener(afterTextChangedListener);
        binding.password.addTextChangedListener(afterTextChangedListener);

        loginViewModel.loginFormState.observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                binding.login.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getNameError() != null) {
                    binding.username.setError(loginFormState.getNameError());
                }
                if (loginFormState.getPwdError() != null) {
                    binding.password.setError(loginFormState.getPwdError());
                }
            }
        });


//        loginViewModel.loginResult.observe(this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                String welcome = "欢迎 " + loginResult.getSuccess();
//                Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//            }
//        });
    }

}
