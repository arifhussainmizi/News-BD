package com.example.hp.newsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        webView=findViewById(R.id.secondActivityWebViewId);

        Bundle bundle=getIntent().getExtras();

        if(bundle !=null){

            String webAddress= bundle.getString("loadWeb");

            webView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);

            webView.loadUrl("http://"+webAddress);
            webView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String url=webView.getOriginalUrl();
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("webViewWeb", url);
                    startActivity(intent);

                }
            });
        }





    }
}
