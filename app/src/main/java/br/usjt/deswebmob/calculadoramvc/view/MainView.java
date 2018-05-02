package br.usjt.deswebmob.calculadoramvc.view;

/**
 * Created by arqdsis on 02/05/2018.
 */

public interface MainView {

    String getValor1();
    String getValor2();
    String getOperador(); // foram criados pois precisamos destes métodos no mainpresenter
    void setResultado(String resultado);
}
