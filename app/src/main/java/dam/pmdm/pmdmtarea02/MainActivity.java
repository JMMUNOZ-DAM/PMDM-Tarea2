package dam.pmdm.pmdmtarea02;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


import dam.pmdm.pmdmtarea02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Infla el menú
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            showAboutDialog(); // Llama al método para mostrar el diálogo
            return true;
        }
        return super.onOptionsItemSelected(item);    }

    private void showAboutDialog() {
        // Crear y mostrar el diálogo con información
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.about_message)
                .setIcon(R.drawable.marioicon) // Cargamos el icono
                .setPositiveButton(R.string.aceptar, null)
                .show();
    }

    // Método para manejar el clic en un personaje
    public void pjClicked(PjData pj, View view) {
        // Crear un Bundle para pasar los datos al PjDetailFragment
        Bundle bundle = new Bundle();
        bundle.putInt("name", pj.getName()); // Pasa el nombre del personaje
        bundle.putInt("image", pj.getImage()); // Pasa la imagen del personaje
        bundle.putInt("description", pj.getDescription()); // Pasa la descripción o más datos que necesites
        bundle.putInt("abilities", pj.getAbilities());//Pasa las habilidades del personaje
        //Navegar al GameDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.pjs_recyclerview, bundle);
    }

}