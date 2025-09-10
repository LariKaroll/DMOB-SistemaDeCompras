package com.example.sistemadecompras;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    CheckBox chkarroz, chkcarne, chkfeijao, chkleite;
    Button bttotal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        chkarroz = findViewById(R.id.chkarroz);
        chkcarne = findViewById(R.id.chkcarne);
        chkfeijao = findViewById(R.id.chkfeijao);
        chkleite = findViewById(R.id.chkleite);
        bttotal = findViewById(R.id.bttotal);

        bttotal.setOnClickListener(v -> {
            double  total = 0;
            if(chkarroz.isChecked())
                total += 2.69;
            if(chkcarne.isChecked())
                total += 10.90;
            if(chkfeijao.isChecked())
                total += 2.30;
            if(chkleite.isChecked())
                total += 5.00;

            AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
            DecimalFormat df = new DecimalFormat("#.##");



            dialogo.setTitle("Aviso");
            dialogo.setMessage("Valor total da compra : R$ " + df.format(total));
            dialogo.setNeutralButton("Pagamento", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intentTelaPagmento = new Intent(MainActivity.this, activity2Pagamento.class);
                    startActivity(intentTelaPagmento);
                }
            });
            dialogo.show();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}