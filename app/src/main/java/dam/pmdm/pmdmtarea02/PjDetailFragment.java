package dam.pmdm.pmdmtarea02;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.Objects;

import dam.pmdm.pmdmtarea02.databinding.PjDetailFragmentBinding;

public class PjDetailFragment extends Fragment{

    private PjDetailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = PjDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image", -1);
            int name = getArguments().getInt("name");
            int description = getArguments().getInt("description");
            int abilities = getArguments().getInt("abilities");

            //Obtenemos el mensaje seleccionado para imprimir bien el toast
            String currentLanguage = Locale.getDefault().getLanguage();
            if("es".equals(currentLanguage)){
                Toast.makeText(getContext(), getString(R.string.sel) +" "+ getString(name), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), getString(name) +" "+ getString(R.string.sel), Toast.LENGTH_SHORT).show();
            }



            // Asignar los datos a los componentes
            Picasso.get()
                    .load(image)
                    .into(binding.image);
            binding.name.setText(getString(name));
            binding.description.setText(getString(description));
            binding.abilities.setText(getString(abilities));


        }
    }

    @Override
    public void onStart(){
        super.onStart();
        if(getActivity() != null){
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setTitle(R.string.pj_details);
        }
    }

}