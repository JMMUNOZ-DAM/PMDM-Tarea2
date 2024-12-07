package dam.pmdm.pmdmtarea02.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dam.pmdm.pmdmtarea02.R;

public class SettingViewModel extends ViewModel {

    private final MutableLiveData<Integer> mText;

    public SettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.settings);
    }

    public LiveData<Integer> getText() {
        return mText;
    }
}