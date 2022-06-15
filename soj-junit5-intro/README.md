
##### Cuprins
- [p01: @Test](#p01)
- [p02: @DisplayName](#p02)
- [p03: @TestMethodOrder](#p03)
    - [s1: alfabetic](#p03_s1)
    - [s2: @Order](#p03_s2)
- [p04: @Disabled](#p04)
- [p05: Testarea exceptiilor](#p05)
- [p06: @ParameterizedTest](#p06)
    - [s1: @CsvSource](#p06_s1)
    - [s2: @CsvFileSource](#p06_s2)
    - [s3: @MethodSource](#p06_s3)
- [p07: @BeforeEach, @BeforeAll](#p07)


## p01

Rulam primele noastre teste automate

Adnotari introduse: `@Test`

## p02

Vi se pare plictisitor numele implicit al testului? Se poate personaliza...

Adnotari introduse: `@DisplayName`


## p03

Cum fac sa rulez testele intr-o anumita ordine?


#### p03_s1

Ordonare alfabetica dupa numele metodelor de test

Adnotari introduse: `@TestMethodOrder`

#### p03_s2

Ordonare alfabetica dupa valoarea unei adnotari specifice

Adnotari introduse: `@Order`

## p04

Daca un test e necesar, dar pentru moment codul nu e pregatit pentru scenariul testat, marcati acest fapt, nu stergeti/commentati testul

Adnotari introduse: `@Disabled`


## p05

Si scenariile care genereaza exceptii trebuie sa fie testate


## p06

Cum fac sa execut aceeasi metoda de test pe un set de date de intrare?

#### p06_s1

Definirea unui set de date predefinit ce contine mai multi parametri, direct in metoda de test

Adnotari introduse: `@ParameterizedTest`, `@CsvSource`

#### p06_s2

Definirea unui set de date predefinit ce contine mai multi parametri, intr-un fisier

Adnotari introduse: `@CsvFileSource`

#### p06_s3

Citirea unui set de date predefinit ce contine mai multi parametri, dintr-o metoda dedicata

Adnotari introduse: `@MethodSource`


## p07

Modalitati de a configura valorile implicite pentru metodele de test

Adnotari introduse: `@BeforeAll`, `@BeforeEach`
