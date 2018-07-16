package com.testing.statistics.service;

import com.testing.statistics.model.Statistics;
import com.testing.statistics.model.Transaction;

public interface Service {

    boolean addTransaction(Transaction transaction);
    Statistics getStatistics();
}
