package com.easy

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.easy.base.BaseActivity
import kotlinx.android.synthetic.main.main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onSeekBarChangeListener

class MainActivity : BaseActivity() {
    val edtNameId = 12
    var a=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        tvContent.setText(R.string.app_name)
        debug("ddddddd")
//        kotlin.error("dd")
//        kotlin.error(dip(34))
//        showAlerts()
//        showAlerts2()

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
        find<EditText>(edtNameId).text = Editable.Factory.getInstance().newEditable("master 分支")

//        startActivity<MainActivity>("id" to 5, "name" to "ActivityName")

        alert {
            customView {
                verticalLayout {
                    val familyName = editText {
                        hint = "Family name"
                    }
                    val firstName = editText {
                        hint = "First name"
                    }
                    positiveButton("Register") { register(familyName.text, firstName.text) }
                }
            }
        }.show()
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
