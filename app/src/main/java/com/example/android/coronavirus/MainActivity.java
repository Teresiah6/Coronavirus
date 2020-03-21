package com.example.android.coronavirus;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Case> cases = new ArrayList<>();
    private CaseAdapter caseAdapter;
    private RecyclerView recyclerView;


    private static String BASE_URL = "https://corona.lmao.ninja/";
    private CasesApi casesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recylerview);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        casesApi = retrofit.create(CasesApi.class);
        displayallinfo();

    }

    private void displayallinfo() {
        Call<List<Case>> call = casesApi.getCases();
        call.enqueue(new Callback<List<Case>>() {
            @Override
            public void onResponse(Call<List<Case>> call, Response<List<Case>> response) {
                if (!response.isSuccessful()) {


//                  textView.setText("Code" + response.code());
                    //return;
                }


//                List<Case> cases = response.body();
                cases = new ArrayList<>(response.body());

                Log.d("Cases", "Cases here " + cases.get(0).toString());
                setupAdapter(response.body());
//
//                for(Case corona: cases){
//                    String content = "";
//                    content+="Country: " + corona.getCountry()+ "\n";
//                    content +="Cases: " +  corona.getCases()+ "\n";
//                    content+=  "TodayCase: " + corona.getTodayCases()+ "\n";
//                    content+= "TodayDeaths: " + corona.getTodayDeaths() +"\n";
//                    content += " Recovered: " + corona.getRecovered()+"\n";
//                    content += " Active: " + corona.getActive()+ "\n";
//                    content += "Critical: " +  corona.getCritical() +"\n";
//                    content+="Cases Per One Million: " + corona.getCasesPerOneMillion() +"\n\n";
//
//                    textView.append(content);

                //    }
            }


            @Override
            public void onFailure(Call<List<Case>> call, Throwable t) {

                Log.d("Error", "Error occurred " + t.getMessage());
            }
        });


    }

    private void setupAdapter(List<Case> body) {
        CaseAdapter caseAdapter = new CaseAdapter(body, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(caseAdapter);

    }

}
