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

/**
 * Fragmento que muestra los detalles de un personaje.
 * Carga y presenta la información de un personaje, incluyendo su imagen, nombre, descripción y habilidades.
 */

public class PjDetailFragment extends Fragment{
    // Enlace al PjDetailFragment de este fragmento
    private PjDetailFragmentBinding binding;

    /**
     * Crea e infla la vista asociada al fragmento.
     *
     * @param inflater  Objeto LayoutInflater para inflar vistas en el fragmento.
     * @param container Contenedor padre en el que se debe insertar la vista.
     * @param savedInstanceState Estado previamente guardado del fragmento (si existe).
     * @return La raíz de la vista inflada para este fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = PjDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Configura la lógica de la vista una vez que esta se ha creado.
     * Obtiene los datos del argumento y los asigna a los componentes visuales.
     *
     * @param view               La vista principal del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento (si existe).
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Verifica si se pasaron argumentos al fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image", -1);
            int name = getArguments().getInt("name");
            int description = getArguments().getInt("description");
            int abilities = getArguments().getInt("abilities");

            // Mostrar un mensaje con el nombre del personaje y un texto de selección según el idioma
            String currentLanguage = Locale.getDefault().getLanguage();
            if("es".equals(currentLanguage)){
                Toast.makeText(getContext(), getString(R.string.sel) +" "+ getString(name), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), getString(name) +" "+ getString(R.string.sel), Toast.LENGTH_SHORT).show();
            }

            // Asignar los datos a los componentes visuales
            Picasso.get()
                    .load(image) // Cargar la imagen del personaje
                    .into(binding.image); // Asignarla al componente de imagen
            binding.name.setText(getString(name)); // Asignar el nombre al componente de texto
            binding.description.setText(getString(description)); // Asignar la descripción
            binding.abilities.setText(getString(abilities)); // Asignar las habilidades

        }
    }
    /**
     * Configura el título de la barra de acción al iniciar el fragmento.
     */
    @Override
    public void onStart(){
        super.onStart();
        if(getActivity() != null){
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setTitle(R.string.pj_details);
        }
    }

}