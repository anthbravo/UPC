package pe.edu.upc.u201320891

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        if (savedInstanceState == null) {
            val fragment = MainFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.flContent, fragment, fragment.javaClass.simpleName)
                .commit()
        }
    }

    private fun initViews() {

        bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mMain -> {

                    val fragment = MainFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, fragment, fragment.javaClass.simpleName)
                        .commit()
                    true
                }
                R.id.mMyFavoritePet -> {
                    val fragment = FavoriteFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, fragment, fragment.javaClass.simpleName)
                        .commit()
                    true
                }
                R.id.mList -> {
                    val fragment = ListFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, fragment, fragment.javaClass.simpleName)
                        .commit()
                    true
                }
                else -> true
            }
        }

    }


}