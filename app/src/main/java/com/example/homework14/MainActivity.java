package com.example.homework14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList <String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.данные);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerview);
        list= new ArrayList<>();
        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                list.add(text);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("list", list);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list.addAll(savedInstanceState.getStringArrayList("list"));
    }
}


//Флоу домашнего задания:
//На экране создать EditText , кнопку и recyclerview, при вводе текста в поле edittext ,
// нажимаете кнопку и он должен передать данные в recyclerview, далее при повороте экрана
// последние данные которые вы ввели должны сохранится,
// то есть удалили или добавили элемент,
// при повороте передается список с последними изменениями