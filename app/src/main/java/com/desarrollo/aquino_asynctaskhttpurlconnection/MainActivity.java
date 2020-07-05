package com.desarrollo.aquino_asynctaskhttpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.desarrollo.aquino_asynctaskhttpurlconnection.Adapter.AdapterTitle;
import com.desarrollo.aquino_asynctaskhttpurlconnection.Entity.TitleVO;
import com.desarrollo.aquino_asynctaskhttpurlconnection.Fragments.DescripcionTitleFragment;
import com.desarrollo.aquino_asynctaskhttpurlconnection.Fragments.ListTitleFragment;
import com.desarrollo.aquino_asynctaskhttpurlconnection.Interface.InterfaceFragments;
import com.desarrollo.aquino_asynctaskhttpurlconnection.Logic.CLibro;

public class MainActivity extends AppCompatActivity implements InterfaceFragments {
    public String URLIMAGEN = "http://www.thebiblescholar.com/android_awesome.jpg";
    private EditText imputLibro;
    private TextView textoTitle;
    private TextView textoAutor;
    ListTitleFragment listTitleFragment;
    DescripcionTitleFragment descripcionTitleFragment;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.contenedorFragment) != null){
            if (savedInstanceState != null){
                return;
            }

            listTitleFragment = new ListTitleFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, listTitleFragment).commit();
        }
        imputLibro = (EditText) findViewById(R.id.ingresoLibro);
        textoTitle = (TextView) findViewById(R.id.title);
       // textoAutor = (TextView) findViewById(R.id.li);
    }

    public void buscarLibro(View view) {
        String cadenaBusqueda = imputLibro.getText().toString();

        if (cadenaBusqueda.equals("")) {
            Toast.makeText(getApplicationContext(), "Texto de busqueda vacio", Toast.LENGTH_SHORT).show();

        } else {
            new CLibro(textoTitle, textoAutor).execute(cadenaBusqueda);
        }
    }
    public static void LlenarTitulos(String titulo, String autores, String descripcionlarga, int imagen) {
        ListTitleFragment.RefrescarTitle(titulo, autores, descripcionlarga, imagen);
        AdapterTitle adapter = new AdapterTitle(ListTitleFragment.ListTitle, context);
        ListTitleFragment.RecyclerTitle.setAdapter(adapter);
    }

    @Override
    public void send(TitleVO title) {
        descripcionTitleFragment = new DescripcionTitleFragment();
        Bundle Frag2 = new Bundle();
        Frag2.putSerializable("objeto", title);
        descripcionTitleFragment.setArguments(Frag2);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, descripcionTitleFragment).addToBackStack(null).commit();
    }
}
