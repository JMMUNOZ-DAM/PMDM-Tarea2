package dam.pmdm.pmdmtarea02.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dam.pmdm.pmdmtarea02.R;

/**
 * ViewModel para el fragmento de configuración (SettingsFragment).
 * Proporciona un recurso de texto observable para ser mostrado en la interfaz de usuario.
 */
public class SettingViewModel extends ViewModel {
    // Texto observable representado como un recurso de cadena (R.string)
    private final MutableLiveData<Integer> mText;

    /**
     * Constructor de SettingViewModel.
     * Inicializa el texto observable con el recurso predeterminado de la configuración.
     */
    public SettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.settings);
    }

    /**
     * Obtiene el recurso de texto observable asociado a la configuración.
     *
     * @return Un LiveData que contiene el ID del recurso de texto (R.string).
     */
    public LiveData<Integer> getText() {
        return mText;
    }
}