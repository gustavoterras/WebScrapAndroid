package br.com.webscrap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String url = "http://www.cucko.com.br/agenda/";
    private ProgressDialog mProgressDialog;
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);

        findViewById(R.id.btn_agenda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Agenda().execute();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = (String) adapterView.getItemAtPosition(i);
                startActivity(new Intent(MainActivity.this, InfoActivity.class).putExtra("key", url));
            }
        });
    }

    private class Agenda extends AsyncTask<Void, Void, Void> {

        List<String> agendas = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setTitle("Atenção");
            mProgressDialog.setMessage("Aguarde, carregando...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(url).get();
                Elements links = document.select("a[href~=(agenda/evento)]");
                for (Element link : links){
                    agendas.add("http://www.cucko.com.br/" + link.attr("href"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            lv.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, agendas));
            mProgressDialog.dismiss();
        }
    }
}
