package easy.cook;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Asegúrate de tener un archivo llamado activity_recipe_detail.xml en res/layout
        setContentView(R.layout.activity_recipe_detail);

        // Aquí puedes añadir lógica futura, como recibir el nombre de la receta
        // que el usuario tocó en la pantalla principal.
    }

    // Esto permite que al presionar el botón de "atrás" del celular,
    // regrese al menú principal en lugar de cerrarse o quedarse colgado
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}