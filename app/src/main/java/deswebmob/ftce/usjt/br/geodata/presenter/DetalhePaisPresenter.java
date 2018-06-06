package deswebmob.ftce.usjt.br.geodata.presenter;

import deswebmob.ftce.usjt.br.geodata.model.Pais;

/**
 * Alessandro Lima da silva
 * R.A 201522705
 */

public class DetalhePaisPresenter implements Presenter {

    private Pais model;
    DetalhePaisView view;

    public DetalhePaisPresenter(DetalhePaisView view){
        this.view = view;
        model = new Pais();
    }

    @Override
    public void onCreate() {
        model = new Pais();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void mostrar(Pais pais){
        // Pega o país selecionado
        this.configurarView(pais);
    }

    public void configurarView(Pais pais) {
        view.configurarView(pais);
    }

}