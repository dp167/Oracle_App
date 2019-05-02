package com.example.browserapp;

import android.content.ClipDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.webkit.WebViewClient;
import android.text.ClipboardManager;

import android.content.ClipData;
import android.content.ClipData.Item;
//import android.content.ClipboardManager;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    

    WebView browser;
    EditText link;
    Button btn_visit;
    Button answerButton;
    @SuppressWarnings("deprecation")
    ClipboardManager answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView) findViewById(R.id.webview);
        link = (EditText) findViewById(R.id.editTextLink);
        btn_visit = (Button) findViewById(R.id.btn_view);
        answerButton = (Button) findViewById(R.id.answer_button);
        @SuppressWarnings("deprecation")
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("your_text_to_be_copied");
        clipboard.setPrimaryClip(clip);

        browser.setWebViewClient(new myWebViewClient());

        String InitialUrl = "http://www.google.com";
        browser.loadUrl(InitialUrl);

        //onPrimaryClipChange()

        btn_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String question= link.getText().toString();


                String url = GetUrl(question);

                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);

                browser.loadUrl(url);

            }
        });

        answerButton.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view){

                @SuppressWarnings("deprecation")
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if (clipboard.hasPrimaryClip()) {
                    ClipDescription description = clipboard.getPrimaryClipDescription();
                    ClipData data = clipboard.getPrimaryClip();
                    if (data != null && description != null && description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))
                        return String.valueOf(data.getItemAt(0).getText());
                }
                return null;


            }


                                        }


        );
    }

    private String GetUrl(String question) {
        String GoogleSearch = "http://www.google.com/search?q=";
        String NewURL = GoogleSearch + question;
        return NewURL;

    }

    public String readFromClipboard() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard.hasPrimaryClip()) {
            android.content.ClipDescription description = clipboard.getPrimaryClipDescription();
            android.content.ClipData data = clipboard.getPrimaryClip();
            if (data != null && description != null && description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))
                return String.valueOf(data.getItemAt(0).getText());
        }
        return null;
    }

    private class myWebViewClient extends WebViewClient
        {

            public boolean shouldOvverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }

        }


    }

