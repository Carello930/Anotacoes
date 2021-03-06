package com.leaoartes.anotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private PreferencesAnotation preferencesClass;
    private EditText editAnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesClass = new PreferencesAnotation(getApplicationContext());

       editAnotation = findViewById(R.id.editTextAnotation);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar texto
                String textRecover = editAnotation.getText().toString();
                if(textRecover.equals("")){

                Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
           
            }else {
                    preferencesClass.anotationSave(textRecover);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                  }
            }
        });

        //Recuperar anotação
        String anotations = preferencesClass.anotationRecover();
        if(!anotations.equals("")){

            editAnotation.setText(anotations);

        }
    }
}

