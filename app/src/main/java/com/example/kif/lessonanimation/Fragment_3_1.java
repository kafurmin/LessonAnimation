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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_3_1 extends Fragment {

    private Fragment fragment3;
    private FragmentTransaction transaction;
    private ImageView imageView;

    public Fragment_3_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3_1, container, false);

        fragment3 = new Fragment_3_2();

        imageView = view.findViewById(R.id.imageView3);


       /* Slide slideTransition = new Slide(Gravity.BOTTOM);
        slideTransition.setDuration(1500);*/
        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(500);

      //  fragment3.setEnterTransition(slideTransition);
        fragment3.setSharedElementEnterTransition(changeBoundsTransition);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getFragmentManager().beginTransaction();

                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);


                transaction.replace(R.id.base_fragment3, fragment3)
                        .addToBackStack(null)
                        .addSharedElement(imageView, "imageView")
                        .commit();
            }

        });

        return view;
    }

}
