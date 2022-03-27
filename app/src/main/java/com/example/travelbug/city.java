package com.example.travelbug;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.security.AccessController.getContext;

public class city extends AppCompatActivity {
    String cURL = "http://192.168.43.96/mcad/citydetails.php";
    RecyclerView recyclerView;
    List<citydetails> ci_details;
    cityadapter ci_adapter;
    SharedPreferences sp;
    String city;
    private cityadapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        city = sp.getString("cityname","");
        //Toast.makeText(city.this,city,Toast.LENGTH_LONG).show();
        recyclerView = findViewById(R.id.city);
        ci_details = new ArrayList<>();
        extractDetails();

    }

    private void extractDetails()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, cURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //Toast.makeText(city.this, response,Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        citydetails c = new citydetails();
                        c.setId(jsonObject.getString("id"));
                        c.setPlace_name(jsonObject.getString("name"));
                        c.setDescription(jsonObject.getString("description"));
                        c.setImage_url(jsonObject.getString("image"));
                        ci_details.add(c);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                setOnClickListaner();
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                Toast.makeText(getContext(), pro_details.get(0).getId(),Toast.LENGTH_LONG).show();
                ci_adapter = new cityadapter(getApplicationContext(),ci_details,listener);
                recyclerView.setAdapter(ci_adapter);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString().trim(),Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("city", city);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    private void setOnClickListaner() {
        listener = new cityadapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                SharedPreferences sp = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("c_id", ci_details.get(position).getId());
                editor.commit();
                Intent intent = new Intent(city.this,cityView.class);
                startActivity(intent);

            }

        };
    }
}
