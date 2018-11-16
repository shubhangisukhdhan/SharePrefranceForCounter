package shubhangi.taskintent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnC,btnBack;
    TextView txt1;
    int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC = findViewById(R.id.btnC);
        txt1 = findViewById(R.id.txt1);
        SharedPreferences mycount=this.getSharedPreferences("Mycounter",Context.MODE_PRIVATE);
        mCounter=mycount.getInt("count",0);
        txt1.setText("  "+mCounter);
        btnBack = findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ThirdActivity.class));

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCounter ++;
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                txt1.setText(Integer.toString(mCounter));
                SharedPreferences mycount=getSharedPreferences("Mycounter",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mycount.edit();
                editor.putInt("count",mCounter);
                editor.commit();

                txt1.setText("  "+mCounter);
            }
        });


    }
}
