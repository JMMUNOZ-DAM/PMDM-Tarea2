package dam.pmdm.pmdmtarea02.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<PjData> pjs; // Lista de juegos
    private PjRecyclerViewAdapter adapter; // Adaptador del RecyclerView
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding =  FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inicializa la lista de juegos
        loadPjs(); // Cargar los personajes (puedes implementar esta función para obtener datos)
        // Configurar el RecyclerView
        adapter = new PjRecyclerViewAdapter(pjs, getActivity());
        binding.pjsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pjsRecyclerview.setAdapter(adapter);

    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private void loadPjs() {
        pjs = new ArrayList<PjData>();
        // Llenar la lista con datos de videojuegos
        pjs.add(new PjData(
                R.drawable.mario, // Usar el ID del recurso
                R.string.marioname,
                R.string.mariodesc,
                R.string.marioabi
        ));

        pjs.add(new PjData(
                R.drawable.luigi, // Usar el ID del recurso
                R.string.luiginame,
                R.string.luigidesc,
                R.string.luigiabi
        ));

        pjs.add(new PjData(
                R.drawable.toad, // Usar el ID del recurso
                R.string.toadname,
                R.string.toaddesc,
                R.string.toadabi
        ));

        pjs.add(new PjData(
                R.drawable.peach, // Usar el ID del recurso
                R.string.peachename,
                R.string.peachedesc,
                R.string.peacheabi
        ));
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setTitle(R.string.pj_list);
            // Configurar el Snackbar con un anclaje para subirlo
            Snackbar snackbar = Snackbar.make(binding.getRoot(), getString(R.string.welcome), Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}