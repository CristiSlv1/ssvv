# In-Class Problem - WBT Design (`Set`)

Target methods:

- `AddAValue(int newVal)`
- `IsInTheSet(int checkVal)`

Coverage criterion used:

- Statement + condition/decision coverage for the two target methods.

## Test cases

| ID | Inputs / Setup | Expected Result | Coverage Notes |
|---|---|---|---|
| TC1 | Empty set (`nVS=0`), call `IsInTheSet(10)` | `false` | While condition false at entry |
| TC2 | Empty set, call `AddAValue(3)` | `true`; value inserted | `AddAValue` true branch + insertion statement |
| TC3 | Set has `[3,2,1]`, call `IsInTheSet(1)` | `true` | While loop true for multiple iterations then exit on found |
| TC4 | Set has `[3,2,1]`, call `IsInTheSet(7)` | `false` | While loop exits because `i == nVS` |
| TC5 | Set has `[4]`, call `AddAValue(4)` | `false` | `AddAValue` duplicate-reject branch |
| TC6 | Capacity 2 set has `[1,2]`, call `AddAValue(3)` | `false` | Defensive full-capacity branch |

## Coverage mapping

- `IsInTheSet`:
  - while condition false at entry: TC1
  - while entered and exits on match: TC3
  - while entered and exits on bounds: TC4
- `AddAValue`:
  - duplicate value path: TC5
  - normal insert path: TC2
  - full capacity path: TC6

