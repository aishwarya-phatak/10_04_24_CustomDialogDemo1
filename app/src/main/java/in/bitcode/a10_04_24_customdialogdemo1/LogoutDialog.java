package in.bitcode.a10_04_24_customdialogdemo1;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class LogoutDialog extends Dialog {

    public interface OnLogoutClickListener{
        void onSuccess();
        void onFailure();
    }

    private OnLogoutClickListener onLogoutClickListener;

    public void setOnLogoutClickListener(OnLogoutClickListener onLogoutClickListener){
        this.onLogoutClickListener = onLogoutClickListener;
    }

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogout;

    public LogoutDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.logout_dialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new BtnLogoutClickListener());
    }

    class BtnLogoutClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (edtUsername.getText().toString().equals("Bitcode") &&
                    edtPassword.getText().toString().equals("Bitcode@123")) {
                onLogoutClickListener.onSuccess();
               // Log.e("success", "Success");
            } else {
                onLogoutClickListener.onFailure();
                //Log.e("failure", "Failure");
            }
        }
    }
}