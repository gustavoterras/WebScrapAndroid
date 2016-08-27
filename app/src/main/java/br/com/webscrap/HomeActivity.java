package br.com.webscrap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import br.com.webscrap.adapter.MyAdapter;
import br.com.webscrap.model.Casa;

public class HomeActivity extends AppCompatActivity {

    private List<Casa> casas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        populateGrid();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MyAdapter adapter = new MyAdapter(this, casas);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void populateGrid(){

        casas = new ArrayList<>();

        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Sinners Club", "http://www.sinnersclub.com.br", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Beco 203", "http://www.beco203.com.br/agenda/", "http://www.beco203.com.br/resources/images/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));
        casas.add(new Casa("Cucko", "http://www.cucko.com.br/agenda/", "http://www.cucko.com.br/assets/site/img/logo.png"));

    }
}
