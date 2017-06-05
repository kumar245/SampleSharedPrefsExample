package com.kumar.user.samplesharedprefsexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button button;
    private static final String  PREFS_NAME="MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);
        textView= (TextView) findViewById(R.id.textView2);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor=preferences.edit();
                if (editText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter a Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("name",editText.getText().toString());
                    editor.commit();
                }

            }
        });
        SharedPreferences prefs=getSharedPreferences(PREFS_NAME,0);
            if (prefs.contains("name")){
                String UserName=prefs.getString("name","not found");
                textView.setText("You are " + UserName);

            }
            else {
                textView.setText("");
        }

    }

}
