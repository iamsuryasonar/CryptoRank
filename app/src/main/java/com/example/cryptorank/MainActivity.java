package com.example.cryptorank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mlist;
    private LinearLayoutManager LinearLayoutManager;
    private List<model> modelList;
    private RecyclerView.Adapter adapter;

    private String url = "https://api.coincap.io/v2/assets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlist = findViewById(R.id.list);

        modelList = new ArrayList<>();

        adapter = new CryptoAdapter(getApplicationContext(),modelList);
        LinearLayoutManager = new LinearLayoutManager(this);

        mlist.setLayoutManager(LinearLayoutManager);
        mlist.setAdapter(adapter);

        getData();


    }
    private void getData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    try{
                        JSONArray jsonArray = response.getJSONArray("data");
                        Log.e( "hello: ", String.valueOf(jsonArray.length()));
                        for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        model model = new model();

                        model.setName(jsonObject.getString("name"));
                        model.setPriceUsd(jsonObject.getDouble("priceUsd"));
                        model.setSymbol(jsonObject.getString("symbol"));
                        model.setChangePercent24Hr(jsonObject.getDouble("changePercent24Hr"));

                        modelList.add(model);
                    }
                    }catch (JSONException e){
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }


                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e( "onErrorResponse: ", String.valueOf(error));
                Toast.makeText(MainActivity.this, "Volley response error", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}