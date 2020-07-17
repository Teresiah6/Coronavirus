package com.example.android.coronavirus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    ArrayList<Case> cases = new ArrayList<>();
    private CaseAdapter caseAdapter;
    private RecyclerView recyclerView;


    private static String BASE_URL="https://corona.lmao.ninja/";
    private CasesApi casesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        recyclerView = (RecyclerView) findViewById(R.id.recylerview);


        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        casesApi = retrofit.create(CasesApi.class);
        displayallinfo();
//        LoadJson();

    }

    private void LoadJson(final String country) {

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

                if (response.body() != null) {
                    cases = new ArrayList<>(response.body());
                }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.case_list_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
       // SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final View searchView =  searchItem.getActionView();

        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //searchView.setQueryHint("Search here");



        //searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
        //return true;



    }

    @Override
    public boolean onQueryTextSubmit(String s) {

        try{
            if(s.length() > 2){
         //       LoadJson();
            }


        } catch (Exception e){
            Log.d("error", e.getMessage());

        }
        //searchMenuItem.getItemId().
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
       // LoadJson();
        return false;
    }
}
