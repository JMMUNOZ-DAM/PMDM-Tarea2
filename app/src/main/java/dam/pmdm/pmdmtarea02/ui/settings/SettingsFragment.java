package dam.pmdm.pmdmtarea02.ui.settings;

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

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private Switch languageSwitch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Referencia al Switch en la vista
        languageSwitch = binding.languageswitch;

        // Configuración inicial del Switch según el idioma actual
        SharedPreferences preferences = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        boolean isEnglish = preferences.getBoolean("isEnglish", true);
        languageSwitch.setChecked(isEnglish);

        // Listener para cambiar el idioma al cambiar el estado del Switch
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setLocale("en");
            } else {
                setLocale("es");
            }
        });

        final TextView textView = binding.textSettings;
        settingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        requireActivity().getBaseContext().getResources().updateConfiguration(config, requireActivity().getBaseContext().getResources().getDisplayMetrics());

        // Guardar la preferencia de idioma
        SharedPreferences preferences = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isEnglish", languageCode.equals("en"));
        editor.apply();
        // Reiniciar la actividad para aplicar el cambio de idioma
        requireActivity().recreate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}