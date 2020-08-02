package com.example.databind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.databind.databinding.Frgmt1Binding;

public class Frgmt1 extends Fragment {

    private Frgmt1Binding   binding;

    private void init(View root){
        binding = DataBindingUtil.bind(root);
        MainActivity main = (MainActivity) getActivity();
        binding.setData(main.data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frgmt1,container,false);
        init(view);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
