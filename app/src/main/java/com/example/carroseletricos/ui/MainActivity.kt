package com.example.carroseletricos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.carroseletricos.R
import com.example.carroseletricos.ui.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {                                                          // É criada a classe que primeiro será executada ao rodar o programa e digo que suas propriedades e métodos serão os passados pelo appCompatActivity.

    lateinit var tabLayout : TabLayout
    lateinit var viewPager : ViewPager2                                                             // São criadas as variáveis lateinit que reseberão valores posteriormente.

    override fun onCreate(savedInstanceState: Bundle?) {                                            // É iniciado o primeiro ciclo do app, com uma função que recebe propriedades definidas pelo savedInstanceState.
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)                                                      // É definido que o conteúdo exibido primeiramente pelo app será o arquivo XML activity_main.

        setupView()
        setupTabs()                                                                                 // São chamados os métodos que criei.
    }

    private fun setupView(){                                                                        // É definido o que será exibido na tela.
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.vp_view_pager)                                                // São referenciados os conteúdos XML que serão propriamente exibidos.
    }


    private fun setupTabs() {                                                                       // São definidas as funções execidas pela Tab.

        val tabsAdapter = TabAdapter(this)                                              // É criada a variável que receberá as informações de TabAdapter.

        viewPager.adapter = tabsAdapter                                                             // viewPager será adaptado de acordo com o as adaptações passadas em TabAdapter.

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.currentItem = it.position
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        }

        )

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {          // Notificando a posição do viewPager para a tab

            override fun onPageSelected(position: Int) {                                            // A posição será 0 ou 1
                super.onPageSelected(position)                                                      // A seleção receberá a posição 0 ou 1...

                tabLayout.getTabAt(position)?.select()                                              // ... E informará à tabLayout a posição selecionada na viewPage
            }
        }

        )

    }


}