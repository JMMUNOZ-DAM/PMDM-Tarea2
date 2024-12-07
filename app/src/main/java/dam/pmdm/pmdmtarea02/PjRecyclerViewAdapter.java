package dam.pmdm.pmdmtarea02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.pmdmtarea02.databinding.PjCardviewBinding;

public class PjRecyclerViewAdapter extends RecyclerView.Adapter<PjViewHolder>{

        private final ArrayList<PjData> pjs;
        private final Context context;

        public PjRecyclerViewAdapter(ArrayList<PjData> pjs, Context context){
            this.pjs = pjs;
            this.context = context;
        }

        // Método que crea el ViewHolder
        @NonNull
        @Override
        public PjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            PjCardviewBinding binding = PjCardviewBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent,false
            );
            return new PjViewHolder(binding);
        }

        // Método para enlazar datos con el ViewHolder
        @Override
        public void onBindViewHolder(@NonNull PjViewHolder holder, int position) {
            PjData currentPj = this.pjs.get(position);
            holder.bind(currentPj);

            // Manejar el evento de clic
            holder.itemView.setOnClickListener(view -> itemClicked(currentPj, view));
        }

        @Override
        public int getItemCount() {
            return pjs.size();
        }

        private void itemClicked(PjData currentPj, View view) {
            // Llama a la función pjClicked de MainActivity, pasando la vista
            ((MainActivity) context).pjClicked(currentPj, view);
        }

    }
