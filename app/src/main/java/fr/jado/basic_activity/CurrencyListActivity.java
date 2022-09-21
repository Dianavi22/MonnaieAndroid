package fr.jado.basic_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class CurrencyListActivity extends AppCompatActivity {

    private List<Currency> currencies;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        currencies = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            currencies.add(new Currency(R.drawable.flag_usa, 0.99f, "$"));
            currencies.add(new Currency(R.drawable.flag_japan, 142f, "￥"));
            currencies.add(new Currency(R.drawable.flag_uk, 0.87f, "£"));
            currencies.add(new Currency(R.drawable.flag_china, 6.98f, "Ұ"));
            currencies.add(new Currency(R.drawable.flag_coree, 1341f, "₩"));
            currencies.add(new Currency(R.drawable.flag_vietnam, 2369836f, "đ"));
            currencies.add(new Currency(R.drawable.flag_brazil, 5.26676f, "R$"));



        }

            adapter = new CurrencyAdapter(currencies);

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
