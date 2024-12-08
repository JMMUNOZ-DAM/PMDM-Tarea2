package dam.pmdm.pmdmtarea02.ui.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Locale;

import dam.pmdm.pmdmtarea02.databinding.FragmentSettingsBinding;

/**
 * Fragmento de configuración que permite al usuario cambiar el idioma de la aplicación.
 * Incluye un interruptor (Switch) para alternar entre inglés y español.
 */
public class SettingsFragment extends Fragment {
    // Binding para acceder de manera segura a las vistas del layout
    private FragmentSettingsBinding binding;

    // Interruptor para cambiar el idioma
    private Switch languageSwitch;

    /**
     * Infla el layout para el fragmento de configuración.
     * Configura el estado inicial del idioma y maneja los cambios realizados por el usuario.
     *
     * @param inflater  El inflador de layouts.
     * @param container El contenedor del layout (puede ser null).
     * @param savedInstanceState El estado previamente guardado (puede ser null).
     * @return La raíz del layout inflado.
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Referencia al Switch en el layout
        languageSwitch = binding.languageswitch;

        // Configura el estado inicial del interruptor basado en las preferencias guardadas
        SharedPreferences preferences = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        boolean isEnglish = preferences.getBoolean("isEnglish", true);
        languageSwitch.setChecked(isEnglish);

        // Listener para los cambios de estado del interruptor para cambiar el idioma
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {
                setLocale("es");
            } else {
                setLocale("en");
            }
        });
        // Observa el texto proporcionado por el ViewModel y lo actualiza en la interfaz
        final TextView textView = binding.textSettings;
        settingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    /**
     * Cambia el idioma de la aplicación y guarda la preferencia en el almacenamiento compartido.
     * Reinicia la actividad para aplicar el cambio.
     *
     * @param languageCode Código del idioma a establecer (por ejemplo, "en" para inglés, "es" para español).
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        // Actualiza la configuración de recursos de la aplicación
        requireActivity().getBaseContext().getResources().updateConfiguration(config, requireActivity().getBaseContext().getResources().getDisplayMetrics());

        // Guarda la preferencia del idioma en SharedPreferences
        SharedPreferences preferences = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isEnglish", languageCode.equals("en"));
        editor.apply();

        // Reinicia el activity para aplicar el cambio
        requireActivity().recreate();
    }

    /**
     * Llamado cuando la vista asociada al fragmento se destruye.
     * Libera la referencia al binding para evitar fugas de memoria.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}