package com.appandweb.multimoduleapp;

import android.content.Context;
import com.appandweb.multimoduleapp.library.Library;
import com.appandweb.multimoduleapp.library.fcm.GetFCMToken;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class LibraryTest {
    @Mock
    Context mockApplicationContext;

    @Mock
    GetFCMToken mockGetFCMToken;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Library.setDependencies(mockGetFCMToken);
    }

    @Test
    public void shouldGetAnFCMTokenOnInitialization() {
        Library.initialize(mockApplicationContext);

        verify(mockGetFCMToken).getFcmToken();
    }
}
