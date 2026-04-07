# Lab 03 Solutions (In-Class + Take-Home)

This folder contains two independent Maven projects:

- `inclass-set` - White-box tests for `Set` (`AddAValue`, `IsInTheSet`)
- `takehome-nextdate` - White-box tests for `GiveNextDate`

Each project includes:

- source code in `src/main/java`
- JUnit 5 + Allure tests in `src/test/java`
- test design documentation in `docs/`

## Run locally

```bash
cd Lab03Solutions/inclass-set
mvn clean test

cd ../takehome-nextdate
mvn clean test
```

## Jenkins

Use `Jenkinsfile.lab3` from repository root as the pipeline script path.

