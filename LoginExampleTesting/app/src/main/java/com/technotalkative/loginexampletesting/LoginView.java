package com.technotalkative.loginexampletesting;

public interface LoginView {

    String getUserName();
    String getPassword();

    void showUserNameError(int resID);
    void showPasswordError(int resID);

    void startMainActivity();
}
