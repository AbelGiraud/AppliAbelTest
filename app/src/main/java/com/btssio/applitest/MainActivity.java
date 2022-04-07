package com.btssio.applitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etlogin;
    private EditText etpasse;
    private Button btEnvoyer;
    private Spinner spListe;
    private String choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etlogin = (EditText) findViewById(R.id.etlogin);
        etpasse = (EditText) findViewById(R.id.etpasse);
        btEnvoyer = (Button) findViewById(R.id.BtEnvoyer);
        spListe = (Spinner) findViewById(R.id.spListe);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.niveau, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spListe.setAdapter(adapter);

        spListe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choix = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapter.getContext(), choix,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toResult();
            }
        });
    }

        private void toResult(){
            Intent intent = new Intent (this, MainActivity2.class);
            intent.putExtra("nom", etlogin.getText().toString());
            intent.putExtra("pass", etpasse.getText().toString());
            intent.putExtra("choix",choix);
            startActivity(intent);

        }
    }


}