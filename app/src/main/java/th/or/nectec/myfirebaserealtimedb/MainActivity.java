package th.or.nectec.myfirebaserealtimedb;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public DatabaseReference myRef;
    private TextView mFirebaseTextView;
    private int mCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_main);

        mFirebaseTextView = (TextView) findViewById(R.id.firebaseTextView);
        Typeface type = Typeface.createFromAsset(getAssets(), "ds_digital.TTF");
        mFirebaseTextView.setTypeface(type);

        // Get firebase database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String value = String.valueOf(map.get("counter"));
                mFirebaseTextView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void onClickUpdateButton(View view) {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("counter",mCounter++);

        myRef.updateChildren(value);

    }

}
