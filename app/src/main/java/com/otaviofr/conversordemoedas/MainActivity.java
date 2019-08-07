package com.otaviofr.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValor = findViewById(R.id.edit_valor);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.button_calcular);
        this.mViewHolder.buttonLimpar = findViewById(R.id.button_limpar);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);
        this.mViewHolder.buttonLimpar.setOnClickListener(this);

        this.ClearValores();
    }

    @Override
    public void onClick(View v) {
        //BOTÃO CALCULAR
        if (v.getId() == R.id.button_calcular) {
            String valor = this.mViewHolder.editValor.getText().toString();
            if ("".equals(valor)) {
                Toast.makeText(this, this.getString(R.string.valor_invalido), Toast.LENGTH_SHORT).show();
            } else {
                Double real = Double.valueOf(valor);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 3.77)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 4.20)));
            }
        }
        //BOTÃO LIMPAR
        if (v.getId() == R.id.button_limpar) {
            this.mViewHolder.textDolar.setText("");
            this.mViewHolder.textEuro.setText("");
            this.mViewHolder.editValor.setText("");
        }

    }
     //INICIA OS CAMPOS EM BRANCO
    private void ClearValores() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValor;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalcular;
        Button buttonLimpar;
    }
}
