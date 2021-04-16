package com.example.mykos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mykos.R;
import com.example.mykos.adapter.AdapterData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private String url = "http://bwa-cozy.herokuapp.com/recommended-spaces";
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.rv);
        listData = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterData = new AdapterData(this, listData);
        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();
    }

    private void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject data = jsonArray.getJSONObject(i);
                        listData.add(data.getString("id"));
                        listData.add(data.getString("name"));
                        listData.add(data.getString("city"));
                        listData.add(data.getString("country"));
                        listData.add(data.getString("price"));
                        listData.add(data.getString("image_url"));
                        listData.add(data.getString("rating"));
                        listData.add(data.getString("address"));
                        listData.add(data.getString("phone"));
                        listData.add(data.getString("map_url"));
                        listData.add(data.getString("number_of_kitchens"));
                        listData.add(data.getString("number_of_bedrooms"));
                        listData.add(data.getString("number_of_cupboards"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}