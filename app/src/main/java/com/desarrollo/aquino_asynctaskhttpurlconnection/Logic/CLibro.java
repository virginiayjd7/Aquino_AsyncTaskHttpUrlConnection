package com.desarrollo.aquino_asynctaskhttpurlconnection.Logic;

import android.os.AsyncTask;
import android.widget.TextView;

import com.desarrollo.aquino_asynctaskhttpurlconnection.MainActivity;
import com.desarrollo.aquino_asynctaskhttpurlconnection.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CLibro  extends AsyncTask<String, Void, String> {
    public static String datos = "";
    private TextView mTextoTitulo;
    private TextView mTextoAutor;
    public static String decoder = "";

    public CLibro(TextView mTextoTitulo, TextView mTextoAutor) {
        this.mTextoTitulo = mTextoTitulo;
        this.mTextoAutor = mTextoAutor;
    }

    @Override
    protected String doInBackground(String... strings) {
        return UtilidadesRed.obtenerInformacionLibro(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String titulo = null;
            String autores = null;
            String subtitle = null;
            String publisher = null;
            String datepublisher = null;
            String urlimagen = null;
            String largedescription = null;

            while ( i < itemsArray.length() && (autores == null && titulo == null && subtitle == null && publisher == null && datepublisher == null)) {
                JSONObject libro = itemsArray.getJSONObject(i);
                JSONObject volumenInfo = libro.getJSONObject("volumeInfo");

                try {
                    titulo = volumenInfo.getString("title");
                    autores = volumenInfo.getString("authors");
                    subtitle = volumenInfo.getString("subtitle");
                    publisher = volumenInfo.getString("publisher");
                    datepublisher = volumenInfo.getString("publishedDate");
                    largedescription = volumenInfo.getString("description");
                    urlimagen = volumenInfo.getString("imageLinks");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                i++;
            }



            if (titulo != null) {

                if (autores != null) {
                    int tamaño = autores.length();
                    int startcadena = 2;
                    int endcadena = tamaño - 2;
                    autores = autores.substring(startcadena, endcadena);
                }

                if (urlimagen != null) {
                    DecodificarURLimagen(urlimagen);
                }


                MainActivity.LlenarTitulos(titulo,
                        subtitle
                                + "\n\nAutor: " + autores
                                + "\n\nEditorial: " + publisher
                                + "\n\nFecha de Publicacion: " + datepublisher
                                + "\n\nURL IMAGEN: " + decoder,

                        "DESCRIPCION: "
                                + "\n\n" + largedescription,
                        R.drawable.ayuda);

            } else {
                MainActivity.LlenarTitulos("No existen resultados para esa busqueda", "error buscando titulo", "",0);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void DecodificarURLimagen(String urlimagen) {

        String urlinicial = "books.google.com/books/content?id=";

        try {
            String[] parts = urlimagen.split(":");
            int finalnum = parts[2].length();
            String urlsecundadria = parts[2].substring(40, finalnum - 13);
            decoder = urlinicial + urlsecundadria;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
