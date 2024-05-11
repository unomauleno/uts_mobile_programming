package id.sttbandung.uts;

 import android.content.Intent;
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
    Button BtnRegister;
    private EditText Username, Password;
    private Button BtnLogin;

    private String username = "admin";
    private String password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        BtnLogin = findViewById(R.id.BtnLogin);
        BtnRegister = findViewById(R.id.BtnRegister);

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register);
            }
        });

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Username.getText().toString().equalsIgnoreCase(username) && Password.getText().toString().equalsIgnoreCase(password)){
                    Intent login = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(login);

                    Toast.makeText(MainActivity.this, "LOGIN BERHASIL!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username atau Password Yang Anda Masukan Salah!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}