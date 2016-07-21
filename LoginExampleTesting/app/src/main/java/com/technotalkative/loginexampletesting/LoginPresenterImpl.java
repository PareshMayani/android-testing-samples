package com.technotalkative.loginexampletesting;

import android.text.TextUtils;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLoginClicked() {

        String userName = loginView.getUserName();
        if (TextUtils.isEmpty(userName)) {
            loginView.showUserNameError(R.string.error_username);
            return;
        }

        String password = loginView.getPassword();
        if (TextUtils.isEmpty(password)) {
            loginView.showPasswordError(R.string.error_password);
            return;
        }

        loginView.startMainActivity();

    }
}
