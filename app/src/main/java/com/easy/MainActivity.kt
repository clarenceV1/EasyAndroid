package com.easy

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.easy.base.BaseActivity
import com.easy.data.ExampleEntity
import kotlinx.android.synthetic.main.main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onSeekBarChangeListener


class MainActivity : BaseActivity() {
    val edtNameId = 12
    var a = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        tvContent.setText(R.string.app_name)
        info ("info info info")
        warn ("warn warn warn")
        verbose ("verbose verbose verbose")
        debug ("debug debug debug")
        error ("error error error")
//        kotlin.error("dd")
//        kotlin.error(dip(34))
//        showAlerts()
//        showAlerts2()
//        showAlerts3()
        verticalLayout {
            backgroundColor = Color.parseColor("#FFFFFF")
            padding = dip(10)
            editText {
                id = edtNameId
                hint = "Name"
                onClick {
                    toast("Name")
                }
            }.lparams(width = dip(100)) {
                margin = dip(10)
            }.applyRecursively {
                if (it is EditText) {
                    it.textSize = 30f
                }
            }
            include<View>(R.layout.main_head) {
                find<TextView>(R.id.tvDay).text = getString(R.string.app_name)
            }
            seekBar {
                onSeekBarChangeListener {
                    onProgressChanged { seekBar, progress, fromUser ->
                        // Do Something
                    }
                }
            }
        }
        find<EditText>(edtNameId).text = Editable.Factory.getInstance().newEditable(applicationMetaData(packageManager, packageName, "env"))



        testSql()
    }

    private fun showAlerts3() {
        alert {
            customView {
                verticalLayout {
                    val familyName = editText {
                        hint = "Family name"
                    }
                    val firstName = editText {
                        hint = "First name"
                    }
                    positiveButton("Register") { toast("点击了") }
                }
            }
        }.show()
    }

    private fun testSql() {

        var entityBox = boxStore().boxFor(ExampleEntity::class.java)
        var entity = ExampleEntity()
        entity.name = "test"
        entityBox.put(entity)

        var entity2 = entityBox.query().build().findFirst()
        Log.d("testSql", entity2.toString())
    }

    private fun showAlerts2() {
        alert(Appcompat, "Some text message").show()
    }

    private fun showAlerts() {
        alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
            yesButton { toast("yes button…") }
            noButton { toast("no button…") }
        }.show()
    }
}
