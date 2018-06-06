package deswebmob.ftce.usjt.br.geodata.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import deswebmob.ftce.usjt.br.geodata.R;
import deswebmob.ftce.usjt.br.geodata.model.Pais;
import deswebmob.ftce.usjt.br.geodata.model.PaisDb;
import deswebmob.ftce.usjt.br.geodata.model.PaisesNetworking;
import deswebmob.ftce.usjt.br.geodata.view.ListaPaisesActivity;

/**
 *
 * Alessandro Lima da silva
 * R.A 201522705
 *
 */
public class MainActivity extends Activity {
    Spinner spinner;
    String continente = "";
    Context contexto;

    public static final String CHAVE = "deswebmob.ftce.usjt.br.geodata.paises";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto = this;

        // Pega o spinner do layout
        spinner = (Spinner) findViewById(R.id.spinnerContinentes);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //
                continente = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void listarPaises(View view) {

        String finalUrl;
        if (continente == "" || continente.equals("Todos")) {
            finalUrl = "all";
        } else {
            finalUrl = "region/" + continente.toLowerCase();
        }

        if (PaisesNetworking.isConnected(this)) {
            new DownloadJsonPaises().execute("https://restcountries.eu/rest/v2/" + finalUrl);
        } else {
            new BuscaBancoPaises().execute();
        }

    }
    private class DownloadJsonPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                // Busca o JSON
                paises = PaisesNetworking.buscarPaises(strings[0]);
                // Popula o banco do SQLite
                PaisDb paisDb = new PaisDb(contexto);
                paisDb.inserirPais(paises);


            } catch (IOException | SQLiteException e) {
                e.printStackTrace();
            }

            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }

    private class BuscaBancoPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                PaisDb paisDb = new PaisDb(contexto);

                if (continente.equals("Todos")) {
                    paises = paisDb.listarPaises();
                } else {
                    paises = paisDb.listarPaises(continente);
                }

            } catch (SQLiteException e) {
                e.printStackTrace();
            }

            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }
}
