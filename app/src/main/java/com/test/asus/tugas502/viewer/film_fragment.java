package com.test.asus.tugas502.viewer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import com.test.asus.tugas502.adapterer.adapter;
import com.test.asus.tugas502.presenterer.presenter;
import com.test.asus.tugas502.modeler.model;
import com.test.asus.tugas502.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class film_fragment extends Fragment implements view{

    List<model> filmModels = new ArrayList<>();
    adapter adapter;

    public film_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false );
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new adapter(getContext(), filmModels);
        recyclerView.setAdapter(adapter);
        presenter data = new presenter(this, getContext());
        data.setData();
    }

    @Override
    public void onSucsess(List<model> animeModels) {
        this.filmModels.clear();
        this.filmModels.addAll(filmModels);
        this.adapter.notifyDataSetChanged();

    }

}
