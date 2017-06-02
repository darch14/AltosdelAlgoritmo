package com.example.david.altosdelalgoritmo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrosEdificios extends AppCompatActivity {
    private EditText cajaMetros,cajaPrecio;
    private Spinner comboPiso,comboNomenclatura;
    private RadioButton rbBalcon1,rbBalcon2,rbSombra1,rbSombra2;
    private String[] opc,opc2;
    private ArrayAdapter adapter,adapter2;
    private Resources res;
    private TextInputLayout icajaMetros,icajaPrecio;
    private boolean guardado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros_edificios);

        res=this.getResources();
        cajaMetros=(EditText)findViewById(R.id.txtMetros);
        cajaPrecio=(EditText)findViewById(R.id.txtPrecio);
        rbBalcon1=(RadioButton)findViewById(R.id.r1Balcon);
        rbBalcon2=(RadioButton)findViewById(R.id.r2Balcon);
        rbSombra1=(RadioButton)findViewById(R.id.r1Sombra);
        rbSombra2=(RadioButton)findViewById(R.id.r2Sombra);
        comboPiso=(Spinner)findViewById(R.id.cmdPiso);
        opc=res.getStringArray(R.array.opciones_piso);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        comboPiso.setAdapter(adapter);
        comboNomenclatura=(Spinner)findViewById(R.id.cmdNomenclatura);
        opc2=res.getStringArray(R.array.opciones_nomenclatura);
        adapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc2);
        comboNomenclatura.setAdapter(adapter2);
        icajaMetros=(TextInputLayout)findViewById(R.id.metrosEdificio);
        icajaPrecio=(TextInputLayout)findViewById(R.id.precioEdificio);

        guardado=false;

        cajaMetros.addTextChangedListener(new TextWatcherPersonalizado(icajaMetros,res.getString(R.string.error_metros)) {
            @Override
            public boolean estaVacio(Editable s) {
                if(TextUtils.isEmpty(s) && !guardado) return true;
                else return false;
            }
        });

        cajaPrecio.addTextChangedListener(new TextWatcherPersonalizado(icajaPrecio,res.getString(R.string.error_precio)) {
            @Override
            public boolean estaVacio(Editable s) {
                if(TextUtils.isEmpty(s) && !guardado) return true;
                else return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent i=new Intent(RegistrosEdificios.this,Principal.class);
        startActivity(i);
    }


    public boolean validarTodo(){
        if (cajaMetros.getText().toString().isEmpty()){
            cajaMetros.setError(res.getString(R.string.error_metros));
            cajaMetros.requestFocus();
            return false;
        }
        if (cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(res.getString(R.string.error_precio));
            cajaPrecio.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validarExistente(){
        ArrayList<Apartamento> a=DatosApartamentos.traerApartamentos(getApplicationContext());
        if (a.size()!=0){
            for (int i=0;i<a.size();i++){
                if (a.get(i).getNomenclatura().equalsIgnoreCase(comboPiso.getSelectedItem().toString()+comboNomenclatura.getSelectedItem().toString())){
                    Toast.makeText(getApplicationContext(),res.getString(R.string.error_existente),
                            Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarPiso(){
        ArrayList<Apartamento> a=DatosApartamentos.traerApartamentos(getApplicationContext());
        String piso=comboPiso.getSelectedItem().toString();
        int cont=0;
        for (int i=0;i<a.size();i++){
            if (a.get(i).getPiso().equals(piso))cont=cont+1;
        }
        if (cont>=3){
            Toast.makeText(getApplicationContext(),res.getString(R.string.error_piso),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public int fotoAleatoria(){
        int foto[]={R.drawable.imagren1,R.drawable.imagen2,R.drawable.imagen3};
        int numero=(int)(Math.random()*3);
        return foto[numero];
    }

    public void guardar(View v){
        String foto,nom,piso,metros,precio,balcon,sombra;
        if (validarTodo()){
            if (validarExistente()){
                if (validarPiso()){
                    foto=String.valueOf(fotoAleatoria());
                    nom=comboPiso.getSelectedItem().toString()+comboNomenclatura.getSelectedItem().toString();
                    piso=comboPiso.getSelectedItem().toString();
                    metros=cajaMetros.getText().toString();
                    precio=cajaPrecio.getText().toString();
                    if (rbBalcon1.isChecked())balcon=res.getString(R.string.tiene_balcon);
                    else balcon=res.getString(R.string.no_tiene_balcon);
                    if (rbSombra1.isChecked())sombra=res.getString(R.string.tiene_sombra);
                    else sombra=res.getString(R.string.no_tiene_sombra);

                    Apartamento a=new Apartamento(foto,nom,piso,metros,precio,balcon,sombra);
                    a.guardar(getApplicationContext());

                    Snackbar.make(v,getResources().getString(R.string.mensaje_exitoso_guardar),Snackbar.LENGTH_SHORT).show();
                    guardado=true;
                    limpiar();
                }
            }
        }
    }

    public void limpiar(){
        comboNomenclatura.setSelection(0);
        comboPiso.setSelection(0);
        cajaMetros.setText("");
        cajaPrecio.setText("");
        rbBalcon1.setChecked(true);
        rbSombra1.setChecked(true);
        cajaMetros.requestFocus();
        guardado=false;
    }

    public void borrar(View v){
        limpiar();
    }
}
