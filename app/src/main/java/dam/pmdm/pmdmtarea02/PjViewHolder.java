package dam.pmdm.pmdmtarea02;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.pmdmtarea02.databinding.PjCardviewBinding;
/**
 * ViewHolder para representar un elemento de la lista de personajes en un RecyclerView.
 */
public class PjViewHolder extends RecyclerView.ViewHolder{
    // Binding para acceder al CardView
    private final PjCardviewBinding binding;

    /**
     * Constructor del ViewHolder.
     *
     * @param binding Enlace al layout del cardview para un personaje.
     */
    public PjViewHolder(PjCardviewBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un personaje al CardView.
     *
     * @param pj Los datos del personaje a mostrar.
     */
    public void bind (PjData pj){
        // Cargar la imagen del personaje usando Picasso
        Picasso.get().load(pj.getImage()).into(binding.image);
        // Establecer el nombre del personaje en el TextView
        binding.name.setText(pj.getName());
        // Ejecutar actualizaciones pendientes en el binding
        binding.executePendingBindings();
    }
}
