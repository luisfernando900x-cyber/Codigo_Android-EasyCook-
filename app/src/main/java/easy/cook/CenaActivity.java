package easy.cook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import androidx.cardview.widget.CardView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CenaActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_cena);

        // --- NAVEGACIÓN ENTRE CATEGORÍAS ---
        ImageButton btnBack = findViewById(R.id.btnBack);
        CardView tabDesayuno = findViewById(R.id.tabDesayuno);
        CardView tabComida = findViewById(R.id.tabComida);

        btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        tabDesayuno.setOnClickListener(v -> {
            startActivity(new Intent(CenaActivity.this, CategoriesActivity.class));
            finish();
        });

        tabComida.setOnClickListener(v -> {
            startActivity(new Intent(CenaActivity.this, ComidaActivity.class));
            finish();
        });

        // --- BOTTOM NAVIGATION ---
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_categories);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                irA(MainActivity.class);
                return true;
            } else if (id == R.id.nav_ingredients) {
                irA(IngredientsActivity.class);
                return true;
            } else if (id == R.id.nav_categories) {
                return true;
            }
            return false;
        });
    }

    private void irA(Class<?> activityClass) {
        Intent intent = new Intent(CenaActivity.this, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}