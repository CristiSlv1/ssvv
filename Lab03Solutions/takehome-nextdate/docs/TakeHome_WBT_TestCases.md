# Take-Home Problem - WBT Design (`GiveNextDate`)

Target method:

- `run()`

## Coverage strategy

- Statement coverage: all executable statements in `run()`
- Decision/condition coverage: every `if`/`else if` outcome covered (true and false)
- Path coverage (basis paths): representative independent paths listed below
- Loop coverage: not applicable (`run()` has no loops)

## CFG and Cyclomatic Complexity (CC)

Decision points in `run()` are 17, therefore:

- `CC = Decisions + 1 = 18`

Independent basis path set size is at least 18. The implemented tests cover these through distinct control-flow routes (invalid input, each month class, boundary transitions, leap/non-leap logic, and error exits).

## Representative basis paths (grouped)

1. Global invalid-input guard returns `"Invalid Input Date"`
2. 31-day month, `day < 31`
3. 31-day month, `day == 31`
4. 31-day month, `day > 31` invalid
5. 30-day month, `day < 30`
6. 30-day month, `day == 30`
7. 30-day month, `day > 30` invalid
8. December, `day < 31`
9. December, `day == 31`, `year < 2021`
10. December, `day == 31`, `year == 2021` -> `"Invalid Next Year"`
11. December, `day > 31` invalid
12. February, `day < 28`
13. February, `day == 28`, leap year
14. February, `day == 28`, non-leap year
15. February, `day == 29`, leap year
16. February, `day == 29`, non-leap year invalid
17. February, `day > 29` invalid
18. Leap-year helper branches: divisible by 100 and divisible by 400 variants

## Test cases

| ID | Input `(m,d,y)` | Expected | Coverage |
|---|---|---|---|
| TC1 | (1,0,2020) | Invalid Input Date | Global invalid guard |
| TC2 | (13,1,2020) | Invalid Input Date | Global invalid guard |
| TC3 | (1,1,1800) | Invalid Input Date | Global invalid guard |
| TC4 | (1,1,2022) | Invalid Input Date | Global invalid guard |
| TC5 | (1,15,2020) | 1/16/2020 | 31-day `<31` |
| TC6 | (1,31,2020) | 2/1/2020 | 31-day `==31` |
| TC7 | (7,31,2020) | 8/1/2020 | 31-day month classification |
| TC8 | (1,32,2020) | Invalid Input Date | 31-day `>31` |
| TC9 | (4,15,2020) | 4/16/2020 | 30-day `<30` |
| TC10 | (4,30,2020) | 5/1/2020 | 30-day `==30` |
| TC11 | (4,31,2020) | Invalid Input Date | 30-day `>30` |
| TC12 | (12,30,2020) | 12/31/2020 | December `<31` |
| TC13 | (12,31,2020) | 1/1/2021 | December year rollover |
| TC14 | (12,31,2021) | Invalid Next Year | December upper year bound |
| TC15 | (2,27,2021) | 2/28/2021 | February `<28` |
| TC16 | (2,28,2021) | 3/1/2021 | February `==28`, non-leap |
| TC17 | (2,29,2021) | Invalid Input Date | February `==29`, non-leap invalid |
| TC18 | (2,28,2020) | 2/29/2020 | February `==28`, leap |
| TC19 | (2,29,2020) | 3/1/2020 | February `==29`, leap |
| TC20 | (2,30,2020) | Invalid Input Date | February `>29` |
| TC21 | (2,28,1900) | 3/1/1900 | Century non-leap branch |
| TC22 | (2,28,2000) | 2/29/2000 | Century leap branch |

