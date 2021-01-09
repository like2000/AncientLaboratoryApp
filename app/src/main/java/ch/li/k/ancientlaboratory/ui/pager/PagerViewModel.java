package ch.li.k.ancientlaboratory.ui.pager;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class PagerViewModel extends ViewModel {

    private LiveData<List<String>> textList;
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private MutableLiveData<String> basicText = new MutableLiveData<String>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void initViewModel() {
        for (int i = 0; i < 10; i++)
            textList.getValue().add("Entry number: " + i);
    }

    public LiveData<List<String>> getTextList() {
        return textList;
    }

    public MutableLiveData<String> getBasicText() {
        return basicText;
    }

    public void setBasicText(MutableLiveData<String> basicText) {
        this.basicText = basicText;
    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public class PagerModel {
        public int value;
        public String name;
    }
}