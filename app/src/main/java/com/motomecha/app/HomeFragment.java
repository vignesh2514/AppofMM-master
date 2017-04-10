package com.motomecha.app;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.nightonke.boommenu.BoomMenuButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
WebView webView;
ImageButton Ioffers;
    ImageButton Ibike,Icar;
    BoomMenuButton bmb1;
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        webView = (WebView) v.findViewById(R.id.webView);
        Ioffers=(ImageButton) v.findViewById(R.id.imageButton);
        webView.getSettings().setJavaScriptEnabled(true);
Ibike=(ImageButton) v.findViewById(R.id.imageButton2);
        Icar=(ImageButton) v.findViewById(R.id.imageButton3);


        webView.loadUrl("http://motomecha.com/mmadmin/slidingme.php");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

//                imageView.setVisibility(View.VISIBLE);
//                webView.setVisibility(View.INVISIBLE);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                if (url.contains("http") ) {
                    final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else {

                    return true;
                }

            }
        });
Ibike.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(getActivity(),PickService.class);
        intent.putExtra("pick_type","bike");
        startActivity(intent);
    }
});
        Icar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),PickService.class);
                intent.putExtra("pick_type","car");
                startActivity(intent);
            }
        });

        Ioffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),OfferPage.class);
                startActivity(intent);
            }
        });
        return v;

    }

}
