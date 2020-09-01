package com.example.duresources;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SetUpNewPassActivity extends AppCompatActivity {

    EditText newPasswordText ;
    EditText newPasswordText2 ;
    Button submitBtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_new_pass);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Users");

        newPasswordText = findViewById(R.id.editTextTextPassword);
        newPasswordText2 = findViewById(R.id.editTextTextPassword2);
        submitBtn= findViewById(R.id.button7);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newPasswordText.getText().toString().equals(newPasswordText2.getText().toString())){
                    //change password
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                SignUpData user = dataSnapshot.getValue(SignUpData.class);
                                if(user!=null){user.set_password(newPasswordText.getText().toString());}
                                Toast.makeText(getApplicationContext(), "Password changed!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SetUpNewPassActivity.this, HomeActivity.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                else{
                    newPasswordText2.setError("Passwords do not match!");
                    newPasswordText2.requestFocus();
                }
            }
        });


    }
}