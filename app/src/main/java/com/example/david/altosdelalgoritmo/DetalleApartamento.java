package com.example.david.altosdelalgoritmo;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class DetalleApartamento extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Apartamento a;
    private String nom,fot,piso,metros,balcon,sombra,precio;
    private Bundle b;
    private Intent i;
    private ImageView foto;
    private TextView cajanomenclatura,cajaprecio,cajametros,cajapiso,cajabalcon,cajasombra;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_apartamento);

        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        res=this.getResources();

        i=getIntent();
        b=i.getBundleExtra("datos");
        nom=b.getString("nom");
        fot=b.getString("foto");
        piso=b.getString("piso");
        metros=b.getString("metros");
        precio=b.getString("precio");
        balcon=b.getString("balcon");
        sombra=b.getString("sombra");

        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        foto=(ImageView)findViewById(R.id.fotoApartamento);

        foto.setImageResource(Integer.parseInt(fot));

        cajanomenclatura=(TextView)findViewById(R.id.txtDetalleNomenclatura);
        cajapiso=(TextView)findViewById(R.id.txtDetallePiso);
        cajametros=(TextView)findViewById(R.id.txtDetalleMetros);
        cajaprecio=(TextView)findViewById(R.id.txtDetallePrecio);
        cajabalcon=(TextView)findViewById(R.id.txtDetalleBalcon);
        cajasombra=(TextView)findViewById(R.id.txtDetalleSombra);

        cajanomenclatura.setText(res.getString(R.string.apartamento)+": "+nom);
        cajapiso.setText(res.getString(R.string.piso)+": "+piso);
        cajametros.setText(res.getString(R.string.metros)+": "+metros);
        cajaprecio.setText(res.getString(R.string.precio)+": $"+precio);
        cajabalcon.setText(balcon);
        cajasombra.setText(sombra);



    }
}
