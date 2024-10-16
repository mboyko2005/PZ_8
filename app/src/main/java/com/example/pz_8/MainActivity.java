package com.example.pz_8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, companyInput, ageInput, phoneInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Инициализация полей ввода
        nameInput = findViewById(R.id.nameInput);
        companyInput = findViewById(R.id.companyInput);
        ageInput = findViewById(R.id.ageInput);
        phoneInput = findViewById(R.id.phoneInput);

        Button sendButton = findViewById(R.id.sendButton);
        // Установка слушателя на кнопку "Сохранить"
        sendButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String company = companyInput.getText().toString().trim();
            String ageStr = ageInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();

            // Проверка на заполненность всех полей
            if (name.isEmpty() || company.isEmpty() || ageStr.isEmpty() || phone.isEmpty()) {
                Toast.makeText(MainActivity.this, "Все поля обязательны для заполнения", Toast.LENGTH_SHORT).show();
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Возраст должен быть числом", Toast.LENGTH_SHORT).show();
                return;
            }

            // Создание объекта пользователя
            User user = new User(name, company, age, phone);

            // Переход на вторую активность с передачей объекта пользователя
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        });
    }
}
