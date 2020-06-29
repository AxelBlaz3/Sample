package com.example.sampleapp.fragmentA

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.databinding.FragmentABinding
import com.example.sampleapp.model.Sample
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialFadeThrough

/**
 * A simple [Fragment] subclass.
 */
class FragmentA : Fragment(),
    HomeAdapter.HomeAdapterListener {
    private lateinit var binding: FragmentABinding

    private val sampleList by lazy {
        ArrayList<Sample>().apply {
            add(Sample())
            add(Sample())
            add(Sample())
            add(Sample())
            add(Sample())
        }
    }

    private val adapter by lazy {
        HomeAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough.create().apply { duration = 300 }
        exitTransition = Hold().apply { duration = 300 }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        binding.homeRecyclerView.adapter = adapter
        adapter.submitList(sampleList)
    }

    override fun onHomeItemClick(cardView: View, position: Int) {
        val directions =
            FragmentADirections.actionFragmentAToFragmentB(
                position
            )
        val extras = FragmentNavigatorExtras(cardView to cardView.transitionName)
        findNavController().navigate(directions, extras)
    }
}