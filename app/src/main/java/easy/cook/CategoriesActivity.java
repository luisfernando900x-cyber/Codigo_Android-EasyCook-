package easy.cook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import androidx.cardview.widget.CardView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CategoriesActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // --- LÓGICA DE NAVEGACIÓN ENTRE CATEGORÍAS ---
        ImageButton btnBack = findViewById(R.id.btnBack);
        CardView tabComida = findViewById(R.id.tabComida);
        CardView tabCena = findViewById(R.id.tabCena);

        btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        tabComida.setOnClickListener(v -> {
            startActivity(new Intent(CategoriesActivity.this, ComidaActivity.class));
            finish();
        });

        tabCena.setOnClickListener(v -> {
            startActivity(new Intent(CategoriesActivity.this, CenaActivity.class));
            finish();
        });

        // --- LÓGICA EXISTENTE DEL BOTTOM NAVIGATION ---
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_categories);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    Intent intent = new Intent(CategoriesActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                else if (id == R.id.nav_ingredients) {
                    Intent intent = new Intent(CategoriesActivity.this, IngredientsActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                else if (id == R.id.nav_categories) {
                    return true;
                }
                return false;
            }
        });
    }
}