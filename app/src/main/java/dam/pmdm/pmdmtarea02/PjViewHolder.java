package dam.pmdm.pmdmtarea02;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.pmdmtarea02.databinding.PjCardviewBinding;

public class PjViewHolder extends RecyclerView.ViewHolder{
    private final PjCardviewBinding binding;

    public PjViewHolder(PjCardviewBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (PjData pj){
        Picasso.get().load(pj.getImage()).into(binding.image);
        binding.name.setText(pj.getName());
        binding.executePendingBindings();
    }
}
