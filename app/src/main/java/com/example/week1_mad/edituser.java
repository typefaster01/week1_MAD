package com.example.week1_mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.example.week1_mad.model.ArrayUser;
import com.example.week1_mad.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class edituser extends AppCompatActivity implements TextWatcher {
    public static final String EXTRA_EDIT="extra";
    private User user;

    TextInputLayout nama1, umur1, alamat1;
    TextInputEditText nama2, umur2, alamat2;
    Button updatebutton;
    String nama, umur, alamat;
    Toolbar backbtn;
    String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edituser);

        if (getIntent().getParcelableExtra(EXTRA_EDIT)!= null){
            user = getIntent().getParcelableExtra(EXTRA_EDIT);
        }

        nama1 = findViewById(R.id.input_fname);
        alamat1 = findViewById(R.id.input_address);
        umur1 = findViewById(R.id.input_age);

        nama2 = findViewById(R.id.nama);
        alamat2 = findViewById(R.id.alamat);
        umur2 = findViewById(R.id.umur);

        nama2.setText(user.getNama());
        alamat2.setText(user.getAlamat());
        umur2.setText(user.getUmur());

        nama = user.getNama();
        alamat = user.getAlamat();
        umur = user.getUmur();

        nama1.getEditText().addTextChangedListener(this);
        alamat1.getEditText().addTextChangedListener(this);
        umur1.getEditText().addTextChangedListener(this);

        updatebutton = (Button) findViewById(R.id.button_edit);
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                User user = new User(nama, alamat, umur);
                Intent a = new Intent(edituser.this, MainActivity.class);
                ArrayUser.datauser.add(new User(nama, alamat, umur));
                startActivity(a);
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        nama = nama1.getEditText().getText().toString().trim();
        alamat = alamat1.getEditText().getText().toString().trim();
        umur = umur1.getEditText().getText().toString().trim();

        if (!nama.isEmpty() && !alamat.isEmpty() && !umur.isEmpty()){
            updatebutton.setEnabled(true);
        }else{
            updatebutton.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
