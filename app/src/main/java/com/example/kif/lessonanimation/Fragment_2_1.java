package com.example.kif.lessonanimation;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_2_1 extends Fragment {

    private Fragment fragment2;
    private FragmentTransaction transaction;
    private  ImageView imageView;
    private  TextView textView;


    public Fragment_2_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_2_1, container, false);

        fragment2 = new Fragment_2_2();

        imageView = view.findViewById(R.id.imageView2);
        textView = view.findViewById(R.id.textView2);


        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(1500);
        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(1500);

        fragment2.setEnterTransition(slideTransition);
        fragment2.setSharedElementEnterTransition(changeBoundsTransition);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getFragmentManager().beginTransaction();

                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                     transaction.replace(R.id.base_fragment, fragment2)
                            .addToBackStack(null)
                            .addSharedElement(imageView, "imageView")
                            .addSharedElement(textView, "textView")
                            .commit();
            }

        });

        return view;
    }
}
