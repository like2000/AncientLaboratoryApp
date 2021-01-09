package ch.li.k.ancientlaboratory.ui.pager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import ch.li.k.ancientlaboratory.databinding.FragmentPagerBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class PagerFragment extends Fragment {

    private final List<PagerViewModel> data = new ArrayList<>();

    private FragmentPagerBinding binding;
    private PagerViewModel viewModel;
    private ViewPager2 viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentPagerBinding.inflate(inflater, container, false);
        viewPager = binding.viewPager;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("Happy fragment!");
        Log.i("Info", "Initialize pager fragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        PagerAdapter adapter = new PagerAdapter();
        viewPager.setAdapter(adapter);
        System.out.println("Set adapter: " + adapter);

        viewModel = new ViewModelProvider(requireActivity()).get(PagerViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });

        binding.setLifecycleOwner(this);
        binding.setPagerModel(viewModel);

        initData();
    }

    private void initData() {

        for (int i = 0; i < 10; i++) {
            data.add(new PagerViewModel());
            Log.i("Info", "Set index in viewmodel to: " + i + "; viewmodel: " + viewModel);
        }


    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
//        int index = 1;
//        if (getArguments() != null) {
//            index = getArguments().getInt(ARG_SECTION_NUMBER);
//        }
//        pageViewModel.setIndex(index);
//    }
//
//    @Override
//    public View onCreateView(
//            @NonNull LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.fragment_main, container, false);
//        final TextView textView = root.findViewById(R.id.section_label);
//        pageViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
}