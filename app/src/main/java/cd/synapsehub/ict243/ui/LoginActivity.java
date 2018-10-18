package cd.synapsehub.ict243.ui;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import cd.synapsehub.ict243.MainActivity;
import cd.synapsehub.ict243.R;
import cd.synapsehub.ict243.model.Member;
import cd.synapsehub.ict243.sql.SqlDbHelper;
import cd.synapsehub.ict243.utils.PreferencesUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //private final AppCompatActivity activity=LoginActivity.this;

    private EditText userEmail, userPassword;
    private Button getConnect, getForgotten;
    private TextView txtNoAccount;
    private Member ictUser;
    private SqlDbHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initObjects();

        ictUser.setEmail("admin@ict243.org");
        ictUser.setPassword("ict243");
        ictUser.setName("Administrateur");

        initViews();

        databaseHelper.addMember(ictUser);

        checkFirstIfPrefsValues();

        setListeners();



    }

    private void initObjects(){
        databaseHelper=new SqlDbHelper(getApplicationContext());
        ictUser=new Member();
    }

    private void initViews(){
        userEmail=findViewById(R.id.edtUsernamer);
        userPassword=findViewById(R.id.edtPassword);
        getConnect= findViewById(R.id.button_signin);
        getForgotten= findViewById(R.id.btnForget);
        txtNoAccount= findViewById(R.id.noAccount);

    }


    private void setListeners(){
        getConnect.setOnClickListener(this);
        getForgotten.setOnClickListener(this);
        txtNoAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnForget:
                //Code ici
                break;
            case R.id.button_signin:
                //Utilisation des SharedPreferences
                //loginAndSaveSharedPreferences(userEmail.getText().toString(),userPassword.getText().toString());

                verifyFromSqLite();

                break;
            case R.id.noAccount:
                Intent intentRegister = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intentRegister);
                break;
        }

    }



    /**
     * Quand on utilise les Sharedprefences
     * @param Email
     * @param Password
     */
    private void loginAndSaveSharedPreferences(String Email,String Password){
        if(Email.toString().equals(ictUser.getEmail().toString()) &&
                Password.toString().equals(ictUser.getPassword().toString())){
            PreferencesUtils.saveEmail(Email,this);
            PreferencesUtils.savePassword(Password,this);
            //Passe la valeur dans un bundle
           /* Intent adresseEmail=new Intent(activity,MainActivity.class);
            adresseEmail.putExtra("EmailUSER",userEmail.getText().toString());
            startActivity(adresseEmail);*/
        } else{
            Toast.makeText(getApplicationContext(),"Mot de passe errone",Toast.LENGTH_LONG).show();
        }

    }

    /**
     * ce code va verifier si il existe des valeurs dans les SharedPreferences, si oui, ca passe directement a l'activity
     */
    private void checkFirstIfPrefsValues(){
        //Check si il ya des valeurs deja dans les preferences
        if(PreferencesUtils.getEmail(this)!= null && PreferencesUtils.getPassword(this)!=null){
            Intent MainActivity=new Intent(LoginActivity.this, cd.synapsehub.ict243.MainActivity.class);
            startActivity(MainActivity);
        }else{
            // a mettre code ici
            userEmail.requestFocus();
        }
    }

    /**
     * verify directement a partir de SQLite
     */
    private void verifyFromSqLite(){
        if (databaseHelper.checkUser(userEmail.getText().toString().trim()
                , userPassword.getText().toString().trim())) {
            //Save in sqlite

            //save in prefs
            PreferencesUtils.saveEmail(userEmail.getText().toString().trim(),this);
            PreferencesUtils.savePassword(userPassword.getText().toString().trim(),this);
            //open intent
            Intent accountsIntent = new Intent(getApplicationContext(), MainActivity.class);
            accountsIntent.putExtra("EMAIL", userEmail.getText().toString().trim());
            startActivity(accountsIntent);
        } else {
            Toast.makeText(LoginActivity.this,"Valeurs saisies incorrectes",Toast.LENGTH_LONG).show();
        }
    }

}
