package fr.jado.basic_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CurrencyChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_chooser);

    findViewById(R.id.usaButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Currency c = new Currency(R.drawable.flag_usa, 0.99f, "$") ;
            navigateToMainActivity(c);
        }
    });

    findViewById(R.id.japanButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Currency c = new Currency(R.drawable.flag_japan, 142f, "¥") ;
            navigateToMainActivity(c);
            }
    });

    findViewById(R.id.ukButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Currency c = new Currency(R.drawable.flag_uk, 0.87f, "£") ;
                navigateToMainActivity(c);

            }
        });

    }

    private void navigateToMainActivity(Currency c) {

        Intent intent = new Intent(CurrencyChooserActivity.this, MainActivity.class);
        intent.putExtra("currency", c);
        intent.putExtra("flagId", c.getFlagId());
        intent.putExtra("rate", c.getRate());
        intent.putExtra("symbol", c.getSymbol());

        startActivity(intent);
    }
}