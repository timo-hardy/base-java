import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        Arrays.fill(storage, r);
    }

    Resume get(String uuid) {
            if (storage[storage.length - 1].uuid == uuid) {
                return storage[storage.length - 1];
            }
        return null;
    }

    void delete(String uuid) {
        if (storage[storage.length - 1].uuid == uuid) {
            Arrays.fill(storage, null);
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
