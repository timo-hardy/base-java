package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        for (Resume resume : storage) {
            resume = null;
        }
//        for (int i = 0; i < size; i++) {
//            storage[i] = null;
//        }
        size = 0;
    }

    public void update(Resume r) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(r)) {
                storage[size] = r;
            }
        }
    }

    public void save(Resume r) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(r)) {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
