package deswebmob.ftce.usjt.br.geodata.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import deswebmob.ftce.usjt.br.geodata.R;

/**
 *
 * Alessandro Lima da silva
 * R.A 201522705
 *
 */
public class DetalhePaisFragment extends Fragment{
    public DetalhePaisFragment() {
        // wow, such empty
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe_pais, container, false);
    }

}
