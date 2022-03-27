package sheridan.wrimicha.assignment3.ui.home


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.wrimicha.assignment3.R
import sheridan.wrimicha.assignment3.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater)

        navController = findNavController()

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }
//        viewModel.status.observe(viewLifecycleOwner){ status ->
//
//            binding.swipeRefresh.isRefreshing =
//                status == CatalogViewModel.Status.REFRESHING
//
//            if(status == CatalogViewModel.Status.ERROR){
//                if(!isErrorDialogShown()){
//                    showErrorDialog(
//                        title = getString(R.string.app_name),
//                        message = getString(R.string.cannot_load_the_data)
//                    )
//                    viewModel.reset()
//                }
//            }
//        }

        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.catalog, menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_refresh -> {
//                viewModel.refresh()
//                true
//            }
//            R.id.action_clear ->{
//                viewModel.clear()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

}





















//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import sheridan.wrimicha.assignment3.databinding.FragmentHomeBinding
//
//class HomeFragment : Fragment() {
//
//    private var _binding: FragmentHomeBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        return root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}