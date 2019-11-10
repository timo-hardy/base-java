import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;

    Resume[] storage = new Resume[10000];

    void clear() {
        for (Resume resume : storage) {
            if (storage != null) {
                storage = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return new Resume();
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (Resume resume : storage) {
            if (storage.clone() != null) {
                return storage;
            }
        }
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        return size;
    }
}
