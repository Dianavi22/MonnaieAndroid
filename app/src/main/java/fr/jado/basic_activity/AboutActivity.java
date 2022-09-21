package fr.jado.basic_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        //récupération des infos depuis l'intent source
        Intent srcIntent = getIntent();
        User u = srcIntent.getParcelableExtra("author");
      //  String name = srcIntent.getStringExtra("name");
      //  String email = srcIntent.getStringExtra("email");
        String versionName = srcIntent.getStringExtra("versionName");
        int versionCode = srcIntent.getIntExtra("versionCode", 1);

        //Maj UI
         TextView nameTextView = findViewById(R.id.nameTextView);
         nameTextView.setText(u.name);
        TextView emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setText(u.email);
        TextView versionTextView = findViewById(R.id.versionTextView);
        versionTextView.setText(versionName + " " + versionCode);


    }
}