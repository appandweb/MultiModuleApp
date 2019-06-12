package com.appandweb.multimoduleapp.library.common;

import android.content.Context;
import com.appandweb.multimoduleapp.library.common.fcm.GetFCMToken;
import com.appandweb.multimoduleapp.library.common.permission.CheckPermission;
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
    CheckPermission mockCheckPermission;

    @Mock
    AbsPushMessage mockPushMessage;

    @Mock
    Library.View mockView;

    ArgumentCaptor<MMNotification> notificationCaptor = ArgumentCaptor.forClass(MMNotification.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Library.setDependencies(mockGetFCMToken, mockCheckPermission, mockView);
    }

    @Test
    public void shouldShowANotificationWhenRemoteMessageIsReceived() {
        Library.onNotificationReceived(mockPushMessage);

        verify(mockView).showNotification(notificationCaptor.capture());
    }
}
