package ominext.com.mvpexample.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ominext.com.mvpexample.R;
import ominext.com.mvpexample.mvp.model.User;
import ominext.com.mvpexample.mvp.presenter.LoginPresenter;
import ominext.com.mvpexample.utill.KeyboardUtils;
import ominext.com.mvpexample.utill.ProgressDialogUtils;
import ominext.com.mvpexample.mvp.view.LoginView;

/**
 * Created by LuongHH on 3/17/2017.
 */

public class LoginFragment extends Fragment implements LoginView {

    private ProgressDialog mProgressDialog;
    private LoginPresenter mPresenter;

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private TextView tvName;
    private TextView tvNickname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUsername = (EditText) view.findViewById(R.id.et_user_name);
        etPassword = (EditText) view.findViewById(R.id.et_password);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        mProgressDialog = ProgressDialogUtils.create(getContext());
        mPresenter = new LoginPresenter(this);

        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvNickname = (TextView) view.findViewById(R.id.tv_nickname);
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onLoginSuccess(String tag, String response) {
        Gson gson = new GsonBuilder().create();
        User user = gson.fromJson(response, User.class);
        tvName.setText(user.name);
        tvNickname.setText(user.nickname);
    }

    @Override
    public void onLoginError(String tag, String message) {
        showToast(message);
        clearData();
    }

    private void login() {
        KeyboardUtils.hideSoftKeyboard(getContext());
        clearData();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.login(username, password);
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    private void clearData() {
        tvName.setText("");
        tvNickname.setText("");
    }
}
