package dam.pmdm.pmdmtarea02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.pmdmtarea02.databinding.PjCardviewBinding;

/**
 * Adaptador para gestionar la visualización de una lista de personajes en un RecyclerView.
 */
public class PjRecyclerViewAdapter extends RecyclerView.Adapter<PjViewHolder>{
    // Lista de personajes a mostrar
        private final ArrayList<PjData> pjs;
    // Contexto donde se utiliza el adaptador
        private final Context context;

    /**
     * Constructor de la clase.
     *
     * @param pjs     Lista de datos de los personajes.
     * @param context Contexto donde se utilizará el adaptador (normalmente una actividad).
     */
        public PjRecyclerViewAdapter(ArrayList<PjData> pjs, Context context){
            this.pjs = pjs;
            this.context = context;
        }

    /**
     * Crea un nuevo ViewHolder para representar un elemento de la lista.
     *
     * @param parent   El ViewGroup al que se añadirá la nueva vista.
     * @param viewType El tipo de la vista (no utilizado aquí).
     * @return Una nueva instancia de {@link PjViewHolder}.
     */
        @NonNull
        @Override
        public PjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            PjCardviewBinding binding = PjCardviewBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent,false
            );
            return new PjViewHolder(binding);
        }

    /**
     * Vincula los datos de un personaje con el ViewHolder.
     *
     * @param holder   El ViewHolder que representa un elemento de la lista.
     * @param position La posición del elemento en la lista.
     */
        @Override
        public void onBindViewHolder(@NonNull PjViewHolder holder, int position) {
            PjData currentPj = this.pjs.get(position); // Obtener el personaje actual
            holder.bind(currentPj); // Vincular los datos con la vista

            // Configurar el evento de clic para el elemento
            holder.itemView.setOnClickListener(view -> itemClicked(currentPj, view));
        }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return Cantidad de elementos en la lista de personajes.
     */
        @Override
        public int getItemCount() {
            return pjs.size();
        }

    /**
     * Método para manejar el evento de clic en un elemento de la lista.
     * Llama al método `pjClicked` de la actividad principal para navegar a los detalles del personaje.
     *
     * @param currentPj El personaje seleccionado.
     * @param view      La vista que fue clicada.
     */

        private void itemClicked(PjData currentPj, View view) {
            // Llama al método pjClicked de MainActivity con los datos del personaje
            ((MainActivity) context).pjClicked(currentPj, view);
        }

    }
