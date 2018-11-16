package shubhangi.taskintent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button btnB,btnBack;
    TextView txt3;
    int mCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnB = findViewById(R.id.btnB);
        txt3 = findViewById(R.id.txt3);
        SharedPreferences mycount=this.getSharedPreferences("Mycounter",Context.MODE_PRIVATE);
        mCounter=mycount.getInt("countV",0);
        txt3.setText("  "+mCounter);
        btnBack = findViewById(R.id.btnBack);
        btnBack = findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ThirdActivity.this,SecondActivity.class));

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCounter ++;
                startActivity(new Intent(ThirdActivity.this,MainActivity.class));
                txt3.setText(Integer.toString(mCounter));
                SharedPreferences mycount=getSharedPreferences("Mycounter",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mycount.edit();
                editor.putInt("countV",mCounter);
                editor.commit();

                txt3.setText("  "+mCounter);
            }
        });

    }
}
