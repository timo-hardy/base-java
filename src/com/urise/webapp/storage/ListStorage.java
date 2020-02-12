package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public class ListStorage implements Storage {
    private List<Resume> resumes = new ArrayList<>();

    @Override
    public void clear() {
        List<Resume> results = new ArrayList<>();
        resumes.removeAll(results);
    }

    @Override
    public void update(Resume r) {
        for (Resume resume : resumes) {
        }
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else if (resumes.size() == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            resumes.add(resume);
        }
    }

    @Override
    public Resume get(String uuid) {
        if (getIndex(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        }
        return resumes.get(getIndex(uuid));
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            resumes.remove(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return resumes.toArray(new Resume[resumes.size()]);
    }

    @Override
    public int size() {
        return resumes.size();
    }

    @Override
    public Integer getIndex(String uuid) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
