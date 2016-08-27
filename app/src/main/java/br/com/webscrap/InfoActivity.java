package br.com.webscrap;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.view.Window;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class InfoActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        url = getIntent().getStringExtra("key");

        Agenda agenda = new Agenda();
        agenda.execute();
    }

    private class Agenda extends AsyncTask<Void, Void, Void> {

        SpannableString s;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(InfoActivity.this);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setTitle("Atenção");
            mProgressDialog.setMessage("Aguarde, carregando...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        public void CuckoGetPartyInfoDoInBackground(){
            try {
                Document document = Jsoup.connect(url).get();
                Elements infoEvento = document.select("div#info-evento");

                for (Element info : infoEvento){
                    s = new SpannableString(Html.fromHtml(info.html()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void SinnersGetPartyInfoDoInBackground() {
            try {
                Document document = Jsoup.connect(url).get();
                Elements infoEvento = document.select("div.content");

                for (Element info : infoEvento) {
                    s = new SpannableString(Html.fromHtml(info.html()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void Beco203RSGetPartyInfoDoInBackground(){
            try {
                Document document = Jsoup.connect(url).get();
                Elements infoEvento = document.select("div#textoAgendaInterna");

                for (Element info : infoEvento){
                    s = new SpannableString(Html.fromHtml(info.html()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void CasaDoLadoGetPartyInfoDoInBackground(){
            try {
                Document document = Jsoup.connect(url).get();
                Elements infoEvento = document.select("div[id*=-0-1]");

                for (Element info : infoEvento){
                    s = new SpannableString(Html.fromHtml(info.html()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            CuckoGetPartyInfoDoInBackground();
//            SinnersGetPartyInfoDoInBackground();
//            Beco203RSGetPartyInfoDoInBackground();
//            CasaDoLadoGetPartyInfoDoInBackground();
            return null;

        }

        @Override
        protected void onPostExecute(Void v) {
            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(s);

            mProgressDialog.dismiss();
        }
    }
}
