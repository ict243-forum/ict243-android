package cd.synapsehub.ict243.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class PreferencesUtils {

    private Context monContext;

    public PreferencesUtils(){
        //constructor
    }

    public static boolean saveEmail(String email, Context context){
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor=prefs.edit();
        prefsEditor.putString(Constants.KEY_EMAIL,email);
        prefsEditor.apply();
        return true;
    }

    public static boolean savePassword(String password, Context context){
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor=prefs.edit();
        prefsEditor.putString(Constants.KEY_PASSWORD,password);
        prefsEditor.apply();
        return true;
    }

    public static String getEmail(Context context){
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_EMAIL, null);
    }

    public static String getPassword(Context context){
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_PASSWORD, null);
    }


    public void hideKeyboardFrom(View view){
        InputMethodManager imm = (InputMethodManager) monContext.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

}
