package fr.jado.basic_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private Currency currency;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent srcIntent = getIntent();
        currency = srcIntent.getParcelableExtra("currency");
        int flagId = srcIntent.getIntExtra("flagId", R.drawable.flag_uk);
        ImageView flagImageView = findViewById(R.id.flagImageView);
        flagImageView.setImageResource(currency.getFlagId());

        Log.i("MainActivity", "Hello world Android !");

        Button convertButton = findViewById(R.id.ConvertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText amountEditText = findViewById(R.id.amountEditText);
                String amountStr = amountEditText.getText().toString();
                // Log.d( "MainActivity", " "+ amountStr);

                if( amountStr.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Saisissez un montant",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                float result = Float.parseFloat(amountStr) * currency.getRate();

                TextView resultText = findViewById(R.id.resultTextView);
                resultText.setText(result + " " + currency.getSymbol());
            }
        });


        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {

            User user = new User ("Pepito", "Pepito@gmail.com");

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("author", user);
               // intent.putExtra("name", "Jado");
               // intent.putExtra("email", "jade.bouiges@edu.itescia.fr");
                intent.putExtra("versionName", "v1.2.5");
                intent.putExtra("versionCode", "2");
                startActivity(intent);
            }
         });


    }
}