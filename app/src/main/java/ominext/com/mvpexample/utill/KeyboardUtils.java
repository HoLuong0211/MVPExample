package ominext.com.mvpexample.utill;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Vinh on 2/21/2017.
 */

public class KeyboardUtils {

    public static void hideSoftKeyboard(Context context) {
        try {
            View view = ((Activity) context).getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showSoftKeyboard(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void requestFocus(final Context context, final EditText editText, final boolean showSoftKeyboard) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
                if (showSoftKeyboard) {
                    KeyboardUtils.showSoftKeyboard(context, editText);
                }
            }
        }, 20);
    }

    /**
     * showSoftKeboard = true
     * @param context
     * @param editText
     */
    public static void requestFocus(final Context context, final EditText editText) {
        requestFocus(context, editText, true);
    }
}
