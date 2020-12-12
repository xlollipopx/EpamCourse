package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;

import java.util.Optional;

public interface BeatDao extends Dao<Beat> {

    Optional<Beat> findBeatByName(String name) throws DaoException;

}
