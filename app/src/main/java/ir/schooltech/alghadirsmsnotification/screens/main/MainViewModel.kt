package ir.schooltech.alghadirsmsnotification.screens.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.schooltech.alghadirsmsnotification.model.Contact
import ir.schooltech.alghadirsmsnotification.repository.ContactRepository
import ir.schooltech.alghadirsmsnotification.screens.splash.SplashState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val contactRepository: ContactRepository) :
	ViewModel() {
	val shownSplash = mutableStateOf(SplashState.Shown)
	private val _contactList = MutableStateFlow<List<Contact>>(emptyList())
	val contactList = _contactList.asStateFlow()
	
	init {
		viewModelScope.launch(Dispatchers.IO) {
			contactRepository.getAllContacts().distinctUntilChanged().collect() {
				_contactList.value = it
			}
		}
	}
	
	
}