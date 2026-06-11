package easy.cook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Button btnBanner;
    private TextView tvVerTodas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // 1. Inicializar la barra de navegación inferior
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        // 2. Inicializar los componentes interactivos
        btnBanner = findViewById(R.id.btnBanner);
        tvVerTodas = findViewById(R.id.tvVerTodas);

        // --- NUEVO: Configurar clics de Categorías ---
        findViewById(R.id.btnDesayuno).setOnClickListener(v -> abrirActivity(CategoriesActivity.class));
        findViewById(R.id.btnComida).setOnClickListener(v -> abrirActivity(ComidaActivity.class));
        findViewById(R.id.btnCena).setOnClickListener(v -> abrirActivity(CenaActivity.class));

        // --- NUEVO: Configurar clics de Recetas Populares ---
        findViewById(R.id.cardReceta1).setOnClickListener(v -> abrirActivity(RecipeDetailActivity.class));
        findViewById(R.id.cardReceta2).setOnClickListener(v -> abrirActivity(RecipeDetailActivity.class));
        findViewById(R.id.cardReceta3).setOnClickListener(v -> abrirActivity(RecipeDetailActivity.class));

        // 3. Botón "Ver recetas" del Banner
        btnBanner.setOnClickListener(v -> abrirCategorias());

        // 4. Texto "Ver todas"
        tvVerTodas.setOnClickListener(v -> abrirCategorias());

        // 5. Barra inferior
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) return true;
            if (id == R.id.nav_ingredients) {
                abrirActivity(IngredientsActivity.class);
                return true;
            }
            if (id == R.id.nav_categories) {
                abrirCategorias();
                return true;
            }
            return false;
        });
    }

    // Método que ya tenías
    private void abrirCategorias() {
        abrirActivity(CategoriesActivity.class);
    }

    // Método genérico para abrir cualquier actividad (mantiene tu estilo)
    private void abrirActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}