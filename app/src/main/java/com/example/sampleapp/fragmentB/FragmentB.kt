package com.example.sampleapp.fragmentB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentBBinding
import com.example.sampleapp.model.SampleDetail
import com.google.android.material.transition.MaterialContainerTransform

/**
 * A simple [Fragment] subclass.
 */
class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding
    private val args: FragmentBArgs by navArgs()
    private val position by lazy { args.position }

    private val adapter by lazy {
        SampleAdapter()
    }

    private val sampleList by lazy {
        ArrayList<String>().apply {
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
            add("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        prepareTransitions()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            this.sampleDetail = SampleDetail()
            position = this@FragmentB.position

            sampleRecyclerView.adapter = adapter
            adapter.submitList(sampleList)
        }

        startTransitions()
    }

    private fun prepareTransitions() {
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 300
            drawingViewId = R.id.nav_host_fragment
        }
        sharedElementReturnTransition = MaterialContainerTransform().apply {
            duration = 300
            drawingViewId = R.id.home_recycler_view
        }
    }

    private fun startTransitions() {
        binding.executePendingBindings()
        startPostponedEnterTransition()
    }
}