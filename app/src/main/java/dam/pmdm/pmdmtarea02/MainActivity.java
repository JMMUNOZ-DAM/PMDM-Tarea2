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


/**
 * Activity principal de la aplicación que gestiona la navegación y la configuración del menú.
 * Proporciona la funcionalidad de Navigation Drawer
 * y permite la interacción con diferentes fragmentos.
 */

public class MainActivity extends AppCompatActivity {
    // Configuración de la barra de aplicaciones (AppBar)
    private AppBarConfiguration mAppBarConfiguration;

    // Enlace (binding) a las vistas de la actividad principal
    private ActivityMainBinding binding;

    /**
     * Método llamado al crear la actividad.
     * Configura el binding, la barra de herramientas, el cajón de navegación
     * y la navegación entre fragmentos.
     *
     * @param savedInstanceState El estado guardado previamente de la actividad (puede ser null).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuración de la barra de herramientas
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configuración de destinos principales en el menú
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();

        // Configuración del controlador de navegación
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     * Maneja la navegación hacia arriba en el cajón de navegación.
     *
     * @return true si se realiza la navegación hacia arriba, false en caso contrario.
     */

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     * Crea las opciones del menú de la barra de aplicaciones.
     *
     * @param menu El menú donde se inflarán las opciones.
     * @return true si el menú se crea correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Infla el menú
        return true;
    }

    /**
     * Maneja las selecciones de elementos del menú.
     *
     * @param item El elemento seleccionado del menú.
     * @return true si el evento se maneja, false de lo contrario.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            showAboutDialog(); // Llama al método para mostrar el diálogo
            return true;
        }
        return super.onOptionsItemSelected(item);    }

    /**
     * Muestra un diálogo "Acerca de" con información sobre la aplicación.
     */
    private void showAboutDialog() {
        // Crear y mostrar el diálogo con información
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.about_message)
                .setIcon(R.drawable.marioicon) // Cargamos el icono
                .setPositiveButton(R.string.aceptar, null)
                .show();
    }

    /**
     * Maneja el clic en un elemento de la lista de personajes.
     * Navega hacia el fragmento de detalles de personajes con los datos correspondientes.
     *
     * @param pj   El objeto de datos del personaje seleccionado.
     * @param view La vista desde la cual se realizó el clic.
     */
    public void pjClicked(PjData pj, View view) {
        // Crear un Bundle para pasar datos al PjDetailFragment
        Bundle bundle = new Bundle();
        bundle.putInt("name", pj.getName()); // Pasa el nombre del personaje
        bundle.putInt("image", pj.getImage()); // Pasa la imagen del personaje
        bundle.putInt("description", pj.getDescription()); // Pasa la descripción
        bundle.putInt("abilities", pj.getAbilities());//Pasa las habilidades del personaje

        //Navegar al PjDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.pjs_recyclerview, bundle);
    }

}