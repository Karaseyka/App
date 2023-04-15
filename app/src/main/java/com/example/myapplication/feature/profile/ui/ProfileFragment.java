//package com.example.myapplication.feature.profile.ui;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.Navigation;
//
//import com.bumptech.glide.Glide;
//import com.example.myapplication.databinding.FragmentProfileBinding;
//import com.example.myapplication.domain.model.User;
//import com.example.myapplication.feature.profile.presentation.ProfileStatus;
//import com.example.myapplication.feature.profile.presentation.ProfileViewModel;
//
//public class ProfileFragment extends Fragment {
//    private ProfileViewModel viewModel;
//    private ProfileFragmentArgs args;
//    private FragmentProfileBinding binding;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
//        args = ProfileFragmentArgs.fromBundle(requireArguments());
//        binding = FragmentProfileBinding.inflate(inflater);
//        return binding.getRoot();
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        viewModel.status.observe(getViewLifecycleOwner(), this::renderStatus);
//        viewModel.user.observe(getViewLifecycleOwner(), this::renderUser);
//        if (savedInstanceState == null) viewModel.load(args.getId());
//        binding.delete.setOnClickListener(v -> viewModel.delete(args.getId()));
//
//    }
//    private void renderStatus(ProfileStatus status){
//        switch (status){
//            case LOADING:
//                binding.imageLayout.setVisibility(View.INVISIBLE);
//                binding.name.setVisibility(View.INVISIBLE);
//                binding.email.setVisibility(View.INVISIBLE);
//                binding.delete.setVisibility(View.INVISIBLE);
//                binding.error.setVisibility(View.INVISIBLE);
//                binding.progress.setVisibility(View.VISIBLE);
//                break;
//            case LOADED:
//                binding.imageLayout.setVisibility(View.VISIBLE);
//                binding.name.setVisibility(View.VISIBLE);
//                binding.email.setVisibility(View.VISIBLE);
//                binding.delete.setVisibility(View.VISIBLE);
//                binding.error.setVisibility(View.VISIBLE);
//                binding.progress.setVisibility(View.INVISIBLE);
//                break;
//            case FALURE:
//                binding.imageLayout.setVisibility(View.INVISIBLE);
//                binding.name.setVisibility(View.INVISIBLE);
//                binding.email.setVisibility(View.INVISIBLE);
//                binding.delete.setVisibility(View.INVISIBLE);
//                binding.error.setVisibility(View.VISIBLE);
//                binding.progress.setVisibility(View.INVISIBLE);
//                break;
//            case DELETE:
//                Navigation.findNavController(binding.getRoot()).navigateUp();
//
//        }
//    }
//
//    private void renderUser(User user){
//        Glide.with(binding.getRoot()).load(user.getPhotoURL()).into(binding.image);
//        binding.name.setText(user.getName());
//        binding.email.setText(user.getEmail());
//
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        binding = null;
//    }
//}
