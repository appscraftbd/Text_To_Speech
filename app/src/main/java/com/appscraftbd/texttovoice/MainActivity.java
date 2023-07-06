package com.appscraftbd.texttovoice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    EditText editText ;
    ImageView imageView;

    TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.text);
        imageView = findViewById(R.id.voice);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.length() > 0){



                textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        textToSpeech.speak(""+editText.getText().toString(),TextToSpeech.QUEUE_ADD,null,null);






                    }
                });


                }else {

                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.ic_launcher_foreground)
                            .setTitle("Text To speech")
                            .setMessage("samthing is rong.Plz text anything")
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {



                                }
                            })
                            .show();


                }





            }
        });






    }
}