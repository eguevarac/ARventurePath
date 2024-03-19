package com.example.arventurepath.ui.login_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.arventurepath.R
import com.example.arventurepath.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var register: Boolean = false
    private val viewModel = LoginViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getListUsers()

        binding.buttonLogin.setOnClickListener {
            if (register){
                if (isEditTextBlank()){

                }
            }
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToListArventureFragment3(idUser = 0)
            )
        }
        binding.textViewRegister.setOnClickListener {
            binding.editTextEmail.setText("")
            binding.editTextPassword.setText("")
            binding.editTextPasswordRepeat.setText("")
            if (!register){
                binding.editTextPasswordRepeat.visibility = View.VISIBLE
                binding.textViewRegister.text = getString(R.string.noregisterText)
                binding.buttonLogin.text = getString(R.string.register)
                register = true
            }else{
                binding.editTextPasswordRepeat.visibility = View.GONE
                binding.textViewRegister.text = getString(R.string.registerText)
                binding.buttonLogin.text = getString(R.string.login)
                register = false
            }
        }
    }

    private fun isEditTextBlank():Boolean{
        if (binding.editTextEmail.text.equals("")){
            return false
        }
        if (binding.editTextPassword.text.equals("")){
            return false
        }
        if (register){
            if (binding.editTextPasswordRepeat.text.equals("")){
                return false
            }
        }
        return true
    }

}