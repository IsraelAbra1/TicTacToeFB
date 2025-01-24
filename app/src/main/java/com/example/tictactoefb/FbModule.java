package com.example.tictactoefb;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FbModule
{
    private Context context;
    public FbModule(Context context) {
        this.context = context;

        setPlayInFireBase(null);  // TODO: 26/11/2023 1 add 
        initFirebaseListener();
    }

    private void initFirebaseListener() {
        // הפונקציה יוצרת מאזין ב FireBase
        //
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("play");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Position position = snapshot.getValue(Position.class);
                //Toast.makeText(context, "onDataChange " + play, Toast.LENGTH_SHORT).show();
                if(position != null)
                    ((GameActivity)context).setPlayInGameActivity(position); // TODO: 26/11/2023 2 add 
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void setPlayInFireBase(Position position) {
        // write to Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("play");
        reference.setValue(position);
    }
}
