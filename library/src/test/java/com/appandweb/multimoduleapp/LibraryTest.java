package com.appandweb.multimoduleapp;

import android.content.Context;
import com.appandweb.multimoduleapp.library.Library;
import com.appandweb.multimoduleapp.library.fcm.GetFCMToken;
import com.appandweb.multimoduleapp.library.model.AbsPushMessage;
import com.appandweb.multimoduleapp.library.model.MMNotification;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class LibraryTest {
    @Mock
    Context mockApplicationContext;

    @Mock
    GetFCMToken mockGetFCMToken;

    @Mock
    AbsPushMessage mockPushMessage;

    @Mock
    Library.View mockView;

    ArgumentCaptor<MMNotification> notificationCaptor = ArgumentCaptor.forClass(MMNotification.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Library.setDependencies(mockGetFCMToken, mockView);
    }

    @Test
    public void shouldGetAnFCMTokenOnInitialization() {
        Library.initialize(mockApplicationContext);

        verify(mockGetFCMToken).getFcmToken();
    }

    @Test
    public void shouldShowANotificationWhenRemoteMessageIsReceived() {
        Library.onNotificationReceived(mockPushMessage);

        verify(mockView).showNotification(notificationCaptor.capture());
    }
}
