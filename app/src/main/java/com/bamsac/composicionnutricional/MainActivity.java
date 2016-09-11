package com.bamsac.composicionnutricional;

import android.content.ClipData;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spTipoAlimento;
    ListView lvAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spTipoAlimento = (Spinner)findViewById(R.id.spnTipoAlimento);
        this.lvAlimento = (ListView) findViewById(R.id.lvAlimento);

        cargarTipoAlimento();
    }

    private void cargarTipoAlimento() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.alimentos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spTipoAlimento.setAdapter(adapter);

        this.spTipoAlimento.setOnItemSelectedListener(this);
        this.lvAlimento.setOnItemSelectedListener(this);
    }

    @Override
    //public boolean onCreateOptionsMenu(Menu menu){
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spnTipoAlimento:
                TypedArray arrayAlimentos = getResources().obtainTypedArray( + R.array.array_tipos_a_alimentos);
                CharSequence[] alimentos = arrayAlimentos.getTextArray(position);
                arrayAlimentos.recycle();

                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, alimentos);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
                this.lvAlimento.setAdapter(adapter); break;

            case R.id.lvAlimento:break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
