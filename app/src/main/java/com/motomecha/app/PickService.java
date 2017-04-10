package com.motomecha.app;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageButton;
import android.widget.TextView;

public class PickService extends AppCompatActivity {
String pick_type;
    ImageButton Igs,Ioil,Irep,Iwat,Ityr,Ibrek,Iveh,Iinsu,Ibuy,Ipet,Ibike,Icus;
    TextView Tservicetype,Tbrandtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        Tservicetype=(TextView) findViewById(R.id.servicetype);
        Igs=(ImageButton)  findViewById(R.id.general_service);
        Irep=(ImageButton) findViewById(R.id.repair_jobs);
        Iwat=(ImageButton) findViewById(R.id.water_wash);
        Ityr=(ImageButton) findViewById(R.id.tyre_puncture);
        Ibrek=(ImageButton) findViewById(R.id.breakdown_assit);
        Iveh=(ImageButton) findViewById(R.id.vehicle_diag);
        Iinsu=(ImageButton) findViewById(R.id.insurance_ren);
//        Ibuy=(ImageButton) findViewById(R.id.b);
//        Ioil=(ImageButton) findViewById(R.id.oil_change);
//        Ioil=(ImageButton) findViewById(R.id.oil_change);
//        Ioil=(ImageButton) findViewById(R.id.oil_change);
//        Ioil=(ImageButton) findViewById(R.id.oil_change);
//        Ioil=(ImageButton) findViewById(R.id.oil_change);
//        Ioil=(ImageButton) findViewById(R.id.oil_change);
        Tbrandtype=(TextView) findViewById(R.id.brandtype);
        pick_type = getIntent().getStringExtra("pick_type");
        Tservicetype.setText(pick_type);
        TextView tv = (TextView) findViewById(R.id.text_view_toolb);
        Typeface custom_font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Vtks.ttf");
        assert tv != null;
        tv.setTypeface(custom_font);
        String text = "<font color=#ff1545>"+pick_type+"</font> <font color=#ffffff>SERVICE</font>";
        tv.setText(Html.fromHtml(text));

    }

}
