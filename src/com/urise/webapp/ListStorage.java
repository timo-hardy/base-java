package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.Storage;

import java.util.ArrayList;
import java.util.List;

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
        resumes.add(resume);
    }

    @Override
    public List<Resume> get(String uuid) {
        List<Resume> results = new ArrayList<>();
        for (Resume resume : resumes) {
            if (resume.getUuid().equals(uuid)) {
                results.add(resume);
            }
        }
        return results;
    }

    @Override
    public void delete(String uuid) {
        resumes.remove(uuid);
    }

    @Override
    public List<Resume> getAll() {
        List<Resume> results = new ArrayList<>();
        results.addAll(resumes);
        return results;
    }

    @Override
    public int size() {
        return resumes.size();
    }
}
