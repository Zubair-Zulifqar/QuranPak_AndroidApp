package com.example.quranapp_assignment_2_bsef20a504_zubairzulifqar;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    ListView listView = null;
    Button button=null;
    TextInputEditText editText=null;
    Names surahName=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list1);
        surahName=new Names();
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,surahName.ParahName);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,SurahDisplay.class);
                intent.putExtra("SurahNumber",i);

                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SurahDisplay.class);
                String tem=editText.getText().toString();
                intent.putExtra("surahNumberButton", Integer.parseInt(tem));
                startActivity(intent);
            }
        });
    }
}