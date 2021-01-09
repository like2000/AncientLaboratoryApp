package ch.li.k.ancientlaboratory.ui.pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

import ch.li.k.ancientlaboratory.ui.slides.SlidesFragment;

public class PagerAdapter extends FragmentStateAdapter {

    private final Integer SLIDES_LIST_SIZE = 10;
    private final List<PagerViewModel> pagerList = new ArrayList<PagerViewModel>();

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return SlidesFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return SLIDES_LIST_SIZE;
    }
}