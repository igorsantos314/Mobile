package com.example.listapersonalizada;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonListAdapter extends ArrayAdapter<Person> {

    Context context;
    int mResource;

    public PersonListAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mResource = resource;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Person p = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(mResource, parent, false);

        TextView first_name_component = (TextView) convertView.findViewById(R.id.tvFirstName);
        TextView last_name_component = (TextView) convertView.findViewById(R.id.tvLastName);
        TextView age_component = (TextView) convertView.findViewById(R.id.tvAge);
        TextView status_component = (TextView) convertView.findViewById(R.id.tvStatus);

        ImageView image = (ImageView) convertView.findViewById(R.id.imgPerson);

        first_name_component.setText(p.getFirstName());
        last_name_component.setText(p.getLastName());
        age_component.setText(String.valueOf(p.getAge()));
        status_component.setText(p.getStatus());

        image.setBackgroundResource(R.drawable.ic_baseline_person_24);
        status_component.setTextColor(convertView.getResources().getColor(R.color.white));

        status_component.setBackgroundColor(
                getColorStatus(convertView, p.getStatus())
        );

        return convertView;
    }

    int getColorStatus(View view, String status){
        switch (status){
            case "ATIVO":
                return view.getResources().getColor(R.color.green);
            case "INATIVO":
                return view.getResources().getColor(R.color.red);
        }

        return view.getResources().getColor(R.color.white);
    }

}
