package com.kkaty.myprojprep;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kkaty.myprojprep.Model.Business;
import com.kkaty.myprojprep.View.BusinessesAdapter;
import com.kkaty.myprojprep.ViewModel.BusinessesViewModel;

import java.util.List;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BusinessesAdapter businessesAdapter;

    List<Business> businessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BusinessesViewModel model = ViewModelProviders.of(this).get(BusinessesViewModel.class);
        model.getBusinesses().observe(this, (businessList) -> {

                businessesAdapter = new BusinessesAdapter(MainActivity.this, businessList);
                recyclerView.setAdapter(businessesAdapter);
        });
    }
}
