package easy.cook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class IngredientsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        // 1. Inicializar botones
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        btnBack = findViewById(R.id.btnBack);

        // 2. Configurar el botón de volver (regresa a la pantalla anterior)
        btnBack.setOnClickListener(v -> finish());

        // 3. Configurar clic en la tarjeta de receta sugerida
        // Asumiendo que es la única tarjeta, pero puedes darle un ID más específico si tienes varias
        findViewById(R.id.cardRecetaImg).setOnClickListener(v -> {
            Intent intent = new Intent(IngredientsActivity.this, RecipeDetailActivity.class);
            startActivity(intent);
        });

        // 4. Marcar "Refrigerador" como activo
        bottomNavigationView.setSelectedItemId(R.id.nav_ingredients);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    navegarA(MainActivity.class);
                    return true;
                }
                else if (id == R.id.nav_ingredients) {
                    return true;
                }
                else if (id == R.id.nav_categories) {
                    navegarA(CategoriesActivity.class);
                    return true;
                }
                return false;
            }
        });
    }

    // Método auxiliar para evitar código repetido
    private void navegarA(Class<?> actividad) {
        Intent intent = new Intent(IngredientsActivity.this, actividad);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}