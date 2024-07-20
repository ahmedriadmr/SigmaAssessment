package com.example.sigmaassessment.profile_details.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sigmaassessment.core.domain.util.Result
import com.example.sigmaassessment.core.presentation.asUiText
import com.example.sigmaassessment.profile_details.domain.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileDetailsViewModel @Inject constructor(private val profileUseCase: GetProfileUseCase) : ViewModel() {

    var state by mutableStateOf(ProfileDetailsState())
        private set

    private val eventChannel = Channel<ProfileDetailsEvent>()
    val events = eventChannel.receiveAsFlow()


    init {
        fetchProfileInfo()
    }

    private fun fetchProfileInfo() {
        viewModelScope.launch {
            when (val result = profileUseCase()) {
                is Result.Error -> {
                    eventChannel.send(ProfileDetailsEvent.Error(result.error.asUiText()))
                }

                is Result.Success -> {
                    state = state.copy(data = result.data)
                }
            }
        }
    }

    fun onAction(action: ProfileDetailsAction) {
        when (action) {
            ProfileDetailsAction.OnBackClick -> {}
            ProfileDetailsAction.OnEditEmail -> {}
        }
    }
}