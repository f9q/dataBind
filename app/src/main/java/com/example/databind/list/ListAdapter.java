package com.example.databind.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databind.R;
import com.example.databind.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemData>  datas = new ArrayList<>();

    public void initData(){
        for (int i = 0 ; i < 32; ++i){
            ItemData item = new ItemData();
            item.title = "item" + i;
            switch (i){
                case 11: case 21:    case 31:
                case 1 : item.icon = R.mipmap.icon1;    break;

                case 12: case 22:    case 32:
                case 2 : item.icon = R.mipmap.icon2;    break;

                case 13: case 23:    case 33:
                case 3 : item.icon = R.mipmap.icon3;    break;

                case 14: case 24:    case 34:
                case 4 : item.icon = R.mipmap.icon4;    break;

                case 15: case 25:    case 35:
                case 5 : item.icon = R.mipmap.icon5;    break;

                case 16: case 26:
                case 6 : item.icon = R.mipmap.icon6;    break;

                case 17: case 27:
                case 7 : item.icon = R.mipmap.icon7;    break;

                case 18: case 28:
                case 8 : item.icon = R.mipmap.icon8;    break;

                case 19: case 29:
                case 9 : item.icon = R.mipmap.icon9;    break;
                default: item.icon = R.mipmap.icon0;    break;
            }
            datas.add(item);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);
        BindHolder holder = new BindHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BindHolder bh = (BindHolder) holder;
        ItemData item = datas.get(position);
        ListItemBinding binding = DataBindingUtil.bind(bh.itemView);
        binding.setItem(item);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static class BindHolder extends RecyclerView.ViewHolder{

        public BindHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
