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
import com.google.android.material.textfield.TextInputLayout;


public class AddUser extends AppCompatActivity implements TextWatcher{

    TextInputLayout iname, iage, iaddress;
    Button button;
    String name, address, age;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        iname = findViewById(R.id.input_fname);
        iage = findViewById(R.id.input_age);
        iaddress = findViewById(R.id.input_address);
        button = findViewById(R.id.button_adduser);


        iname.getEditText().addTextChangedListener(this);
        iage.getEditText().addTextChangedListener(this);
        iaddress.getEditText().addTextChangedListener(this);

        toolbar = findViewById(R.id.tooladd);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUser.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(name,address,age);
                ArrayUser.datauser.add(new User(name,address,age + " Years Old"));
                Intent intent = new Intent(AddUser.this, MainActivity.class);
                intent.putExtra("dataUser", user);
                startActivity(intent);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        name = iname.getEditText().getText().toString().trim();
        age = iage.getEditText().getText().toString().trim();
        address = iaddress.getEditText().getText().toString().trim();

        if (!name.isEmpty() && !address.isEmpty() && !age.isEmpty()){
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}