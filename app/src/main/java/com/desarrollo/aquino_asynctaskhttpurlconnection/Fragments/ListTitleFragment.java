package com.desarrollo.aquino_asynctaskhttpurlconnection.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desarrollo.aquino_asynctaskhttpurlconnection.Entity.TitleVO;
import com.desarrollo.aquino_asynctaskhttpurlconnection.Interface.InterfaceFragments;
import com.desarrollo.aquino_asynctaskhttpurlconnection.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTitleFragment extends Fragment {
    public static ArrayList<TitleVO> ListTitle;
    public static RecyclerView RecyclerTitle;
    Activity activity;
    InterfaceFragments interfaceFragments;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTitleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTitleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTitleFragment newInstance(String param1, String param2) {
        ListTitleFragment fragment = new ListTitleFragment();
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
        View vista =  inflater.inflate(R.layout.fragment_list_title, container, false);

        ListTitle = new ArrayList<>();

        RecyclerTitle = vista.findViewById(R.id.recyclerId);

        RecyclerTitle.setLayoutManager(new LinearLayoutManager(getContext()));

        return vista;
    }
    public static void RefrescarTitle(String title, String autor, String descripciondet, int image) {
        ListTitle.clear();
        ListTitle.add(new TitleVO(title, autor, descripciondet, image));
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity= (Activity) context;
            interfaceFragments= (InterfaceFragments) this.activity;
        }
    }
}