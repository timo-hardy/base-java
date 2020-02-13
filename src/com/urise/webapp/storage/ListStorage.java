package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage {
    private List<Resume> resumes = new ArrayList<>();

    @Override
    public void clear() {
        resumes.clear();
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            resumes.set(index, resume);
        }
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            resumes.add(resume);
        }
    }

    @Override
    public Resume get(String uuid) {
        Integer index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return resumes.get(index);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            resumes.remove(index);
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

    protected Integer getIndex(String uuid) {

        for (int i = 0; i < resumes.size(); i++) {
            String listUuid = resumes.get(i).getUuid();
            if (listUuid.equals(listUuid)) {
                return i;
            } else if (listUuid == null) {
                return null;
            }
        }
        return -1;
    }
}
