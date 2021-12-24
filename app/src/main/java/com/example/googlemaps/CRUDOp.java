package com.example.googlemaps;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class CRUDOp {

    private DatabaseReference databaseReference;

    public CRUDOp() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Loc.class.getSimpleName());
    }

    public Task<Void> add(Loc loc) {
        return databaseReference.push().setValue(loc.toMap());
    }


}
