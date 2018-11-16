package shubhangi.taskintent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btnA,btnBack;
    TextView txt2;
    int mCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnA = findViewById(R.id.btnA);
        txt2 = findViewById(R.id.txt2);
        SharedPreferences mycount=this.getSharedPreferences("Mycounter",Context.MODE_PRIVATE);
        mCounter=mycount.getInt("countS",0);
        txt2.setText("  "+mCounter);
        btnBack = findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SecondActivity.this,MainActivity.class));

            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCounter ++;
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
                txt2.setText(Integer.toString(mCounter));
                SharedPreferences mycount=getSharedPreferences("Mycounter",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mycount.edit();
                editor.putInt("countS",mCounter);
                editor.commit();

                txt2.setText("  "+mCounter);
            }
        });

    }
}

