package com.example.jetweatherapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SearchFormComponent(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},

) {
    val searchQueryState = rememberSaveable{
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val validate = remember(searchQueryState.value){
        searchQueryState.value.trim().isNotEmpty()
    }
    Column(modifier = modifier) {
        CommonTextField(valueState = searchQueryState,
            placeholder = "Search",
            onAction = KeyboardActions {
                if(!validate) return@KeyboardActions
                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyboardController?.hide()
                }
            )
    }
}

@Composable
fun CommonTextField(
    valueState: MutableState<String>,
    placeholder: String,
    onAction:KeyboardActions = KeyboardActions.Default,
    imeActions: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,

){
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {
            valueState.value = it
        },
        keyboardActions = onAction,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType, imeAction = imeActions
        ),
        label = {
            Text(text = placeholder)
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Blue,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,

            cursorColor = Color.Black
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)

    )
}