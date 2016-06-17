package com.example.administrador.petshopstore;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<PetCatalog> petCatalogs;
    RecyclerView rvCatalogList;
    ImageView imgStart;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setIcon(R.drawable.star_hotel_48);
        //getSupportActionBar().setIcon(R.drawable.star_hotel_48);

        rvCatalogList = (RecyclerView) findViewById(R.id.recPetCatalog);

        LinearLayoutManager myLinLayout = new LinearLayoutManager(this);
        myLinLayout.setOrientation(LinearLayoutManager.VERTICAL);

        rvCatalogList.setLayoutManager(myLinLayout);
        startPetCatalogList();
        startAdapter();

    }

    public void startPetCatalogList(){
        petCatalogs = new ArrayList<PetCatalog>();
        petCatalogs.add( new PetCatalog(R.drawable.benito ,"1", "1", "Benito"));
        petCatalogs.add( new PetCatalog(R.drawable.perro,"1", "3", "Baby Dog"));
        petCatalogs.add( new PetCatalog(R.drawable.atom_ant,"1", "4", "Atom Ant"));
    }

    public void startAdapter(){
        CatalogAdapter catalogAdapter = new CatalogAdapter(petCatalogs);
        rvCatalogList.setAdapter(catalogAdapter);
    }

    public void callFavoritePet(){
        intent = new Intent(MainActivity.this, FavorityPet.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                callFavoritePet();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
