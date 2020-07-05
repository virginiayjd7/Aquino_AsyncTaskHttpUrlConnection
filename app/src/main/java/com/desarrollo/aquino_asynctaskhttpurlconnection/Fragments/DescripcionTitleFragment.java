package com.desarrollo.aquino_asynctaskhttpurlconnection.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desarrollo.aquino_asynctaskhttpurlconnection.Entity.TitleVO;
import com.desarrollo.aquino_asynctaskhttpurlconnection.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DescripcionTitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescripcionTitleFragment extends Fragment {
    TextView textinfo;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DescripcionTitleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DescripcionTitleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DescripcionTitleFragment newInstance(String param1, String param2) {
        DescripcionTitleFragment fragment = new DescripcionTitleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_descripcion_title, container, false);

        textinfo = (TextView) vista.findViewById(R.id.informacion);

        Bundle objLL = getArguments();
        TitleVO mytitle = null;

        if (objLL != null) {
            mytitle= (TitleVO) objLL.getSerializable("objeto");
            LlenarInformacion(mytitle);
        }
        return vista;
    }

    public void LlenarInformacion(TitleVO mititulo) {
        textinfo.setText(mititulo.getDescripcion());
    }

}