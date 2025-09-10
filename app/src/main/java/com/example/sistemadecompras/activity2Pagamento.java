package com.example.sistemadecompras;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity2Pagamento extends AppCompatActivity {
    Button btdebito, btcredito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activity2_pagamento);

        Intent intentTelaPrincipal = new Intent(activity2Pagamento.this, MainActivity.class);
        AlertDialog.Builder dialogo = new AlertDialog.Builder(activity2Pagamento.this);

        btcredito = findViewById(R.id.btcredito);
        btdebito = findViewById(R.id.btdebito);

        btdebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cartão de Débito\nPagamento Realizado com Sucesso!");
                dialogo.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intentTelaPrincipal);
                    }
                });
                dialogo.show();
            }
        });

        btcredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cartão de Crédito\nPagamento Realizado com Sucesso!");
                dialogo.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intentTelaPrincipal);
                    }
                });
                dialogo.show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}