package com.example.laboratorywork1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView resView ;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resView = findViewById(R.id.resView);
        resView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);   //для отображения обчного лин.списка
        resView.setLayoutManager(layoutManager);
        adapter = new ListAdapter();
        resView.setAdapter(adapter);
    }

    // для закрытия по кнопке Назад
    private void openQuitApp(){
        AlertDialog.Builder quitApp = new AlertDialog.Builder(Main2Activity.this);
        quitApp.setTitle("Вы уверены, что хотите выйти?");
        quitApp.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        quitApp.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        quitApp.show();
    }

    @Override
    //переопределение метода нажатия на кнопку Назад
    public void onBackPressed(){
        openQuitApp();
    }
}
