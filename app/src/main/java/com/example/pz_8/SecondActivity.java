package com.example.pz_8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Инициализация TextView для отображения данных
        TextView displayText = findViewById(R.id.displayText);

        // Получение объекта Intent
        Intent intent = getIntent();
        // Извлечение объекта User из Intent
        User user = intent.getParcelableExtra("user");

        if (user != null) {
            // Формирование строки с данными пользователя
            String userInfo = String.format("Имя: %s\nКомпания: %s\nВозраст: %d\nТелефон: %s",
                    user.getName(), user.getCompany(), user.getAge(), user.getPhone());
            // Установка текста в TextView
            displayText.setText(userInfo);
        }
    }
}
