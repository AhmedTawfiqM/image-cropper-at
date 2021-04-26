package com.atdev.image_cropper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

internal class ActivityResultFragment : Fragment() {
    private lateinit var callback: (ActivityResult) -> Unit

    private lateinit var requestPermissionLauncher: ActivityResultLauncher<Intent>
    private var intent: Intent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (this::callback.isInitialized)
                callback(it!!)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchActivityForResult()
    }

    private fun launchActivityForResult() {
        try {
            requestPermissionLauncher?.launch(intent)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    companion object {
        private fun newInstance(): ActivityResultFragment {
            return ActivityResultFragment()
        }

        fun request(intent: Intent,
                    activity: FragmentActivity,
                    callback: (ActivityResult) -> Unit): ActivityResultFragment {
            var frag = findFragment(activity.supportFragmentManager)
            if (frag == null) {
                frag = newInstance()
                frag.intent = intent
                frag.callback = callback
                activity.supportFragmentManager
                        .beginTransaction()
                        .add(frag, ActivityResultFragment::class.java.simpleName)
                        .commitAllowingStateLoss()
                return frag
            }
            frag.intent = intent
            frag.callback = callback
            frag.launchActivityForResult()
            return frag
        }

        private fun findFragment(fragmentManager: FragmentManager): ActivityResultFragment? {
            return fragmentManager.findFragmentByTag(ActivityResultFragment::class.java.simpleName) as ActivityResultFragment?
        }

    }
}