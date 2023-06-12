package com.example.quranapp_assignment_2_bsef20a504_zubairzulifqar;

import androidx.appcompat.app.AppCompatActivity;
import static java.lang.Integer.parseInt;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class SurahDisplay extends AppCompatActivity {
    ListView listView=null;
    Ayat ayat=null;
    Names name=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_display);
        int myString=0;
        myString=getIntent().getIntExtra("SurahNumber",1);
        myString=getIntent().getIntExtra("surahNumberButton",1);
        System.out.println(myString);
        int i=myString;
        listView=findViewById(R.id.ayatList);
        name=new Names();
        ayat=new Ayat();
        int start= name.SSP[i];
        int end=name.SSP[i+1]-1;
        String[] ayats=Arrays.copyOfRange(ayat.QuranArabicText, start, end);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ayats);
        listView.setAdapter(arrayAdapter);

    }
}