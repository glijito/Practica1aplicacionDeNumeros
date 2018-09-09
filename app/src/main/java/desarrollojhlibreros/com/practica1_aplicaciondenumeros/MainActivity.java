package desarrollojhlibreros.com.practica1_aplicaciondenumeros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int datoVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFibonacci = (Button) findViewById(R.id.btnFibo);
        Button btnMaravilloso = (Button) findViewById(R.id.btnmaravilloso);
        Button btnPalindromo = (Button) findViewById(R.id.btnPalindromo);
        Button btnPrimo = (Button) findViewById(R.id.btnprimo);

        btnFibonacci.setOnClickListener(this);
        btnMaravilloso.setOnClickListener(this);
        btnPalindromo.setOnClickListener(this);
        btnPrimo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        TextView dato=(TextView)findViewById(R.id.txtDato);
        TextView resultado=(TextView)findViewById(R.id.txtResultado);

        if(v.getId()==findViewById(R.id.btnFibo).getId()) {
            if(isFibonnaci(Integer.parseInt(dato.getText().toString())))
                resultado.setText("El numero esta en la serie fibonacci");
            else
                resultado.setText("El numero esta en la serie fibonacci");
        }

        if(v.getId()==findViewById(R.id.btnmaravilloso).getId()) {
            String numeroMaravilloso= listNumeroMaravilloso(Integer.parseInt(dato.getText().toString()));
            resultado.setText(numeroMaravilloso+" \n es un numero maravilloso");
        }

        if(v.getId()==findViewById(R.id.btnPalindromo).getId()) {
            if(isVerificacionPalindromo(dato.getText().toString()))
                resultado.setText("La palabra ingresada es palindromo");
            else
                resultado.setText("La palabra ingresada no es palindromo");
        }

        if(v.getId()==findViewById(R.id.btnprimo).getId()) {
            if(isPrimo(Integer.parseInt(dato.getText().toString())))
                resultado.setText("El numero es primo");
            else
                resultado.setText("El numero no es primo");
        }
    }

    private String listNumeroMaravilloso(int numero){
        String estadosNumericos="";
        do{
            if(numero%2==0){
                numero=numero/2;
                estadosNumericos+=""+numero+"\n";
            }else{
                numero=(numero*3)+1;
                estadosNumericos+=""+numero+"\n";
            }
            System.out.println(numero);
        }while(numero!=1);

        estadosNumericos="\nEstados: \n"+estadosNumericos;
        return estadosNumericos;
    }

    private boolean isFibonnaci(int numero){
        int suma;
        int j = 1,l = 0;

        for(int i=0;;i++){
            suma=l+j;
            if(j==numero)
                return true;
            else
            if(j>numero)
                return false;
            l=j;
            j=suma;
        }
    }

    private boolean isPrimo(int numero){
        int contadorDeDivision=0;

        if(numero==1 || numero==0)
            return false;
        else
            for(int i=numero;i>=1;i--){
                if(numero%i==0)
                    contadorDeDivision++;
            }
        return (contadorDeDivision>2)?false:true;
    }

    private boolean isVerificacionPalindromo(String texto)
    {
        boolean palindromoCorrecto = false;

        for (int i = 0; i < ((texto.length())/2); i++) {
            if(texto.charAt(i)==texto.charAt(texto.length()-i-1))
                palindromoCorrecto=true;
            else{
                palindromoCorrecto=false;
                break;
            }
        }
        return palindromoCorrecto;
    }

}
