package com.appandweb.multimoduleapp.library.common;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LibraryNullInitializationTest {
    @Mock
    AbsPushMessage mockPushMessage;

    @Rule
    public ExpectedException noExceptionsThrown = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotCrashIfCallingNotificationReceivedWithoutInitializing() {
        Library.onNotificationReceived(mockPushMessage);
    }

    @Test
    public void shouldNotCrashIfCallingNotificationReceivedInitializedWithNulls() {
        Library.setDependencies(null, null);

        Library.onNotificationReceived(mockPushMessage);
    }
}
