package com.example.administrador.petshopstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FavorityPet extends AppCompatActivity {
    ArrayList<PetCatalog> favPetCatalogs;
    RecyclerView rvFavorCatalogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favority_pet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvFavorCatalogList = (RecyclerView) findViewById(R.id.recFavoritePetCatalog);

        LinearLayoutManager myLinLayout = new LinearLayoutManager(this);
        myLinLayout.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavorCatalogList.setLayoutManager(myLinLayout);
        startFavPetCatalogList();
        startAdapter();
    }

    public void startFavPetCatalogList(){
        favPetCatalogs = new ArrayList<PetCatalog>();
        favPetCatalogs.add( new PetCatalog(R.drawable.woody_woodpecker ,"0", "6", "Woodpecker"));
        favPetCatalogs.add( new PetCatalog(R.drawable.osohormiguero,"0", "5", "Oso H"));
        favPetCatalogs.add( new PetCatalog(R.drawable.demostenes,"0", "4", "Demostenes"));
        favPetCatalogs.add( new PetCatalog(R.drawable.inspector,"0", "4", "Brave Lion"));
        favPetCatalogs.add( new PetCatalog(R.drawable.tigre,"0", "7", "Sport Tiger"));

    }

    public void startAdapter(){
        CatalogAdapter catalogAdapter = new CatalogAdapter(favPetCatalogs);
        rvFavorCatalogList.setAdapter(catalogAdapter);
    }
}
