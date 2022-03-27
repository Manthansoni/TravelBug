package com.example.travelbug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class cityView extends AppCompatActivity {
    TextView _view_name,_view_des,_view_time,_view_fee;
    ImageView _view_image;
    Button btn;
    SharedPreferences sp;
    String name;
    String vpURL = "http://192.168.43.96/mcad/viewcitydetails.php";
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_view);

        _view_image = findViewById(R.id.view_image);
        _view_name = findViewById(R.id.view_name);
        _view_des = findViewById(R.id.view_desc);
        _view_time = findViewById(R.id.view_time);
        _view_fee = findViewById(R.id.view_fee);
        btn = findViewById(R.id.openMap);

        sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        id = sp.getString("c_id","");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, vpURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String img=jsonObject.getString("image");
                    name=jsonObject.getString("name");
                    String time=jsonObject.getString("timings");
                    String fee=jsonObject.getString("fee");
                    String des=jsonObject.getString("description");



                    Picasso.get().load("http://192.168.43.96/mcad/cityimages/"+img).into(_view_image);
                    _view_name.setText(name);
                    _view_des.setText("Description : \n"+des);
                    _view_time.setText("Timings : "+time);
                    _view_fee.setText("Entry Fee :"+fee);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString().trim(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String > data =new HashMap<>();
                data.put("c_id", id);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q="+name) ;
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

    }
}