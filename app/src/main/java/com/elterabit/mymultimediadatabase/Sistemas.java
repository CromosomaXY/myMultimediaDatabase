package com.elterabit.mymultimediadatabase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.elterabit.altas.AltaSistemas;
import com.elterabit.beans.Sistema;
import com.elterabit.detalles.DetalleSistemas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Sistemas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sistemas extends Fragment implements SearchView.OnQueryTextListener,  MenuItem.OnActionExpandListener, View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FloatingActionButton addBtn;
    ArrayList<Sistema> listaSistemas;
    ArrayList<String> listaResultados;
    ArrayAdapter<String> adapter;
    ConexionSQLiteHelper conn;


    private OnFragmentInteractionListener mListener;

    public Sistemas() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings.
     */
    // TODO: Rename and change types and number of parameters
    public static Sistemas newInstance(String param1, String param2) {
        Sistemas fragment = new Sistemas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        conn = new ConexionSQLiteHelper(getContext(), "my_mini_database", null, 2);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sistemas, container, false);
        View view = inflater.inflate(R.layout.fragment_sistemas, container, false);

        addBtn = view.findViewById(R.id.fabSistemas);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AltaSistemas.class);
                startActivity(intent);
            }
        });

        consultarSistemas();

        adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                listaResultados);

        ListView lvSistemas = view.findViewById(R.id.listViewSistemas);
        lvSistemas.setAdapter(adapter);

        lvSistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Sistema sistema = new Sistema();
                sistema = listaSistemas.get(position);

                Intent intent = new Intent(getContext(), DetalleSistemas.class);
                Bundle bundle  = new Bundle();

                bundle.putSerializable("sistema", sistema);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }

    private void consultarSistemas(){
        SQLiteDatabase db = conn.getReadableDatabase();
        listaSistemas = new ArrayList<Sistema>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_SISTEMAS, null);

        while(cursor.moveToNext()){
            Sistema sistema = new Sistema();
            sistema.setId(cursor.getInt(0));
            sistema.setNombre(cursor.getString(1));
            sistema.setCompania(cursor.getString(2));

            listaSistemas.add(sistema);
        }

        obtenerListaSistemas();

    }

    private void obtenerListaSistemas(){
        listaResultados = new ArrayList<String>();

        for(int i=0; i<listaSistemas.size(); i++){
            if(listaSistemas.get(i).getCompania() == null){
                listaResultados.add(listaSistemas.get(i).getNombre());
            } else {
                listaResultados.add(listaSistemas.get(i).getNombre() +  " (" + listaSistemas.get(i).getCompania() + ")");
            }
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return false;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
