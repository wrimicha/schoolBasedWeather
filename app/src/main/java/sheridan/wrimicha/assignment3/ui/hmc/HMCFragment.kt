package sheridan.wrimicha.assignment3.ui.hmc


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.wrimicha.assignment3.R
import dagger.hilt.android.AndroidEntryPoint
import sheridan.wrimicha.assignment3.databinding.FragmentHmcBinding
import sheridan.wrimicha.assignment3.ui.home.HMCViewModel

@AndroidEntryPoint
class HMCFragment : Fragment() {

    private val viewModel: HMCViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHmcBinding.inflate(inflater)

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
}