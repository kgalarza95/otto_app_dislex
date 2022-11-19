package ec.ug.ottonavdrawer.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ec.ug.ottonavdrawer.R;
import ec.ug.ottonavdrawer.model.ItemUsuario;

//importante que se llame "ListAdapter" para que funcione el adpatador
//no es necesario llamarle ListAdapter
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    public List<ItemUsuario> listUsuarios;
    public LayoutInflater layoutInflater;
    public Context context;

    public ListAdapter() {

    }

    public ListAdapter(List<ItemUsuario> listUsuarios, Context context) {
        this.listUsuarios = listUsuarios;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_rv_card_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(listUsuarios.get(position));
    }

    @Override
    public int getItemCount() {
        return listUsuarios.size();
    }

    public void setItem(List<ItemUsuario> listUsuarios){
        this.listUsuarios = listUsuarios;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        View manejoVista;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            manejoVista = itemView;
            iv = itemView.findViewById(R.id.imageView3);
        }

        void bindData(final  ItemUsuario itemCv){
            //iv
            //aqui van los valores a modificar el card view,
            //los texttos y demas.
            manejoVista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Click.. "+itemCv.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
