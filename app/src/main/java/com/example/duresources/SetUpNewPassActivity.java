package com.example.duresources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetUpNewPassActivity extends AppCompatActivity {

    EditText newPasswordText ;
    EditText newPasswordText2 ;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_new_pass);

        newPasswordText = findViewById(R.id.editTextTextPassword);
        newPasswordText2 = findViewById(R.id.editTextTextPassword2);
        submitBtn= findViewById(R.id.button7);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newPasswordText.equals(newPasswordText2)){
                    //change password
                }
                else{
                    newPasswordText2.setError("Passwords do not match!");
                    newPasswordText2.requestFocus();
                    return;
                }
            }
        });
    }
}