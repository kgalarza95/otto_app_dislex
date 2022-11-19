package ec.ug.ottonavdrawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ec.ug.ottonavdrawer.R;
import ec.ug.ottonavdrawer.databinding.FragmentHomeBinding;
import ec.ug.ottonavdrawer.model.ItemUsuario;
import ec.ug.ottonavdrawer.util.ListAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    List<ItemUsuario> litUsuarios;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        init();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void init(){
        litUsuarios = new ArrayList<>();
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));
        litUsuarios.add(new ItemUsuario("KEVIN","GALARZA"));

        ListAdapter listAdapter = new ListAdapter(litUsuarios, getActivity());
        //RecyclerView recyclerView = findViewById(R.id.mySegmentoRecyVi);
        RecyclerView recyclerView =  binding.mySegmentoRecyVi;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listAdapter);
    }
}