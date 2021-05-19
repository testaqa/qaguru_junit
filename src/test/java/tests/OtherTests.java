package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
