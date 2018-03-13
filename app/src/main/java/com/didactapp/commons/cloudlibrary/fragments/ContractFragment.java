package com.didactapp.commons.cloudlibrary.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

/* Base fragment to ensure the parent activity implements a contract interface. */
public abstract class ContractFragment<T> extends Fragment {
    private T contract;

    @Override
    public void onAttach(Activity activity) {
        try {
            contract = (T) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException(activity.getClass().getSimpleName()
                    + " does not implement " + getClass().getSimpleName() + "'s contract interface.", e);
        }
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        contract = null;
    }

    public final T getContract() {
        return contract;
    }
}