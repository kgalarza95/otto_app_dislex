package ec.ug.ottonavdrawer.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ec.ug.ottonavdrawer.R;
import ec.ug.ottonavdrawer.databinding.FragmentUsuariosBinding;

public class GalleryFragment extends Fragment {

    private FragmentUsuariosBinding binding;

    private Spinner spTiposUsuarios;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentUsuariosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView3;
        spTiposUsuarios = binding.spUsuarios;

        //Adaptador con layout por defecto
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getActivity(), R.array.strs_tip_users,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        //Diseño cuando aparezcan las opciones
        adaptador.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spTiposUsuarios.setAdapter(adaptador);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}