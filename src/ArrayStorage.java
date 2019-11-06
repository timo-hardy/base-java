import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (Resume resume : storage) {
            if (storage.clone() != null) {
                storage[9997] = null;
            }
        }
    }

    void save(Resume r) {
        for (Resume resume : storage) {
            if (storage[storage.length - 1] == null) {
                storage[9997] = r;
            }
        }
    }

    Resume get(String uuid) {
        if (storage[9997].uuid == uuid) {
            return storage[9997];
        }
        return storage[9997];
    }

    void delete(String uuid) {
        if (storage[9997].uuid == uuid) {
            storage[9997] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        return storage.length;
    }
}
