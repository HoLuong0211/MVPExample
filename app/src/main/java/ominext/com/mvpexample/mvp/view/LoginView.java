package ominext.com.mvpexample.mvp.view;

/**
 * Created by P.Tuan on 2/10/2017.
 */

public interface LoginView {

    void showProgressDialog();

    void hideProgressDialog();

    void onLoginSuccess(String tag, String response);

    void onLoginError(String tag, String message);
}
