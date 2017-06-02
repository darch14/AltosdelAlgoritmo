package com.example.david.altosdelalgoritmo;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetalleApartamento extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Apartamento a;
    private String nom,fot;
    private Bundle b;
    private Intent i;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_apartamento);

        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        i=getIntent();
        b=i.getBundleExtra("datos");
        nom=b.getString("nom");
        fot=b.getString("foto");

        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.toolbar2);
        foto=(ImageView)findViewById(R.id.fotoApartamento);

        picasso

    }
}
