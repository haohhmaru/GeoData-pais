package deswebmob.ftce.usjt.br.geodata.model;

import android.widget.ImageView;
import android.widget.TextView;
/**
 *
 * Alessandro Lima da silva
 * R.A 201522705
 *
 */
public class ViewHolderPais {
    ImageView bandeira;
    TextView nome, regiao, capital;

    public ViewHolderPais(ImageView bandeira, TextView nome, TextView regiao, TextView capital) {
        this.bandeira = bandeira;
        this.nome = nome;
        this.regiao = regiao;
        this.capital = capital;
    }

    public ImageView getBandeira() {
        return bandeira;
    }

    public void setBandeira(ImageView bandeira) {
        this.bandeira = bandeira;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getRegiao() {
        return regiao;
    }

    public void setRegiao(TextView regiao) {
        this.regiao = regiao;
    }

    public TextView getCapital() {
        return capital;
    }

    public void setCapital(TextView capital) {
        this.capital = capital;
    }
}
