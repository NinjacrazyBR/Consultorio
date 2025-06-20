package com.example.consultorio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SelecionarDataActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private String dataSelecionada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_data);

        calendarView = findViewById(R.id.calendarView);
        Button btnSelecionarHorario = findViewById(R.id.btnSelecionarHorario);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            dataSelecionada = dayOfMonth + "/" + (month + 1) + "/" + year;
        });

        String servico = getIntent().getStringExtra("servico");
        btnSelecionarHorario.setOnClickListener(v -> {
            if (!dataSelecionada.isEmpty()) {
                Intent intent = new Intent(this, com.example.consultorio.SelecionarHorarioActivity.class);
                intent.putExtra("data", dataSelecionada);
                intent.putExtra("servico", servico);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Selecione uma data primeiro!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}