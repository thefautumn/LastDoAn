package edu.huflit.myapplication.Activity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.huflit.myapplication.R;

public class ManHinhLogin extends AppCompatActivity {

    Button btnDangKy,btnDangNhap;
    EditText edtTaiKhoan,edtMatKhau;
    FirebaseAuth mAuth;
    ImageView img_bh;
    ProgressBar progressBar;
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser !=null){
            Intent intent = new Intent(ManHinhLogin.this, DanhSachGiaoDich.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_login);
        mAuth=FirebaseAuth.getInstance();
        btnDangKy = findViewById(R.id.next_dangky);
        btnDangNhap = findViewById(R.id.btn_dn);
        edtTaiKhoan = findViewById(R.id.edt_tk);
        edtMatKhau = findViewById(R.id.edt_mk);
        progressBar = findViewById(R.id.progressBar);
        img_bh = findViewById(R.id.img_backhome);

        img_bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
                finish();
            }
        });


        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhRegister.class);
                startActivity(i);
                finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(edtTaiKhoan.getText());
                password = String.valueOf(edtMatKhau.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ManHinhLogin.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(ManHinhLogin.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), TrangChu.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(ManHinhLogin.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        //Firebase


//        FirebaseDatabase db  = FirebaseDatabase.getInstance();
//        DatabaseReference table_user = db.getReference("User");
//        btnDangKy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),ManHinhRegister.class);
//                startActivity(i);
//            }
//        });
//        btnDangNhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                ProgressDialog mDialog = new ProgressDialog(ManHinhLogin.this);
//                mDialog.setMessage("Vui lòng chờ...");
//                mDialog.show();
//                table_user.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                      if(snapshot.child(edtTaiKhoan.getText().toString()).exists())
//                      {
//                          mDialog.dismiss();
//                            User user = snapshot.child(edtTaiKhoan.getText().toString()).getValue(User.class);
//                            if(user.getPassword().equals(edtMatKhau.getText().toString()))
//                            {
//                                Intent i= new Intent(getApplicationContext(), TrangChu.class);
//                                startActivity(i);
//
//                            }
//                            else{
//                                Toast.makeText(ManHinhLogin.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
//                            }
//
//
//                            }
//                      }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            }
//        });
    }
}