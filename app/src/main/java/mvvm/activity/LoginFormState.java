package mvvm.activity;

import androidx.annotation.Nullable;

class LoginFormState {

    @Nullable
    private String nameError;
    @Nullable private String pwdError;
    private boolean isDataValid;

    LoginFormState(@Nullable String nameError, @Nullable String pwdError) {
        this.nameError = nameError;
        this.pwdError = pwdError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.nameError = null;
        this.pwdError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    String getNameError() {
        return nameError;
    }

    @Nullable
    String getPwdError() {
        return pwdError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}
