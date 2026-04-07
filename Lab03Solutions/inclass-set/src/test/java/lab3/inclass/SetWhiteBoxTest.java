package lab3.inclass;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("In-Class WBT - Set")
class SetWhiteBoxTest {

    @Test
    @DisplayName("TC1: IsInTheSet on empty set returns false")
    @Description("Covers while condition false on first check (nVS=0).")
    @Severity(SeverityLevel.CRITICAL)
    void isInTheSet_emptySet_returnsFalse() {
        Set set = new Set(5);
        assertFalse(set.IsInTheSet(10));
    }

    @Test
    @DisplayName("TC2: AddAValue adds first distinct value")
    @Description("Covers AddAValue path where value is absent and insertion is performed.")
    @Severity(SeverityLevel.CRITICAL)
    void addAValue_firstValue_returnsTrue() {
        Set set = new Set(5);
        assertTrue(set.AddAValue(3));
        assertTrue(set.IsInTheSet(3));
    }

    @Test
    @DisplayName("TC3: IsInTheSet finds value after loop iterations")
    @Description("Covers loop iterations before match and returns true.")
    @Severity(SeverityLevel.NORMAL)
    void isInTheSet_valuePresentLater_returnsTrue() {
        Set set = new Set(5);
        set.AddAValue(3);
        set.AddAValue(2);
        set.AddAValue(1);

        assertTrue(set.IsInTheSet(1));
    }

    @Test
    @DisplayName("TC4: IsInTheSet returns false when value missing")
    @Description("Covers loop exhausting all elements with no match.")
    @Severity(SeverityLevel.NORMAL)
    void isInTheSet_missingValue_returnsFalse() {
        Set set = new Set(5);
        set.AddAValue(3);
        set.AddAValue(2);
        set.AddAValue(1);

        assertFalse(set.IsInTheSet(7));
    }

    @Test
    @DisplayName("TC5: AddAValue rejects duplicate")
    @Description("Covers AddAValue branch when IsInTheSet(newVal) is true.")
    @Severity(SeverityLevel.CRITICAL)
    void addAValue_duplicate_returnsFalse() {
        Set set = new Set(5);
        assertTrue(set.AddAValue(4));
        assertFalse(set.AddAValue(4));
    }

    @Test
    @DisplayName("TC6: AddAValue rejects when capacity is full")
    @Description("Covers defensive capacity branch.")
    @Severity(SeverityLevel.MINOR)
    void addAValue_capacityExceeded_returnsFalse() {
        Set set = new Set(2);
        assertTrue(set.AddAValue(1));
        assertTrue(set.AddAValue(2));
        assertFalse(set.AddAValue(3));
    }
}

