package app.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.types.InMemoryRepository;

class InMemoryRepositoryTest {
    private InMemoryRepository<String> repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRepository<>();
    }

    @Test
    void testSaveAndFindById() {
        String id = repository.save("Test Entity");
        assertNotNull(id);
        assertEquals("Test Entity", repository.findById(id));
    }

    @Test
    void testUpdateExistingEntity() {
        String id = repository.save("Old Entity");
        repository.update(id, "Updated Entity");
        assertEquals("Updated Entity", repository.findById(id));
    }

    @Test
    void testUpdateNonExistingEntity() {
        assertThrows(NoSuchElementException.class, () -> repository.update("non-existent-id", "New Entity"));
    }

    @Test
    void testDeleteExistingEntity() {
        String id = repository.save("To be deleted");
        repository.delete(id);
        assertNull(repository.findById(id));
    }

    @Test
    void testDeleteNonExistingEntity() {
        assertThrows(NoSuchElementException.class, () -> repository.delete("non-existent-id"));
    }

    @Test
    void testFindAll() {
        repository.save("Entity1");
        repository.save("Entity2");
        List<String> allEntities = repository.findAll();
        assertEquals(2, allEntities.size());
    }
}
