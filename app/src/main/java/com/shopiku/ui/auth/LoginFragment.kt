package com.shopiku.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import com.shopiku.databinding.FragmentLoginBinding
import com.shopiku.util.SessionManager
import com.shopiku.util.UiState
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabs()
        setupLogin()
        setupRegister()
        observeStates()
    }

    private fun setupTabs() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> showLoginForm()
                    1 -> showRegisterForm()
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun showLoginForm() {
        binding.layoutLogin.visibility = View.VISIBLE
        binding.layoutRegister.visibility = View.GONE
    }

    private fun showRegisterForm() {
        binding.layoutLogin.visibility = View.GONE
        binding.layoutRegister.visibility = View.VISIBLE
    }

    private fun setupLogin() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            if (validateLoginForm(email, password)) {
                viewModel.login(email, password)
            }
        }

        binding.btnLoginGoogle.setOnClickListener {
            // Simulasi login Google
            viewModel.login("user@gmail.com", "password123")
        }

        binding.btnLoginFacebook.setOnClickListener {
            viewModel.login("user@facebook.com", "password123")
        }
    }

    private fun setupRegister() {
        binding.btnRegister.setOnClickListener {
            val name = binding.etRegisterName.text.toString().trim()
            val email = binding.etRegisterEmail.text.toString().trim()
            val password = binding.etRegisterPassword.text.toString()
            val confirmPassword = binding.etRegisterConfirmPassword.text.toString()
            if (validateRegisterForm(name, email, password, confirmPassword)) {
                viewModel.register(name, email, password)
            }
        }
    }

    private fun validateLoginForm(email: String, password: String): Boolean {
        var valid = true
        if (email.isEmpty()) {
            binding.tilEmail.error = "Email tidak boleh kosong"
            valid = false
        } else {
            binding.tilEmail.error = null
        }
        if (password.isEmpty()) {
            binding.tilPassword.error = "Password tidak boleh kosong"
            valid = false
        } else if (password.length < 6) {
            binding.tilPassword.error = "Password minimal 6 karakter"
            valid = false
        } else {
            binding.tilPassword.error = null
        }
        return valid
    }

    private fun validateRegisterForm(name: String, email: String, password: String, confirm: String): Boolean {
        var valid = true
        if (name.isEmpty()) { binding.tilRegisterName.error = "Nama tidak boleh kosong"; valid = false }
        else binding.tilRegisterName.error = null

        if (email.isEmpty()) { binding.tilRegisterEmail.error = "Email tidak boleh kosong"; valid = false }
        else binding.tilRegisterEmail.error = null

        if (password.length < 6) { binding.tilRegisterPassword.error = "Password minimal 6 karakter"; valid = false }
        else binding.tilRegisterPassword.error = null

        if (password != confirm) { binding.tilRegisterConfirmPassword.error = "Password tidak cocok"; valid = false }
        else binding.tilRegisterConfirmPassword.error = null

        return valid
    }

    private fun observeStates() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loginState.collect { state ->
                when (state) {
                    is UiState.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is UiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        SessionManager.saveToken(requireContext(), state.data)
                        (activity as? AuthActivity)?.navigateToMain()
                    }
                    is UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tilPassword.error = state.message
                    }
                    null -> binding.progressBar.visibility = View.GONE
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.registerState.collect { state ->
                when (state) {
                    is UiState.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is UiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        SessionManager.saveToken(requireContext(), state.data)
                        (activity as? AuthActivity)?.navigateToMain()
                    }
                    is UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tilRegisterPassword.error = state.message
                    }
                    null -> binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
