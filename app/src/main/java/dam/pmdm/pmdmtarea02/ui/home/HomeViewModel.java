package dam.pmdm.pmdmtarea02.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel para el fragmento de inicio (HomeFragment).
 * Proporciona datos observables para la interfaz de usuario.
 */
public class HomeViewModel extends ViewModel {
    // Texto observable para el fragmento de inicio
    private final MutableLiveData<String> mText;
    /**
     * Constructor de HomeViewModel.
     * Inicializa el texto observable con un valor predeterminado.
     */
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }
    /**
     * Obtiene el texto observable asociado al fragmento de inicio.
     *
     * @return Un LiveData que contiene el texto.
     */
    public LiveData<String> getText() {
        return mText;
    }
}