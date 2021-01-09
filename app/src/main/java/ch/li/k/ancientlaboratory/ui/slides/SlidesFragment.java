package ch.li.k.ancientlaboratory.ui.slides;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ch.li.k.ancientlaboratory.R;
import ch.li.k.ancientlaboratory.databinding.FragmentSlidesBinding;
import ch.li.k.ancientlaboratory.dummy.DummyContent;
import ch.li.k.ancientlaboratory.ui.pager.PagerViewModel;

public class SlidesFragment extends Fragment {

    private static final String ARG_COUNT = "counter";

    private final List<PagerViewModel> data = new ArrayList<>();

    private int[] COLOR_MAP = {
            R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700, R.color.blue_100,
            R.color.blue_300, R.color.blue_500, R.color.blue_700, R.color.green_100, R.color.green_300,
            R.color.green_500, R.color.green_700
    };
    private Integer counter;

    public SlidesFragment() {
    }

    public static SlidesFragment newInstance(int counter) {
        SlidesFragment fragment = new SlidesFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            counter = getArguments().getInt(ARG_COUNT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @NonNull FragmentSlidesBinding binding = FragmentSlidesBinding.inflate(inflater, container, false);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SlidesAdapter adapter = new SlidesAdapter(DummyContent.ITEMS);
        recyclerView.setAdapter(adapter);

//        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new SlidesAdapter(DummyContent.ITEMS));
//        }
//        return view;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setBackgroundColor(ContextCompat.getColor(getContext(), COLOR_MAP[counter]));
    }
}