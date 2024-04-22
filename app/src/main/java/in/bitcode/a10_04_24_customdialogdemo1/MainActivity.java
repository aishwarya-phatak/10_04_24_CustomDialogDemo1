package in.bitcode.a10_04_24_customdialogdemo1;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }

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