package com.elterabit.mymultimediadatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.elterabit.altas.AltaVideojuegos;
import com.elterabit.beans.Videojuego;
import com.elterabit.detalles.DetalleVideojuegos;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Videojuegos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Videojuegos extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener, View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FloatingActionButton addBtn;
    ArrayList<Videojuego> listaVideojuegos;
    ArrayList<String> listaResultados;
    ArrayAdapter<String> adapter;
    ConexionSQLiteHelper conn;


    private OnFragmentInteractionListener mListener;

    public Videojuegos() {
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
    public static Videojuegos newInstance(String param1, String param2) {
        Videojuegos fragment = new Videojuegos();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_videojuegos, container, false);

        addBtn = view.findViewById(R.id.fabVideojuegos);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AltaVideojuegos.class);
                startActivity(intent);
            }
        });

       consultarVideojuegos();


       adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                listaResultados);

        ListView lvVideojuegos = view.findViewById(R.id.listViewVideojuegos);
        lvVideojuegos.setAdapter(adapter);

        lvVideojuegos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Videojuego vJuego = new Videojuego();
                vJuego = listaVideojuegos.get(position);

                Intent intent = new Intent(getContext(), DetalleVideojuegos.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("videojuego", vJuego);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;



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

    private void consultarVideojuegos() {

        SQLiteDatabase db = conn.getReadableDatabase();
        listaVideojuegos = new ArrayList<Videojuego>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_VIDEOJUEGOS, null);


        while(cursor.moveToNext()){
            Videojuego vJuego = new Videojuego();
            vJuego.setId(cursor.getString(0));
            vJuego.setNombre(cursor.getString(1));
            vJuego.setPlataforma(cursor.getString(2));
            vJuego.setJugadores(cursor.getInt(3));
            vJuego.setGenero(cursor.getString(4));
            vJuego.setDesarrollador(cursor.getString(5));
            vJuego.setFormato(cursor.getString(6));

            listaVideojuegos.add(vJuego);
        }
        obtenerListaVideojuegos();
    }

    private void obtenerListaVideojuegos() {

        listaResultados = new ArrayList<String>();

        for(int i=0; i<listaVideojuegos.size(); i++){
            listaResultados.add(listaVideojuegos.get(i).getNombre() + " (" + listaVideojuegos.get(i).getId() + ")");
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
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
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
