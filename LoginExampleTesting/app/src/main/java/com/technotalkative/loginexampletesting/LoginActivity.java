package com.technotalkative.loginexampletesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.edUserName)
    EditText edUserName;

    @BindView(R.id.edPassword)
    EditText edPassword;

    private Unbinder unbinder;
    private LoginPresenterImpl loginPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);

        loginPresenterImpl = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.btnLogin)
    void btnLoginClick(View view) {

        loginPresenterImpl.onLoginClicked();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    @Override
    public String getUserName() {
        return edUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return edPassword.getText().toString();
    }

    @Override
    public void showUserNameError(int resID) {
        edUserName.setError(getString(resID));
        edUserName.requestFocus();
    }

    @Override
    public void showPasswordError(int resID) {
        edPassword.setError(getString(resID));
        edPassword.requestFocus();
    }

    @Override
    public void startMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
