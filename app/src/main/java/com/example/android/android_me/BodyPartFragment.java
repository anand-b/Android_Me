package com.example.android.android_me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {
    public BodyPartFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView bodyPartIV = (ImageView) root.findViewById(R.id.body_part_image_view);
        bodyPartIV.setImageResource(AndroidImageAssets.getBodies().get(0));
        return root;
    }
}
