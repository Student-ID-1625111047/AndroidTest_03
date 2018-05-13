package student_1625111047.androidtest_03;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class Outer extends AppCompatActivity implements View.OnClickListener {
    TextView TopText;
    public Outer(TextView textview) {
        TopText = textview;
    }
    public void onClick(View view) {
        TopText.setText("外部类");
    }
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TopText;

    Button B1,B2,B3,B4,B5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class Inner implements View.OnClickListener {
            public void onClick(View view) {
                TopText.setText("内部类");
            }
        }

        TopText = (TextView) findViewById(R.id.TopText);
        B1 = (Button) findViewById((R.id.button1));
        B2 = (Button) findViewById((R.id.button2));
        B3 = (Button) findViewById((R.id.button3));
        B4 = (Button) findViewById((R.id.button4));
        B5 = (Button) findViewById((R.id.button5));

        B5.setOnClickListener(new Inner());

        B4.setOnClickListener(new Outer(TopText));

        B3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TopText.setText("匿名内部类");
                    }
                }
        );

        B2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TopText.setText("Activity");
    }

    public void Lable(View view){
        TextView LableText = (TextView) findViewById(R.id.TopText);
        LableText.setText("绑定到标签");
    }
}
