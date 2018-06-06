package deswebmob.ftce.usjt.br.geodata.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import deswebmob.ftce.usjt.br.geodata.R;
import deswebmob.ftce.usjt.br.geodata.model.DetalhePaisActivity;
import deswebmob.ftce.usjt.br.geodata.model.Pais;
import deswebmob.ftce.usjt.br.geodata.model.PaisAdapter;

import static deswebmob.ftce.usjt.br.geodata.R.layout.activity_lista_paises;

/**
 *
 * Alessandro Lima da silva
 * R.A 201522705
 *
 */
public class ListaPaisesActivity extends Activity implements ListaPaisesView{
    public static final String PAIS_SELECIONADO = "br.usjt.ftce.deswebmob.dadosmundi.pais_selecionado";
    Activity activity;
    ArrayList<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_paises);

        activity = this;
        // Pega o continente que foi selecionado
        Intent intent = getIntent();
        paises = (ArrayList<Pais>) intent.getSerializableExtra(MainActivity.CHAVE);

        // Pega o listView e configura os países do continente selecionado
        ListView listView = (ListView) findViewById(R.id.listViewPaises);
        PaisAdapter adapter = new PaisAdapter(this, paises);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startNextActivity(i);
            }
        });
    }


    public void startNextActivity(int posicao) {

        Intent intent = new Intent(activity, DetalhePaisActivity.class);
        intent.putExtra(PAIS_SELECIONADO, paises.get(posicao));
        startActivity(intent);

    }
}
