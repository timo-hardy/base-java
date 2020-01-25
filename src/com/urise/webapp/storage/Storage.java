package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume resume);

    List<Resume> get(String uuid);

    void delete(String uuid);

    List<Resume> getAll();

    int size();
}
