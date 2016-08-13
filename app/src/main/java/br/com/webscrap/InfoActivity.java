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

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(url).get();
                Elements infoEvento = document.select("div[id~=(info-evento)]");
                for (Element info : infoEvento){
                    s = new SpannableString(Html.fromHtml(info.html()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
