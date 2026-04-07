package lab3.takehome;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Take-Home WBT - GiveNextDate")
class GiveNextDateWhiteBoxTest {

    private String run(int m, int d, int y) {
        return new GiveNextDate(m, d, y).run();
    }

    @Test
    @DisplayName("TC1: Invalid day lower bound")
    @Description("day < 1 should be rejected by the global input guard.")
    @Severity(SeverityLevel.CRITICAL)
    void invalidDayLow() {
        assertEquals("Invalid Input Date", run(1, 0, 2020));
    }

    @Test
    @DisplayName("TC2: Invalid month upper bound")
    @Description("month > 12 should be rejected by the global input guard.")
    @Severity(SeverityLevel.CRITICAL)
    void invalidMonthHigh() {
        assertEquals("Invalid Input Date", run(13, 1, 2020));
    }

    @Test
    @DisplayName("TC3: Invalid year lower bound")
    @Description("year < 1801 should be rejected.")
    @Severity(SeverityLevel.CRITICAL)
    void invalidYearLow() {
        assertEquals("Invalid Input Date", run(1, 1, 1800));
    }
    @Test
    @DisplayName("TC4: Invalid year upper bound")
    @Description("year > 2021 should be rejected.")
    @Severity(SeverityLevel.CRITICAL)
    void invalidYearHigh() {
        assertEquals("Invalid Input Date", run(1, 1, 2022));
    }

    @Test
    @DisplayName("TC5: 31-day month standard increment")
    @Description("Covers day < 31 branch in a 31-day month.")
    @Severity(SeverityLevel.NORMAL)
    void thirtyOneDayMonthIncrement() {
        assertEquals("1/16/2020", run(1, 15, 2020));
    }

    @Test
    @DisplayName("TC6: 31-day month rollover")
    @Description("Covers day == 31 branch in a 31-day month.")
    @Severity(SeverityLevel.NORMAL)
    void thirtyOneDayMonthRollover() {
        assertEquals("2/1/2020", run(1, 31, 2020));
    }

    @Test
    @DisplayName("TC7: July rollover to August")
    @Description("Validates July as a 31-day month.")
    @Severity(SeverityLevel.CRITICAL)
    void julyRollover() {
        assertEquals("8/1/2020", run(7, 31, 2020));
    }

    @Test
    @DisplayName("TC8: Invalid day in 31-day month")
    @Description("Covers invalid day > 31 branch.")
    @Severity(SeverityLevel.NORMAL)
    void invalidDayInThirtyOneDayMonth() {
        assertEquals("Invalid Input Date", run(1, 32, 2020));
    }

    @Test
    @DisplayName("TC9: 30-day month standard increment")
    @Description("Covers day < 30 branch in a 30-day month.")
    @Severity(SeverityLevel.NORMAL)
    void thirtyDayMonthIncrement() {
        assertEquals("4/16/2020", run(4, 15, 2020));
    }

    @Test
    @DisplayName("TC10: 30-day month rollover")
    @Description("Covers day == 30 branch in a 30-day month.")
    @Severity(SeverityLevel.NORMAL)
    void thirtyDayMonthRollover() {
        assertEquals("5/1/2020", run(4, 30, 2020));
    }

    @Test
    @DisplayName("TC11: Invalid day in 30-day month")
    @Description("Covers invalid day > 30 branch.")
    @Severity(SeverityLevel.NORMAL)
    void invalidDayInThirtyDayMonth() {
        assertEquals("Invalid Input Date", run(4, 31, 2020));
    }

    @Test
    @DisplayName("TC12: December standard increment")
    @Description("Covers day < 31 branch in December.")
    @Severity(SeverityLevel.NORMAL)
    void decemberIncrement() {
        assertEquals("12/31/2020", run(12, 30, 2020));
    }

    @Test
    @DisplayName("TC13: December year rollover")
    @Description("Covers day == 31 in December with valid next year.")
    @Severity(SeverityLevel.CRITICAL)
    void decemberYearRollover() {
        assertEquals("1/1/2021", run(12, 31, 2020));
    }

    @Test
    @DisplayName("TC14: December upper year boundary")
    @Description("Covers Invalid Next Year branch for 12/31/2021.")
    @Severity(SeverityLevel.CRITICAL)
    void decemberInvalidNextYear() {
        assertEquals("Invalid Next Year", run(12, 31, 2021));
    }

    @Test
    @DisplayName("TC15: February non-leap standard increment")
    @Description("Covers February day < 28.")
    @Severity(SeverityLevel.NORMAL)
    void februaryNonLeapStandardIncrement() {
        assertEquals("2/28/2021", run(2, 27, 2021));
    }

    @Test
    @DisplayName("TC16: February non-leap day 28 to March 1")
    @Description("Covers day == 28 with non-leap year.")
    @Severity(SeverityLevel.CRITICAL)
    void februaryNonLeapDay28() {
        assertEquals("3/1/2021", run(2, 28, 2021));
    }

    @Test
    @DisplayName("TC17: February non-leap day 29 invalid")
    @Description("Covers day == 29 with non-leap year (invalid).")
    @Severity(SeverityLevel.CRITICAL)
    void februaryNonLeapDay29Invalid() {
        assertEquals("Invalid Input Date", run(2, 29, 2021));
    }

    @Test
    @DisplayName("TC18: February leap day 28 to 29")
    @Description("Covers day == 28 with leap year.")
    @Severity(SeverityLevel.CRITICAL)
    void februaryLeapDay28() {
        assertEquals("2/29/2020", run(2, 28, 2020));
    }

    @Test
    @DisplayName("TC19: February leap day 29 to March 1")
    @Description("Covers day == 29 with leap year.")
    @Severity(SeverityLevel.CRITICAL)
    void februaryLeapDay29() {
        assertEquals("3/1/2020", run(2, 29, 2020));
    }

    @Test
    @DisplayName("TC20: February invalid day > 29")
    @Description("Covers day > 29 invalid branch.")
    @Severity(SeverityLevel.NORMAL)
    void februaryInvalidDayAbove29() {
        assertEquals("Invalid Input Date", run(2, 30, 2020));
    }

    @Test
    @DisplayName("TC21: Century non-leap year (1900)")
    @Description("1900 is not leap year because divisible by 100 and not by 400.")
    @Severity(SeverityLevel.NORMAL)
    void centuryNonLeapYear1900() {
        assertEquals("3/1/1900", run(2, 28, 1900));
    }

    @Test
    @DisplayName("TC22: Century leap year (2000)")
    @Description("2000 is leap year because divisible by 400.")
    @Severity(SeverityLevel.NORMAL)
    void centuryLeapYear2000() {
        assertEquals("2/29/2000", run(2, 28, 2000));
    }
}
