package com.motomecha.app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class BatteryFragment extends Fragment {

    ImageView main_image;
    TextView Ttitle,Tdescrip;
    public static BatteryFragment newInstance() {
        BatteryFragment fragment = new BatteryFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Context c = getActivity().getApplicationContext();
        View v= inflater.inflate(R.layout.fragment_tyre, container, false);
        main_image=(ImageView) v.findViewById(R.id.imageView);
        Ttitle=(TextView) v.findViewById(R.id.text_title);
        Tdescrip=(TextView) v.findViewById(R.id.text_description);

        StringRequest stringRequest =new StringRequest(Request.Method.POST, GlobalUrlInit.BATTERY_SERVICE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);

                    JSONObject user = jObj.getJSONObject("battery_service");
                    String image_url = user.getString("image_url");
                    String title = user.getString("title");
                    String content_des =user.getString("content_des");

                    Picasso.with(c).load(image_url).fit().into(main_image);
                    Ttitle.setText(title);
                    Tdescrip.setText(content_des);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){};
        AppController.getInstance().addToRequestQueue(stringRequest);
        return v;
    }

}
