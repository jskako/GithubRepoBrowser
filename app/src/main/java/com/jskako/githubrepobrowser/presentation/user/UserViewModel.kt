package com.jskako.githubrepobrowser.presentation.user

import com.jskako.githubrepobrowser.data.shared.SharedRepositoryImpl
import com.jskako.githubrepobrowser.presentation.core.SharedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    sharedRepositoryData: SharedRepositoryImpl
) : SharedViewModel(sharedRepositoryData) {


}