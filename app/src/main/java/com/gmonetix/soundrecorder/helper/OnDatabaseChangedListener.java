package com.gmonetix.soundrecorder.helper;

/**
 * @author Gmonetix
 */

public interface OnDatabaseChangedListener {
    void onNewDatabaseEntryAdded();
    void onDatabaseEntryRenamed();
}