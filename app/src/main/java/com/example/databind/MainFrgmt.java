package com.example.databind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.databind.databinding.FrgmtMainBinding;
import com.example.databind.list.ListFrgmt;


public class MainFrgmt extends Fragment {


    private FrgmtMainBinding    binding;


    private void initBinding(){

        MainActivity main = (MainActivity) getActivity();

        binding.setData(main.data);
        binding.setClick(new Click());
        binding.listFragment.setOnClickListener(this::onListFrgmtClicked);
        binding.btnSave.setOnClickListener(this::onSaveClicked);
        binding.btnFeatures.setOnClickListener(this::onFeaturesClicked);
        binding.mapCollection.setOnClickListener(this::onMapClicked);
        binding.btn2way.setOnClickListener(this::on2WayClicked);

    }

    public void onMapClicked(View v){
        MapCollectionFrgmt mcf = new MapCollectionFrgmt();

        FragmentTransaction ft = requireFragmentManager().beginTransaction();

        ft.addToBackStack("MapCollectionFrmgt").add(R.id.main,mcf,"MapCollectionTag").commit();
    }


    public void onFeaturesClicked(View v){
        FeaturesFrgmt frgmt = new FeaturesFrgmt();

        FragmentTransaction ft = requireFragmentManager().beginTransaction();

        ft.addToBackStack("FeaturesFrgmt").add(R.id.main,frgmt).commit();
    }

    public void on2WayClicked(View v){
        FragmentTransaction ft = requireFragmentManager().beginTransaction();
        ft.addToBackStack("2WayFrmgt").add(R.id.main,new Way2Frgmt(),"2WayTag").commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FrgmtMainBinding.inflate(inflater,container,false);
        initBinding();
        return binding.getRoot();
    }

    public void onListFrgmtClicked(View view){
        ListFrgmt listFrgmt = new ListFrgmt();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.main,listFrgmt,"ListFrgmt").addToBackStack("ListFrgmt").commit();
    }

    public void onSaveClicked(View view){
        String newKey = binding.edtKey.getText().toString().trim();
        String valueStr = binding.edtValue.getText().toString();

        if (newKey.length() < 1 || valueStr.length() < 1) return;
        binding.edtKey.setText("");
        binding.edtValue.setText("");

        int newValue = Integer.valueOf(valueStr);

        MainActivity main = (MainActivity) getActivity();

        main.data.setKey(newKey);
        main.data.setTest(newKey);
        main.data.setValue(newValue);

        int id = main.data.icon;
        if (id == R.mipmap.boy){
            main.data.setIcon(R.mipmap.girl);
        }else{
            main.data.setIcon(R.mipmap.boy);
        }
    }

}
