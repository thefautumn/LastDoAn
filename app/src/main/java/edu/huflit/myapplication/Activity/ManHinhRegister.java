package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.huflit.myapplication.R;

public class ManHinhRegister extends AppCompatActivity {
    EditText edEmail, edPassword, edrepassword;
    Button btnRegister;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    ImageView img_res_bh;

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser !=null){
            Intent intent = new Intent(ManHinhRegister.this, GioiThieu.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_register);
        mAuth=FirebaseAuth.getInstance();
        edEmail = findViewById(R.id.email);
        edPassword = findViewById(R.id.password);
        edrepassword = findViewById(R.id.repassword);
        btnRegister = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar);
        img_res_bh = findViewById(R.id.img_res_backhome);

        //
        img_res_bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
                finish();
            }
        });
        //
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(edEmail.getText());
                password =  String.valueOf(edPassword.getText());
                String confirmpassword = edrepassword.getText().toString().trim();
                if(password.isEmpty()){
                    edPassword.setError("vui lòng nhập mật khẩu");
                    return;
                }
                if (password.length()<=5){
                    edPassword.setError("Mật khẩu phải có hơn 5 kí tự");
                    return;
                }
                if (password.equals(confirmpassword)){
                    edrepassword.setError("Mật khẩu không đúng");
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(ManHinhRegister.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(ManHinhRegister.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()){
                                    Toast.makeText(ManHinhRegister.this,"Account Created.",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),ManHinhLogin.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Toast.makeText(ManHinhRegister.this,"Authentication Failed.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}