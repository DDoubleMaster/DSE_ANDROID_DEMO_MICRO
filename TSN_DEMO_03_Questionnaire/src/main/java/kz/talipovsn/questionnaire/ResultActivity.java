package kz.talipovsn.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        setContentView(R.layout.activity_result);

        // Переменная доступа к компоненту окна с инициализацией
        EditText editText = findViewById(R.id.editText);

        // Запрет на редактирование в компоненте "editText"
        editText.setKeyListener(null);

        // Очистка данных в компоненте "editText"
        editText.setText("");

        // Добавление данных в компонент "editText"
        editText.append(String.format("%s %s \n", "Ваш персонаж:", getIntent().getStringExtra("fio")));
        editText.append(String.format("%s %s \n", "Класс:", getIntent().getStringExtra("edu")));
        editText.append(String.format("%s %s \n", "Уникальная черта:", getIntent().getStringExtra("country")));
        editText.append(String.format("%s %s \n", "Тип:", getIntent().getStringExtra("gender")));
    }

    // МЕТОД ДЛЯ КНОПКИ НАЗАД
    public void onBack(View v) {
        Intent intent = new Intent(ResultActivity.this, HelloActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        this.startActivity(intent);
        finish();
    }

    // МЕТОД ДЛЯ КНОПКИ ВЫХОДА
    public void onExit(View v) {
        finishAffinity();
    }

}
