package com.bamsac.composicionnutricional;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spTipoAlimento;
    ListView lvAlimento;
    Button  btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnAgregar = (Button)findViewById(R.id.btnAgregar);
        this.spTipoAlimento = (Spinner)findViewById(R.id.spnTipoAlimento);
        this.lvAlimento = (ListView) findViewById(R.id.lvAlimento);

        cargarTipoAlimento();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Seleccion = new Intent(MainActivity.this, Seleccion_Alimentos.class);
                startActivity(Seleccion);
            }
        });
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
