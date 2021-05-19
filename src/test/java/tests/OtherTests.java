package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherTests {

    int MyDoublerMethod(int num) {
        if (num == 0) {
            throw new IllegalArgumentException();
        }
        return num * 2;
    }

    @Test
    void ExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> MyDoublerMethod(0));
    }

    @TempDir
    Path tempDir;

    @Test
    void TempDirForTest() throws IOException {
        Path createdFile = Files.createFile(tempDir.resolve("createdFile.txt"));

        assertTrue(createdFile.toFile().exists());
    }
}
