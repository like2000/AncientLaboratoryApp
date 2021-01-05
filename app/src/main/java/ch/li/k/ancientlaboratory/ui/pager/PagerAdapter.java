package ch.li.k.ancientlaboratory.ui.pager;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ch.li.k.ancientlaboratory.databinding.FragmentPagerBinding;
import ch.li.k.ancientlaboratory.databinding.FragmentSlidesBinding;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.PagerViewHolder> {


    private List<MutableLiveData<String>> slidesList = new ArrayList<MutableLiveData<String>>();

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentPagerBinding binding = FragmentPagerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PagerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {
        holder.binding.setPagerModel(null);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class PagerViewHolder extends RecyclerView.ViewHolder {

        private final FragmentPagerBinding binding;

        public PagerViewHolder(@NonNull FragmentPagerBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}