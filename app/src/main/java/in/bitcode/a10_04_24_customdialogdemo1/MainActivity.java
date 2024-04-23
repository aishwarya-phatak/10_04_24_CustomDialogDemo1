package in.bitcode.a10_04_24_customdialogdemo1;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnLogoutDialog1;
    Button btnLogoutDialog2;
    Button btnLogoutDialog3;

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        btnLogoutDialog1 = findViewById(R.id.btnLogoutDialog1);
        btnLogoutDialog2 = findViewById(R.id.btnLogoutDialog2);
        btnLogoutDialog3 = findViewById(R.id.btnLogoutDialog3);
    }

    private void initListeners(){
        btnLogoutDialog1.setOnClickListener(new Btn1ClickListener());
        btnLogoutDialog2.setOnClickListener(new Btn2ClickListener());
        btnLogoutDialog3.setOnClickListener(new Btn3ClickListener());
    }

    //way 3
    class Btn3ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            LogoutDialog logoutDialog1 = new LogoutDialog(MainActivity.this);
            logoutDialog1.setOnLogoutClickListener(new MyLogoutClickListener());
            logoutDialog1.show();
        }
    }

    class MyLogoutClickListener implements LogoutDialog.OnLogoutClickListener{
        @Override
        public void onSuccess() {
            Toast.makeText(MainActivity.this, "onSuccess",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure() {
            Toast.makeText(MainActivity.this,"onFailure",Toast.LENGTH_LONG).show();
        }
    }

    //way 2
    class Btn2ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            LogoutDialog logoutDialog = new LogoutDialog(MainActivity.this);
            logoutDialog.show();
        }
    }

    //way 1
    class Btn1ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Dialog logoutDialog = new Dialog(MainActivity.this);
            logoutDialog.setContentView(R.layout.logout_dialog);
            edtUsername = logoutDialog.findViewById(R.id.edtUsername);
            edtPassword = logoutDialog.findViewById(R.id.edtPassword);
            btnLogout = logoutDialog.findViewById(R.id.btnLogout);
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edtUsername.getText().toString().equals("Bitcode") && edtPassword.getText().toString().equals("Bitcode@123")){
                        logoutDialog.dismiss();
                    }
                }
            });
            logoutDialog.show();
        }
    }
}