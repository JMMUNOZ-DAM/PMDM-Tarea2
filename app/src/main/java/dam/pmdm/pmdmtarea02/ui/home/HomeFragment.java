package dam.pmdm.pmdmtarea02.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Objects;
import com.google.android.material.snackbar.Snackbar;
import dam.pmdm.pmdmtarea02.PjData;
import dam.pmdm.pmdmtarea02.PjRecyclerViewAdapter;
import dam.pmdm.pmdmtarea02.R;
import dam.pmdm.pmdmtarea02.databinding.FragmentHomeBinding;

/**
 * Fragmento principal de la aplicación que muestra una lista de personajes (PJs).
 * Utiliza un RecyclerView para mostrar los datos de cada personaje.
 */

public class HomeFragment extends Fragment {
    // Binding para acceder a las vistas del layout
    private FragmentHomeBinding binding;
    // Lista de personajes (PJs)
    private ArrayList<PjData> pjs;
    // Adaptador para el RecyclerView
    private PjRecyclerViewAdapter adapter;


    /**
     * Infla el layout para este fragmento usando FragmentHomeBinding.
     *
     * @param inflater           El inflador de layouts.
     * @param container          El contenedor del layout (puede ser null).
     * @param savedInstanceState El estado previamente guardado (puede ser null).
     * @return La raíz del layout inflado.
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding =  FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Llamado después de que la vista ha sido creada.
     * Configura la lista de personajes y el RecyclerView.
     *
     * @param view               La vista creada.
     * @param savedInstanceState El estado previamente guardado (puede ser null).
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inicializa la lista de personajes
        loadPjs();
        // Configura el RecyclerView con un adaptador y un administrador de diseño
        adapter = new PjRecyclerViewAdapter(pjs, getActivity());
        binding.pjsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pjsRecyclerview.setAdapter(adapter);

    }

    /**
     * Carga los datos de los personajes en la lista.
     * Este método debe ser implementado para agregar personajes personalizados.
     */
    private void loadPjs() {
        pjs = new ArrayList<PjData>();
        // Agrega datos de personajes a la lista sin usar literales

        pjs.add(new PjData(
                R.drawable.mario,
                R.string.marioname,
                R.string.mariodesc,
                R.string.marioabi
        ));

        pjs.add(new PjData(
                R.drawable.luigi,
                R.string.luiginame,
                R.string.luigidesc,
                R.string.luigiabi
        ));

        pjs.add(new PjData(
                R.drawable.toad,
                R.string.toadname,
                R.string.toaddesc,
                R.string.toadabi
        ));

        pjs.add(new PjData(
                R.drawable.peach,
                R.string.peachename,
                R.string.peachedesc,
                R.string.peacheabi
        ));
    }
    /**
     * Llamado cuando el fragmento se vuelve visible para el usuario.
     * Configura el título del ActionBar y muestra un mensaje de bienvenida.
     */
    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setTitle(R.string.pj_list);
            Snackbar snackbar = Snackbar.make(binding.getRoot(), getString(R.string.welcome), Snackbar.LENGTH_LONG);
            snackbar.show();
        }
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