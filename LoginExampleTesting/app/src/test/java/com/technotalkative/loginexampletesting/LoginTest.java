package com.technotalkative.loginexampletesting;

import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest (TextUtils.class)
public class LoginTest {

    @Mock
    private LoginView loginView;

    private LoginPresenterImpl loginPresenter;

    @Before
    public void setUp() throws  Exception {
        PowerMockito.mockStatic(TextUtils.class);
        loginPresenter = new LoginPresenterImpl(loginView);
    }

    @Test
    public void shouldShowUserNameErrorWhenEmpty() throws Exception {

        when(TextUtils.isEmpty("")).thenReturn(true);
        when(loginView.getUserName()).thenReturn("");
        loginPresenter.onLoginClicked();

        verify(loginView).showUserNameError(R.string.error_username);
    }

    @Test
    public void shouldShowPasswordErrorWhenEmpty() throws Exception {

        when(TextUtils.isEmpty("")).thenReturn(true);
        when(loginView.getPassword()).thenReturn("");
        loginPresenter.onLoginClicked();

        verify(loginView).showPasswordError(R.string.error_password);
    }

    @Test
    public void shouldStartMainActivityWhenUserNameAndPasswordAreCorrect() throws Exception {

        when(TextUtils.isEmpty(anyString())).thenReturn(false);

        when(loginView.getUserName()).thenReturn("paresh");
        when(loginView.getPassword()).thenReturn("secret");

        loginPresenter.onLoginClicked();

        verify(loginView).startMainActivity();


    }
  }