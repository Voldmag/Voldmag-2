import com.example.String.StringProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    @Test
    void repetitionMethod_positiveNum() {
        assertEquals("test test test ", StringProcessor.repetitionMethod("test", 3));
        assertEquals("hello ", StringProcessor.repetitionMethod("hello", 1));
    }

    @Test
    void repetitionMethod_zeroNum() {
        assertEquals("Пустая строка!", StringProcessor.repetitionMethod("test", 0));
    }

    @Test
    void repetitionMethod_negativeNum() {
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.repetitionMethod("test", -1));
    }

    @Test
    void lineOccursMethod_positiveOccurs() {
        assertEquals(2, StringProcessor.lineOccursMethod("test test test", "test"));
        assertEquals(1, StringProcessor.lineOccursMethod("hello world hello", "hello"));
    }

    @Test
    void lineOccursMethod_zeroOccurs() {
        assertEquals(0, StringProcessor.lineOccursMethod("test test test", "hello"));
    }

    @Test
    void lineOccursMethod_emptyWord() {
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.lineOccursMethod("test", ""));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.lineOccursMethod("test", null));
    }

    @Test
    void replacingNumMethod_replacesNumbers() {
        assertEquals("один дватри", StringProcessor.replacingNumMethod("123"));
        assertEquals("тест один два", StringProcessor.replacingNumMethod("тест12"));
        assertEquals("123", StringProcessor.replacingNumMethod("123")); 
    }

    @Test
    void deleteEveryOtherCharacterMetod_positive() {
        assertEquals("hlo", StringProcessor.deleteEveryOtherCharacterMetod("hello"));
        assertEquals("Hlowrd", StringProcessor.deleteEveryOtherCharacterMetod("HelloWorld"));
    }

    @Test
    void deleteEveryOtherCharacterMetod_empty() {
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.deleteEveryOtherCharacterMetod(""));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.deleteEveryOtherCharacterMetod(null));
    }


    @Test
    void reverseWordsmMetod_reversesWords() {
        assertEquals("world hello", StringProcessor.reverseWordsmMetod("hello world"));
        assertEquals("c b a", StringProcessor.reverseWordsmMetod("a b c"));
    }

    @Test
    void reverseWordsmMetod_empty() {
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.reverseWordsmMetod(""));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.reverseWordsmMetod(null));
    }

    @Test
    void convertHexToDecMetod_convertsHex() {
        assertEquals("16 10", StringProcessor.convertHexToDecMetod("0x10 0xA"));
        assertEquals("16 0xA", StringProcessor.convertHexToDecMetod("0x10 0xA invalid"));
    }

    @Test
    void convertHexToDecMetod_empty() {
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.convertHexToDecMetod(""));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.convertHexToDecMetod(null));
    }


    @Test
    void isValidHex_validHex() {
        assertTrue(StringProcessor.isValidHex("0x1A"));
        assertTrue(StringProcessor.isValidHex("1A"));
        assertTrue(StringProcessor.isValidHex("F"));
        assertTrue(StringProcessor.isValidHex("1234567890ABCDEF"));
    }

    @Test
    void isValidHex_invalidHex() {
        assertFalse(StringProcessor.isValidHex("0xG"));
        assertFalse(StringProcessor.isValidHex("123g"));
        assertFalse(StringProcessor.isValidHex("0x"));
        assertFalse(StringProcessor.isValidHex(""));
    }
}
