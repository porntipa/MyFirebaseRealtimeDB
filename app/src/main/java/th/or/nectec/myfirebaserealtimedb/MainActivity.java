package th.or.nectec.myfirebaserealtimedb;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    public DatabaseReference myRef;
    private TextView mFirebaseTextView;
    private int mCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseTextView = (TextView) findViewById(R.id.firebaseTextView);
        Typeface type = Typeface.createFromAsset(getAssets(), "ds_digital.TTF");
        mFirebaseTextView.setTypeface(type);
    }
}
