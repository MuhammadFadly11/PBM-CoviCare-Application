package com.example.covicare;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Contact2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Contact2Fragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<RumahSakit> listRumahSakit;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Contact2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Contact2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Contact2Fragment newInstance(String param1, String param2) {
        Contact2Fragment fragment = new Contact2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        listRumahSakit = new ArrayList<>();
        listRumahSakit.add(new RumahSakit("RS Bhayangkara Tk. I R. Said Sukanto", "0218093288",
                "Jl. Raya Bogor, Kramat Jati, Kec. Kramat Jati, Kota Jakarta Timur, DKI Jakarta", "Available","Jakarta Timur"));
        listRumahSakit.add(new RumahSakit("RS Paru Dr. H. A. Rotinsulu", "022231427",
                "Jl. Bukit Jarian No. 40 Ciumbuleuit, Kota Bandung, Jawa Barat","Available","Kota Bandung"));
        listRumahSakit.add(new RumahSakit("RS Paru Dr. M. Goenawan Partowidigdo","02518253629",
                "Jl. Raya Puncak KM. 83, Po Box 28 Kec. Cisarua, Kota Bogor, Jawa Barat","Available","Kota Bogor"));
        listRumahSakit.add(new RumahSakit("RS Tk. II Dustira","0226652207",
                "Jl. dr. Dustira No.1 Kel. Baros Kec. Cimahi Tengah, Kota Cimahi, Jawa Barat","Available","Kota Cimahi"));
        listRumahSakit.add(new RumahSakit("BRSU Tabanan", "0361811027",
                "Jl. Pahlawan No. 14, Delod Peken, Kec. Tabanan, Kab. Tabanan, Bali","Available","Bali"));
        listRumahSakit.add(new RumahSakit("RS Universitas Hasanuddin","0411591331",
                "Jl. Perintis Kemerdekaan KM.10, Tamalanrea Indah, Kec. Tamalanrea, Kota Makassar, Sulawesi Selatan 90245","Available","Kota Makassar"));
        listRumahSakit.add(new RumahSakit("RS dr. Tadjuddin Chalid Makassar","0411512902",
                "Jl. Paccerakkang No.67, Paccerakkang, Kec. Biringkanaya, Kota Makassar, Sulawesi Selatan 90242","Available","Kota Makassar"));
        listRumahSakit.add(new RumahSakit("RSAL Dr. Mintoharjo", "0215703081",
                "Jl. Bendungan Hilir No. 17, Bend. Hilir, Kec. Tanah Abang, Kota Jakarta Pusat, DKI Jakarta","Available","Jakarta Pusat"));
        listRumahSakit.add(new RumahSakit("RSPAD Gatot Soebroto","021371008",
                "Jl. Abdul Rahman Saleh Raya No. 24, Senen, Kec. Senen, Kota Jakarta Pusat, DKI Jakarta","Available","Jakarta Pusat"));
        listRumahSakit.add(new RumahSakit("RSPI Prof. Dr. Sulianti Saroso", "0216506559",
                "Jl. Baru Sunter Permai Raya, Papanggo, Tj. Priok, Kota Jakarta Utara, DKI Jakarta","Available","Jakarta Utara"));
        listRumahSakit.add(new RumahSakit("RSD Mayjend. H. M. Ryacudu Kotabumi", "072422095",
                "Jl. Jend. Sudirman No. 2, Kota Gapura, Kotabumi, Kab. Lampung Utara, Lampung, 34511","Available","Lampung Utara"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_contact2, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listRumahSakit);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }
}