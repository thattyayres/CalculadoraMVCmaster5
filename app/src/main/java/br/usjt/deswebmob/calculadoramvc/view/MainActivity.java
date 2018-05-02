package br.usjt.deswebmob.calculadoramvc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import br.usjt.deswebmob.calculadoramvc.model.Calculadora;
import br.usjt.deswebmob.calculadoramvc.R;
import br.usjt.deswebmob.calculadoramvc.presenter.MainPresenter;
import br.usjt.deswebmob.calculadoramvc.presenter.Presenter;

public class MainActivity extends Activity implements MainView{
    EditText valor1, valor2, operador, resultado;
    MainPresenter presenter = new MainPresenter(this);
    // Calculadora model; a activy não pode acessar o model, o presenter acessa o model

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor1 = (EditText)findViewById(R.id.valor1);
        valor2 = (EditText)findViewById(R.id.valor2);
        operador = (EditText)findViewById(R.id.operador);
        resultado = (EditText)findViewById(R.id.resultado);
        presenter.onCreate();
        // model = new Calculadora(); para instaciar o model chama-se o onCreate do mainPresenter, pois este método instacia a model
    }

    public void calcular(View view){
       presenter.calculo();
       //este método permanece aqui, pois existe um evento quando o usuario clica em calcular. Transfiro as informações para o MainPresenter
    }
    public String getValor1(){
        return valor1.getText().toString();
    }
    public String getValor2(){
        return valor2.getText().toString();
    }
    public String getOperador(){
        return operador.getText().toString();
    } // esses métodos foram criados para serem chamados no mainpresenter pois assim saberemos os valores digitados pelo usuario

    @Override
    public void setResultado(String resultado) {
        this.resultado.setText(resultado);
    }
}
