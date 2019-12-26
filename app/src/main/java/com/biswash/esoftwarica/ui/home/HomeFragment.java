package com.biswash.esoftwarica.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.biswash.esoftwarica.MainActivity;
import com.biswash.esoftwarica.R;
import com.biswash.esoftwarica.Students;
import com.biswash.esoftwarica.StudentsActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeModel homeModel;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeModel = ViewModelProviders.of(this).get(HomeModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView=root.findViewById(R.id.recyclerview);
        List<Students> studentsList=new ArrayList<>();

        if(MainActivity.students.isEmpty()){
            MainActivity.students.add(new Students("Biswash", "baneshwor", "male",22));
            StudentsActivity studentsActivity=new StudentsActivity(getContext(),MainActivity.students);
            recyclerView.setAdapter(studentsActivity);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }
        else {

            StudentsActivity studentsActivity=new StudentsActivity(getContext(),MainActivity.students);
            recyclerView.setAdapter(studentsActivity);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        }

        return root;
    }
    }


