package com.appspot.lincoln_kids;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
    private static final PersistenceManagerFactory pmfInstance = JDOHelper
            .getPersistenceManagerFactory("transactions-optional");

    private PMF() { /* nop */ }

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}