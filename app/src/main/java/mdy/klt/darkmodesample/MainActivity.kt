package mdy.klt.darkmodesample

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import mdy.klt.darkmodesample.helper.ThemeHelper

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.light -> {
                viewModel.saveMode(ThemeHelper.LIGHT_MODE)
                Log.e(this::class.simpleName ,item.title.toString())
            }
            R.id.dark -> {
                viewModel.saveMode(ThemeHelper.DARK_MODE)
                Log.e(this::class.simpleName ,item.title.toString())
            }
            R.id.sys_def -> {
                viewModel.saveMode(ThemeHelper.DEFAULT)
                Log.e(this::class.simpleName ,item.title.toString())
            }
            else -> {
                viewModel.saveMode(ThemeHelper.DEFAULT)
                Log.e(this::class.simpleName ,item.title.toString())
            }
        }
        return true
    }

}