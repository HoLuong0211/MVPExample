package ominext.com.mvpexample.mvp.presenter;

import ominext.com.mvpexample.api.ApiRequest;
import ominext.com.mvpexample.listener.OnResponse;
import ominext.com.mvpexample.mvp.view.LoginView;

/**
 * Created by P.Tuan on 2/10/2017.
 */

public class LoginPresenter {

    private LoginView mLoginView;

    public LoginPresenter(LoginView view) {
        this.mLoginView = view;
    }

    public void login(String userCode, String password) {
        ApiRequest.login(userCode, password, new OnResponse() {

            @Override
            public void onStart() {
                super.onStart();
                mLoginView.showProgressDialog();
            }

            @Override
            public void onResponseSuccess(String tag, String response) {
                mLoginView.onLoginSuccess(tag, response);
            }

            @Override
            public void onResponseError(String tag, String message) {
                mLoginView.onLoginError(tag, message);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                mLoginView.hideProgressDialog();
            }
        });
    }
}
