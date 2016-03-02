package com.example.testfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShotTimeFragment extends Fragment{
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    
    View view = inflater.inflate(R.layout.fragment_test, container, false);
    TextView textView = (TextView) view.findViewById(R.id.tv);
    textView.setText("ShotTimeFragment");
    return view;
  }
  
}
